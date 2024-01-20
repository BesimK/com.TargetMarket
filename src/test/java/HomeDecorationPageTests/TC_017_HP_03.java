package HomeDecorationPageTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class TC_017_HP_03 extends Hooks {



    /**
     * 1. Launch the application
     * 2. Navigate to the Target Market
     * 3. Use login data with standard_user
     * 4. Use password data with secret_password
     * 5. Click. The login button
     * Verification login functions properly
     */
// REPORTER PLUGIN BUST BE ADDED TO POM.XML!!!
// POM.XML MUST BE REVISED!!!


        @Test
        void homeDecorationSingleProduct() throws Exception {
            BrowserUtils.wait(2.0);
            //Scroll
            BrowserUtils.scrollDownWithPageDown();
            //Swipe Tabs
          //  pages.getTargetMarketHomePage().swipeTabsLeft();
            //Click Women Dresses
            pages.getTargetMarketHomePage().clickHomeDecorationPageLink();
            //Get to new Tab;
            BrowserUtils.scrollDownWithPageDown();
            //Click Add to cart Button
            pages.getWomenDressesPage().clickAddToCartButton();
		/*try{
			//Buttons start with 1
			pages.getWomenDressesPage().clickAddToCartButton(1,2,3);
		}catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
			Assert.fail("There is not that much product");
		}catch (Exception exception){
			Assert.fail("Added to cart notification isn't shown");
		}*/
            String actual = pages.getTargetMarketHomePage().getTextFromCartCounter();
            String expected ="1";
            Assert.assertEquals(actual,expected);
            //Click Cart Button
            pages.getTargetMarketHomePage().clickCartButton();
            //Click Go to check out button
            pages.getTargetMarketHomePage().clickGoToCheckoutButton();
            BrowserUtils.wait(2.0);

            pages.getCheckoutPage().checkOut();
            BrowserUtils.wait(2.0);
            actual = pages.getTargetMarketHomePage().getCheckoutMessage();
            expected = "Thanks!";
            Assert.assertEquals(actual,expected);
            pages.getTargetMarketHomePage().clickCloseDialogButton();
            BrowserUtils.scrollUpWithPageUp();
        }

    }


