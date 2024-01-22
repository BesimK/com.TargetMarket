package SmartphonesPageTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

/**
 * 1. Open the URL. 2. Navigate to Target Market Home Page. 3. Click on the "Smartphones"
 * button. 4. Click on the "Sort By" button and select the "Lowest Price" option. 5. Click
 * on the "OppoF19", "Samsung Universe 9" and "iPhone X" Add to Cart buttons. 6. Verify
 * that the product is added in shopping cart. 7. Click on the shopping cart icon. 8.
 * Verify that the products are added in shopping cart. 9. Click the '-' button once for
 * 'iPhone X'. 10. Verify that the total price is changed correctly.
 */
public class TC_021_SP_03 extends Hooks {

	@Test
	void verifyShoppingCartProcessFunctionsProperly() {

		// Open the URL and Navigate to Target Market Home Page.

		// Click on the "Smartphones" button.

		pages.getTargetMarketHomePage().clickTab("Smartphones");

		// Click on the "Sort By" button and select the "Highest Price" option.
		pages.getSmartphonesPage().clickOnSortByToChose("Lowest Price");

		// Click on the "OppoF19" Add to Cart button.
		BrowserUtils.scrollDownWithPageDown();
		pages.getSmartphonesPage().clickOnSelectedProduct("OPPOF19");

		// Click on the "Samsung Universe 9" Add to Cart button
		BrowserUtils.scrollDownWithPageDown();
		pages.getSmartphonesPage().clickOnSelectedProduct("Samsung Universe 9");

		// Click on the "iPhone X" Add to Cart button
		BrowserUtils.scrollUpWithPageUp();
		pages.getSmartphonesPage().clickOnSelectedProduct("iPhone X");

		// Verify that the product is added in shopping cart.
		String countOfProductsInShoppingCart = pages.getSmartphonesPage().getCountOfShoppingCart();
		Assert.assertEquals(countOfProductsInShoppingCart, "3", "Counts of product should be 3");

		// Click on the shopping cart icon.
		pages.getSmartphonesPage().clickOnShoppingCartIcon();

		// Verify that the products are added in shopping cart.
		boolean areTheseProductsAddedToShoppingCart = pages.getSmartphonesPage()
			.areTheseProductsAddedToShoppingCart("OPPOF19", "Samsung Universe 9", "iPhone X");
		Assert.assertTrue(areTheseProductsAddedToShoppingCart,
				"There should be three products in the shopping cart but there is not");

		// Click the '-' button once for 'iPhone X'.
		pages.getSmartphonesPage().pressMinusSignInShoppingCart(4);

		// Verify that the total price is changed correctly.
		boolean isTotalPriceInShoppingCartCorrect = pages.getSmartphonesPage().isTotalPriceInShoppingCartCorrect();
		Assert.assertTrue(isTotalPriceInShoppingCartCorrect,
				"Total price in shopping cart does not match with the total price of product(s)");
	}

}