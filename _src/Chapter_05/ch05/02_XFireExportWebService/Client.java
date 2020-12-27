
import org.codehaus.xfire.*;
import org.codehaus.xfire.client.*;
import org.codehaus.xfire.service.*;
import org.codehaus.xfire.service.binding.*;

import java.net.*;

public class Client{

	private static String serviceUrl = "http://localhost:8080/HelloXFireExport/services/HelloService";

	public static void main(String[] args)throws Exception{

		log("Client.main : Start...");
		if(args.length > 0){
			serviceUrl = args[0];
		}
		Client client = new Client();
		log("Response from WEB SERVICE: " + client.callWebService("Sowmya"));
		log("Client.main : End.");
	}

	public String callWebService(String name)throws Exception{

		log("Client.main : Start...");
		//Create a metadata of the service
		Service serviceModel = new ObjectServiceFactory().create(IHello.class);
		log("callSoapServiceLocal(): got service model." );

		//Create a proxy for the deployed service
		XFire xfire = XFireFactory.newInstance().getXFire();
		XFireProxyFactory factory = new XFireProxyFactory(xfire);

		IHello client = null;
		try {
			client = (IHello) factory.create(serviceModel, serviceUrl);
		} catch (MalformedURLException e) {
			log("WsClient.callWebService(): EXCEPTION: " + e.toString());
		}

		//Invoke the service
		String serviceResponse = "";
		try {
			serviceResponse = client.sayHello(name);
		}
		catch (Exception e){
			log("Client.callWebService(): EXCEPTION: " + e.toString());
			serviceResponse = e.toString();
		}
		log("Client.main : End. status = " + serviceResponse);

		//Return the response
		return serviceResponse;
	}

	public static void log(Object msg){
		System.out.println(msg.toString());
	}

}
