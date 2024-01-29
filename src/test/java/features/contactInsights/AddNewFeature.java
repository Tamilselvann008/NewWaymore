package features.contactInsights;

import org.testng.annotations.Test;

import basePackage.BasePo;
import steps.contactInsights.ContactInsightsSteps;
import steps.contactInsights.CreateContactDialogSteps;
import steps.login.LoginSteps;
import steps.sideMenu.SideMenuSteps;

public class AddNewFeature extends BasePo{
	private static final String createContact = "Create contact";
	private static final String editContact  = "Edit contact";
	
	
	private LoginSteps loginSteps = new LoginSteps();
    private SideMenuSteps sideMenuSteps = new SideMenuSteps();
    private ContactInsightsSteps contactInsightsSteps = new ContactInsightsSteps();
    private CreateContactDialogSteps createContactDialogSteps = new CreateContactDialogSteps();
    

    @Test (description = "@ALW-12074 @TR-12074 @Regression\r\n"
    		+ "    	  @BugALW-32607 @BugALW-18862\r\n"
    		+ "    	  Scenario: The user can add a new contact")
    public void testUserInteractionsOnContactInsightsPage() throws Exception {
    	
//    	  
//    	    Given [API] the user № 1 sets authentication token
//    	    And [API] the user № 1 removes all existing contacts
//    	    And [API] the user № 1 removes the existing group № 3 with all contacts in that group from the list of groups
//    	    And [API] the user № 1 adds a new group № 3 to the list of groups
        // When the user № 1 is on the Getting started with WayMore page
    	loginSteps.theUserIsOnTheGettingStartedWithWayMorePage(1);
        // Then the Side Menu is displayed
        sideMenuSteps.thenTheSideMenuIsDisplayed();
        // When the user clicks on the Contact Insights item
        sideMenuSteps.whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem("ContactInsights");
        // And the user clicks on the Contact Insights submenu option in the Contact Insights side menu option
        sideMenuSteps.whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption("ContactInsights","ContactInsights");
        // Then the CONTACTS title is displayed
        contactInsightsSteps.thenTheContactsTitleIsDisplayed("CONTACTS");
//        And the table does not display any contacts on the Contacts Insights page
        contactInsightsSteps.thenthetab
//        When the user clicks on the Add New button on the Contact Insights page
        contactInsightsSteps.whenTheUserClicksOnTheAddNewButtonOnTheContactInsightsPage();
//        Then the Create contact dialog is displayed
        createContactDialogSteps.thenTheCreateContactOrEditContactDialogIsDisplayed(createContact);
//        When the user enters a First Name in the suitable input field for the contact № 1 in the Create Contact dialog
        createContactDialogSteps.whenthe
//        And the user enters a Last Name in the suitable input field for the contact № 1 in the Create Contact dialog
//        And the user enters a Email in the suitable input field for the contact № 1 in the Create Contact dialog
//        And the user enters a mobile number with a code for Jordan in the mobile number input field for the contact № 1 in the Create Contact dialog
//        And the user selects a country by typing Jordan in the input field in the dropdown menu of countries in the Create Contact dialog
//        Then the country is changed to Jordan
//        And the country code is changed to 🇯🇴
//        And the mobile number flag is changed to Jordan
//        When the user checks SMS checkbox in the Create Contact dialog
//        Then the checkbox SMS is checked in the Create Contact dialog
//        And the checkbox SMS option is Enabled in the Create Contact dialog
//        When the user checks Viber checkbox in the Create Contact dialog
//        Then the checkbox Viber is checked in the Create Contact dialog
//        And the checkbox Viber option is Enabled in the Create Contact dialog
//        When the user clicks on the Assign contact to Groups dropdown in the Create Contact dialog
//        And the user selects group № 3 option in the Groups dropdown
//        Then the selected group № 3 is displayed in the Groups dropdown
//        When the user selects the contact № 1 birthdate from Birthdate calendar in the Create Contact dialog
//        Then the selected contact № 1 birthdate is displayed in the the Add date of birth input
//        When the user clicks on the Save Button in the Create Contact dialog
//        Then the Create contact dialog is not displayed
//        And the First Name and Last Name data of the contact № 1 is displayed in the Contacts list
//        And the country code for the contact № 1 is displayed as JOR on the Contacts Insights page
//        And the data of SMS and Viber channels for the contact № 1 is displayed in the Contacts list
//        And the Email data of the contact № 1 is displayed in the Contacts list
//        And the group № 3 for the contact № 1 is displayed as selected in the Contacts list

    }
}
