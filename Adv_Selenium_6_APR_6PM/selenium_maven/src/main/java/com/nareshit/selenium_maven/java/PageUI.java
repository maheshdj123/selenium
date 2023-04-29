package com.nareshit.selenium_maven.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageUI extends BasePage {
	
	@FindBy(linkText = "HMS") WebElement linkHMS;
	@FindBy(name = "username") WebElement txtusername;
	@FindBy(name = "password") WebElement txtpassword;
	@FindBy(name = "submit") WebElement btnlogin;
	@FindBy(linkText = "Logout") WebElement linklogout;
	
	public PageUI(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void hmsLogin() {
		linkHMS.click();
		txtusername.sendKeys("admin");
		txtpassword.sendKeys("admin");
		btnlogin.click();
	}
	
	public void hmsLogout() {
		linklogout.click();
	}

}
