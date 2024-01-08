package pages.contactInsights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.Waiters;

public class CreateContactDialogPo extends BasePo {

	public CreateContactDialogPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private static By createContactDialog = By.cssSelector("wm-create-contact-dialog wm-settings-dialog-wrapper");
	private static By createContactDialogTitle = By.cssSelector("wm-settings-dialog-wrapper .connection-dialog__head-title");
	private static By countryDropdown = By.cssSelector("[formcontrolname=\"country\"] .mat-select-trigger");
	private static By selectedCountryDropdown = By.cssSelector("mat-select[formcontrolname=\"country\"] .mat-select-value");
	private static By activeDropdownOptionsContent = By.cssSelector(".mat-autocomplete-visible[role=\"listbox\"]");
	private static By assignContactToGroupsPlusButton = By.cssSelector("button.connection-dialog__btn-add");
	private static By groupsDropdownWidth = By.cssSelector("wm-contact-groups .connection-dialog__control-variable");
	private static By groupsDropdownOptionsContentWidth = By.cssSelector(".cdk-overlay-container .mat-autocomplete-panel");
	private static By countryDropdownInput = By.cssSelector("[role=\"listbox\"] input[name=\"countrySearch\"]");
	private static By countryDropdownOption = By.cssSelector(".country-dropdown mat-option .mat-option-text");
	private static By countryDropdownFilteredOption = By.cssSelector(".country-dropdown mat-option:not([hidden])");
	private static By mobileNumberInput = By.cssSelector("input#phone");
	private static By saveButton = By.cssSelector(".progress-btn.actionBtn");
	private static By loadingButton = By.cssSelector(".progress-btn.actionBtn.disabled-button.loading");
	private static By addDateOfBirthInput = By.cssSelector("input#birthdate");
	private static By groupLoader = By.cssSelector("md-content md-progress-circular[ng-if=\"vm.isLoadMore\"]");
	private static By openCalendarButton = By.cssSelector("button[aria-label=\"Open calendar\"]");
	private static By calendarHeader = By.cssSelector("button[aria-label=\"Choose month and year\"]");
	private static By calendarBackButton = By.cssSelector("button[aria-label=\"Previous 24 years\"]");
	private static By calendarNextButton = By.cssSelector("button[aria-label=\"Next 24 years\"]");
	private static By calendarOption = By.cssSelector("td.mat-calendar-body-cell-container");
	private static By mobileNumberErrorMessage = By.cssSelector("div[ng-messages=\"vm.form['phone'].$error\"] ng-message");
	private static By groupsDropdownOption = By
			.cssSelector(".cdk-overlay-container .mat-autocomplete-panel mat-option.ng-star-inserted");

	public static By groupCloseButtonByGroupName(String groupName) {
		return By.xpath("//div[span[text()='" + groupName + "']]");
	}

	public static By createContactInputByOptionName(String contactData) {
		return By.cssSelector("input[placeholder='Add " + contactData + "']");
	}

	public static By channelUseOptionByName(String optionName) {
		return By.cssSelector("input[aria-label='" + optionName + "']");
	}

	public static By statusByChannelName(String channelName) {
		return By.cssSelector(".mat-slide-toggle-label input[aria-label='" + channelName + "'] ~ .status-label--v2");
	}

	public static By dateOptionItem(String value) {
		return By.xpath("//div[text()=' " + value + " ']/ancestor::button");
	}

	public boolean isCreateContactsDialogElementDisplayed() {
		return Action.isElementDisplayedByLocator(createContactDialog);
	}

	public String getCreateContactDialogTitleText() throws Exception {
		Waiters.waitForElementToBeDisplayed(createContactDialogTitle);
		return ElementUtils.getTextByLocator(createContactDialogTitle, 0);
	}

	public void typeContactDataByOptionName(String contactData, String value) {
		Action.typeTextInWithoutClear(createContactInputByOptionName(contactData), value, 0);
	}

	public void typeMobileNumber(String value) throws InterruptedException {
		Action.clearTextInLocatorAndTypeText(mobileNumberInput, value);
	}

	public void selectCheckboxByLocator(String optionName) {
		Action.clickWithJSByLocator(channelUseOptionByName(optionName));
	}

	public void clickOnSaveButton() throws Exception {
		Action.clickByLocator(saveButton);
		Waiters.waitForElementToBeInvisible(loadingButton);
	}

}