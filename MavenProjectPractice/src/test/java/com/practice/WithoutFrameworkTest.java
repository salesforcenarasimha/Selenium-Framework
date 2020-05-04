package com.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WithoutFrameworkTest {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://ui.freecrm.com/");
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
	  System.out.print("Good....996");
	  driver.quit();
  }
}
