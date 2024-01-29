package features.contactInsights;

import java.util.Collections;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testcase.WaymorePageLogin;

import basePackage.BasePo;
import steps.contactInsights.ContactInsightsSteps;
import steps.contactInsights.FilterContactsDialogSteps;
import steps.sideMenu.SideMenuSteps;

public class FilterContactFeature extends BasePo {

	private WaymorePageLogin waymorePageLogin = new WaymorePageLogin();
	//private LoginSteps loginPage= new LoginSteps(); // Assuming a LoginPage class for login functionality
    private SideMenuSteps sidemenuSteps = new SideMenuSteps(); // Assuming a DashboardPage class for navigation
    private ContactInsightsSteps contactInsightsPage = new ContactInsightsSteps(); // Assuming a ContactInsightsPage for Contact Insights specific actions
   private FilterContactsDialogSteps filterContactsDialogSteps = new FilterContactsDialogSteps();
		   
    
   @BeforeTest
	public void launchWebsite() {
		browserLaunch();
	}
	@AfterTest
	public void tearDown() {
		closeBrowser();
	}

    @Test(description ="@ALW-35808 @TR-35808 @Regression\r\n"
    		+ "  Scenario: The user can see Filter option on the Contact Insights page" )
//    @DisplayName("ALW-35808, TR-35808: The user can see Filter option on the Contact Insights page")
   // @Tag("Regression")
    public void testUserCanSeeFilterOptionOnContactInsightsPage() throws Exception {
        // Given the user № 1 is on the Getting started with WayMore page
    	waymorePageLogin.theUserIsOnTheGettingStartedWithWayMorePage(1); // Assuming a method to log in a user by number
        // Then the Side Menu is displayed
        sidemenuSteps.thenTheSideMenuIsDisplayed();
        // When the user clicks on the Contact Insights item
        sidemenuSteps.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem("ContactInsights");
        // And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
        sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption("Contact Insights", "Contact Insights");;
        // Then the CONTACTS title is displayed
        contactInsightsPage.thenTheContactsTitleIsDisplayed("CONTACTS");
        // And the Filter button is displayed on the Contact table toolbar
        contactInsightsPage.thenTheFilterButtonIsDisplayedOnTheContactTableToolbar();
    } 
    
    
    @Test(description ="@ALW-35809 @TR-35809 @Regression\r\n"
    		+ "  Scenario: The user can see the Contact Filter dialog by clicking the Filter button" )
    public void TheUserCanSeeTheContactFilterDialogByClickingTheFilterButton() throws Exception {
//      Given the user № 1 is on the Getting started with WayMore page
    	waymorePageLogin.theUserIsOnTheGettingStartedWithWayMorePage(1);
//      Then the Side Menu is displayed
    	 sidemenuSteps.thenTheSideMenuIsDisplayed();
//      When the user clicks on the Contact Insights item
         sidemenuSteps.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem("ContactInsights");
//      And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
         sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption("Contact Insights", "Contact Insights");;
//      Then the CONTACTS title is displayed
         contactInsightsPage.thenTheContactsTitleIsDisplayed("CONTACTS");
//      When the user clicks on the Filter button on the Contact Insights page
         contactInsightsPage.whenTheUserClicksOnTheFilterButtonOnTheContactInsightsPage();
//      Then the Filter Contacts dialog is displayed
         filterContactsDialogSteps.thenTheFilterContactsDialogIsDisplayed();
    }
    @Test(description = "@ALW-35810 @TR-35810 @Regression\r\n"
    		+ "  Scenario: The user can close Filter Contacts dialogue by clicking outside the dialog")
    public void theUserCanCloseFilterContactsDialogueByClickingOutsideTheDialog() throws Exception
    {
//    Given the user № 1 is on the Getting started with WayMore page
    	waymorePageLogin.theUserIsOnTheGettingStartedWithWayMorePage(1);
//      Then the Side Menu is displayed
    	 sidemenuSteps.thenTheSideMenuIsDisplayed();
//      When the user clicks on the Contact Insights item
         sidemenuSteps.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem("ContactInsights");
//      And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
         sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption("Contact Insights", "Contact Insights");;
//      Then the CONTACTS title is displayed
         contactInsightsPage.thenTheContactsTitleIsDisplayed("CONTACTS");
//      When the user clicks on the Filter button on the Contact Insights page
         contactInsightsPage.whenTheUserClicksOnTheFilterButtonOnTheContactInsightsPage();
//      Then the Filter Contacts dialog is displayed
         filterContactsDialogSteps.thenTheFilterContactsDialogIsDisplayed();
//    When the user clicks on a background outside of the Filter dialog
         filterContactsDialogSteps.whenTheUserClicksOnABackgroundOutsideOfTheFilterDialog();
//    Then the Filter Contacts dialog is not displayed
         filterContactsDialogSteps.thenTheFilterContactsDialogIsNotDisplayed();
    }
    
    @Test(description = "@ALW-35811 @TR-35811 @Regression\r\n"
    		+ "  Scenario: The user can close Filter Contacts dialogue by clicking the Close button")
    public void theUserCanCloseFilterContactsDialogueByClickingTheCloseButton() throws Exception {
//      Given the user № 1 is on the Getting started with WayMore page
      	waymorePageLogin.theUserIsOnTheGettingStartedWithWayMorePage(1);
//        Then the Side Menu is displayed
      	 sidemenuSteps.thenTheSideMenuIsDisplayed();
//        When the user clicks on the Contact Insights item
           sidemenuSteps.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem("ContactInsights");
//        And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
           sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption("Contact Insights", "Contact Insights");;
//        Then the CONTACTS title is displayed
           contactInsightsPage.thenTheContactsTitleIsDisplayed("CONTACTS");
//        When the user clicks on the Filter button on the Contact Insights page
           contactInsightsPage.whenTheUserClicksOnTheFilterButtonOnTheContactInsightsPage();
//        Then the Filter Contacts dialog is displayed
           filterContactsDialogSteps.thenTheFilterContactsDialogIsDisplayed();
//        When the user clicks on the Close button in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheCloseButtonInTheFilterDialog();
//        Then the Filter Contacts dialog is not displayed
           filterContactsDialogSteps.thenTheFilterContactsDialogIsNotDisplayed();
    }
    
    @Test(description = "@ALW-35812 @TR-35812 @Regression\r\n"
    		+ "  Scenario: The user can filter contacts by First Name based on a specific condition")
    public void theUserCanFilterContactsByFirstNameBasedOnASpecificCondition() throws Exception {
    	
    	
//    	Given [API] the user № 1 sets authentication token
//        And [API] the user № 1 adds a new contact № 1 to the list of contacts
//        And [API] the user № 1 adds a new contact № 2 to the list of contacts
//      Given the user № 1 is on the Getting started with WayMore page
      	waymorePageLogin.theUserIsOnTheGettingStartedWithWayMorePage(1);
//        Then the Side Menu is displayed
      	 sidemenuSteps.thenTheSideMenuIsDisplayed();
//        When the user clicks on the Contact Insights item
           sidemenuSteps.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem("ContactInsights");
//        And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
           sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption("Contact Insights", "Contact Insights");;
//        Then the CONTACTS title is displayed
           contactInsightsPage.thenTheContactsTitleIsDisplayed("CONTACTS");
//        When the user clicks on the Filter button on the Contact Insights page
           contactInsightsPage.whenTheUserClicksOnTheFilterButtonOnTheContactInsightsPage();
//        Then the Filter Contacts dialog is displayed
           filterContactsDialogSteps.thenTheFilterContactsDialogIsDisplayed();
//        When the user clicks on the First Name dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailGroupCountryMobileChannelPreferencesSegmentDropdownInTheFilterDialog("First Name");
//        And the user checks the checkbox in the AQAFirstName option in the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserChecksUnchecksTheCheckboxInTheOptionInTheExpandedDropdownInTheFilterDialog("checks", "AQAFirstName");
//        Then the AQAFirstName option is selected in the dropdown options list in the Filter dialog
           filterContactsDialogSteps.thenTheOptionIsSelectedInTheDropdownOptionsListInTheFilterDialog("AQAFirstName");
//        When the user clicks on the Search button in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheSearchButtonInTheFilterDialog();
//        Then the Filter Contacts dialog is not displayed
           filterContactsDialogSteps.thenTheFilterContactsDialogIsNotDisplayed();
//        And the firstName - AQAFirstName filter tag is displayed on the Contact Insights page Collections.singletonList
           contactInsightsPage.thenTheFilterTagIsDisplayedOnTheContactInsightsPage("firstName - AQAFirstName");
//        And the Filter close icon is displayed on the Contact table toolbar
           contactInsightsPage.thenTheFilterCloseIconIsDisplayedOnTheContactTableToolbar();
//        And all filtered results shown in the First Name column match the AQAFirstName filter criteria selected in the Filter Contacts dialog
           contactInsightsPage.thenAllFilteredResultsShownInTheColumnMatchTheFilterCriteriaSelectedInTheFilterContactsDialog("First Name", "AQAFirstName");
    }
    
    @Test(description = "@ALW-35813 @TR-35813 @Regression\r\n"
    		+ "  Scenario: The user can delete filtering conditions in the Filter Contacts dialog")
    public void theUserCanDeleteFilteringConditionsInTheFilterContactsDialog() throws Exception {
    	
    	
//    	 Given [API] the user № 1 sets authentication token
//    	    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//      Given the user № 1 is on the Getting started with WayMore page
      	waymorePageLogin.theUserIsOnTheGettingStartedWithWayMorePage(1);
//        Then the Side Menu is displayed
      	 sidemenuSteps.thenTheSideMenuIsDisplayed();
//        When the user clicks on the Contact Insights item
           sidemenuSteps.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem("ContactInsights");
//        And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
           sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption("Contact Insights", "Contact Insights");;
//        Then the CONTACTS title is displayed
           contactInsightsPage.thenTheContactsTitleIsDisplayed("CONTACTS");
//        When the user clicks on the Filter button on the Contact Insights page
           contactInsightsPage.whenTheUserClicksOnTheFilterButtonOnTheContactInsightsPage();
//        Then the Filter Contacts dialog is displayed
           filterContactsDialogSteps.thenTheFilterContactsDialogIsDisplayed();
//        When the user clicks on the First Name dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailGroupCountryMobileChannelPreferencesSegmentDropdownInTheFilterDialog("First Name");
//        And the user checks the checkbox in the AQAFirstName option in the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserChecksUnchecksTheCheckboxInTheOptionInTheExpandedDropdownInTheFilterDialog("checks", "AQAFirstName");
//        Then the AQAFirstName option is selected in the dropdown options list in the Filter dialog
           filterContactsDialogSteps.thenTheOptionIsSelectedInTheDropdownOptionsListInTheFilterDialog("AQAFirstName");
//    	    And the AQAFirstName option appears selected in the First Name filter in the Filter dialog
           filterContactsDialogSteps.thenTheOptionAppearsSelectedInTheFirstNameLastNameEmailGroupCountryMobileSegmentChannelPreferencesFilterInTheFilterDialog("AQAFirstName", "First Name");
//    	    And the Search   button is enabled in the Filter dialog
           filterContactsDialogSteps.thenTheSearchButtonIsDisabledEnabledInTheFilterDialog("enabled");
//    	    When the user clicks on the Close icon in the selected AQAFirstName option in the First Name filter in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheCloseIconInTheSelectedOptionInTheFirstNameFilterInTheFilterDialog("AQAFirstName", "First Name");
//    	    Then the AQAFirstName option is not selected in the dropdown options list in the Filter dialog
           filterContactsDialogSteps.thenTheOptionIsNotSelectedInTheDropdownOptionsListInTheFilterDialog("AQAFirstName");
//    	    And the AQAFirstName option does not appear as selected in the First Name filter in the Filter dialog
           filterContactsDialogSteps.thenTheOptionDoesNotAppearAsSelectedInTheFirstNameGroupFilterInTheFilterDialog("AQAFirstName", "First Name");
//    	    And the Search button is disabled in the Filter dialog
           filterContactsDialogSteps.thenTheSearchButtonIsDisabledEnabledInTheFilterDialog("diabled");
//    	    When the user clicks on the Close button in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheCloseButtonInTheFilterDialog();
//    	    Then the Filter Contacts dialog is not displayed
           filterContactsDialogSteps.thenTheFilterContactsDialogIsNotDisplayed();
//    	    And the filter tag is not displayed on the Contact Insights page
           contactInsightsPage.thenTheFilterSortTagIsNotDisplayedOnTheContactInsightsPage("filter");
//    	    And the Filter close icon is not displayed on the Contact table toolbar
           contactInsightsPage.thenTheFilterCloseIconIsNotDisplayedOnTheContactTableToolbar();
    }
    
    @Test(description = "@ALW-35814 @TR-35814 @Regression\r\n"
    		+ "  Scenario: The user can select all filter conditions in the Filter Contacts dialog")
    public void theUserCanSelectAllFilterConditionsInTheFilterContactsDialog() throws Exception {
//    	 Given [API] the user № 1 sets authentication token
//    	    And [API] the user № 1 adds a new contact № 1 to the list of contacts
//    	    And [API] the user № 1 adds a new group № 1 to the list of groups
//    	    And [API] the user № 1 adds a new segment № 1 to the list of segments
//      Given the user № 1 is on the Getting started with WayMore page
      	waymorePageLogin.theUserIsOnTheGettingStartedWithWayMorePage(1);
//        Then the Side Menu is displayed
      	 sidemenuSteps.thenTheSideMenuIsDisplayed();
//        When the user clicks on the Contact Insights item
           sidemenuSteps.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem("ContactInsights");
//        And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
           sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption("Contact Insights", "Contact Insights");;
//        Then the CONTACTS title is displayed
           contactInsightsPage.thenTheContactsTitleIsDisplayed("CONTACTS");
//        When the user clicks on the Filter button on the Contact Insights page
           contactInsightsPage.whenTheUserClicksOnTheFilterButtonOnTheContactInsightsPage();
//        Then the Filter Contacts dialog is displayed
           filterContactsDialogSteps.thenTheFilterContactsDialogIsDisplayed();
//        When the user clicks on the First Name dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailGroupCountryMobileChannelPreferencesSegmentDropdownInTheFilterDialog("First Name");
//        And the user checks the checkbox in the AQAFirstName option in the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserChecksUnchecksTheCheckboxInTheOptionInTheExpandedDropdownInTheFilterDialog("checks", "AQAFirstName");
//    	  And the user collapses the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserCollapsesTheExpandedDropdownInTheFilterDialog();
//    	    And the user clicks on the Last Name dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailGroupCountryMobileChannelPreferencesSegmentDropdownInTheFilterDialog("Last Name");
//    	    And the user checks the checkbox in the AQALastName option in the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserChecksUnchecksTheCheckboxInTheOptionInTheExpandedDropdownInTheFilterDialog("checks", "AQALastName");
//    	    And the user collapses the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserCollapsesTheExpandedDropdownInTheFilterDialog();
//    	    And the user clicks on the Country dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailGroupCountryMobileChannelPreferencesSegmentDropdownInTheFilterDialog("Country");
//    	    And the user checks the checkbox in the jor option in the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserChecksUnchecksTheCheckboxInTheOptionInTheExpandedDropdownInTheFilterDialog("checks", "jor");
//    	    And the user collapses the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserCollapsesTheExpandedDropdownInTheFilterDialog();
//    	    And the user clicks on the Mobile dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailGroupCountryMobileChannelPreferencesSegmentDropdownInTheFilterDialog("Mobile");
//    	    And the user checks the checkbox in the 962796699276 option in the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserChecksUnchecksTheCheckboxInTheOptionInTheExpandedDropdownInTheFilterDialog("checks", "962796699276");
//    	    And the user collapses the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserCollapsesTheExpandedDropdownInTheFilterDialog();
//    	    And the user clicks on the Email dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailGroupCountryMobileChannelPreferencesSegmentDropdownInTheFilterDialog("Email");
//    	    And the user checks the checkbox in the bribri880@email-temp.com option in the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserChecksUnchecksTheCheckboxInTheOptionInTheExpandedDropdownInTheFilterDialog("checks", "bribri880@email-temp.com");
//    	    And the user collapses the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserCollapsesTheExpandedDropdownInTheFilterDialog();
//    	    And the user clicks on the Group dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailGroupCountryMobileChannelPreferencesSegmentDropdownInTheFilterDialog("Group");
//    	    And the user checks the checkbox in the AQA Test Group option in the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserChecksUnchecksTheCheckboxInTheOptionInTheExpandedDropdownInTheFilterDialog("checks", "AQA Test Group");
//    	    And the user collapses the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserCollapsesTheExpandedDropdownInTheFilterDialog();
//    	    And the user clicks on the Segment dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailGroupCountryMobileChannelPreferencesSegmentDropdownInTheFilterDialog("Segment");
//    	    And the user checks the checkbox in the AQA Testing Segment option in the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserChecksUnchecksTheCheckboxInTheOptionInTheExpandedDropdownInTheFilterDialog("checks", "AQA Testing Segment");
//    	    And the user collapses the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserCollapsesTheExpandedDropdownInTheFilterDialog();
//    	    And the user clicks on the Channel dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailGroupCountryMobileChannelPreferencesSegmentDropdownInTheFilterDialog("Channel");
//    	    And the user checks the checkbox in the SMS option in the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserChecksUnchecksTheCheckboxInTheOptionInTheExpandedDropdownInTheFilterDialog("checks", "SMS");
//    	    And the user collapses the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserCollapsesTheExpandedDropdownInTheFilterDialog();
//    	    And the user clicks on the Preferences dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserClicksOnTheFirstNameLastNameEmailGroupCountryMobileChannelPreferencesSegmentDropdownInTheFilterDialog("Preferences");
//    	    And the user checks the checkbox in the whitelisted option in the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserChecksUnchecksTheCheckboxInTheOptionInTheExpandedDropdownInTheFilterDialog("checks", "whitelisted");
//    	    And the user collapses the expanded dropdown in the Filter dialog
           filterContactsDialogSteps.whenTheUserCollapsesTheExpandedDropdownInTheFilterDialog();
//    	    Then the AQAFirstName option appears selected in the First Name filter in the Filter dialog
           filterContactsDialogSteps.thenTheOptionAppearsSelectedInTheFirstNameLastNameEmailGroupCountryMobileSegmentChannelPreferencesFilterInTheFilterDialog("AQAFirstName", "First Name");
//    	    And the AQALastName option appears selected in the Last Name filter in the Filter dialog
           filterContactsDialogSteps.thenTheOptionAppearsSelectedInTheFirstNameLastNameEmailGroupCountryMobileSegmentChannelPreferencesFilterInTheFilterDialog("AQALastName", "Last Name");
//    	    And the jor option appears selected in the Country filter in the Filter dialog
           filterContactsDialogSteps.thenTheOptionAppearsSelectedInTheFirstNameLastNameEmailGroupCountryMobileSegmentChannelPreferencesFilterInTheFilterDialog("jor", "Country");
//    	    And the 962796699276 option appears selected in the Mobile filter in the Filter dialog
           filterContactsDialogSteps.thenTheOptionAppearsSelectedInTheFirstNameLastNameEmailGroupCountryMobileSegmentChannelPreferencesFilterInTheFilterDialog("962796699276", "Mobile");
//    	    And the bribri880@email-temp.com option appears selected in the Email filter in the Filter dialog
           filterContactsDialogSteps.thenTheOptionAppearsSelectedInTheFirstNameLastNameEmailGroupCountryMobileSegmentChannelPreferencesFilterInTheFilterDialog("bribri880@email-temp.com", "Email");
//    	    And the AQA Test Group option appears selected in the Group filter in the Filter dialog
           filterContactsDialogSteps.thenTheOptionAppearsSelectedInTheFirstNameLastNameEmailGroupCountryMobileSegmentChannelPreferencesFilterInTheFilterDialog("AQA Test Group", "Group");
//    	    And the AQA Testing Segment option appears selected in the Segment filter in the Filter dialog
           filterContactsDialogSteps.thenTheOptionAppearsSelectedInTheFirstNameLastNameEmailGroupCountryMobileSegmentChannelPreferencesFilterInTheFilterDialog("AQA Testing Segment", "Segment");
//    	    And the SMS option appears selected in the Channel filter in the Filter dialog
           filterContactsDialogSteps.thenTheOptionAppearsSelectedInTheFirstNameLastNameEmailGroupCountryMobileSegmentChannelPreferencesFilterInTheFilterDialog("SMS", "Channel");
//    	    And the whitelisted option appears selected in the Preferences filter in the Filter dialog
           filterContactsDialogSteps.thenTheOptionAppearsSelectedInTheFirstNameLastNameEmailGroupCountryMobileSegmentChannelPreferencesFilterInTheFilterDialog("whitelisted", "Preferences");

    }
    
    @Test(description = "@ALW-36728 @TR-36728 @Regression\r\n"
    		+ "    Scenario: The user can see a placeholder for each filter dropdown in the Filter Contacts dialog")
    public void theUserCanSeeAPlaceholderForEachFilterDropdownInTheFilterContactsDialog() throws Exception {
    
//      Given the user № 1 is on the Getting started with WayMore page
      	waymorePageLogin.theUserIsOnTheGettingStartedWithWayMorePage(1);
//        Then the Side Menu is displayed
      	 sidemenuSteps.thenTheSideMenuIsDisplayed();
//        When the user clicks on the Contact Insights item
           sidemenuSteps.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem("ContactInsights");
//        And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
           sidemenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption("Contact Insights", "Contact Insights");;
//        Then the CONTACTS title is displayed
           contactInsightsPage.thenTheContactsTitleIsDisplayed("CONTACTS");
//        When the user clicks on the Filter button on the Contact Insights page
           contactInsightsPage.whenTheUserClicksOnTheFilterButtonOnTheContactInsightsPage();
//        Then the Filter Contacts dialog is displayed
           filterContactsDialogSteps.thenTheFilterContactsDialogIsDisplayed();
//      And the placeholder for each filter dropdown is displayed in the Filter dialog
           filterContactsDialogSteps.thenThePlaceholderForEachFilterDropdownIsDisplayedInTheFilterDialog();
    }

    
    
    
}