package com.bridgelabz.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelReservationSystem {

	public ArrayList<Hotels> hotel = new ArrayList<>();
	public Hotels hotels;
	
	public void addHotels(Hotels hotels) {
		hotel.add(hotels);
	}
	
	
    public String findCheapestHotel(LocalDate first, LocalDate second){
        ArrayList<LocalDate> dateArr = new ArrayList<LocalDate>(3);

        dateArr.add(first);
        long NoOFDays = ChronoUnit.DAYS.between(first,second);

        while (NoOFDays>0){
        	dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
            NoOFDays--;
        }
        
        Integer[] price ={0,0,0};
        for (int i=0; i<dateArr.size(); i++){
            for (int j=0; j<hotel.size(); j++) {

                if (dateArr.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY) || dateArr.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                    price[j] += hotel.get(j).hotelRates.get(CustomerType.REGULAR).weekEnd;
                }
                else
                    price[j] += hotel.get(j).hotelRates.get(CustomerType.REGULAR).weekDay;
            }
        }

       Integer rate = Arrays.asList(price).indexOf(Collections.min(Arrays.asList(price)));
       System.out.println("Cheapest hotel is  " + hotel.get(rate).hotelName + " Rate : "+ price[rate]);
       
       return hotel.get(rate).hotelName;
    }
    
	
}