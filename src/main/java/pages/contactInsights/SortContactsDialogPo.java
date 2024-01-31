package pages.contactInsights;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePo;
import helpers.Action;
import helpers.ElementUtils;
import helpers.Waiters;

public class SortContactsDialogPo extends BasePo {

	public SortContactsDialogPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private By sortContactsDialog = By.cssSelector("mat-dialog-container[role='dialog']");
	private By conditionVariableDropdownOption = By.cssSelector("[role='listbox'] mat-option");
	private By conditionVariableDropdown = By.cssSelector(".sort-contacts-dialog__sort-item > mat-select:nth-child(2)");
	private By conditionSortTypeDropdown = By.cssSelector(".sort-contacts-dialog__sort-item > mat-select:nth-child(3)");
	private By closeButton = By.cssSelector(".sort-contacts-dialog__header button");
	private By addSortButton = By.cssSelector("button.sort-contacts-dialog__add-btn");
	private By conditionRow = By.cssSelector("[ng-repeat*='condition']");
	private By deleteSortConditionButton = By.cssSelector(".sort-contacts-dialog__sort-item > button");
	private By conditionSortTypeDropdownOption = By.cssSelector(".mat-select-panel-wrap mat-option");

	public boolean isSortContactsDialogDisplayed() throws Exception {
		return Action.isElementDisplayedByLocator(sortContactsDialog, 0);
	}

	public void waitForSortContactsDialogIsDisplayed() throws Exception {
		Waiters.waitForElementToBeDisplayed(sortContactsDialog);
	}

	public List<String> getConditionVariableDropdownOptionTextList() throws Exception {
		return ElementUtils.getTextListByLocator(conditionVariableDropdownOption);
	}

	public void clickOnConditionVariableDropdown() throws Exception {
		Action.clickByLocator(conditionVariableDropdown, 0);
	}

	public void clickOnCloseButton() throws Exception {
		Action.clickByLocator(closeButton, 0);
	}

	public void selectSortTypeDropdownOptionByNameAndRowIndex(String optionName) throws Exception {
		Action.selectOptionFromDropdownByOptionName(conditionSortTypeDropdown, conditionSortTypeDropdownOption,
				optionName);
	}

	public void selectVariableDropdownOptionByNameAndRowIndex(String optionName) throws Exception {
		Action.selectOptionFromDropdownByOptionName(conditionVariableDropdown, conditionVariableDropdownOption,
				optionName);
	}

	public String getConditionVariableDropdownTextByRowIndex(int rowIndex) throws Exception {
		return ElementUtils.getTextByLocator(conditionVariableDropdown, rowIndex);
	}

	public String getConditionSortTypeDropdownTextByRowIndex(int rowIndex) throws Exception {
		return ElementUtils.getTextByLocator(conditionSortTypeDropdown, rowIndex);
	}

	public void clickOnAddSortButton() throws Exception {
		Action.clickByLocator(addSortButton, 0);
	}

	public int getSortConditionsAmount() throws Exception {
		return ElementUtils.getElementListCountByLocator(conditionRow);
	}

	public void clickOnDeleteSortConditionButtonByRowIndex() throws Exception {
		Action.clickByLocator(deleteSortConditionButton, 0);
	}
}
