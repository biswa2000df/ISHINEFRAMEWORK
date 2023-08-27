package com.ishine.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ishine.base.TestBase;
import com.ishine.utils.ActionKeywords;

public class HomePage extends TestBase{

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@title=\"Home\"]")
	WebElement homePage;
	
	
	@FindBy(xpath="//*[@class=\"sidenav-link-icon fa-gear fa-solid\"]")
	WebElement SettingBtn;
	
	
	
	
	public boolean CheckHomePage() {
		return ActionKeywords.isDisplay(homePage);
	}
	
	
	public void ClickOnsettingBtn() {
		ActionKeywords.clickElement(SettingBtn);
	}
	
	
	

}
