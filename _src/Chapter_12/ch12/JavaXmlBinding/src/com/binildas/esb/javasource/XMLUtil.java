
package com.binildas.esb.javasource;

import java.io.StringReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;

import javax.xml.transform.dom.DOMSource;
import java.io.StringWriter;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import org.w3c.dom.Node;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import javax.jbi.messaging.ExchangeStatus;
import javax.jbi.messaging.InOut;
import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.MessagingException;
import javax.jbi.messaging.NormalizedMessage;
import javax.jbi.messaging.MessageExchange.Role;
import javax.jbi.servicedesc.ServiceEndpoint;

public class XMLUtil{

    public static String retreiveSoapContent(Node node){

		String processedXML = null;
		InputStream inputStream = null;
		MessageFactory messageFactory = null;
		SOAPMessage soapMessage = null;
		SOAPPart part = null;
		SOAPEnvelope envelope = null;
		SOAPBody body = null;
		SOAPBodyElement bodyElement = null;
		Node contentNode = null;
		Iterator items = null;

		try {
			processedXML = node2XML(node);
			inputStream = new ByteArrayInputStream(processedXML.getBytes());

			messageFactory = MessageFactory.newInstance();
			soapMessage = messageFactory.createMessage(null, inputStream);
			part = soapMessage.getSOAPPart( );
			envelope = part.getEnvelope();
			body = envelope.getBody();

			contentNode = body.extractContentAsDocument();

			processedXML = node2XML(contentNode);

		} catch(Exception ex) {
			System.out.println("Exception! >>> " + ex.getMessage() );
			ex.printStackTrace();
		}
		return processedXML;
	}

	public static String node2XML(Node node) {
		String processedXML = null;
		try {
			// Transform the DOM tree into XML String
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			DOMSource dSource = new DOMSource( node );
			StringWriter sw = new StringWriter();
			StreamResult sr = new StreamResult( sw );
			transformer.transform( dSource, sr );
			StringWriter anotherSW = (StringWriter) sr.getWriter();
			StringBuffer sBuffer = anotherSW.getBuffer();
			processedXML = sBuffer.toString();

		} catch(Exception ex) {
			System.out.println("Exception! >>> " + ex.getMessage() );
			ex.printStackTrace();
		}
		return processedXML;
	}

	public static String formatStreamSource(StreamSource streamSource){

		InputStream inputStream = null;
		byte[] bytes = null;

		try{
			inputStream = streamSource.getInputStream();
			bytes = new byte[inputStream.available()];
			inputStream.read(bytes);
		} catch(Exception ex) {
			System.out.println("Exception! >>> " + ex.getMessage() );
			ex.printStackTrace();
		}

		return new String(bytes);
	}

}
