package com.nareshit.selenium_maven.testNG;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class PrintAllRadioBT_Properties {

	public WebDriver driver;

	@Test
	public void f() throws Exception {
		WebElement tableloc = driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		for (int k = 1; k < 3; k++) {
			List<WebElement> radio1 = tableloc.findElements(By.name("group" + k));
			for (int i = 0; i < radio1.size(); i++) {
				radio1.get(i).click();
				for (int j = 0; j < radio1.size(); j++) {
					System.out.println(
							radio1.get(j).getAttribute("value") + "-----" + radio1.get(j).getAttribute("checked"));
					Thread.sleep(2000);
				}
			}
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
