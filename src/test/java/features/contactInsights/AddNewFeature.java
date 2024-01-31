package features.contactInsights;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BasePo;
import steps.contactInsights.ContactInsightsSteps;
import steps.contactInsights.CreateContactDialogSteps;
import steps.login.LoginSteps;
import steps.sideMenu.SideMenuSteps;

public class AddNewFeature extends BasePo {
	private static final String createContact = "Create contact";
	private static final String editContact = "Edit contact";
	private static final String firstName = "First Name";
	private static final String lastName = "Last Name";
	private static final String email = "Email";
	private static final String Jordan = "Jordan";
	private static final String Greece = "Greece";
	private static final String ContactInsights = "Contact  Insights";
	private static final String check = "Check";
	private static final String uncheck = "unchecks";
	private static final String SMS = "SMS";
	private static final String checked = "checked";
	private static final String unchecked = "unchecked";
	private static final String enabled = "Enabled";
	private static final String disabled = "Disabled";
	private static final String viber = "Viber";
	private static final String jor = "JOR";
	private static final String grc = "GRC";
	private static final String ThisFieldIsRequired = "This field is required";
	private static final String PleaseEnableAtLeastOneChannel = "Please enable at least one channel";
	private LoginSteps loginSteps = new LoginSteps();
	private SideMenuSteps sideMenuSteps = new SideMenuSteps();
	private ContactInsightsSteps contactInsightsSteps = new ContactInsightsSteps();
	private CreateContactDialogSteps createContactDialogSteps = new CreateContactDialogSteps();

	@BeforeTest
	public void launchWebsite() {
		browserLaunch();
	}

	@AfterTest
	public void tearDown() {
		closeBrowser();
	}

	@Test(description = "@ALW-12074 @TR-12074 @Regression\r\n" + "@BugALW-32607 @BugALW-18862\r\n"
			+ "Scenario: The user can add a new contact")
	public void theUserCanAddANewContact() throws Exception {
//    	    Given [API] the user № 1 sets authentication token
//    	    And [API] the user № 1 removes all existing contacts
//    	    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups
//    	    And [API] the user № 1 adds a new group № 3 to the list of groups
//         When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//         Then the Side Menu is displayed
		sideMenuSteps.thenTheSideMenuIsDisplayed();
//         When the user clicks on the Contact Insights item
		sideMenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						ContactInsights);
//         And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sideMenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//        Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//        And the table does not display any contacts on the Contacts Insights page
		contactInsightsSteps.thenTheTableDoesNotDisplayAnyContactsOnTheContactsInsightsPage();
//        When the user clicks on the Add New button on the Contact Insights page
		contactInsightsSteps.whenTheUserClicksOnTheAddNewButtonOnTheContactInsightsPage();
//        Then the Create contact dialog is displayed
		createContactDialogSteps.thenTheCreateContactOrEditContactDialogIsDisplayed(createContact);
//        When the user enters a First Name in the suitable input field for the contact № 1 in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserEntersAFirstNameLastNameEmailInTheSuitableInputFieldForTheContactInTheCreateContactDialog(
						firstName, 1);
//        And the user enters a Last Name in the suitable input field for the contact № 1 in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserEntersAFirstNameLastNameEmailInTheSuitableInputFieldForTheContactInTheCreateContactDialog(
						lastName, 1);
//        And the user enters a Email in the suitable input field for the contact № 1 in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserEntersAFirstNameLastNameEmailInTheSuitableInputFieldForTheContactInTheCreateContactDialog(
						email, 1);
//        And the user enters a mobile number with a code for Jordan in the mobile number input field for the contact № 1 in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserEntersAMobileNumberWithACodeForGermanyGreeceJordanCountryInTheMobileNumberInputFieldForTheContactInTheCreateContactDialog(
						Jordan, 1);
//        And the user selects a country by typing Jordan in the input field in the dropdown menu of countries in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserSelectsACountryByTypingInInputFieldInTheDropdownMenuOfCountriesInTheCreateContactDialog(
						Jordan);
//        Then the country is changed to Jordan
		createContactDialogSteps.thenTheCountryIsChangedToGermanyGreeceJordan(Jordan);
//        And the country code is changed to 🇯🇴
		createContactDialogSteps.thenTheCountryCodeIsChangedToDEGRJO("🇯🇴");
//        And the mobile number flag is changed to Jordan
		createContactDialogSteps.thenTheMobileNumberFlagIsChangedToGermanyGreeceJordan(Jordan);
//        When the user checks SMS checkbox in the Create Contact dialog
		createContactDialogSteps.whenTheUserChecksUnchecksSMSViberCheckboxInCreateContactDialog(check, SMS);
//        Then the checkbox SMS is checked in the Create Contact dialog
		createContactDialogSteps.thenTheCheckboxSMSViberVoiceIsCheckedUncheckedInTheCreateContactDialog(SMS, checked);
//        And the checkbox SMS option is Enabled in the Create Contact dialog
		createContactDialogSteps.thenTheCheckboxSMSViberVoiceOptionIsEnabledDisabledInTheCreateContactDialog(SMS,
				enabled);
//        When the user checks Viber checkbox in the Create Contact dialog
		createContactDialogSteps.whenTheUserChecksUnchecksSMSViberCheckboxInCreateContactDialog(check, viber);
//        Then the checkbox Viber is checked in the Create Contact dialog
		createContactDialogSteps.thenTheCheckboxSMSViberVoiceIsCheckedUncheckedInTheCreateContactDialog(viber, checked);
//        And the checkbox Viber option is Enabled in the Create Contact dialog
		createContactDialogSteps.thenTheCheckboxSMSViberVoiceOptionIsEnabledDisabledInTheCreateContactDialog(viber,
				enabled);
//        When the user clicks on the Assign contact to Groups dropdown in the Create Contact dialog
		createContactDialogSteps.whenTheUserClicksOnTheAssignContactToGroupsDropdownInTheCreateContactDialog();
//        And the user selects group № 3 option in the Groups dropdown
		createContactDialogSteps.whenTheUserSelectsGroupNumberOptionInTheGroupsDropdown(3);
//        Then the selected group № 3 is displayed in the Groups dropdown
		createContactDialogSteps.thenTheSelectedGroupNumberIsDisplayedInTheGroupsDropdown(3);
//        When the user selects the contact № 1 birthdate from Birthdate calendar in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserSelectsTheContactNumberBirthdateFromBirthdateCalendarInTheCreateContactDialog(1);
//        Then the selected contact № 1 birthdate is displayed in the the Add date of birth input
		createContactDialogSteps.thenTheSelectedContactBirthdateIsDisplayedInTheAddDateOfBirthInput(1);
//        When the user clicks on the Save Button in the Create Contact dialog
		createContactDialogSteps.whenTheUserClicksOnTheSaveButtonInTheCreateContactDialog();
//        Then the Create contact dialog is not displayed
		createContactDialogSteps.thenTheCreateContactDialogIsNotDisplayed();
//        And the First Name and Last Name data of the contact № 1 is displayed in the Contacts list
		contactInsightsSteps.thenTheFirstNameAndLastNameDataOfTheContactNumberIsDisplayedInTheContactsList(1);
//        And the country code for the contact № 1 is displayed as JOR on the Contacts Insights page
		contactInsightsSteps.thenTheCountryCodeForTheContactNumberIsDisplayedAsDEUGRCJOROnTheContactsInsightsPage(1,
				jor);
//        And the data of SMS and Viber channels for the contact № 1 is displayed in the Contacts list
		contactInsightsSteps.thenTheDataOfSMSAndViberChannelsForTheContactNumberIsDisplayedInTheContactsList(1);
//        And the Email data of the contact № 1 is displayed in the Contacts list
		contactInsightsSteps.thenTheEmailDataOfTheContactNumberIsDisplayedInTheContactsList(1);
//        And the group № 3 for the contact № 1 is displayed as selected in the Contacts list
		contactInsightsSteps.thenTheGroupNumberForTheContactNumberIsDisplayedAsSelectedInTheContactsList(3, 1);
	}

	@Test(description = " @ALW-12546 @TR-12546 @Regression\r\n" + "@BugALW-32607 @BugALW-18862\r\n"
			+ "Scenario: The user can add a new contact with one channel")
	public void theUserCanAddANewContactWithOneChannel() throws Exception {

//    	    Given [API] the user № 1 sets authentication token
//    	    And [API] the user № 1 removes all existing contacts
//    	    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups
//    	    And [API] the user № 1 adds a new group № 3 to the list of groups
//    	    When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//          Then the Side Menu is displayed
		sideMenuSteps.thenTheSideMenuIsDisplayed();
//    	    When the user clicks on the Contact Insights item
		sideMenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						ContactInsights);
//        And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sideMenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//       Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//    	    And the table does not display any contacts on the Contacts Insights page
//     And the table does not display any contacts on the Contacts Insights page
		contactInsightsSteps.thenTheTableDoesNotDisplayAnyContactsOnTheContactsInsightsPage();
//     When the user clicks on the Add New button on the Contact Insights page
		contactInsightsSteps.whenTheUserClicksOnTheAddNewButtonOnTheContactInsightsPage();
//     Then the Create contact dialog is displayed
		createContactDialogSteps.thenTheCreateContactOrEditContactDialogIsDisplayed(createContact);
//     When the user enters a First Name in the suitable input field for the contact № 2 in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserEntersAFirstNameLastNameEmailInTheSuitableInputFieldForTheContactInTheCreateContactDialog(
						firstName, 2);
//     And the user enters a Last Name in the suitable input field for the contact № 2 in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserEntersAFirstNameLastNameEmailInTheSuitableInputFieldForTheContactInTheCreateContactDialog(
						lastName, 2);
//     And the user enters a Email in the suitable input field for the contact № 2 in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserEntersAFirstNameLastNameEmailInTheSuitableInputFieldForTheContactInTheCreateContactDialog(
						email, 2);
//    	    And the user enters a mobile number with a code for Greece in the mobile number input field for the contact № 2 in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserEntersAMobileNumberWithACodeForGermanyGreeceJordanCountryInTheMobileNumberInputFieldForTheContactInTheCreateContactDialog(
						Greece, 2);
//    	    And the user selects a country by typing Greece in the input field in the dropdown menu of countries in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserSelectsACountryByTypingInInputFieldInTheDropdownMenuOfCountriesInTheCreateContactDialog(
						Greece);
//    	    Then the country is changed to Greece
		createContactDialogSteps.thenTheCountryIsChangedToGermanyGreeceJordan(Greece);
//    	    And the country code is changed to 🇬🇷
		createContactDialogSteps.thenTheCountryCodeIsChangedToDEGRJO("🇬🇷");
//    	    And the mobile number flag is changed to Greece
		createContactDialogSteps.thenTheMobileNumberFlagIsChangedToGermanyGreeceJordan(Greece);
//    	    When the user checks SMS checkbox in the Create Contact dialog
		createContactDialogSteps.whenTheUserChecksUnchecksSMSViberCheckboxInCreateContactDialog(check, SMS);
//      Then the checkbox SMS is checked in the Create Contact dialog
		createContactDialogSteps.thenTheCheckboxSMSViberVoiceIsCheckedUncheckedInTheCreateContactDialog(SMS, checked);
//      And the checkbox SMS option is Enabled in the Create Contact dialog
		createContactDialogSteps.thenTheCheckboxSMSViberVoiceOptionIsEnabledDisabledInTheCreateContactDialog(SMS,
				enabled);
//    	    When the user clicks on the Assign contact to Groups dropdown in the Create Contact dialog
		createContactDialogSteps.whenTheUserClicksOnTheAssignContactToGroupsDropdownInTheCreateContactDialog();
//    	    And the user selects group № 3 option in the Groups dropdown
		createContactDialogSteps.whenTheUserSelectsGroupNumberOptionInTheGroupsDropdown(3);
//    	    Then the selected group № 3 is displayed in the Groups dropdown
		createContactDialogSteps.thenTheSelectedGroupNumberIsDisplayedInTheGroupsDropdown(3);
//    	    When the user selects the contact № 2 birthdate from Birthdate calendar in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserSelectsTheContactNumberBirthdateFromBirthdateCalendarInTheCreateContactDialog(2);
//    	    Then the selected contact № 2 birthdate is displayed in the the Add date of birth input
		createContactDialogSteps.thenTheSelectedContactBirthdateIsDisplayedInTheAddDateOfBirthInput(2);
//    	    When the user clicks on the Save Button in the Create Contact dialog
		createContactDialogSteps.whenTheUserClicksOnTheSaveButtonInTheCreateContactDialog();
//      Then the Create contact dialog is not displayed
		createContactDialogSteps.thenTheCreateContactDialogIsNotDisplayed();
//    	    And the First Name and Last Name data of the contact № 2 is displayed in the Contacts list
		contactInsightsSteps.thenTheFirstNameAndLastNameDataOfTheContactNumberIsDisplayedInTheContactsList(2);
//    	    And the country code for the contact № 2 is displayed as GRC on the Contacts Insights page
		contactInsightsSteps.thenTheCountryCodeForTheContactNumberIsDisplayedAsDEUGRCJOROnTheContactsInsightsPage(2,
				grc);
//    	    And the data of SMS channel for the contact № 2 is displayed in the Contacts list
		contactInsightsSteps.thenTheDataOfSMSViberChannelForTheContactNumberIsDisplayedInTheContactsList(SMS, 2);
//    	    And the Viber channel data for the contact № 2 is empty for added contact in the Contacts list
		contactInsightsSteps.thenTheSMSViberChannelDataForTheContactNumberIsEmptyForAddedContactInTheContactsList(viber,
				2, "for added contact");
//    	    And the Email data of the contact № 2 is displayed in the Contacts list
		contactInsightsSteps.thenTheEmailDataOfTheContactNumberIsDisplayedInTheContactsList(2);
//    	    And the group № 3 for the contact № 2 is displayed as selected in the Contacts list
		contactInsightsSteps.thenTheGroupNumberForTheContactNumberIsDisplayedAsSelectedInTheContactsList(3, 2);

	}

	@Test(description = "@ALW-13213 @TR-13213 @Regression\r\n" + "@BugALW-32607 @BugALW-32614 @BugALW-18862\r\n"
			+ "Scenario: The user can add a new contact to multiply groups")
	public void theUserCanAddANewContactToMultiplyGroups() throws Exception {

//		    Given [API] the user № 1 sets authentication token
//		    And [API] the user № 1 removes all existing contacts
//		    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups
//		    And [API] the user № 1 adds a new group № 3 to the list of groups
//		    And [API] the user № 1 removes the existing group № 4 with all contacts in that group from the list of groups
//		    And [API] the user № 1 adds a new group № 4 to the list of groups
//      When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//      Then the Side Menu is displayed
		sideMenuSteps.thenTheSideMenuIsDisplayed();
//      When the user clicks on the Contact Insights item
		sideMenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						ContactInsights);
//      And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sideMenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//     Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//     And the table does not display any contacts on the Contacts Insights page
		contactInsightsSteps.thenTheTableDoesNotDisplayAnyContactsOnTheContactsInsightsPage();
//     When the user clicks on the Add New button on the Contact Insights page
		contactInsightsSteps.whenTheUserClicksOnTheAddNewButtonOnTheContactInsightsPage();
//     Then the Create contact dialog is displayed
		createContactDialogSteps.thenTheCreateContactOrEditContactDialogIsDisplayed(createContact);
//	     When the user enters a First Name in the suitable input field for the contact № 2 in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserEntersAFirstNameLastNameEmailInTheSuitableInputFieldForTheContactInTheCreateContactDialog(
						firstName, 2);
//	     And the user enters a Last Name in the suitable input field for the contact № 2 in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserEntersAFirstNameLastNameEmailInTheSuitableInputFieldForTheContactInTheCreateContactDialog(
						lastName, 2);
//		    And the user enters a mobile number with a code for Greece in the mobile number input field for the contact № 2 in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserEntersAMobileNumberWithACodeForGermanyGreeceJordanCountryInTheMobileNumberInputFieldForTheContactInTheCreateContactDialog(
						Greece, 2);
//		    And the user selects a country by typing Greece in the input field in the dropdown menu of countries in the Create Contact dialog
		createContactDialogSteps
				.whenTheUserSelectsACountryByTypingInInputFieldInTheDropdownMenuOfCountriesInTheCreateContactDialog(
						Greece);
//		    Then the country is changed to Greece
		createContactDialogSteps.thenTheCountryIsChangedToGermanyGreeceJordan(Greece);
//    	    And the country code is changed to 🇬🇷
		createContactDialogSteps.thenTheCountryCodeIsChangedToDEGRJO("🇬🇷");
//		    And the mobile number flag is changed to Greece
		createContactDialogSteps.thenTheMobileNumberFlagIsChangedToGermanyGreeceJordan(Greece);
//		    When the user checks SMS checkbox in the Create Contact dialog
		createContactDialogSteps.whenTheUserChecksUnchecksSMSViberCheckboxInCreateContactDialog(check, SMS);
//		    Then the checkbox SMS is checked in the Create Contact dialog
		createContactDialogSteps.thenTheCheckboxSMSViberVoiceIsCheckedUncheckedInTheCreateContactDialog(SMS, checked);
//		    And the checkbox SMS option is Enabled in the Create Contact dialog
		createContactDialogSteps.thenTheCheckboxSMSViberVoiceOptionIsEnabledDisabledInTheCreateContactDialog(SMS,
				enabled);
//		    When the user clicks on the Assign contact to Groups dropdown in the Create Contact dialog
		createContactDialogSteps.whenTheUserClicksOnTheAssignContactToGroupsDropdownInTheCreateContactDialog();
//		    And the user selects group № 3 option in the Groups dropdown
		createContactDialogSteps.whenTheUserSelectsGroupNumberOptionInTheGroupsDropdown(3);
//		    Then the selected group № 3 is displayed in the Groups dropdown
		createContactDialogSteps.thenTheSelectedGroupNumberIsDisplayedInTheGroupsDropdown(3);
//		    When the user clicks on the Assign contact to Groups dropdown in the Create Contact dialog
		createContactDialogSteps.whenTheUserClicksOnTheAssignContactToGroupsDropdownInTheCreateContactDialog();
//		    And the user selects group № 4 option in the Groups dropdown
		createContactDialogSteps.whenTheUserSelectsGroupNumberOptionInTheGroupsDropdown(4);
//		    Then the selected group № 4 is displayed in the Groups dropdown
		createContactDialogSteps.thenTheSelectedGroupNumberIsDisplayedInTheGroupsDropdown(4);
//		    When the user clicks on the Save Button in the Create Contact dialog
		createContactDialogSteps.whenTheUserClicksOnTheSaveButtonInTheCreateContactDialog();
//		    Then the Create contact dialog is not displayed
		createContactDialogSteps.thenTheCreateContactDialogIsNotDisplayed();
//		    And the group № 3 for the contact № 2 is displayed as selected in the Contacts list
		contactInsightsSteps.thenTheGroupNumberForTheContactNumberIsDisplayedAsSelectedInTheContactsList(3, 2);
//		    And the group № 4 for the contact № 2 is displayed as selected in the Contacts list
		contactInsightsSteps.thenTheGroupNumberForTheContactNumberIsDisplayedAsSelectedInTheContactsList(4, 2);

	}
	
	
	@Test(description = "@ALW-12619 @TR-12619 @Regression\r\n"
			+ "	  @BugALW-23622\r\n"
			+ "	  Scenario: The user can't create a new contact without filling required fields")
	public void theUserCannotCreateANewContactWithoutFillingRequiredFields() throws Exception {
		
		
//      When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//      Then the Side Menu is displayed
		sideMenuSteps.thenTheSideMenuIsDisplayed();
//      When the user clicks on the Contact Insights item
		sideMenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						ContactInsights);
//      And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sideMenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//     Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//     And the table does not display any contacts on the Contacts Insights page
		contactInsightsSteps.thenTheTableDoesNotDisplayAnyContactsOnTheContactsInsightsPage();
//     When the user clicks on the Add New button on the Contact Insights page
		contactInsightsSteps.whenTheUserClicksOnTheAddNewButtonOnTheContactInsightsPage();
//     Then the Create contact dialog is displayed
		createContactDialogSteps.thenTheCreateContactOrEditContactDialogIsDisplayed(createContact);
//		    When the user clicks on the First Name input field for in the Create Contact dialog
		createContactDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailInputFieldForInTheCreateContactDialog(firstName);
//		    Then the user sees This field is required error message at the First Name field
		createContactDialogSteps.thenTheUserSeesThisFieldIsRequiredPleaseEnableAtLeastOneChannelErrorMessageAtField(ThisFieldIsRequired,firstName);
//		    When the user clicks on the Last Name input field for in the Create Contact dialog
		createContactDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailInputFieldForInTheCreateContactDialog(lastName);
//		    Then the user sees This field is required error message at the Last Name field
		createContactDialogSteps.thenTheUserSeesThisFieldIsRequiredPleaseEnableAtLeastOneChannelErrorMessageAtField(ThisFieldIsRequired,lastName);
//		    When the user clicks on the Email input field for in the Create Contact dialog
		createContactDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailInputFieldForInTheCreateContactDialog(email);
//		    Then the user sees This field is required error message at the Email field
		createContactDialogSteps.thenTheUserSeesThisFieldIsRequiredPleaseEnableAtLeastOneChannelErrorMessageAtField(ThisFieldIsRequired,email);
//		    When the user clicks on the Mobile Number input field for in the Create Contact dialog
		createContactDialogSteps.whenTheUserClicksOnTheMobileNumberInputFieldForInTheCreateContactDialog();
//		    Then the user sees This field is required error message at the Mobile Number field
		createContactDialogSteps.thenTheUserSeesThisFieldIsRequiredPleaseEnableAtLeastOneChannelErrorMessageAtField(ThisFieldIsRequired,"MobileNumber");
//		    And the Save Button is disabled in the Create Contact dialog
		createContactDialogSteps.thenTheSaveButtonIsDisabledInTheCreateContactDialog();
	}
	
	   

}
