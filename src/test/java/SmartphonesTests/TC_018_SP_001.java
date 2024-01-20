package SmartphonesTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 1. Open the URL.
 * 2. Navigate to Target Market Home Page.
 * 3. Click on the "Smartphones" button.
 * 4. Click on the "Sort By" button and select the "Highest Price" option.
 * 5. Verify that the products are sorted in decreasing order on the page.
 */
public class TC_018_SP_001 extends Hooks {

    @Test
    void verifySortByDropdownListFunctionality() {

        // Open the URL and Navigate to Target Market Home Page.

        // Click on the "Smartphones" button.
        pages.getTargetMarketHomePage().clickTab(1);

        // Click on the "Sort By" button and select the "Highest Price" option.
        pages.getSmartphonesPage().clickOnSortByToChose("Highest Price");

        // Verify that the products are sorted in decreasing order on the page.
        boolean areSmartphonesSortByHighestPrice = pages.getSmartphonesPage().areSmartphonesSortByHighestPriceCorrectly();
        Assert.assertTrue(areSmartphonesSortByHighestPrice);
    }
}