package com.bridgelabz.hotelreservation;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class HotelsTest {

	Hotels lw, bw, rw;
	
	@Test
	public void addHotels() {
		
		HashMap<CustomerType, Rates> rate = new HashMap<CustomerType,Rates>();
		rate.put(CustomerType.REGULAR, new Rates(110,90));
		rate.put(CustomerType.REWARD, new Rates(80,80));
		lw = new Hotels("LakeWood",3,rate);
		lw.addHotels(lw);
		
		rate = new HashMap<>();
		rate.put(CustomerType.REGULAR, new Rates(160,60));
		rate.put(CustomerType.REWARD, new Rates(110,50));
		bw = new Hotels("BridgeWood",4,rate);
		bw.addHotels(bw);
		
		rate = new HashMap<>();
		rate.put(CustomerType.REGULAR, new Rates(220,150));
		rate.put(CustomerType.REWARD, new Rates(100,40));
		rw = new Hotels("RidgeWood",5,rate);
		rw.addHotels(rw);
		
		int size = lw.size();
		size += bw.size();
		size += rw.size();
		assertEquals(3, size);

	}
	
}
