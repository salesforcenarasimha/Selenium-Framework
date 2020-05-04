package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClassPro;

public class GmailPage extends BaseClassPro{
	//create PageFactory Object repository
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//span[@class='RveJvd snByac']")
	WebElement nextBtn;
	
	
	public GmailPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void login() {
		email.sendKeys("snr6775@gmail.com");
		nextBtn.click();
		password.sendKeys("snr..6775");
		//loginBtn.click();
		
	}

}
