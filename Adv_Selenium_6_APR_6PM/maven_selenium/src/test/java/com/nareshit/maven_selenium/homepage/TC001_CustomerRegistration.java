package com.nareshit.maven_selenium.homepage;

import org.testng.annotations.Test;
import com.nareshit.maven_selenium.basepage.BasePage;
import com.nareshit.maven_selenium.pageUI.Registration;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TC001_CustomerRegistration extends BasePage {

	public static Logger log = Logger.getLogger(TC001_CustomerRegistration.class.getName());

	@Test(description = "This test case is to verify patient registration in HMS.")
	public void hmsPatientRegistration() throws Exception {
		log.info("*****Starting TC001_CustomerRegistration******");
		Registration reg = new Registration(driver);
		reg.login();
		reg.registration();
		reg.pr();
		log.info("*****End of TC001_CustomerRegistration******");
		log.info("*****End of TC001_CustomerRegistration******");//added one line
	}

	@Test
	public void verifyLogin() {
		System.out.println("VerifyLogin");
	}

	@BeforeClass
	public void beforeTest() throws Exception {
		browserLaunch(getData("browser"), getData("url"));
	}
	
	@AfterClass
	public void endTest() {
		closeBrowser();
	}

}






