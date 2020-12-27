import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import org.apache.servicemix.jbi.jaxp.StringSource;

import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.MessagingException;
import javax.jbi.messaging.NormalizedMessage;

import org.apache.servicemix.MessageExchangeListener;
import org.apache.servicemix.components.util.TransformComponentSupport;
import javax.xml.transform.stream.StreamSource;
;
public class MyReceiver extends   TransformComponentSupport  implements MessageExchangeListener{

	private String name;

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	protected boolean transform(MessageExchange exchange, NormalizedMessage in, NormalizedMessage out) throws MessagingException {

        NormalizedMessage copyMessage = exchange.createMessage();
        getMessageTransformer().transform(exchange, in, copyMessage);
        Source content = copyMessage.getContent();
        String contentString = null;
		if (content instanceof DOMSource){
			contentString = XMLUtil.node2XML(((DOMSource) content).getNode());
		}
		if (content instanceof StreamSource){
			contentString = XMLUtil.formatStreamSource((StreamSource) content);
		}
        System.out.println("MyReceiver.transform(" + name + "). contentString = " + contentString);

		out.setContent(new StringSource(contentString));
		return true;
	}

    public static void log(Object msg){
       System.out.println(msg.toString());
    }

}