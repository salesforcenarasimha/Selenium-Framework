package com.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.BaseClassPro;
import com.qa.pages.GmailPage;



public class GmailPageTest extends BaseClassPro {
	GmailPage gmailPage;
	BaseClassPro b;
	public GmailPageTest() {
		//super();
		gmailPage=new GmailPage();
		b=new BaseClassPro();
	}
	
	@BeforeMethod
	public void setup() {
		b.startApplication();
	}
	@Test(priority=1)
	public void gmailTitleTest() {
		System.out.println(gmailPage.validateLoginPageTitle());
		
		Assert.assertEquals(gmailPage.validateLoginPageTitle(),"Gmail","Title not matched");
	}
	
	@Test(priority=2,enabled=false)
	public void gmailLoginTest() {
		gmailPage.login();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
