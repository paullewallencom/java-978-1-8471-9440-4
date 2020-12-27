
package com.binildas.apache.axis.AxisEndToEnd;

public class HelloWebService implements IHelloWeb{

	private static int times;

	public HelloWebService(){
		//System.out.println("Inside HelloWebService.HelloWebService...");
	}

	public String hello(String param){

		System.out.println("Inside HelloWebService.hello - " + (++times) );
		return "Hello " + param + "! Return From Server";
	}

}