package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtils {
    public static void clickDependingBrowser(WebDriver driver, WebElement element, String browser) {
        if (browser.equals("firefox")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } else {
            element.click();
        }
    }

    public static String getValueByLocatorThroughJSExecutor(WebDriver driver, String locator) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String script = String.format("return document.querySelector('#%s').value", locator);

        return (String) executor.executeScript(script);
    }

    public static int createTab(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.open()");

        return driver.getWindowHandles().size() - 1;
    }

}