package FurnitureTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.Collections;
import java.util.List;

/**
 * 1. Open Browser, Navigate and Login to Target Market
 * 2.Click the “AddToCart” buttons for products IN ORDER
 * 3.Click the shoppingCart button
 * 4.Get the name's of products in order
 * 5.Verify that all products added to Shopping card in order
 */
public class TC_011_F_02 extends Hooks {
    @Test
    public void testFurniturePAge01() {
        //Waiting is for preConditions
        BrowserUtils.wait(2.0);
        BrowserUtils.scrollDownWithPageDown();

        //1. Open Browser, Navigate and Login to Target Market
        pages.getTargetMarketHomePage().clickFurniture();
        BrowserUtils.scrollDownWithPageDown();
        BrowserUtils.wait(2.0);

        //2.Click the “AddToCart” buttons for products IN ORDER
        // -3 Tier Corner Shelves
        // -Sofa for Coffe Cafe
        //	-Mornadi Velvet Bed
        pages.getFurniturePage().clickTheAddCartButton(3);
        pages.getFurniturePage().clickTheAddCartButton(2);
        pages.getFurniturePage().clickTheAddCartButton(1);

        BrowserUtils.scrollUpWithPageUp();

        //3.Click the shoppingCart button
        pages.getTargetMarketHomePage().clickCartButton();

        //4.Get the name's of products in oreder
        //5.Verify that all products added to Shopping card in order
       boolean condition1 = pages.getFurniturePage().checkTextOfShoppingCart(1,"3 Tier Corner Shelves");
        Assert.assertTrue(condition1);

        boolean condition2 = pages.getFurniturePage().checkTextOfShoppingCart(2,"Sofa for Coffe Cafe");
        Assert.assertTrue(condition2);

        boolean condition3 = pages.getFurniturePage().checkTextOfShoppingCart(3,"Mornadi Velvet Bed");
        Assert.assertTrue(condition3);
    }
}