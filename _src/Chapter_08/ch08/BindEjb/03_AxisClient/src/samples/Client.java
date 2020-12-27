
package samples;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.namespace.QName;

import com.binildas.esb.bindejb.HelloServiceBIService;
import com.binildas.esb.bindejb.HelloServiceBIServiceLocator;
import com.binildas.esb.bindejb.JsrEjbEPPortType;

public class Client{

    private static String wsdlUrl = "http://localhost:8192/Services/HelloWebService/main.wsdl";
    private static String namespaceURI = "http://binildas.com/esb/bindejb";
    private static String localPart = "HelloServiceBIService";

    protected void executeClient(String[] args)throws Exception{

		log(" ********** Client.executeClient...");

		HelloServiceBIService helloServiceBIService = null;
		JsrEjbEPPortType jsrEjbEPPortType = null;

		if(args.length == 3){
			helloServiceBIService = new HelloServiceBIServiceLocator(args[0], new QName(args[1], args[2]));
		}
		else{
			helloServiceBIService = new HelloServiceBIServiceLocator(wsdlUrl, new QName(namespaceURI, localPart));
		}

		jsrEjbEPPortType = helloServiceBIService.getHelloServiceBI();

		log("Response From Server : " + jsrEjbEPPortType.hello("Binil"));

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