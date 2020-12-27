
package com.binildas.esb.javasource;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class CreditCardTO implements Serializable, Cloneable{

	private String cardNumber;
	private String validTill;
	private String cardType;

	public static final String VISA = "Visa";
	public static final String MASTER_CARD = "Master Card";
	public static final String AMEX = "Amex";

	public CreditCardTO(){}

	public CreditCardTO(String cardNumber, String validTill, String cardType){
		this.cardNumber = cardNumber;
		this.validTill = validTill;
		this.cardType = cardType;
	}

	public void setCardNumber(String cardNumber){
		this.cardNumber = cardNumber;
	}
	public String getCardNumber(){
		return cardNumber;
	}

	public void setValidTill(String validTill){
		this.validTill = validTill;
	}
	public String getValidTill(){
		return validTill;
	}

	public void setCardType(String cardType){
		this.cardType = cardType;
	}
	public String getCardType(){
		return cardType;
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
		if(this.cardNumber != null){
			stringBuffer.append("[CardNumber : " + cardNumber + "; ");
		}
		if(this.validTill != null){
			stringBuffer.append("ValidTill : " + validTill + "; ");
		}
		if(this.cardType != null){
			stringBuffer.append("CardType : " + cardType + "]");
		}
		return stringBuffer.toString();
	}

}