package pages.contactInsights;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import helpers.ElementUtils;
import helpers.Waiters;
import basePackage.BasePo;

public class CustomFieldsTabPo extends BasePo {

	public CustomFieldsTabPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private By customFieldHeader = By.cssSelector(".values-container .header");
	private By tabLabel = By.cssSelector("[role='tablist'] .mat-tab-label");

	private By customFieldByCustomFieldName(String customFieldName) {
		return By.xpath("//p[text()='" + customFieldName + "']/following-sibling::p");
	}

	public boolean isTabByNameActive(String tabName) throws Exception {
		Waiters.waitForElementToBeVisible(tabLabel);
		List<WebElement> tabList = driver.findElements(tabLabel);
		for (int i = 0; i < tabList.size(); i++) {
			if (tabList.get(i).getText().equals(tabName)) {
				String attribute = tabList.get(i).getAttribute("class");
				return attribute != null && attribute.contains("mat-label-active");
			}
		}
		return false;
	}

	public List<String> getCustomFieldHeaderTextList() throws Exception {
		return ElementUtils.getTextListByLocator(customFieldHeader);
	}

	public String getCustomFieldTextByCustomFieldName(String customFieldName) throws Exception {
		return ElementUtils.getTextByLocator(customFieldByCustomFieldName(customFieldName), 0);
	}
}
