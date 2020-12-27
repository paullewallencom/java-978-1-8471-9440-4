package samples;

public class HelloServicePojo implements HelloServiceBI{

	private static long times = 0;

	public String hello(String phrase) {

		System.out.println("HelloServiceBean.hello{" + (++times) + "}...");
		return "From HelloServiceBean : HELLO!! You just said :" + phrase;
	}

}
