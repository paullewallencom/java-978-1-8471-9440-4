
package com.binildas.esb.servicemix.ws.version20061231;

public class HelloWebService implements IHelloWeb{

	private static int times;

	public HelloWebService(){
	}

	public String hello(String param){

		System.out.println("Inside HelloWebService.hello - " + (++times)  + " : " + getClass().getPackage().getName());
        return param + " from : " + getClass().getPackage().getName();
	}

}