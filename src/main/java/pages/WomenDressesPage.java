package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.Driver;

import java.util.List;

public class WomenDressesPage extends BasePage{
    @FindBy(xpath = "//button[text()=\"Add to Cart\"]")
    private List<WebElement> addToCartButtons;
    @FindBy(xpath ="(//button[text()=\"Add to Cart\"])[1]")
    private WebElement firstAddToCartButton;
    @FindBy(xpath = "//div[text()=\"Product added to cart!\"]")
    private WebElement notificationForCart;

    public void clickAddToCartButton(int... buttons) throws Exception {
        if( buttons.length > addToCartButtons.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 1; i <= addToCartButtons.size(); i++) {
            if(i%5==0){
                BrowserUtils.scrollDownWithPageDown();
            }
            addToCartButtons.get((buttons[i-1])-1).click();
            BrowserUtils.wait(2.0);
            if(!checkNotification()){
                throw new Exception("\"Added to cart!\" notification isn't displayed");
            }
        }
    }
    public void clickAddToCartButton(int productIndex){
        for(int c = (productIndex+1)/5;c>0;c/=5){
            BrowserUtils.scrollDownWithPageDown();
        }
        addToCartButtons.get(productIndex-1).click();
    }
    public boolean checkNotification(){
        return notificationForCart.isDisplayed();
    }
}
