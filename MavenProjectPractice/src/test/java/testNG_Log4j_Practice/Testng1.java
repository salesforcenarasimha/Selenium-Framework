package testNG_Log4j_Practice;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

public class Testng1 extends BaseTestng{
	
	Logger logger=Logger.getLogger("Testng1");
	
	
	@Test
	public void m1() {
		//For log4j.propperties file format use PropertyConfigurator
		 //PropertyConfigurator.configure("log4j.properties");
		
		//For xml file format use DOMConfigurator
		DOMConfigurator.configure("log4j.xml");
		 logger.info("m1 method started");
		System.out.println("This is m1 Test Case========");
	}
	@Test
	
	public void m2() {
		logger.info("m2 method started");
		System.out.println("This is m2 Test Case=======");
		logger.info("m1 method completed---");
	}
	@Test
	public void m3() {
		logger.info("m3 method started");
		System.out.println("This is m3 Test Case=======");
		logger.info("m3 method completed");
	}

}
