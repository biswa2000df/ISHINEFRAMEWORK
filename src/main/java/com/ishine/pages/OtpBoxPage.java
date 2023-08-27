package com.ishine.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ishine.base.TestBase;
import com.ishine.utils.ActionKeywords;

public class OtpBoxPage extends TestBase{

	public OtpBoxPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	ActionKeywords actionKeywords=new ActionKeywords();
	
	@FindBy(xpath="//*[@placeholder=\"Enter OTP\"]")
	WebElement EnterOtp;
	
	@FindBy(xpath="//*[contains(text(),'Confirm')]")
	WebElement clickConformBtn;
	
	
	public boolean checkOtpBox() {
		return actionKeywords.isDisplay(EnterOtp);
	}
	
	public void OtpEntered() {
		actionKeywords.sendKeysElement(EnterOtp , prop.getProperty("OTP"));
	}
	
	
	
	public void clickConfromBtn() {
		actionKeywords.clickElement(clickConformBtn);
	}
	
	
	

}
