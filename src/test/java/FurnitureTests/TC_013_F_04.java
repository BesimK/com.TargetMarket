package FurnitureTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class TC_013_F_04 extends Hooks {

    @Test
    public void tesFurniturePage03(){
        //Waiting is for preConditions
        BrowserUtils.wait(2.0);
        BrowserUtils.scrollDownWithPageDown();

        //1. Open Browser, Navigate and Login to Target Market
        pages.getTargetMarketHomePage().clickFurniture();
        BrowserUtils.wait(2.0);

        //2.Click On sort By button
        //3.Select the Lowest Price from the list
        //4..scrollDown the page
        pages.getFurniturePage().clickOnSortByButton("Lowest Price");
        BrowserUtils.scrollDownWithPageDown();

        //5.Verify that the products in the page viewing in order related to their price from lowest to hightes.
        Assert.assertTrue(pages.getFurniturePage().areSmartphonesSortByLowestPriceCorrectly());
    }
}
