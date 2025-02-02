package com.binildas.esb.servicemix.serviceassembly.voipservice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.servicemix.components.util.TransformComponentSupport;
import org.apache.servicemix.components.util.ComponentSupport;
import org.apache.servicemix.MessageExchangeListener;

import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.MessagingException;
import javax.jbi.messaging.NormalizedMessage;
import javax.jbi.messaging.InOut;
import javax.jbi.messaging.ExchangeStatus;
import javax.jbi.messaging.MessageExchange.Role;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;

import java.util.Map;
import java.util.Iterator;

import javax.xml.namespace.QName;

public class AddressValidationService extends TransformComponentSupport{

    private static final Log log = LogFactory.getLog(AddressValidationService.class);

	private String name;

	public void setName(String name){
		this.name = name;
	}

    protected boolean transform(MessageExchange exchange, NormalizedMessage in, NormalizedMessage out) throws MessagingException {

        String correlationId = (String) exchange.getProperty(Constants.CORRELATION_ID_KEY);
        System.out.println("AddressValidationService.transform. correlationId              : " + correlationId);

        Source content = in.getContent();
        String contentString = null;
        AddressTO addressTO = null;

		if(content instanceof StreamSource){
			contentString = XMLUtil.formatStreamSource((StreamSource) content);
			addressTO = (AddressTO) XStreamUtil.xmlToObject(contentString);
		}
		else{
			log.debug("AddressValidationService-content.getClass() : " + content.getClass() + " ; content : " + content);
		}

        out.setProperty(Constants.ADDRESS_VALIDATED_KEY, Boolean.TRUE);
        return true;
    }
}
