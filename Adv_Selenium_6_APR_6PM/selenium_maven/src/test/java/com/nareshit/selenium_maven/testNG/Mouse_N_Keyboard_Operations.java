package com.nareshit.selenium_maven.testNG;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class Mouse_N_Keyboard_Operations {

	public WebDriver driver;

	@Test(enabled = false)
	public void drgNdrop() {
		Actions a = new Actions(driver);
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Avaibale frames:"+frames.size());
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		//a.dragAndDrop(drag, drop).build().perform();
		a.clickAndHold(drag).moveToElement(drop).release().build().perform();
	}
	
	@Test(enabled = false)
	public void rightClickOnElement() {
		Actions a = new Actions(driver);
		WebElement link = driver.findElement(By.linkText("Draggable"));
		a.contextClick(link).perform();
	}
	
	@Test
	public void slider() {
		driver.switchTo().frame(0);
		Actions a = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath("//div[@id='slider']/span"));
		//a.clickAndHold(drag).moveByOffset(100, 0).release().build().perform();
		a.dragAndDropBy(drag, 200, 0).perform();
	}

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
	}
}
