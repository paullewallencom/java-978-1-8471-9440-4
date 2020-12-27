
package com.binildas.esb.servicemix.serviceassembly.voipservice;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class CustomerTO implements Serializable, Cloneable{

	private String firstName;
	private String lastName;
	private AddressTO addressTO;

	public CustomerTO(){}

	public CustomerTO(String firstName, String lastName){
		this(firstName, lastName, null);
	}

	public CustomerTO(String firstName, String lastName, AddressTO addressTO){
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressTO = addressTO;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getLastName(){
		return lastName;
	}

	public String getName(){
		return getFirstName() + " " + getLastName();
	}

	public void setAddress(AddressTO addressTO){
		this.addressTO = addressTO;
	}
	public AddressTO getAddress(){
		return addressTO;
	}

	public Object clone(){

		Object clone = null;
		try{
			clone = super.clone();
			if(null != addressTO){
				((CustomerTO) clone).setAddress((AddressTO) addressTO.clone());
			}
		}
		catch(CloneNotSupportedException cloneNotSupportedException){
			;
		}
		return clone;
	}

	public String toString(){
		StringBuffer stringBuffer = new StringBuffer();
		if(this.firstName != null){
			stringBuffer.append("[Name : " + getName() + "] ");
		}
		if(this.addressTO != null){
			stringBuffer.append("Address -> " + addressTO);
		}
		return stringBuffer.toString();
	}

}