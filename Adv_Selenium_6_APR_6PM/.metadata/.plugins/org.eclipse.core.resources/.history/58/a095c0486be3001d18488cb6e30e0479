package com.nareshit.maven_selenium.pageUI;

import static org.testng.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nareshit.maven_selenium.basepage.BasePage;


public class Registration extends BasePage{
	
	public static Logger log = Logger.getLogger(Registration.class.getName());
	
	//@FindBy(linkText = "HMS") WebElement linkHMS;
	@FindBy(name = "username") WebElement txtusername;
	@FindBy(name = "password") WebElement txtpassword;
	@FindBy(name = "submi") WebElement btnlogin;
	@FindBy(linkText = "Registration") WebElement linkregistration;
	@FindBy(linkText = "Perminent Registration") WebElement linkperminentregistration;
	@FindBy(xpath = "//span[text()='Permanent Registration ']") WebElement txtPR;
	@FindBy(name = "PATIENT_CAT") WebElement ddpatientcat;
	@FindBy(name = "RELATION") WebElement ddrelation;
	@FindBy(name = "TITLE") WebElement ddtitle;
	@FindBy(name = "PNT_NAME") WebElement txtfirstname;
	@FindBy(name = "LAST_NAME") WebElement txtlastname;
	@FindBy(name = "PAT_IDENTITY") WebElement ddpatientident;
	@FindBy(name = "PAT_IDENTITY_PROOF") WebElement txtpatienid;
	@FindBy(name = "DOB") WebElement datedob;
	@FindBy(name = "AGE") WebElement txtage;
	@FindBy(name = "EMAIL_ID") WebElement txtemail;
	@FindBy(name = "image") WebElement btnupload;
	
	
	
	public Registration(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login() throws Exception{
		//linkHMS.click();
		//log.info("Clicked on  HMS link with object:" + linkHMS.toString());
		txtusername.sendKeys(getData("username"));
		log.info("Entering username with object:" + txtusername.toString());
		txtpassword.sendKeys(getData("password"));
		log.info("Entering password with object:" + txtpassword.toString());
		btnlogin.click();
		log.info("Clicking on login button with object:" + btnlogin.toString());
	}

	public void registration() {
		linkregistration.click();
		log.info("Clicked on  Registration link with object:" + linkregistration.toString());
		linkperminentregistration.click();
		log.info("Clicked on  Perminant Registration link with object:" + linkperminentregistration.toString());
	}
	
	public void pr() throws Exception {
		assertEquals(txtPR.getText(), "Permanent Registration");
		log.info("Verifying PR page by using object:"+txtPR.toString());
		ddpatientcat.sendKeys("Self");
		log.info("Selecting a value from Patient Category dropdown by using object:"+ddpatientcat.toString());
		ddrelation.sendKeys("Brother");
		log.info("Selecting a value from relation dropdown by using object:"+ddrelation.toString());
		ddtitle.sendKeys("Mr.");
		log.info("Selecting a value from title Category dropdown by using object:"+ddtitle.toString());
		txtfirstname.sendKeys("Mahesh");
		log.info("Entering firstname by using object:"+txtfirstname.toString());
		txtlastname.sendKeys("D");
		log.info("Entering lastname by using object:"+txtlastname.toString());
		ddpatientident.sendKeys("AAdhar Card");
		txtpatienid.sendKeys("12345678");
		datedob.sendKeys("10-10-1990");
		txtage.sendKeys("12");
		txtemail.sendKeys(getData("firstname")+getData("lastname")+randomNumber()+getData("domainname"));
		//btnupload.sendKeys("D:\\Images\\sunny2.jpg");
	}

}
