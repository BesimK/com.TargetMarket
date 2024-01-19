package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopsCheckOutPage extends BasePage {
    @FindBy(xpath = "//div[2]/div/h2")
    private WebElement totalPriceText;

    @FindBy(id = "lastName")
    private WebElement lastNameInputArea;

    @FindBy(id = "firstName")
    private WebElement firstNameInputArea;

    @FindBy(id = "address")
    private WebElement addressInputArea;

    @FindBy(id = "cardNumber")
    private WebElement cardNumberInputArea;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberInputArea;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//h1[text()='Thanks!']")
    private WebElement endOfOrderMessage;

    @FindBy(xpath = "//div[text()='Card number must be 16 digits']")
    private WebElement cardNumberAlert;

    public Boolean getTotatlPriceText(CharSequence text){
        return totalPriceText.getText().contains(text);
    }

    public void enterInputToFirstName(String input){
        firstNameInputArea.sendKeys(input);
    }

    public void enterInputToLastName(String input){
        lastNameInputArea.sendKeys(input);
    }

    public void enterInputToAddress(String input){
        addressInputArea.sendKeys(input);
    }

    public void enterInputToCardNumber(String input){
        cardNumberInputArea.sendKeys(input);
    }

    public void enterInputToPhoneNumber(String input){
        phoneNumberInputArea.sendKeys(input);
    }

    public void clickOnPlaceOrderButton(){
        placeOrderButton.click();
    }

    public String endOfOrderMessage(){
        return endOfOrderMessage.getText();

    }

    public Boolean isCardNumberAlertDiplayed(){
        return cardNumberAlert.isDisplayed();
    }

}
