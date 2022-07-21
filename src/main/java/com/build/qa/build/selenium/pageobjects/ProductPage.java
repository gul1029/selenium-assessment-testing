package com.build.qa.build.selenium.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public WebDriver driver;

    @FindBy(css = "#singleSkuForm > div.quantity__action > div.btn__group > input.btn__primary.js-add-to-cart")
    WebElement addToCart;
    @FindBy(css = "#wrapper > header > div.header-container.container > div.header-details-user > ul > li.cart.i-cart > a")
    WebElement cartButton;
    @FindBy(css = "#react-type-ahead-normal > fieldset > input")
    WebElement searchBar;
    @FindBy(className = "add__to__cart__success")
    WebElement addToCartSuccess;
    @FindBy(css = "#wrapper > main > div > div > div:nth-child(2) > div.col-lg-4.col-md-4 > div")
    WebElement productPageElement;
    @FindBy(css = "#wrapper > main > div > div:nth-child(6) > div > h1")
    WebElement productOnCartElement;
    FunctionPage functionPage;

    public ProductPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }

    private void onProductPage() {
        functionPage.waitUntilElementIsVisbilt(productPageElement);

    }

    public void addItemToCart() {
        addToCart.click();
        functionPage.waitUntilElementIsVisbilt(addToCartSuccess);

    }

    public boolean clickCartButton() {
        functionPage.waitUntilElementIsVisbilt(cartButton);
        cartButton.click();
        functionPage.waitUntilElementIsVisbilt(productOnCartElement);
        return productOnCartElement.isDisplayed();
    }

    public void searchForItem(String item) {
        searchBar.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        searchBar.sendKeys(Keys.DELETE);
        searchBar.sendKeys(item);
        searchBar.sendKeys(Keys.ENTER);
        functionPage.waitUntilElementIsVisbilt(addToCart);
    }
}
