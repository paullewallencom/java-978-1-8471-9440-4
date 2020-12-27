
import java.text.NumberFormat;
import java.text.DecimalFormat;

/** XFire WebServices sample implementation class.
*/
public class HelloServiceImpl implements IHello{

	private static long times = 0L;

    //Default constructor.
    public HelloServiceImpl(){
		System.out.println("HelloServiceImpl.HelloServiceImpl()...");
    }

	public String sayHello(String name){

		System.out.println("HelloServiceImpl.sayHello(" + (++times) + ")");
		return "HelloServiceImpl.sayHello : HELLO! You just said: " + name;
	}

}