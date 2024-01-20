package WomenShoesPageTest;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
/*
1.Scroll Down the page
2.Click the Womens Shoes Button
3.Scroll Down the Page
4.Click the “AddToCart” buttons for products in order Women Strip Heel, Chappals &
Shoe Ladies Metallic, Sneaker shoes
5.Click to the shopping cart Item
6.Verify that all added items Shown in adding order
 */

public class TC_026_WS_02 extends Hooks {

    @Test
    public void verifyAddingProductFunctionality(){

        //1.Scroll Down the page
        //2.Click the Womens Shoes Button
        //pages.getTargetMarketHomePage().swipeTabsLeft();
        pages.getTargetMarketHomePage().clickTab("Womens Shoes");

        //3.Scroll Down the Page
        BrowserUtils.scrollDownWithPageDown();


        //4.Click the “AddToCart” buttons for products in order Women Strip Heel, Chappals & Shoe Ladies Metallic, Sneaker shoes
        pages.getWomenShoesPage().clickTheAddCartButton(3);
        pages.getWomenShoesPage().clickTheAddCartButton(4);
        pages.getWomenShoesPage().clickTheAddCartButton(2);

        BrowserUtils.scrollUpWithPageUp();

        //5.Click to the shopping cart Item
        pages.getTargetMarketHomePage().clickCartButton();


        //6.Verify that all added items Shown in adding order
        boolean item1 = pages.getFurniturePage().checkTextOfShoppingCart(1,"Women Strip Heel");
        Assert.assertTrue(item1);

        boolean item2 = pages.getFurniturePage().checkTextOfShoppingCart(2,"Chappals & Shoe Ladies Metallic");
        Assert.assertTrue(item2);

        boolean item3 = pages.getFurniturePage().checkTextOfShoppingCart(3,"Sneaker shoes");
        Assert.assertTrue(item3);

    }


}
