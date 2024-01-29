package steps.contactInsights;

import java.util.List;

import basePackage.BasePo;
import helpers.ArrayUtils;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.DateUtils;
import helpers.StringUtils;
import pages.contactInsights.CreateContactDialogPo;

public class CreateContactDialogSteps extends BasePo{

    private CreateContactDialogPo createContactDialogPo = new CreateContactDialogPo(driver);

    // ... Previous When methods ...

    public void whenTheUserClicksOnTheMobileNumberInputFieldForInTheCreateContactDialog() throws Exception {
        createContactDialogPo.clickOnMobileNumberInput();
    }

    public void whenTheUserChecksUnchecksCheckboxInCreateContactDialog(String checkboxStatus, String optionName) throws Exception {
        createContactDialogPo.selectChannelCheckboxByNameAndStatus(optionName, checkboxStatus);
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
    }

    public void thenTheSaveButtonIsDisabledInTheCreateContactDialog() throws Exception {
        Assertions.expectToBeDisabled(createContactDialogPo.getSaveButton(), "The Save Button is enabled");
    }

    public void thenTheUserSeesErrorMessageAtField(String errorMessage, String optionName) throws Exception {
        Assertions.expectToEqual(createContactDialogPo.getCreateContactErrorMessageByOption(optionName), errorMessage, 
            "The '" + optionName + "' error message is wrong");
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
    }

    public void thenTheCreateContactDialogIsNotDisplayed() {
        Assertions.expectToBeFalse(createContactDialogPo.isCreateContactsDialogElementDisplayed(), 
            "The Create Contact dialog is displayed");
    }

    public void thenTheCountryIsChangedTo(String country) throws Exception {
        Assertions.expectToInclude(createContactDialogPo.getCountryDropdownText(), country, 
            "The country is not changed to '" + country + "'");
    }

    public void thenTheCountryCodeIsChangedTo(String countryCode) throws Exception {
        Assertions.expectToEqual(StringUtils.getStringBySlice(createContactDialogPo.getCountryCodeDropdown(), 0, 4), countryCode,
            "The country code is not changed to '" + countryCode + "'");
    }

    public void thenTheMobileNumberFlagIsChangedTo(String country) {
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

