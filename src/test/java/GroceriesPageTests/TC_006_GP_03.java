package GroceriesPageTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 1. Click the Groceries item 2. Click on the add to cart button in Orange Essence Food
 * Flavou 3. Click on the add to cart button in Elbow Macaroni - 400 gm 4. Click on
 * shopping cart button. 5. Click on "Go to Checkout" button and navigate to Checkout
 * page. 6. Verify that total price is correctly. 7. Click "+" button on Orange Essence
 * Food Flavou 8. Verify that total price is updated correctly.
 */

public class TC_006_GP_03 extends Hooks {

	@Test
	void testCartItemsFunctionalityInCheckoutPage() throws Exception {

		// 1. Click the Groceries item
		pages.getTargetMarketHomePage().clickTab("Groceries");

		// 2. Click on the add to cart button in Orange Essence Food Flavou
		// 3. Click on the add to cart button in Elbow Macaroni - 400 gm
		pages.getTargetMarketHomePage().clickAddToCartButton(2, 3);

		// 4. Click on the shopping cart button
		pages.getGroceriesPage().clickOnGoToCartButton();

		// 5. Click on "Go to Checkout" button and navigate to Checkout page.
		pages.getTargetMarketHomePage().clickGoToCheckoutButton();

		// 6. Verify that total price is correctly.
		String expected = "Total Price: $28.00";
		String actual = pages.getGroceriesPage().getTotalPriceInCheckoutPage();
		Assert.assertEquals(actual, expected);

		// 7. Click "+" button on Orange Essence Food Flavou
		pages.getGroceriesPage().clickOnIncreaseButton(1);

		// 8. Verify that total price is updated correctly.
		expected = "Total Price: $42.00";
		actual = pages.getGroceriesPage().getTotalPriceInCheckoutPage();
		Assert.assertEquals(actual, expected);

	}

}
