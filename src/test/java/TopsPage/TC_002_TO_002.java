package TopsPage;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import utils.BrowserUtils;

public class TC_002_TO_002 extends Hooks {

    @Test
    void test() throws InterruptedException {

        BrowserUtils.scrollDownWithPageDown();
        //BrowserUtils.scrollDownWithPageDown();

        pages.getTargetMarketHomePage().clickTopsPageLink();

        BrowserUtils.scrollDownWithPageDown();

        Thread.sleep(2000);

        pages.getTopsPage().clickOnAddToCartButton(0);

        pages.getTopsPage().clickOnAddToCartButton(0);

        pages.getTopsPage().clickOnAddToCartButton(0);

        pages.getTopsPage().clickOnAddToCartButton(0);

        BrowserUtils.scrollDownWithPageDown();

        Thread.sleep(2000);

        pages.getTopsPage().clickOnAddToCartButton(0);

        pages.getTopsPage().clickOnGoToCartButton();

        pages.getTopsPage().clickOnGoCheckOutButton();

        BrowserUtils.scrollDownWithPageDown();

        Thread.sleep(2000);

        Assert.assertTrue(pages.getTopsCheckOutPage().getTotatlPriceText("$897.00"));




    }
}
