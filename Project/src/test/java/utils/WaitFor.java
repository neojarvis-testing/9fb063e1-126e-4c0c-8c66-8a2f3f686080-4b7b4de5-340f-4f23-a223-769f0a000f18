package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {
     WebDriver driver;

	 public WaitFor(WebDriver driver) {
        this.driver = driver;
    }

	static WebDriverWait wait=new WebDriverWait(Root.driver, Duration.ofSeconds(Integer.parseInt(Root.prop.getProperty("defaultExplicitWait"))));
	
	public static void waitForElemetToBeClickable(By elementLocator) {
		wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
	}
	
	public static void waitForElemetToBeVisible(By elementLocator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}
	
	public static void waitForPageVisiblity(String url) {
		wait.until(ExpectedConditions.urlToBe(url));
	}
}

