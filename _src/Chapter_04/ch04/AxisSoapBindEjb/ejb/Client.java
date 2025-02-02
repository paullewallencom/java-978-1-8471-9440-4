package samples;

import java.rmi.RemoteException;
import java.util.Hashtable;
import javax.ejb.CreateException;
import javax.ejb.RemoveException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class Client{

  private static final String JNDI_NAME = "sample-statelessSession-TraderHome";
  private String url;
  private HelloServiceHome home;

  public Client(String url) throws NamingException {
    this.url = url;
    home = lookupHome();
  }

  public static void main(String[] args) throws Exception {
    log("\nBeginning statelessSession.Client...\n");
    String url       = "t3://localhost:7001";
    Client client = null;

    // Parse the argument list
     if (args.length != 1) {
      log("Usage: java examples.ejb20.basic.statelessSession.Client t3://hostname:port");
      return;
    } else {
      url = args[0];
    }

    try {
      client = new Client(url);
      client.example();
    } catch (NamingException ne) {
      log("Unable to look up the beans home: " + ne.getMessage());
      throw ne;
    } catch (Exception e) {
      log("There was an exception while creating and using the Trader.");
      log("This indicates that there was a problem communicating with the server: "+e);
      throw e;
    }

    log("\nEnd statelessSession.Client...\n");
  }

  public void example()
    throws CreateException, RemoteException, RemoveException, Exception
  {
    // create a Trader
    log("Creating a trader");
    HelloService trader = (HelloService) narrow(home.create(), HelloService.class);

    String ret = trader.hello("Binil");
    log("Return from server: " + ret);

    // remove the Trader
    log("Removing the trader");
    trader.remove();
  }

  private Object narrow(Object ref, Class c) {
    return PortableRemoteObject.narrow(ref, c);
  }

  private HelloServiceHome lookupHome() throws NamingException {
    // Lookup the beans home using JNDI
    Context ctx = getInitialContext();
    try {
      Object home = ctx.lookup(JNDI_NAME);
      return (HelloServiceHome) narrow(home, HelloServiceHome.class);
    } catch (NamingException ne) {
      log("The client was unable to lookup the EJBHome.  Please make sure ");
      log("that you have deployed the ejb with the JNDI name "+
        JNDI_NAME+" on the WebLogic server at "+url);
      throw ne;
    }
  }

  private Context getInitialContext() throws NamingException {

    try {
      // Get an InitialContext
      Hashtable h = new Hashtable();
      h.put(Context.INITIAL_CONTEXT_FACTORY,
        "weblogic.jndi.WLInitialContextFactory");
      h.put(Context.PROVIDER_URL, url);
      return new InitialContext(h);
    } catch (NamingException ne) {
      log("We were unable to get a connection to the WebLogic server at "+url);
      log("Please make sure that the server is running.");
      throw ne;
    }
  }

  private static void log(String s) { System.out.println(s); }

}
