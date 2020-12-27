package com.binildas.esb.customcomponent;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.MessagingException;
import javax.jbi.messaging.NormalizedMessage;
import javax.jbi.messaging.InOut;

import org.apache.servicemix.MessageExchangeListener;
import org.apache.servicemix.components.util.TransformComponentSupport;
import org.apache.servicemix.jbi.jaxp.StringSource;

public class HttpInterceptor extends TransformComponentSupport{

	public HttpInterceptor(){
		log("HttpInterceptor.HttpInterceptor()...");
	}

	protected boolean transform(MessageExchange exchange, NormalizedMessage in, NormalizedMessage out) throws MessagingException {

		System.out.println("HttpInterceptor.transform01. exchange.getService() = " + exchange.getService());

        NormalizedMessage copyMessage = exchange.createMessage();
        getMessageTransformer().transform(exchange, in, copyMessage);
        Source content = copyMessage.getContent();
        System.out.println("HttpInterceptor.transform02. content = " + content);
        String contentString = null;
		if (content instanceof DOMSource){
			contentString = XMLUtil.node2XML(((DOMSource) content).getNode());
        	System.out.println("HttpInterceptor.transform03. contentString = " + contentString);
		}

		out.setContent(new StringSource("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Response>Response From Server</Response>"));

        return true;
	}

    public static void log(Object msg){
       System.out.println(msg.toString());
    }

}