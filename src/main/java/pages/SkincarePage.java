package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SkincarePage extends BasePage {

	@FindBy(css = "h1")
	private WebElement skincarePageHeader;

	@FindBy(xpath = "//*[@id=\"sortType\"]/option")
	private List<WebElement> sortByDropdownList;

	@FindBy(id = "sortType")
	private WebElement sortByDropdown;

	@FindBy(css = "#market-items-target .text-danger")
	private List<WebElement> productPriceList;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li/div[1]/div[2]/span[1]")
	private List<WebElement> productListInCheckoutPage;

	public String getSkincarePageHeader() {
		return skincarePageHeader.getText();
	}

	public void clickSortByDropdown() {
		sortByDropdown.click();
	}

	public void selectSortByDropdownElement(int index) {
		sortByDropdownList.get(index).click();
	}

	public int getProductPrice(int index) {
		String priceWithDollar = productPriceList.get(index).getText();
		String price = priceWithDollar.charAt(1) + "" + priceWithDollar.charAt(2);
		return Integer.parseInt(price);
	}

	public String getProductNameInCart(int index) {
		return productListInCheckoutPage.get(index).getText();
	}

}
