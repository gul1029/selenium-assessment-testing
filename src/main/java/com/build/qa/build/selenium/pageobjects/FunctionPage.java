package com.build.qa.build.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionPage {
	public WebDriver driver;
	int timeout=30;
	public FunctionPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void waitUntilElementIsVisbilt(WebElement element)
	{
		WebDriverWait webDriverWait=new WebDriverWait(driver,timeout);
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
	}
}

