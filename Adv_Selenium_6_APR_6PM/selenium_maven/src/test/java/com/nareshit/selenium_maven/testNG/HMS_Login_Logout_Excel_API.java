package com.nareshit.selenium_maven.testNG;

import org.testng.annotations.Test;
import com.nareshit.selenium_maven.java.Excel_API;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class HMS_Login_Logout_Excel_API {

	public WebDriver driver;

	@Test
	public void f() throws Exception {
		Excel_API e = new Excel_API("D:\\Workspaces\\Adv_Selenium_6_APR_6PM\\selenium_maven\\testdata\\login.xlsx");
		driver.findElement(By.name("username")).sendKeys(e.getCellData("Sheet1", 0, 1));
		driver.findElement(By.name("password")).sendKeys(e.getCellData("Sheet1", 1, 1));
		driver.findElement(By.name("submit")).click();
	}

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("http://seleniumbymahesh.com/HMS");
		driver.manage().window().maximize();
	}

}
