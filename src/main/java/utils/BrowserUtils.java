package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class BrowserUtils {

	static JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

	public static void scrollDownWithPageDown() {
		Actions actions = new Actions(Driver.getDriver());
		actions.keyDown(Keys.PAGE_DOWN).release().build().perform();
		wait(2.0);
	}

	public static void pressHomeButton() {
		Actions actions = new Actions(Driver.getDriver());
		actions.keyDown(Keys.HOME).release().build().perform();
		wait(2.0);
	}

	public static void scrollVertically(int pixelAmount) {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scroll(0," + pixelAmount + ")");
	}

	public static void scrollUpWithPageUp() {
		Actions actions = new Actions(Driver.getDriver());
		actions.keyDown(Keys.PAGE_UP).release().build().perform();
		wait(2.0);
	}

	public static void wait(double timeout) {
		try {
			Thread.sleep((long) timeout * 1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
