package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "(//a[@href='/'])[1]")
    private WebElement inarAcademyImage;

    @FindBy(linkText = "Target Market")
    private WebElement targetMarketLink;

    public void clickOnTargetMarketLink() {
        targetMarketLink.click();
    }

    public void clickInarAcademyImageLink(){
        inarAcademyImage.click();
    }
}
