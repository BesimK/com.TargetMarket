package WomenShoesPageTest;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import utils.BrowserUtils;

/*
1.Scroll Down the page
2.Click the Womens Shoes Button
3.click on Sort By button
4.Select the Lowest Price from the list
5.scrollDown the page
6.Verify that the products in the page viewing in order related to their price from lowest
to hightes.
 */
public class TC_028_WS_04 extends Hooks {

    @Test
    public void verifyTheFunctioanalityOfSortByButton(){

        //1.Scroll Down the page
        //2.Click the Womens Shoes Button
       // pages.getTargetMarketHomePage().swipeTabsLeft();
        pages.getTargetMarketHomePage().clickTab("Womens Shoes");

        //3.click on Sort By button
        //4.Select the Lowest Price from the list
        pages.getWomenShoesPage().clickOnSortByButton("Lowest Price");

        //5.scrollDown the page
        BrowserUtils.scrollDownWithPageDown();

        //6.Verify that the products in the page viewing in order related to their price from lowest to hightes.
        pages.getWomenShoesPage().areSmartphonesSortByLowestPriceCorrectly();





    }
}
