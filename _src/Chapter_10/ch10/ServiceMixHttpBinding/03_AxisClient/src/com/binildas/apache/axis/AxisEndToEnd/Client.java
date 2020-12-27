
package com.binildas.apache.axis.AxisEndToEnd;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.namespace.QName;

import com.binildas.apache.axis.AxisEndToEnd.MyConsumerService;
import com.binildas.apache.axis.AxisEndToEnd.MyConsumerServiceLocator;
import com.binildas.apache.axis.AxisEndToEnd.IHelloWeb;

public class Client{

    private static String wsdlUrl = "http://localhost:8081/services/HelloWebService/main.wsdl";
    private static String namespaceURI = "http://AxisEndToEnd.axis.apache.binildas.com";
    private static String localPart = "MyConsumerService";

    protected void executeClient(String[] args)throws Exception{

		log(" ********** Client.executeClient...");

		MyConsumerService myConsumerService = null;
		IHelloWeb iHelloWeb = null;

		if(args.length == 3){
			myConsumerService = new MyConsumerServiceLocator(args[0], new QName(args[1], args[2]));
		}
		else{
			myConsumerService = new MyConsumerServiceLocator(wsdlUrl, new QName(namespaceURI, localPart));
		}

		iHelloWeb = myConsumerService.getHelloWebService();

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