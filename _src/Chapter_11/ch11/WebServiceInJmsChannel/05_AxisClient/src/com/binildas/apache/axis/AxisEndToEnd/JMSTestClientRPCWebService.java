package com.binildas.apache.axis.AxisEndToEnd;

public class JMSTestClientRPCWebService {

    public static void main(String args[]) throws Exception {

        org.apache.axis.client.Service axisServiceObj = new org.apache.axis.client.Service();
        org.apache.axis.client.Call axisCall = (org.apache.axis.client.Call) axisServiceObj.createCall();


        axisCall.setOperationName("hello");
        axisCall.addParameter("in0", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN );
        axisCall.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);

        org.apache.axis.client.Transport transport = new JMSTransportForAxis();
        axisCall.setTransport(transport);

        axisCall.setProperty("REQUEST_QUEUE", "queue/A");
        axisCall.setProperty("RESPONSE_QUEUE", "queue/B");

        String res = (String) axisCall.invoke(new Object[] {"Binil"});
        System.out.println("res: " + res);
    }
}
