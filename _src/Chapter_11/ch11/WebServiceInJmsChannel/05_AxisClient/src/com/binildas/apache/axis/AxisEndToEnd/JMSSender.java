
package com.binildas.apache.axis.AxisEndToEnd;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.command.ActiveMQQueue;

public class JMSSender extends org.apache.axis.handlers.BasicHandler{

	public void invoke(org.apache.axis.MessageContext msgContext) throws org.apache.axis.AxisFault{

		try{
			System.out.println("inside JMSSender");

        	ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

			Object requestDestination = msgContext.getProperty("REQUEST_QUEUE");
			Object responseDestination = msgContext.getProperty("RESPONSE_QUEUE");
			System.out.println("requestDestination : " + requestDestination + "; responseDestination : " + responseDestination);

			ActiveMQQueue pubTopic = new ActiveMQQueue((String) requestDestination);
			ActiveMQQueue subTopic = new ActiveMQQueue((String) responseDestination);

			System.out.println("Connecting to JMS server.");
			Connection connection = factory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(pubTopic);
			MessageConsumer consumer = session.createConsumer(subTopic);
			connection.start();

			String reqSOAPMsgString = msgContext.getRequestMessage().getSOAPPartAsString();

			System.out.println("Sending request: " + reqSOAPMsgString);
			producer.send(session.createTextMessage(reqSOAPMsgString));
			TextMessage m = (TextMessage) consumer.receive(1000*10);
			String respMessageStr = null;

			if( m == null ) {
				System.out.println("Response timed out.");
			} else {
				respMessageStr = m.getText();
				System.out.println("Response was : " + respMessageStr);
			}
			System.out.println("Closing.");
			connection.close();

			org.apache.axis.Message respSoapMessage = new org.apache.axis.Message(respMessageStr);
			msgContext.setResponseMessage(respSoapMessage);
		} catch (Exception e) {
			throw new org.apache.axis.AxisFault("failedSend", e);
		}
   }
}