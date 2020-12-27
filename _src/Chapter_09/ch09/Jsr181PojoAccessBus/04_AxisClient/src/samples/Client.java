
package samples;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.namespace.QName;

import com.binildas.esb.jsrpojo.PojoWebService;
import com.binildas.esb.jsrpojo.PojoWebServiceLocator;
import com.binildas.esb.jsrpojo.BridgeServicePortType;

public class Client{

    private static String wsdlUrl = "http://localhost:8081/services/PojoService/main.wsdl";
    private static String namespaceURI = "http://binildas.com/esb/jsrpojo";
    private static String localPart = "BridgeHelloServiceBIService";

    protected void executeClient(String[] args)throws Exception{

		log(" ********** Client.executeClient...");

		PojoWebService pojoWebService = null;
		BridgeServicePortType bridgeServicePortType = null;

		if(args.length == 3){
			pojoWebService = new PojoWebServiceLocator(args[0], new QName(args[1], args[2]));
		}
		else{
			pojoWebService = new PojoWebServiceLocator(wsdlUrl, new QName(namespaceURI, localPart));
		}

		bridgeServicePortType = pojoWebService.getPojoWebServiceEP();

		log("Response From Server : " + bridgeServicePortType.broker("Binil"));

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