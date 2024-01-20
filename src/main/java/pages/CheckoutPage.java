package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class CheckoutPage extends BasePage{
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(id = "lastName")
    private WebElement lastNameField;
    @FindBy(id = "address")
    private WebElement addressField;
    @FindBy(id = "cardNumber")
    private WebElement cardNumberField;
    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;
    @FindBy(xpath = "//div[text()='Card number must be 16 digits']")
    private WebElement cardNumberAlert;
    @FindBy(xpath = "//div[2]/div/h2")
    private WebElement totalPriceText;

    public Boolean getTotalPriceText(CharSequence text){
        return totalPriceText.getText().contains(text);
    }
    public Boolean isCardNumberAlertDisplayed(){
        return cardNumberAlert.isDisplayed();
    }
    private static final String[] validCredentials = {
            "Tarık Jake",
            "Gulbas",
            "Testers Valley Inar Academy Street Building Before WallMart Dallas Texas",
            "1111111111111111",
            "1111111111"};

    public void checkOut(){
        firstNameField.sendKeys(validCredentials[0]);
        lastNameField.sendKeys(validCredentials[1]);
        addressField.sendKeys(validCredentials[2]);
        cardNumberField.sendKeys(validCredentials[3]);
        phoneNumberField.sendKeys(validCredentials[4]);
        BrowserUtils.scrollDownWithPageDown();
        BrowserUtils.wait(2.0);
        submitButton.click();
        BrowserUtils.wait(2.0);
    }
    public void checkOut(String[] credentials){
        firstNameField.sendKeys(credentials[0]);
        lastNameField.sendKeys(credentials[1]);
        addressField.sendKeys(credentials[2]);
        cardNumberField.sendKeys(credentials[3]);
        phoneNumberField.sendKeys(credentials[4]);
        BrowserUtils.scrollDownWithPageDown();
        BrowserUtils.wait(2.0);
        submitButton.click();
        BrowserUtils.wait(2.0);
    }

}