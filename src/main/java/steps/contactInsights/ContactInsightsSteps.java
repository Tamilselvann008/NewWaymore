package steps.contactInsights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import basePackage.BasePo;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.StepUtils;
import pages.contactInsights.ContactInsightsPo;
import pages.contactInsights.UploadFileWithContactsPo;

public class ContactInsightsSteps extends BasePo {

    private static final Object AllResultsSelected = "All results on this page are selected.";
	private static final String Waymore = "Waymore";
	private String firstName = "firstName";
	private static final String nextPage = "Next page";
    private static final String previousPage = "Previous page";
	private ContactInsightsPo contactInsightsPo = new ContactInsightsPo(driver);
//    private ApiContactRouteePo apiContactRouteePo = new ApiContactRouteePo();
//    private ApiGroupsRouteePo apiGroupsRouteePo = new ApiGroupsRouteePo();
//    private UploadFileWithContactsPo uploadFileWithContactsPo = new UploadFileWithContactsPo(driver);
    
    public void thenTheContactsTitleIsDisplayed(String title) throws Exception {
        Assertions.expectToEqual(contactInsightsPo.getContactsTitleText(), title, "The '" + title + "' title is not correct");
        StepUtils.addLog("the "+title+" title is displayed");
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

//    public void thenTheCounterInTheHeaderDisplaysTheCorrectNumberOfSelectedFilteredRowsInTheTableOnTheContactInsightsPage(String option) throws Exception {
//        contactInsightsPo.waitForTableLoaderIsNotDisplayed();
//        int checkboxCount;
//        String toolbarCounter = contactInsightsPo.getToolbarCounterTextByValue(option);
//        System.out.println("toolbarCounter"+toolbarCounter);
//        switch (option) {
//            case "Selected ":
//                checkboxCount = contactInsightsPo.getSelectedTableRowCheckboxCount();
//               System.out.println("checkboxCount"+checkboxCount);
//                break;
//            default:
//                checkboxCount = contactInsightsPo.getTableRowCheckboxInputCount();
//                break;
//        }
//
//        Assertions.expectToEqual(toolbarCounter,  option+checkboxCount, "The counter in the header displays the incorrect number of the '" + option + "' rows");
//        StepUtils.addLog("the counter in the header displays the correct number of Selected rows in the table on the Contact Insights page");
//    }
    
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
                contactName = DataProviders.getContactTestData(firstName, index);
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
                contactName = DataProviders.getContactTestData(firstName, index);
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
                contactName = DataProviders.getContactTestData(firstName, index);
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
}

//    public void whenTheUserChecksCheckboxOfTheWaymoreRouteeContactNumberInTheTableOnTheContactInsightsPage(String platform, int contactIndex) {
//        String contactData;
//        if (platform.equals(PlatformOptionEnum.Waymore)) {
//            contactData = DataProviders.getContactTestData(contactIndex);
//        } else {
//            contactData = DataProviders.getRouteeContactTestData(contactIndex);
//        }
//        StepUtils.addLog("The user checks checkbox of the '" + platform + "' contact '" + contactData.getFirstName() + "'");
//        contactInsightsPo.clickOnCheckboxInTableByValue(contactData.getFirstName());
//    }
//
//    public void whenTheUserChecksCheckboxInTheHeaderOfTheTableOnTheContactInsightsPage() {
//        contactInsightsPo.clickOnCheckboxInHeader();
//    }
//
//    public void whenTheUserNotesTheDefaultListOfContactsOnTheContactInsightsPage() {
//        List<String> defaultListOfContacts = contactInsightsPo.getContactsFirstNameTextList();
//        contactInsightsPo.localStorage.setItem("defaultListOfContacts", StringUtils.parseObjectToJSON(defaultListOfContacts));
//    }
//
//    public void whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(String value) {
//        List<String> contactListBeforeFiltering = contactInsightsPo.getContactsFirstNameTextList();
//        contactInsightsPo.localStorage.setItem("defaultListOfContacts", StringUtils.parseObjectToJSON(contactListBeforeFiltering));
//        contactInsightsPo.searchByValue(value);
//    }
//
//    // ... More methods ...
//
//    public void thenTheCheckboxForTheWaymoreRouteeContactNumberIsCheckedOnTheContactInsightsPage(String platform, int contactIndex) {
//        IContactDataType contactData;
//        if (platform.equals(PlatformOptionEnum.Waymore)) {
//            contactData = contactInsightsPo.dataProvider.getContactTestData(contactIndex);
//        } else {
//            contactData = contactInsightsPo.dataProvider.getRouteeContactTestData(contactIndex);
//        }
//        Assertions.expectToEqual(contactInsightsPo.isContactCheckboxCheckedByName(contactData.getFirstName()), true,
//            "The checkbox for the '" + platform + "' contact '" + contactData.getFirstName() + "' is not checked");
//   
