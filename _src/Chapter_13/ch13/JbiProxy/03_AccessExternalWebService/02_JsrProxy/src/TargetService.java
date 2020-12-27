
package test;

public class TargetService implements ITarget{

	private com.binildas.apache.axis.AxisEndToEnd.IHelloWeb helloWeb;

	public TargetService(){}

	public TargetService(com.binildas.apache.axis.AxisEndToEnd.IHelloWeb helloWeb){
		this.helloWeb = helloWeb;
	}

    public String hello(String input) {

        System.out.println("TargetService.echo : String. this = " + this);
        try{
        	return helloWeb.hello(input);
		}
		catch(Exception exception){
			exception.printStackTrace();
			return exception.getMessage();
		}
    }
}
