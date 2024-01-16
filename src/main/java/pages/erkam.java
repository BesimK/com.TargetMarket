package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class erkam {
    // Arkadaşlar projemizde metodlarımızı yazarken bu şekilde yazalım.

    @FindBy(xpath = "//h5[@class=\"display-5\"]")
    private WebElement welcomeText;

    @FindBy(xpath = "//button[text()=\"Logout\"]")
    private WebElement logoutButton;

    @FindBy(xpath = "(//ul[@id=\"splide02-list\"]/li)")
    private List<WebElement> tabs;

    @FindBy(xpath = "(//ul[@id=\"splide02-list\"])")
    private WebElement slideList;

    @FindBy(xpath = "//span[@class=\"cart-badge m-0 mt-1 badge rounded-pill bg-danger\"]")
    private WebElement cartCounter;
}
