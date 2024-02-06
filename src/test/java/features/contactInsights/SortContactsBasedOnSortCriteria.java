package features.contactInsights;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BasePo;
import enums.uienums.OptionEnum.MenuItemOptionEnum;
import steps.contactInsights.ContactInsightsSteps;
import steps.contactInsights.CreateContactDialogSteps;
import steps.login.LoginSteps;
import steps.sideMenu.SideMenuSteps;


//Feature: Sort Contacts Based On Sort Criteria
//
//USER STORY - As a Waymore user, I should be able to Sort AND view the contacts under Contact Insight based on the sort criteria
//GIVEN the user is on the Getting started with WayMore page
//THEN the Side Menu is displayed
//WHEN the user clicks on the Contact Insights item
//THEN the CONTACTS title is displayed
//WHEN the user select a Sort Option AND enter the Sort criteria
//THEN the user will be able to view the Sorted value in the list view


public class SortContactsBasedOnSortCriteria extends BasePo {
	private LoginSteps loginSteps = new LoginSteps();
	private SideMenuSteps sideMenuSteps = new SideMenuSteps();
	private ContactInsightsSteps contactInsightsSteps = new ContactInsightsSteps();

	@BeforeTest
	public void launchWebsite() {
		browserLaunch();
	}

	@AfterTest
	public void tearDown() {
		closeBrowser();
	}

	@Test(description = "@ALW-12582 @TR-12582 @Regression\r\n"
			+ "		  Scenario: The user can see all Condition Variable dropdown menu options corresponding to all columns from the table")
	public void theUserCanAddANewContact() throws Exception {
		  
//		    Given the user № 1 is on the Getting started with WayMore page
		loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
//      Then the Side Menu is displayed
		sideMenuSteps.thenTheSideMenuIsDisplayed();
//      When the user clicks on the Contact Insights item
		sideMenuSteps
				.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(
						MenuItemOptionEnum.ContactInsights);
//      And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
		sideMenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(
				"Contact Insights", "Contact Insights");
//     Then the CONTACTS title is displayed
		contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//		    When the user clicks on the Sort button on the Contact Insights page
		
//		    Then the Sort Contacts dialog is displayed
//		    When the user clicks on the Condition Variable dropdown menu in the Sort Contacts dialog
//		    Then the Condition Variable dropdown menu has options corresponding to all columns from the table
	}
	

}
