package GroceriesPageTests;

import BaseTest.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 1. Click the Groceries item
 * 2. Click on the add to cart button in Gulab Powder 50 Gram, - Daal Masoor 500 grams,cereals muesli fruit nuts, Elbow Macaroni - 400 gm, Orange Essence Food Flavou
 * 3. Click on the shopping cart button
 * 4. Click on "Go to Checkout" button and navigate to Checkout page.
 * 5. Enter name as First Name field.
 * 6. Enter lastname as Last Name field.
 * 7. Enter address as Address field.
 * 8. Enter "1111111111111111" as Card Number field.
 * 9. Enter "1111111111" as Phone Number field.
 * 10. Click on "Place Order" button.
 * 11. Verify that "Thanks! Hello, Emre Can!" alert appears.
 */

public class TC_005_GP_02 extends Hooks {

    @Test
    void placeOrderTest() throws Exception {
        //1. Click the Groceries item
        pages.getTargetMarketHomePage().clickTab("Groceries");

        //2. Click on the add to cart button in Gulab Powder 50 Gram, - Daal Masoor 500 grams,cereals muesli fruit nuts, Elbow Macaroni - 400 gm, Orange Essence Food Flavou
        pages.getTargetMarketHomePage().clickAddToCartButton(1,2,3,4,5);

        //3. Click on the shopping cart button
        pages.getGroceriesPage().clickOnGoToCartButton();

        //4. Click on "Go to Checkout" button and navigate to Checkout page.
        pages.getTargetMarketHomePage().clickGoToCheckoutButton();

        //5. Enter name as First Name field.
        //6. Enter lastname as Last Name field.
        //7. Enter address as Address field.
        //8. Enter "1111111111111111" as Card Number field.
        //9. Enter "1111111111" as Phone Number field.
        //10. Click on "Place Order" button.
        pages.getCheckoutPage().checkOut();

        //11. Verify that order alert appears.
        String actual = pages.getTargetMarketHomePage().getCheckoutMessage();
        String expected = "Thanks!";
        Assert.assertEquals(actual, expected);



    }
}
