package com.crm.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;

public class NewContactsPage extends TestBase {

	@FindBy(xpath = "//*[@name='title']")
	WebElement tittle;
	
	@FindBy(id="first_name")
	WebElement firstName;

	@FindBy(id="middle_initial")
	WebElement middleName;
	
	@FindBy(id="surname")
	WebElement lastName;  
		
	@FindBy(xpath="//*[@name='receive_sms' and @value='Y']")
	WebElement receiveSmsYes;
	
	@FindBy(xpath="//*[@name='receive_sms' and @value='N']")
	WebElement receiveSmsNo;
	
	@FindBy(xpath = "//*[@align=\"center\" and @colspan=\"2\"]//input[@value=\"Save\"]")
	WebElement save;
	
	@FindBy(xpath="//*[@onclick=\"javascript:lookup('CLIENT', 'contactForm' , this.form.client_lookup.value);\"]")
	WebElement companyLookup;
	
// Initializing the Page Objects:
	public NewContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String tittle, String firstName, String middleName, String lastName, String receiveSms){
		
		Select select = new Select(this.tittle);
		select.selectByVisibleText(tittle);
		
		this.firstName.sendKeys(firstName);
		this.middleName.sendKeys(middleName);
		this.lastName.sendKeys(lastName);
		if(receiveSms=="Yes")
		{
			receiveSmsYes.click();
		}
		else
		{
			receiveSmsNo.click();
		}
		save.click();
		
	}
	
	public void clickOncontactLookUp()
	{
		String currentWindow = driver.getWindowHandle();
		System.out.println(currentWindow);
		companyLookup.click();
		//String newCurrentWindow = driver.getWindowHandle();
		//System.out.println(newCurrentWindow);
		Set<String> windows = driver.getWindowHandles();
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		//Iterator<String> iterator = windows.iterator(); 
		//System.out.println(windows.size());
		/*while(iterator.hasNext())
		{
		System.out.println(windows);	
		}*/
		/*while(String s = iterator.hasNext())
		{
			if(currentWindow!=newCurrentWindow)
			{
				driver.switchTo().window(newCurrentWindow);
				
			}
		}*/
		
		
	}
}
	