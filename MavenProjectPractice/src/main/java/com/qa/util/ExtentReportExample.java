package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportExample {
	public WebDriver driver;
	public ExtentHtmlReporter htmlReport;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void extentSet() {
		//"user.dir" -- it gives project home dirctory
		//Specify the location where extent report stored
		htmlReport=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		
		//Title of the Report
		htmlReport.config().setDocumentTitle("Automation Report");
		
		//Name of the report
		htmlReport.config().setReportName("Functional Report");
		
		//Set theme for report
		htmlReport.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		
		//Attach html report
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("Host Name", "Localhost");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Tester Name", "Rao");
		extent.setSystemInfo("Browser", "Chrome");
	}
		
		@AfterTest
		public void endReport() {
			
			//Flush method will clear the memory
			//Flushing the Report
			extent.flush();
		}
		
		@BeforeMethod
		public void setUp() {
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://demo.nopcommerce.com");
		}
		
		@Test
		public void noComTitleTest() {
			//create test case entry in the report
			//Main node
			test=extent.createTest("noComTitleTest");
			Assert.assertEquals(driver.getTitle(), "no commerce demo store");
		}
		
		@Test
		public void noComLogoTest() {
			//if Two sub nodes are passed then only main node is passed
			//create test case entry in the report
			test=extent.createTest("noComLogoTest");
			
			//creating sub node under test method name(Main node)-noComLogoTest() 
			test.createNode("Login with valid input");
			Assert.assertTrue(true);
			
			//creating sub node under test method name-noComLogoTest() 
			test.createNode("Login with Invalid input");
			Assert.assertTrue(true);
		}
	
		@AfterMethod
		//result object-- Have status of Test Cases pass or Fail or Skipped
		//result object-- Have result of previous Test method executed
		public void tearDown(ITestResult result) {
			if(result.getStatus()==ITestResult.FAILURE) {
				test.log(Status.FAIL,"TEST CASE FAILED IS"+result.getName()); //add method name in Extent Report
				test.log(Status.FAIL, "TEST CASE FAILEDIS"+result.getThrowable()); // add exception/error in Report
				
				String screenshotpath=ExtentReportExample.getScreenshot(driver,result.getName());
				try {
					test.addScreenCaptureFromPath(screenshotpath);  //adding screenshot
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(result.getStatus()==ITestResult.SKIP) {
				test.log(Status.SKIP,"TEST CASE SKIPPED IS"+result.getName());
				}
			else if(result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS,"TEST CASE PASSED IS"+result.getName());
			}
			driver.close();
		}
		
		//capture Screenshot
		public static String getScreenshot(WebDriver driver, String screenshotName) {
			/*DateFormat dateName=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
			Date currentDate=new Date();
			dateName.format(currentDate);  */
			
			String dateName=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			String destination=System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+"-"+dateName+".png";
			File finalDestination=new File(destination);
			//FileUtils.copyFile(source,finalDestination);
			try {
				FileHandler.copy(source,finalDestination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return destination;
		}
	
	
	
	
	
	
	
	
	
	
}
