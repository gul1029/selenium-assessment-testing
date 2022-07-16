package com.build.qa.build.selenium.pageobjects.homepage;

import com.build.qa.build.selenium.pageobjects.ProductPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class HomePage extends BasePage {
	
	private By homePageWrapper;
	WebElement searchBar;
	
	public HomePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		homePageWrapper = By.cssSelector("#wrapper.homepage");
		searchBar = driver.findElement(By.cssSelector("#react-type-ahead-normal > fieldset > input"));
	}

	public boolean onHomePage() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(homePageWrapper)) != null;
	}

	public void onSearchBar(String item) {
		searchBar.sendKeys(item);
		searchBar.sendKeys(Keys.ENTER);
	}
}
