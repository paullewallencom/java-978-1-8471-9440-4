
package test;

public class EchoProxyService implements IEcho {

    private IEcho echo;

    public void setEcho(IEcho echo) {
        this.echo = echo;
    }

    public String echo(String input) {

        System.out.println("EchoProxyService.echo. this = " + this);
        return echo.echo(input);
    }
}
