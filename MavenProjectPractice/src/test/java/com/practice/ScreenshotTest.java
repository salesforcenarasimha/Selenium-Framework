package com.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class ScreenshotTest extends BaseClass{
	//create PageFactory Object repository
			@FindBy(xpath="//input[@name=\"email\"]")
			WebElement username;
			
			@FindBy(xpath="//input[@name=\"password\"]")
			WebElement password;
			
			@FindBy(xpath="//div[@class=\"ui fluid large blue submit button\"]")
			WebElement loginBtn;
			
			@FindBy(xpath="//a[contains(text(),'Sign Up')]")
			WebElement sinnUpBtn;
			
			@FindBy(xpath="//div[contains(text(),'No Account? Registration takes only a few seconds?')]")
			WebElement noAccountText;
			
			//to initialize web elements/page objects with driver object using initE method 
			//this-it points current class object 
			//we can also pass LoginPage.class instead of this keyword
			public ScreenshotTest() {
				startApp();
				PageFactory.initElements(driver, this);
			}
			
			public String validateLoginPageTitle() {
				return driver.getTitle();
			}
			
			public boolean validateNoAccountText() {
				return noAccountText.isDisplayed();
			}
			
			public void login() {
				username.sendKeys("snr6775@gmail.comm");
				password.sendKeys("Snr@67751");
				loginBtn.click();
				 System.out.print("Good....*88888888888888888");
			}
			@Test(priority=1)
			public void loginTest() {
				login();
				driver.quit();
			}
			
			@AfterMethod
			public void screenShot(ITestResult result) {
				
					if(result.getStatus()==ITestResult.FAILURE) {
						CaptureScreenShot.captureScreenshot(driver);
					}
				
			}
			

}
