package com.ishine.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ishine.base.TestBase;
import com.ishine.utils.ActionKeywords;

public class Ishinepage extends TestBase{

	public Ishinepage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='auth__logo']")
	WebElement ishineDisplay;
	
	ActionKeywords actionKeywords=new ActionKeywords();
	
	public boolean CheckIshineImg() {
		System.out.println("check is is work properly or not");
		return actionKeywords.isDisplay(ishineDisplay);
		
//		return ishineDisplay.isDisplayed();
	}
	

}
