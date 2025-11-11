package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPojo;

public class FakeAddressUtility {
	
	public static void main(String[] args) {
		getFakeAddress();
		
	}
	public static AddressPojo getFakeAddress() {

		Faker faker = new Faker(Locale.US);
		
		
		AddressPojo addressPojo = new AddressPojo(faker.company().name(),
				faker.address().buildingNumber(), faker.address().streetAddress(), faker.address().city(), faker.address().zipCode(), faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), 
				"other info", "homeaddress", faker.address().state());
		
		return addressPojo;
		
	}

}
