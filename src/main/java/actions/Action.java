package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.StringUtils;
import helpers.Waiters;

public class Action extends BasePo {

	public static void clearTextInLocatorAndTypeText(By locator, String text) throws InterruptedException {
		Waiters.waitForElementToBeVisible(locator);
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	public static void typeTextInWithoutClear(By locator, String text, int index) {
		Waiters.waitForElementToBeVisible(locator);
		List<WebElement> elements = driver.findElements(locator);

		if (index >= 0 && index < elements.size()) {
			WebElement element = elements.get(index);
			element.click();
			element.sendKeys(text);
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds for elements list");
		}
	}

	public static void clearTextInLocatorAndTypeTextWithEnter(By locator, String text) throws InterruptedException {
		clearTextInLocatorAndTypeText(locator, text);
		Waiters.waitForTextChange(locator, text, 0);
		driver.findElement(locator).sendKeys(Keys.ENTER);
	}

	public static void uploadFileByFileName(By locator, String filePath) {
		WebElement fileUpload = driver.findElement(locator);
		fileUpload.sendKeys(filePath);
	}

	public static void clickByLocator(By locator) throws Exception {
		WebElement element = ElementUtils.getElementByLocator(locator, 0);
		Waiters.waitForElementToBeClickable(locator);
		element.click();
	}

	public static void clickByLocator(WebElement element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void clickWithJSByLocator(By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public static void moveMouseToElementByLocator(By locator) throws InterruptedException {
		Waiters.waitForElementToBeVisible(locator);
		WebElement element = driver.findElement(locator);
		new Actions(driver).moveToElement(element).perform();
	}

	public static boolean isElementDisplayedByLocator(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isElementClickableByLocator(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element.isEnabled() && element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isScrollbarDisplayedByLocator(By locator) {
		WebElement element = driver.findElement(locator);
		long scrollHeight = (long) ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollHeight;",
				element);
		long clientHeight = (long) ((JavascriptExecutor) driver).executeScript("return arguments[0].clientHeight;",
				element);
		return scrollHeight > clientHeight;
	}

	public static boolean isElementExistingByLocator(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element != null;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isElementCheckedByLocator(By locator) {
		WebElement element = driver.findElement(locator);
		String isChecked = element.getAttribute("aria-checked");
		return "true".equals(isChecked);
	}

	public static boolean isElementSelectedByLocator(By locator) {
		WebElement element = driver.findElement(locator);
		String isSelected = element.getAttribute("aria-selected");
		return "true".equals(isSelected);
	}

	public static void selectCheckboxByLocatorAndStatus(By locator, String checkboxStatus) throws InterruptedException {
		boolean isChecked = isElementCheckedByLocator(locator);
		if ((checkboxStatus.equals("Check") && !isChecked) || (checkboxStatus.equals("Uncheck") && isChecked)) {
			clickWithJSByLocator(locator);
		}
	}

	public static void selectOptionFromDropdownByOptionName(By dropdownLocator, By optionLocator, String optionName)
			throws Exception {
		Waiters.waitForElementToBeVisible(dropdownLocator);
		Action.clickByLocator(dropdownLocator);
		Waiters.waitForElementToBeVisible(optionLocator);

		List<WebElement> options = ElementUtils.getElementListWithWaitByLocator(optionLocator);
		for (WebElement option : options) {
			if (StringUtils.getStringByTrim(option.getText()).equals(optionName)) {
				Action.clickByLocator(option);
				break;
			}
		}
		Waiters.waitWithSleepTimeout(2500);
	}

}
