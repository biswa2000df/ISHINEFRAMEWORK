package com.Ishine.testcase;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ishine.base.TestBase;
import com.ishine.pages.Ishinepage;
import com.ishine.pages.OtpBoxPage;
import com.ishine.pages.SignInPage;
import com.ishine.utils.ActionKeywords;
import com.ishine.utils.TestUtils;

public class OTPtest extends TestBase {

	public OTPtest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Ishinepage ishinePage;
	TestUtils testUtils;
	SignInPage signInPage;
	OtpBoxPage otpPage;
	ActionKeywords actionKeywords;

	@BeforeTest
	public void setUp() throws IOException {
		InitializeBrowser();
		ishinePage = new Ishinepage();
		testUtils = new TestUtils();
		signInPage = new SignInPage();
		otpPage = new OtpBoxPage();
		actionKeywords = new ActionKeywords();

	}

	@Test
	public void CheckTheOTPBox() throws IOException {
		testUtils.extentReport();
		testUtils.testCaseCreate("Tc_03");
		try {
			if (ishinePage.CheckIshineImg())
				testUtils.passTestCase("Ishine page  is display");
		} catch (Exception e) {
			testUtils.failTestCase("Ishine page is not display");
		}
		signInPage.enterUseranme();
		signInPage.enterPassword();
		try {
			if(signInPage.signInBtn()) {
				testUtils.passTestCase("SignIn Page is display");
				signInPage.signInbtnClick();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			testUtils.failTestCase("SignIn Page is not display");
		}
		
		
		//OtpBox======
		
		try {
			if(otpPage.checkOtpBox()) {
				otpPage.OtpEntered();
				testUtils.passTestCase("OTP Box is display properly");
				otpPage.clickConfromBtn();
				
			}
		} catch (Exception e) {
			testUtils.failTestCase("OTP box is not display properly");
		}
		
		
		
		
		
		

	}

	@AfterTest
	public void tearDown() {
		testUtils.ExtentFlush();
		driver.quit();
	}

}
