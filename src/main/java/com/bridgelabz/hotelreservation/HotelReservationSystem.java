package com.bridgelabz.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

public class HotelReservationSystem {

	public ArrayList<Hotels> hotel = new ArrayList<>();
	public Hotels hotels;
	
	public void addHotels(Hotels hotels) {
		hotel.add(hotels);
	}
	
	Integer[] price ={0,0,0};
	Integer[] priceRewarded = {0,0,0};
	  
    public String findCheapestHotel(LocalDate first, LocalDate second){
        ArrayList<LocalDate> dateArr = new ArrayList<LocalDate>(3);

        dateArr.add(first);
        long NoOFDays = ChronoUnit.DAYS.between(first,second);

        while (NoOFDays>0){
        	dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
            NoOFDays--;
        }
        
      
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
    
    
    public String bestRatingCheapestHotel(LocalDate first, LocalDate second) {
    	Hotels[] hotelsList = new Hotels[3];
    	ArrayList<Integer> hotelRating = new ArrayList<>();
        ArrayList<LocalDate> dateArr = new ArrayList<LocalDate>();

        dateArr.add(first);
        long noOFDays = ChronoUnit.DAYS.between(first,second);

        while (noOFDays>0){
        	dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
            noOFDays--;
        }
                
        for (int i=0; i<dateArr.size(); i++){
            for (int j=0; j<hotel.size(); j++) {

                if (dateArr.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY) || dateArr.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                    price[j] += hotel.get(j).hotelRates.get(CustomerType.REGULAR).weekEnd;
                }
                else
                    price[j] += hotel.get(j).hotelRates.get(CustomerType.REGULAR).weekDay;
            }
        }
    	
    	for(int i=0; i<hotel.size(); i++) {
    		for(int j=0; j<price.length; j++) {
    			if(i != j) {
    				if(price[i].equals(price[j])) {
    					hotelsList[i] = hotel.get(i);
    				}
    			}
    		}
    	}
    	
       for(int i=0; i<hotelsList.length; i++) {
    	   if(hotelsList[i] != null) {
        	   hotelRating.add(hotel.get(i).rating);
    	   }
       }

       Integer rate = hotelRating.indexOf(Collections.max(hotelRating));
       System.out.println("Cheapest hotel with best Ratings: " + hotel.get(rate).hotelName + " Ratings: " +hotel.get(rate).rating+ " with total rates: " +price[rate]);
       return hotel.get(rate).hotelName;
    }
    
    public void bestRatedHotel(LocalDate first, LocalDate second) {
        ArrayList<Integer> hotelRating = new ArrayList<>();
        for (int i=0; i<hotel.size(); i++) {
     	   hotelRating.add(hotel.get(i).rating);
        }
        
        int n = hotelRating.indexOf(Collections.max(hotelRating));
        System.out.println("Best Rated hotel  " + hotel.get(n).hotelName + " Ratings : " +hotel.get(n).rating);
    } 


    public void cheapestHotelRewarded(LocalDate first, LocalDate second) {
    	Hotels[] hotelsReward = new Hotels[3];
    	ArrayList<Integer> hotelsRatingReward = new ArrayList<>();
        ArrayList<LocalDate> dateArr = new ArrayList<LocalDate>();

        dateArr.add(first);
        long noOFDays = ChronoUnit.DAYS.between(first,second);

        while (noOFDays>0){
        	dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
            noOFDays--;
        }
                
        for (int i=0; i<dateArr.size(); i++){
            for (int j=0; j<hotel.size(); j++) {

                if (dateArr.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY) || dateArr.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                	priceRewarded[j] += hotel.get(j).hotelRates.get(CustomerType.REWARD).weekEnd;
                }
                else
                	priceRewarded[j] += hotel.get(j).hotelRates.get(CustomerType.REWARD).weekDay;
            }
        }
        int rate = Arrays.asList(priceRewarded).indexOf(Collections.min(Arrays.asList(priceRewarded)));
       
    	
    	for(int i=0; i<hotel.size(); i++) {
    		for(int j=0; j<priceRewarded.length; j++) {
    			if(i != j) {   				
    				if(priceRewarded[i].equals(rate)) {
    					hotelsReward[i] = hotel.get(i);
    				}
    			}
    		}
    	}
    	
       for(int i=0; i<hotelsReward.length; i++) {
    	   if(hotelsReward[i] != null) {
    		   hotelsRatingReward.add(hotel.get(i).rating);
    	   }
       }
       
       if(hotelsReward[0] == null && hotelsReward[0] == null && hotelsReward[0] == null) {
    	   int n = rate;
    	   System.out.println("Cheapest hotel with best Ratings for Rewarded Customer : " + hotel.get(n).hotelName + " Ratings: " +hotel.get(n).rating+ "  Rates: " +priceRewarded[n]);
       }
       else {
           int n = hotelsRatingReward.indexOf(Collections.max(hotelsRatingReward));
           System.out.println("Cheapest hotel with best Ratings for Rewarded Customer: " + hotel.get(n).hotelName + " Ratings: " +hotel.get(n).rating+ " Ratess: " +priceRewarded[n]);
       }

       
    }
    
    public boolean validateInputDate (String date) throws HotelsException{
    	try {
    		Pattern p = Pattern.compile("((19|20)\\d\\d)-(0?[1-9]|1?[012])-(0?[1-9]|[12][0-9]|3[01])");
    		return p.matcher(date).matches();
    	}
    	catch(Exception e) {
    		throw new HotelsException("Invalid date");
    	}
    }
}