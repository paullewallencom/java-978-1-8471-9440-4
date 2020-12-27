
import java.lang.reflect.InvocationHandler;
import java.io.Serializable;
import java.lang.reflect.Method;

public class SimpleInvocationHandler
		implements InvocationHandler, Serializable{

    public SimpleInvocationHandler(){}

    public Object invoke(final Object obj, Method method, Object[] args) throws Throwable{

		if (method.getName().equals("print") && (args == null || args.length == 0)){
			System.out.println("SimpleInvocationHandler.invoked");
		}
		else{
			throw new IllegalArgumentException("Interface method does not support param(s) : " + args);
		}
		return null;
    }

}

