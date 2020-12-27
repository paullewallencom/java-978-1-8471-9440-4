package test;

public class TargetService implements IEcho{

    public String echo(String input) {

        System.out.println("TargetService.echo : String. this = " + this);
        return input;
    }
}
