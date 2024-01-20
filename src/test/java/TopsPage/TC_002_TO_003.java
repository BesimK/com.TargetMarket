package TopsPage;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class TC_002_TO_003 extends Hooks {


    @Test
    void testValidPlaceOrder() throws InterruptedException {
        BrowserUtils.scrollDownWithPageDown();

        pages.getTargetMarketHomePage().clickTopsPageLink();

        BrowserUtils.scrollDownWithPageDown();

        Thread.sleep(2000);

        pages.getTopsPage().clickOnAddToCartButton(0);

        pages.getTopsPage().clickOnAddToCartButton(0);

        Thread.sleep(3000);

        pages.getTopsPage().clickOnAddToCartButton(0);

        pages.getTopsPage().clickOnAddToCartButton(0);

        BrowserUtils.scrollDownWithPageDown();

        BrowserUtils.wait(2.0);

        pages.getTopsPage().clickOnAddToCartButton(0);

        pages.getTopsPage().clickOnGoToCartButton();

        pages.getTopsPage().clickOnGoCheckOutButton();

       String [] inputData = {
               "Tarık Jake",
               "Gulbas",
               "Testers Valley Inar Academy Street Building Before WallMart Dallas Texas",
               "1111111111111111",
               "1111111111"};

       pages.getCheckoutPage().checkOut(inputData);

        Assert.assertEquals(pages.getTargetMarketHomePage().getCheckoutMessage(),"Thanks!");




    }

}
