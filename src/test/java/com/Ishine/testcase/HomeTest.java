package com.Ishine.testcase;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ishine.base.TestBase;
import com.ishine.pages.HomePage;
import com.ishine.pages.Ishinepage;
import com.ishine.pages.OtpBoxPage;
import com.ishine.pages.SignInPage;
import com.ishine.utils.ActionKeywords;
import com.ishine.utils.TestUtils;

public class HomeTest extends TestBase {

	public HomeTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Ishinepage ishinePage;
	TestUtils testUtils;
	SignInPage signInPage;
	OtpBoxPage otpPage;
	ActionKeywords actionKeywords;
	HomePage homePage;

	@BeforeTest
	public void setUp() throws IOException {
		InitializeBrowser();
		ishinePage = new Ishinepage();
		testUtils = new TestUtils();
		signInPage = new SignInPage();
		otpPage = new OtpBoxPage();
		actionKeywords = new ActionKeywords();
		homePage=new HomePage();

	}

	@Test
	public void CheckTheHomePage() throws IOException {
		testUtils.extentReport();
		
		String Statu;
		
		testUtils.CsvFileCreate();
		
		testUtils.WriteCSVFile("SI No.", "TestCase No." , "Status" , "Page Description");
		
		testUtils.testCaseCreate("Tc_01");
		
		try {
			if (ishinePage.CheckIshineImg()) {
				
				Statu = "PASS";
				testUtils.WriteCSVFile("01", "Tc_01", Statu , "Ishine page  is display");
				testUtils.passTestCase("Ishine page  is display");
			}
		} catch (Exception e) {
			
			Statu="FAIL";
			testUtils.WriteCSVFile("01", "Tc_01", Statu , "Ishine page  is not display");
			
			testUtils.failTestCase("Ishine page is not display");
		}
		signInPage.enterUseranme();
		TestUtils.test.log(Status.INFO, "Enter UserName");
		signInPage.enterPassword();
		TestUtils.test.log(Status.INFO, "Enter PassWord");
		try {
			if (signInPage.signInBtn()) {
				Statu = "PASS";
				testUtils.WriteCSVFile("02", "Tc_02", Statu , "SignIn Page is display");
				testUtils.testCaseCreate("Tc_02");
				testUtils.passTestCase("SignIn Page is display");
				signInPage.signInbtnClick();
				TestUtils.test.log(Status.INFO, "Click on Sign Button");
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			Statu="FAIL";
			testUtils.WriteCSVFile("02", "Tc_02", Statu , "SignIn Page is not display");
			testUtils.failTestCase("SignIn Page is not display");
		}

		// OtpBox======

		try {
			if (otpPage.checkOtpBox()) {
				Statu = "PASS";
				testUtils.WriteCSVFile("03", "Tc_03", Statu , "OTP Box is display properly");
				testUtils.testCaseCreate("Tc_03");
				otpPage.OtpEntered();
				TestUtils.test.log(Status.INFO, "Enter OTP");
				testUtils.passTestCase("OTP Box is display properly");
				otpPage.clickConfromBtn();
				TestUtils.test.log(Status.INFO, "Click on Conform Button");

			}
		} catch (Exception e) {
			Statu="FAIL";
			System.out.println("Status Is == "+Statu);
			testUtils.WriteCSVFile("03", "Tc_03", Statu , "OTP box is not display properly");
			testUtils.failTestCase("OTP box is not display properly");
		}
		
		
		//HOmePage====================
		
		try {
			if(homePage.CheckHomePage()) {
				Statu = "PASS";
				testUtils.WriteCSVFile("04", "Tc_04", Statu , "HomePage is Display");
				testUtils.testCaseCreate("Tc_04");
				testUtils.passTestCase("HomePage is Display");
//				Thread.sleep(3000);
//				homePage.ClickOnsettingBtn();
//				TestUtils.test.log(Status.INFO, "Click on Setting Button");
			}
			
		} catch (Exception e) {
			Statu="FAIL";
			testUtils.WriteCSVFile("04", "Tc_04", Statu , "HomePage is not Display");
		testUtils.failTestCase("HomePage is not Display");
		}

	}

	@AfterTest
	public void tearDown() {
		testUtils.ExtentFlush();
		driver.quit();
	}

}
