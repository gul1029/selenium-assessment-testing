package com.build.qa.build.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class ProductPage extends BasePage {

    WebElement addToCart;
    WebElement cartButton;
    WebElement searchBar;

    public ProductPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
        onProductPage();
        searchBar = driver.findElement(By.cssSelector("#react-type-ahead-normal > fieldset > input"));
    }

    private void onProductPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#wrapper > main > div > div > div:nth-child(2) > div.col-lg-4.col-md-4 > div")));
    }

    public void addItemToCart() {
        addToCart = driver.findElement(By.cssSelector("#singleSkuForm > div.quantity__action > div.btn__group > input.btn__primary.js-add-to-cart"));
        addToCart.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("add__to__cart__success")));
    }

    public boolean clickCartButton() {
        cartButton = driver.findElement(By.cssSelector("#wrapper > header > div.header-container.container > div.header-details-user > ul > li.cart.i-cart > a"));
        cartButton.click();
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#wrapper > main > div > div:nth-child(6) > div > h1"))) != null;
    }

    public void searchForItem(String item) {
        searchBar.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        searchBar.sendKeys(Keys.DELETE);
        searchBar.sendKeys(item);
        searchBar.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.stalenessOf(addToCart));
    }
}
