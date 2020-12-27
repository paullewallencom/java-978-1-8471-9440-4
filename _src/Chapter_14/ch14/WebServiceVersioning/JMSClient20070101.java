
import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import java.io.InputStream;


public class JMSClient20070101 {

    private static final String REQUEST_FILE = "/SoapRequest20070101.xml";

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

		InputStream inputStream = JMSClient20061231.class.getClass().getResourceAsStream(REQUEST_FILE);
		int available = inputStream.available();
		byte[] bytes = new byte[available];
		inputStream.read(bytes);
		inputStream.close();
		String requestString = new String(bytes);

        System.out.println("----------------------------------------------");
        System.out.println("Sending request:\n" + requestString);
        System.out.println("----------------------------------------------");
        producer.send(session.createTextMessage(requestString));

        System.out.println("Request Send.");

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
