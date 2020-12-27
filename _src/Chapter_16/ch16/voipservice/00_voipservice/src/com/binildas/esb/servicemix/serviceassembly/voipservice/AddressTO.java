
package com.binildas.esb.servicemix.serviceassembly.voipservice;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class AddressTO implements Serializable, Cloneable{

	private String houseNumber;
	private String street;
	private String city;

	public AddressTO(){}

	public AddressTO(String houseNumber, String street, String city){

		this.houseNumber = houseNumber;
		this.street = street;
		this.city = city;
	}

	public void setHouseNumber(String houseNumber){
		this.houseNumber = houseNumber;
	}
	public String getHouseNumber(){
		return houseNumber;
	}

	public void setStreet(String street){
		this.street = street;
	}
	public String getStreet(){
		return street;
	}

	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return city;
	}

	public Object clone(){

		Object clone = null;
		try{
			clone = super.clone();
		}
		catch(CloneNotSupportedException cloneNotSupportedException){
			;
		}
		return clone;
	}

	public String toString(){
		StringBuffer stringBuffer = new StringBuffer();
		if(this.houseNumber != null){
			stringBuffer.append("[HouseNumber : " + houseNumber + "; ");
		}
		if(this.street != null){
			stringBuffer.append("Street : " + street + "; ");
		}
		if(this.houseNumber != null){
			stringBuffer.append("City : " + city + "]");
		}
		return stringBuffer.toString();
	}

}