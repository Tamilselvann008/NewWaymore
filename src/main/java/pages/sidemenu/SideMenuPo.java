package pages.sidemenu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.Waiters;
import pages.dashboard.DashboardPo;
import pages.forms.FormsPo;

public class SideMenuPo extends BasePo {

	private static final String Active = "";
	private static final String Class ="";
	
	public SideMenuPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	DashboardPo dashboardPo = new DashboardPo(driver);
	FormsPo formsPo = new FormsPo(driver);
	private By userPluginsLink = By.cssSelector(".side-menu__domains mat-select");
	private By sideMenuItem = By.cssSelector(".nav-sidebar .side-menu__nav-li mat-icon + span");
	private By sideMenuActiveItem = By.cssSelector(".side-menu__nav .side-menu__nav-li.nav-parent.active");
	private By sideMenuDomainOption = By.cssSelector(".side-menu__domains .side-menu__domains-select-opt-desc-domain");
	private By sideMenuPluginInfo = By.cssSelector(".side-menu__domains .side-menu__domains-select-opt-desc-info");
	private By formLink = By.cssSelector("wm-app-menu a[href=\"/forms\"]");
	private By landingPageLink = By.cssSelector("wm-app-menu a.wm-app-menu__item:not([href=\"/forms\"])");
	private By sideMenuLogo = By.cssSelector(".side-menu__logo--short");
	private By sideMenuItemOnHover = By.cssSelector(".sidebar-inner .nav-sidebar>li:not(.not-active):hover>a span");
	private By sideMenuItemWithSubmenuOnHover = By
			.cssSelector(".sidebar-inner .nav-sidebar>li:not(.not-active):hover>span span");
	private By sideMenuActiveSubSubmenuItem = By.cssSelector("li.active>ul.children>li");
	private By sideMenuQuickSearchInput = By.cssSelector("input[placeholder=\"QUICK SEARCH\"]");

	private By sideMenuSubmenuItemOnHover = By
			.cssSelector(".side-menu__nav-li.nav-parent:hover ul.side-menu__nav-sub-menu>li>a>span");
	private By expandedSideMenuSubmenuItem = By
			.cssSelector(".side-menu__nav-li.nav-parent.active .children .ng-star-inserted span");

	public By sideMenuLinkByName(String value) {
		return By.xpath("//ul[@class='nav-sidebar scroll-sidebar']//span[text()='" + value
				+ "']/ancestor::*[@class='ng-star-inserted'][1]");
	}

	public boolean isSideMenuItemExpanded() {
		return Action.isElementDisplayedByLocator(sideMenuActiveItem, 0);
	}

	private By sideMenuSubOptionItemByName(String subSubmenuOption, String submenuOption) {
	    return By.xpath("//span[text()='" + submenuOption + "']/parent::span/parent::li//a//span[text()='" + subSubmenuOption + "']");
	}

	private By sideMenuActiveExpandedSubSubmenuItemByName(String menuOption, String submenuOption) {
	    return By.xpath("//span[text()='" + menuOption + "']/parent::span/parent::li//span[text()='" + submenuOption + "']/parent::a/parent::li/ul//a");
	}

	private By sidebarMenuDropdownOptionByName(String value) {
	    switch (value) {
	        case "MyIntegrations":
	            return By.cssSelector("a[href=\"/workflow-automation-service/integrations\"]");
	        case "PushNotification":
	            return By.cssSelector("a[href=\"/push\"]");
	        case "Forms":
	            return By.cssSelector(".side-menu__nav-li.nav-parent.active > ul > li:nth-child(1) > a");
	        case "Email":
	            return By.xpath("//wm-sidebar//li[3]/ul/li[2]/a/span[text()='" + value + "']");
	        case "PushForMobileDevices":
	        case "UnifiedChatBoard":
	            return By.xpath("//span[text()='" + value + "']/parent::a");
	        default:
	            throw new RuntimeException("Add sidebar menu dropdown '" + value + "' option");
	    }
	}

	private By sideMenuOptionByName(String value) {
	    switch (value) {
	        case "Dashboard":
	            return By.cssSelector("a[href=\"/\"].ng-star-inserted");
	        case "MyCampaigns":
	            return By.cssSelector("a[href=\"/campaigns-manager/campaigns-list\"].ng-star-inserted");
	        case "Settings":
	            return By.cssSelector("a[href=\"/settings/profile\"].ng-star-inserted");
	        case "ContactInsights":
	            return By.cssSelector("a[href=\"/contact/contact-list\"].ng-star-inserted");
	        case "Events":
	            return By.cssSelector("a[href=\"/events\"].ng-star-inserted");
	        default:
	            throw new RuntimeException("Add sidebar menu dropdown '" + value + "' option");
	    }
	}

	public void clickOnLinkFromSidebarMenuByName(String value) throws Exception {
		By sideMenuLink = sideMenuLinkByName(value);

		Waiters.waitForElementToBeDisplayed(sideMenuLink);
		Action.clickWithJSByLocator(sideMenuLink, 0);
		Waiters.waitWithSleepTimeout(2500);
	}

	public void clickOnSubmenuItemFromSideMenuByName(String subSubmenuOption, String submenuOption) throws Exception {
		By subMenuLocator = sideMenuSubOptionItemByName(subSubmenuOption, submenuOption);

		Waiters.waitForElementToBeDisplayed(subMenuLocator);
		Action.clickByLocator(subMenuLocator, 0);
	}
	public void clickOnFormLink() throws Exception {
	    Waiters.waitForElementToBeDisplayed(formLink);
	    Action.clickByLocator(formLink, 0);
	    Waiters.waitUntilURLContains("forms");
	    formsPo.waitForFormPageLoaderToBeInvisible();
	}

	public void clickOnSideMenuQuickSearchInput() throws Exception {
	    Waiters.waitForElementToBeDisplayed(sideMenuQuickSearchInput);
	    Action.clickByLocator(sideMenuQuickSearchInput, 0);
	}

	public void scrollToEachMenuItem() throws InterruptedException {
	    List<WebElement> menuItemList = ElementUtils.getElementListWithWaitByLocator(sideMenuItem);

	    for (int i = 0; i < menuItemList.size(); i++) {
	        Action.scrollToElementWithJsByLocator(sideMenuItem, i);
	    }
	}

	public WebElement getSideMenuItemByValue(String value) throws Exception {
	    return ElementUtils.getElementByLocator(sideMenuOptionByName(value), 0);
	}

	public void clickOnLandingPageLink() throws Exception {
	    Waiters.waitForElementToBeDisplayed(landingPageLink);
	    Action.clickByLocator(landingPageLink, 0);
	}

	public WebElement getSideMenu() throws Exception {
	    Waiters.waitForElementToBeDisplayed(sideMenuItem);
	    return ElementUtils.getElementWithWaitByLocator(sideMenuItem, 0);
	}

	public List<String> getSideMenuTextList() throws Exception {
	    Waiters.waitForElementToBeDisplayed(sideMenuItem);
	    return ElementUtils.getTextListByLocator(sideMenuItem);
	}
	public void clickOnUserPluginsLink() throws Exception {
	    Waiters.waitForElementToBeDisplayed(userPluginsLink);
	    Action.clickByLocator(userPluginsLink, 0);
	    Waiters.waitWithSleepTimeout(0);
	}


	public boolean isSidebarMenuByNameActive(String value) throws Exception {
	    String attribute = ElementUtils.getAttributeByLocator(sideMenuLinkByName(value), Class, 0);
	    return attribute.contains(Active);
	}


	public String getSideMenuDomainOptionText() throws Exception {
	    Waiters.waitForElementToBeDisplayed(sideMenuDomainOption);
	    return ElementUtils.getTextByLocator(sideMenuDomainOption, 0);
	}

	public String getSideMenuPluginInfoText() throws Exception {
	    Waiters.waitForElementToBeDisplayed(sideMenuPluginInfo);
	    return ElementUtils.getTextByLocator(sideMenuPluginInfo, 0);
	}

	public void selectOptionFromItemDropdownListByOptionName(String value) throws Exception {
	    Action.clickWithJSByLocator(sidebarMenuDropdownOptionByName(value), 0);
	    dashboardPo.waitForLogoToBeInvisible();
	    Waiters.waitWithSleepTimeout(2000);
	}
	
	public void hoverOverOnMenuItem(String option) throws Exception {
	    Waiters.waitForElementToBeDisplayed(sideMenuOptionByName(option));
	    Action.moveMouseToElementByLocator(sideMenuOptionByName(option), 0);
	}

	public void hoverOverOnMenuItemWithSubmenu(String option) throws Exception {
	    Waiters.waitForElementToBeDisplayed(sideMenuLinkByName(option));
	    //WebElement sideMenu = ElementUtils.getElementWithWaitByLocator(sideMenuLinkByName(option), 0);
//	    Action.scrollIntoView(sideMenu);
	    Action.moveMouseToElementByLocator(sideMenuLinkByName(option), 0);
	}

	public String getSideMenuTooltipOnHoverText() throws Exception {
	    Waiters.waitForElementToBeDisplayed(sideMenuItemOnHover);
	    return ElementUtils.getTextByLocator(sideMenuItemOnHover, 0);
	}

	public String getSideMenuTooltipWithSubmenuOnHoverText() throws Exception {
	    Waiters.waitForElementToBeDisplayed(sideMenuItemWithSubmenuOnHover);
	    return ElementUtils.getTextByLocator(sideMenuItemWithSubmenuOnHover, 0);
	}

	public List<String> getSideMenuSubmenuOptionOnHoverTextList() throws Exception {
	    Waiters.waitForElementToBeDisplayed(sideMenuSubmenuItemOnHover);
	    return ElementUtils.getTextListByLocator(sideMenuSubmenuItemOnHover);
	}

	public List<String> getSideMenuSubmenuOptionTextList() throws Exception {
	    Waiters.waitForElementToBeDisplayed(expandedSideMenuSubmenuItem);
	    return ElementUtils.getTextListByLocator(expandedSideMenuSubmenuItem);
	}

	public List<String> getSideMenuTooltipSubSubmenuOptionTextList() throws Exception {
	    Waiters.waitForElementToBeDisplayed(sideMenuActiveSubSubmenuItem);
	    return ElementUtils.getTextListByLocator(sideMenuActiveSubSubmenuItem);
	}

	public List<String> getSideMenuExpandedSubSubmenuOptionByMenuOptionsTextList(String menuItem, String subMenuItem) throws Exception {
	    Waiters.waitForElementToBeDisplayed(sideMenuActiveExpandedSubSubmenuItemByName(menuItem, subMenuItem));
	    return ElementUtils.getTextListByLocator(sideMenuActiveExpandedSubSubmenuItemByName(menuItem, subMenuItem));
	}

	public void clickOnWaymoreLogoLink() throws Exception {
	    Waiters.waitForElementToBeDisplayed(sideMenuLogo);
	    Action.clickByLocator(sideMenuLogo, 0);
	}


}
