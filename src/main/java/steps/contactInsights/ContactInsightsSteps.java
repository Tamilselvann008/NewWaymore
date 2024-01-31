package steps.contactInsights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import basePackage.BasePo;
import bsh.StringUtil;
import enums.uienums.OptionEnum.MenuItemOptionEnum;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.StepUtils;
import pages.contactInsights.ContactInsightsPo;
import pages.contactInsights.UploadFileWithContactsPo;

public class ContactInsightsSteps extends BasePo {

    private static final Object AllResultsSelected = "All results on this page are selected.";
	private static final String Waymore = "Waymore";
	private static final String firstName = "firstName";
	private static final String lastName = "lastName";
	private static final String nextPage = "Next page";
    private static final String previousPage = "Previous page";
	
	private ContactInsightsPo contactInsightsPo = new ContactInsightsPo(driver);
//    private ApiContactRouteePo apiContactRouteePo = new ApiContactRouteePo();
//    private ApiGroupsRouteePo apiGroupsRouteePo = new ApiGroupsRouteePo();
//    private UploadFileWithContactsPo uploadFileWithContactsPo = new UploadFileWithContactsPo(driver);
    
    public void thenTheContactsTitleIsDisplayed(String title) throws Exception {
        Assertions.expectToEqual(contactInsightsPo.getContactsTitleText(), title, "The '" + title + "' title is not correct");
        String value = MenuItemOptionEnum.ContactInsights.getValue();
        StepUtils.addLog("the "+value+" title is displayed");
    }
    
    public void thenTheTableDoesNotDisplayAnyContactsOnTheContactsInsightsPage() throws Exception {
        Assertions.expectToBeFalse(contactInsightsPo.isContactElementDisplayed(),
            "Some contacts are displayed in a table on the Contact Insights page");
        StepUtils.addLog("the table does not display any contacts on the Contacts Insights page");
    }
    public void thenTheFilterButtonIsDisplayedOnTheContactTableToolbar() throws Exception {
        Assertions.expectToDisplay(contactInsightsPo.getFilterButton(), "The Filter button is not displayed on the table toolbar");
        StepUtils.addLog("the Filter button is displayed on the Contact table toolbar");
    }
    
    public void whenTheUserChecksCheckboxInTheHeaderOfTheTableOnTheContactInsightsPage() throws Exception {
        contactInsightsPo.clickOnCheckboxInHeader();
        StepUtils.addLog("the user checks checkbox in the header of the table on the Contact Insights page");
    }
    public void thenAllCheckboxesAreCheckedOnTheContactInsightsPage() throws Exception {
            Assertions.expectToEveryStringEqualInArray(contactInsightsPo.isAllCheckboxesChecked(),"true", "Not all checkboxes are checked");
        StepUtils.addLog("all checkboxes are checked on the Contact Insights page");
    }
    public void whenTheUserClicksOnTheFilterButtonOnTheContactInsightsPage() throws Exception {
        contactInsightsPo.clickOnFilterButton();
        StepUtils.addLog("the user clicks on the Filter button on the Contact Insights page");
    }
    public void thenTheFilterTagIsDisplayedOnTheContactInsightsPage(String filterTag) throws Exception {
        List<String> filterTagTextList = contactInsightsPo.getFilterTagTextList();
        String modifiedFilterTag = filterTag.replace(" - ", " : ");

        Assertions.expectToIncludeMembers(filterTagTextList, Collections.singletonList(modifiedFilterTag),
            "The '" + filterTag + "' filter tag is not displayed on the Contact Insights page");
        StepUtils.addLog("the "+filterTag+" filter tag is displayed on the Contact Insights page");
    }
    
    public void thenTheFilterCloseIconIsDisplayedOnTheContactTableToolbar() throws Exception {
        Assertions.expectToDisplay(contactInsightsPo.getFilterCloseIcon(), "The Filter close icon is not displayed on the Contact table toolbar");
        StepUtils.addLog("the Filter close icon is displayed on the Contact table toolbar");
    }
    
    
    public void thenTheCountryCodeForTheContactNumberIsDisplayedAsDEUGRCJOROnTheContactsInsightsPage(int contactIndex, String country) throws Exception {
        String firstName = DataProviders.getContactTestData("firstName", contactIndex); 

        String countryCode = contactInsightsPo.getCountryCodeTextByContactName(firstName);

        Assertions.expectToEqual(countryCode, country, 
            "The country code is not displayed as '" + country + "'");
    }
    
    public void thenTheDataOfSMSAndViberChannelsForTheContactNumberIsDisplayedInTheContactsList(int contactIndex) throws Exception {
        String firstName = DataProviders.getContactTestData("firstName", contactIndex);
        List<String> contactChannelTextList = contactInsightsPo.getContactChannelTextListByContactName(firstName);
        String countryCode = contactInsightsPo.getCountryCodeTextByContactName(firstName);

        String mobileSMS;
        String mobileViber;

        // Assuming that DataProviders.getContactTestData provides destination identifiers for SMS and Viber
        String smsIdentifier = DataProviders.getContactTestData("identifier", contactIndex, 1);
        String viberIdentifier = DataProviders.getContactTestData("identifier", contactIndex, 5);

        if ("DEU".equals(countryCode)) {
            mobileSMS = "+491" + smsIdentifier.substring(3);
            mobileViber = "+491" + viberIdentifier.substring(3);
        } else {
            mobileSMS = smsIdentifier.substring(1);
            mobileViber = viberIdentifier.substring(1);
        }

        Assertions.expectToHaveMembers(contactChannelTextList, Arrays.asList(mobileSMS, mobileViber),
            "The '" + mobileSMS + "' for SMS channel and '" + mobileViber + "' for Viber channel are not displayed");
    }
    
    public void thenTheDataOfSMSViberChannelForTheContactNumberIsDisplayedInTheContactsList(String channel, int contactIndex) throws Exception {
        // Directly fetching the first name of the contact and other required data using a Data Provider.
        String firstName = DataProviders.getContactTestData("firstName", contactIndex);
        String smsIdentifier = DataProviders.getContactTestData("identifier", contactIndex, 1);
        String viberIdentifier = DataProviders.getContactTestData("identifier", contactIndex, 5);
        String countryCode = contactInsightsPo.getCountryCodeTextByContactName(firstName);

        String mobileSMS;
        String mobileViber;

        if ("DEU".equals(countryCode)) {
            mobileSMS = "+491" + smsIdentifier.substring(3);
            mobileViber = "+491" + viberIdentifier.substring(3);
        } else {
            mobileSMS = smsIdentifier.substring(1);
            mobileViber = viberIdentifier.substring(1);
        }

        List<String> contactChannelTextList = contactInsightsPo.getContactChannelTextListByContactName(firstName);

        if ("SMS".equals(channel)) {
            Assertions.expectToHaveMembers(contactChannelTextList, Arrays.asList("", mobileSMS),
                "The '" + channel + "' channel data is not displayed");
        } else if ("Viber".equals(channel)) {
            Assertions.expectToHaveMembers(contactChannelTextList, Arrays.asList(mobileViber, ""),
                "The '" + channel + "' channel data is not displayed");
        }
    }
    
    
    public void thenTheSMSViberChannelDataForTheContactNumberIsEmptyForAddedContactInTheContactsList(String channel, int contactIndex, String addType) throws Exception {
        String firstName = DataProviders.getContactTestData("firstName", contactIndex);
        String countryCode = contactInsightsPo.getCountryCodeTextByContactName(firstName);

        String mobileSMS;
        String mobileViber;

        if (addType != null && !addType.isEmpty()) {
            String smsIdentifier = DataProviders.getContactTestData("identifier", contactIndex, 1);
            String viberIdentifier = DataProviders.getContactTestData("identifier", contactIndex, 5);

            if ("DEU".equals(countryCode)) {
                mobileSMS = "+491" + smsIdentifier.substring(3);
                mobileViber = "+491" + viberIdentifier.substring(3);
            } else {
                mobileSMS = smsIdentifier.substring(1);
                mobileViber = viberIdentifier.substring(1);
            }
        } else {
            mobileSMS = mobileViber = "";
        }

        List<String> contactChannelTextList = contactInsightsPo.getContactChannelTextListByContactName(firstName);

        if ("SMS".equals(channel)) {
            Assertions.expectToHaveMembers(contactChannelTextList, Arrays.asList("", mobileSMS),
                "The '" + channel + "' channel data is not empty");
        } else if ("Viber".equals(channel)) {
            Assertions.expectToHaveMembers(contactChannelTextList, Arrays.asList(mobileViber, ""),
                "The '" + channel + "' channel data is not empty");
        }
    }
    
    
    
    public void thenTheEmailDataOfTheContactNumberIsDisplayedInTheContactsList(int contactIndex) throws Exception {
        // Fetching the email of the contact using the Data Provider.
        String contactEmail = DataProviders.getContactTestData("identifier", contactIndex, 7);

        // Checking if the contact's email is present in the Contacts list.
        Assertions.expectToInclude(contactInsightsPo.getContactsEmailTextList(), contactEmail, 
            "The contact email '" + contactEmail + "' is not displayed");
    }
    
    
    public void thenTheGroupNumberForTheContactNumberIsDisplayedAsSelectedInTheContactsList(int groupIndex, int contactIndex) throws Exception {
        // Fetching the first name of the contact.
        String contactName = DataProviders.getContactTestData("firstName", contactIndex);

        // Fetching the name of the group.
        String groupName = DataProviders.getGroupTestData("name", groupIndex);

        // Retrieving the text of the group associated with the contact's name.
        String groupText = contactInsightsPo.getGroupTextByContactName(contactName);

        // Asserting that the group text includes the expected group name.
        Assertions.expectToInclude(groupText, groupName, 
            "The contact '" + contactName + "' doesn't contain the group '" + groupName + "'");
    }
    
    public void thenAllFilteredResultsShownInTheColumnMatchTheFilterCriteriaSelectedInTheFilterContactsDialog(String column, String filterCriteria) throws Exception {
        contactInsightsPo.waitForTableLoaderIsNotDisplayed();
        List<String> columnValueList = new ArrayList<>();
        List<String> filterResult = Arrays.asList(filterCriteria.split(","));

        switch (column) {
            case "First Name":
                columnValueList = contactInsightsPo.getContactsFirstNameTextList();
                break;
            case "Last Name":
                columnValueList = contactInsightsPo.getContactsLastNameTextList();
                break;
            case "Country":
                columnValueList = contactInsightsPo.getContactsCountryTextList();
                break;
            case "Email":
                columnValueList = contactInsightsPo.getContactsEmailTextList();
                break;
            case "SMS":
                columnValueList = contactInsightsPo.getContactsSMSTextList();
                break;
            case "Viber":
                columnValueList = contactInsightsPo.getContactsViberTextList();
                break;
            case "Groups":
                columnValueList = contactInsightsPo.getContactsGroupsTextList();
                break;
            // Other cases as necessary
        }

        Assertions.expectToEveryStringIncludeSomeValueFromArray(columnValueList, filterResult,
            "Not all results in the '" + column + "' column match the filter criteria '" + filterCriteria + "'");
        StepUtils.addLog("all filtered results shown in the "+column+" column match the "+filterCriteria+" filter criteria selected in the Filter Contacts dialog");
    }
    
    public void thenTheFilterSortTagIsNotDisplayedOnTheContactInsightsPage(String tagType) throws Exception {
        Assertions.expectToBeFalse(contactInsightsPo.isFilterTagDisplayed(),
            "The '" + tagType + "' tag is displayed on the Contact Insights page");
        StepUtils.addLog("The '" + tagType + "' tag is not displayed on the Contact Insights page");
    }
    public void thenTheFilterCloseIconIsNotDisplayedOnTheContactTableToolbar() throws Exception {
        Assertions.expectToBeFalse(contactInsightsPo.isFilterCloseIconDisplayed(),
            "The Filter close icon is displayed on the Contact table toolbar");
    }


    public void thenTheFirstNameAndLastNameDataOfTheContactNumberIsDisplayedInTheContactsList(int contactIndex) throws Exception {
        String FirstName = DataProviders.getContactTestData("firstName", contactIndex);
        String LastName = DataProviders.getContactTestData("lastName", contactIndex);

        Assertions.expectToInclude(contactInsightsPo.getContactsFirstNameTextList(), FirstName,
            "The contact first name '" + FirstName + "' is not displayed");
        Assertions.expectToInclude(contactInsightsPo.getContactsLastNameTextList(),LastName, 
            "The contact last name '" + LastName + "' is not displayed");
        StepUtils.addLog(" the First Name '" + FirstName + "' and Last Name '" + LastName +"' data of the contact "+contactIndex+" is displayed in the Contacts list");
    }
    
    public void thenTheCounterInTheHeaderDisplaysTheCorrectNumberOfSelectedFilteredRowsInTheTableOnTheContactInsightsPage(String option) throws Exception {
        contactInsightsPo.waitForTableLoaderIsNotDisplayed();
        int checkboxCount;
        String toolbarCounter = contactInsightsPo.getToolbarCounterTextByValue(option);

        if ("Selected".equals(option)) {
            checkboxCount = contactInsightsPo.getSelectedTableRowCheckboxCount();
        } else {
            checkboxCount = contactInsightsPo.getTableRowCheckboxInputCount();
        }

        Assertions.expectToEqual(toolbarCounter, option + " " + checkboxCount, "The counter in the header displays the incorrect number of the '" + option + "' rows");
        StepUtils.addLog("the counter in the header displays the correct number of Selected rows in the table on the Contact Insights page");
    }
    public void thenTheMessageThatAllResultsAreSelectedIsDisplayedOnTheContactInsightsPage() throws Exception {
        Assertions.expectToDisplay(contactInsightsPo.getAllResultsSelectedMessage(), "The message that all results are selected is not displayed");
        Assertions.expectToEqual(contactInsightsPo.getAllResultsSelectedMessageText(), AllResultsSelected,
            "The message that all results are selected is incorrect");
        StepUtils.addLog("the message that all results are selected is displayed on the Contact Insights page");
    } 
    
    public void thenAllCheckboxesAreUncheckedOnTheContactInsightsPage() throws Exception {
    	Assertions.expectToEveryStringEqualInArray(contactInsightsPo.isAllCheckboxesChecked(),"true", "Not all checkboxes are checked");
        }
    
    public void thenTheSelectedCounterInTheToolbarIsNotDisplayedWithoutSelectingRowsInTheTableOnTheContactInsightsPage(String option) throws Exception {
        Assertions.expectToBeFalse(contactInsightsPo.isCounterByNameInToolbarDisplayed(option),
            "The '" + option + "' counter in the toolbar is displayed without selecting rows in the table");
        StepUtils.addLog("the Selected counter in the toolbar is not displayed without selecting rows in the table on the Contact Insights page");
    }
    public void thenTheMessageThatAllResultsAreSelectedIsNotDisplayedOnTheContactInsightsPage() throws Exception {
        Assertions.expectToBeFalse(contactInsightsPo.isAllResultsSelectedMessageElementDisplayed(),
            "The message that all results are selected is displayed");
        StepUtils.addLog("the message that all results are selected is not displayed on the Contact Insights page");
    }
    
    public void whenTheUserChecksCheckboxOfTheWaymoreRouteeContactInTheTableOnTheContactInsightsPage(String platform,int index) throws Exception {
        String contactName;

        switch (platform) {
            case Waymore:
                contactName = DataProviders.getContactTestData("firstName", index);
                System.out.println(contactName);
                break;
//            case Routee:
//                contactName = contactInsightsPo.dataProvider.getRouteeContactTestData(contactIndex).getFirstName();
//                break;
            default:
                throw new IllegalArgumentException("Invalid platform option");
        }

        
        contactInsightsPo.clickOnCheckboxInTableByValue(contactName);
        StepUtils.addLog("The user checks checkbox of the '" + platform + "' contact '" + contactName + "'");
    }
    
    public void thenTheCheckboxForTheWaymoreRouteeContactIsCheckedOnTheContactInsightsPage(String platform,int index) throws Exception {
        String contactName;

        switch (platform) {
            case Waymore:
                contactName = DataProviders.getContactTestData("firstName", index);
                break;
//            case PlatformOptionEnum.Routee:
//                contactName = contactInsightsPo.dataProvider.getRouteeContactTestData(contactIndex).getFirstName();
//                break;
            default:
                throw new IllegalArgumentException("Invalid platform option");
        }

        Assertions.expectToEqual(contactInsightsPo.isContactCheckboxCheckedByName(contactName), "true",
            "The checkbox for the '" + platform + "' contact '" + contactName + "' is not checked");
        StepUtils.addLog("The checkbox for the '" + platform + "' contact '" + contactName + "is checked'");
    }
    
    public void thenTheCheckboxForTheWaymoreRouteeContactIsUncheckedOnTheContactInsightsPage(String platform,int index) throws Exception {
        String contactName;

        switch (platform) {
            case Waymore:
                contactName = DataProviders.getContactTestData("firstName", index);
                break;
//            case PlatformOptionEnum.Routee:
//                contactName = contactInsightsPo.dataProvider.getRouteeContactTestData(contactIndex).getFirstName();
//                break;
            default:
                throw new IllegalArgumentException("Invalid platform option");
        }

        Assertions.expectToEqual(contactInsightsPo.isContactCheckboxCheckedByName(contactName), "false",
            "The checkbox for the '" + platform + "' contact '" + contactName + "' is not checked");
    }
    
    public void thenTheCheckboxInTheHeaderOfTheTableIsUncheckedOnTheContactInsightsPage() throws Exception {
        Assertions.expectToEqual(contactInsightsPo.isHeaderCheckboxChecked(), false, "The checkbox in the header of the table is checked");
        StepUtils.addLog("the checkbox in the header of the table is unchecked on the Contact Insights page");
    }
    
    public void whenTheUserSelectsAnOptionOfItemsPerPageFromThePaginationDropdownOnTheContactInsightsPage(String option) throws Exception {
        contactInsightsPo.selectOptionFromPageSizeDropdownByValue(option);
        StepUtils.addLog("the user selects an option of "+option+" items per page from the pagination dropdown on the Contact Insights page");
        
    }
    
    public void whenTheUserClicksPreviousOrNextPageButtonOnTheContactInsightsPage(String buttonName) throws Exception {
//        String pageNumberInputValue = contactInsightsPo.getPageNumberInputValue();
//        contactInsightsPo.localStorage.setItem("pageNumberInputValue", pageNumberInputValue);

        switch (buttonName) {
            case nextPage:
                contactInsightsPo.clickOnPaginationNextLink();
//                contactInsightsPo.localStorage.setItem("clickOnPaginationNextPage", true);
                break;
            case previousPage:
                contactInsightsPo.clickOnPaginationPreviousLink();
//                contactInsightsPo.localStorage.setItem("clickOnPaginationPreviousPage", true);
                break;
        }
    }

    public void thenTheSelectedOptionIsDisplayedInThePageDropdownOnContactInsightsPage(int option) throws Exception {
        String itemPerPage = contactInsightsPo.getPaginationPageSizeDropdownText();
        int parsedItemPerPage = Integer.parseInt(itemPerPage);

        Assertions.expectToEqual(parsedItemPerPage, option, "The pagination dropdown doesn't show the selected option '" + option + "'");
    }
    
    public void thenTheResultOfAllContactsInTheBottomToolbarOfTheTableIsCorrectOnTheContactInsightsPage() throws Exception {
        String toolbarCounter = contactInsightsPo.getToolbarCounterTextByValue("All").replaceAll("[^\\d]", "");
        List<String> contactTextListResult = contactInsightsPo.getContactsFirstNameTextList();
        String paginationPageResult = contactInsightsPo.getPaginationPageResultText();
        String itemPerPage = contactInsightsPo.getPaginationPageSizeDropdownText();
        int contactsCountPerPage = contactTextListResult.size() > Integer.parseInt(itemPerPage) ? Integer.parseInt(itemPerPage) : contactTextListResult.size();

        Assertions.expectToEqual(paginationPageResult, "showing 1-" + contactsCountPerPage + " of " + toolbarCounter, "The table doesn't show the correct contacts result");
    }

    public void thenTheResultOfAllContactsInTheBottomToolbarOfTheTableIsUpdatedAfterChangingThePageNumberOnTheContactInsightsPage() throws Exception {
        String toolbarCounter = contactInsightsPo.getToolbarCounterTextByValue("All").replaceAll("[^\\d]", "");
        List<String> contactTextListResult = contactInsightsPo.getContactsFirstNameTextList();
        String paginationPageResult = contactInsightsPo.getPaginationPageResultText();
        String itemPerPage = contactInsightsPo.getPaginationPageSizeDropdownText();
        String pageNumber = contactInsightsPo.getPageNumberInputValue();
        int contactsCountPerPage = Integer.parseInt(pageNumber) * contactTextListResult.size();
        int showingFirstNumber = contactsCountPerPage - Integer.parseInt(itemPerPage) + 1;

        Assertions.expectToEqual(paginationPageResult, "showing " + showingFirstNumber + "-" + contactsCountPerPage + " of " + toolbarCounter, "The table doesn't show the correct contacts result");
    }

    public void whenTheUserClicksOnTheAddNewButtonOnTheContactInsightsPage() throws Exception {
        contactInsightsPo.clickOnAddNewButton();
        StepUtils.addLog("the user clicks on the Add New button on the Contact Insights page");
    }
}

