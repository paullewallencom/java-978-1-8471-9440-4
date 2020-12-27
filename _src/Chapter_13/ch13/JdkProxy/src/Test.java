import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;

public class Test{

	public static void main(String[] args){

		InvocationHandler handler = new SimpleInvocationHandler();
/*
		Class proxyClass = Proxy.getProxyClass(
         SimpleIntf.class.getClassLoader(), new Class[]
         	{ SimpleIntf.class });
*/
		SimpleIntf simpleIntf = (SimpleIntf) Proxy.newProxyInstance
			(SimpleIntf.class.getClassLoader(),
			new Class[] { SimpleIntf.class }, handler);

		simpleIntf.print();

	}
}

