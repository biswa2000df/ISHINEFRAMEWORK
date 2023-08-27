package com.Ishine.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.ishine.base.TestBase;
import com.ishine.pages.Ishinepage;
import com.ishine.utils.TestUtils;

public class IshinePageDisplayTest extends TestBase {

	public IshinePageDisplayTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Ishinepage ishinePage;
	TestUtils testUtils;

	@BeforeTest
	public void setUp() throws IOException {
		InitializeBrowser();
		ishinePage = new Ishinepage();
		testUtils = new TestUtils();

	}

	@Test
	public void checkIshineImage() throws IOException {
		String Status;
		testUtils.extentReport();
		testUtils.testCaseCreate("Tc_01");
		
		testUtils.WriteCSVFile("SI No.", "TestCase No." , "Status" , "Page Description");

		try {
			if (ishinePage.CheckIshineImg()) {

				Status = "PASS";

				testUtils.WriteCSVFile("01", "Tc_01", Status , "Ishine page  is display");

				testUtils.passTestCase("Ishine page  is display");
			}
		} catch (Exception e) {
			
			Status ="FAIL";
			testUtils.WriteCSVFile("01", "Tc_01", Status , "Ishine page  is not display");
			testUtils.failTestCase("Ishine page is not display");
		}
	

	}

	@AfterTest
	public void tearDown() throws IOException {
//		testUtils.CsvWriterClose();
		testUtils.ExtentFlush();
		driver.quit();
	}

}
