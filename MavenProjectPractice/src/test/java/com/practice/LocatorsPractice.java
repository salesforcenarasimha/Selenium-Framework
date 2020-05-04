package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.facebook.com/");
			//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			System.out.println(driver.getTitle());
		  System.out.print("Good....===");
		  //driver.findElement(By.xpath("//input[starts-with(@id,'email')]")).sendKeys("hfhfgg@gmail.com");
		 //driver.findElement(By.xpath("//div[text()='Facebook helps you connect and share with the people in your life.']"));
		  driver.findElement(By.xpath("//input[@name='lastname']/following::input[1]")).sendKeys("gggggg");
		  Thread.sleep(1000);
		  driver.quit();

	}

}
