package WomenDressesTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.Driver;

/**
 * 1. Open Browser, Navigate and Login to Target Market
 * 2. Click on Women Dresses Tab
 * 3. Add One Item to Cart
 * 4. Assert Product Added to Cart Dialogue is Displayed
 * 5. Assert Cart Counter
 * 6. Click On Cart Button
 * 7. Click On Checkout
 * 8. Place Order with Valid Credentials
 * 9. Assert Successful Order Placement Dialogue at Home Page
 * 10. Assert Cart counter is 0
 * 11. Scroll Up
 */
public class TC_001_WD_001 extends Hooks {

	@Test(dataProvider = "productsInWomenDressesPage")
	void womenDressSingleProduct(int productIndex) {
		//1. Open Browser, Navigate and Login to Target Market
		BrowserUtils.wait(2.0);
		//Scroll
		BrowserUtils.scrollDownWithPageDown();

		//2. Click on Women Dresses Tab
		//Swipe Tabs
		pages.getTargetMarketHomePage().swipeTabsLeft();
		//Click Women Dresses
		pages.getTargetMarketHomePage().clickWomenDresses();
		//Get to new Tab;
		BrowserUtils.scrollDownWithPageDown();

		//3. Add One Item to Cart
		//Click Add to cart Button
		pages.getWomenDressesPage().clickAddToCartButton(productIndex);

		//Assert Product Added to Cart Dialogue is displayed
		boolean result = pages.getTargetMarketHomePage().addedToCartDialogueIsDisplayed();
		Assert.assertTrue(result);

		//Assert Cart Counter Is Working Properly
		String actual = pages.getTargetMarketHomePage().getTextFromCartCounter();
		String expected ="1";
		Assert.assertEquals(actual,expected);

		//Click Cart Button
		pages.getTargetMarketHomePage().clickCartButton();

		//Click Go to check out button
		pages.getTargetMarketHomePage().clickGoToCheckoutButton();
		BrowserUtils.wait(2.0);

		//Place Order
		pages.getCheckoutPage().checkOut();
		BrowserUtils.wait(2.0);

		//Assert Check Out Message
		actual = pages.getTargetMarketHomePage().getCheckoutMessage();
		expected = "Thanks!";
		Assert.assertEquals(actual,expected);
		pages.getTargetMarketHomePage().clickCloseDialogButton();

		//Return to HomePage navigate to Target Market
		Driver.getDriver().get("https://InarAcademy:Fk160621.@test.inar-academy.com");
		pages.getHomePage().clickOnTargetMarketLink();
		BrowserUtils.pressHomeButton();

	}

	@DataProvider (name = "productsInWomenDressesPage")
	private Object[] dataProvider(){
		return new Object[]{1,2,3,4,5};
	}
}
