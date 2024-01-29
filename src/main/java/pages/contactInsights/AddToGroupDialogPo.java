package pages.contactInsights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.StringUtils;
import helpers.Waiters;

import java.util.List;
import java.util.stream.Collectors;

public class AddToGroupDialogPo extends BasePo {
	private By addToGroupDialog = By.cssSelector("mat-dialog-container[role='dialog']");
	private By addToGroupDialogHeader = By.cssSelector("mat-dialog-container .wm-dialog__header div");
	private By addToGroupDropdown = By.cssSelector("mat-form-field .mat-chip-list input");
	private By addToGroupDropdownOption = By.cssSelector("[role='listbox'] mat-option");
	private By selectedGroupChipOption = By.cssSelector("mat-chip-list mat-chip");
	private By searchProgressLiner = By.cssSelector("mat-progress-bar[role='progressbar']");
	private By addToGroupButton = By.cssSelector("wm-progress-button button");
	private By addToGroupButtonLoading = By.cssSelector("progress-button button.wm-btn--loading");
	private By closeButton = By.cssSelector(".contacts-dialog__add-to-group .wm-dialog-close");
	private By cancelButton = By.cssSelector(".wm-dialog__actions .wm-btn.wm-btn--simple.wm-btn--small");
	private By dropdownOptionSpinner = By.cssSelector("mat-spinner[role='progressbar']");
	private By removeSelectedGroupChipButton = By.cssSelector(".mat-chip-list-wrapper mat-chip mat-icon");

	public AddToGroupDialogPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddToGroupDialog() throws Exception {
		return ElementUtils.getElementByLocator(addToGroupDialog, 0);
	}

	public boolean isAddToGroupDialogElementDisplayed() {
		return Action.isElementDisplayedByLocator(addToGroupDialog, 0);
	}

	public void typeSearchCriteriaInAddToGroupDropdown(String searchValue) throws Exception {
		Action.clearTextInLocatorAndTypeText(addToGroupDropdown, searchValue);
		Waiters.waitForElementToBeInvisible(searchProgressLiner);
		Waiters.waitWithSleepTimeout(1000);
	}

	public String getAddToGroupDialogHeaderText() throws Exception {
		Waiters.waitForElementToBeDisplayed(addToGroupDialogHeader);
		return ElementUtils.getTextByLocator(addToGroupDialogHeader, 0);
	}

	public List<String> getSelectedGroupChipOptionTextList() throws Exception {
		Waiters.waitForElementToBeDisplayed(selectedGroupChipOption);
		List<WebElement> selectedGroupElements = ElementUtils.getElementListWithWaitByLocator(selectedGroupChipOption);

		return selectedGroupElements.stream().map(WebElement::getText)
				.map(groupText -> StringUtils.replaceAllStringForValue(groupText, "\ncancel", ""))
				.collect(Collectors.toList());
	}

	public void selectOptionFromDropdownByOptionName(String optionName) throws Exception {
		Action.clickByLocator(addToGroupDropdown, 0);
		Waiters.waitForElementToBeInvisible(dropdownOptionSpinner);
		List<WebElement> options = ElementUtils.getElementListWithWaitByLocator(addToGroupDropdownOption);

		for (WebElement option : options) {
			if (option.getText().trim().equals(optionName)) {
				Action.clickByLocator(option);
				break;
			}
		}

		Waiters.waitWithSleepTimeout(1000);
	}

	public void removeGroupByName(String groupName) throws Exception {
		Waiters.waitForElementToBeDisplayed(selectedGroupChipOption);
		List<WebElement> selectedGroups = ElementUtils.getElementListWithWaitByLocator(selectedGroupChipOption);

		for (int i = 0; i < selectedGroups.size(); i++) {
			String groupText = StringUtils.replaceAllStringForValue(selectedGroups.get(i).getText(), "\ncancel", "")
					.trim();
			if (groupText.equals(groupName)) {
				List<WebElement> removeButtons = ElementUtils
						.getElementListWithWaitByLocator(removeSelectedGroupChipButton);
				if (i < removeButtons.size()) {
					Action.clickByLocator(removeButtons.get(i));
					break;
				}
			}
		}
		Waiters.waitWithSleepTimeout(1000);
	}

	public List<String> getAddToGroupDropdownOptionTextList() throws Exception {
		Waiters.waitForElementToBeDisplayed(addToGroupDropdownOption);
		return ElementUtils.getElementListWithWaitByLocator(addToGroupDropdownOption).stream().map(WebElement::getText)
				.collect(Collectors.toList());
	}

	public void clickOnAddToGroupButton() throws Exception {
		Waiters.waitForElementToBeEnabled(addToGroupButton);
		Action.clickWithJSByLocator(addToGroupButton, 0);
		Waiters.waitForElementToBeInvisible(addToGroupButtonLoading);
	}

	public void clickOnCloseButton() throws Exception {
		Waiters.waitForElementToBeDisplayed(closeButton);
		Action.clickByLocator(closeButton, 0);
	}

	public void clickOnCancelButton() throws Exception {
		Waiters.waitForElementToBeDisplayed(cancelButton);
		Action.clickByLocator(cancelButton, 0);
	}
}