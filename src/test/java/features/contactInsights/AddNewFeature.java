package features.contactInsights;

import org.testng.annotations.Test;

import basePackage.BasePo;
import steps.contactInsights.ContactInsightsSteps;
import steps.sideMenu.SideMenuSteps;

public class AddNewFeature extends BasePo{

    private SideMenuSteps sideMenuSteps = new SideMenuSteps();
    private ContactInsightsSteps contactInsightsSteps = new ContactInsightsSteps();
    private CreateContactDialogSteps createContactDialogSteps = new CreateContactDialogSteps();

    @Test 
    public void testUserInteractionsOnContactInsightsPage() {
        // When the user № 1 is on the Getting started with WayMore page
        // (Assuming this setup is done prior to the test)

        // Then the Side Menu is displayed
        sideMenuSteps.thenTheSideMenuIsDisplayed();

        // When the user clicks on the Contact Insights item
        sideMenuSteps.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem("ContactInsights");

        // And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
        sideMenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption("ContactInsights","ContactInsights");

        // Then the CONTACTS title is displayed
        contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");

        // And the table does not display any contacts on the Contacts Insights page
        contactInsightsSteps.thenTheTableDoesNotDisplayAnyContactsOnTheContactsInsightsPage();

        // When the user clicks on the Add New button on the Contact Insights page
        contactInsightsSteps.whenTheUserClicksOnTheAddNewButtonOnTheContactInsightsPage();

        // Then the Create contact dialog is displayed
        createContactDialogSteps.thenTheCreateContactDialogIsDisplayed();

        // When the user enters a First Name in the suitable input field for the contact № 1 in the Create Contact dialog
        createContactDialogSteps.whenTheUserEntersAFirstNameInTheSuitableInputFieldForTheContactNumberInCreateContactDialog(1);

        // And the user enters a Last Name in the suitable input field for the contact № 1 in the Create Contact dialog
        createContactDialogSteps.whenTheUserEntersALastNameInTheSuitableInputFieldForTheContactNumberInCreateContactDialog(1);

        // And the user enters an Email in the suitable input field for the contact № 1 in the Create Contact dialog
        createContactDialogSteps.whenTheUserEntersAEmailInTheSuitableInputFieldForTheContactNumberInCreateContactDialog(1);

        // And the user enters a mobile number with a code for Jordan in the mobile number input field for the contact № 1 in the Create Contact dialog
        // And the user selects a country by typing Jordan in the input field in the dropdown menu of countries in the Create Contact dialog
        createContactDialogSteps.whenTheUserEntersAMobileNumberWithCodeForJordanInTheMobileNumberInputFieldForTheContactNumberInCreateContactDialog(1);

        // Then the country is changed to Jordan
        // And the country code is changed to 🇯🇴
        // And the mobile number flag is changed to Jordan
        createContactDialogSteps.thenTheCountryIsChangedToJordanAndCountryCodeIsChangedToJordanFlag();

        // When the user checks SMS checkbox in the Create Contact dialog
        createContactDialogSteps.whenTheUserChecksSMSCheckboxInCreateContactDialog();

        // Then the checkbox SMS is checked in the Create Contact dialog
        // And the checkbox SMS option is Enabled in the Create Contact dialog
        createContactDialogSteps.thenTheCheckboxSMSIsCheckedAndEnabledInCreateContactDialog();

        // When the user checks Viber checkbox in the Create Contact dialog
        createContactDialogSteps.whenTheUserChecksViberCheckboxInCreateContactDialog();

        // Then the checkbox Viber is checked in the Create Contact dialog
        // And the checkbox Viber option is Enabled in the Create Contact dialog
        createContactDialogSteps.thenTheCheckboxViberIsCheckedAndEnabledInCreateContactDialog();

        // When the user clicks on the Assign contact to Groups dropdown in the Create Contact dialog
        // And the user selects group № 3 option in the Groups dropdown
        createContactDialogSteps.whenTheUserSelectsGroupNumberOptionInGroupsDropdownInCreateContactDialog(3);

        // Then the selected group № 3 is displayed in the Groups dropdown
        createContactDialogSteps.thenTheSelectedGroupNumberIsDisplayedInGroupsDropdown(3);

        // When the user selects the contact № 1 birthdate from Birthdate calendar in the Create Contact dialog
        createContactDialogSteps.whenTheUserSelectsTheContactNumberBirthdateFromBirthdateCalendarInCreateContactDialog(1);

        // Then the selected contact № 1 birthdate is displayed in the the Add date of birth input
        createContactDialogSteps.thenTheSelectedContactNumberBirthdateIsDisplayedInAddDateOfBirthInput(1);

        // When the user clicks on the Save Button in the Create Contact dialog
        createContactDialogSteps.whenTheUserClicksOnTheSaveButtonInCreateContactDialog();

        // Then the Create contact dialog is not displayed
        createContactDialogSteps.thenTheCreateContactDialogIsNotDisplayed();
    }
}
