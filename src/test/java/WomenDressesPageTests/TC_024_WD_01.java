package WomenDressesPageTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.Driver;

/**
 * 1. Open Browser, Navigate and Login to Target Market
 * 2. Click on Women Dresses Tab
 * 3. Add Product/Products to Cart
 * 4. Assert Product Added to Cart Dialogue is Displayed
 * 5. Assert Cart Counter
 * 6. Click On Cart Button
 * 7. Click On Checkout
 * 8. Place Order with Valid Credentials
 * 9. Assert Successful Order Placement Dialogue at Home Page
 * 10. Assert Cart counter is 0
 * 11. Scroll Up
 */
public class TC_024_WD_01 extends Hooks {
	@Test(dataProvider = "cases")
	void womenDressAddToCartFunction(int[] products) {
		//1. Open Browser, Navigate and Login to Target Market
		//Get to new Tab;
		pages.getTargetMarketHomePage().clickTab("Womens Dresses");

		//3. Add Product/Products to Cart
		//Click Add to cart Button
		try {
			pages.getTargetMarketHomePage().clickAddToCartButton(products);
		}catch (Exception exception){
			Assert.fail();
		}

		//Assert Cart Counter Is Working Properly
		String actual = pages.getTargetMarketHomePage().getTextFromCartCounter();
		String expected = "" + products.length;
		Assert.assertEquals(actual, expected);

		//Click Cart Button
		pages.getTargetMarketHomePage().clickCartButton();

		//Click Go to check out button
		pages.getTargetMarketHomePage().clickGoToCheckoutButton();

		//Place Order
		pages.getCheckoutPage().checkOut();

		//Assert Check Out Message
		actual = pages.getTargetMarketHomePage().getCheckoutMessage();
		expected = "Thanks!";
		Assert.assertEquals(actual, expected);
		pages.getTargetMarketHomePage().clickCloseDialogButton();
	}

	@AfterMethod
	private void refresh() {
		//Return to HomePage navigate to Target Market
		Driver.getDriver().get("https://InarAcademy:Fk160621.@test.inar-academy.com");
		pages.getHomePage().clickOnTargetMarketLink();
		BrowserUtils.pressHomeButton();
	}

	@DataProvider(name = "cases")
	private Object[][] differentCases() {
		return new Object[][]{
				{5, 1, 4, 2, 3},
				{1},
				{3,2,1},
				{5}
		};
	}
}