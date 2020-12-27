package examples.webservices.basic.statelessSession;

import java.io.IOException;


public interface HelloWorldBI{

  String sayHello(int num, String s) throws IOException;
}
