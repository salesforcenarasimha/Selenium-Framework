package testNG_Log4j_Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng3 extends BaseTestng {
	
	
	@Test
	public void m10() {
		System.out.println("@Test This is m10 Test Case=========");
	}
	
	@Test(groups="sanity")
	public void m11() {
		System.out.println("@Test This is m11 Test Case=========");
	}
	
	
	@BeforeMethod
	public void m15() {
		System.out.println("@BeforeMethod This is m15 Test Case");
	}
	@AfterMethod
	public void m16() {
		System.out.println("@AfterMethod This is m16 Test Case");
	}
	

}
