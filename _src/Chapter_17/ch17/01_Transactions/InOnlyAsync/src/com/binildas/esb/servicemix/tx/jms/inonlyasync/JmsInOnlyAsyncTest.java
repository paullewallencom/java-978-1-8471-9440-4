package com.binildas.esb.servicemix.tx.jms.inonlyasync;

import javax.transaction.TransactionManager;
import javax.jbi.messaging.InOnly;
import javax.jbi.messaging.ExchangeStatus;

import org.apache.servicemix.client.Destination;
import org.apache.servicemix.client.ServiceMixClient;
import org.apache.servicemix.jbi.container.SpringJBIContainer;
import org.apache.servicemix.jbi.jaxp.StringSource;
import org.apache.servicemix.tck.Receiver;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;

import junit.framework.TestCase;

public class JmsInOnlyAsyncTest extends TestCase{

    private AbstractXmlApplicationContext context;
    private ServiceMixClient svcMixClient;
    private SpringJBIContainer springJbiContainer;
    private Receiver receiver;

    private static final String EMPTY_STRING = "";
    private static final String SERVICE_MIX_JBI_CONFIG = "servicemixjms.xml";

    protected void setUp()throws Exception{

		log("JmsInOnlyAsyncTest.setUp...");
        System.setProperty("DEBUG", "true");

        context = initAppContext();
        svcMixClient = (ServiceMixClient) getBeanFromJbiContainer("client");
        springJbiContainer = (SpringJBIContainer) context.getBean("jbi");
        receiver = (Receiver) getBeanFromJbiContainer("receiver");
    }

    protected void tearDown() throws Exception{

		log("JmsInOnlyAsyncTest.tearDown...");
        if (context != null) {
            log("Closing down the Spring ApplicationContext");
            context.destroy();
        }
    }

    public void testJmsInOnlySync() throws Exception {

        log("JmsInOnlyAsyncTest.testJmsInOnlySync - Start...");

        TransactionManager tm = (TransactionManager) getBeanFromJbiContainer("transactionManager");
        tm.begin();
        Destination dest = svcMixClient.createDestination("endpoint:http://binildas.com/esb/servicemix/tx/jms/inonlyasync/MyProviderService/providerEP");
        InOnly me = dest.createInOnlyExchange();
        me.getInMessage().setContent(new StringSource("<TestXML content=\"binil\" />"));
        svcMixClient.send(me);
        tm.commit();
        log("JmsInOnlyAsyncTest.testJmsInOnlySync - Transaction Committed.");
        me = (InOnly) svcMixClient.receive();
        assertEquals(ExchangeStatus.DONE, me.getStatus());
        receiver.getMessageList().assertMessagesReceived(1);


        log("JmsInOnlyAsyncTest.testJmsInOnlySync - End.");
    }

    protected Object getBeanFromJbiContainer(String name){

        Object bean = null;
        if (springJbiContainer != null) {
            bean = springJbiContainer.getBean(name);
        }
        if (bean == null) {
            bean = context.getBean(name);
        }
        assertNotNull("Cannot find object in Spring for key: " + name, bean);
        return bean;
    }

    protected AbstractXmlApplicationContext initAppContext() {

		log("JmsInOnlyAsyncTest.initAppContext...");
        return new ClassPathXmlApplicationContext(SERVICE_MIX_JBI_CONFIG);
    }

    public static void log(Object msg){
       System.out.println(msg.toString());
    }

    public static void main(String[] args)throws Exception{

		log("JmsInOnlyAsyncTest.main - Start...");
		JmsInOnlyAsyncTest jmsInOnlyAsyncTest = new JmsInOnlyAsyncTest();
		jmsInOnlyAsyncTest.setUp();
		jmsInOnlyAsyncTest.testJmsInOnlySync();
		jmsInOnlyAsyncTest.tearDown();
		log("JmsInOnlyAsyncTest.main - Done.");
	}

}