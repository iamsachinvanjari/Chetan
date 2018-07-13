package com.crm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;/*
	public static ExtentTest test;
	public static ExtentReports extent;*/
	
	public TestBase() {
		prop = new Properties();
		System.out.println("browserName");
		String path ="C:\\Users\\CRC\\eclipse-workspace\\freeCRM\\src\\main\\java\\com\\crm\\config\\config.properties";
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Users\\CRC\\eclipse-workspace\\freeCRM\\src\\main\\java\\com\\crm\\config\\config.properties");
			
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
public static void initilization()
{
	String browserName = prop.getProperty("browserName");
	System.out.println(browserName);
	/*
	extent = new ExtentReports ("C:\\Users\\CRC\\eclipse-workspace\\freeCRM\\src\\main\\java\\com\\crm\\reports\\freeCRM_Reports.html", false);
	extent.addSystemInfo("Platform","Windows8.1");
	extent.addSystemInfo("Website", "Free CRM");
	extent.addSystemInfo("User", "Chetan Chopade");
	extent.addSystemInfo("Testing Type", "Functional Testing");
	extent.loadConfig(new File("C:\\Users\\CRC\\eclipse-workspace\\freeCRM\\extent_config.xml"));
	*//*if(browserName=="firefox") {
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium Material\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	     driver= new FirefoxDriver();
	     test.log(LogStatus.PASS, "Firefox launched successfully");
	     } else */ //if(browserName=="Chrome") {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Material\\chromedriver_win32 (2)\\chromedriver.exe");
		driver= new ChromeDriver();
	/*	test.log(LogStatus.PASS,"Google Chrome browser launched successfully");
//	*///}
	driver.get("https://www.freecrm.com/index.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(com.crm.util.TestUtil.implicit_Timeout,TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();	
	}
}
