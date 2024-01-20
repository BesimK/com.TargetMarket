package WomenShoesTest;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import static org.testng.AssertJUnit.assertEquals;

/*
1.Scroll Down the page
2.Click the Womens Shoes Button
3.Scroll Down the Page
4.Add all items in Womens Shoes Page to Shoping Cart
5.Click to the shopping cart Item
6.Verify that all items added to cart
7.Remove all items in Shoping Cart List
8.Verify that the message ”Your cart is empty."viewed in Shopping Cart.
9.Click to the close button.
 */
public class TC_030_WS_03 extends Hooks {

    @Test
    public void verifyRemovingProductFunctionalityFromShopingCart(){

        //1.Scroll Down the page
        //2.Click the Womens Shoes Button
        pages.getTargetMarketHomePage().swipeTabsLeft();
        pages.getTargetMarketHomePage().clickTab(9);

        //3.Scroll Down the Page
        BrowserUtils.scrollUpWithPageUp();

        //4.Add all items in Womens Shoes Page to Shoping Cart
        pages.getWomenShoesPage().clickTheAddCartButton(1);
        pages.getWomenShoesPage().clickTheAddCartButton(2);
        pages.getWomenShoesPage().clickTheAddCartButton(3);
        pages.getWomenShoesPage().clickTheAddCartButton(4);
        pages.getWomenShoesPage().clickTheAddCartButton(5);

        //5.Click to the shopping cart Item
        BrowserUtils.scrollUpWithPageUp();
        pages.getTargetMarketHomePage().clickCartButton();

        //6.Verify that all items added to cart
        boolean item1 = pages.getFurniturePage().checkTextOfShoppingCart(1,"women's shoes");
        Assert.assertTrue(item1);

        boolean item2 = pages.getFurniturePage().checkTextOfShoppingCart(2,"Sneaker shoes");
        Assert.assertTrue(item2);

        boolean item3 = pages.getFurniturePage().checkTextOfShoppingCart(3,"Women Strip Heel");
        Assert.assertTrue(item3);

        boolean item4 = pages.getFurniturePage().checkTextOfShoppingCart(4,"Chappals & Shoe Ladies Metallic");
        Assert.assertTrue(item4);

        boolean item5 = pages.getFurniturePage().checkTextOfShoppingCart(5,"Women Shoes");
        Assert.assertTrue(item5);

        //7.Remove all items in Shoping Cart List
        pages.getWomenShoesPage().clickOnRemoveButtons();

        //8.Verify that the message ”Your cart is empty." viewed in Shopping Cart.
        String expectedResult = "Your cart is empty.";
        String actualResult = pages.getWomenShoesPage().getEmptyMessage();
        assertEquals(expectedResult,actualResult);

        //9.Click to the close button.
        pages.getWomenShoesPage().getCloseButtonInShopCart();


    }
}
