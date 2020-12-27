
package com.binildas.apache.axis.AxisEndToEnd;

import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;


public class JMSClient {

	public static String MESSAGE_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><ns1:hello soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"http://AxisEndToEnd.axis.apache.binildas.com\"><in0 xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">Binil</in0></ns1:hello></soapenv:Body></soapenv:Envelope>";
	private static final long WAIT_TIME = 5 * 1000L;

    public static void main(String[] args) throws Exception {

        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        ActiveMQQueue pubTopic = new ActiveMQQueue("queue/A");
        ActiveMQQueue subTopic = new ActiveMQQueue("queue/B");

        System.out.println("Connecting to JMS server.");
        Connection connection = factory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(pubTopic);
        MessageConsumer consumer = session.createConsumer(subTopic);
        connection.start();

        System.out.println("Sending request: " + MESSAGE_1);
        producer.send(session.createTextMessage(MESSAGE_1));

        TextMessage textMessage = (TextMessage) consumer.receive(1000 * 10);
        if(textMessage == null){
            System.out.println("Response timed out.");
        }else{
            System.out.println("Response was: " + textMessage.getText());
        }

        System.out.println("Closing.");
        connection.close();
    }
}
