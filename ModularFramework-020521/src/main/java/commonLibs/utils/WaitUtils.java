package commonLibs.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static void waitForSeconds(int timeOutInSeconds) throws Exception {
		Thread.sleep(timeOutInSeconds * 1000);
	}
	
	public static void waitTillAlertIsPresent(WebDriver driver, int timeOutInSeconds) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void WaitTillElementIsVisible(WebDriver driver, WebElement element, int timeOutInSeconds) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void WaitTillElementIsClickable(WebDriver driver, WebElement element, int timeOutInSeconds) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void WaitTillElementIsSelectable(WebDriver driver, WebElement element, int timeOutInSeconds) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

}
