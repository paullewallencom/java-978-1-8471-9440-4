package com.binildas.esb.javasource;

import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.MessagingException;
import javax.jbi.messaging.NormalizedMessage;
import javax.jbi.messaging.InOut;

import org.apache.servicemix.components.util.TransformComponentSupport;
import org.apache.servicemix.jbi.jaxp.StringSource;

import org.apache.servicemix.JavaSource;
import org.apache.servicemix.components.util.xstream.XStreamSource;
import com.thoughtworks.xstream.XStream;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import java.io.InputStream;
import java.io.IOException;

public class HttpInterceptor extends TransformComponentSupport{

	private String name;
	private String namespaceURI;
	private String localPart;

	public HttpInterceptor(){
		log("HttpInterceptor.HttpInterceptor()...");
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public void setNamespaceURI(String namespaceURI){
		this.namespaceURI = namespaceURI;
	}
	public String getNamespaceURI(){
		return namespaceURI;
	}

	public void setLocalPart(String localPart){
		this.localPart = localPart;
	}
	public String getLocalPart(){
		return localPart;
	}

	protected boolean transform(MessageExchange exchange, NormalizedMessage in, NormalizedMessage out) throws MessagingException {

		System.out.println("HttpInterceptor(" + name + ").transform01. exchange.getService() = " + exchange.getService());

        XStream xStream = null;

        String contentString = null;
        ServiceParamTO payLoad = null;
        JavaSource javaSource = null;

        QName service = null;
        InOut inOut = null;
        NormalizedMessage normalizedMessageIn = null;

        NormalizedMessage normalizedMessageOut = null;
        NormalizedMessage copyReturnMessage = null;
        Source contentReturn = null;
        InputStream inputStream = null;
        byte[] bytes = null;
        int available = 0;
        String contentReturnString = null;

        NormalizedMessage copyMessage = exchange.createMessage();
        getMessageTransformer().transform(exchange, in, copyMessage);
        Source content = copyMessage.getContent();

		if (content instanceof DOMSource){
			contentString = XMLUtil.retreiveSoapContent(((DOMSource) content).getNode());
        	System.out.println("HttpInterceptor(" + name + ").transform02. contentString = " + contentString);
        	payLoad = (ServiceParamTO) XStreamUtil.xmlToObject(contentString);

			xStream = new XStream();
			xStream.alias("ServiceParamTO", ServiceParamTO.class);
			xStream.alias("CustomerTO", CustomerTO.class);
			xStream.alias("CreditCardTO", CreditCardTO.class);
			xStream.alias("AddressTO", AddressTO.class);

        	javaSource = new XStreamSource(payLoad, xStream);

			service = new QName(namespaceURI, localPart);
			inOut = createInOutExchange(service, null, null);
			normalizedMessageIn = inOut.createMessage();
			normalizedMessageIn.setContent(javaSource);
			inOut.setInMessage(normalizedMessageIn);

			sendSync(inOut);

			normalizedMessageOut = inOut.getOutMessage();
			copyReturnMessage = exchange.createMessage();
			getMessageTransformer().transform(exchange, normalizedMessageOut, copyReturnMessage);
			contentReturn = copyReturnMessage.getContent();

			if (contentReturn instanceof StringSource){
				try{
					inputStream = ((StringSource) contentReturn).getInputStream();
					available = inputStream.available();
					bytes = new byte[available];
					inputStream.read(bytes);
				}
				catch(IOException ioException){
					throw new MessagingException(ioException);
				}
				contentReturnString = new String(bytes);
				System.out.println("HttpInterceptor(" + name + ").transform03. contentReturnString = " + contentReturnString);
				out.setContent(contentReturn);
				System.out.println("HttpInterceptor(" + name + ").transform04. contentReturnString = " + contentReturnString);
			}

			System.out.println("HttpInterceptor(" + name + ").transform05. End");
		}

        return true;
	}

    public static void log(Object msg){
       System.out.println(msg.toString());
    }

}