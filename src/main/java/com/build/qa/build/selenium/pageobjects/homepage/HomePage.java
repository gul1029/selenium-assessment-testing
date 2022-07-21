package com.build.qa.build.selenium.pageobjects.homepage;

import com.build.qa.build.selenium.pageobjects.FunctionPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(css = "#wrapper.homepage")
	WebElement homePageWrapper;

	@FindBy(css = "#react-type-ahead-normal > fieldset > input")
	WebElement searchBar;
	FunctionPage functionPage;


	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		functionPage=new FunctionPage(driver);
	}

	public boolean onHomePage() {
		functionPage.waitUntilElementIsVisbilt(homePageWrapper);
		return homePageWrapper.isDisplayed();
	}

	public void onSearchBar(String item) {
		searchBar.sendKeys(item);
		searchBar.sendKeys(Keys.ENTER);
	}
}
