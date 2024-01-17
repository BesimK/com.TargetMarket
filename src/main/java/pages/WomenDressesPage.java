package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

import java.util.List;

public class WomenDressesPage extends BasePage{

    @FindBy(xpath = "//button[@class=\"btn btn-danger fs-3 w-100\"]")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//div[text()=\"Product added to cart!\"]")
    private WebElement notificationForCart;

    //Generic multiple product selector
    public void clickAddToCartButton(int... buttons) throws Exception {
        int scrollCounter;
        for(int button:buttons){
            scrollCounter = 0;
            for(int c = (button-1)/4;c>0;c--){
                BrowserUtils.scrollDownWithPageDown();
                ++scrollCounter;
            }
            addToCartButtons.get(button-1).click();
            BrowserUtils.wait(1.5);
            if(!checkNotification()){
                throw new Exception();
            }
            BrowserUtils.wait(2.0);
            for (int j = 0; j < scrollCounter; j++) {
                BrowserUtils.scrollUpWithPageUp();
            }
        }
    }

    public boolean checkNotification(){
        return notificationForCart.isDisplayed();
    }

    public void clickAddToCartButton1(int productIndex){
        for(int c = productIndex/5;c>0;c/=5){
            BrowserUtils.scrollDownWithPageDown();
        }
        addToCartButtons.get(productIndex-1).click();
    }
}