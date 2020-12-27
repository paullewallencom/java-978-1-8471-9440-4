
package com.binildas.esb.servicemix.serviceassembly.voipservice;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.dom.DOMSource;
import javax.xml.namespace.QName;

import javax.jbi.messaging.ExchangeStatus;
import javax.jbi.messaging.InOut;
import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.MessagingException;
import javax.jbi.messaging.NormalizedMessage;
import javax.jbi.messaging.MessageExchange.Role;
import javax.jbi.servicedesc.ServiceEndpoint;

import org.apache.servicemix.jbi.jaxp.StringSource;
import org.apache.servicemix.jbi.container.JBIContainer;
import org.apache.servicemix.MessageExchangeListener;
import org.apache.servicemix.components.util.ComponentSupport;
import org.apache.servicemix.jbi.NoInMessageAvailableException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SyncVoipBroker extends ComponentSupport implements MessageExchangeListener{

    private Map aggregations = Collections.synchronizedMap(new HashMap());

	private JBIContainer container;

	private String name;
	private String addressNamespaceURI;
	private String addressLocalPart;
	private String creditGatewayNamespaceURI;
	private String creditGatewayLocalPart;

	private Object payLoad;
	private boolean creditVetoed;
	private volatile int stack = 0;

	private Log log = LogFactory.getLog(SyncVoipBroker.class.getPackage().getName());


	public SyncVoipBroker(){
		System.out.println("SyncVoipBroker.SyncVoipBroker()...");
	}

	public SyncVoipBroker(JBIContainer container){

		System.out.println("SyncVoipBroker.SyncVoipBroker(JBIContainer)...");
		this.container = container;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public void setAddressNamespaceURI(String addressNamespaceURI){
		this.addressNamespaceURI = addressNamespaceURI;
	}
	public void setAddressLocalPart(String addressLocalPart){
		this.addressLocalPart = addressLocalPart;
	}

	public void setCreditGatewayNamespaceURI(String creditGatewayNamespaceURI){
		this.creditGatewayNamespaceURI = creditGatewayNamespaceURI;
	}
	public void setCreditGatewayLocalPart(String creditGatewayLocalPart){
		this.creditGatewayLocalPart = creditGatewayLocalPart;
	}


	public void onMessageExchange(MessageExchange exchange)throws MessagingException{

		System.out.println("SyncVoipBroker.onMessageExchange. ExchangeId                   :X: " + exchange.getExchangeId());
		ServiceEndpoint serviceEndpoint = null;

		if (exchange.getStatus() == ExchangeStatus.DONE){
			System.out.println("SyncVoipBroker.onMessageExchange. ExchangeStatus.DONE");
			dispose();
			return;
		}
		if (exchange.getStatus() == ExchangeStatus.ERROR){
			System.out.println("SyncVoipBroker.onMessageExchange. ExchangeStatus.ERROR");
			return;
		}

		if (exchange.getRole() == Role.PROVIDER){
			System.out.println("SyncVoipBroker.onMessageExchange. Role.PROVIDER");
			processInputRequest(exchange);
		}
		else{

			System.out.println("SyncVoipBroker.onMessageExchange. Role.CONSUMER");
            serviceEndpoint = exchange.getEndpoint();

            if (serviceEndpoint.getServiceName().getLocalPart().equals(addressLocalPart)) {
                processAddressValidationResponse(exchange);
            } else if (serviceEndpoint.getServiceName().getLocalPart().equals(creditGatewayLocalPart)) {
                processCreditGatewayResponse(exchange);
            } else {
                processServiceRequest(exchange);
            }

		}
	}

    private void processInputRequest(MessageExchange exchange) throws MessagingException {

		NormalizedMessage copyMessage = exchange.createMessage();
		NormalizedMessage inNormalizedMessage = exchange.getMessage("in");
        getMessageTransformer().transform(exchange, inNormalizedMessage, copyMessage);
        Source content = copyMessage.getContent();

        String contentString = null;
		if (content instanceof DOMSource){
			contentString = XMLUtil.retreiveSoapContent(((DOMSource) content).getNode());
			payLoad = XStreamUtil.xmlToObject(contentString);//Cache it here
		}

		CustomerTO customerTO = ((ServiceParamTO) payLoad).getCustomer();
		AddressTO addressTO = customerTO.getAddress();
		String xmlAddress = XStreamUtil.objectToXml(addressTO);
		Source addressSource = new StreamSource(new ByteArrayInputStream(xmlAddress.getBytes()));

        String correlationId = null;
        if (exchange.getStatus() == ExchangeStatus.ACTIVE) {

            correlationId = exchange.getExchangeId();
            aggregations.put(correlationId, exchange);
            InOut inout = createInOutExchange(new QName(addressNamespaceURI, addressLocalPart), null, null);
            inout.setProperty(Constants.CORRELATION_ID_KEY, correlationId);
            NormalizedMessage msg = inout.createMessage();
            msg.setContent(addressSource);
            inout.setInMessage(msg);
            send(inout);
        }
		System.out.println("SyncVoipBroker.processInputRequest. correlationId              : " + correlationId);
    }

    private void processAddressValidationResponse(MessageExchange exchange) throws MessagingException {

        String correlationId = (String) getProperty(exchange, Constants.CORRELATION_ID_KEY);
        System.out.println("SyncVoipBroker.processAddressValidationResponse. correlationId : " + correlationId);
        boolean isAaddressValidated = ((Boolean) getOutProperty(exchange, Constants.ADDRESS_VALIDATED_KEY)).booleanValue();
		MessageExchange rootExchange = null;

        if(isAaddressValidated){

			InOut inout = createInOutExchange(new QName(creditGatewayNamespaceURI, creditGatewayLocalPart), null, null);
			inout.setProperty(Constants.CORRELATION_ID_KEY, correlationId);
			NormalizedMessage msg = inout.createMessage();
			inout.setInMessage(msg);
			send(inout);
		}
		else{
			rootExchange = (MessageExchange) aggregations.get(correlationId);
			NormalizedMessage response = rootExchange.createMessage();
			response.setContent(new StringSource("<AddressNotValidated/>"));
			rootExchange.setMessage(response, "out");
			send(rootExchange);
			aggregations.remove(correlationId);
		}
		done(exchange);
    }

    private void processCreditGatewayResponse(MessageExchange exchange) throws MessagingException {


        String correlationId = (String) getProperty(exchange, Constants.CORRELATION_ID_KEY);
        System.out.println("SyncVoipBroker.processCreditGatewayResponse. correlationId     : " + correlationId);
        QName[] recipients = (QName[]) getOutProperty(exchange, Constants.RECIPIENTS_KEY);
		CreditCardTO creditCardTO = ((ServiceParamTO) payLoad).getCreditCard();
		String xmlCreditCard = XStreamUtil.objectToXml(creditCardTO);
		Source creditCardSource = null;

        InOut inout = null;
        NormalizedMessage msg = null;
        for(int qNames = 0; qNames < recipients.length; qNames++) {
            inout = createInOutExchange(recipients[qNames], null, null);
            inout.setProperty(Constants.CORRELATION_ID_KEY, correlationId);
            msg = inout.createMessage();
            creditCardSource = new StreamSource(new ByteArrayInputStream(xmlCreditCard.getBytes()));
            msg.setContent(creditCardSource);
            inout.setInMessage(msg);
            stack++;
            send(inout);
        }
        done(exchange);
    }

    private void processServiceRequest(MessageExchange exchange) throws MessagingException {

        String correlationId = (String) getProperty(exchange, Constants.CORRELATION_ID_KEY);
        System.out.println("SyncVoipBroker.processServiceRequest. correlationId            : " + correlationId);
        Boolean creditauthorized = (Boolean) getOutProperty(exchange, Constants.CREDIT_AUTHORIZED_KEY);
        Boolean goodhistory = (Boolean) getOutProperty(exchange, Constants.GOOD_HISTORY_KEY);
        MessageExchange rootExchange = (MessageExchange) aggregations.get(correlationId);
        done(exchange);
        stack--;

        if	(		((creditauthorized != null) && !(creditauthorized.equals(Boolean.TRUE))) ||
        			((goodhistory != null) && !(goodhistory.equals(Boolean.TRUE)))
        	){
			creditVetoed = true;
			System.out.println("SyncVoipBroker.processServiceRequest - creditVetoed : " + creditVetoed);
		}

		if(0 == stack){
			NormalizedMessage response = rootExchange.createMessage();
			if(creditVetoed){
				response.setContent(new StringSource("<ServiceNotProvisioned/>"));
			}
			else{
				response.setContent(new StringSource("<ServiceProvisioned/>"));
			}
			rootExchange.setMessage(response, "out");
			send(rootExchange);
			aggregations.remove(correlationId);
		}
    }

    private void dispose(){
		payLoad = null;
	}

    protected Object getProperty(MessageExchange me, String name) {
        return me.getProperty(name);
    }

    protected Object getOutProperty(MessageExchange me, String name) {
        return me.getMessage("out").getProperty(name);
    }
}
