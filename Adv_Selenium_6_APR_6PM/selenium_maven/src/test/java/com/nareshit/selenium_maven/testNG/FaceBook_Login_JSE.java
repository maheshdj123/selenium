package com.nareshit.selenium_maven.testNG;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class FaceBook_Login_JSE {

	public WebDriver driver;

	@Test
	public void f() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('email').value='Mahesh'");
		js.executeScript("document.getElementById('pass').value='abc@123'");
		js.executeScript("document.getElementById('u_0_5_Ip').click()");
	}

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
	}
}
