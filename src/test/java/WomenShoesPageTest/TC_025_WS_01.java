package WomenShoesPageTest;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import static org.testng.Assert.assertEquals;
/*
1.Scroll Down the page
2.Click the Womens Shoes Button
3.Scroll up the page
4.Verify that Womens Shoes headLine Shown
5.Click The LogOut Button
6.Verify that the Login Page Opened.
 */

public class TC_025_WS_01 extends Hooks {

    @Test
    public void verifyWomenShoesPageFuctionality(){

        //1.Scroll Down the page
        //2.Click the Womens Shoes Button
        pages.getTargetMarketHomePage().swipeTabsLeft();
        pages.getTargetMarketHomePage().clickTab(9);

        //3.Scroll up the page
        BrowserUtils.scrollUpWithPageUp();

        //4.Verify that Womens Shoes headLine Shown
        BrowserUtils.wait(3.0);
        String expectedHead = "Womens Shoes";
        String actualHead = pages.getWomenShoesPage().getHeaderOfWomenShoesPage();
        System.out.println(actualHead);
        assertEquals(expectedHead,actualHead , "HeadLine should be Womens Shoes");

        //5.Click The LogOut Button
        pages.getTargetMarketHomePage().clickLogoutButton();

        //6.Verify that the Login Page Opened
        String expectedLoginHead = "Login";
        String actualLoginHead = pages.getWomenShoesPage().getHeaderOfLoginPage();
        assertEquals(expectedLoginHead , actualLoginHead , "it should be -Login- text");








    }
}
