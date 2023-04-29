package com.nareshit.selenium_maven.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFile_AutoIT {

	public WebDriver driver;

	@Test
	public void f() throws Exception {
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Perminent Registration")).click();
		driver.findElement(By.name("PATIENT_CAT")).sendKeys("Self");
		driver.findElement(By.name("PNT_NAME")).sendKeys("Mahesh");
		Thread.sleep(12000);
		//driver.findElement(By.cssSelector("input.photo")).sendKeys(Keys.ENTER);
		Runtime.getRuntime().exec("C:\\Users\\mahesh\\Desktop\\upload.exe");
	}

	@BeforeTest
	public void beforeTest() {
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);*/
		driver = new EdgeDriver();
		driver.get("http://seleniumbymahesh.com/HMS");
		driver.manage().window().maximize();
	}

}
