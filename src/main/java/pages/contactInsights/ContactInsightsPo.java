package pages.contactInsights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.Waiters;


public class ContactInsightsPo extends BasePo {

	public ContactInsightsPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private By contactsTitle = By.cssSelector(".contacts-page h2 b");
	private By checkbox = By.cssSelector(".wm-table mat-checkbox input");
	private By counter = By.cssSelector(".wm-table__toolbar .wm-table__toolbar-counter");
	private By tableRowCheckboxInput = By.cssSelector(".wm-table__body mat-checkbox input");
	private By tableRowCheckbox = By.cssSelector(".wm-table__body mat-checkbox");
	private By headerCheckbox = By.cssSelector(".wm-table__head mat-checkbox");
	private By headerCheckboxInput = By.cssSelector(".wm-table__head mat-checkbox input");
	private By exportButton = By.cssSelector("button span[class=\"icon material-icons-outlined add-new-icon\"]");
	private By importButton = By.cssSelector("button span[class=\"icon material-icons-outlined\"]");
	private By addNewButton = By.cssSelector("button span[class=\"icon material-icons-round add-new-icon\"]");
	private By sortButton = By.xpath("//button[contains(text(), \"Sort\")]");
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
	private By pageSizeDropdownOption = By.cssSelector("[role=\"listbox\"] mat-option span");
	private By paginationNextLink = By
			.cssSelector(".wm-table-pagination__range-actions button[aria-label=\"Next page\"]");
	private By paginationPreviousLink = By
			.cssSelector(".wm-table-pagination__range-actions button[aria-label=\"Previous page\"]");
	private By paginationPageResult = By.cssSelector(".wm-table-pagination__page-result");
	private By allResultsSelectedMessage = By.cssSelector("div.wm-table--v2__hint");
	private By tableLoader = By.cssSelector(".wm-table__body .wm-table__loader-container");
	private By pageNumberInput = By.cssSelector("input[type=\"number\"]");
	private By searchInput = By.cssSelector("search-input input[type=\"search\"]");
	private By tableContentInfo = By.cssSelector(".wm-table__body .wm-table-placeholder__content");
	private By searchInputClearButton = By.cssSelector("search-input input + mat-icon");
	private By tableContactOptionsDropdownOption = By.cssSelector(".mat-menu-panel .wm-menu-dropdown__option-btn");
	private By waymoreContactsButton = By
			.cssSelector("ng-select .ng-select-container.ng-has-value .ng-value-container");
	private By contactsRouteeTableHeader = By.cssSelector(".wm-table__head div.wm-table__cell");
	private By allContactsDropdown = By.cssSelector("wm-contact-list .wm-page-title");
	private By contactsDropdown = By.cssSelector("div.ng-value-container");
	private By groupDropdown = By.cssSelector("div[role=\"listbox\"]");
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

	public void clickOnAddNewButton() throws Exception {
		Action.clickByLocator(addNewButton);
	}

	public String getContactsTitleText() throws Exception {
		Waiters.waitForElementToBeDisplayed(contactsTitle);
		waitForTableLoaderIsNotDisplayed();
		return ElementUtils.getTextByLocator(contactsTitle, 0);
	}

	public void waitForTableLoaderIsNotDisplayed() {
		Waiters.waitForElementToBeInvisible(tableLoader);
	}

	public void waitForGroupDropdownIsNotDisplayed() {
		Waiters.waitForElementToBeInvisible(groupDropdown);
	}

	public boolean isContactElementDisplayed() {
		return Action.isElementDisplayedByLocator(contactSubRow);
	}
	
	 public String getContactsFirstNameTextList() throws InterruptedException {
	       Waiters.waitForElementToBeDisplayed(contactFirstName);
	       return ElementUtils.getTextListWithJSByLocator(contactFirstName).get(0);
	    }

	    public String getContactsLastNameTextList() throws InterruptedException {
	        Waiters.waitForElementToBeDisplayed(contactLastName);
	        return ElementUtils.getTextListWithJSByLocator(contactLastName).get(0);
	    }

}
