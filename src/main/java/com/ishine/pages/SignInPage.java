package com.ishine.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ishine.base.TestBase;
import com.ishine.utils.ActionKeywords;

public class SignInPage extends TestBase{

	public SignInPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	ActionKeywords actionKeywords=new ActionKeywords();
	
	@FindBy(xpath="//*[@placeholder=\"Enter Username\"]")
	WebElement enterUsername;
	
	public void enterUseranme() {
		actionKeywords.sendKeysElement(enterUsername, prop.getProperty("UserName"));
	}
	
	@FindBy(xpath="//*[@placeholder=\"Enter Password\"]")
	WebElement Password;
	
	public void enterPassword() {
		actionKeywords.sendKeysElement(Password, prop.getProperty("Password"));
	}
	
	//*[text()="SIGN IN"]
	
	@FindBy(xpath="//*[text()=\"SIGN IN\"]")
	WebElement SignInBtn;
	
	public boolean signInBtn() {
		return actionKeywords.isDisplay(SignInBtn);
	}
	
	public void signInbtnClick()
	{
		actionKeywords.clickElement(SignInBtn);
	}
	
	
	
	
	

}
