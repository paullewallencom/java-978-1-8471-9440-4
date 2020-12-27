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

import java.util.Map;
import java.util.Iterator;

import javax.xml.namespace.QName;

public class CreditGateway extends TransformComponentSupport{

    private static final Log log = LogFactory.getLog(CreditGateway.class);

	private String name;
	private Map endPoints;

	public void setName(String name){
		this.name = name;
	}
	public void setEndPoints(Map endPoints){
		this.endPoints = endPoints;
	}

    protected boolean transform(MessageExchange exchange, NormalizedMessage in, NormalizedMessage out) throws MessagingException {

        String correlationId = (String) exchange.getProperty(Constants.CORRELATION_ID_KEY);
        System.out.println("CreditGateway.transform. correlationId                         : " + correlationId);

        out.setProperty(Constants.RECIPIENTS_KEY, getRecipients());
        return true;
    }

    private QName[] getRecipients(){

		QName[] recipients = new QName[endPoints.size()];
		String theNamespaceURI = null;
		String theLocalPart = null;
		int times = 0;
		for(Iterator iterator = endPoints.keySet().iterator(); iterator.hasNext();){
			theLocalPart = (String) iterator.next();
			theNamespaceURI = (String) endPoints.get(theLocalPart);
			recipients[times++] = new QName(theNamespaceURI, theLocalPart);
		}
		return recipients;
	}

    protected Object getProperty(MessageExchange me, String name) {
        return me.getProperty(name);
    }
}
