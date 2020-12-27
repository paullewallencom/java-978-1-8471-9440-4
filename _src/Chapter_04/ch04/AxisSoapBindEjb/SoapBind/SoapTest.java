
package samples.ejb;

import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.soap.*;
import org.apache.soap.rpc.*;

public class SoapTest {

	public static void main (String[] args) throws Exception{

		if (args.length != 1 ) {
			log("Usage: java " + SoapTest.class.getName () + " SOAP-Router-URL");
			System.exit (1);
		}

		URL url = new URL (args[0]);
		Call call = new Call ();
		call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
		call.setTargetObjectURI ("urn:ejbhello");
		call.setMethodName ("hello");
		Vector params = new Vector ();
		params.addElement (new Parameter("phrase", String.class, "what's your name?", null));
		call.setParams (params);

		Response resp = call.invoke (url, "" );

		Fault fault = null;
		if(resp.generatedFault ()){
			fault = resp.getFault ();
			log("Fault occured: " + fault);
		}else{
			Parameter result = resp.getReturnValue();
			log( "Done. result : " + result.getValue());
		}
	}

	private static void log(Object msg){
		System.out.println(msg.toString());
	}
}
