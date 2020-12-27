package com.binildas.apache.axis.AxisEndToEnd;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.utils.Options;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;

public class TestClient {

	public static String msg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><ns1:hello soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"http://AxisEndToEnd.axis.apache.binildas.com\"><in0 xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">Binil</in0></ns1:hello></soapenv:Body></soapenv:Envelope>";

    public static String doTest (String args[], String op) throws Exception {
      Options      opts    = new Options( args );
      String       url     = args[0];
      String       action  = "HelloWebService" ;
      action = args[1];

      if (op != null) action = op;


      InputStream   input   = new ByteArrayInputStream(msg.getBytes());
      Service       service = new Service();
      Call          call    = (Call) service.createCall();
      SOAPEnvelope  env     = new SOAPEnvelope(input);

      call.setTargetEndpointAddress( new URL(url) );
      if (action != null) {
          call.setUseSOAPAction( true );
          call.setSOAPActionURI( action );
      }

      System.out.println( "url : " + url );
      System.out.println( "Request:\n" + msg );

      env = call.invoke( env );

      System.out.println( "Response:\n" + env.toString() );
      return( env.toString() );
    }

  public static void main(String args[]) throws Exception{
    doTest(args, null);
  }
  public static void mainWithService(String args[], String service) throws Exception{
    doTest(args, service);
  }
}
