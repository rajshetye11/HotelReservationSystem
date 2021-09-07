package com.bridgelabz.hotelreservation;

public class Rates {
	public Integer weekDay;
	public Integer weekEnd;
	
	public Rates(Integer weekDay, Integer weekEnd) {
		this.weekDay = weekDay;
		this.weekEnd = weekEnd;
	}

	public Integer getWeekDay() {
		return weekDay;
	}

	public Integer getWeekEnd() {
		return weekEnd;
	}

}
