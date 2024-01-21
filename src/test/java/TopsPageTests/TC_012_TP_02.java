package TopsPageTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class TC_012_TP_02 extends Hooks {

	@Test
	void test() {

		BrowserUtils.scrollDownWithPageDown();
		// BrowserUtils.scrollDownWithPageDown();

		pages.getTargetMarketHomePage().clickTopsPageLink();

		BrowserUtils.scrollDownWithPageDown();

		BrowserUtils.wait(2.0);

		pages.getTopsPage().clickOnAddToCartButton(0);

		pages.getTopsPage().clickOnAddToCartButton(0);

		pages.getTopsPage().clickOnAddToCartButton(0);

		pages.getTopsPage().clickOnAddToCartButton(0);

		BrowserUtils.scrollDownWithPageDown();

		BrowserUtils.wait(2.0);

		pages.getTopsPage().clickOnAddToCartButton(0);

		pages.getTopsPage().clickOnGoToCartButton();

		pages.getTopsPage().clickOnGoCheckOutButton();

		BrowserUtils.scrollDownWithPageDown();

		BrowserUtils.wait(2.0);

		Assert.assertTrue(pages.getCheckoutPage().getTotalPriceText("$897.00"));
	}

}
