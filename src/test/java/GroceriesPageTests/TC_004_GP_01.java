package GroceriesPageTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 1. Click the Groceries item 2. Click on the add to cart button in Gulab Powder 50 Gram,
 * -Daal Masoor 500 grams 3. Click on the shopping cart button 4. Verify that the selected
 * items have been added to the cart
 */

public class TC_004_GP_01 extends Hooks {

	@Test
	void groceriesAddToCartFunctions() throws Exception {

		// 1. Click the Groceries item
		pages.getTargetMarketHomePage().clickTab("Groceries");

		// 2. Click on the add to cart button in Gulab Powder 50 Gram, -Daal Masoor 500
		// grams
		pages.getTargetMarketHomePage().clickAddToCartButton(1, 5);

		// 3. Click on the shopping cart button
		pages.getGroceriesPage().clickOnGoToCartButton();

		// 4. Verify that the selected items have been added to the cart
		String expected = "- Daal Masoor 500 grams";
		String actual = pages.getGroceriesPage().getAddedProductName(0);
		Assert.assertEquals(actual, expected);
		expected = "Gulab Powder 50 Gram";
		actual = pages.getGroceriesPage().getAddedProductName(1);
		Assert.assertEquals(actual, expected);

	}

}
