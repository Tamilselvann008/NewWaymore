package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BasePo;

public class Waiters extends BasePo {

	public static int timeout = 25000;
	public static WebDriverWait wait = new WebDriverWait(driver, timeout);

	public static void waitForElementToBeDisplayed(By locator, WebDriver driver) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (TimeoutException e) {
			throw new TimeoutException("Timed out waiting for the element to be displayed: " + locator.toString());
		}
	}

	public static void waitForElementToBeInvisible(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static void waitForElementToBeClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void waitForElementToBeDisplayed(By locator) {
		WebElement pageElement = driver.findElement(locator);
		try {
			wait.until(ExpectedConditions.visibilityOf(pageElement));
		} catch (TimeoutException e) {
			throw new TimeoutException(String.format(
					"Waiting for the element with locator '%s' to be displayed has timed out after %s seconds",
					locator.toString(), timeout), e);
		}
	}

	public static void waitForElementToBeEnabled(By locator) {
		WebElement pageElement = driver.findElement(locator);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(pageElement));
		} catch (TimeoutException e) {
			throw new TimeoutException(String.format(
					"Waiting for the element with locator '%s' to be enabled has timed out after %s seconds",
					locator.toString(), timeout), e);
		}
	}

	public static void waitForElementToBeNotVisible(By locator) {
		WebElement pageElement = driver.findElement(locator);
		try {
			wait.until(ExpectedConditions.invisibilityOf(pageElement));
		} catch (TimeoutException e) {
			throw new TimeoutException("Timed out waiting for the element to be not visible: " + locator.toString());
		}
	}

	public static void waitWithSleepTimeout(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void waitForElementToBeVisible(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			throw new TimeoutException("Timed out waiting for the element to be visible: " + locator.toString());
		}
	}

}
