package FurnitureTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

/**
 * 1. Open Browser, Navigate and Login to Target Market
 * 2.Get the header of Furniture Header
 * 3.Verify that the header is correct
 * 4.Implement Log Out process frım FurniturePage
 * 5.Check shopping Cart is "1"
 * 6.Implement Kog Out process
 */
public class TC_010_F_01 extends Hooks {
 @Test
    public void testFurniturePage00(){

     BrowserUtils.wait(2.0);

     BrowserUtils.scrollDownWithPageDown();
     //1. Open Browser, Navigate and Login to Target Market
     pages.getTargetMarketHomePage().clickTab(6);
     BrowserUtils.scrollUpWithPageUp();
     BrowserUtils.wait(2.0);

     //2.Get the header of Furniture Header
     String actualHeader = pages.getFurniturePage().getHeaderOfFurniturePage();

     //3.Verify that the header is correct
     Assert.assertEquals(actualHeader,"Furniture","We are in wrong Page!");
     BrowserUtils.scrollDownWithPageDown();
     BrowserUtils.wait(1.0);
     BrowserUtils.scrollDownWithPageDown();

     //4.Add the first product to SoppingCart
     pages.getFurniturePage().clickTheAddCartButton(1);

     //5.Check shopping Cart is "1"
     BrowserUtils.wait(1.0);
     BrowserUtils.scrollUpWithPageUp();
     String countOfShoppingCart = pages.getTargetMarketHomePage().getTextFromCartCounter();
     Assert.assertEquals(countOfShoppingCart,"1");

     //6.Implement Kog Out process
     pages.getTargetMarketHomePage().clickLogoutButton();
 }
}