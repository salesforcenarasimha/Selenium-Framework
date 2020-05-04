package com.qa.listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test
	public void loginByEmail() {
		System.out.println("Login by Email");
		Assert.assertEquals("rao", "rao");
	}
	
	@Test
	public void loginByFacebook() {
		System.out.println("Login by Facebook");
		Assert.assertEquals("mohan", "mohan1");
	}
}
