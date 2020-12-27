
package test;

//import com.binildas.apache.axis.AxisEndToEnd.IHelloWebService;

public class HelloProxyService implements IHelloProxy {

    private IHelloProxy helloProxy;

    public void setHelloProxy(IHelloProxy helloProxy) {
        this.helloProxy = helloProxy;
    }

    public String hello(String input) {

        System.out.println("HelloProxyService.hello. this = " + this);
        return helloProxy.hello(input);
    }
}
