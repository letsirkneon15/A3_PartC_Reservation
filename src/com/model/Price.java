package com.model;

public class Price {
	
	public double getRoomRates(String room) {
		double price = 0.0;
		
		switch(room) {
		case "Standard":
			price = 100.00;
			break;
		case "Deluxe":
			price = 150.00;
			break;
		case "Deluxe King":
			price = 200.00;
			break;
		case "Alpine":
			price = 300.00;
			break;
		}
		
		return price;	
	}

}
