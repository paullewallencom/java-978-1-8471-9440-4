package examples.webservices.basic.statelessSession;

import weblogic.ejb.GenericSessionBean;


public class HelloWorldEJB extends GenericSessionBean implements HelloWorldBI{

  public String sayHello(int num, String s) {

    System.out.println("sayHello in the HelloWorldEJB has "+
      "been invoked with arguments " + s + " and " + num);

    String returnValue = "This message brought to you by the "+
      "letter "+s+" and the number "+num;

    return returnValue;

  }

}
