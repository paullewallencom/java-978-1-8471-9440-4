package com.binildas.esb.servicemix.serviceassembly.voipservice;

import java.util.*;

public class ClientUtil {

	private static final List CUSTOMERS;
	private static final List ADDRESSES;
	private static final List CREDIT_CARDS;

	public static final String VISA = "Visa";
	public static final String MASTER_CARD = "Master Card";
	public static final String AMEX = "Amex";

	static{
		CUSTOMERS = new ArrayList();

		CUSTOMERS.add(createCustomer("Binil", "Das"));
		CUSTOMERS.add(createCustomer("Rajesh", "Warrier"));
		CUSTOMERS.add(createCustomer("Jacob", "Oommen"));
		CUSTOMERS.add(createCustomer("Shahanas", "Mohammed"));
		CUSTOMERS.add(createCustomer("Sowmya", "Hubert"));
		CUSTOMERS.add(createCustomer("Ann", "Binil"));
		CUSTOMERS.add(createCustomer("Rajesh", "Ravindran"));
		CUSTOMERS.add(createCustomer("Renjit", "Hubert"));
		CUSTOMERS.add(createCustomer("Brijesh", "Deb"));
		CUSTOMERS.add(createCustomer("Rama", "Varma"));

		ADDRESSES = new ArrayList();

		ADDRESSES.add(createAddress("123", "Koudiar Palace", "Trivandrum"));
		ADDRESSES.add(createAddress("222", "Lake View", "Cochin"));
		ADDRESSES.add(createAddress("345", "Spencer Town", "Chennai"));
		ADDRESSES.add(createAddress("898", "Electronics City", "Bangalore"));
		ADDRESSES.add(createAddress("554", "Kovalam Beach", "Trivandrum"));
		ADDRESSES.add(createAddress("101", "Anzyl Grove", "Pune"));
		ADDRESSES.add(createAddress("369", "Victoria Terminus", "Mumbai"));
		ADDRESSES.add(createAddress("876", "Ponmudi Hills", "Trivandrum"));
		ADDRESSES.add(createAddress("777", "White Field", "Bangalore"));
		ADDRESSES.add(createAddress("908", "Varkala Palms", "Trivandrum"));

		CREDIT_CARDS = new ArrayList();

		CREDIT_CARDS.add(createCreditCard("1111-2222-3333-4444", "01-JAN-2006", VISA));
		CREDIT_CARDS.add(createCreditCard("2222-3333-4444-5555", "01-FEB-2006", MASTER_CARD));
        CREDIT_CARDS.add(createCreditCard("3333-4444-5555-6666", "01-MAR-2006", VISA));
		CREDIT_CARDS.add(createCreditCard("4444-5555-6666-7777", "01-APR-2006", VISA));
		CREDIT_CARDS.add(createCreditCard("5555-6666-7777-8888", "01-JAN-2007", MASTER_CARD));
        CREDIT_CARDS.add(createCreditCard("6666-7777-8888-9999", "01-FEB-2007", MASTER_CARD));
		CREDIT_CARDS.add(createCreditCard("7777-8888-9999-1111", "01-MAR-2007", VISA));
		CREDIT_CARDS.add(createCreditCard("8888-9999-1111-2222", "01-APR-2007", MASTER_CARD));
        CREDIT_CARDS.add(createCreditCard("9999-1111-2222-3333", "01-JAN-2008", VISA));
		CREDIT_CARDS.add(createCreditCard("9999-1111-2222-4444", "01-FEB-2008", VISA));

	}

	public static CustomerTO createCustomer(String firstName, String lastName){
		CustomerTO customerTO = new CustomerTO();
		customerTO.setFirstName(firstName);
		customerTO.setLastName(lastName);
		return customerTO;
	}
	public static AddressTO createAddress(String houseNumber, String street, String city){
		AddressTO addressTO = new AddressTO();
		addressTO.setHouseNumber(houseNumber);
		addressTO.setStreet(street);
		addressTO.setCity(city);
		return addressTO;
	}
	public static CreditCardTO createCreditCard(String cardNumber, String validTill, String cardType){
		CreditCardTO creditCardTO = new CreditCardTO();
		creditCardTO.setCardNumber(cardNumber);
		creditCardTO.setValidTill(validTill);
		creditCardTO.setCardType(cardType);
		return creditCardTO;
	}

    public static CustomerTO getRandomCustomer(){

        int index = new Double(Math.random() * 10).intValue();
        //AddressTO addressTO = (AddressTO) ADDRESSES.get(index);
		//CustomerTO customerTO = (CustomerTO) ((CustomerTO) CUSTOMERS.get(index)).clone();
		CustomerTO customerTO = (CustomerTO) CUSTOMERS.get(index);
		if(null == customerTO.getAddress()){
			customerTO.setAddress(getRandomAddress());
		}
		return customerTO;
	}

    public static AddressTO getRandomAddress(){

        int index = new Double(Math.random() * 10).intValue();
        //AddressTO addressTO = (AddressTO) ADDRESSES.get(index);
		return (AddressTO) ADDRESSES.get(index);
	}

    public static CreditCardTO getRandomCreditCard(){

        int index = new Double(Math.random() * 10).intValue();
		return (CreditCardTO) CREDIT_CARDS.get(index);
	}

    public static ServiceParamTO getRandomServiceParam(){

		CustomerTO customerTO = getRandomCustomer();
		CreditCardTO creditCardTO = getRandomCreditCard();
		ServiceParamTO serviceParamTO = new ServiceParamTO();
		serviceParamTO.setCustomer(customerTO);
		serviceParamTO.setCreditCard(creditCardTO);
		return serviceParamTO;
	}

}