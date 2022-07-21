package com.build.qa.build.selenium.tests;

import com.build.qa.build.selenium.pageobjects.ProductPage;
import org.junit.Test;

import com.build.qa.build.selenium.pageobjects.homepage.HomePage;
import com.build.qa.build.selenium.pageobjects.ProductPage;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Assert;
import org.junit.Test;

import com.build.qa.build.selenium.pageobjects.homepage.HomePage;

public class FergTest extends BaseFramework {


	/**
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 */
	@Test
	public void navigateToHomePage() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue("The website home page did not load.", homePage.onHomePage());
	}

	/**
	 * Search for the Moen m6702bn from the search bar
	 * @assert: That the product page we land on is what is expected by checking the product brand and product id
	 * @difficulty Easy
	 */
	@Test
	public void searchForProductLandsOnCorrectProduct() {
		// TODO: Implement this test
	}

	/**
	 * Go to the Bathroom Sinks category directly
	 * (https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3)
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
	@Test
	public void addProductToCartFromCategoryDrop() {
		// TODO: Implement this test
	}

	/**
	 * Add two different finishes of a product (such as Moen m6702bn) to cart,
	 * change the quantity of each finish on the cart page
	 * @assert that the product and cart total update as expected when the quantity is changed
	 * @difficulty Medium-Hard
	 */
	@Test
	public void addMultipleCartItemsAndChangeQuantity() {

		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver);

		homePage.onSearchBar("m6702bn");

		ProductPage productPage = new ProductPage(driver);
		productPage.addItemToCart();
		productPage.searchForItem("S3315025BT");
		productPage.addItemToCart();
		Assert.assertTrue("The products quantity and the total price being updated in the shopping cart",productPage.clickCartButton());
	}

	/**
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Brand=Brizo
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() {
		// TODO: Implement this test
	}
}
