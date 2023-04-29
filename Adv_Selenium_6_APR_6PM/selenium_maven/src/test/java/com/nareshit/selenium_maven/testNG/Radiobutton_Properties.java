package com.nareshit.selenium_maven.testNG;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class Radiobutton_Properties {

	public WebDriver driver;

	@Test
	public void radiobuttons() {
		WebElement tableloc = driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		List<WebElement> radio1 = tableloc.findElements(By.name("group1"));
		System.out.println("Available radio buttons in grop-1:" + radio1.size());
		for (int i = 0; i < radio1.size(); i++) {
			System.out.println(radio1.get(i).getAttribute("value") + "-----" + radio1.get(i).getAttribute("checked"));
		}
		List<WebElement> radio2 = tableloc.findElements(By.name("group2"));
		System.out.println("Available radio buttons in grop-2:" + radio2.size());
		for (int i = 0; i < radio2.size(); i++) {
			System.out.println(radio2.get(i).getAttribute("value") + "-----" + radio2.get(i).getAttribute("checked"));
		}
	}

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://echoecho.com/htmlforms10.htm");
		driver.manage().window().maximize();
	}

}
