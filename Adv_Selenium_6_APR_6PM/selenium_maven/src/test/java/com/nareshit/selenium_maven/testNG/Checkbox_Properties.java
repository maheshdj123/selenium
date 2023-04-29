package com.nareshit.selenium_maven.testNG;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class Checkbox_Properties {

	public WebDriver driver;

	@Test
	public void checkboxesProperties() throws Exception {
		List<WebElement> checkboxes = driver.findElements
				(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for (int i = 0; i < checkboxes.size(); i++) {
			System.out.println(
					checkboxes.get(i).getAttribute("value") + "----" + checkboxes.get(i).getAttribute("checked"));
			Thread.sleep(3000);
			if(!checkboxes.get(i).isSelected()) {
			checkboxes.get(i).click();
			}
		}
	}

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://echoecho.com/htmlforms09.htm");
		driver.manage().window().maximize();
	}

}
