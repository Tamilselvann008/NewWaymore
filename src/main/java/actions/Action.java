package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.StringUtils;
import helpers.Waiters;

public class Action extends BasePo {

	private static final int maxRetryAttempts = 3;

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
	public static void scrollToElementWithJsByLocator(By locator, int index) {
	    int retryCount = 1;
	    WebDriverWait wait = new WebDriverWait(driver, 10); // WebDriverWait with a timeout of 10 seconds

	    while (true) {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Wait for the element to be visible
	            List<WebElement> pageElements = driver.findElements(locator);

	            if (index >= pageElements.size()) {
	                throw new NoSuchElementException("Element not found with the given locator and index.");
	            }

	            WebElement elementToScroll = pageElements.get(index);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
	            break;
	        } catch (Exception e) {
	            if (retryCount >= maxRetryAttempts) {
	                throw new RuntimeException("Unable to scroll to element by locator '" + locator.toString() + "' after " + retryCount + " retries", e);
	            }
	            retryCount++;
	        }
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

	public static void clickByLocator(By locator,int index) throws Exception {
		WebElement element = ElementUtils.getElementByLocator(locator, index);
		//Waiters.waitForElementToBeClickable(locator);
		element.click();
	}
	
	public static void clickSelectDropDownByLoctor(By locator,String value, int index) throws Exception {
		WebElement element = ElementUtils.getElementByLocator(locator, index);
		Waiters.waitForElementToBeClickable(locator);
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
		
	}

	public static void clickByLocator(WebElement element) throws Exception {
		Waiters.waitForElementToBeClickable(element);
		element.click();
	}

	public static void clickWithJSByLocator(By locator,int index) throws Exception {
		WebElement element = ElementUtils.getElementByLocator(locator, index);
//		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	public static void clickWithJSByElement(WebElement element,int index) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
		
		public static void moveMouseToElementByLocator(By locator,int index) throws Exception {
		Waiters.waitForElementToBeVisible(locator);
		WebElement element = ElementUtils.getElementByLocator(locator, index);
		new Actions(driver).moveToElement(element).perform();
	}

	public static boolean isElementDisplayedByLocator(By locator,int index) {
		try {
			WebElement element = ElementUtils.getElementByLocator(locator, index);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isElementClickableByLocator(By locator,int index) {
		try {
			WebElement element = ElementUtils.getElementByLocator(locator, index);
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

	public static void selectCheckboxByLocatorAndStatus(By locator, String checkboxStatus) throws Exception {
		boolean isChecked = isElementCheckedByLocator(locator);
		if ((checkboxStatus.equals("Check") && !isChecked) || (checkboxStatus.equals("Uncheck") && isChecked)) {
			clickWithJSByLocator(locator, 0);
		}
	}

	public static void selectOptionFromDropdownByOptionName(By dropdownLocator, By optionLocator, String optionName)
			throws Exception {
		Waiters.waitForElementToBeVisible(dropdownLocator);
		Action.clickByLocator(dropdownLocator, 0);
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

	public static void clearTextInLocatorWithExtraTempSpace(By locator) throws InterruptedException {
	    Waiters.waitForElementToBeVisible(locator);
	    WebElement element = driver.findElement(locator);
	    element.clear();
	    element.sendKeys(Keys.SPACE); // Sending a temporary space
	    element.sendKeys(Keys.BACK_SPACE); // Removing the space
	    Waiters.waitWithSleepTimeout(2500); // Assuming you have a similar wait method in Waiters class
	}

	public static void typeTextInLocatorWithoutClear(By locator, String text, int index) throws InterruptedException {
	    Waiters.waitForElementToBeVisible(locator);
	    List<WebElement> elements = driver.findElements(locator);

	    if (index >= 0 && index < elements.size()) {
	        WebElement element = elements.get(index);
	        element.click();
	        element.sendKeys(text);
	    } else {
	        throw new IndexOutOfBoundsException("Index out of bounds for elements list.");
	    }
	}

	 public static void scrollIntoView(By locator) {
		 WebElement element = driver.findElement(locator);
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//	        js.executeScript("arguments[0].scrollIntoView(true);", element);
		 
		 // Create an instance of Actions class
         Actions actions = new Actions(driver);
         // Move to the element
         actions.moveToElement(element).perform();
	    }
	 public static void scrollIntoView(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }
	 public static void switchToHandleByTabNumber(int tabNumber) {
	        Object[] handles = driver.getWindowHandles().toArray();
	        if (tabNumber > 0 && tabNumber <= handles.length) {
	            driver.switchTo().window(handles[tabNumber - 1].toString());
	            driver.manage().window().maximize();
	        } else {
	            throw new IllegalArgumentException("Tab number out of range");
	        }
	    }

	 public static void clearTextInLocator(By locator, int index) {
        Waiters.waitForElementToBeVisible( locator);
        List<WebElement> elements = driver.findElements(locator);
        
        if (index < elements.size()) {
            WebElement elementToClear = elements.get(index);
            elementToClear.clear();
        } else {
            // Handle the case where the index is out of bounds
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + elements.size());
        }
    }

	

}
