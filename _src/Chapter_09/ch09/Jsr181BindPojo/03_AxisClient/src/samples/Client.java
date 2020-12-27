
package samples;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.namespace.QName;

import com.binildas.esb.jsrpojo.PojoBindService;
import com.binildas.esb.jsrpojo.PojoBindServiceLocator;
import com.binildas.esb.jsrpojo.HelloServicePortType;

public class Client{

    private static String wsdlUrl = "http://localhost:8081/services/PojoBindService/main.wsdl";
    private static String namespaceURI = "http://binildas.com/esb/jsrpojo";
    private static String localPart = "PojoBindService";

    protected void executeClient(String[] args)throws Exception{

		log(" ********** Client.executeClient...");

		PojoBindService pojoBindService = null;
		HelloServicePortType helloServicePortType = null;

		if(args.length == 3){
			pojoBindService = new PojoBindServiceLocator(args[0], new QName(args[1], args[2]));
		}
		else{
			pojoBindService = new PojoBindServiceLocator(wsdlUrl, new QName(namespaceURI, localPart));
		}

		helloServicePortType = pojoBindService.getPojoBindService();

		log("Response From Server : " + helloServicePortType.hello("Binil"));

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