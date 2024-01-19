package SkincareTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

/**
 * 1. Click the Skincare item
 * 2. Verify you are on the Skincare page
 * 3. Click on the add to cart button in Skin Beauty Serum
 * 4. Verify "Product added to cart!"message was displayed
 */

public class TC_003_SC_01 extends Hooks {
    @Test
    void skincareAddToCartFunctions() throws Exception {
        //1. Click the Skincare item
        pages.getTargetMarketHomePage().clickTab(3);

        //2. Verify you are on the Skincare page
        String expected = "Skincare";
        String actual = pages.getSkincarePage().getSkincarePageHeader();
        Assert.assertEquals(actual,expected);

        //3. Click on the add to cart button in Skin Beauty Serum
        //4.Verify "Product added to cart!"message was displayed
        pages.getTargetMarketHomePage().clickAddToCartButton(4);


    }
}
