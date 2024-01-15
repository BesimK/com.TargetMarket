package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TargetMarketLoginPage extends BasePage {

	@FindBy(id = "login-username-input")
	private WebElement usernameTextField;

	@FindBy(id = "login-password-input")
	private WebElement passwordTextField;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	public void login(String username, String password) {
		usernameTextField.clear();
		usernameTextField.sendKeys(username);
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		loginButton.click();
	}

}
