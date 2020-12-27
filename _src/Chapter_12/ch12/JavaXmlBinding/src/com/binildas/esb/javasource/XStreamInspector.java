package com.binildas.esb.javasource;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.MessagingException;
import javax.jbi.messaging.NormalizedMessage;
import javax.jbi.messaging.InOut;

import org.apache.servicemix.components.util.TransformComponentSupport;
import org.apache.servicemix.jbi.jaxp.StringSource;

import javax.xml.namespace.QName;

public class XStreamInspector extends TransformComponentSupport{

	private String name;

	public XStreamInspector(){
		log("XStreamInspector.XStreamInspector()...");
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	protected boolean transform(MessageExchange exchange, NormalizedMessage in, NormalizedMessage out) throws MessagingException {

		System.out.println("XStreamInspector(" + name + ").transform01. exchange.getService() = " + exchange.getService());

        NormalizedMessage copyMessage = exchange.createMessage();
        getMessageTransformer().transform(exchange, in, copyMessage);
        Source content = copyMessage.getContent();
        String contentString = null;
		if (content instanceof DOMSource){
			contentString = XMLUtil.node2XML(((DOMSource) content).getNode());
        	System.out.println("XStreamInspector(" + name + ").transform02. contentString = " + contentString);
		}
		out.setContent(new StringSource(contentString));
		System.out.println("XStreamInspector(" + name + ").transform03. End");

        return true;
	}

    public static void log(Object msg){
       System.out.println(msg.toString());
    }

}