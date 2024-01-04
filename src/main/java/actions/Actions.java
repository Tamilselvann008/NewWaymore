package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.Waiters;

public class Actions extends BasePo {

	public static int maxRetryAttempts = 3;
	public static int retryCount = 1;

	public static void enterText(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	public static void buttonClick(By locator) {
		driver.findElement(locator).click();
	}

	public static String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public static void typeTextWithoutClear(By locator, String text, int index) {
		Waiters.waitForElementToBeVisible(locator);
		List<WebElement> pageElements = driver.findElements(locator);

		pageElements.get(index).click();
		pageElements.get(index).sendKeys(text);
	}

	public static boolean isElementDisplayedByLocator(By locator, int index) {
		Waiters.waitWithSleepTimeout(1000);

		try {
			WebElement[] pageElements = driver.findElements(locator).toArray(new WebElement[0]);

			return pageElements.length > index && pageElements[index].isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static void clickWithJSByLocator(By locator, int index) {

		while (retryCount < maxRetryAttempts) {
			try {
				WebElement[] pageElements = driver.findElements(locator).toArray(new WebElement[0]);
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

				jsExecutor.executeScript("arguments[0].click()", pageElements[index]);
				break;
			} catch (Exception e) {
				if (retryCount >= maxRetryAttempts) {
					throw new RuntimeException(e.getMessage() + ". Unable to click on locator '" + locator.toString()
							+ "' with JS after '" + retryCount + "' retries");
				}
				retryCount++;
			}
		}
	}

	public static void clickByLocator(By locator, int index) {
		WebElement pageElement = ElementUtils.getElementWithWaitByLocator(locator, index);
		int retryCount = 1;

		while (retryCount < maxRetryAttempts) {
			try {
				Waiters.waitForElementToBeVisible(locator);
				Waiters.waitForElementToBeClickable(locator);
				pageElement.click();
				break;
			} catch (Exception e) {
				if (retryCount >= maxRetryAttempts) {
					throw new RuntimeException(e.getMessage() + ". Unable to click on locator '" + locator.toString()
							+ "' after '" + retryCount + "' retries");
				}
				retryCount++;
			}
		}
	}

	public static void clearTextInLocatorAndTypeText(By locator, String text, int index) {
		WebElement pageElement = ElementUtils.getElementWithWaitByLocator(locator, index);
		pageElement.clear();
		pageElement.sendKeys(text);
		Waiters.waitWithSleepTimeout(2500);
	}
	
	
	public static boolean isElementCheckedByLocator(By locator) {
        WebElement pageElement = ElementUtils.getElementWithWaitByLocator( locator,0);
        return pageElement.isSelected();
    }
}
