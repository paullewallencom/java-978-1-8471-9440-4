package samples;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;

public class HelloServiceBean implements SessionBean {

	private static long times = 0; // This is bad, still...

	private javax.ejb.SessionContext mySessionCtx = null;

	public void ejbActivate() throws java.rmi.RemoteException {}
	public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {}
	public void ejbPassivate() throws java.rmi.RemoteException {}
	public void ejbRemove() throws java.rmi.RemoteException {}

	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}
	public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
		mySessionCtx = ctx;
	}

	public String hello(String phrase) {
		System.out.println("HelloServiceBean.hello{" + (++times) + "}...");
		return "From HelloServiceBean : HELLO!! You just said :" + phrase;
	}

}
