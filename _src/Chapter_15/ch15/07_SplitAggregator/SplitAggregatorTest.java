
import java.io.IOException;
import java.io.InputStream;

import javax.xml.namespace.QName;

import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;
import org.w3c.dom.Element;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.TransformerException;
import javax.xml.namespace.QName;

import org.springframework.context.support.AbstractXmlApplicationContext;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.apache.xpath.CachedXPathAPI;

import org.apache.servicemix.jbi.resolver.ServiceNameEndpointResolver;
import org.apache.servicemix.jbi.jaxp.SourceTransformer;
import org.apache.servicemix.jbi.util.DOMUtil;
import org.apache.servicemix.client.ServiceMixClient;
import org.apache.servicemix.jbi.container.SpringJBIContainer;
import org.apache.servicemix.client.DefaultServiceMixClient;
import org.apache.servicemix.jbi.jaxp.StringSource;
import org.apache.servicemix.eip.support.AbstractSplitter;

import javax.jbi.messaging.InOnly;
import javax.jbi.messaging.ExchangeStatus;

import junit.framework.TestCase;

public class SplitAggregatorTest extends TestCase{

	private static final long WAIT_TIME = 5 * 1000L;

    private AbstractXmlApplicationContext context;
    private SourceTransformer srcTransformer;
    private ServiceMixClient svcMixClient;
    private SpringJBIContainer springJbiContainer;

    private static final String SERVICE_MIX_JBI_CONFIG = "servicemix.xml";
    private static final QName SERVICE = new QName("http://xslt.servicemix.apache.binildas.com", "aggregator");;

    protected void setUp()throws Exception{

		log(" ********** SplitAggregatorTest.setUp...");
        System.setProperty("DEBUG", "true");

        context = initAppContext();
        srcTransformer = new SourceTransformer();
        svcMixClient = (ServiceMixClient) getBeanFromJbiContainer("client");
        springJbiContainer = (SpringJBIContainer) context.getBean("jbi");
    }

    protected void tearDown() throws Exception{

		log(" ********** SplitAggregatorTest.tearDown...");
        if (context != null) {
            log("Closing down the Spring ApplicationContext");
            context.destroy();
        }
    }

    public void testSplitAggregator() throws Exception{

		log(" ********** SplitAggregatorTest.testSplitAggregator. Start...");
		String splitterCorrId = null;
		String message = null;
		int splitterCount = -1;
		int splitterIndex = -1;

        String corrIdMsg1 = Long.toString(System.currentTimeMillis());
		synchronized(Thread.currentThread()){
			Thread.currentThread().wait(WAIT_TIME);
		}
        String corrIdMsg2 = Long.toString(System.currentTimeMillis());

//---------------------------------------------------------------------------------
        splitterCorrId = corrIdMsg1;
        message = "<hello id=\"1\"><binil/><sowmya/></hello>";
        splitterCount = 3;
        splitterIndex = 1;
        sendMessagePart(message, splitterCount, splitterIndex, splitterCorrId);
        System.out.println("Send msg : corrId<" + splitterCorrId + "> : splitterCount<" + splitterCount + "> : splitterIndex<" + splitterIndex + "> : msg<"+ message + ">");
		synchronized(Thread.currentThread()){
			System.out.println("Waiting " + WAIT_TIME + " millis before next message...");
			Thread.currentThread().wait(WAIT_TIME);
		}

        splitterCorrId = corrIdMsg2;
        message = "<hello id=\"1\"><ann/></hello>";
        splitterCount = 2;
        splitterIndex = 1;
        sendMessagePart(message, splitterCount, splitterIndex, splitterCorrId);
        System.out.println("Send msg : corrId<" + splitterCorrId + "> : splitterCount<" + splitterCount + "> : splitterIndex<" + splitterIndex + "> : msg<"+ message + ">");
		synchronized(Thread.currentThread()){
			System.out.println("Waiting " + WAIT_TIME + " millis before next message...");
			Thread.currentThread().wait(WAIT_TIME);
		}

        splitterCorrId = corrIdMsg1;
        message = "<hello id=\"0\"><binil/><sowmya/></hello>";
        splitterCount = 3;
        splitterIndex = 0;
        sendMessagePart(message, splitterCount, splitterIndex, splitterCorrId);
        System.out.println("Send msg : corrId<" + splitterCorrId + "> : splitterCount<" + splitterCount + "> : splitterIndex<" + splitterIndex + "> : msg<"+ message + ">");
		synchronized(Thread.currentThread()){
			System.out.println("Waiting " + WAIT_TIME + " millis before next message...");
			Thread.currentThread().wait(WAIT_TIME);
		}

        splitterCorrId = corrIdMsg2;
        message = "<hello id=\"0\"><ann/></hello>";
        splitterCount = 2;
        splitterIndex = 0;
        sendMessagePart(message, splitterCount, splitterIndex, splitterCorrId);
        System.out.println("Send msg : corrId<" + splitterCorrId + "> : splitterCount<" + splitterCount + "> : splitterIndex<" + splitterIndex + "> : msg<"+ message + ">");
		synchronized(Thread.currentThread()){
			System.out.println("Waiting " + WAIT_TIME + " millis before next message...");
			Thread.currentThread().wait(WAIT_TIME);
		}

        splitterCorrId = corrIdMsg1;
        message = "<hello id=\"2\"><binil/><sowmya/></hello>";
        splitterCount = 3;
        splitterIndex = 2;
        sendMessagePart(message, splitterCount, splitterIndex, splitterCorrId);
        System.out.println("Send msg : corrId<" + splitterCorrId + "> : splitterCount<" + splitterCount + "> : splitterIndex<" + splitterIndex + "> : msg<"+ message + ">");
		synchronized(Thread.currentThread()){
			System.out.println("Waiting " + WAIT_TIME + " millis before next message...");
			Thread.currentThread().wait(WAIT_TIME);
		}

		log(" ********** SplitAggregatorTest.testSplitAggregator. End.");
    }

    private void sendMessagePart(String message, int splitterCount, int splitterIndex, String splitterCorrId)throws Exception{

		InOnly me = svcMixClient.createInOnlyExchange();
		me.setService(SERVICE);
		me.getInMessage().setContent(new StringSource(message));
		me.getInMessage().setProperty(AbstractSplitter.SPLITTER_COUNT, new Integer(splitterCount));
		me.getInMessage().setProperty(AbstractSplitter.SPLITTER_INDEX, new Integer(splitterIndex));
		me.getInMessage().setProperty(AbstractSplitter.SPLITTER_CORRID, splitterCorrId);
		svcMixClient.send(me);
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

		log(" ********** SaajTest.initAppContext...");
        return new ClassPathXmlApplicationContext(SERVICE_MIX_JBI_CONFIG);
    }

    public static void log(Object msg){
       System.out.println(msg.toString());
    }

    public static void main(String[] args)throws Exception{

		log(" ********** SplitAggregatorTest.main-Start...");
		SplitAggregatorTest splitAggregatorTest = new SplitAggregatorTest();
		splitAggregatorTest.setUp();
		splitAggregatorTest.testSplitAggregator();
		splitAggregatorTest.tearDown();
		log(" ********** SplitAggregatorTest.main-Done.");
	}

}