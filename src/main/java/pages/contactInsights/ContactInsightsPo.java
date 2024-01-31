package pages.contactInsights;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePo;
import helpers.Action;
import helpers.ArrayUtils;
import helpers.ElementUtils;
import helpers.StepUtils;
import helpers.StringUtils;
import helpers.Waiters;

public class ContactInsightsPo extends BasePo {
	public ContactInsightsPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	private static final String AriaChecked = "aria-checked";
	private static final Object NextPage = "Next page";
	private static final String Disabled = "disabled";
	private SortContactsDialogPo sortContactsDialogPo = new SortContactsDialogPo(driver);
	private FilterContactsDialogPo filterContactsDialogPo = new FilterContactsDialogPo(driver);

	private By contactsTitle = By.cssSelector(".contacts-page h2 b");
	private By checkbox = By.cssSelector(".wm-table mat-checkbox input");
	private By counter = By.cssSelector(".wm-table__toolbar .wm-table__toolbar-counter");
	private By tableRowCheckboxInput = By.cssSelector(".wm-table__body mat-checkbox input");
	private By tableRowCheckbox = By.cssSelector(".wm-table__body mat-checkbox");
	private By headerCheckbox = By.cssSelector(".wm-table__head .mat-checkbox label span input");
	private By headerCheckboxInput = By.cssSelector(".wm-table__head mat-checkbox input");
	private By exportButton = By.cssSelector("button span[class='icon material-icons-outlined add-new-icon']");
	private By importButton = By.cssSelector("button span[class='icon material-icons-outlined']");
	private By addNewButton = By.cssSelector("button span[class='icon material-icons-round add-new-icon']");
	private By sortButton = By.xpath("//button[contains(text(), 'Sort')]");
	private By filterButton = By.cssSelector("wm-contacts-filter .filter-icon");
	private By filterCloseIcon = By.cssSelector("wm-contacts-filter mat-icon + .filter-close");
	private By contactSubRow = By.cssSelector(".wm-table__body .wm-table__row .wm-table__sub-row");
	private By contactFirstName = By.cssSelector(".wm-table__body .wm-table__row .contacts__name");
	private By contactLastName = By.cssSelector(".wm-table__body .wm-table__row .contacts__last-name");
	private By contactCountry = By.cssSelector(".wm-table__body .wm-table__row .contacts__country");
	private By contactEmail = By.cssSelector(".wm-table__body .wm-table__row .contacts__email");
	private By contactMobilePhone = By.cssSelector(".wm-table__body .wm-table__row .contacts__channel");
	private By contactGroup = By.cssSelector(".wm-table__body .wm-table__row .contacts__groups");
	private By actionsDropdown = By.cssSelector(".mat-menu-trigger .wm-table__toolbar-dropdown");
	private By actionsDropdownOption = By.cssSelector("button.wm-menu-dropdown__option-btn");
	private By pageSizeDropdown = By.cssSelector("mat-form-field .wm-table-pagination__page-size-select");
	private By pageSizeDropdownOption = By.cssSelector("[role='listbox'] mat-option span");
	private By paginationNextLink = By
			.cssSelector(".wm-table-pagination__range-actions button[aria-label=\"Next page\"]");
	private By paginationPreviousLink = By
			.cssSelector(".wm-table-pagination__range-actions button[aria-label='Previous page']");
	private By paginationPageResult = By.cssSelector(".wm-table-pagination__page-result");
	private By allResultsSelectedMessage = By.cssSelector("div.wm-table--v2__hint");
	private By tableLoader = By.cssSelector(".wm-table__body .wm-table__loader-container");
	private By pageNumberInput = By.cssSelector("input[type='number']");
	private By searchInput = By.cssSelector("search-input input[type='search']");
	private By tableContentInfo = By.cssSelector(".wm-table__body .wm-table-placeholder__content");
	private By searchInputClearButton = By.cssSelector("search-input input + mat-icon");
	private By tableContactOptionsDropdownOption = By.cssSelector(".mat-menu-panel .wm-menu-dropdown__option-btn");
	private By waymoreContactsButton = By
			.cssSelector("ng-select .ng-select-container.ng-has-value .ng-value-container");
	private By contactsRouteeTableHeader = By.cssSelector(".wm-table__head div.wm-table__cell");
	private By allContactsDropdown = By.cssSelector("wm-contact-list .wm-page-title");
	private By contactsDropdown = By.cssSelector("div.ng-value-container");
	private By groupDropdown = By.cssSelector("div[role='listbox']");
	private By tableFilterTag = By.cssSelector(".wm-table__filter-statuses span");
	private By closeFilterTagButton = By.cssSelector("wm-contacts-filter-chips mat-chip mat-icon");
	private By groupsTooltipIcon = By.cssSelector("wm-view-groups [uib-tooltip]");
	private By groupsTooltipContent = By.cssSelector("div[uib-tooltip-popup] .tooltip-inner[ng-bind='content']");
	private By rightPopupNotification = By.cssSelector("wm-toast-message");
	private By popupNotificationCloseButton = By.cssSelector("wm-toast-message button");
	private By totalPageNumber = By.cssSelector("span.wm-table-pagination__range-actions-label");
	private By closeSortTagButton = By.cssSelector(".wm-table__filter-statuses .contact-info__group-close");

	private By tableContactOptionsDropdown = By
			.cssSelector(".wm-table__row .wm-table__cell.contacts__options button.wm-menu-dropdown__btn-more");

	private By contactSmsMobilePhone() {
		return By.cssSelector("wm-contact-list div.wm-table__body div.wm-table__sub-row div:nth-child(4)");
	}

	private By contactViberMobilePhone() {
		return By.cssSelector("wm-contact-list div.wm-table__body div.wm-table__sub-row div:nth-child(5)");
	}

	private By contactChannelsByRowNumber(int index) {
		return By.cssSelector(".wm-table__body .wm-table__row:nth-child(" + (index + 1) + ") .contacts__channel");
	}

	private By contactEmailByRowNumber(int index) {
		return By.cssSelector(".wm-table__body .wm-table__row:nth-child(" + (index + 1) + ") .contacts__email");
	}

	private By contactGroupByRowNumber(int index) {
		return By.cssSelector(
				".wm-table__body .wm-table__row:nth-child(" + (index + 1) + ") .contacts__groups .contact-group-item");
	}

	private By contactDropdownOptionByName(String value) {
		return By.xpath("//ng-dropdown-panel//span[text()='" + value + " ']");
	}

	private By groupDropdownOptionByName(String value) {
		return By.xpath("//div//mat-option//span[text()='" + value + "']");
	}

	private By contactOptionByColumnIndexAndContactIndex(int contactIndex, int columnIndex) {
		return By.cssSelector("div.wm-table--routee div.wm-table__body div:nth-child(" + (contactIndex + 1)
				+ ") > div:nth-child(" + (columnIndex + 1) + ")");
	}

	private By contactInfoByDuplicate(String contactInfo, String duplicateName) {
		switch (contactInfo) {
		case "LastName":
			return By.xpath("//*[@class='wm-table__row ng-star-inserted'][.//*[contains(text(),'" + duplicateName
					+ "')]]//*//div[@class='wm-table__cell contacts__last-name']");
		case "Country":
			return By.xpath("//*[@class='wm-table__sub-row ng-star-inserted'][.//*[contains(text(),'" + duplicateName
					+ "')]]//div[@class='wm-table__cell contacts__country']");
		default:
			// Handle the default case or return null based on your requirements
			return null;
		}
	}

	public String getContactRouteeTextByColumnAndContactName(String columnName, String contactName) throws Exception {
		Waiters.waitForElementToBeVisible(By.cssSelector(".contacts__name"));
		List<WebElement> columnList = ElementUtils
				.getElementListWithWaitByLocator(By.cssSelector(".wm-table__head div.wm-table__cell"));
		List<String> columnTextList = ElementUtils.getTextListByElements(columnList);
		int columnIndex = IntStream.range(0, columnTextList.size())
				.filter(i -> columnTextList.get(i).trim().toLowerCase().equals(columnName.toLowerCase())).findFirst()
				.orElseThrow(() -> new NoSuchElementException("Column not found"));

		List<WebElement> contactNameList = ElementUtils
				.getElementListWithWaitByLocator(By.cssSelector(".contacts__name"));
		List<String> contactFirstNameList = ElementUtils.getTextListByElements(contactNameList);
		int contactIndex = IntStream.range(0, contactFirstNameList.size())
				.filter(i -> contactFirstNameList.get(i).equals(contactName)).findFirst()
				.orElseThrow(() -> new NoSuchElementException("Contact name not found"));

		WebElement contactElement = ElementUtils.getElementByLocator(contactOptionByColumnIndexAndContactIndex(contactIndex, columnIndex),0);
		return contactElement.getText();
	}

	public void waitForTableLoaderIsNotDisplayed() {
		Waiters.waitForElementToBeInvisible(tableLoader);
	}

	public void waitForGroupDropdownIsNotDisplayed() {
		Waiters.waitForElementToBeInvisible(groupDropdown);
	}

	public boolean isAllResultsSelectedMessageElementDisplayed() throws Exception {
		return Action.isElementDisplayedByLocator(allResultsSelectedMessage, 0);
	}

	public String getContactsTitleText() throws Exception {
		Waiters.waitForElementToBeDisplayed(contactsTitle);
		return ElementUtils.getTextByLocator(contactsTitle, 0);
	}

	public WebElement getFilterButton() throws Exception {
		return ElementUtils.getElementWithWaitByLocator(filterButton, 0);
	}

	public WebElement getFilterCloseIcon() throws Exception {
		return ElementUtils.getElementByLocator(filterCloseIcon, 0);
	}


	public boolean isFilterCloseIconDisplayed() throws Exception {
		return Action.isElementDisplayedByLocator(filterCloseIcon, 0);
	}

	public void clickOnFilterCloseIcon() throws Exception {
		Action.clickByLocator(filterCloseIcon, 0);
	}

	public String getDropdownText() throws Exception {
		Waiters.waitForElementToBeDisplayed(contactsDropdown);
		return ElementUtils.getTextByLocator(contactsDropdown, 0);
	}

	public String getAllContactsDropdownText() throws Exception {
		Waiters.waitForElementToBeDisplayed(allContactsDropdown);
		return ElementUtils.getTextByLocator(allContactsDropdown, 0);
	}

	public void clickOnCheckboxInTableByValue(String contactName) throws Exception {
		Waiters.waitForElementToBeDisplayed(contactFirstName);
		List<String> contactNameList = ElementUtils.getTextListByLocator(contactFirstName);
		int index = contactNameList.indexOf(contactName);
		Action.clickByLocator(ElementUtils.getElementByLocator(tableRowCheckbox, index));
	}

//	public int getToolbarCounterTextByValue(String counterValue) throws Exception {
//		String headerCounterList = ElementUtils.getTextByLocator(counter, 0);
//		int count = 0;
//			if(headerCounterList.contains(counterValue)){
//			count =1; 
//     		}
////			System.out.println(count);
//		//int index = headerCounterList.indexOf(counterValue);
//		return count;
//		
//	}
	
	public String getToolbarCounterTextByValue(String counterValue) throws Exception {
        List<WebElement> headerCounterElements = ElementUtils.getElementListWithWaitByLocator(counter);
        int index = 0;

        for (int i = 0; i < headerCounterElements.size(); i++) {
            if (headerCounterElements.get(i).getText().contains(counterValue)) {
                index = i;
                break;
            }
        }return ElementUtils.getTextWithJSByLocator(counter, index);
      }

	public void clickOnCheckboxInHeader() throws Exception {
    	Waiters.waitForElementToBeClickable(headerCheckbox);
		Action.clickByLocator(headerCheckbox, 0);
		Waiters.waitWithSleepTimeout(2500);
	}

	public void clickOnAllContactsDropdown() throws Exception {
		Action.clickByLocator(allContactsDropdown, 0);
		Waiters.waitWithSleepTimeout(2500);
	}

	public void clickOnGroupsDropdownOption(String option) throws Exception {
		Waiters.waitForElementToBeDisplayed(groupDropdown);
		Action.clickByLocator(groupDropdownOptionByName(option), 0);
		waitForTableLoaderIsNotDisplayed();
		waitForGroupDropdownIsNotDisplayed();
	}

	public void searchByValue(String value) throws Exception {
		Action.clearTextInLocatorAndTypeText(searchInput, value);
		Waiters.waitForElementToBeVisible(tableLoader);
		Waiters.waitForElementToBeInvisible(tableLoader);
	}

	// ... Previous methods ...

	public String getSearchInputValue() throws Exception {
		Waiters.waitForElementToBeDisplayed(searchInput);
		return ElementUtils.getValueByLocator(searchInput, 0);
	}

	public String getTableContentInfoText() throws Exception {
		Waiters.waitForElementToBeDisplayed(tableContentInfo);
		return ElementUtils.getTextByLocator(tableContentInfo, 0);
	}

	public void clickOnSearchContactsClearButton() throws Exception {
		Action.clickByLocator(searchInputClearButton, 0);
		Waiters.waitForElementToBeInvisible(tableLoader);
		Waiters.waitForElementToBeDisplayed(contactFirstName);
	}

	public List<String> isAllCheckboxesChecked() throws Exception {
		Waiters.waitForElementToBeDisplayed(checkbox);
		return ElementUtils.getAttributeListByLocator(checkbox, AriaChecked);
	}

	public String isHeaderCheckboxChecked() throws Exception {
		Waiters.waitForElementToBeDisplayed(headerCheckbox);
		return ElementUtils.getAttributeByLocator(headerCheckboxInput, AriaChecked, 0);
	}

	public int getSelectedTableRowCheckboxCount() throws Exception {
		Waiters.waitForElementToBeDisplayed(tableRowCheckboxInput);
		List<String> tableRowCheckboxList = ElementUtils.getAttributeListByLocator(tableRowCheckboxInput, AriaChecked);
		//System.out.println(tableRowCheckboxList.stream().filter(checkbox -> "true".equals(checkbox)).count());
		return (int) tableRowCheckboxList.stream().filter(checkbox -> "true".equals(checkbox)).count();
		
	}

	public int getTableRowCheckboxInputCount() throws Exception {
		return ElementUtils.getElementListCountByLocator(tableRowCheckboxInput);
	}

	public String isContactCheckboxCheckedByName(String contactName) throws Exception {
		Waiters.waitForElementToBeDisplayed(contactFirstName);
		List<String> contactNameList = ElementUtils.getTextListByLocator(contactFirstName);
		int index = contactNameList.indexOf(contactName);
		return ElementUtils.getAttributeByLocator(tableRowCheckboxInput, AriaChecked, index);
	}

	public void clickOnExportButton() throws Exception {
		Action.clickByLocator(exportButton, 0);
	}

	public void clickOnImportButton() throws Exception {
		Action.clickByLocator(importButton, 0);
	}

	public void clickOnAddNewButton() throws Exception {
		Action.clickByLocator(addNewButton, 0);
	}

	public void clickOnSortButton() throws Exception {
		Action.clickByLocator(sortButton, 0);
		sortContactsDialogPo.waitForSortContactsDialogIsDisplayed();
	}

	public void clickOnFilterButton() throws Exception {
		Action.clickByLocator(filterButton, 0);
		filterContactsDialogPo.waitForFilterContactsDialogIsDisplayed();
	}

	// ... Previous methods ...

	public void clickOnWaymoreContactsButton() throws Exception {
		Action.clickByLocator(waymoreContactsButton, 0);
	}

	public void clickOnContactsDropdownOption(String option) throws Exception {
		Action.clickByLocator(contactDropdownOptionByName(option), 0);
		waitForTableLoaderIsNotDisplayed();
	}

	public void selectOptionFromActionDropdownByOptionName(String optionName) throws Exception {
		Waiters.waitForElementToBeDisplayed(actionsDropdown);
		Action.clickByLocator(actionsDropdown, 0);
		List<String> optionList = ElementUtils.getTextListByLocator(actionsDropdownOption);
		optionList = optionList.stream().map(
				option -> StringUtils.replaceAllStringForValue(StringUtils.getStringByTrim(option), "\\n\\t\\s+", ""))
				.collect(Collectors.toList());
		int optionIndex = optionList.indexOf(optionName);
		Action.clickWithJSByLocator(actionsDropdownOption, optionIndex);
		Waiters.waitWithSleepTimeout(2500);
	}

	public List<String> getContactsFirstNameTextList() throws Exception {
		waitForTableLoaderIsNotDisplayed();
		Waiters.waitForElementToBeDisplayed(contactFirstName);
		return ElementUtils.getTextListWithJSByLocator(contactFirstName);
	}

	public List<String> getContactsRowTextList() throws Exception {
		Waiters.waitForElementToBeDisplayed(contactFirstName);
		return ElementUtils.getTextListByLocator(contactSubRow);
	}

	public List<String> getContactsLastNameTextList() throws Exception {
		Waiters.waitForElementToBeDisplayed(contactLastName);
		return ElementUtils.getTextListByLocator(contactLastName);
	}

	public List<String> getContactsCountryTextList() throws Exception {
		Waiters.waitForElementToBeDisplayed(contactCountry);
		return ElementUtils.getTextListByLocator(contactCountry);
	}

	public List<String> getContactsEmailTextList() throws Exception {
		Waiters.waitForElementToBeDisplayed(contactEmail);
		return ElementUtils.getTextListByLocator(contactEmail);
	}

	public List<String> getContactsMobilePhoneTextList() throws Exception {
		Waiters.waitForElementToBeDisplayed(contactMobilePhone);
		return ElementUtils.getTextListByLocator(contactMobilePhone);
	}

	public List<String> getContactsSMSTextList() throws Exception {
		Waiters.waitForElementToBeDisplayed(contactSmsMobilePhone());
		return ElementUtils.getTextListByLocator(contactSmsMobilePhone());
	}

	public List<String> getContactsViberTextList() throws Exception {
		Waiters.waitForElementToBeDisplayed(contactViberMobilePhone());
		return ElementUtils.getTextListByLocator(contactViberMobilePhone());
	}

	public List<String> getContactsGroupsTextList() throws Exception {
		Waiters.waitForElementToBeDisplayed(contactGroup);
		return ElementUtils.getTextListByLocator(contactGroup);
	}

	public String getMobilePhoneTextByContactName(String contactName) throws Exception {
		Waiters.waitForElementToBeDisplayed(contactFirstName);
		List<String> contactNameList = ElementUtils.getTextListByLocator(contactFirstName);
		int index = contactNameList.indexOf(contactName);
		return ElementUtils.getTextByLocator(contactMobilePhone, index);
	}

	public String getCountryCodeTextByContactName(String contactName) throws Exception {
		Waiters.waitForElementToBeDisplayed(contactFirstName);
		List<String> contactNameList = ElementUtils.getTextListByLocator(contactFirstName);
		int index = contactNameList.indexOf(contactName);
		return ElementUtils.getTextByLocator(contactCountry, index);
	}

	// ... Previous methods ...

	public String getPaginationPageResultText() throws Exception {
		Waiters.waitForElementToBeDisplayed(paginationPageResult);
		return ElementUtils.getTextByLocator(paginationPageResult, 0);
	}

	public String getPaginationPageSizeDropdownText() throws Exception {
		Waiters.waitForElementToBeDisplayed(pageSizeDropdown);
		return ElementUtils.getTextByLocator(pageSizeDropdown, 0);
	}

	public void selectOptionFromPageSizeDropdownByValue(String option) throws Exception {
		Waiters.waitForElementToBeDisplayed(pageSizeDropdown);
		
		Action.moveMouseToElementByLocator(pageSizeDropdown, 0);
		
		System.out.println("scrolled into view");
		
		Action.clickByLocator(pageSizeDropdown, 0);
		
		StepUtils.addLog("pageSize Dropdown is clicked");
		
		List<String> pageSizeOptionList = ElementUtils.getTextListByLocator(pageSizeDropdownOption);
		pageSizeOptionList = pageSizeOptionList
				.stream().map(pageSizeOption -> StringUtils
						.replaceAllStringForValue(StringUtils.getStringByTrim(pageSizeOption), "\\n\\t\\s+", ""))
				.collect(Collectors.toList());
		int optionIndex = pageSizeOptionList.indexOf(option);
		Action.clickByLocator(pageSizeDropdownOption, optionIndex);
		Waiters.waitWithSleepTimeout(1500);
		Waiters.waitForElementToBeDisplayed(contactFirstName);
	}
	
//	 public void selectOptionFromPageSizeDropdownByValue(String option) throws Exception {
//	        Waiters.waitForElementToBeDisplayed(pageSizeDropdown);
//	        Action.clickByLocator(pageSizeDropdown, 0);
//
//	        List<String> pageSizeOptionList = ElementUtils.getTextListByLocator(pageSizeDropdownOption);
//	        pageSizeOptionList = pageSizeOptionList.stream()
//	                                               .map(pageSizeOption -> StringUtils.replaceAllStringForValue(pageSizeOption, "\\n\\t\\s+",""))
//	                                               .collect(Collectors.toList());
//
//	        int optionIndex = pageSizeOptionList.indexOf(option);
//	        
//	        if (optionIndex != -1) {
//	            Action.clickByLocator(pageSizeDropdownOption, optionIndex);
//	            Waiters.waitWithSleepTimeout(1500); // assuming this is a static sleep
//	            Waiters.waitForElementToBeDisplayed(contactFirstName);
//	        } else {
//	            throw new Exception("Option not found in the dropdown list.");
//	        }
//	    }

	public void clickOnPaginationLink(By locator) throws Exception {
		Waiters.waitForElementToBeDisplayed(locator);
		String isDisabled = ElementUtils.getAttributeByLocator(locator, Disabled, 0);
		String pageNumberBefore = ElementUtils.getValueByLocator(pageNumberInput, 0);

		if (!isDisabled.equals("true")) {
			Action.clickByLocator(locator, 0);
		}

		Waiters.waitForElementToBeInvisible(tableLoader);
		Waiters.waitForTextChange(pageNumberInput, pageNumberBefore, 0);
		Waiters.waitForElementToBeDisplayed(tableRowCheckboxInput);
	}

	public void clickOnPaginationNextLink() throws Exception {
		clickOnPaginationLink(paginationNextLink);
	}

	public void clickOnPaginationPreviousLink() throws Exception {
		clickOnPaginationLink(paginationPreviousLink);
	}

	public WebElement getPageNumberInput() throws Exception {
		return ElementUtils.getElementByLocator(pageNumberInput, 0);
	}

	public String getPageNumberInputValue() throws Exception {
		Waiters.waitForElementToBeDisplayed(pageNumberInput);
		return ElementUtils.getValueByLocator(pageNumberInput, 0);
	}

	public void typePageNumberByValue(String pageNumber) throws Exception {
		Action.clickByLocator(pageNumberInput, 0);
		Action.clearTextInLocatorAndTypeTextWithEnter(pageNumberInput, pageNumber);
		Waiters.waitForElementToBeInvisible(tableLoader);
		Waiters.waitWithSleepTimeout(1000);
	}

	public String getDisableAttributeByButtonValue(String buttonName) throws Exception {
		By locator = buttonName.equals(NextPage) ? paginationNextLink : paginationPreviousLink;
		Waiters.waitForElementToBeDisplayed(locator);
		return ElementUtils.getAttributeByLocator(locator, Disabled, 0);
	}

	public WebElement getAllResultsSelectedMessage() throws Exception {
		Waiters.waitForElementToBeDisplayed(allResultsSelectedMessage);
		return ElementUtils.getElementByLocator(allResultsSelectedMessage, 0);
	}

	public String getAllResultsSelectedMessageText() throws Exception {
		Waiters.waitForElementToBeDisplayed(allResultsSelectedMessage);
		return ElementUtils.getTextByLocator(allResultsSelectedMessage, 0);
	}

	public void selectOptionFromDropdownByOptionName(String optionValue, String contactName) throws Exception {
		Waiters.waitForElementToBeDisplayed(tableContactOptionsDropdown);
		List<String> contactFirstNameList = ElementUtils.getTextListByLocator(contactFirstName);
		int index = contactFirstNameList.indexOf(contactName);
		Action.clickByLocator(tableContactOptionsDropdown, index);
		Waiters.waitForElementToBeDisplayed(tableContactOptionsDropdownOption);
		List<String> optionList = ElementUtils.getTextListByLocator(tableContactOptionsDropdownOption);
		int optionIndex = optionList.indexOf(optionValue);
		Action.clickWithJSByLocator(tableContactOptionsDropdownOption, optionIndex);
		Waiters.waitWithSleepTimeout(1000);
	}

	 public String getGroupTextByContactName(String contactName) throws Exception {
	        List<WebElement> contactFirstNameElements = ElementUtils.getElementListWithWaitByLocator( contactFirstName);
	        int optionIndex = -1;

	        for (int i = 0; i < contactFirstNameElements.size(); i++) {
	            if (contactFirstNameElements.get(i).getText().equals(contactName)) {
	                optionIndex = i;
	                break;
	            }
	        }

	        if (optionIndex != -1) {
	            return ElementUtils.getTextByLocator( contactGroup, optionIndex);
	        } else {
	            return "";
	        }
	    }
	public List<String> getContactChannelTextListByContactName(String contactName) throws Exception {
		List<String> contactNameList = ElementUtils.getTextListByLocator(contactFirstName);
		int index = contactNameList.indexOf(contactName);
		return ElementUtils.getTextListByLocator(contactChannelsByRowNumber(index));
	}

	public String getContactEmailTextByContactName(String contactName) throws Exception {
		List<String> contactNameList = ElementUtils.getTextListByLocator(contactFirstName);
		int index = contactNameList.indexOf(contactName);
		return ElementUtils.getTextByLocator(contactEmailByRowNumber(index), index);
	}

	public boolean isContactElementDisplayed() throws Exception {
		// waitForTableLoaderIsNotDisplayed();
		return Action.isElementDisplayedByLocator(contactSubRow, 0);
	}

	public List<String> getColumnHeaderTextList() throws Exception {
		return ArrayUtils.getArrayWithoutAppropriateFields(ElementUtils.getTextListByLocator(contactsRouteeTableHeader),
				Collections.singletonList(""));
	}

	public List<String> getFilterTagTextList() throws Exception {
		List<String> filterTagTextList = ElementUtils.getTextListByLocator(tableFilterTag);
		List<String> collect = filterTagTextList.stream().map(StringUtils::getStringByTrim).collect(Collectors.toList());
		//System.out.println(collect);
		return collect;
	}

	public boolean isFilterTagDisplayed() throws Exception {
		return Action.isElementDisplayedByLocator(tableFilterTag, 0);
	}

	public List<String> getContactsByDuplicateTextList(String contactInfo, String duplicate) throws Exception {
		return ElementUtils.getTextListByLocator(contactInfoByDuplicate(contactInfo, duplicate));
	}

	public void clearTextInSearchContactInput() throws Exception {
		Action.clearTextInLocatorWithExtraTempSpace(searchInput);
		Waiters.waitWithSleepTimeout(1000);
		Waiters.waitForElementToBeInvisible(tableLoader);
	}

	public void typeTextInSearchInputFieldWithoutClear(String text) throws Exception {
		Action.typeTextInLocatorWithoutClear(searchInput, text, 0);
		Waiters.waitWithSleepTimeout(1000);
		Waiters.waitForElementToBeInvisible(tableLoader);
	}

	public String getContactDetailsTextByContactName(String contactName) throws Exception {
		Waiters.waitForElementToBeDisplayed(contactFirstName);
		List<String> contactNameList = ElementUtils.getTextListByLocator(contactFirstName);
		int index = contactNameList.indexOf(contactName);
		return ElementUtils.getTextByLocator(contactSubRow, index);
	}

	public void clickOnCloseSortTagButton() throws Exception {
		Action.clickWithJSByLocator(closeSortTagButton, 0);
	}

	public void clickOnCloseFilterTagButtonByTagName(String tag) throws Exception {
		List<String> filterTagList = ElementUtils.getTextListByLocator(tableFilterTag);
		filterTagList = filterTagList.stream().map(StringUtils::getStringByTrim).collect(Collectors.toList());
		int index = filterTagList.indexOf(tag);
		Action.clickWithJSByLocator(closeFilterTagButton, index);
	}

	public void mouseHoverGroupsTooltip() throws Exception {
		Waiters.waitForElementToBeDisplayed(groupsTooltipIcon);
		Action.moveMouseToElementByLocator(groupsTooltipIcon, 0);
	}

	public String getNumberOfGroupsInTooltip() throws Exception {
		Waiters.waitForElementToBeDisplayed(groupsTooltipIcon);
		return ElementUtils.getTextByLocator(groupsTooltipIcon, 0);
	}

	public String getGroupsTooltipContentText() throws Exception {
		Waiters.waitForElementToBeDisplayed(groupsTooltipContent);
		return ElementUtils.getTextByLocator(groupsTooltipContent, 0);
	}

	public String getRightPopupNotificationText() throws Exception {
		Waiters.waitForElementToBeVisible(rightPopupNotification);
		String popupText = ElementUtils.getTextByLocator(rightPopupNotification, 0);
		return StringUtils.getStringBySplit(popupText, "\n", 1);
	}

	public void clickOnCloseNotificationButton() throws Exception {
		Action.clickWithJSByLocator(popupNotificationCloseButton, 0);
		Waiters.waitForElementToBeInvisible(rightPopupNotification);
		Waiters.waitWithSleepTimeout(2500);
	}

	public String getTotalPageNumberText() throws Exception {
		Waiters.waitForElementToBeDisplayed(totalPageNumber);
		String totalPageContent = ElementUtils.getTextByLocator(totalPageNumber, 0);
		return StringUtils.replaceAllStringForValue(totalPageContent, "\\D+", "");
	}

	public boolean isCounterByNameInToolbarDisplayed(String counterValue) throws Exception {

		return Action.isElementDisplayedByLocator(counter, 1);
	}

	// ... End of methods for ContactInsightsPo ...

}
