package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import basePackage.BasePo;

public class ElementUtils extends BasePo {

	private static final int maxRetryAttempts = 3;
	public static int retryCount = 1;

	public static WebElement getElementWithWaitByLocator(By locator, int index) {

		while (retryCount < maxRetryAttempts) {
			try {
				WebElement[] pageElements = driver.findElements(locator).toArray(new WebElement[0]);
				return pageElements[index];
			} catch (Exception e) {
				if (retryCount >= maxRetryAttempts) {
					throw new RuntimeException(e.getMessage() + ". Unable to get locator '" + locator.toString()
							+ "' with wait after '" + retryCount + "' retries");
				}
				retryCount++;
			}
		}
		return null;
	}

	public static String getTextByLocator(By locator, int index) {
		while (retryCount < maxRetryAttempts) {
			try {
				return getElementWithWaitByLocator(locator, index).getText();
			} catch (Exception e) {
				if (retryCount >= maxRetryAttempts) {
					throw new RuntimeException(e.getMessage() + ". Unable to get text from locator '"
							+ locator.toString() + "' after '" + retryCount + "' retries");
				}
				retryCount++;
			}
		}
		return null;
	}

}
