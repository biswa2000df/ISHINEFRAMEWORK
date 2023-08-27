package com.ishine.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ishine.base.TestBase;
import com.opencsv.CSVWriter;

public class TestUtils extends TestBase {

	public ExtentHtmlReporter htmlReport;
	public static ExtentReports extent;
	public static ExtentTest test;
	static String year;
	static String time;
	static CSVWriter cw;

	public TestUtils() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long pageloadtime = 20;
	public static long implicitywait = 20;

	public String takeScreenShot() throws IOException {
		Date date = new Date();
		SimpleDateFormat tm = new SimpleDateFormat("yyyy-MM-dd");
		year = tm.format(date);
		SimpleDateFormat tm1 = new SimpleDateFormat("hh:mm:ss");
		time = tm1.format(date);

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir") + "/Screenshot" + "/" + year + "/" + time + ".png";
		FileUtils.copyFile(srcFile, new File(destFile));
		return destFile;
	}

	public void ScreenshotPathFormat() {
		Date date = new Date();
		SimpleDateFormat tm = new SimpleDateFormat("yyyy-MM-dd");
		year = tm.format(date);
		SimpleDateFormat tm1 = new SimpleDateFormat("hh:mm:ss");
		time = tm1.format(date);
	}

	public void extentReport() throws IOException {
		ScreenshotPathFormat();
		String path = System.getProperty("user.dir") + "/REPORT_ISHINE";
		String finalPath = path + "/" + year + "/";
		new File(finalPath).mkdirs();
		htmlReport = new ExtentHtmlReporter(finalPath + time + ".html");

		htmlReport.config().setDocumentTitle("Automation Report");// Title of the report
		htmlReport.config().setReportName("Functional Report");// Name of the report
		htmlReport.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.setSystemInfo("Comapny Name", "APMOSYS");
		extent.setSystemInfo("Project Name", "ISHINE");
		extent.setSystemInfo("Test Lead", "Prabhat Padhy");
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("OS", "Window11");
		extent.setSystemInfo("Tester Name", "Biswajit");
		extent.setSystemInfo("Browser", "Chrome");
		
		
		CsvFileCreate();//call  the csv file create
		
		

	}

	public void testCaseCreate(String tc) {
		test = extent.createTest(tc);
	}

	public void passTestCase(String passDesc) throws IOException {
		test.log(Status.INFO, MarkupHelper.createLabel(passDesc, ExtentColor.GREEN));
		test.log(Status.PASS, "", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
	}

	public void failTestCase(String failDesc) throws IOException {
		test.log(Status.INFO, MarkupHelper.createLabel(failDesc, ExtentColor.RED));
		test.log(Status.FAIL, "", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
	}

	public void ExtentFlush() {
		extent.flush();
	}

	// Write the pass and failed testcass
//	FileWriter fileWriter;
	String csvFile = "students.csv";
	static String destFile;
	public static void CsvFileCreate() throws IOException {
			
		Date date = new Date();
		SimpleDateFormat tm = new SimpleDateFormat("yyyy-MM-dd");
		year = tm.format(date);
		SimpleDateFormat tm1 = new SimpleDateFormat("hh:mm:ss");
		time = tm1.format(date);
		destFile = System.getProperty("user.dir") + "/CSVFile" + "/" + year + "/" + time;
		new File(destFile).mkdirs();

	}

	public void WriteCSVFile(String ID, String Name, String Status, String Pages_Description) throws IOException {

		FileWriter	fileWriter=new FileWriter(destFile + "/" + csvFile, true);
		CSVWriter cw = new CSVWriter(fileWriter);
		String line1[] = { ID, Name, Status, Pages_Description };

		// Writing data to the csv file
		cw.writeNext(line1);
		// close the file
		cw.close();
	}


}
