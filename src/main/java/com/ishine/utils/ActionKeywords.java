package com.ishine.utils;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ishine.base.TestBase;

public class ActionKeywords{
	
	
	
	

	public static boolean isDisplay(WebElement ele) {	
		return ele.isDisplayed();	
	}
	
	public static void clickElement(WebElement ele) {
		ele.click();
	}
	
	public static void sendKeysElement(WebElement ele, String element) {
		ele.sendKeys(element);
	}

}
