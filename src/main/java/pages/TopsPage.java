package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopsPage extends BasePage{
    @FindBy(xpath = "//button[text()='Add to Cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(id = "//*[@id=\"sortType\"]/option")
    private List<WebElement> sortByDropDownElements;

    @FindBy(xpath = "//*[@id=\"navbar\"]/div/div/button[2]")
    private WebElement goToCartButton;

    public void clickOnAddToCartButton(int index){

        try {
            addToCartButtons.get(index).click();
        }
        catch (NullPointerException e){
            addToCartButtons.get(index).click();
        }

    }
    public void clickOnGoToCartButton(){
        goToCartButton.click();
    }


}
