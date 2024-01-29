package pages.contactInsights;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helpers.ElementUtils;
import helpers.Waiters;
import actions.Action;
import basePackage.BasePo;

public class ActivityTabPo extends BasePo {
	String MatLabelActive = "mat-tab-label-active";
	String Class = "class";

	private By activityTableHeader = By.cssSelector(".contact-activity__chart-wrap .wm-table__headline span");
	private By sessionsChartBar = By.cssSelector(".contact-activity__chart-wrap .wm-table__body canvas");
	private By tabLabel = By.cssSelector("[role=\"tablist\"] .mat-tab-label");
	private By infoBlockContent = By
			.cssSelector(".tab-activity .contact-info-block .contact-info-block__content-caption");

	public boolean isTabByNameActive(String tabName) throws Exception {
		List<WebElement> tabs = ElementUtils.getElementListWithWaitByLocator(tabLabel);
		for (WebElement tab : tabs) {
			if (ElementUtils.getTextByLocator(tab).equals(tabName)) {
				String classAttribute = tab.getAttribute(Class);
				return classAttribute.contains(MatLabelActive);
			}
		}
		return false;
	}
 
	public String getActivityTableHeaderText() throws Exception {
		Waiters.waitForElementToBeVisible(activityTableHeader);
		return ElementUtils.getTextByLocator(activityTableHeader, 0);
	}

	public boolean isInfoBlockContentByNameDisplayed(String infoBlockName) throws Exception {
		Waiters.waitForElementToBeVisible(infoBlockContent);
		List<WebElement> infoBlocks = ElementUtils.getElementListWithWaitByLocator(infoBlockContent);
		for (WebElement infoBlock : infoBlocks) {
			if (ElementUtils.getTextByLocator(infoBlock).equals(infoBlockName)) {
				return infoBlock.isDisplayed();
			}
		}
		return false;
	}

	public boolean isSessionsChartBarDisplayed() throws Exception {
		return Action.isElementDisplayedByLocator(sessionsChartBar, 0);
	}
}
