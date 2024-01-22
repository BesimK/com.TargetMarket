package LaptopsPageTests;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import utils.BrowserUtils;

/**
 * 1. Open the URL. 2. Navigate to Target Market Home Page. 3. Click on the "Laptops"
 * button. 4. Click on the "Microsoft Surface Laptop 4" Add to Cart button. 5. Verify that
 * the product is added in shopping cart icon. 6. Click on the shopping cart icon. 7.
 * Verify that the product is added in shopping cart correctly. 8. Click the '+' button
 * twice for 'Microsoft Surface Laptop 4'. 9. Verify that the total price is changed
 * correctly.
 */
public class TC_023_LP_02 extends Hooks {

	@Test
	void verifyWhetherCountsOfProductsDisplayedInShoppingCartCorrect() {

		// Open the URL and Navigate to Target Market Home Page.

		// Click on the "Laptops" button.
		pages.getTargetMarketHomePage().clickTab("Laptops");

		// Click on the "Microsoft Surface Laptop 4" Add to Cart button.
		BrowserUtils.scrollDownWithPageDown();
		pages.getLaptopsPage().clickOnSelectedProduct("Microsoft Surface Laptop 4");

		// Verify that the product is added in shopping cart icon.
		String countOfProductsInShoppingCart = pages.getLaptopsPage().getCountOfShoppingCart();
		softAssert.assertEquals(countOfProductsInShoppingCart, "1", "Counts of product should be 1");

		// Click on the shopping cart icon.
		pages.getLaptopsPage().clickOnShoppingCartIcon();

		// Verify that the product is added in shopping cart correctly.
		boolean areTheseProductsAddedToShoppingCart = pages.getLaptopsPage()
			.areTheseProductsAddedToShoppingCart("Microsoft Surface Laptop 4");
		softAssert.assertTrue(areTheseProductsAddedToShoppingCart,
				"There should be only one product in the shopping cart but there is not");

		// Click the '+' button twice for 'Microsoft Surface Laptop 4'.
		pages.getLaptopsPage().pressPlusMinusSignInShoppingCart(1);

		// Verify that the total price is changed correctly.
		boolean isTotalPriceInShoppingCartCorrect = pages.getLaptopsPage().isTotalPriceInShoppingCartCorrect();
		softAssert.assertTrue(isTotalPriceInShoppingCartCorrect,
				"Total price in shopping cart does not match with the total price of product(s)");
	}

}