package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import actions.Actions;
import basePackage.BasePo;
import helpers.Waiters;

public class SideMenuPo extends BasePo {

	public SideMenuPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

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
		return Actions.isElementDisplayedByLocator(sideMenuActiveItem, 0);
	}

	private By sideMenuSubOptionItemByName(String subSubmenuOption, String submenuOption) {
		return By.xpath("//span[text()='" + submenuOption + "']/parent::span/parent::li//a//span[text()='"
				+ subSubmenuOption + "']");
	}

	public void clickOnLinkFromSidebarMenuByName(String value) {
		By sideMenuLink = sideMenuLinkByName(value);

		Waiters.waitForElementToBeDisplayed(sideMenuLink);
		Actions.clickWithJSByLocator(sideMenuLink, 0);
		Waiters.waitWithSleepTimeout(2500);
	}

	public void clickOnSubmenuItemFromSideMenuByName(String subSubmenuOption, String submenuOption) {
		By subMenuLocator = sideMenuSubOptionItemByName(subSubmenuOption, submenuOption);

		Waiters.waitForElementToBeDisplayed(subMenuLocator);
		Actions.clickByLocator(subMenuLocator, 0);
	}

}
