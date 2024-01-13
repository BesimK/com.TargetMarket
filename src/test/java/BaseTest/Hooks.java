package BaseTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Pages;

public class Hooks {


    private static final String browser = Driver.browser;
    protected static Pages pages = new Pages();

    @BeforeAll
    public static void setUp() {
        Driver.getDriver().get("https://InarAcademy:Fk160621.@test.inar-academy.com");
        if (browser.equalsIgnoreCase("firefox")) {
            Driver.getDriver().navigate().refresh();
        }
    }

    @AfterAll
    public static void tearDown() {
        Driver.closeDriver();
    }

}
