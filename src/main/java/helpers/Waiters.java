package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BasePo;

public class Waiters extends BasePo {

	public static int timeoutInSeconds = 10;
	public static WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

    public static void waitWithSleepTimeout(int timeInMillis) throws InterruptedException {
        Thread.sleep(timeInMillis);
    }

    public static void waitForElementToBeDisplayed(By locator) {
      wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilURLContains(String url ) {
    	wait.until(ExpectedConditions.urlContains(url));
    }

    public static void waitForElementToBeVisible(By locator ) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementToBeEnabled(By locator ) {
    	wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementToBeInvisible(By locator ) {
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForElementToBeClickable(By locator ) {
    	wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public static void waitForElementToBeClickable(WebElement element ) {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    

    public static void waitForTabsCount( ) throws InterruptedException {
    	int tabsCount =2;
    	int counter = 0;
        while (driver.getWindowHandles().size() != tabsCount && counter < timeoutInSeconds) {
            waitWithSleepTimeout(100);
            counter++;
        }
        if (counter == timeoutInSeconds) {
            throw new RuntimeException("The browser doesn't have '" + tabsCount + "' tabs after timeout");
        }
    }

    // Wait for an attribute to have a specific value
    public static void  waitForAttributeValueToBePresentInElement(By locator, String attribute, String expectValue, int locatorIndex ) {
    	wait.until(ExpectedConditions.attributeToBe(driver.findElements(locator).get(locatorIndex), attribute, expectValue));
    }

    // Wait for an attribute value to change
    public static void  waitForChangeAttributeValueInElement(By locator, String attribute, String attributeBefore, int locatorIndex ) {
    	wait.until(driver -> !driver.findElements(locator).get(locatorIndex).getAttribute(attribute).equals(attributeBefore));
    }

    // Wait for text to be present in an element
    public static void  waitForTextToBePresentInElement(By locator, String textValue ) {
    	wait.until(ExpectedConditions.textToBe(locator, textValue));
    }

    // Wait for a value to be present in an element
    public static void  waitForValueToBePresentInElement(By locator, String textValue ) {
    	wait.until(ExpectedConditions.attributeToBe(locator, "value", textValue));
    }

    // Wait for text to change in an element
    public static void waitForTextChange(By locator, String textValueBefore, int index ) {
    	wait.until(driver -> !driver.findElements(locator).get(index).getText().equals(textValueBefore));
    }

    // Wait for text change in an element with page refresh
    public static void  waitForTextChangeInElementWithRefresh(By locator, String textValue, int locatorIndex ) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < timeoutInSeconds * 1000L) {
            if (driver.findElements(locator).get(locatorIndex).getText().equals(textValue)) {
                return;
            }
            driver.navigate().refresh();
            waitForElementToBeVisible(locator);
        }
        throw new RuntimeException("Timed out waiting for text change in element");
    }

	 public static void waitForElementToBeNotVisible(By locator) {
    
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
