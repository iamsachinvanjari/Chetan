package com.crm.tests;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;


public class LoginPageTest extends TestBase{
	LoginPage IndexPage;
	HomePage homePage;
	
	public LoginPageTest() throws Exception{
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initilization();
		try {
			IndexPage = new LoginPage();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = IndexPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = IndexPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage = IndexPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
