package testNG_Log4j_Practice;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestNG2 {
	@BeforeGroups
	public void m() {
		System.out.println("@@BeforeGroups This is Groups Test Case");
	}
	@AfterGroups
	public void m82() {
		System.out.println("@@AfterGroups This is Groups  Test Case");
	}
	@Test
	public void m4() {
		System.out.println("This is m4 Test Case");
		Assert.assertEquals("nara", "nara1");
	}
	//@Test(dependsOnMethods= {"m4"},alwaysRun=true)
	@Test(groups="sanity")
	public void m5() {
		System.out.println("This is m5 Test Case");
		
	}
	@Test(groups="sanity")
	public void m6() {
		System.out.println("This is m6 Test Case");
	}

}
