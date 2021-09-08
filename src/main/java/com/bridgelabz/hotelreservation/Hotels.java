package com.bridgelabz.hotelreservation;

import java.util.HashMap;

public class Hotels {
	
	String hotelName;
	Integer rating;
	HashMap<CustomerType, Rates> hotelRates;
	
	public Hotels() {}
	
	public Hotels(String hotelName, Integer rating, HashMap<CustomerType, Rates> hotelRates)
		{
			this.hotelName = hotelName;
			this.rating = rating;
			this.hotelRates = hotelRates;
		}

	public HashMap<CustomerType, Rates> getHotelRates() {
		return hotelRates;
	}	
		
}