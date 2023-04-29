package com.nareshit.selenium_maven.testNG;

import org.testng.annotations.Test;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class CaptureScreenshot {

	public WebDriver driver;

	@Test(enabled = false)
	public void normalScreenshot() throws Exception {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\mahesh\\Desktop\\sbm.png"));
	}

	@Test(enabled = false)
	public void conditionBasedScreenshot() throws Exception {
		List<WebElement> links = driver.findElements(By.partialLinkText("New Batches"));
		System.out.println("Availbale links are:" + links.size());
		for (int i = 0; i < links.size(); i++) {
			System.out.println("Link Name:" + links.get(i).getText());
			links.get(i).click();
			Thread.sleep(5000);
		}
		if (!(links.size() == 0)) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\mahesh\\Desktop\\sbm.png"));
		}
	}

	@Test
	public void dateNtimeScreenshot() throws Exception {
		Date dt = new Date();
		DateFormat dtformat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\mahesh\\Desktop\\" + dtformat.format(dt) + "-sbm.png"));
	}

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("http://seleniumbymahesh.com");
		driver.manage().window().maximize();

	}
}
