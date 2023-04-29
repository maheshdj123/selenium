package com.nareshit.selenium_maven.testNG;

import org.testng.annotations.Test;
import com.nareshit.selenium_maven.java.BasePage;
import com.nareshit.selenium_maven.java.PageUI;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import org.testng.annotations.BeforeTest;

public class TC001_HMS_Login_Logout extends BasePage {

	public ATUTestRecorder recorder;

	@Test(description = "This test case is to verify login & logout in HMS")
	public void hmsLoginLogout() throws Exception {
		PageUI p = new PageUI(driver);
		p.hmsLogin();
		p.hmsLogout();
		recorder.stop();
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		recorder = new ATUTestRecorder("D:\\recordings", "HMSLogin", false);
		recorder.start();
		browserLaunch("chrome", "http://seleniumbymahesh.com");
	}
}
