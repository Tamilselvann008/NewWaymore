package pages.dashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.Waiters;

public class DashboardPo extends BasePo {
	public DashboardPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private By dashboardSideInfo = By.cssSelector(".wm-dashboard__side-tutorial-steps .wm-dashboard__side-info");
	private By dashboardTitle = By.cssSelector("#dashboard-container .wm-dashboard__title");
	private By logo = By.cssSelector(".wm-dashboard__page-logo-title");
	private By quickStartGuideTitle = By.cssSelector("#dashboard-container .wm-dashboard__side-info-title");
	private By unverifiedUserMessage = By.cssSelector("unverified-user-component .unverified-user__message");
	private By dashboardHeaderTab = By
			.cssSelector("#dashboard-container [ng-model='vm.templates.lower'] .wm-table__headline");
	private By countryView = By.cssSelector("#dashboard-container .wm-table__headline + [ng-if='vm.showCountry']");
	private By channelSetupTitle = By.cssSelector(
			".wm-dashboard__side-configuration-campaigns-steps[aria-hidden='false'] .wm-dashboard__side-info-title-tutorial-steps");

	private By progressCircularByTabIndex(int index) {
		return By.cssSelector("#dashboard-container [ng-model='vm.templates.lower'] > div.as-sortable-item:nth-child("
				+ (index + 1) + ") .wm-table__headline + div md-progress-circular");
	}

	private By dashboardHeaderTabByTabIndex(int index) {
		return By.cssSelector("#dashboard-container [ng-model='vm.templates.lower'] > div.as-sortable-item:nth-child("
				+ (index + 1) + ") .wm-table__headline");
	}

	private By quickStartGuideOptionBySetupOptionName(String option) {
		switch (option) {
		case "ChannelSetup":
			return By.cssSelector("div[aria-hidden='false'] .wm-dashboard__side-configuration-campaigns-description");
		case "ServicesSetup":
			return By.cssSelector(".wm-dashboard__side-tutorial-steps .wm-dashboard__side-tutorial-description");
		default:
			throw new IllegalArgumentException("Invalid option: " + option);
		}
	}

	private By servicesSetupOptionByName(String value) {
		switch (value) {
		case "Integrate":
			return By.cssSelector(
					".wm-dashboard__side-tutorial-steps a[href='/workflow-automation-service/integrations']");
		case "Synchronize":
			return By.cssSelector(".wm-dashboard__side-tutorial-steps a[ng-class*='synchronize']");
		case "Automate":
			return By.cssSelector(".wm-dashboard__side-tutorial-steps a[ng-class*='automate']");
		case "PushNotification":
			return By.cssSelector(".wm-dashboard__side-tutorial-steps a[href='/push']");
		case "SendCampaign":
			return By.cssSelector(".wm-dashboard__side-tutorial-steps a[href*='/campaigns-manager/']");
		default:
			throw new IllegalArgumentException("Invalid value: " + value);
		}
	}

	public void clickOnServicesSetupOptionByName(String value) throws Exception {
		Waiters.waitForElementToBeDisplayed(servicesSetupOptionByName(value));
		Action.clickByLocator(servicesSetupOptionByName(value), 0);
	}

	public WebElement getDashboardSideInfo() throws Exception {
		Waiters.waitForElementToBeDisplayed(dashboardSideInfo);
		return ElementUtils.getElementWithWaitByLocator(dashboardSideInfo, 0);
	}

	public String getDashboardTitleText() throws Exception {
		Waiters.waitForElementToBeDisplayed(dashboardTitle);
		return ElementUtils.getTextByLocator(dashboardTitle, 0);
	}

	public void waitForDashboardTitleIsDisplayed() throws InterruptedException {
		Waiters.waitForElementToBeDisplayed(dashboardTitle);
	}

	public void waitForLogoToBeInvisible() throws InterruptedException {
		Waiters.waitForElementToBeInvisible(logo);
	}

	public String getQuickStartGuideTitleText() throws Exception {
		Waiters.waitForElementToBeDisplayed(quickStartGuideTitle);
		return ElementUtils.getTextByLocator(quickStartGuideTitle, 0);
	}

	public String getUnverifiedUserMessageText() throws Exception {
		Waiters.waitForElementToBeDisplayed(unverifiedUserMessage);
		return ElementUtils.getTextByLocator(unverifiedUserMessage, 0);
	}

	public List<String> getDashboardHeaderTabTextList() throws Exception {
		Waiters.waitForElementToBeDisplayed(dashboardHeaderTab);
		return ElementUtils.getTextListByLocator(dashboardHeaderTab);
	}

	public boolean isCountryViewDisplayed(String country) throws Exception {
		List<String> headerTabTextList = getDashboardHeaderTabTextList();
		int index = headerTabTextList.indexOf(country);
		WebElement countryTab = ElementUtils.getElementWithWaitByLocator(dashboardHeaderTabByTabIndex(index), index);
		Action.scrollIntoView(countryTab);
		Waiters.waitForElementToBeNotVisible(progressCircularByTabIndex(index));
		return Action.isElementDisplayedByLocator(countryView, index);
	}

	public List<String> getQuickStartGuideOptionTextListByOptionName(String option) throws Exception {
		Waiters.waitForElementToBeDisplayed(quickStartGuideOptionBySetupOptionName(option));
		return ElementUtils.getTextListByLocator(quickStartGuideOptionBySetupOptionName(option));
	}

	public String getChannelSetupTitleText() throws Exception {
		Waiters.waitForElementToBeDisplayed(channelSetupTitle);
		return ElementUtils.getTextByLocator(channelSetupTitle, 0);
	}

	public boolean isChannelSetupTitleDisplayed() throws InterruptedException {
		return Action.isElementDisplayedByLocator(channelSetupTitle, 0);
	}

	public boolean isQuickStartGuideOptionByOptionNameDisplayed(String option) throws InterruptedException {
		return Action.isElementDisplayedByLocator(quickStartGuideOptionBySetupOptionName(option), 0);
	}


}
