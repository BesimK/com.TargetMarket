package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LaptopsPage extends BasePage {

	@FindBy(xpath = "//p[text()='Total: $']")
	private List<WebElement> pricesInShoppingCart;

	@FindBy(xpath = "//h5[@class='display-5']")
	private WebElement welcomeHeaderText;

	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement logoutButton;

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

	public LaptopsPage() {
		super();
	}

	public void clickOnLoginButton() {
		logoutButton.click();
	}

	public String getWelcomeHeaderText() {
		return welcomeHeaderText.getText();
	}

	public boolean isUserCorrect(String user) {
		String welcomeHeader = "Welcome to the Target Market, " + user + "!";
		return getWelcomeHeaderText().equalsIgnoreCase(welcomeHeader);
	}

	public void clickOnSelectedProduct(String productName) {
		addToCartButtonList.get(productsForNoneOption().get(productName)).click();
	}

	public String getCountOfShoppingCart() {
		return shoppingCartIcon.getText();
	}

	public void clickOnShoppingCartIcon() {
		shoppingCartIcon.click();
	}

	public void pressPlusMinusSignInShoppingCart(int number) {
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

	// PRIVATE METHOD

	private Map<String, Integer> productsForNoneOption() {
		Map<String, Integer> list = new HashMap<>();
		list.put("MacBook Pro", 0);
		list.put("Samsung Galaxy Book", 1);
		list.put("Microsoft Surface Laptop 4", 2);
		list.put("Infinix INBOOK", 3);
		list.put("HP Pavilion 15-DK1056WM", 4);
		return list;
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

}