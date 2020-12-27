package examples.webservices.basic.statelessSession;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface HelloWorldHome extends EJBHome {

  HelloWorld create() throws CreateException, RemoteException;

}
