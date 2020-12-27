
import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.MessagingException;
import javax.jbi.messaging.NormalizedMessage;
import javax.jbi.component.ComponentContext;
import javax.jbi.messaging.ExchangeStatus;

import org.apache.servicemix.JbiConstants;
import org.apache.servicemix.jbi.container.JBIContainer;
import org.apache.servicemix.MessageExchangeListener;
import org.apache.servicemix.components.util.ComponentSupport;
import org.apache.servicemix.jbi.jaxp.StringSource;

public class ContentAppender extends ComponentSupport implements MessageExchangeListener{

	private JBIContainer container;

	public ContentAppender(JBIContainer container){

		this.container = container;
	}

	public void setContext(ComponentContext context) throws Exception {

	}


	public void onMessageExchange(MessageExchange exchange) throws MessagingException {

		if (exchange.getStatus() == ExchangeStatus.ACTIVE) {
			boolean txSync = exchange.isTransacted() && Boolean.TRUE.equals(exchange.getProperty(JbiConstants.SEND_SYNC));
			NormalizedMessage out = exchange.createMessage();
			out.setContent(new StringSource("<?xml version='1.0' encoding='UTF-8'?><test:kerberosticket xmlns:test=\"http://xslt.servicemix.apache.binildas.com\">123456789</test:kerberosticket>"));
			exchange.setMessage(out, "out");
			if (txSync) {
				sendSync(exchange);
			} else {
				send(exchange);
			}
		}
	}


    public static void log(Object msg){
       System.out.println(msg.toString());
    }
}