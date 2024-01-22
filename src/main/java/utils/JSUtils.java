package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSUtils {

	private static final JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

	public static void executeJS(String jsCommand, WebElement element) {
		js.executeScript(jsCommand, element);
	}

}
