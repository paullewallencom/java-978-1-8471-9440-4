
package com.binildas.esb.servicemix.ws.version20070101;

public class HelloWebService implements IHelloWeb{

	private static int times;

	public HelloWebService(){
	}

	public String hello(String param){

		System.out.println("Inside HelloWebService.hello - " + (++times)  + " : " + getClass().getPackage().getName());
        return param + " from : " + getClass().getPackage().getName();
	}

}