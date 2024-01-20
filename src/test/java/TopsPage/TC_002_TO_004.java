package TopsPage;

import BaseTest.Hooks;
import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class TC_002_TO_004 extends Hooks {

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

        pages.getTopsCheckOutPage().enterInputToFirstName("Fatih");

        pages.getTopsCheckOutPage().enterInputToLastName("Satan");

        pages.getTopsCheckOutPage().enterInputToAddress("Ibrikder mah imar cad kartepe kocaeli");

        BrowserUtils.scrollDownWithPageDown();
        BrowserUtils.wait(2.0);

        pages.getTopsCheckOutPage().enterInputToCardNumber("111111111111111");

        pages.getTopsCheckOutPage().enterInputToPhoneNumber("1111111111");

        pages.getTopsCheckOutPage().clickOnPlaceOrderButton();

        Assert.assertTrue(pages.getTopsCheckOutPage().isCardNumberAlertDiplayed());
    }
}