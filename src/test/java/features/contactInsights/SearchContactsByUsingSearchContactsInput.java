package features.contactInsights;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BasePo;
import enums.uienums.OptionEnum.ContactsOptionEnum;
import enums.uienums.OptionEnum.MenuItemOptionEnum;
import steps.contactInsights.ContactInsightsSteps;
import steps.login.LoginSteps;
import steps.sideMenu.SideMenuSteps;

public class SearchContactsByUsingSearchContactsInput extends BasePo {

	private LoginSteps loginSteps = new LoginSteps();
	private SideMenuSteps sidemenuSteps = new SideMenuSteps();
	private ContactInsightsSteps contactInsightsSteps = new ContactInsightsSteps();

	@BeforeTest
	public void launchWebsite() {
		browserLaunch();
	}

//	@AfterTest
//	public void tearDown() {
//		closeBrowser();
//	}

	@Test(description = "@WQ-418 @TR-418 @Regression\r\n" + "	  @BugALW-11389 @BugALW-10050\r\n"
			+ "	  Scenario: The user can search contacts from the WayMore Contact Insights list by first name")
	public void theUserCanSearchContactsFromTheWayMoreContactInsightsListByFirstName() throws Exception {

//	    Given [API] the user № 1 sets authentication token
//	    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//	    And [API] the user № 1 adds a new contact № 2 to the list of contacts
//	    And [API] the user № 1 adds a new group № 3 to the list of groups
//	    And [API] the user № 1 adds the contact № 1 to the group № 3
//	    And [API] the user № 1 adds the contact № 2 to the group № 3
//	    When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//	    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//	    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//	    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//	    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//	    When the user filters contacts by entering the AQAFirstName value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
						"AQAFirstName");
//	    Then all filtered results shown in the First Name column contain the AQAFirstName value that was entered in the Search Contacts input field
		contactInsightsSteps
				.thenAllFilteredResultsShownInTheColumnContainTheValueThatWasEnteredInTheSearchContactsInputField(
						ContactsOptionEnum.FirstName, "AQAFirstName");
//	    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups
	}

	@Test(description = " @WQ-419 @TR-419 @Regression\r\n" + "  @BugALW-11389 @BugALW-10050\r\n"
			+ "  Scenario: The user can search contacts from the WayMore Contact Insights list by last name")
	public void theUserCanSearchContactsFromTheWayMoreContactInsightsListByLastName() throws Exception {
//		    Given [API] the user № 1 sets authentication token
//		    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//		    And [API] the user № 1 adds a new contact № 2 to the list of contacts
//		    And [API] the user № 1 adds a new group № 3 to the list of groups
//		    And [API] the user № 1 adds the contact № 1 to the group № 3
//		    And [API] the user № 1 adds the contact № 2 to the group № 3
//		    When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//		    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//		    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//		    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//		    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//		    When the user filters contacts by entering the AQALastName value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
						"AQALastName");
//		    Then all filtered results shown in the Last Name column contain the AQALastName value that was entered in the Search Contacts input field
		contactInsightsSteps
				.thenAllFilteredResultsShownInTheColumnContainTheValueThatWasEnteredInTheSearchContactsInputField(
						ContactsOptionEnum.LastName, "AQALastName");
//		    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups

	}

	@Test(description = "@WQ-422 @TR-422 @Regression\r\n" + "	  @BugALW-5826 @BugALW-11389 @BugALW-10050\r\n"
			+ "	  Scenario: The user can search contacts from the WayMore Contact Insights list by country")
	public void theUserCanSearchContactsFromTheWayMoreContactInsightsListByCountry() throws Exception {

//		  Given [API] the user № 1 sets authentication token
//		    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//		    And [API] the user № 1 adds a new contact № 2 to the list of contacts
//		    And [API] the user № 1 adds a new group № 3 to the list of groups
//		    And [API] the user № 1 adds the contact № 1 to the group № 3
//		    And [API] the user № 1 adds the contact № 2 to the group № 3
//		    When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//		    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//		    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//		    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//		    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//		    When the user filters contacts by entering the GRC value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage("GRC");
//		    Then all filtered results shown in the Country column contain the GRC value that was entered in the Search Contacts input field
		contactInsightsSteps
				.thenAllFilteredResultsShownInTheColumnContainTheValueThatWasEnteredInTheSearchContactsInputField(
						ContactsOptionEnum.Country, "GRC");
//		    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups

	}

	@Test(description = " @WQ-423 @TR-423 @Regression\r\n" + "	  @BugALW-11389 @BugALW-10050\r\n"
			+ "	  Scenario: The user can search contacts from the WayMore Contact Insights list by email")
	public void theUserCanSearchContactsFromTheWayMoreContactInsightsListByEmail() throws Exception {

//		Given [API] the user № 1 sets authentication token
//	    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//	    And [API] the user № 1 adds a new contact № 2 to the list of contacts
//	    And [API] the user № 1 adds a new group № 3 to the list of groups
//	    And [API] the user № 1 adds the contact № 1 to the group № 3
//	    And [API] the user № 1 adds the contact № 2 to the group № 3
//	    When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//	    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//	    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//	    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//	    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//	    When the user filters contacts by entering the bribri880@email-temp.com value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
						"bribri880@email-temp.com");
//	    Then all filtered results shown in the Email column contain the bribri880@email-temp.com value that was entered in the Search Contacts input field
		contactInsightsSteps
				.thenAllFilteredResultsShownInTheColumnContainTheValueThatWasEnteredInTheSearchContactsInputField(
						ContactsOptionEnum.Email, "bribri880@email-temp.com");
//	    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups

	}

	@Test(description = "@WQ-424 @TR-424 @Regression\r\n" + "	  @BugALW-11389 @BugALW-10050\r\n"
			+ "	  Scenario: The user can search contacts from the WayMore Contact Insights list by mobile phone")
	public void theUserCanSearchContactsFromTheWayMoreContactInsightsListByMobilePhone() throws Exception {

//		 Given [API] the user № 1 sets authentication token
//		    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//		    And [API] the user № 1 adds a new contact № 2 to the list of contacts
//		    And [API] the user № 1 adds a new group № 3 to the list of groups
//		    And [API] the user № 1 adds the contact № 1 to the group № 3
//		    And [API] the user № 1 adds the contact № 2 to the group № 3
//	    When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//	    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//	    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//	    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//	    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//		    When the user filters contacts by entering the 962796699276 value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
						"962796699276");
//		    Then all filtered results shown in the Mobile Phone column contain the 962796699276 value that was entered in the Search Contacts input field
		contactInsightsSteps
				.thenAllFilteredResultsShownInTheColumnContainTheValueThatWasEnteredInTheSearchContactsInputField(
						ContactsOptionEnum.Mobile, "962796699276");
//		    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups

	}

	@Test(description = " @WQ-426 @TR-426 @Regression\r\n" + "	  @BugALW-11389 @BugALW-10050\r\n"
			+ "	  Scenario: The user can search contacts from the WayMore Contact Insights list by groups")
	public void theUserCanSearchContactsFromTheWayMoreContactInsightsListByGroups() throws Exception {

//		 Given [API] the user № 1 sets authentication token
//		    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//		    And [API] the user № 1 adds a new contact № 2 to the list of contacts
//		    And [API] the user № 1 adds a new group № 3 to the list of groups
//		    And [API] the user № 1 adds the contact № 1 to the group № 3
//		    And [API] the user № 1 adds the contact № 2 to the group № 3
//		    When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//	    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//	    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//	    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//	    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//		    When the user filters contacts by entering the AQA Contact Insight Group value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
						"AQA Contact Insight Group");
//		    Then all filtered results shown in the Groups column contain the AQA Contact Insight Group value that was entered in the Search Contacts input field
		contactInsightsSteps
				.thenAllFilteredResultsShownInTheColumnContainTheValueThatWasEnteredInTheSearchContactsInputField(
						ContactsOptionEnum.Groups, "AQA Contact Insight Group");
//		    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups

	}

	@Test(description = " @WQ-427 @TR-427 @Regression\r\n" + "@BugALW-36531 @BugALW-11389 @BugALW-3875\r\n"
			+ "Scenario: The user can search for some value, change the number of contacts per page and then delete the search term")
	public void theUserCanSearchForSomeValueChangeTheNumberOfContactsPerPageAndThenDeleteTheSearchTerm()
			throws Exception {

//	    Given the user № 2 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(2);
//	    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//	    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//	    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//	    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//	    When the user filters contacts by entering the Pinelopi value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
						"Pinelopi");
//	    Then all filtered results shown in the First Name column contain the Pinelopi value that was entered in the Search Contacts input field
		contactInsightsSteps
				.thenAllFilteredResultsShownInTheColumnContainTheValueThatWasEnteredInTheSearchContactsInputField(
						ContactsOptionEnum.FirstName, "Pinelopi");
//	    And the result of All contacts in the bottom toolbar of the table is correct on the Contact Insights page
		contactInsightsSteps
				.thenTheResultOfAllContactsInTheBottomToolbarOfTheTableIsCorrectOnTheContactInsightsPage("All");
//	    When the user selects an option of 10 items per page from the pagination dropdown on the Contact Insights page
		contactInsightsSteps
				.whenTheUserSelectsAnOptionOfItemsPerPageFromThePaginationDropdownOnTheContactInsightsPage("10");
//	    And the user clicks on the clear button in the Search Contacts input on the Contact Insights page
		contactInsightsSteps.whenTheUserClicksOnTheClearButtonInTheSearchContactsInputOnTheContactInsightsPage();
//	    Then the search contacts input is cleared on the Contact Insights page
		contactInsightsSteps.thenTheSearchContactsInputIsClearedOnTheContactInsightsPage();
//	    And the selected option 10 is displayed in the page dropdown on Contact Insights page
		contactInsightsSteps.thenTheSelectedOptionIsDisplayedInThePageDropdownOnContactInsightsPage(10);
//	    And the result of All contacts in the bottom toolbar of the table is correct on the Contact Insights page
		contactInsightsSteps
				.thenTheResultOfAllContactsInTheBottomToolbarOfTheTableIsCorrectOnTheContactInsightsPage("All");

	}

	@Test(description = "@WQ-428 @TR-428 @Regression\r\n" + "	  @BugALW-36531 @BugALW-11389 @BugALW-10050\r\n"
			+ "	  Scenario: The user can search specific value, change the number of contacts per page to 100")
	public void theUserCanSearchSpecificValueAndChangeTheNumberOfContactsPerPageTo100() throws Exception {

//	    Given [API] the user № 1 sets authentication token
//	    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//	    And [API] the user № 1 adds a new contact № 2 to the list of contacts
//	    And [API] the user № 1 adds a new contact № 3 to the list of contacts
//	    And [API] the user № 1 adds a new group № 3 to the list of groups
//	    And [API] the user № 1 adds the contact № 1 to the group № 3
//	    And [API] the user № 1 adds the contact № 2 to the group № 3
//	    And [API] the user № 1 adds the contact № 3 to the group № 3
//	    Given the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//	    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//	    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//	    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//	    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//	    When the user filters contacts by entering the 99276 value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
						"99276");
//	    Then all filtered results shown in the Mobile Phone column contain the 99276 value that was entered in the Search Contacts input field
		contactInsightsSteps
				.thenAllFilteredResultsShownInTheColumnContainTheValueThatWasEnteredInTheSearchContactsInputField(
						ContactsOptionEnum.Mobile, "99276");
//	    When the user selects an option of 100 items per page from the pagination dropdown on the Contact Insights page
		contactInsightsSteps
				.whenTheUserSelectsAnOptionOfItemsPerPageFromThePaginationDropdownOnTheContactInsightsPage("100");
//	    Then the selected option 100 is displayed in the page dropdown on Contact Insights page
		contactInsightsSteps.thenTheSelectedOptionIsDisplayedInThePageDropdownOnContactInsightsPage(100);
//	    And the result of All contacts in the bottom toolbar of the table is correct on the Contact Insights page
		contactInsightsSteps
				.thenTheResultOfAllContactsInTheBottomToolbarOfTheTableIsCorrectOnTheContactInsightsPage("All");
//	    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups

	}

	@Test(description = " @WQ-429 @TR-429 @Regression\r\n" + "	  @BugALW-11389 @BugALW-10050\r\n"
			+ "	  Scenario: The search contacts filtering is reset and the input is cleared after the user clicks the clear icon")
	public void theSearchContactsFilteringIsResetAndTheInputIsClearedAfterTheUserClicksTheClearIScon()
			throws Exception {

//	    Given [API] the user № 1 sets authentication token
//	    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//	    And [API] the user № 1 adds a new contact № 2 to the list of contacts
//	    And [API] the user № 1 adds a new group № 1 to the list of groups
//	    And [API] the user № 1 adds a new group № 3 to the list of groups
//	    And [API] the user № 1 adds the contact № 1 to the group № 1
//	    And [API] the user № 1 adds the contact № 2 to the group № 3
//	    Given the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//	    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//	    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//	    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//	    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//	    When the user filters contacts by entering the AQA Test Group value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
						"AQA Test Group");
//	    Then all filtered results shown in the Groups column contain the AQA Test Group value that was entered in the Search Contacts input field
//		contactInsightsSteps
//		.thenAllFilteredResultsShownInTheColumnContainTheValueThatWasEnteredInTheSearchContactsInputField(
//				ContactsOptionEnum.Groups, "AQA Test Group");
//	    When the user clicks on the clear button in the Search Contacts input on the Contact Insights page
		contactInsightsSteps.whenTheUserClicksOnTheClearButtonInTheSearchContactsInputOnTheContactInsightsPage();
//	    Then the contacts are reset to default on the Contact Insights page
		contactInsightsSteps.thenTheContactsAreResetToDefaultOnTheContactInsightsPage();
//	    And the search contacts input is cleared on the Contact Insights page
		contactInsightsSteps.thenTheSearchContactsInputIsClearedOnTheContactInsightsPage();
//	    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups

	}

	@Test(description = " @WQ-430 @TR-430 @Regression\r\n" + "	  @BugALW-37181 @BugALW-11389 @BugALW-2612\r\n"
			+ "	  Scenario: The user can partial text search on the Contact Insights page")
	public void theUserCanPartialTextSearchOnTheContactInsightsPage() throws Exception {
//	    Given the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(2);
//    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//	    When the user filters contacts by entering the nikos value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
						"nikos");
//	    Then all filtered results shown contain the partial value nikos that was entered in the Search Contacts input field
		contactInsightsSteps
				.thenAllFilteredResultsShownContainThePartialValueThatWasEnteredInTheSearchContactsInputField("nikos");
	}

	@Test(description = "@WQ-431 @TR-431 @Regression\r\n" + "	  @BugALW-11389 @BugALW-10050\r\n"
			+ "	  Scenario: The user can see a message that there are no results matching the search")
	public void theUserCanSeeAMessageThatThereAreNoResultsMatchingTheSearch() throws Exception {

//	    Given [API] the user № 1 sets authentication token
//	    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//	    And [API] the user № 1 adds a new contact № 2 to the list of contacts
//	    And [API] the user № 1 adds a new group № 3 to the list of groups
//	    And [API] the user № 1 adds the contact № 1 to the group № 3
//	    And [API] the user № 1 adds the contact № 2 to the group № 3
//	    When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(2);
//	    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//	    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//	    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//	    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//	    When the user filters contacts by entering the value value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
						"value");
//	    Then the message that there are no results matching the search is displayed
		contactInsightsSteps.thenTheMessageThatThereAreNoResultsMatchingTheSearchIsDisplayed();
//	    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups
	}

	@Test(description = "	@ALW-13709 @TR-13709 @Regression\r\n"
			+ "	  Scenario: The user can see the full list of contacts after deleting the value from the search input")
	public void theUserCanSeeTheFullListOfContactsAfterDeletingTheValueFromTheSearchInput() throws Exception {

//	    Given [API] the user № 1 sets authentication token
//	    And [API] the user № 1 removes all existing contacts
//	    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//	    And [API] the user № 1 adds a new contact № 2 to the list of contacts
//	    When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//	    When the user filters contacts by entering the First value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
						"First");
//	    Then all filtered results shown in the First Name column contain the First value that was entered in the Search Contacts input field
		contactInsightsSteps
				.thenAllFilteredResultsShownInTheColumnContainTheValueThatWasEnteredInTheSearchContactsInputField(
						ContactsOptionEnum.FirstName, "First");
//	    When the user deletes text from the Search Contacts input on the Contact Insights page
		contactInsightsSteps.whenTheUserDeletesTextFromTheSearchContactsInputOnTheContactInsightsPage();
//	    Then the search contacts input is cleared on the Contact Insights page
		contactInsightsSteps.thenTheSearchContactsInputIsClearedOnTheContactInsightsPage();
//	    And the contacts are reset to default on the Contact Insights page
		contactInsightsSteps.thenTheContactsAreResetToDefaultOnTheContactInsightsPage();

	}

	@Test(description = "@ALW-13772 @TR-13772 @Regression\r\n"
			+ "	  Scenario: The user can start searching contact only after entering 3rd letter")
	public void theUserCanStartSearchingContactOnlyAfterEntering3rdLetter() throws Exception {

//	    Given [API] the user № 1 sets authentication token
//	    And [API] the user № 1 removes all existing contacts
//	    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//	    And [API] the user № 1 adds a new contact № 2 to the list of contacts
//	    When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//	    When the user filters the contacts by adding the F value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersTheContactsByAddingTheValueIntoTheSearchContactsInputOnTheContactInsightsPage("A");
//	    Then the contacts are reset to default on the Contact Insights page
		contactInsightsSteps.thenTheContactsAreResetToDefaultOnTheContactInsightsPage();
//	    When the user filters the contacts by adding the i value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersTheContactsByAddingTheValueIntoTheSearchContactsInputOnTheContactInsightsPage("Q");
//	    Then the contacts are reset to default on the Contact Insights page
		contactInsightsSteps.thenTheContactsAreResetToDefaultOnTheContactInsightsPage();
//	    When the user filters the contacts by adding the r value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
				.whenTheUserFiltersTheContactsByAddingTheValueIntoTheSearchContactsInputOnTheContactInsightsPage("A");
//	    Then all filtered results shown in the First Name column contain the Fir value that was entered in the Search Contacts input field
		contactInsightsSteps
				.thenAllFilteredResultsShownInTheColumnContainTheValueThatWasEnteredInTheSearchContactsInputField(
						ContactsOptionEnum.FirstName, "AQA");

	}

	@Test(description = "@ALW-15102 @TR-15102 @Regression\r\n"
			+ "	  Scenario: The checkbox in the header is checked when the user search and select all contacts")
	public void theCheckboxInTheHeaderIsCheckedWhenTheUserSearchAndSelectAllContacts() throws Exception {

//	    Given [API] the user № 1 sets authentication token
//	    And [API] the user № 1 removes all existing contacts
//	    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//	    And [API] the user № 1 adds a new contact № 2 to the list of contacts
//	    And [API] the user № 1 adds a new contact № 3 to the list of contacts
//	    When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//    Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//	    When the user filters contacts by entering the AQA value into the Search Contacts input on the Contact Insights page
		contactInsightsSteps
		.whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
				"AQA");
//	    Then all filtered results shown in the First Name column contain the AQA value that was entered in the Search Contacts input field
		contactInsightsSteps
		.thenAllFilteredResultsShownInTheColumnContainTheValueThatWasEnteredInTheSearchContactsInputField(
				ContactsOptionEnum.FirstName, "AQA");
//	    When the user checks checkbox in the header of the table on the Contact Insights page
		contactInsightsSteps.whenTheUserChecksCheckboxInTheHeaderOfTheTableOnTheContactInsightsPage();
//	    Then all checkboxes are checked on the Contact Insights page
		contactInsightsSteps.thenAllCheckboxesAreCheckedOnTheContactInsightsPage();
	}

	@Test(description = " @ALW-34563 @TR-34563 @Regression\r\n"
			+ "	  Scenario: The user can search contacts by entering special characters in the input field")
	public void theUserCanSearchContactsByEnteringSpecialCharactersInTheInputField() throws Exception {

//	    Given [API] the user № 1 sets authentication token
//	    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//	    And [API] the user № 1 adds a new contact № 2 to the list of contacts
//	    And [API] the user № 1 adds a new group № 3 to the list of groups
//	    And [API] the user № 1 adds the contact № 1 to the group № 3
//	    And [API] the user № 1 adds the contact № 2 to the group № 3
//	    When the user № 1 is on the Getting started with WayMore page
//	    Then the Side Menu is displayed
//	    When the user clicks on the Contact Insights item
//	    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
//	    Then the CONTACTS title is displayed
//	    When the user filters contacts by entering the @#$ value into the Search Contacts input on the Contact Insights page
//	    Then the message that there are no results matching the search is displayed
//	    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups
	}
}
