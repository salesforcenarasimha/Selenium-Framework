package testNG_Log4j_Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTestng {

	@BeforeSuite
	public void m7() {
		System.out.println("@BeforeSuite This is m7 Test Case");
	}
	@BeforeClass
	public void m8() {
		System.out.println("@BeforeClass This is m8 Test Case");
	}
	@AfterTest
	public void m12() {
		System.out.println("@AfterTest This is m12 Test Case");
	}
	@BeforeTest
	public void m9() {
		System.out.println("@BeforeTest This is m9 Test Case");
	}
	@AfterClass
	public void m13() {
		System.out.println("@AfterClass This is m13 Test Case");
	}
	@AfterSuite
	public void m14() {
		System.out.println("@AfterSuite This is m14 Test Case");
	}
}
