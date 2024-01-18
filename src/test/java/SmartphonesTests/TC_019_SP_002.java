package SmartphonesTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

/**
 * 1. Open the URL.
 * 2. Navigate to Target Market Home Page.
 * 3. Click on the "Smartphones" button.
 * 4. Click on the "Sort By" button and select the "None" option.
 * 5. Click on the "iPhone X" Add to Cart button.
 * 6. Verify that the product is added in shopping cart.
 */
public class TC_019_SP_002 extends Hooks {

    @Test
    void verifyAddedToCartButtonFunctionality() {

        // Open the URL and Navigate to Target Market Home Page.

        // Click on the "Smartphones" button.
        pages.getTargetMarketHomePage().clickTab(1);

        // Click on the "Sort By" button and select the "None" option.
        pages.getSmartphonesPage().clickOnSortByToChose("Highest Price");

        // Click on the "iPhone X" Add to Cart button.
        BrowserUtils.scrollDownWithPageDown();
        pages.getSmartphonesPage().clickOnSelectedProduct("iPhone X");

        // Verify that the product is added in shopping cart.
        String numberOfProduct = pages.getSmartphonesPage().getCountOfShoppingCart();
        Assert.assertEquals(numberOfProduct, "1");
    }
}