package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class CompanyLookUpPage extends TestBase{

	@FindBy(xpath = "//*[@type='submit']")
	WebElement search;

	public WebElement getSearch() {
		return search;
	}

	public void setSearch(WebElement search) {
		this.search = search;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public void setSearchBox(WebElement searchBox) {
		this.searchBox = searchBox;
	}
	@FindBy(xpath = "//*[@id='search']")
	WebElement searchBox;
	
	public CompanyLookUpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void putValueForSearch(String search_value)
	{
		searchBox.sendKeys(search_value);
	}
	public void clickOnSearch()
	{
		search.click();
	}
}
