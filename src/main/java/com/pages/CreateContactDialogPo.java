package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import actions.Actions;
import basePackage.BasePo;
import enums.uienums.OptionEnums.CountryOptionEnum;
import helpers.ElementUtils;
import helpers.Waiters;

public class CreateContactDialogPo extends BasePo {

	public CreateContactDialogPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private By createContactDialog = By.cssSelector("wm-create-contact-dialog wm-settings-dialog-wrapper");
	private By createContactDialogTitle = By.cssSelector("wm-settings-dialog-wrapper .connection-dialog__head-title");
	private By countryDropdown = By.cssSelector("[formcontrolname=\"country\"] .mat-select-trigger");
	private By selectedCountryDropdown = By.cssSelector("mat-select[formcontrolname=\"country\"] .mat-select-value");
	private By activeDropdownOptionsContent = By.cssSelector(".mat-autocomplete-visible[role=\"listbox\"]");
	private By assignContactToGroupsPlusButton = By.cssSelector("button.connection-dialog__btn-add");
	private By groupsDropdownWidth = By.cssSelector("wm-contact-groups .connection-dialog__control-variable");
	private By groupsDropdownOptionsContentWidth = By.cssSelector(".cdk-overlay-container .mat-autocomplete-panel");
	private By countryDropdownInput = By.cssSelector("[role=\"listbox\"] input[name=\"countrySearch\"]");
	private By countryDropdownOption = By.cssSelector(".country-dropdown mat-option .mat-option-text");
	private By countryDropdownFilteredOption = By.cssSelector(".country-dropdown mat-option:not([hidden])");
	private static By mobileNumberInput = By.cssSelector("input#phone");
	private By saveButton = By.cssSelector(".progress-btn.actionBtn");
	private By loadingButton = By.cssSelector(".progress-btn.actionBtn.disabled-button.loading");
	private By addDateOfBirthInput = By.cssSelector("input#birthdate");
	private By groupLoader = By.cssSelector("md-content md-progress-circular[ng-if=\"vm.isLoadMore\"]");
	private By openCalendarButton = By.cssSelector("button[aria-label=\"Open calendar\"]");
	private By calendarHeader = By.cssSelector("button[aria-label=\"Choose month and year\"]");
	private By calendarBackButton = By.cssSelector("button[aria-label=\"Previous 24 years\"]");
	private By calendarNextButton = By.cssSelector("button[aria-label=\"Next 24 years\"]");
	private By calendarOption = By.cssSelector("td.mat-calendar-body-cell-container");
	private By mobileNumberErrorMessage = By.cssSelector("div[ng-messages=\"vm.form['phone'].$error\"] ng-message");
	private By groupsDropdownOption = By
			.cssSelector(".cdk-overlay-container .mat-autocomplete-panel mat-option.ng-star-inserted");

	public By mobileNumberFlagByCountry(CountryOptionEnum country) {
		switch (country) {
		case Germany:
			return By.cssSelector(".iti__flag-container .iti__de");
		case Greece:
			return By.cssSelector(".iti__flag-container .iti__gr");
		case Jordan:
			return By.cssSelector(".iti__flag-container .iti__jo");
		default:
			throw new IllegalArgumentException("Add Mobile Number Flag");
		}
	}

	public By groupCloseButtonByGroupName(String groupName) {
		return By.xpath("//div[span[text()='" + groupName + "']]");
	}

	public By createContactInputByOptionName(String contactData) {
		return By.cssSelector("input[placeholder='Add " + contactData + "']");
	}

	public By channelUseOptionByName(String optionName) {
		return By.cssSelector("input[aria-label='" + optionName + "']");
	}

	public By statusByChannelName(String channelName) {
		return By.cssSelector(".mat-slide-toggle-label input[aria-label='" + channelName + "'] ~ .status-label--v2");
	}

	public By dateOptionItem(String value) {
		return By.xpath("//div[text()=' " + value + " ']/ancestor::button");
	}

	public boolean isCreateContactsDialogElementDisplayed() {
		return Actions.isElementDisplayedByLocator(createContactDialog, 0);
	}

	public String getCreateContactDialogTitleText() {
		Waiters.waitForElementToBeDisplayed(createContactDialogTitle);
		return ElementUtils.getTextByLocator(createContactDialogTitle, 0);
	}

	public void typeContactDataByOptionName(String contactData, String value) {
		Actions.typeTextWithoutClear(createContactInputByOptionName(contactData), value, 0);
	}

	public void typeMobileNumber(String value) {
		Actions.clearTextInLocatorAndTypeText(mobileNumberInput, value, 0);
	}

	public void selectCheckboxByLocator(String optionName) {
		Actions.clickWithJSByLocator(channelUseOptionByName(optionName), 0);
	}

	public void clickOnSaveButton() {
		Actions.clickByLocator(saveButton, 0);
		Waiters.waitForElementToBeInvisible(loadingButton);
	}

}