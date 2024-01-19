package SkincareTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

/**
 * 1.Click the Skincare item
 * 2.Verify you are on the Skincare Page
 * 3.Select the highest price in sort by dropdown
 * 4.Verify that the products are sorted from expensive to cheap
 */

public class TC_004_SC_02 extends Hooks {

    @Test
    void sortByDropdownFunctionality() {

        //1.Click the Skincare item
        pages.getTargetMarketHomePage().clickTab(3);

        //2.Verify you are on the Skincare page
        String expected = "Skincare";
        String actual = pages.getSkincarePage().getSkincarePageHeader();
        Assert.assertEquals(actual,expected);

        //3.Select the highest price in sort by dropdown
        pages.getSkincarePage().clickSortByDropdown();
        BrowserUtils.wait(1.0);
        pages.getSkincarePage().selectSortByDropdownElement(3);

        //4.Verify that the products are sorted from expensive to cheap
        int[] priceList = new int[5];
        for (int i = 0; i < priceList.length; i++) {
            priceList[i] = pages.getSkincarePage().getProductPrice(i);
        }
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(priceList[i] > priceList[i + 1]);
        }

    }
}
