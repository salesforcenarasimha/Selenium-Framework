package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void startApp() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://ui.freecrm.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
	}

}
