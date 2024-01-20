package SkincarePageTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_003_SC_03 extends Hooks {

    /**
     * 1. Click the Skincare item
     * 2. Verify you are on the Skincare page
     * 3. Click on the add to cart button in Skin Beauty Serum
     * 4. Click on the add to cart button in Tree Oil 30ml
     * 5. Click on shopping cart button.
     * 6. Click on "Go to Checkout" button and navigate to Checkout page.
     * 7. Verify that product added to cart.
     */

    @Test
    void checkoutPageItemListTest() throws Exception {
        //1. Click the Skincare item
        pages.getTargetMarketHomePage().clickTab(3);

        //2. Verify you are on the Skincare page
        String expected = "Skincare";
        String actual = pages.getSkincarePage().getSkincarePageHeader();
        Assert.assertEquals(actual, expected);

        //3. Click on the add to cart button in Skin Beauty Serum
        //4. Click on the add to cart button in Tree Oil 30ml
        pages.getTargetMarketHomePage().clickAddToCartButton(2,4);

        //5. Click on shopping cart button.
        pages.getGroceriesPage().clickOnGoToCartButton();

        //6. Click on "Go to Checkout" button and navigate to Checkout page.
        pages.getTargetMarketHomePage().clickGoToCheckoutButton();

        //7. Verify that product added to cart.
        actual = pages.getSkincarePage().getProductNameInCart(0);
        expected = "Tree Oil 30ml x 1";
        Assert.assertEquals(actual,expected);
        actual = pages.getSkincarePage().getProductNameInCart(1);
        expected = "Skin Beauty Serum. x 1";
        Assert.assertEquals(actual,expected);

    }
}
