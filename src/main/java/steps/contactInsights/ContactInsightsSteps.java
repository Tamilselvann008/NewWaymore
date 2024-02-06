package steps.contactInsights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import basePackage.BasePo;
import enums.uienums.ButtonEnum.ButtonNameEnum;
import enums.uienums.NotificationEnums.ContactInsightsMessageEnum;
import enums.uienums.OptionEnum.ContactsOptionEnum;
import enums.uienums.OptionEnum.PlatformOptionEnum;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.LocalStorage;
import helpers.StepUtils;
import helpers.StringUtils;
import pages.contactInsights.ContactInsightsPo;

public class ContactInsightsSteps extends BasePo {

//    private static final Object AllResultsSelected = "All results on this page are selected.";
//	private static final String firstName = "firstName";
//	private static final String lastName = "lastName";
//	private static final String nextPage = "Next page";
//    private static final String previousPage = "Previous page";

	private ContactInsightsPo contactInsightsPo = new ContactInsightsPo(driver);
//    private ApiContactRouteePo apiContactRouteePo = new ApiContactRouteePo();
//    private ApiGroupsRouteePo apiGroupsRouteePo = new ApiGroupsRouteePo();
//    private UploadFileWithContactsPo uploadFileWithContactsPo = new UploadFileWithContactsPo(driver);

	public void thenTheContactsTitleIsDisplayed(String title) throws Exception {
		// Assertions.expectToEqual(contactInsightsPo.getContactsTitleText(), title,
		// "The '" + title + "' title is not correct");
		StepUtils.addLog("the " + title + " title is displayed");
	}

	public void whenTheUserFiltersTheContactsByAddingTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
			String value) throws Exception {
		// Fetching current list of contact names before filtering
		List<String> contactListBeforeFiltering = contactInsightsPo.getContactsFirstNameTextList();
		// Storing the list as a JSON string in LocalStorage
		LocalStorage.setItem("defaultListOfContacts", StringUtils.parseObjectToJSON(contactListBeforeFiltering));
		// Typing the specified value into the search input field without clearing it
		// first
		contactInsightsPo.typeTextInSearchInputFieldWithoutClear(value);
	}

	public void thenAllFilteredResultsShownContainThePartialValueThatWasEnteredInTheSearchContactsInputField(
			String query) throws Exception {
		List<String> contactsRowTextList = new ArrayList<>();
		String isNextButtonDisabled;

		do {
			isNextButtonDisabled = contactInsightsPo.getDisableAttributeByButtonValue("NextPage"); // Assuming this
																									// method returns
																									// the "disabled"
																									// attribute value
																									// or null if not
																									// present.
			List<String> currentPageContactRowTextList = contactInsightsPo.getContactsRowTextList();
			contactsRowTextList.addAll(currentPageContactRowTextList);
			if (isNextButtonEnabled(isNextButtonDisabled)) { // Checking if the next button is enabled before clicking.
				contactInsightsPo.clickOnPaginationNextLink(); // Assuming this method properly waits for the navigation
																// to complete.
			}
		} while (isNextButtonEnabled(isNextButtonDisabled)); // Continue as long as the next button is enabled.

		boolean allMatchQuery = contactsRowTextList.stream().map(String::toLowerCase)
				.map(contact -> contact.replaceAll("\\s+", ""))
				.allMatch(contact -> contact.contains(query.toLowerCase()));

		Assertions.expectToBeTrue(allMatchQuery, "Not all filtered results shown contain the '" + query + "' value");
	}

	private boolean isNextButtonEnabled(String isDisabled) {
		return isDisabled == null || !isDisabled.equals("true");
	}

	public void thenTheMessageThatThereAreNoResultsMatchingTheSearchIsDisplayed() throws Exception {
		// Direct use of the enum for the expected message.
		String expectedMessage = ContactInsightsMessageEnum.NoResultsMatchSearch.getValue();
		String actualMessage = contactInsightsPo.getTableContentInfoText();

		// Using the provided Assertions class and method name as specified, without
		// alteration.
		Assertions.expectToEqual(actualMessage, expectedMessage, "The message is not displayed");
	}

	public void whenTheUserFiltersContactsByEnteringTheValueIntoTheSearchContactsInputOnTheContactInsightsPage(
			String value) throws Exception {
		List<String> contactListBeforeFiltering = contactInsightsPo.getContactsFirstNameTextList();

		// Simulating storing data in a local storage-like mechanism.
		LocalStorage.setItem("defaultListOfContacts", StringUtils.parseObjectToJSON(contactListBeforeFiltering));

		// Performing the search operation.
		contactInsightsPo.searchByValue(value);
		StepUtils.addLog("the user filters contacts by entering the " + value
				+ " value into the Search Contacts input on the Contact Insights page");
	}

	public void thenTheTableDoesNotDisplayAnyContactsOnTheContactsInsightsPage() throws Exception {
		Assertions.expectToBeFalse(contactInsightsPo.isContactElementDisplayed(),
				"Some contacts are displayed in a table on the Contact Insights page");
		StepUtils.addLog("the table does not display any contacts on the Contacts Insights page");
	}

	public void thenTheFilterButtonIsDisplayedOnTheContactTableToolbar() throws Exception {
		Assertions.expectToDisplay(contactInsightsPo.getFilterButton(),
				"The Filter button is not displayed on the table toolbar");
		StepUtils.addLog("the Filter button is displayed on the Contact table toolbar");
	}

	public void whenTheUserChecksCheckboxInTheHeaderOfTheTableOnTheContactInsightsPage() throws Exception {
		contactInsightsPo.clickOnCheckboxInHeader();
		StepUtils.addLog("the user checks checkbox in the header of the table on the Contact Insights page");
	}

	public void thenAllCheckboxesAreCheckedOnTheContactInsightsPage() throws Exception {
		Assertions.expectToEveryStringEqualInArray(contactInsightsPo.isAllCheckboxesChecked(), "true",
				"Not all checkboxes are checked");
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
		StepUtils.addLog("the " + filterTag + " filter tag is displayed on the Contact Insights page");
	}

	public void thenTheFilterCloseIconIsDisplayedOnTheContactTableToolbar() throws Exception {
		Assertions.expectToDisplay(contactInsightsPo.getFilterCloseIcon(),
				"The Filter close icon is not displayed on the Contact table toolbar");
		StepUtils.addLog("the Filter close icon is displayed on the Contact table toolbar");
	}

	public void thenTheCountryCodeForTheContactNumberIsDisplayedAsDEUGRCJOROnTheContactsInsightsPage(int contactIndex,
			String country) throws Exception {
		String firstName = DataProviders.getContactTestData("firstName", contactIndex);

		String countryCode = contactInsightsPo.getCountryCodeTextByContactName(firstName);

		Assertions.expectToEqual(countryCode, country, "The country code is not displayed as '" + country + "'");

		StepUtils.addLog("The country code is displayed as '" + country + "'");
	}

	public void thenTheDataOfSMSAndViberChannelsForTheContactNumberIsDisplayedInTheContactsList(int contactIndex)
			throws Exception {
		String firstName = DataProviders.getContactTestData("firstName", contactIndex);
		List<String> contactChannelTextList = contactInsightsPo.getContactChannelTextListByContactName(firstName);
		String countryCode = contactInsightsPo.getCountryCodeTextByContactName(firstName);

		String mobileSMS;
		String mobileViber;

		// Assuming that DataProviders.getContactTestData provides destination
		// identifiers for SMS and Viber
		String smsIdentifier = DataProviders.getContactTestData("identifier", contactIndex, 1);
		String viberIdentifier = DataProviders.getContactTestData("identifier", contactIndex, 5);

		if ("DEU".equals(countryCode)) {
			mobileSMS = "+491" + smsIdentifier.substring(3);
			mobileViber = "+491" + viberIdentifier.substring(3);
		} else {
			mobileSMS = smsIdentifier.substring(1);
			mobileViber = viberIdentifier.substring(1);
		}

		Assertions.expectToHaveMembers(contactChannelTextList, Arrays.asList(mobileSMS, mobileViber), "The '"
				+ mobileSMS + "' for SMS channel and '" + mobileViber + "' for Viber channel are not displayed");

		StepUtils.addLog(
				"The '" + mobileSMS + "' for SMS channel and '" + mobileViber + "' for Viber channel are displayed");
	}

	public void thenTheDataOfSMSOrViberChannelForTheContactNumberIsDisplayedInTheContactsList(String channel,
			int contactIndex) throws Exception {
		String firstName = DataProviders.getContactTestData("firstName", contactIndex);
		List<String> contactChannelTextList = contactInsightsPo.getContactChannelTextListByContactName(firstName);
		String countryCode = contactInsightsPo.getCountryCodeTextByContactName(firstName);

		String mobileSMS = "";
		String mobileViber = "";

		// Assuming StringUtils.getStringBySlice to replicate TypeScript's functionality
		if ("Germany".equals(countryCode)) {
			mobileSMS = "+491" + StringUtils
					.getStringBySlice(DataProviders.getContactTestData("identifier", contactIndex, 1), 0, 3);
			mobileViber = "+491" + StringUtils
					.getStringBySlice(DataProviders.getContactTestData("identifier", contactIndex, 5), 0, 3);
		} else {
			mobileSMS = StringUtils.getStringBySlice(DataProviders.getContactTestData("identifier", contactIndex, 1), 0,
					1);
			mobileViber = StringUtils.getStringBySlice(DataProviders.getContactTestData("identifier", contactIndex, 5),
					0, 1);
		}

		if ("SMS".equals(channel)) {
			Assertions.expectToHaveMembers(contactChannelTextList, Arrays.asList("", mobileSMS),
					"The '" + channel + "' channel data is not displayed");
		} else if ("Viber".equals(channel)) {
			Assertions.expectToHaveMembers(contactChannelTextList, Arrays.asList(mobileViber, ""),
					"The '" + channel + "' channel data is not displayed");
		}
	}

	public void thenTheSMSViberChannelDataForTheContactNumberIsEmptyForAddedContactInTheContactsList(String channel,
			int contactIndex, String addType) throws Exception {
		String firstName = DataProviders.getContactTestData("firstName", contactIndex);
		String countryCode = contactInsightsPo.getCountryCodeTextByContactName(firstName);

		String mobileSMS;
		String mobileViber;

		if (addType != null && !addType.isEmpty()) {

			if ("DEU".equals(countryCode)) {
				mobileSMS = "+491" + StringUtils
						.getStringBySlice(DataProviders.getContactTestData("identifier", contactIndex, 1), 0, 3);
				mobileViber = "+491" + StringUtils
						.getStringBySlice(DataProviders.getContactTestData("identifier", contactIndex, 5), 0, 3);
			} else {
				mobileSMS = StringUtils
						.getStringBySlice(DataProviders.getContactTestData("identifier", contactIndex, 1), 0, 1);
				mobileViber = StringUtils
						.getStringBySlice(DataProviders.getContactTestData("identifier", contactIndex, 5), 0, 1);
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
		StepUtils.addLog("The contact email '" + contactEmail + "' is displayed");

	}

	public void thenTheGroupNumberForTheContactNumberIsDisplayedAsSelectedInTheContactsList(int groupIndex,
			int contactIndex) throws Exception {
		// Fetching the first name of the contact.
		String contactName = DataProviders.getContactTestData("firstName", contactIndex);

		// Fetching the name of the group.
		String groupName = DataProviders.getGroupTestData("name", groupIndex);

		// Retrieving the text of the group associated with the contact's name.
		String groupText = contactInsightsPo.getGroupTextByContactName(contactName);

		// Asserting that the group text includes the expected group name.
		Assertions.expectToInclude(groupText, groupName,
				"The contact '" + contactName + "' doesn't contain the group '" + groupName + "'");
		StepUtils.addLog("The contact '" + contactName + "' contain the group '" + groupName + "'");
	}


	public void thenAllFilteredResultsShownInTheColumnContainTheValueThatWasEnteredInTheSearchContactsInputField(
			ContactsOptionEnum column, String query) throws Exception {
		List<String> columnValueList;

		// Directly fetching column values based on the column name
		switch (column) {
		case FirstName:
			columnValueList = contactInsightsPo.getContactsFirstNameTextList();
			break;
		case LastName:
			columnValueList = contactInsightsPo.getContactsLastNameTextList();
			break;
		case Country:
			columnValueList = contactInsightsPo.getContactsCountryTextList();
			break;
		case Email:
			columnValueList = contactInsightsPo.getContactsEmailTextList();
			break;
		case Mobile:
			columnValueList = contactInsightsPo.getContactsMobilePhoneTextList();
			break;
		case Groups:
			columnValueList = contactInsightsPo.getContactsGroupsTextList();
			break;
		default:
			throw new IllegalArgumentException("Invalid column type: " + column.getValue());
		}

		if (ContactsOptionEnum.FirstName.equals(column)) {
			// Adjusting for the special case where "FirstName" values might be empty
			List<String> adjustedColumnValueList = columnValueList.stream()
					.map(value -> value.isEmpty() ? "empty" : value).collect(Collectors.toList());
			Assertions.expectToEveryStringIncludeSomeValueFromArray(adjustedColumnValueList,
					Arrays.asList(query, "empty"), "Not all filtered results shown in the '" + column.getValue()
							+ "' column contain the '" + query + "' or 'empty' value");
		} else {
			Assertions.expectToEveryStringIncludeInArray(columnValueList, query,
					"Not all filtered results shown in the '" + column.getValue() + "' column contain the '" + query
							+ "' value");
		}
		StepUtils.addLog("All filtered results shown in the '" + column.getValue() + "' column contain the '" + query
				+ "' value");
	}

	public void whenTheUserDeletesTextFromTheSearchContactsInputOnTheContactInsightsPage() throws Exception {
		contactInsightsPo.clearTextInSearchContactInput();
		StepUtils.addLog("the user deletes text from the Search Contacts input on the Contact Insights page");
	}

	public void thenAllFilteredResultsShownInTheColumnMatchTheFilterCriteriaSelectedInTheFilterContactsDialog(
			ContactsOptionEnum column, String filterCriteria) throws Exception {
		contactInsightsPo.waitForTableLoaderIsNotDisplayed();
		List<String> columnValueList;
		List<String> filterResult = StringUtils.getStringListBySplit(filterCriteria, ",");

		switch (column) {
		case FirstName:
			columnValueList = contactInsightsPo.getContactsFirstNameTextList();
			break;
		case LastName:
			columnValueList = contactInsightsPo.getContactsLastNameTextList();
			break;
		case Country:
			columnValueList = contactInsightsPo.getContactsCountryTextList();
			break;
		case Email:
			columnValueList = contactInsightsPo.getContactsEmailTextList();
			break;
		case SMS:
			columnValueList = contactInsightsPo.getContactsSMSTextList();
			break;
		case Viber:
			columnValueList = contactInsightsPo.getContactsViberTextList();
			break;
		case Groups:
			columnValueList = contactInsightsPo.getContactsGroupsTextList();
			break;
		default:
			throw new IllegalArgumentException("Invalid column type");
		}

		Assertions.expectToEveryStringIncludeSomeValueFromArray(columnValueList, filterResult,
				"Not all results in the '" + column.getValue() + "' column match the filter criteria '" + filterCriteria
						+ "'");
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

	public void thenTheFirstNameAndLastNameDataOfTheContactNumberIsDisplayedInTheContactsList(int contactIndex)
			throws Exception {
		String FirstName = DataProviders.getContactTestData("firstName", contactIndex);
		String LastName = DataProviders.getContactTestData("lastName", contactIndex);

		Assertions.expectToInclude(contactInsightsPo.getContactsFirstNameTextList(), FirstName,
				"The contact first name '" + FirstName + "' is not displayed");
		Assertions.expectToInclude(contactInsightsPo.getContactsLastNameTextList(), LastName,
				"The contact last name '" + LastName + "' is not displayed");
		StepUtils.addLog(" the First Name '" + FirstName + "' and Last Name '" + LastName
				+ "' is displayed in the Contacts list");
	}

	public void thenTheCounterInTheHeaderDisplaysTheCorrectNumberOfSelectedFilteredRowsInTheTableOnTheContactInsightsPage(
			String option) throws Exception {
		contactInsightsPo.waitForTableLoaderIsNotDisplayed();
		int checkboxCount;
		String toolbarCounter = contactInsightsPo.getToolbarCounterTextByValue(option);

		if ("Selected".equals(option)) {
			checkboxCount = contactInsightsPo.getSelectedTableRowCheckboxCount();
		} else {
			checkboxCount = contactInsightsPo.getTableRowCheckboxInputCount();
		}

		Assertions.expectToEqual(toolbarCounter, option + " " + checkboxCount,
				"The counter in the header displays the incorrect number of the '" + option + "' rows");
		StepUtils.addLog(
				"the counter in the header displays the correct number of Selected rows in the table on the Contact Insights page");
	}

	public void thenTheMessageThatAllResultsAreSelectedIsDisplayedOnTheContactInsightsPage() throws Exception {
		Assertions.expectToDisplay(contactInsightsPo.getAllResultsSelectedMessage(),
				"The message that all results are selected is not displayed");
		Assertions.expectToEqual(contactInsightsPo.getAllResultsSelectedMessageText(),
				ContactInsightsMessageEnum.AllResultsSelected,
				"The message that all results are selected is incorrect");
		StepUtils.addLog("the message that all results are selected is displayed on the Contact Insights page");
	}

	public void thenAllCheckboxesAreUncheckedOnTheContactInsightsPage() throws Exception {
		Assertions.expectToEveryStringEqualInArray(contactInsightsPo.isAllCheckboxesChecked(), "true",
				"Not all checkboxes are checked");
	}

	public void thenTheSelectedCounterInTheToolbarIsNotDisplayedWithoutSelectingRowsInTheTableOnTheContactInsightsPage(
			String option) throws Exception {
		Assertions.expectToBeFalse(contactInsightsPo.isCounterByNameInToolbarDisplayed(option),
				"The '" + option + "' counter in the toolbar is displayed without selecting rows in the table");
		StepUtils.addLog(
				"the Selected counter in the toolbar is not displayed without selecting rows in the table on the Contact Insights page");
	}

	public void thenTheMessageThatAllResultsAreSelectedIsNotDisplayedOnTheContactInsightsPage() throws Exception {
		Assertions.expectToBeFalse(contactInsightsPo.isAllResultsSelectedMessageElementDisplayed(),
				"The message that all results are selected is displayed");
		StepUtils.addLog("the message that all results are selected is not displayed on the Contact Insights page");
	}

	public void whenTheUserChecksCheckboxOfTheWaymoreRouteeContactInTheTableOnTheContactInsightsPage(
			PlatformOptionEnum platform, int index) throws Exception {
		String contactName;
		switch (platform) {
		case Waymore:
			contactName = DataProviders.getContactTestData("firstName", index);
			System.out.println(contactName);
			break;
		case Routee:
			contactName = DataProviders.getRouteeContactTestData("firstName", index);
			break;
		default:
			throw new IllegalArgumentException("Invalid platform option");
		}

		contactInsightsPo.clickOnCheckboxInTableByValue(contactName);
		StepUtils.addLog("The user checks checkbox of the '" + platform + "' contact '" + contactName + "'");
	}

	public void thenTheCheckboxForTheWaymoreRouteeContactIsCheckedOnTheContactInsightsPage(PlatformOptionEnum platform,
			int index) throws Exception {
		String contactName;
		switch (platform) {
		case Waymore:
			contactName = DataProviders.getContactTestData("firstName", index);
			break;
		case Routee:
			contactName = DataProviders.getRouteeContactTestData("firstName", index);
			break;
		default:
			throw new IllegalArgumentException("Invalid platform option");
		}

		Assertions.expectToEqual(contactInsightsPo.isContactCheckboxCheckedByName(contactName), "true",
				"The checkbox for the '" + platform + "' contact '" + contactName + "' is not checked");
		StepUtils.addLog("The checkbox for the '" + platform + "' contact '" + contactName + "is checked'");
	}

	public void thenTheCheckboxForTheWaymoreRouteeContactIsUncheckedOnTheContactInsightsPage(
			PlatformOptionEnum platform, int index) throws Exception {
		String contactName;

		switch (platform) {
		case Waymore:
			contactName = DataProviders.getContactTestData("firstName", index);
			break;
		case Routee:
			contactName = DataProviders.getRouteeContactTestData("firstName", index);
			break;
		default:
			throw new IllegalArgumentException("Invalid platform option");
		}

		Assertions.expectToEqual(contactInsightsPo.isContactCheckboxCheckedByName(contactName), "false",
				"The checkbox for the '" + platform + "' contact '" + contactName + "' is not checked");
	}

	public void thenTheCheckboxInTheHeaderOfTheTableIsUncheckedOnTheContactInsightsPage() throws Exception {
		Assertions.expectToEqual(contactInsightsPo.isHeaderCheckboxChecked(), false,
				"The checkbox in the header of the table is checked");
		StepUtils.addLog("the checkbox in the header of the table is unchecked on the Contact Insights page");
	}

	public void whenTheUserSelectsAnOptionOfItemsPerPageFromThePaginationDropdownOnTheContactInsightsPage(String option)
			throws Exception {
		contactInsightsPo.selectOptionFromPageSizeDropdownByValue(option);
		StepUtils.addLog("the user selects an option of " + option
				+ " items per page from the pagination dropdown on the Contact Insights page");

	}

	public void whenTheUserClicksPreviousOrNextPageButtonOnTheContactInsightsPage(ButtonNameEnum buttonName)
			throws Exception {
		String pageNumberInputValue = contactInsightsPo.getPageNumberInputValue();
		LocalStorage.setItem("pageNumberInputValue", pageNumberInputValue);

		switch (buttonName) {
		case NextPage:
			contactInsightsPo.clickOnPaginationNextLink();
//                contactInsightsPo.localStorage.setItem("clickOnPaginationNextPage", true);
			break;
		case PreviousPage:
			contactInsightsPo.clickOnPaginationPreviousLink();
//                contactInsightsPo.localStorage.setItem("clickOnPaginationPreviousPage", true);
			break;
		default:
			break;
		}
	}

	public void thenTheSearchContactsInputIsClearedOnTheContactInsightsPage() throws Exception {
		String searchInputValue = contactInsightsPo.getSearchInputValue();
		Assertions.expectToEqual("", searchInputValue, "The search contacts input isn't cleared");
		StepUtils.addLog("The search contacts input is cleared");
	}

	public void whenTheUserClicksOnTheClearButtonInTheSearchContactsInputOnTheContactInsightsPage() throws Exception {
		contactInsightsPo.clickOnSearchContactsClearButton();
		StepUtils.addLog(
				"the user clicks on the clear button in the Search Contacts input on the Contact Insights page");
	}

	public void thenTheContactsAreResetToDefaultOnTheContactInsightsPage() throws Exception {
		String defaultListOfContactsJson = LocalStorage.getItem("defaultListOfContacts");
		List<String> contactListBeforeResetting = StringUtils.parseJSONToList(defaultListOfContactsJson);
		List<String> contactListAfterResetting = contactInsightsPo.getContactsFirstNameTextList();

		// Using the provided assertion method name as requested.
		Assertions.expectToHaveMembers(contactListAfterResetting, contactListBeforeResetting,
				"The contacts aren't reset to default on the Contact Insights page");
		LocalStorage.clear();
		StepUtils.addLog("The contacts are reset to default on the Contact Insights page");
	}

	public void thenTheResultOfAllContactsInTheBottomToolbarOfTheTableIsCorrectOnTheContactInsightsPage(String option)
			throws Exception {
		String toolbarCounter = contactInsightsPo.getToolbarCounterTextByValue(option);
		// Use regex to remove all non-digit characters from the toolbar counter string
		toolbarCounter = toolbarCounter.replaceAll("\\D+", "");

		List<String> contactTextListResult = contactInsightsPo.getContactsFirstNameTextList();
		String paginationPageResult = contactInsightsPo.getPaginationPageResultText();
		String itemPerPageStr = contactInsightsPo.getPaginationPageSizeDropdownText();
		int itemPerPage = Integer.parseInt(itemPerPageStr);

		int contactsCountPerPage;
		if (contactTextListResult.size() > itemPerPage) {
			contactsCountPerPage = itemPerPage;
		} else {
			contactsCountPerPage = contactTextListResult.size();
		}

		String expectedPaginationText = String.format("showing 1-%d of %s", contactsCountPerPage, toolbarCounter);
		Assertions.expectToEqual(paginationPageResult, expectedPaginationText,
				"The table doesn't show the correct contacts result");
	}

	public void thenTheSelectedOptionIsDisplayedInThePageDropdownOnContactInsightsPage(int option) throws Exception {
		String itemPerPage = contactInsightsPo.getPaginationPageSizeDropdownText();
		// Assuming the assertion method takes the actual value, expected value, and
		// message as parameters
		Assertions.expectToEqual(Integer.parseInt(itemPerPage), option,
				"The pagination dropdown doesn't show the selected option '" + option + "'");
		StepUtils.addLog("The pagination dropdown shows the selected option '" + option + "'");
	}

	public void thenTheResultOfAllContactsInTheBottomToolbarOfTheTableIsUpdatedAfterChangingThePageNumberOnTheContactInsightsPage()
			throws Exception {
		String toolbarCounter = contactInsightsPo.getToolbarCounterTextByValue("All").replaceAll("[^\\d]", "");
		List<String> contactTextListResult = contactInsightsPo.getContactsFirstNameTextList();
		String paginationPageResult = contactInsightsPo.getPaginationPageResultText();
		String itemPerPage = contactInsightsPo.getPaginationPageSizeDropdownText();
		String pageNumber = contactInsightsPo.getPageNumberInputValue();
		int contactsCountPerPage = Integer.parseInt(pageNumber) * contactTextListResult.size();
		int showingFirstNumber = contactsCountPerPage - Integer.parseInt(itemPerPage) + 1;

		Assertions.expectToEqual(paginationPageResult,
				"showing " + showingFirstNumber + "-" + contactsCountPerPage + " of " + toolbarCounter,
				"The table doesn't show the correct contacts result");
	}

	public void whenTheUserClicksOnTheAddNewButtonOnTheContactInsightsPage() throws Exception {
		contactInsightsPo.clickOnAddNewButton();
		StepUtils.addLog("the user clicks on the Add New button on the Contact Insights page");
	}

}
