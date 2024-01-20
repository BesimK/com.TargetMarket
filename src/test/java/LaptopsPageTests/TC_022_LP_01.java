package LaptopsPageTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 1. Open the URL.
 * 2. Navigate to Target Market Login Page.
 * 3. Fill in the blanks with the provided credentials. (problem_user)
 * 4. Navigate to Target Market Home Page.
 * 5. Verify that the welcoming message header matches for the 'problem_user' user
 */
public class TC_022_LP_01 extends Hooks {

    @Test
    void verifyThatWelcomingMessageHeaderMatchedWithCorrectUser() {

        // Open the URL and Navigate to Target Market Home Page.
        pages.getLaptopsPage().clickOnLoginButton();

        // Fill in the blanks with the provided credentials. (problem_user)
        pages.getTargetMarketLoginPage().login("problem_user", "secret_password");

        // Navigate to Target Market Home Page
        String userName = pages.getLaptopsPage().getWelcomeHeaderText();

        // Verify that the welcoming message header matches for the 'problem_user' user
        boolean isUserCorrect = pages.getLaptopsPage().isUserCorrect("problem_user");
        Assert.assertTrue(isUserCorrect,"Correct user should be problem_user but it is not");
    }
}