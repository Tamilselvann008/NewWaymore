package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import basePackage.BasePo;
@SuppressWarnings("unchecked")
public class ElementUtils extends BasePo {
	 public static WebElement getElementByLocator(By locator, int index) throws Exception {
	        Waiters.waitForElementToBeVisible(locator);
	        List<WebElement> pageElements = driver.findElements(locator);
	        if (pageElements.isEmpty() || index >= pageElements.size()) {
	            throw new Exception("Element not found with the given locator and index.");
	        }
	        return pageElements.get(index);
	    }
	 public static WebElement getElementWithWaitByLocator(By locator, int index) throws Exception {
	        int retryCount = 1;
	        int maxRetryAttempts =3;
	        while (retryCount <= maxRetryAttempts) {
	            try {
	                Waiters.waitForElementToBeVisible(locator);
	                List<WebElement> pageElements = driver.findElements(locator);
	                if (index >= 0 && index < pageElements.size()) {
	                    return pageElements.get(index);
	                } else {
	                    throw new Exception("Element not found with the given locator and index.");
	                }
	            } catch (Exception e) {
	                if (retryCount >= maxRetryAttempts) {
	                    throw new Exception(String.format("%s. Unable to get locator '%s' with wait after %d retries", e.getMessage(), locator.toString(), retryCount));
	                }
	                retryCount++;
	            }
	        }
	        throw new Exception("Unable to find element after retries");
	    }
	 
	 
	
	    public static String getTextByLocator(By locator, int index) throws Exception {
	        WebElement element = getElementByLocator(locator, index);
	        return element.getText();
	    }
	    public static String getTextByLocator(WebElement locator) {
	        
	        return locator.getText();
	    }

	    public static String getValueByLocator(By locator, int index) throws Exception {
	        WebElement element = getElementByLocator(locator, index);
	        return element.getAttribute("value");
	    }

	    public static List<WebElement> getElementListWithWaitByLocator(By locator) throws InterruptedException {
	        Waiters.waitForElementToBeVisible(locator);
	        return driver.findElements(locator);
	    }

	    public static List<String> getTextListByLocator(By locator) throws Exception {
	        Waiters.waitForElementToBeVisible(locator);
	        List<WebElement> elements = driver.findElements(locator);
	        List<String> output = new ArrayList<>();
	        for(WebElement e : elements) {
	        	//System.out.println(e.getText());
	        	output.add(e.getText());
	        }
//	        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
	       // System.out.println(output);
	        return output;
	    }
	    
	    public static String getTextWithJSByLocator(By locator, int index) throws Exception {
	        WebElement element = getElementByLocator(locator, index);
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        return (String) jsExecutor.executeScript("return arguments[0].textContent;", element);
	    }

	    public static List<String> getValueListWithJSByLocator(By locator) throws InterruptedException {
	        Waiters.waitForElementToBeVisible(locator);
	        List<WebElement> elements = driver.findElements(locator);
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        return elements.stream()
	                       .map(element -> (String) jsExecutor.executeScript("return arguments[0].value;", element))
	                       .collect(Collectors.toList());
	    }

	    public static List<String> getTextListWithJSByLocator(By locator) throws InterruptedException {
	        Waiters.waitForElementToBeVisible(locator);
	        List<WebElement> elements = driver.findElements(locator);
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        return elements.stream()
	                       .map(element -> (String) jsExecutor.executeScript("return arguments[0].textContent;", element))
	                       .collect(Collectors.toList());
	    }

	    public static int getElementListCountByLocator(By locator) throws InterruptedException {
	        Waiters.waitForElementToBeVisible(locator);
	        return driver.findElements(locator).size();
	    }

	    public static String getAttributeByLocator(By locator, String attribute, int index) throws Exception {
	        WebElement element = getElementByLocator(locator, index);
	        return element.getAttribute(attribute);
	    }

	    public static List<String> getAttributeListByLocator(By locator, String attribute) throws InterruptedException {
	        Waiters.waitForElementToBeVisible(locator);
	        List<WebElement> elements = driver.findElements(locator);
	        return elements.stream().map(element -> element.getAttribute(attribute)).collect(Collectors.toList());
	    }
	    
	   
	    public static String getCssValueByElement(By locator, String value, int index) throws Exception {
	        WebElement element = getElementByLocator(locator, index);
	        return element.getCssValue(value);
	    }
	    public static String getTextByLocatorAndPseudoElement(By locator, String pseudoElement, String propertyValue) throws Exception {
	        WebElement element = getElementByLocator(locator, 0);
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        String script = String.format(
	            "return window.getComputedStyle(arguments[0], ':%s').getPropertyValue('%s');",
	            pseudoElement,
	            propertyValue
	        );
	        return (String) jsExecutor.executeScript(script, element).toString().replace("\"", "");
	    }

	    public static String getFirstChildHtmlOfElementWithJSByLocator(By locator) throws Exception {
	        WebElement element = getElementByLocator(locator, 0);
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        return (String) jsExecutor.executeScript("return arguments[0].firstChild.innerHTML;", element);
	    }

	    public static Object getPropertyByLocator(By locator, String property, int index) throws Exception {
	        WebElement element = getElementByLocator(locator, index);
	        return element.getAttribute(property);
	    }

	    
		public static List<WebElement> getShadowDomElementList(By rootLocator, By shadowLocator) throws Exception {
	        Waiters.waitForElementToBeVisible(rootLocator);
	        WebElement rootElement = getElementByLocator(rootLocator, 0);
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        return (List<WebElement>) jsExecutor.executeScript("return arguments[0].shadowRoot.querySelectorAll(arguments[1])", rootElement, shadowLocator);
	    }

	    public static List<String> getTextListByElements(List<WebElement> elements) throws InterruptedException {
	        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
	    }



	}