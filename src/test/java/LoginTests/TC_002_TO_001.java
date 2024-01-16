package LoginTests;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.Pages;

import java.lang.annotation.Target;
import java.util.logging.Handler;

public class TC_002_TO_001 extends Hooks {

    @Test
    void test() throws InterruptedException {

       Thread.sleep(3000);
        BrowserUtils.scrollDownWithPageDown();
        //BrowserUtils.scrollDownWithPageDown();
        pages.getTargetMarketHomePage().clickTopsPageLink();
        BrowserUtils.scrollDownWithPageDown();
        Thread.sleep(2000);
        pages.getTopsPage().clickOnAddToCartButton(0);
        pages.getTopsPage().clickOnGoToCartButton();

    }
}
