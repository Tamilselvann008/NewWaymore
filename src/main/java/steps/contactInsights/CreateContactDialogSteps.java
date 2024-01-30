package steps.contactInsights;

import java.util.List;

import basePackage.BasePo;
import helpers.ArrayUtils;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.DateUtils;
import helpers.StepUtils;
import helpers.StringUtils;
import pages.contactInsights.CreateContactDialogPo;

public class CreateContactDialogSteps extends BasePo{

    private static final String firstName = "First Name";
	private static final String lastName = "Last Name";
	private static final String email = "Email";
	private static final String GERMANY = "Germany";
	private CreateContactDialogPo createContactDialogPo = new CreateContactDialogPo(driver);

    // ... Previous When methods ...
    public void whenTheUserEntersAFirstNameLastNameEmailInTheSuitableInputFieldForTheContactInTheCreateContactDialog(String optionName, int contactIndex) {
        String contactData = "";

        switch (optionName) {
            case firstName:
                contactData = DataProviders.getContactTestData("firstName", contactIndex);
                break;
            case lastName:
                contactData = DataProviders.getContactTestData("lastName", contactIndex);;
                break;
            case email:
                contactData = DataProviders.getContactTestData("destination", "identifier", contactIndex, 7);
                break;
        }
        createContactDialogPo.typeContactDataByOptionName(optionName, contactData);
        StepUtils.addLog("The user enters a '" + contactData + "' in the '" + optionName + "' input field");
       
    }
    
    public void whenTheUserEntersAMobileNumberWithACodeForGermanyGreeceJordanCountryInTheMobileNumberInputFieldForTheContactInTheCreateContactDialog(String country, int contactIndex) throws InterruptedException {
    
        String mobile;

        switch (country) {
            case GERMANY:
                // Assuming getPhone() and getNumber() methods exist to extract phone number from contactData
                mobile =  DataProviders.getphoneDetails("number", contactIndex);
                break;
            default:
                mobile = DataProviders.getphoneDetails("number", contactIndex);
                break;
        }

        // Note: Local storage operations in Java Selenium are handled differently than in JavaScript.
//        createContactDialogPo.localStorage.setItem('contactMobileNumber', StringUtils.getStringBySlice(mobile, 1));
        // This step may need to be adapted based on your application's architecture.

        StepUtils.addLog("The user enters a '" + mobile + "' mobile number with a code for '" + country + "' in the mobile number input field");
        createContactDialogPo.typeMobileNumber(mobile);
    }
    
    public void whenTheUserSelectsACountryByTypingInInputFieldInTheDropdownMenuOfCountriesInTheCreateContactDialog(String searchValue) throws Exception {
        createContactDialogPo.selectCountryFromCountryDropdownByValue(searchValue);
        StepUtils.addLog("the user selects a country by typing "+searchValue+" in the input field in the dropdown menu of countries in the Create Contact dialog");
    }
   
    public void whenTheUserClicksOnTheMobileNumberInputFieldForInTheCreateContactDialog() throws Exception {
        createContactDialogPo.clickOnMobileNumberInput();
    }

    public void whenTheUserChecksUnchecksSMSViberCheckboxInCreateContactDialog(String checkboxStatus, String optionName) throws Exception {
        createContactDialogPo.selectChannelCheckboxByNameAndStatus(optionName, checkboxStatus);
        StepUtils.addLog("the user "+checkboxStatus + " " + optionName+" checkbox in the Create Contact dialog");
    }
    public void thenTheCheckboxSMSViberVoiceIsCheckedUncheckedInTheCreateContactDialog(String channel, String optionStatus) throws InterruptedException {
        if ("Checked".equalsIgnoreCase(optionStatus)) {
            Assertions.expectToBeTrue(createContactDialogPo.isChannelUseCheckboxCheckedByName(channel),
                "The checkbox for the '" + channel + "' channel is not checked");
            StepUtils.addLog("The checkbox for the '" + channel + "' channel is checked");
        } else if ("Unchecked".equalsIgnoreCase(optionStatus)) {
            Assertions.expectToBeFalse(createContactDialogPo.isChannelUseCheckboxCheckedByName(channel),
                "The checkbox for the '" + channel + "' channel is checked");
            StepUtils.addLog("The checkbox for the '" + channel + "' channel is Unchecked");
        }
    }
    public void whenTheUserSelectsGroupNumberOptionInTheGroupsDropdown(int groupIndex) throws Exception {
        String groupName = DataProviders.getGroupTestData("name", groupIndex);
        StepUtils.addLog("The user selects the '" + groupName + "' group in the Groups dropdown");
        createContactDialogPo.selectOptionFromGroupsDropdownByOptionName(groupName);
    }
    public void thenTheSelectedGroupNumberIsDisplayedInTheGroupsDropdown(int groupIndex) throws Exception {
        String groupName = DataProviders.getGroupTestData("name", groupIndex);
        Assertions.expectToInclude(createContactDialogPo.getGroupsDropdownText(), groupName, 
            "The group '" + groupName + "' is not displayed in the Groups dropdown");
        StepUtils.addLog("The group '" + groupName + "' is displayed in the Groups dropdown");
    }
    public void whenTheUserClicksOnTheAssignContactToGroupsDropdownInTheCreateContactDialog() throws Exception {
        createContactDialogPo.clickOnAssignContactToGroupsDropdown();
        StepUtils.addLog("the user clicks on the Assign contact to Groups dropdown in the Create Contact dialog");
    }
    public void thenTheCheckboxSMSViberVoiceOptionIsEnabledDisabledInTheCreateContactDialog(String channel, String optionStatus) throws Exception {
        if ("Disabled".equalsIgnoreCase(optionStatus)) {
            Assertions.expectToBeDisabled(createContactDialogPo.getChannelUseCheckboxByName(channel),
                "The checkbox for the '" + channel + "' channel is enabled");
        } else if ("Enabled".equalsIgnoreCase(optionStatus)) {
            Assertions.expectToBeEnabled(createContactDialogPo.getChannelUseCheckboxByName(channel),
                "The checkbox for the '" + channel + "' channel is disabled");
        }
        Assertions.expectToInclude(createContactDialogPo.getChannelUseCheckboxTextByName(channel), optionStatus,
            "The checkbox for the '" + channel + "' channel doesn't have '" + optionStatus + "' status");
        StepUtils.addLog("The checkbox for the '" + channel + "' channel is " +optionStatus);
    }
    public void whenTheUserSelectsTheContactNumberBirthdateFromBirthdateCalendarInTheCreateContactDialog(int contactIndex) throws Exception {
        String contactBirthdate = DataProviders.getContactTestData("birthDate",contactIndex);
        createContactDialogPo.selectBirthdateFromBirthdateCalendarByDate(contactBirthdate);
        StepUtils.addLog("The user selects the '" + contactBirthdate + "' birthdate from Birthdate calendar in the Create Contact dialog");
    }

    
    public void whenTheUserSelectsGroupOptionInGroupsDropdown(int groupIndex) throws Exception {
        String groupName = DataProviders.getGroupTestData("name", groupIndex);
        createContactDialogPo.selectOptionFromGroupsDropdownByOptionName(groupName);
    }

    public void whenTheUserSelectsTheContactBirthdateFromBirthdateCalendarInTheCreateContactDialog(int contactIndex) throws Exception {
        String contactBirthdate = DataProviders.getContactTestData("birthDate", contactIndex);
        createContactDialogPo.selectBirthdateFromBirthdateCalendarByDate(contactBirthdate);
    }

    public void whenTheUserEntersInvalidDataInTheSuitableInputFieldInTheCreateContactDialog(String optionName) {
        String invalidData = StringUtils.getRandomString(10, "lower");
        createContactDialogPo.typeContactDataByOptionName(optionName, invalidData);
    }

    public void whenTheUserClicksOnGroupCloseButtonInTheCreateContactDialog(int groupIndex) throws Exception {
        String groupName = DataProviders.getGroupTestData("name", groupIndex);
        createContactDialogPo.clickOnCloseButtonByGroupName(groupName);
    }

    // ... Then methods ...

    public void thenTheSelectedGroupIsDisplayedInTheGroupsDropdown(int groupIndex) throws Exception {
        String groupName = DataProviders.getGroupTestData("name", groupIndex);
        Assertions.expectToInclude(createContactDialogPo.getGroupsDropdownText(), groupName, 
            "The group '" + groupName + "' is not displayed in the Groups dropdown");
    }

    public void thenTheGroupIsNotDuplicatedInTheDropdownListOfGroupsInCreateEditContactDialog(int groupIndex, String dialog) throws Exception {
        String groupName = DataProviders.getGroupTestData("name", groupIndex);
        List<String> groupOptionList = createContactDialogPo.getOptionFromGroupsDropdownTextList();
        Assertions.expectToInclude(groupOptionList, groupName, 
            "The group '" + groupName + "' is not displayed in the Groups dropdown option list in the '" + dialog + " Contact' dialog");
        Assertions.expectToEqual(ArrayUtils.getDuplicatesFromArray(groupOptionList).size(), 0, 
            "The group name '" + groupName + "' is duplicated");
    }

    public void thenTheSelectedContactBirthdateIsDisplayedInTheAddDateOfBirthInput(int contactIndex) throws Exception {
        String contactBirthdate = DataProviders.getContactTestData("birthDate", contactIndex);
        Assertions.expectToInclude(createContactDialogPo.getAddDateOfBirthInputValue(), 
            DateUtils.getModifiedDateByDate(contactBirthdate, "D/M/YYYY"),
            "The contact birthdate '" + contactBirthdate + "' is not displayed in the Add date of birth input");
    StepUtils.addLog("The contact birthdate '" + contactBirthdate + "' is displayed in the Add date of birth input");
    }

    public void thenTheSaveButtonIsDisabledInTheCreateContactDialog() throws Exception {
        Assertions.expectToBeDisabled(createContactDialogPo.getSaveButton(), "The Save Button is enabled");
    }

    public void thenTheUserSeesErrorMessageAtField(String errorMessage, String optionName) throws Exception {
        Assertions.expectToEqual(createContactDialogPo.getCreateContactErrorMessageByOption(optionName), errorMessage, 
            "The '" + optionName + "' error message is wrong");
    }
    public void whenTheUserClicksOnTheSaveButtonInTheCreateContactDialog() throws Exception {
        createContactDialogPo.clickOnSaveButton();
        StepUtils.addLog("the user clicks on the Save Button in the Create Contact dialog");
    }
    public void thenTheUserCanSeeTheErrorMessageAboutAnInvalidMobileNumberInTheCreateContactDialog() throws Exception {
        Assertions.expectToEqual(createContactDialogPo.getMobileNumberErrorMessageText(), 
            CreateContactMessageEnum.ADD_VALID_PHONE_NUMBER,
            "The error message about an invalid mobile number is incorrect");
    }

    public void thenTheCountryIsDisplayedInTheCreateContactDialog(String country) throws Exception {
        Assertions.expectToInclude(createContactDialogPo.getCountryDropdownText(), country,
            "The country '" + country + "' is not displayed in the Create Contact dialog");
    }
 // Continuing from the previous methods...

    public void thenTheCreateContactOrEditContactDialogIsDisplayed(String title) throws Exception {
        Assertions.expectToBeTrue(createContactDialogPo.isCreateContactsDialogElementDisplayed(), 
            "The Create Contact dialog is not displayed");
        Assertions.expectToEqual(createContactDialogPo.getCreateContactDialogTitleText(), title, 
            "The '" + title + "' title is not correct");
        StepUtils.addLog("the Create contact dialog is displayed");
    }

    public void thenTheCreateContactDialogIsNotDisplayed() {
        Assertions.expectToBeFalse(createContactDialogPo.isCreateContactsDialogElementDisplayed(), 
            "The Create Contact dialog is displayed");
        StepUtils.addLog("the Create contact dialog is not displayed");
    }

    public void thenTheCountryIsChangedToGermanyGreeceJordan(String country) throws Exception {
        Assertions.expectToInclude(createContactDialogPo.getCountryDropdownText(), country, 
            "The country is not changed to '" + country + "'");
        StepUtils.addLog("The country is changed to '" + country + "'");
    }

    public void thenTheCountryCodeIsChangedToDEGRJO(String countryCode) throws Exception {
        Assertions.expectToEqual(StringUtils.getStringBySlice(createContactDialogPo.getCountryCodeDropdown(), 0, 4), countryCode,
            "The country code is not changed to '" + countryCode + "'");
        StepUtils.addLog("the country code is changed to '" + countryCode + "'");
    }

    public void thenTheMobileNumberFlagIsChangedToGermanyGreeceJordan(String country) {
        Assertions.expectToBeTrue(createContactDialogPo.isMobileNumberFlagByCountryVisible(country), 
            "The mobile number flag is not changed to '" + country + "'");
    }

    public void thenTheWidthOfTheOptionsInTheCountryDropdownIsTheSameAsTheWidthOfTheDropdownInTheCreateContactDialog() throws Exception {
        int dropdownWidth = createContactDialogPo.getCountryDropdownWidth();
        int dropdownOptionsWidth = createContactDialogPo.getActiveDropdownOptionsWidth();
        Assertions.expectToEqual(dropdownOptionsWidth, dropdownWidth, 
            "The width of the options in the country dropdown is not the same as the width of the dropdown");
    }

    public void thenTheWidthOfTheOptionsInTheAssignContactsToGroupsDropdownIsTheSameAsTheWidthOfTheDropdownInTheCreateContactDialog() throws Exception {
        int dropdownWidth = createContactDialogPo.getAssignContactToGroupsDropdownWidth();
        int dropdownOptionsWidth = createContactDialogPo.getAssignContactToGroupsDropdownOptionsWidth();
        Assertions.expectToEqual(dropdownOptionsWidth, dropdownWidth,
            "The width of the options in the Assign contacts to Groups dropdown is not the same as the width of the dropdown");
    }

    public void thenTheCheckboxChannelIsCheckedUncheckedInCreateContactDialog(String channel, String optionStatus) throws InterruptedException {
        if ("checked".equals(optionStatus)) {
            Assertions.expectToBeTrue(createContactDialogPo.isChannelUseCheckboxCheckedByName(channel),
                "The checkbox for the '" + channel + "' channel is not checked");
        } else if ("unchecked".equals(optionStatus)) {
            Assertions.expectToBeFalse(createContactDialogPo.isChannelUseCheckboxCheckedByName(channel),
                "The checkbox for the '" + channel + "' channel is checked");
        }
    }

    public void thenTheCheckboxChannelOptionIsEnabledDisabledInCreateContactDialog(String channel, String optionStatus) throws Exception {
        if ("Disabled".equals(optionStatus)) {
            Assertions.expectToBeDisabled(createContactDialogPo.getChannelUseCheckboxByName(channel),
                "The checkbox for the '" + channel + "' channel is enabled");
        } else if ("Enabled".equals(optionStatus)) {
            Assertions.expectToBeEnabled(createContactDialogPo.getChannelUseCheckboxByName(channel),
                "The checkbox for the '" + channel + "' channel is disabled");
        }
        Assertions.expectToInclude(createContactDialogPo.getChannelUseCheckboxTextByName(channel), optionStatus,
            "The checkbox for the '" + channel + "' channel doesn't have '" + optionStatus + "' status");
    }

    // Other methods as needed...
}

