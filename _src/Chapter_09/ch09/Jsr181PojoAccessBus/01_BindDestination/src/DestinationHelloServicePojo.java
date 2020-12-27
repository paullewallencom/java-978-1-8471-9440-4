package samples;

public class DestinationHelloServicePojo implements DestinationHelloServiceBI{

	private static long times = 0;

	public String hello(String phrase) {

		System.out.println("DestinationHelloServiceBean.hello{" + (++times) + "}...");
		return "From DestinationHelloServiceBean : HELLO!! You just said :" + phrase;
	}

}
