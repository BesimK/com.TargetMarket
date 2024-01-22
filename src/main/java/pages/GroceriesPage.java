package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GroceriesPage extends BasePage {

	@FindBy(xpath = "//*[@id=\"navbar\"]/div/div/button[2]")
	private WebElement goToCartButton;

	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div/div[1]/div[1]/h3[1]")
	private List<WebElement> addedProducts;

	@FindBy(xpath = "//body/div/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]")
	private List<WebElement> addedProductsInCheckoutPage;

	@FindBy(xpath = "//button[@type=\"button\"][2]")
	private List<WebElement> productQuantityIncreaseButton;

	@FindBy(xpath = "//h2[contains(text(),'Total Price')]")
	private WebElement totalPriceInCheckoutPage;

	public void clickOnGoToCartButton() {
		goToCartButton.click();
	}

	public String getAddedProductName(int index) {
		return addedProducts.get(index).getText();
	}

	public String getAddedProductNameInCheckoutPage(int index) {
		return addedProductsInCheckoutPage.get(index).getText();
	}

	public void clickOnIncreaseButton(int index) {
		productQuantityIncreaseButton.get(index).click();
	}

	public String getTotalPriceInCheckoutPage() {
		return totalPriceInCheckoutPage.getText();
	}

}
