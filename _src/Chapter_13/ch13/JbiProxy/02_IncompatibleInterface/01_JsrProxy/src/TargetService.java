
package test;

public class TargetService implements ITarget{

    public String echo(String input) {

        System.out.println("TargetService.echo : String. this = " + this);
        return input;
    }
}
