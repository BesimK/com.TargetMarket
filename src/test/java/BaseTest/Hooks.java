package BaseTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;
import utils.Driver;
import utils.Pages;

public class Hooks {

	private static final String browser = Driver.browser;

	protected static Pages pages;

	protected SoftAssert softAssert = new SoftAssert();

	@BeforeClass
	public static void setUp() {
		Driver.getDriver().get("https://InarAcademy:Fk160621.@test.inar-academy.com");
		pages = new Pages();
		if (browser.equalsIgnoreCase("firefox")) {
			Driver.getDriver().navigate().refresh();
		}
		pages.getHomePage().clickOnTargetMarketLink();
		pages.getTargetMarketLoginPage().login("standard_user", "secret_password");
		BrowserUtils.wait(2.0);
	}

	@AfterClass
	public static void tearDown() {
		Driver.closeDriver();
	}

}
