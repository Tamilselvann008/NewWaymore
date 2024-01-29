package pages.contactInsights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePo;
import helpers.Waiters;

import java.util.List;
import java.util.stream.Collectors;

public class OverviewTabPo extends BasePo {
    private By overviewPlaceholderTotalValue = By.cssSelector("wm-tab-overview .contact__total .contact__total-value");

    private WebDriver driver;

    public OverviewTabPo(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }

    public List<String> getOverviewPlaceholderTotalTextList() {
        Waiters.waitForElementToBeDisplayed(overviewPlaceholderTotalValue);
        List<WebElement> elements = driver.findElements(overviewPlaceholderTotalValue);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
