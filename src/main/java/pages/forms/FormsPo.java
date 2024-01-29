package pages.forms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.StringUtils;
import helpers.Waiters;

public class FormsPo extends BasePo {
	public FormsPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private By formTopBar = By.id("forms-top-bar");
	private By formTabLink = By.cssSelector(".forms__tabs .forms__tab-link.is-active");
	private By addNewItemIcon = By.cssSelector(".forms__item--new a.forms__item--new-link md-icon");
	private By searchInput = By.cssSelector("input#wm-search");
	private By searchIcon = By.cssSelector("i.search-icon");
	private By cancelSearchIcon = By.cssSelector(".search-input-clicked md-icon");
	private By formItemName = By
			.cssSelector("div[aria-hidden='false'].forms__item:not(.forms__item--new) .forms__item-name");
	private By formBackdrop = By.cssSelector(".md-menu-backdrop.md-click-catcher");
	private By paginationPageLink = By.cssSelector("a[ng-click='selectPage(page.number, $event)']");
	private By formDropdown = By
			.cssSelector(".forms__item:not(.forms__item--new)[aria-hidden='false'] .forms__item-footer md-icon");
	private By formPageLoader = By.cssSelector("wm-app-loader[ng-if='vm.isLoading'] div.spinner");
	private By formDate = By
			.cssSelector("#forms-content [ng-show='!vm.isLoading']:not(.forms__item--new) div:nth-child(3)");
	private By rightPopupNotification = By.cssSelector("md-toast div.md-toast-content");
	private By popupNotificationCloseButton = By.cssSelector("md-toast button");

	private By formDropdownByFormName(String name) {
		return By.xpath("//div[contains(@class, 'forms__item-header')]/div[text()='" + name
				+ "']/parent::*/parent::*//md-menu//md-icon");
	}

	private By formDropdownOptionByValue(String option) {
		switch (option) {
		case "Delete":
			return By.cssSelector(".md-clickable[aria-hidden='false'] md-menu-item [ng-click='vm.delete(form.id)']");
		case "Edit":
			return By.cssSelector(".md-clickable[aria-hidden='false'] md-menu-item [ng-click='vm.editForm(form)']");
		case "Clone":
			return By.cssSelector(".md-clickable[aria-hidden='false'] md-menu-item [ng-click='vm.clone(form)']");
		case "View":
			return By.cssSelector(
					".md-clickable[aria-hidden='false'] md-menu-item [ng-click='vm.viewForm(form.form_url)']");
		case "Publish":
		case "Unpublish":
			return By.cssSelector(".md-clickable[aria-hidden='false'] md-menu-item [ng-click='vm."
					+ option.toLowerCase() + "(form)']");
		default:
			throw new IllegalArgumentException("Invalid option: " + option);
		}
	}

	public boolean isFormTopBarElementDisplayed() throws InterruptedException {
		return Action.isElementCheckedByLocator(formTopBar);
	}

	public String getFormTabLinkText() throws Exception {
		return ElementUtils.getTextByLocator(formTabLink, 0);
	}

	public boolean isAddNewItemIconElementDisplayed() throws InterruptedException {
		return Action.isElementDisplayedByLocator(addNewItemIcon, 0);
	}

	public void typeValueInSearchInputField(String value) throws InterruptedException {
		Action.clearTextInLocatorAndTypeText(searchInput, value);
	}

	public int getPaginationPageLinkCount() throws InterruptedException {
		return ElementUtils.getElementListCountByLocator(paginationPageLink);
	}

	public List<String> getFormItemNameTextList() throws Exception {
		boolean isFormExist = Action.isElementDisplayedByLocator(formItemName, 0);
		if (isFormExist) {
			return ElementUtils.getTextListByLocator(formItemName);
		} else {
			return null;
		}
	}

	public void clickOnCloseNotificationButton() throws Exception {
		Action.clickByLocator(popupNotificationCloseButton, 0);
		Waiters.waitForElementToBeInvisible(rightPopupNotification);
		Waiters.waitWithSleepTimeout(2500);
	}

	public void clickOnFormBackdrop() throws Exception {
		Action.clickByLocator(formBackdrop, 0);
	}

	public void clickOnFormMenuDropdownByFormName(String formName) throws Exception {
		Action.clickByLocator(formDropdownByFormName(formName), 0);
		Waiters.waitWithSleepTimeout(2500);
	}

	public WebElement getFromDropdownOptionByOptionName(String option) throws Exception {
		return ElementUtils.getElementByLocator(formDropdownOptionByValue(option), 0);
	}

	public void selectFormMenuOptionFromDropdownByOptionName(String formName, String option) throws Exception {
		Action.clickByLocator(formDropdownByFormName(formName), 0);
		Waiters.waitWithSleepTimeout(2500);
		Action.clickByLocator(formDropdownOptionByValue(option), 0);
		Waiters.waitWithSleepTimeout(2500);
	}

	public void deleteAllFormsFromPage() throws Exception {
		int count = ElementUtils.getElementListCountByLocator(formDropdown);
		for (int i = 0; i < count; i++) {
			Action.clickByLocator(formDropdown, i);
			Waiters.waitWithSleepTimeout(2500);
			Action.clickByLocator(formDropdownOptionByValue("delete"), i);
			Waiters.waitWithSleepTimeout(2500);
		}
	}

	public String getFormCreatedDateByFormName(String formName) throws Exception {
		List<String> formNameTextList = ElementUtils.getTextListByLocator(formItemName);
		int index = formNameTextList.indexOf(formName);
		return ElementUtils.getTextByLocator(formDate, index);
	}

	public void clickOnLastPaginationLink() throws Exception {
		int paginationListNumber = ElementUtils.getElementListCountByLocator(paginationPageLink);
		Action.clickByLocator(paginationPageLink, paginationListNumber - 1);
		Waiters.waitWithSleepTimeout(2500);
	}

	public boolean isFormItemNameDisplayed() throws InterruptedException {
		return Action.isElementDisplayedByLocator(formItemName, 0);
	}

	public void clickOnSearchIcon() throws Exception {
		Action.clickByLocator(searchIcon, 0);
	}

	public void clickOnCancelSearchIcon() throws Exception {
		Action.clickByLocator(cancelSearchIcon, 0);
	}

	public void waitForFormPageLoaderToBeInvisible() throws InterruptedException {
		Waiters.waitForElementToBeInvisible(formPageLoader);
	}

	public String getRightPopupNotificationText() throws Exception {
		Waiters.waitForElementToBeVisible(rightPopupNotification);
		String popupText = ElementUtils.getTextByLocator(rightPopupNotification, 0);
		return StringUtils.getStringBySplit(popupText, "\n", 1);
	}
}
