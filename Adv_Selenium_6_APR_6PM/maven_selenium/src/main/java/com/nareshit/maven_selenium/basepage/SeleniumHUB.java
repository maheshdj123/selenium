package com.nareshit.maven_selenium.basepage;

import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumHUB {

	public static void main(String[] args) throws Exception {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		ChromeOptions co = new ChromeOptions();
		co.merge(dc);
		String hubURL = "http://192.168.44.154:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(hubURL), dc);
		driver.get("http://seleniumbymahesh.com");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getTitle());
		System.out.println(driver.getTitle());//3-lines of code added in seleniumHUB class
		System.out.println(driver.getTitle());
	}

}
