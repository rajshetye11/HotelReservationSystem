package com.bridgelabz.hotelreservation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HotelsTest {

	Hotels h1;
	
	@Test
	public void addHotels() {
		h1 = new Hotels();
		h1.addHotels("LakeWood","3",110,80,90,80);
		h1.addHotels("BridgeWood","4",160,110,60,50);
		h1.addHotels("RidgeWood","5",220,100,150,40);
		int size = h1.size();
		assertEquals(3, size);

	}
}
