
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class HelloServiceImpl implements IHello{

	private static long times = 0L;

    public HelloServiceImpl(){
		System.out.println("HelloServiceImpl.HelloServiceImpl()...");
    }

	public String sayHello(String name){

		System.out.println("HelloServiceImpl.sayHello(" + (++times) + ")");
		return "HelloServiceImpl.sayHello : HELLO! You just said: " + name;
	}

}