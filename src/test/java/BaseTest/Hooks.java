package BaseTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.BrowserUtils;
import utils.Driver;
import utils.Pages;

public class Hooks {

	private static final String browser = Driver.browser;

	protected static Pages pages = new Pages();


	@BeforeSuite
	public static void setUp() {
		Driver.getDriver().get("https://InarAcademy:Fk160621.@test.inar-academy.com");
		if (browser.equalsIgnoreCase("firefox")) {
			Driver.getDriver().navigate().refresh();
		}
		pages.getHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user","secret_password");
		BrowserUtils.wait(2.0);
	}

	@AfterSuite
	public static void tearDown() {
		Driver.closeDriver();
	}

}
