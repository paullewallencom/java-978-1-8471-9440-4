package com.binildas.esb.servicemix.serviceassembly.voipservice;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceFactory;
import java.net.URL;
import java.util.*;

public class Client {


    public static void main(String[] args) throws Exception {

		System.out.println("Client.main...");

		IVoip iVoip = null;

		if(args.length == 0){
			iVoip = new IVoipServiceLocator().getVoipService();
		}
		else{
			iVoip = new IVoipServiceLocator(args[0], new QName(args[1], args[2])).getVoipService();
		}

		ServiceParamTO serviceParamTO = ClientUtil.getRandomServiceParam();

		CreditProfileTO creditProfileTO = iVoip.provisionService(serviceParamTO);

		System.out.println("Client.main. Done.");

    }
}