package com.model;

public class Charges {

	public ChargesPojo calculateCharges(GetMockParameter parameterObject) {
		
		ChargesPojo charges = new ChargesPojo();
		
		System.out.println("Number of Days: " + parameterObject.numOfDays);
		System.out.println("Price: " + parameterObject.price);
		
		charges.totalCharges = parameterObject.price * parameterObject.numOfDays;
		charges.taxes = (parameterObject.price * parameterObject.numOfDays) * 0.1;
		charges.chargeWithoutTax = charges.totalCharges - charges.taxes;
		
		return charges;
	
	}
}
