
import org.codehaus.xfire.*;
import org.codehaus.xfire.client.*;
import org.codehaus.xfire.service.*;
import org.codehaus.xfire.service.binding.*;

import examples.webservices.basic.statelessSession.HelloWorldBI;

import java.net.*;

public class Client{

	private static String serviceUrl = "http://localhost:8080/XFireBindEjb/services/InvokeService";

	public static void main(String[] args)throws Exception{

		log("Client.main : Start...");
		if(args.length > 0){
			serviceUrl = args[0];
		}
		Client client = new Client();
		log("Response from WEB SERVICE: " + client.callWebService());
		log("Client.main : End.");

	}

    public String callWebService()
        throws MalformedURLException, Exception {

        //Create a metadata of the service
        Service serviceModel = new ObjectServiceFactory().create(HelloWorldBI.class);
        log("Client.callWebService(): got service model." );

        //Create a proxy for the deployed service
        XFire xfire = XFireFactory.newInstance().getXFire();
        XFireProxyFactory factory = new XFireProxyFactory(xfire);

        HelloWorldBI client = null;
        try {
            client = (HelloWorldBI) factory.create(serviceModel, serviceUrl);
        } catch (MalformedURLException e) {
            log("Client.callWebService(): EXCEPTION: " + e.toString());
        }

        //Invoke the service
        String serviceResponse = "";
        try {
            serviceResponse = client.sayHello(1, "Binil");
       } catch (Exception e){
            log("Client.callWebService(): EXCEPTION: " + e.toString());
            serviceResponse = e.toString();
        }

        log("Client.callWebService(): status:" + serviceResponse);

        //Return the response
        return serviceResponse;
    }

    public static void log(Object msg){
       System.out.println(msg.toString());
    }

 }
