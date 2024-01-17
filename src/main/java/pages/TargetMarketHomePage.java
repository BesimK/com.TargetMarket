package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.JSUtils;

import java.util.List;


public class TargetMarketHomePage extends BasePage {
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

	@FindBy(xpath = "//div[text()=\"Product added to cart!\"]")
	private WebElement notificationForCart;

	@FindBy(xpath = "//button[text()=\"Go to Checkout\"]")
	private WebElement goToCheckoutButton;

	@FindBy(xpath = "//button[@aria-label=\"Close\"]")
	private WebElement closeDialogButton;

	@FindBy(xpath = "(//h1)[1]")
	private WebElement checkOutMessage;

	@FindBy(linkText = "target-market")
	private WebElement logo;
	@FindBy(xpath = "//button[@class=\"btn btn-danger fs-3 w-100\"]")
	private List<WebElement> addToCartButtons;


	public void clickLogoutButton() {
		logoutButton.click();
	}

	public void swipeTabsLeft(){
		JSUtils.executeJS("arguments[0].setAttribute('style','transform: translateX(-285px);')", slideList);
		BrowserUtils.wait(2.0);
	}

	public void clickTab(int tabIndex){
		BrowserUtils.scrollDownWithPageDown();
		if(tabIndex>7) {
			swipeTabsLeft();
		}
		tabs.get(tabIndex).click();
	}

	public boolean addedToCartDialogueIsDisplayed(){
		return notificationForCart.isDisplayed();
	}

	public String getTextFromCartCounter(){
		return cartCounter.getText();
	}

	public void clickCartButton(){
		cartCounter.click();
	}

	public void clickGoToCheckoutButton(){
		goToCheckoutButton.click();
		BrowserUtils.wait(2.0);
	}

	public String getCheckoutMessage(){
		return checkOutMessage.getText();
	}

	public void clickCloseDialogButton(){
		closeDialogButton.click();
	}

	public void clickTopsPageLink() {
		tabs.get(7).click();
	}

	public void clickLogoToRefresh(){
		logo.click();
	}

	public void clickAddToCartButton(int... buttons) throws Exception {
		BrowserUtils.scrollDownWithPageDown();
		int scrollCounter;
		for(int button:buttons){
			scrollCounter = 0;
			for(int c = (button-1)/4;c>0;c--){
				BrowserUtils.scrollDownWithPageDown();
				++scrollCounter;
			}
			addToCartButtons.get(button-1).click();
			BrowserUtils.wait(1.5);
			if(!checkNotification()){
				throw new Exception();
			}
			BrowserUtils.wait(2.0);
			for (int j = 0; j < scrollCounter; j++) {
				BrowserUtils.scrollUpWithPageUp();
			}
		}
	}

	public boolean checkNotification(){
		return notificationForCart.isDisplayed();
	}
}