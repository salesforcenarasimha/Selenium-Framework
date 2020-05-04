package com.practice;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenShot {
public static void captureScreenshot(WebDriver driver) {
		
		//capture screenshot as file type in src object
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//In order to Store screenshot as file type  and specify the location
		try {
			System.out.println("-----------------");
			FileHandler.copy(src,new File("./ScreenShots/ProjectName"+getCurrentDateTime()+".png"));
		} catch (IOException e) {
			
			System.out.println("unable to take screenshot "+e.getMessage());
		}
	}
	

	public static String getCurrentDateTime() {
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
	}
	//@AfterMethod
	/*public static void tearDownMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
		}
	} */


}
