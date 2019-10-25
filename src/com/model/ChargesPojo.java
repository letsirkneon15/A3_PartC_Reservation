package com.model;

public class ChargesPojo {
	
	public double chargeWithoutTax, taxes, totalCharges;

	public ChargesPojo(double chargeWithoutTax, double taxes, double totalCharges) {
		super();
		this.chargeWithoutTax = chargeWithoutTax;
		this.taxes = taxes;
		this.totalCharges = totalCharges;
	}

	public ChargesPojo() {
	}

	public double getChargeWithoutTax() {
		return chargeWithoutTax;
	}

	public void setChargeWithoutTax(double chargeWithoutTax) {
		this.chargeWithoutTax = chargeWithoutTax;
	}

	public double getTaxes() {
		return taxes;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}

	public double getTotalCharges() {
		return totalCharges;
	}

	public void setTotalCharges(double totalCharges) {
		this.totalCharges = totalCharges;
	}
}
