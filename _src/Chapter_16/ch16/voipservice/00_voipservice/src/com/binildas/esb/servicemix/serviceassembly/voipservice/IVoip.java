
package com.binildas.esb.servicemix.serviceassembly.voipservice;

public interface IVoip  extends java.rmi.Remote{

	CreditProfileTO provisionService(ServiceParamTO serviceParamTO) throws java.rmi.RemoteException;

}