package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopsPage extends BasePage {

	@FindBy(xpath = "//button[text()='Add to Cart']")
	private List<WebElement> addToCartButtons;

	@FindBy(id = "//*[@id=\"sortType\"]/option")
	private List<WebElement> sortByDropDownElements;

	@FindBy(xpath = "//button[2]/span")
	private WebElement goToCartButton;

	@FindBy(xpath = "//button[text()='Go to Checkout']")
	private WebElement goToCheckOutButton;

	public void clickOnAddToCartButton(int index) {

		addToCartButtons.get(index).click();

	}

	public void clickOnGoToCartButton() {
		goToCartButton.click();
	}

	public void clickOnGoCheckOutButton() {
		goToCheckOutButton.click();
	}

	public String getTextOfCartButton() {
		return goToCartButton.getText();
	}

}
