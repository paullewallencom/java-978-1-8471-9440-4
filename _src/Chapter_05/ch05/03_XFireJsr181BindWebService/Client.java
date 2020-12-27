
import org.codehaus.xfire.*;
import org.codehaus.xfire.client.*;
import org.codehaus.xfire.service.*;
import org.codehaus.xfire.service.binding.*;

import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import java.net.MalformedURLException;

import java.net.*;

public class Client{

	private static String serviceUrl = "http://localhost:8080/XFireJsr181/services/OrderService";

   public static void main(String[] args)throws Exception{

      log("Client.main : Start...");
		if(args.length > 0){
			serviceUrl = args[0];
		}
      Client client = new Client();
      //log("Response from WEB SERVICE: " + client.callWebService("Test"));
      client.callWebService("2001");
      log("Client.main : End.");

   }

	public void callWebService(String orderId)throws Exception{

		log("Client.callWebService() : Start...");
		//Create a metadata of the service
		Service serviceModel = new ObjectServiceFactory().create(IOrder.class);
		log("Client.callWebService(): got service model." );

		//Create a proxy for the deployed service
		XFire xfire = XFireFactory.newInstance().getXFire();
		XFireProxyFactory factory = new XFireProxyFactory(xfire);

		IOrder client = null;
		try {
			client = (IOrder) factory.create(serviceModel, serviceUrl);
		} catch (MalformedURLException e) {
			log("Client.callWebService(): EXCEPTION: " + e.toString());
		}

		//Invoke the service
		PurchaseOrderType serviceResponse = null;
		try {
			serviceResponse = client.getPurchaseOrderType(orderId);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		log("Client.callWebService() : End. serviceResponse : " + serviceResponse);

	}


    public static void log(Object msg){
       System.out.println(msg.toString());
    }

 }
