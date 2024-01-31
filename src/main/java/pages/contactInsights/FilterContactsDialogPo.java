package pages.contactInsights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePo;
import helpers.Waiters;
import helpers.Action;
import helpers.ElementUtils;
import helpers.StringUtils;

public class FilterContactsDialogPo extends BasePo {

	public FilterContactsDialogPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	String Checks = "checks";
	String Unchecks = "unchecks";
	String Disabled = "disabled";
	String AriaSelected = "aria-selected";
	private By filterContactsDialog = By.cssSelector("mat-dialog-container[role='dialog']");
	private By filterContactsDialogTitle = By.cssSelector("mat-dialog-container[role='dialog'] h5");
	private By closeButton = By.cssSelector("wm-contacts-filter-dialog mat-icon");
	private By searchButton = By.cssSelector("wm-contacts-filter-dialog button.submit");
	private By resetButton = By.cssSelector("wm-contacts-filter-dialog button.reset");
	private By backgroundOutsideDialog = By.cssSelector(".cdk-overlay-backdrop-showing");
	private By dropdownPanelOption = By.cssSelector("ng-dropdown-panel [role='option']");
	private By dropdownPanelList = By.cssSelector("ng-dropdown-panel[role='listbox']");
	private By dropdownPanelSpinner = By.cssSelector("ng-dropdown-panel .ng-dropdown-footer mat-spinner");
	private By dropdownOptionDisabled = By.cssSelector(".ng-dropdown-panel-items .ng-option-disabled");
	private By dropdownSelectedValueLabel = By.cssSelector("wm-contacts-filter-dialog .ng-value-label");
	private By searchInput = By.cssSelector("ng-dropdown-panel input[type='text']");
	private By dropdownPlaceholder = By.cssSelector("wm-contacts-filter-dialog .ng-placeholder");
	private By dropdownLabel = By.cssSelector("wm-contacts-filter-dialog .fields b > span");

	private By filterDropdownByName(String dropdownName) {
		return By.xpath("//span[text()='" + dropdownName + "']/ancestor::div[contains(@class, 'fields')]/ng-select");
	}

	private By selectedOptionByDropdownName(String dropdownName) {
		return By.xpath("//span[text()='" + dropdownName
				+ "']/ancestor::div[contains(@class, 'fields')]/ng-select//span[contains(@class, 'ng-value-label')]");
	}

	private By selectedOptionCloseIconByDropdownName(String dropdownName) {
		return By.xpath("//span[text()='" + dropdownName
				+ "']/ancestor::div[contains(@class, 'fields')]/ng-select//span[contains(@class, 'ng-value-icon')]");
	}

	public boolean isFilterContactsDialogDisplayed() throws Exception {
		return Action.isElementDisplayedByLocator(filterContactsDialog, 0);
	}

	public void clickOnSearchButton() throws Exception {
		Action.clickWithJSByLocator(searchButton, 0);
		Waiters.waitForElementToBeInvisible(dropdownPanelList);
	}

	public boolean isDropdownSelectedValueLabelDisplayed() throws Exception {
		return Action.isElementDisplayedByLocator(dropdownSelectedValueLabel, 0);
	}

	public void waitForFilterContactsDialogIsDisplayed() throws Exception {
		Waiters.waitForElementToBeDisplayed(filterContactsDialog);
	}

	public String getFilterContactsDialogTitleText() throws Exception {
		return ElementUtils.getTextByLocator(filterContactsDialogTitle, 0);
	}

	public List<String> getDropdownPlaceholderTextList() throws Exception {
		return ElementUtils.getTextListByLocator(dropdownPlaceholder);
	}

	public List<String> getDropdownLabelTextList() throws Exception {
		return ElementUtils.getTextListByLocator(dropdownLabel);
	}

	public void clickOnBackgroundOutsideDialog() throws Exception {
		Action.clickWithJSByLocator(backgroundOutsideDialog, 0);
		Waiters.waitForElementToBeInvisible(filterContactsDialog);
	}

	public void clickOnCloseButton() throws Exception {
		Action.clickWithJSByLocator(closeButton, 0);
		Waiters.waitForElementToBeInvisible(filterContactsDialog);
	}

	public void clickOnResetButton() throws Exception {
		Action.clickWithJSByLocator(resetButton, 0);
	}

	public boolean isSubmitButtonDisabled() throws Exception {
		String isDisabled = ElementUtils.getAttributeByLocator(searchButton, Disabled, 0);
		return "true".equals(isDisabled);
	}

	public boolean isDropdownOptionDisabled() throws Exception {
		Waiters.waitWithSleepTimeout(2500);
		return Action.isElementDisplayedByLocator(dropdownOptionDisabled, 0);
	}

	public void clickOnFilterDropdownByName(String dropdownName) throws Exception {
		Action.clickByLocator(filterDropdownByName(dropdownName), 0);
		Waiters.waitForElementToBeInvisible(dropdownPanelSpinner);
	}

	public void typeValueInSearchInputField(String value) throws Exception {
		Waiters.waitForElementToBeDisplayed(searchInput);
		Action.typeTextInWithoutClear(searchInput, value, 0);
		Waiters.waitForElementToBeInvisible(dropdownPanelSpinner);
	}

	public List<String> getDropdownPanelOptionTextList() throws Exception {
		return ElementUtils.getTextListByLocator(dropdownPanelOption);
	}

	public void selectOptionFromDropdownByOptionName(String optionName) throws Exception {
		List<String> optionTextList = ElementUtils.getTextListByLocator(dropdownPanelOption);
		optionTextList = optionTextList.stream().map(StringUtils::getStringByTrim).collect(Collectors.toList());
		int index = optionTextList.indexOf(optionName);
		if (index != -1) {
			Action.clickByLocator(ElementUtils.getElementByLocator(dropdownPanelOption, index));
		} else {
			throw new NoSuchElementException("Dropdown option not found: " + optionName);
		}
	}

	public void selectCheckboxByStatusAndOptionName(String checkboxStatus, String optionName) throws Exception {
		List<String> optionTextList = ElementUtils.getTextListByLocator(dropdownPanelOption);
		optionTextList = optionTextList.stream().map(StringUtils::getStringByTrim).collect(Collectors.toList());
		int index = optionTextList.indexOf(optionName);
		if (index != -1) {
			String attribute = ElementUtils.getAttributeByLocator(dropdownPanelOption, AriaSelected, index);
			boolean isSelected = !(attribute == null || "false".equals(attribute));
			if ((Checks.equals(checkboxStatus) && !isSelected) || (Unchecks.equals(checkboxStatus) && isSelected)) {
				Action.clickByLocator(ElementUtils.getElementByLocator(dropdownPanelOption, index));
			}
		} else {
			throw new NoSuchElementException("Dropdown option not found: " + optionName);
		}
	}

	public boolean isOptionByNameSelectedInDropdownOptionsList(String optionName) throws Exception {
		List<String> optionTextList = ElementUtils.getTextListByLocator(dropdownPanelOption);
		optionTextList = optionTextList.stream().map(StringUtils::getStringByTrim).collect(Collectors.toList());
		int index = optionTextList.indexOf(optionName);
		if (index != -1) {
			return Action.isElementSelectedByLocator(dropdownPanelOption);
		}
		return false;
	}

	public List<String> getSelectedOptionByDropdownNameTextList(String dropdownName) throws Exception {
		boolean isDisplayed = Action.isElementDisplayedByLocator(selectedOptionByDropdownName(dropdownName), 0);
		List<String> optionTextList = new ArrayList<>();
		if (isDisplayed) {
			optionTextList = ElementUtils.getTextListByLocator(selectedOptionByDropdownName(dropdownName));
			optionTextList = optionTextList.stream().map(StringUtils::getStringByTrim).collect(Collectors.toList());
		}
		return optionTextList;
	}

	public void clickOnCloseIconInSelectedOptionByDropdownAndOptionName(String dropdownName, String optionName)
			throws Exception {
		List<String> optionTextList = ElementUtils.getTextListByLocator(selectedOptionByDropdownName(dropdownName));
		optionTextList = optionTextList.stream().map(StringUtils::getStringByTrim).collect(Collectors.toList());
		int index = optionTextList.indexOf(optionName);
		if (index != -1) {
			Action.clickByLocator(
					ElementUtils.getElementByLocator(selectedOptionCloseIconByDropdownName(dropdownName), index));
		} else {
			throw new NoSuchElementException("Selected option not found: " + optionName);
		}
	}

	public void clickOnFilterContactsDialog() throws Exception {
		Action.clickByLocator(filterContactsDialog, 0);
		// Waiters.waitForElementToBeNotVisible( dropdownPanelList);
	}
}
