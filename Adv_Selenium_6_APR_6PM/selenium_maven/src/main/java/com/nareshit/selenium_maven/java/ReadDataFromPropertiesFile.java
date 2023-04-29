package com.nareshit.selenium_maven.java;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReadDataFromPropertiesFile {

	public static String path = "./config.properties";

	public static String getData(String key) throws Exception {
		File f = new File(path);
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(f);
		p.load(fi);
		return p.getProperty(key);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getData("browser"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get(getData("prodURL"));
		driver.manage().window().maximize();
		driver.findElement(By.name(getData("usernameLoc"))).sendKeys(getData("username"));
		driver.findElement(By.name(getData("passwordLoc"))).sendKeys(getData("password"));
		driver.findElement(By.name(getData("loginLoc"))).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(getData("logoutLoc"))).click();
	}
}







