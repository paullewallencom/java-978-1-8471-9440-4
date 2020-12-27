
package com.binildas.esb.servicemix.serviceassembly.voipservice;

public class VoipImpl implements IVoip{

	public CreditProfileTO provisionService(ServiceParamTO serviceParamTO){

		System.out.println("ServiceImpl.provisionService...");

		CreditProfileTO creditProfileTO = new CreditProfileTO();
		creditProfileTO.setCustomer(serviceParamTO.getCustomer());
		creditProfileTO.setCreditScore(100);
		creditProfileTO.setValid(true);
		creditProfileTO.setCreditAuthorisedStatus(1);

		return creditProfileTO;
	}

}