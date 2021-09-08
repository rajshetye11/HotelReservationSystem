package com.bridgelabz.hotelreservation;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;


public class HotelsTest {

	HotelReservationSystem h1 = new HotelReservationSystem();
	Hotels lw, bw, rw;
	
	@Before
	public void addHotels() {
		
		HashMap<CustomerType, Rates> rate = new HashMap<CustomerType,Rates>();
		rate.put(CustomerType.REGULAR, new Rates(110,90));
		rate.put(CustomerType.REWARD, new Rates(80,80));
		lw = new Hotels("LakeWood",3,rate);
		
		rate = new HashMap<>();
		rate.put(CustomerType.REGULAR, new Rates(160,60));
		rate.put(CustomerType.REWARD, new Rates(110,50));
		bw = new Hotels("BridgeWood",4,rate);
		
		rate = new HashMap<>();
		rate.put(CustomerType.REGULAR, new Rates(220,150));
		rate.put(CustomerType.REWARD, new Rates(100,40));
		rw = new Hotels("RidgeWood",5,rate);

		h1.addHotels(lw);
		h1.addHotels(bw);
		h1.addHotels(rw);
	}

	 @Test
	    public void cheapestHotel() {
	    	DateTimeFormatter date = DateTimeFormatter.ofPattern("ddMMMyyyy");
	    	String firstDate = "10Sep2020";
	    	String secondDate = "12Sep2020";
	    	
	        LocalDate date1 = LocalDate.parse(firstDate,date);
	        LocalDate date2 = LocalDate.parse(secondDate,date);
	        String h2 = h1.findCheapestHotel(date1,date2);
	        assertEquals("LakeWood", h2);
	    }
	 
	 @Test
	    public void BestRatingCheapestHotel() {
	    	DateTimeFormatter date = DateTimeFormatter.ofPattern("ddMMMyyyy");    	
	    	String firstDate = "11Sep2020";
	    	String secondDate = "12Sep2020";
	    	
	        LocalDate date1 = LocalDate.parse(firstDate,date);
	        LocalDate date2 = LocalDate.parse(secondDate,date);
	        String h2 =  h1.bestRatingCheapestHotel(date1,date2);
	        assertEquals("BridgeWood", h2);
	    }
	 
	 @Test
	    public void whenGivenDateRange_ShouldReturnBestRatedHotel() {
	    	DateTimeFormatter date = DateTimeFormatter.ofPattern("ddMMMyyyy");    	
	    	LocalDate date1 = LocalDate.of(2020,9,11);
	    	LocalDate date2 = LocalDate.of(2020,9,12);
	    	h1.bestRatedHotel(date1,date2);
	    	
	    }
}
