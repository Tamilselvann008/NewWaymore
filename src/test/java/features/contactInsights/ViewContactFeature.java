package features.contactInsights;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BasePo;
import enums.uienums.OptionEnum.MenuItemOptionEnum;
import enums.uienums.OptionEnum.PlatformOptionEnum;
import steps.common.CommonButtonsSteps;
import steps.contactInsights.ContactInsightsSteps;
import steps.login.LoginSteps;
import steps.sideMenu.SideMenuSteps;

public class ViewContactFeature extends BasePo {

	private LoginSteps loginSteps = new LoginSteps();
	private SideMenuSteps sidemenuSteps = new SideMenuSteps(); // Assuming a DashboardPage class for navigation
	private ContactInsightsSteps contactInsightsPage = new ContactInsightsSteps();
	private CommonButtonsSteps CommonButtonsSteps = new CommonButtonsSteps();

	@BeforeTest
	public void launchWebsite() {
		browserLaunch();
	}

//	@AfterTest
//	public void tearDown() {
//		closeBrowser();
//	}

	@Test(description = "@WQ-408 @TR-408 @Regression\r\n" + "  @BugALW-11389 @BugALW-10050")
	public void theUserCanSelectAllContactsOnThePageByClickingOnTheCheckboxInTheHeader() throws Exception {

//	When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				MenuItemOptionEnum.ContactInsights.getValue(), MenuItemOptionEnum.ContactInsights.getValue());
		;
//    Then the CONTACTS title is displayed
		contactInsightsPage.thenTheContactsTitleIsDisplayed("CONTACTS");
//    When the user checks checkbox in the header of the table on the Contact Insights page
		contactInsightsPage.whenTheUserChecksCheckboxInTheHeaderOfTheTableOnTheContactInsightsPage();
//    Then all checkboxes are checked on the Contact Insights page
		contactInsightsPage.thenAllCheckboxesAreCheckedOnTheContactInsightsPage();
//    And the counter in the header displays the correct number of Selected rows in the table on the Contact Insights page
		contactInsightsPage
				.thenTheCounterInTheHeaderDisplaysTheCorrectNumberOfSelectedFilteredRowsInTheTableOnTheContactInsightsPage(
						"Selected ");
//    And the message that all results are selected is displayed on the Contact Insights page
		contactInsightsPage.thenTheMessageThatAllResultsAreSelectedIsDisplayedOnTheContactInsightsPage();
//    When the user checks checkbox in the header of the table on the Contact Insights page
		contactInsightsPage.whenTheUserChecksCheckboxInTheHeaderOfTheTableOnTheContactInsightsPage();
//    Then all checkboxes are unchecked on the Contact Insights page
		contactInsightsPage.thenAllCheckboxesAreUncheckedOnTheContactInsightsPage();
//    And the Selected counter in the toolbar is not displayed without selecting rows in the table on the Contact Insights page
		contactInsightsPage
				.thenTheSelectedCounterInTheToolbarIsNotDisplayedWithoutSelectingRowsInTheTableOnTheContactInsightsPage(
						"Selected ");
//    And the message that all results are selected is not displayed on the Contact Insights page
		contactInsightsPage.thenTheMessageThatAllResultsAreSelectedIsNotDisplayedOnTheContactInsightsPage();
	}

	@Test(description = "@WQ-409 @TR-409 @Regression\r\n" + "  @BugALW-11389 @BugALW-10050")
	public void TheUserCanSelectASpecificContactInTheContactInsightsPage() throws Exception {
//	When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				MenuItemOptionEnum.ContactInsights.getValue(), MenuItemOptionEnum.ContactInsights.getValue());
//    Then the CONTACTS title is displayed
		contactInsightsPage.thenTheContactsTitleIsDisplayed("CONTACTS");
//    	    When the user checks checkbox of the Waymore contact № 2 in the table on the Contact Insights page
		contactInsightsPage.whenTheUserChecksCheckboxOfTheWaymoreRouteeContactInTheTableOnTheContactInsightsPage(
				PlatformOptionEnum.Waymore, 1);
//    	    Then the checkbox for the Waymore contact № 2 is checked on the Contact Insights page
		contactInsightsPage.thenTheCheckboxForTheWaymoreRouteeContactIsCheckedOnTheContactInsightsPage(
				PlatformOptionEnum.Waymore, 1);
//    	    And the counter in the header displays the correct number of Selected rows in the table on the Contact Insights page
		contactInsightsPage
				.thenTheCounterInTheHeaderDisplaysTheCorrectNumberOfSelectedFilteredRowsInTheTableOnTheContactInsightsPage(
						"Selected");
//    	    When the user checks checkbox of the Waymore contact № 2 in the table on the Contact Insights page
		contactInsightsPage.whenTheUserChecksCheckboxOfTheWaymoreRouteeContactInTheTableOnTheContactInsightsPage(
				PlatformOptionEnum.Waymore, 1);
//    	    Then the checkbox for the Waymore contact № 2 is unchecked on the Contact Insights page
		contactInsightsPage.thenTheCheckboxForTheWaymoreRouteeContactIsUncheckedOnTheContactInsightsPage(
				PlatformOptionEnum.Waymore, 1);
//    	    And the Selected counter in the toolbar is not displayed without selecting rows in the table on the Contact Insights page
		contactInsightsPage
				.thenTheSelectedCounterInTheToolbarIsNotDisplayedWithoutSelectingRowsInTheTableOnTheContactInsightsPage(
						"Selected");
	}

	@Test(description = " @WQ-416 @TR-416 @Regression\r\n" + "  @BugALW-11389 @BugALW-10050")
	public void theUserCanSelectAllContactsByClickingOnTheCheckboxInTheHeaderAndUncheckASpecificContactFromTheTable()
			throws Exception {

//		When the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//	    Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//	    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//	    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				MenuItemOptionEnum.ContactInsights.getValue(), MenuItemOptionEnum.ContactInsights.getValue());
		;
//	    Then the CONTACTS title is displayed
		contactInsightsPage.thenTheContactsTitleIsDisplayed("CONTACTS");
//	    When the user checks checkbox in the header of the table on the Contact Insights page
		contactInsightsPage.whenTheUserChecksCheckboxInTheHeaderOfTheTableOnTheContactInsightsPage();
//		    Then all checkboxes are checked on the Contact Insights page
		contactInsightsPage.thenAllCheckboxesAreCheckedOnTheContactInsightsPage();
//		    And the counter in the header displays the correct number of Selected rows in the table on the Contact Insights page
		contactInsightsPage
				.thenTheCounterInTheHeaderDisplaysTheCorrectNumberOfSelectedFilteredRowsInTheTableOnTheContactInsightsPage(
						"Selected");
//	    And the message that all results are selected is displayed on the Contact Insights page
		contactInsightsPage.thenTheMessageThatAllResultsAreSelectedIsDisplayedOnTheContactInsightsPage();
//		    When the user checks checkbox of the Waymore contact № 2 in the table on the Contact Insights page
		contactInsightsPage.whenTheUserChecksCheckboxOfTheWaymoreRouteeContactInTheTableOnTheContactInsightsPage(
				PlatformOptionEnum.Waymore, 2);
//		    Then the checkbox for the Waymore contact № 2 is unchecked on the Contact Insights page
		contactInsightsPage.thenTheCheckboxForTheWaymoreRouteeContactIsUncheckedOnTheContactInsightsPage(
				PlatformOptionEnum.Waymore, 2);
//		    And the checkbox in the header of the table is unchecked on the Contact Insights page
		contactInsightsPage.thenTheCheckboxInTheHeaderOfTheTableIsUncheckedOnTheContactInsightsPage();

//		    And the counter in the header displays the correct number of Selected rows in the table on the Contact Insights page
		contactInsightsPage
				.thenTheCounterInTheHeaderDisplaysTheCorrectNumberOfSelectedFilteredRowsInTheTableOnTheContactInsightsPage(
						"Selected");
//		    And the message that all results are selected is not displayed on the Contact Insights page
		contactInsightsPage.thenTheMessageThatAllResultsAreSelectedIsNotDisplayedOnTheContactInsightsPage();

	}

	@Test(description = "@WQ-417 @TR-417 @Regression\r\n" + "  @BugALW-35800 @BugALW-11389 @BugALW-3735 @BugALW-2612")
	public void theUserCanSelectAllContactsByClickingOnTheCheckboxInTheHeaderGoToTheNextPageAndReturnToThePreviousPage()
			throws Exception {

//		Given the user № 2 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(2);
//	     Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//	    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//	    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				MenuItemOptionEnum.ContactInsights.getValue(), MenuItemOptionEnum.ContactInsights.getValue());
//	    Then the CONTACTS title is displayed
		contactInsightsPage.thenTheContactsTitleIsDisplayed("CONTACTS");
//	    When the user selects an option of 10 items per page from the pagination dropdown on the Contact Insights page
		contactInsightsPage
				.whenTheUserSelectsAnOptionOfItemsPerPageFromThePaginationDropdownOnTheContactInsightsPage("10");
//	    And the user checks checkbox in the header of the table on the Contact Insights page
		contactInsightsPage.whenTheUserChecksCheckboxInTheHeaderOfTheTableOnTheContactInsightsPage();
//	    Then all checkboxes are checked on the Contact Insights page
		contactInsightsPage.thenAllCheckboxesAreCheckedOnTheContactInsightsPage();
//	    And the counter in the header displays the correct number of Selected rows in the table on the Contact Insights page
		contactInsightsPage
				.thenTheCounterInTheHeaderDisplaysTheCorrectNumberOfSelectedFilteredRowsInTheTableOnTheContactInsightsPage(
						"Selected");
//	    And the message that all results are selected is displayed on the Contact Insights page
		contactInsightsPage.thenTheMessageThatAllResultsAreSelectedIsDisplayedOnTheContactInsightsPage();
//	    When the user clicks Next page button on the Contact Insights page
		CommonButtonsSteps.whenTheUserClicksPreviousOrNextPageButton("Next page");
//	    Then the Previous page button is active on the Contact Insights page
		CommonButtonsSteps.thenThePreviousOrNextPageButtonIsActiveInactive("Previous page", "active");
//	    And all checkboxes are unchecked on the Contact Insights page
		contactInsightsPage.thenAllCheckboxesAreUncheckedOnTheContactInsightsPage();
//	    And the counter in the header displays the correct number of Selected rows in the table on the Contact Insights page
		contactInsightsPage
				.thenTheCounterInTheHeaderDisplaysTheCorrectNumberOfSelectedFilteredRowsInTheTableOnTheContactInsightsPage(
						"Selected");
//	    And the message that all results are selected is not displayed on the Contact Insights page
		contactInsightsPage.thenTheMessageThatAllResultsAreSelectedIsNotDisplayedOnTheContactInsightsPage();
//	    When the user clicks Previous page button on the Contact Insights page
		CommonButtonsSteps.whenTheUserClicksPreviousOrNextPageButton("Previous page");
//	    Then the Next page button is active on the Contact Insights page
		CommonButtonsSteps.thenThePreviousOrNextPageButtonIsActiveInactive("Next page", "active");
//	    And all checkboxes are checked on the Contact Insights page
		contactInsightsPage.thenAllCheckboxesAreCheckedOnTheContactInsightsPage();
//	    And the counter in the header displays the correct number of Selected rows in the table on the Contact Insights page
		contactInsightsPage
				.thenTheCounterInTheHeaderDisplaysTheCorrectNumberOfSelectedFilteredRowsInTheTableOnTheContactInsightsPage(
						"Selected");
//	    And the message that all results are selected is displayed on the Contact Insights page
		contactInsightsPage.thenTheMessageThatAllResultsAreSelectedIsDisplayedOnTheContactInsightsPage();
	}

	@Test(description = " @WQ-468 @TR-468 @Regression\r\n" + "  @BugALW-11389")
	public void theUserCanChangeTheNumberOfContactsPerPageTo10() throws Exception {

//		 Given the user № 2 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(2);
//	     Then the Side Menu is displayed
		sidemenuSteps.thenTheSideMenuIsDisplayed();
//	    When the user clicks on the Contact Insights item
		sidemenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//	    And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				MenuItemOptionEnum.ContactInsights.getValue(), MenuItemOptionEnum.ContactInsights.getValue());
//	    Then the CONTACTS title is displayed
		contactInsightsPage.thenTheContactsTitleIsDisplayed("CONTACTS");
//		    When the user selects an option of 10 items per page from the pagination dropdown on the Contact Insights page
		contactInsightsPage
				.whenTheUserSelectsAnOptionOfItemsPerPageFromThePaginationDropdownOnTheContactInsightsPage("10");
//		    Then the selected option 10 is displayed in the page dropdown on Contact Insights page
		contactInsightsPage.thenTheSelectedOptionIsDisplayedInThePageDropdownOnContactInsightsPage(10);
//		    And the result of All contacts in the bottom toolbar of the table is correct on the Contact Insights page
		contactInsightsPage.thenTheResultOfAllContactsInTheBottomToolbarOfTheTableIsCorrectOnTheContactInsightsPage();
	}
}
