
package com.binildas.esb.javasource;

import com.thoughtworks.xstream.XStream;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

public class XStreamUtil{

	public static String ServiceParamToXml(ServiceParamTO serviceParamTO){

		XStream xStream = new XStream();
		xStream.alias("ServiceParamTO", ServiceParamTO.class);
		xStream.alias("CustomerTO", CustomerTO.class);
		xStream.alias("CreditCardTO", CreditCardTO.class);
		xStream.alias("AddressTO", AddressTO.class);

		String xml = xStream.toXML(serviceParamTO);
		return xml;

	}

	public static ServiceParamTO xmlToServiceParam(String xml){

		XStream xStream = new XStream();
		xStream.alias("ServiceParamTO", ServiceParamTO.class);
		xStream.alias("CustomerTO", CustomerTO.class);
		xStream.alias("CreditCardTO", CreditCardTO.class);
		xStream.alias("AddressTO", AddressTO.class);

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml.getBytes());
		InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
		ServiceParamTO serviceParamTO = (ServiceParamTO) xStream.fromXML(inputStreamReader);

		return serviceParamTO;

	}

	public static String objectToXml(Object object){

		XStream xStream = new XStream();
		xStream.alias("ServiceParamTO", ServiceParamTO.class);
		xStream.alias("CustomerTO", CustomerTO.class);
		xStream.alias("CreditCardTO", CreditCardTO.class);
		xStream.alias("AddressTO", AddressTO.class);

		String xml = xStream.toXML(object);
		return xml;

	}

	public static Object xmlToObject(String xml){

		XStream xStream = new XStream();
		xStream.alias("ServiceParamTO", ServiceParamTO.class);
		xStream.alias("CustomerTO", CustomerTO.class);
		xStream.alias("CreditCardTO", CreditCardTO.class);
		xStream.alias("AddressTO", AddressTO.class);

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml.getBytes());
		InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
		Object object = xStream.fromXML(inputStreamReader);

		return object;

	}

	private void test2(){

		log("XStreamUtil.test2 : Start...");

		Object object = ClientUtil.getRandomServiceParam();
		String xml = objectToXml(object);
		log("xml:\n" + xml);

		Object objectBack = xmlToObject(xml);
		log("objectBack:\n" + objectBack);

		log("XStreamUtil.test2 : End");
	}

	private void test1(){

		log("XStreamUtil.test1 : Start...");

		ServiceParamTO serviceParamTO = ClientUtil.getRandomServiceParam();
		String xml = ServiceParamToXml(serviceParamTO);
		log("xml:\n" + xml);

		ServiceParamTO serviceParamTOBack = xmlToServiceParam(xml);
		log("serviceParamTOBack:\n" + serviceParamTOBack);

		log("XStreamUtil.test1 : End");
	}

	public static void main(String[] args){

		log("XStreamUtil.main : Start...");
		XStreamUtil xStreamUtil = new XStreamUtil();
		xStreamUtil.test1();
		xStreamUtil.test2();
	}

	private static void log(Object msg){
		System.out.println(msg.toString());
	}

}