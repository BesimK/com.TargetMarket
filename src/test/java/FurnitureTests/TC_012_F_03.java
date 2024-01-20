package FurnitureTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

/**
 * 1. Open Browser, Navigate and Login to Target Market
 * 2. Add all products ro ShoppingCart
 * 3.Verify that all products added to ShoppingCart
 * 4.Remove all items in Shoping Cart List
 * 5.Verify that Shopping card is empty
 */

public class TC_012_F_03 extends Hooks {
    @Test
    public void testFurniturePage02() throws Exception {
        //Waiting is for preConditions
        BrowserUtils.wait(2.0);
        BrowserUtils.scrollDownWithPageDown();

        //1. Open Browser, Navigate and Login to Target Market
        pages.getTargetMarketHomePage().clickTab(6);
        BrowserUtils.scrollDownWithPageDown();
        BrowserUtils.wait(2.0);

        // 2. Add all products to ShoppingCart
        pages.getFurniturePage().clickAllTheAddToCarts();

        BrowserUtils.wait(1.0);
        BrowserUtils.scrollUpWithPageUp();

        //3.Verify that all products added to ShoppingCart
        pages.getTargetMarketHomePage().clickCartButton();
        Assert.assertEquals(pages.getFurniturePage().getShoppingCartSize(), 5, "All products can not added to list!");

        //4.Remove all items in Shoping Cart List
        pages.getFurniturePage().clickOnRemoveButtons();

        //5.Verify that Shopping card is empty
        String expected ="Your cart is empty.";
        String actual = pages.getFurniturePage().getEmptyMessage();
        Assert.assertEquals(actual,expected,"Shopping card is not empty.");
    }
}
