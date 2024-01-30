package pages.contactInsights;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePackage.BasePo;
import helpers.DateUtils;
import helpers.ElementUtils;
import helpers.StringUtils;
import helpers.Waiters;

public class CreateContactDialogPo extends BasePo {

	private static final String Width = "width";

	public CreateContactDialogPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private static By createContactDialog = By.cssSelector("wm-create-contact-dialog wm-settings-dialog-wrapper");
	private static By createContactDialogTitle = By.cssSelector("wm-settings-dialog-wrapper .connection-dialog__head-title");
	private static By countryDropdown = By.cssSelector("[formcontrolname='country'] .mat-select-trigger");
	private static By selectedCountryDropdown = By.cssSelector("mat-select[formcontrolname='country'] .mat-select-value");
	private static By activeDropdownOptionsContent = By.cssSelector(".mat-autocomplete-visible[role='listbox']");
	private static By assignContactToGroupsPlusButton = By.cssSelector("button.connection-dialog__btn-add");
	private static By groupsDropdownWidth = By.cssSelector("wm-contact-groups .connection-dialog__control-variable");
	private static By groupsDropdownOptionsContentWidth = By.cssSelector(".cdk-overlay-container .mat-autocomplete-panel");
	private static By countryDropdownInput = By.cssSelector("[role='listbox'] input[name='countrySearch']");
	private static By countryDropdownOption = By.cssSelector(".country-dropdown mat-option .mat-option-text");
	private static By countryDropdownFilteredOption = By.cssSelector(".country-dropdown mat-option:not([hidden])");
	private static By mobileNumberInput = By.cssSelector("input#phone");
	private static By saveButton = By.cssSelector(".progress-btn.actionBtn");
	private static By loadingButton = By.cssSelector(".progress-btn.actionBtn.disabled-button.loading");
	private static By addDateOfBirthInput = By.cssSelector("input#birthdate");
	private static By groupLoader = By.cssSelector("md-content md-progress-circular[ng-if='vm.isLoadMore']");
	private static By openCalendarButton = By.cssSelector("button[aria-label='Open calendar']");
	private static By calendarHeader = By.cssSelector("button[aria-label='Choose month and year']");
	private static By calendarBackButton = By.cssSelector("button[aria-label='Previous 24 years']");
	private static By calendarNextButton = By.cssSelector("button[aria-label='Next 24 years']");
	private static By calendarOption = By.cssSelector("td.mat-calendar-body-cell-container");
	private static By mobileNumberErrorMessage = By.cssSelector("div[ng-messages='vm.form['phone'].$error'] ng-message");
	// Inside CreateContactDialogPo class

	private By groupsDropdownOption = By.cssSelector(".cdk-overlay-container .mat-autocomplete-panel mat-option.ng-star-inserted");

	private By mobileNumberFlagByCountry(String country) {
	    switch (country) {
	        case "Germany":
	            return By.cssSelector(".iti__flag-container:has(.iti__de)");
	        case "Greece":
	            return By.cssSelector(".iti__flag-container:has(.iti__gr)");
	        case "Jordan":
	            return By.cssSelector(".iti__flag-container:has(.iti__jo)");
	        default:
	            throw new IllegalArgumentException("Add Mobile Number Flag");
	    }
	}

	private By groupCloseButtonByGroupName(String groupName) {
	    return By.xpath("//div[span[text()='" + groupName + "']]");
	}

	private By createContactInputByOptionName(String optionName) {
	    return By.cssSelector("input[placeholder='Add " + optionName + "']");
	}

	private By channelUseOptionByName(String optionName) {
	    return By.cssSelector("input[aria-label='" + optionName + "']");
	}

	private By statusByChannelName(String channelName) {
	    return By.cssSelector(".mat-slide-toggle-label:has(input[aria-label='" + channelName + "']) .status-label--v2");
	}

	private By dateOptionItem(String value) {
	    return By.xpath("//div[text()=' " + value + " ']/ancestor::button");
	}

		private By createContactErrorMessageByOption(String option) {
	    switch (option) {
	        case "FirstName":
	        case "LastName":
	            String modifiedOption = StringUtils.getStringToLowerCase(StringUtils.replaceAllStringForValue(option, "-", " "));
	            return By.xpath("//input[@id='" + modifiedOption + "']/parent::md-input-container/div/div");
	        case "Email":
	            return By.cssSelector("div[ng-messages='vm.contactForm.email.$error'] ng-message");
	        case "MobileNumber":
	            return By.cssSelector("div[ng-messages='vm.form['phone'].$error'] ng-message");
	        case "ChannelUse":
	            return By.cssSelector("div.form__control-input__errors");
	        default:
	            throw new IllegalArgumentException("Invalid option for create contact error message");
	    }
	}

 

	public boolean isCreateContactsDialogElementDisplayed() {
		return Action.isElementDisplayedByLocator(createContactDialog, 0);
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

	public void selectCheckboxByLocator(String optionName) throws Exception {
		Action.clickWithJSByLocator(channelUseOptionByName(optionName), 0);
	}

	public void clickOnSaveButton() throws Exception {
		Action.clickByLocator(saveButton, 0);
		Waiters.waitForElementToBeInvisible(loadingButton);
	}
	
	
	
	
	
	
	
    // ... continuing from previous methods

    public String getGroupsDropdownText() throws Exception {
        Waiters.waitForElementToBeDisplayed(groupsDropdownWidth);
        return ElementUtils.getTextByLocator(groupsDropdownWidth, 0);
    }

    public String getAddDateOfBirthInputValue() throws Exception {
        Waiters.waitForElementToBeDisplayed(addDateOfBirthInput);
        return ElementUtils.getValueByLocator(addDateOfBirthInput, 0);
    }

    public String getCreateContactErrorMessageByOption(String optionName) throws Exception {
        Waiters.waitForElementToBeDisplayed(createContactErrorMessageByOption(optionName));
        return ElementUtils.getTextByLocator(createContactErrorMessageByOption(optionName), 0);
    }

    public boolean isMobileNumberFlagByCountryVisible(String country) {
        return Action.isElementDisplayedByLocator(mobileNumberFlagByCountry(country), 0);
    }

    public String getMobileNumberErrorMessageText() throws Exception {
        return ElementUtils.getTextByLocator(mobileNumberErrorMessage, 0);
    }

    public String getChannelUseCheckboxTextByName(String optionName) throws Exception {
        return ElementUtils.getTextByLocator(statusByChannelName(optionName), 0);
    }

    public List<String> getCalendarOptionTextList() throws Exception {
        Waiters.waitForElementToBeDisplayed(calendarOption);
        return ElementUtils.getTextListByLocator(calendarOption);
    }

    public String getCountryCodeDropdown() throws Exception {
        return ElementUtils.getTextByLocator(selectedCountryDropdown, 0);
    }

    public void typeSearchCriteriaInCountryDropdown(String country) throws InterruptedException {
        Action.clearTextInLocatorAndTypeText(countryDropdownInput, country);
    }

//    public void typeMobileNumber(String value) {
//        Action.clearTextInLocatorAndTypeText(mobileNumberInput, value);
//    }
//
//    public void typeContactDataByOptionName(String optionName, String value) {
//        Action.typeTextWithoutClear(createContactInputByOptionName(optionName), value);
//    }

    public void selectCountryFromCountryDropdownByValue(String country) throws Exception {
        Waiters.waitForElementToBeDisplayed(countryDropdown);
        Action.clickWithJSByLocator(countryDropdown, 0);
        typeSearchCriteriaInCountryDropdown(country);
        Action.clickWithJSByLocator(countryDropdownFilteredOption, 0);
        Waiters.waitWithSleepTimeout(2500);
    }

    public void clickOnCountryDropdown() throws Exception {
        Waiters.waitForElementToBeDisplayed(countryDropdown);
        Action.clickWithJSByLocator(countryDropdown, 0);
        Waiters.waitForElementToBeDisplayed(countryDropdownOption);
    }

    public void clickOnAssignContactToGroupsDropdown() throws Exception {
        boolean isCountryDropdownOpened = Action.isElementDisplayedByLocator(countryDropdownOption, 0);

        if (isCountryDropdownOpened) {
            Action.clickWithJSByLocator(countryDropdownOption, 1);
            Waiters.waitForElementToBeInvisible(countryDropdownOption);
        }

        WebElement groupsDropdown = ElementUtils.getElementWithWaitByLocator(assignContactToGroupsPlusButton, 0);
        Action.scrollIntoView(assignContactToGroupsPlusButton);
        Action.clickWithJSByElement(groupsDropdown, 0);
//        Waiters.waitForElementToBeNotVisible(groupLoader);
        Waiters.waitForElementToBeDisplayed(groupsDropdownOption);
    }

    public void clickOnCreateContactInputByOptionName(String optionName) throws Exception {
        Waiters.waitForElementToBeDisplayed(createContactInputByOptionName(optionName));
        Action.clickByLocator(createContactInputByOptionName(optionName), 0);
        Action.clickByLocator(createContactDialogTitle, 0);
        Waiters.waitWithSleepTimeout(2500);
    }

    public void clickOnMobileNumberInput() throws Exception {
        Waiters.waitForElementToBeDisplayed(mobileNumberInput);
        Action.clickByLocator(mobileNumberInput, 0);
        Action.clickByLocator(createContactDialogTitle, 0);
        Waiters.waitWithSleepTimeout(2500);
    }

    // ... continuing from previous methods

    public void selectOptionFromGroupsDropdownByOptionName(String optionName) throws Exception {
        Waiters.waitForElementToBeDisplayed(groupsDropdownOption);
        List<String> optionList = ElementUtils.getTextListByLocator(groupsDropdownOption);
        int optionIndex = optionList.indexOf(optionName);
        Action.clickByLocator(groupsDropdownOption, optionIndex);
        Waiters.waitForElementToBeInvisible(groupsDropdownOption);
    }

    public List<String> getOptionFromGroupsDropdownTextList() throws Exception {
        Waiters.waitForElementToBeDisplayed(groupsDropdownOption);
        return ElementUtils.getTextListByLocator(groupsDropdownOption);
    }

    public int getAssignContactToGroupsDropdownWidth() throws Exception {
        Waiters.waitForElementToBeDisplayed(groupsDropdownWidth);
        String width = ElementUtils.getCssValueByElement(groupsDropdownWidth, Width, 0);
        return Integer.parseInt(width.replace("px", "").trim());
    }

    public int getAssignContactToGroupsDropdownOptionsWidth() throws Exception {
        Waiters.waitForElementToBeDisplayed(groupsDropdownOptionsContentWidth);
        String width = ElementUtils.getCssValueByElement(groupsDropdownOptionsContentWidth, Width, 0);
        return Integer.parseInt(width.replace("px", "").trim());
    }

    public int getCountryDropdownWidth() throws Exception {
        Waiters.waitForElementToBeDisplayed(countryDropdown);
        String width = ElementUtils.getCssValueByElement(countryDropdown, Width, 0);
        return Integer.parseInt(width.replace("px", "").trim());
    }

    public int getActiveDropdownOptionsWidth() throws Exception {
        Waiters.waitForElementToBeDisplayed(activeDropdownOptionsContent);
        String width = ElementUtils.getCssValueByElement(activeDropdownOptionsContent, Width, 0);
        return Integer.parseInt(width.replace("px", "").trim());
    }

//    public void clickOnSaveButton() throws InterruptedException {
//        Action.clickByLocator(saveButton);
//        Waiters.waitForElementToBeInvisible(loadingButton);
//        contactInsightsPo.waitForTableLoaderIsNotDisplayed();
//    }

    public boolean isChannelUseCheckboxCheckedByName(String optionName) throws InterruptedException {
        return Action.isElementCheckedByLocator(channelUseOptionByName(optionName));
    }

//	public void selectBirthdateFromBirthdateCalendarByDate(String date) throws Exception {
//         Date contactBirthdate = DateUtils.getDateByValue(date);
//        String year = String.valueOf(contactBirthdate.getYear() + 1900); // Adding 1900 as Java Date year starts from 1900
//        String month = new SimpleDateFormat("MMM").format(contactBirthdate);
//        String day = String.format("%02d", contactBirthdate.getDayOfMonth());
//
//        Action.clickByLocator(openCalendarButton, 0);
//        Action.clickByLocator(calendarHeader, 0);
//        List<String> calendarData = getCalendarOptionTextList();
//
//        while (!calendarData.contains(year)) {
//            if (Integer.parseInt(calendarData.get(calendarData.size() - 1)) < Integer.parseInt(year)) {
//                Action.clickByLocator(calendarNextButton, 0);
//            } else {
//                Action.clickByLocator(calendarBackButton, 0);
//            }
//            calendarData = getCalendarOptionTextList();
//        }
//
//        Action.clickByLocator(dateOptionItem(year), 0);
//        Waiters.waitWithSleepTimeout(2500);
//        Action.clickByLocator(dateOptionItem(month.toUpperCase()), 0);
//        Waiters.waitWithSleepTimeout(0);
//        Action.clickByLocator(dateOptionItem(day), 0);
//        Waiters.waitForElementToBeInvisible(calendarHeader);
//    }
	
    public void selectBirthdateFromBirthdateCalendarByDate(String dateStr) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date contactBirthdate = dateFormat.parse(dateStr);
System.out.println("Date -"+contactBirthdate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(contactBirthdate);
        String year = String.valueOf(cal.get(Calendar.YEAR));
        System.out.println("year-"+year);
        String month = new SimpleDateFormat("MMM").format(cal.getTime());
        System.out.println("month-"+month);
        int day = StringUtils.getIntFromString(String.format("%02d", cal.get(Calendar.DAY_OF_MONTH)), 2);
        String day1 = StringUtils.getStringFromInt(StringUtils.getRoundedNumber(day),1);
        System.out.println("day-"+day);
        System.out.println("day1-"+day1);
        
        Action.clickByLocator(openCalendarButton, 0);
        Action.clickByLocator(calendarHeader, 0);
        List<String> calendarData = getCalendarOptionTextList();

        while (!calendarData.contains(year)) {
            if (Integer.parseInt(calendarData.get(calendarData.size() - 1)) < Integer.parseInt(year)) {
                Action.clickByLocator(calendarNextButton, 0);
            } else {
                Action.clickByLocator(calendarBackButton, 0);
            }

            calendarData = getCalendarOptionTextList();
        }

        Action.clickByLocator(dateOptionItem(year), 0);
        Waiters.waitWithSleepTimeout(1000);
        Action.clickByLocator(dateOptionItem(month.toUpperCase()), 0);
        Waiters.waitWithSleepTimeout(1000);
        Action.clickByLocator(dateOptionItem(day1), 0);
        Waiters.waitForElementToBeInvisible(calendarHeader);
    }

    public void selectChannelCheckboxByNameAndStatus(String optionName, String checkboxStatus) throws Exception {
        Action.selectCheckboxByLocatorAndStatus(channelUseOptionByName(optionName), checkboxStatus);
        Waiters.waitWithSleepTimeout(1000);
    }

    public void clickOnCloseButtonByGroupName(String groupName) throws Exception {
        Action.clickByLocator(groupCloseButtonByGroupName(groupName), 0);
        Waiters.waitForElementToBeInvisible(groupCloseButtonByGroupName(groupName));
    }

    // ... continuing from previous methods

    public WebElement getSaveButton() throws Exception {
        return ElementUtils.getElementByLocator(saveButton, 0);
    }

    public WebElement getChannelUseCheckboxByName(String channelName) throws Exception {
        return ElementUtils.getElementByLocator(channelUseOptionByName(channelName), 0);
    }


    public String getCountryDropdownText() throws Exception {
        Waiters.waitForElementToBeDisplayed(selectedCountryDropdown);
        return ElementUtils.getTextByLocator(selectedCountryDropdown, 0);
    }




}