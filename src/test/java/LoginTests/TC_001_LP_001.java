package LoginTests;

import BaseTest.Hooks;
import jdk.jfr.Name;
import org.testng.annotations.Test;

/**
 * 1. Launch the application
 * 2. Navigate to the Target Market
 * 3. Use login data with standard_user
 * 4. Use password data with secret_password
 * 5. Click. The login button
 * Verification login functions properly
 */
public class TC_001_LP_001 extends Hooks{

    @Test
    void loginWithStandardUser(){
    pages.getHomePage().clickOnTargetMarketLink();
    pages.getTargetMarketLoginPage().login("standard_user","secret_password");
    pages.getTargetMarketHomePage().clickLogoutButton();
    }


}
