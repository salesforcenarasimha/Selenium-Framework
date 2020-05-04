package com.DataDriven;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataFromExcel {

	
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.get("https://ui.freecrm.com/");
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData=TestUtil.getDataExcel();
		return testData.iterator();
	}

	@Test(dataProvider="getTestData")
	public void loginPageTest(String uname,String pwd) {
		// enter test data
		WebElement username = driver.findElement(By.xpath("//input[@name=\"email\"]"));
		username.clear();
		username.sendKeys(uname);
		
		WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		password.clear();
		password.sendKeys(pwd);

		WebElement loginBtn = driver.findElement(By.xpath("//div[@class=\"ui fluid large blue submit button\"]"));
		loginBtn.click();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
