package com.ishine.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ishine.utils.ActionKeywords;
import com.ishine.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException{	
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/ishine/config/configure.propertief");
		prop=new Properties();
		prop.load(fs);
	}
	
		
	public static void InitializeBrowser() throws IOException {
		TestUtils testUtils=new TestUtils();
		String browserName=prop.getProperty("BROWSER");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions option =new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(option);	
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option =new FirefoxOptions();
			option.addArguments("--remote-allow-origins=*");
			driver=new FirefoxDriver(option);	
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions option =new EdgeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver=new EdgeDriver(option);	
		}
		
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testUtils.pageloadtime,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtils.implicitywait,TimeUnit.SECONDS);	
	}

}
