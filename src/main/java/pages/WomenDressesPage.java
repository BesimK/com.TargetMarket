package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

import java.util.*;

public class WomenDressesPage extends BasePage {

	@FindBy(xpath = "//button[@class=\"btn btn-danger fs-3 w-100\"]")
	private List<WebElement> addToCartButtons;

	@FindBy(xpath = "//div[text()=\"Product added to cart!\"]")
	private WebElement notificationForCart;

	@FindBy(id = "sortType")
	private WebElement sortByDropDownList;

	@FindBy(xpath = "//p[text()='Total: $']")
	private List<WebElement> pricesInShoppingCart;

	@FindBy(xpath = "//img[@alt='Targets Logo']")
	private WebElement targetsLogo;

	@FindBy(xpath = "//strong[@class='text-danger']/child::i")
	private List<WebElement> priceListOfSmartphones;

	@FindBy(xpath = "//button[@class='btn btn-danger fs-3 w-100']")
	private List<WebElement> addToCartButtonList;

	@FindBy(xpath = "//div[@class='modal-content']/div/div/child::p")
	private WebElement totalPriceInShoppingCart;

	@FindBy(xpath = "(//div[@class='d-flex align-items-center']/child::button)")
	private List<WebElement> plusMinusSignsInShoppingCart;

	@FindBy(xpath = "//span[@class='cart-badge m-0 mt-1 badge rounded-pill bg-danger']")
	private WebElement shoppingCartIcon;

	@FindBy(xpath = "(//div[@class='d-flex align-items-center justify-content-start']/child::img)")
	private List<WebElement> shoppingCartProductList;

	public void clickOnSortByToChose(String sortOption) {
		Select select = new Select(sortByDropDownList);
		select.selectByVisibleText(sortOption);
		actions.moveToElement(targetsLogo).click().perform();
	}

	public void clickOnShoppingCartIcon() {
		shoppingCartIcon.click();
	}

	public void pressMinusSignInShoppingCart(int number) {
		plusMinusSignsInShoppingCart.get(number).click();
	}

	public boolean isTotalPriceInShoppingCartCorrect() {
		double totalPrice = totalPriceInShoppingCart();
		double totalPerItems = productPricesInTotal();
		return totalPrice == totalPerItems;
	}

	public boolean areTheseProductsAddedToShoppingCart(String... products) {
		ArrayList<String> shoppingCartProductList = shoppingCartProductList();
		for (int i = 0; i < products.length; i++) {
			if (!shoppingCartProductList.get(i).equalsIgnoreCase(products[i])
					|| shoppingCartProductList.size() != products.length) {
				return false;
			}
		}
		return true;
	}

	public boolean areSmartphonesSortByHighestPriceCorrectly() {
		ArrayList<Integer> expectedList = expectedHighestPriceList(priceListOfSmartphones);
		ArrayList<Integer> actualList = actualHighestPriceList(priceListOfSmartphones);

		for (int i = 0; i < actualList.size(); i++) {
			if (!expectedList.get(i).equals(actualList.get(i))) {
				return false;
			}
		}
		return true;
	}

	public void clickOnSelectedProduct(String chosenProduct) {

		ArrayList<String> selectedOption = new ArrayList<>();
		selectedOption.add(sortByDropDownList.getAttribute("value"));

		if (selectedOption.get(0).equalsIgnoreCase("HighestPrice")) {
			Map<String, Integer> key = productsForHighestPrice();
			addToCartButtonList.get(key.get(chosenProduct)).click();

		}
		else if (selectedOption.get(0).equalsIgnoreCase("LowestPrice")) {
			Map<String, Integer> key = productsForLowestPrice();
			addToCartButtonList.get(key.get(chosenProduct)).click();
		}
	}

	public String getCountOfShoppingCart() {
		return shoppingCartIcon.getText();
	}

	// PRIVATE METHODS

	private Map<String, Integer> productsForHighestPrice() {
		Map<String, Integer> list = new HashMap<>();
		list.put("Samsung Universe 9", 0);
		list.put("iPhone X", 1);
		list.put("iPhone 9", 2);
		list.put("Huawei P30", 3);
		list.put("OPPOF19", 4);
		return list;
	}

	private Map<String, Integer> productsForLowestPrice() {
		Map<String, Integer> list = new HashMap<>();
		list.put("Samsung Universe 9", 4);
		list.put("iPhone X", 3);
		list.put("iPhone 9", 2);
		list.put("Huawei P30", 1);
		list.put("OPPOF19", 0);
		return list;
	}

	private ArrayList<Integer> priceListInInteger(ArrayList<String> priceListWithout$Signs) {

		priceListWithout$Signs = priceListWithout$Signs(priceListOfSmartphones);
		ArrayList<Integer> integer = new ArrayList<>();

		for (int i = 0; i < priceListWithout$Signs.size(); i++) {
			integer.add(Integer.parseInt(priceListWithout$Signs.get(i).trim()));
		}
		return integer;
	}

	private ArrayList<Integer> actualHighestPriceList(List<WebElement> list) {
		ArrayList<String> priceListWithout$Signs = priceListWithout$Signs(priceListOfSmartphones);
		return priceListInInteger(priceListWithout$Signs);
	}

	private ArrayList<Integer> expectedHighestPriceList(List<WebElement> list) {
		ArrayList<String> priceListWithout$Signs = priceListWithout$Signs(priceListOfSmartphones);
		ArrayList<Integer> priceListInInteger = priceListInInteger(priceListWithout$Signs);
		Collections.sort(priceListInInteger);
		Collections.reverse(priceListInInteger);
		return priceListInInteger;
	}

	private ArrayList<String> priceListWithout$Signs(List<WebElement> list) {
		ArrayList<String> priceListWithout$Signs = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			priceListWithout$Signs.add(priceListOfSmartphones.get(i).getText().trim().replace("$", " "));
		}
		return priceListWithout$Signs;
	}

	private ArrayList<String> shoppingCartProductList() {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < shoppingCartProductList.size(); i++) {
			list.add(shoppingCartProductList.get(i).getAttribute("alt"));
		}
		return list;
	}

	private double totalPriceInShoppingCart() {
		return Double.parseDouble(totalPriceInShoppingCart.getText().substring(14));
	}

	private double productPricesInTotal() {
		double total = 0;
		for (int i = 0; i < pricesInShoppingCart.size(); i++) {
			double number = Double.parseDouble(pricesInShoppingCart.get(i).getText().substring(8));
			total += number;
		}
		return total;
	}

	// Generic multiple product selector
	public void clickAddToCartButton(int... buttons) throws Exception {
		int scrollCounter;
		for (int button : buttons) {
			scrollCounter = 0;
			for (int c = (button - 1) / 4; c > 0; c--) {
				BrowserUtils.scrollDownWithPageDown();
				++scrollCounter;
			}
			addToCartButtons.get(button - 1).click();
			BrowserUtils.wait(1.5);
			if (!checkNotification()) {
				throw new Exception();
			}
			BrowserUtils.wait(2.0);
			for (int j = 0; j < scrollCounter; j++) {
				BrowserUtils.scrollUpWithPageUp();
			}
		}
	}

	public boolean checkNotification() {
		return notificationForCart.isDisplayed();
	}

	public void clickAddToCartButton1(int productIndex) {
		for (int c = productIndex / 5; c > 0; c /= 5) {
			BrowserUtils.scrollDownWithPageDown();
		}
		addToCartButtons.get(productIndex - 1).click();
	}

}