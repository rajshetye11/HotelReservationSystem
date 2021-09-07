package com.bridgelabz.hotelreservation;

import java.util.ArrayList;

public class Hotels {

	public ArrayList<Hotels> hotelName = new ArrayList<>();
	
	String hotels;
	String rates;
	Integer weekDayReg;
	Integer weekDayReward;
	Integer weekEndReg;
	Integer weekEndReward;
	
	public Hotels()
	{
		
	}
	public Hotels(String hotels, String rates, Integer weekDayReg, Integer weekDayReward,
		Integer weekEndReg ,Integer weekEndReward)
		{
			this.hotels = hotels;
			this.rates = rates;
			this.weekDayReg = weekDayReg;
			this.weekDayReward = weekDayReward;
			this.weekEndReg = weekDayReg;
			this.weekEndReward = weekEndReward;
		}
	
	public void addHotels(String hotels, String rates, Integer weekDayReg, Integer weekDayReward,
			Integer weekEndReg ,Integer weekEndReward) {
		hotelName.add(new Hotels (hotels, rates,weekDayReg,weekDayReward, weekEndReg, weekEndReward));
	}
	
	public int size() {
		return hotelName.size();
	}
}
