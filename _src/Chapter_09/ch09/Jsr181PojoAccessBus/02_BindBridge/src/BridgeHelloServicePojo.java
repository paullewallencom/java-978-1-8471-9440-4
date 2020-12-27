package samples;

import javax.jbi.component.ComponentContext;
import javax.xml.namespace.QName;
import javax.jbi.JBIException;

import org.apache.servicemix.client.ServiceMixClient;
import org.apache.servicemix.client.ServiceMixClientFacade;
import org.apache.servicemix.jbi.resolver.EndpointResolver;

public class BridgeHelloServicePojo implements BridgeHelloServiceBI{

	private ComponentContext context;

	private static long times = 0;

	private String namespaceURI;
	private String localPart;

	public void setContext(ComponentContext context) {
		this.context = context;
	}

	public void setNamespaceURI(String namespaceURI){
		this.namespaceURI = namespaceURI;
	}
	public void setLocalPart(String localPart){
		this.localPart = localPart;
	}

	public String broker(String phrase) {

		System.out.println("BridgeHelloServicePojo.hello{" + (++times) + "}...");
		try{
			sendToJbi(phrase);
		}
		catch(JBIException jbiException){
			jbiException.printStackTrace();
			return jbiException.getMessage();
		}
		return "Success";
	}

	private void sendToJbi(String message)throws javax.jbi.JBIException{

		System.out.println("BridgeHelloServicePojo.1. message : " + message);
		ServiceMixClient client = new ServiceMixClientFacade(this.context);
		QName service = new QName(namespaceURI, localPart);
		EndpointResolver resolver = client.createResolverForService(service);
		String messageToDespatch = getMessage(message);
		client.send(resolver, null, null, messageToDespatch);
	}

	private String getMessage(String message){

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer	.append("<hello>")
							.append("<helloRequest>")
								.append("<message xmlns=\"http://soap\">" + message + "</message>")
							.append("</helloRequest>")
						.append("</hello>");
		return stringBuffer.toString();
	}


}
