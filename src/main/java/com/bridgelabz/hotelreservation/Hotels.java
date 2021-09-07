package com.bridgelabz.hotelreservation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;


public class Hotels {

	public ArrayList<Hotels> hotels = new ArrayList<>();
	
	String hotelName;
	Integer rating;
	HashMap<CustomerType, Rates> hotelRates;
	
	public Hotels()
	{
		
	}
	
	public Hotels(String hotelName, Integer rating, HashMap<CustomerType, Rates> hotelRates)
		{
			this.hotelName = hotelName;
			this.rating = rating;
			this.hotelRates = hotelRates;
		}
	
	public void addHotels(Hotels hotel) {
		hotels.add(hotel);
	}
	
	public int size() {
		return hotels.size();
	}
	
	
	
}
