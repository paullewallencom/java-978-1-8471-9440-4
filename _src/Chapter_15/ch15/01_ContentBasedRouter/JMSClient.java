
import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;


public class JMSClient {

	private static final String MESSAGE_1 = "<hello id='1' />";
	private static final String MESSAGE_2 = "<hello id='2' />";
	private static final String MESSAGE_3 = "<hello id='3' />";
	private static final String MESSAGE_4 = "<hello id='4' />";
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

		synchronized(Thread.currentThread()){
			System.out.println("Waiting " + WAIT_TIME + " millis before next message...");
			Thread.currentThread().wait(WAIT_TIME);
		}

        System.out.println("Sending request: " + MESSAGE_2);
        producer.send(session.createTextMessage(MESSAGE_2));

		synchronized(Thread.currentThread()){
			System.out.println("Waiting " + WAIT_TIME + " millis before next message...");
			Thread.currentThread().wait(WAIT_TIME);
		}

        System.out.println("Sending request: " + MESSAGE_3);
        producer.send(session.createTextMessage(MESSAGE_3));

		synchronized(Thread.currentThread()){
			System.out.println("Waiting " + WAIT_TIME + " millis before next message...");
			Thread.currentThread().wait(WAIT_TIME);
		}

        System.out.println("Sending request: " + MESSAGE_4);
        producer.send(session.createTextMessage(MESSAGE_4));

        System.out.println("Closing.");
        connection.close();
    }
}
