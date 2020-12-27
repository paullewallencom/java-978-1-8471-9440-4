
package com.binildas.esb.servicemix.ws.version20070101;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.namespace.QName;

public class Client{

    private static String wsdlUrl = "http://localhost:8080/AxisEndToEnd/services/HelloWebService?WSDL";
    private static String namespaceURI = "http://AxisEndToEnd.axis.apache.binildas.com";
    private static String localPart = "IHelloWebService";

    protected void executeClient(String[] args)throws Exception{

		log(" ********** Client.executeClient...");

		IHelloWebService iHelloWebService = null;
		IHelloWeb iHelloWeb = null;

		if(args.length == 3){
			iHelloWebService = new IHelloWebServiceLocator(args[0], new QName(args[1], args[2]));
		}
		else{
			iHelloWebService = new IHelloWebServiceLocator(wsdlUrl, new QName(namespaceURI, localPart));
		}

		iHelloWeb = iHelloWebService.getHelloWebService20070101();

		log("Response From Server : " + iHelloWeb.hello("Binil"));

	}

    public static void log(Object msg){
       System.out.println(msg.toString());
    }

    public static void main(String[] args)throws Exception{

		log(" ********** Client.main-Start...");

		Client client = new Client();
		client.executeClient(args);

		log(" ********** Client.main-Done.");
	}

}