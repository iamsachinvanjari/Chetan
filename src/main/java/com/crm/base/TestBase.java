package com.crm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.crm.reports.ExtentReportListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		prop = new Properties();
		String path ="C:\\Users\\CRC\\eclipse-workspace\\freeCRM\\src\\main\\java\\com\\crm\\config\\config.properties";
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Users\\CRC\\eclipse-workspace\\freeCRM\\src\\main\\java\\com\\crm\\config\\config.properties");
			
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
public static void initilization()
{
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
/*	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	
	ExtentTest test = extent.createTest("MyFirstTest");
*/	
	System.setProperty("webdriver.chrome.driver", "E:\\Selenium Material\\chromedriver_win32 (2)\\chromedriver.exe");
	driver= new ChromeDriver();
	/*	test.log(LogStatus.PASS,"Google Chrome browser launched successfully");
//	*///}
	driver.get("https://www.freecrm.com/index.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(com.crm.util.TestUtil.implicit_Timeout,TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();	
}
	protected void info(String message)
	{
		ExtentReportListener.test.get().info(message);
				
}
	protected void info(String message, File snap)
	{
	 
		try {
			ExtentReportListener.test.get().info(message,MediaEntityBuilder.createScreenCaptureFromPath(snap.getAbsolutePath()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
}
}

