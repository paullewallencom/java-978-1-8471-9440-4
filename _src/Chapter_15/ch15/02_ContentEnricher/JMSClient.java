
import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;


public class JMSClient {

	public static String MESSAGE_1 = "<?xml version='1.0' encoding='UTF-8'?><test:username xmlns:test=\"http://xslt.servicemix.apache.binildas.com\">Binildas</test:username>";
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

        TextMessage textMessage = (TextMessage) consumer.receive(WAIT_TIME);
        if(textMessage == null){
            System.out.println("Response timed out.");
        }else{
            System.out.println("Response was: " + textMessage.getText());
        }

        System.out.println("Closing.");
        connection.close();
    }
}
