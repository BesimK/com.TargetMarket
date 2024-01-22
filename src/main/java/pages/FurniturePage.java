package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FurniturePage extends BasePage {

	@FindBy(xpath = "//div[1]/h1/strong")
	private WebElement headerOfFurniturePage;

	@FindBy(xpath = "//button[text()=\"Add to Cart\"]")
	private List<WebElement> ListAddCartButton;

	@FindBy(xpath = "//div[contains(@class,'p-4 list-group-item')]")
	private List<WebElement> shoppingCardProducts;

	@FindBy(xpath = "//div[@class='d-flex align-items-center']/button[1]")
	private List<WebElement> removeButtons;

	@FindBy(xpath = "//p[contains(text(),'Your cart is empty.')]")
	private WebElement emptyMessage;

	@FindBy(id = "sortType")
	private WebElement sortByButton;

	@FindBy(xpath = "//h5[@class='card-title']")
	private List<WebElement> cartTitles;

	@FindBy(xpath = "//strong[@class='text-danger']/child::i")
	private List<WebElement> priceListOfFurniturePage;

	public FurniturePage() {
		super();
	}

	public String getHeaderOfFurniturePage() {
		return headerOfFurniturePage.getText();
	}

	public int getShoppingCartSize() {
		return shoppingCardProducts.size();
	}

	public String getEmptyMessage() {
		return emptyMessage.getText();
	}

	public String getTitleOfProduct(int productOrder) {
		return cartTitles.get(productOrder - 1).getText();
	}

	public void clickOnSortByButton(String option) {
		Select select = new Select(sortByButton);
		select.selectByVisibleText(option);
	}

	public void clickOnRemoveButtons() {
		for (int i = 0; i < 5; i++) {
			removeButtons.get(0).click();
			BrowserUtils.wait(1.0);
		}
	}

	public void clickTheAddCartButton(int product) {
		if (product > 4) {
			BrowserUtils.scrollDownWithPageDown();
			ListAddCartButton.get(product - 1).click();

		}
		else {
			ListAddCartButton.get(product - 1).click();
		}
	}

	public void clickAllTheAddToCarts() {

		int number = 0;
		for (int i = 0; i < 5; i++) {
			if (i < 4) {
				ListAddCartButton.get(number).click();
			}
			else {
				BrowserUtils.scrollDownWithPageDown();
				ListAddCartButton.get(number).click();
			}
		}
	}

	public String getTheProductNameFromShoppingCart(int productNumber) {
		return shoppingCardProducts.get(productNumber - 1).getText();
	}

	public String textOfList(int product) {
		List<String> elements = Collections.singletonList(shoppingCardProducts.get(product - 1).getText());
		return elements.get(product - 1);
	}

	public boolean checkTextOfShoppingCart(int productNumber, String productName) {
		String element = getTheProductNameFromShoppingCart(productNumber);
		if (element.contains(productName)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean areSmartphonesSortByLowestPriceCorrectly() {
		ArrayList<Integer> expectedList = expectedLowestPriceList(priceListOfFurniturePage);
		ArrayList<Integer> actualList = actualLowestPriceList(priceListOfFurniturePage);

		for (int i = 0; i < actualList.size(); i++) {
			if (!expectedList.get(i).equals(actualList.get(i))) {
				return false;
			}
		}
		return true;
	}

	private ArrayList<Integer> priceListInInteger(ArrayList<String> priceListWithout$Signs) {

		priceListWithout$Signs = priceListWithout$Signs(priceListOfFurniturePage);
		ArrayList<Integer> integer = new ArrayList<>();

		for (int i = 0; i < priceListWithout$Signs.size(); i++) {
			integer.add(Integer.parseInt(priceListWithout$Signs.get(i).trim()));
		}
		return integer;
	}

	private ArrayList<String> priceListWithout$Signs(List<WebElement> list) {
		ArrayList<String> priceListWithout$Signs = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			priceListWithout$Signs.add(priceListOfFurniturePage.get(i).getText().trim().replace("$", " "));
		}
		return priceListWithout$Signs;
	}

	private ArrayList<Integer> actualLowestPriceList(List<WebElement> list) {
		ArrayList<String> priceListWithout$Signs = priceListWithout$Signs(priceListOfFurniturePage);
		return priceListInInteger(priceListWithout$Signs);
	}

	private ArrayList<Integer> expectedLowestPriceList(List<WebElement> list) {
		ArrayList<String> priceListWithout$Signs = priceListWithout$Signs(priceListOfFurniturePage);
		ArrayList<Integer> priceListInInteger = priceListInInteger(priceListWithout$Signs);
		Collections.sort(priceListInInteger);
		return priceListInInteger;
	}

}
