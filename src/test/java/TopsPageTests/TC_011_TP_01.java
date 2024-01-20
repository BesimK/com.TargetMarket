package TopsPageTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class TC_011_TP_01 extends Hooks {

    @Test
    void testAddToCartButton() throws InterruptedException {

        BrowserUtils.scrollDownWithPageDown();

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

        Assert.assertEquals("5",pages.getTopsPage().getTextOfCartButton());

    }
}
