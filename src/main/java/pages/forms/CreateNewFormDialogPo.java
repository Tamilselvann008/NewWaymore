package pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePo;
import enums.uienums.HtmlEnums.AttributeEnum;
import helpers.Action;
import helpers.ElementUtils;
import helpers.Waiters;

public class CreateNewFormDialogPo extends BasePo {
	   public CreateNewFormDialogPo(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
    private By createFormDialog = By.cssSelector("#createForm-dialog");
    private By createFormDialogTitle = By.cssSelector("#createForm-dialog .header-title");
    private By formNameInput = By.cssSelector("#createForm-dialog input[name='formName']");
    private By formDescription = By.cssSelector("#createForm-dialog #createForm-desc");
    private By createFormButton = By.cssSelector("#createForm-dialog button[type='submit']");
    private By closeFormDialogButton = By.cssSelector("#createForm-dialog button[ng-click='ctrl.closeDialog()']");
    private By formNameWarning = By.cssSelector(".required p.text-danger");
    private By addFormCheckbox = By.cssSelector("[name='createForm'] md-checkbox");
    private By routeeContactContainer = By.cssSelector("md-dialog [ng-show='ctrl.routeeContact'] .border-grey");
    private By routeeContactMessage = By.cssSelector("md-dialog .row[ng-show='ctrl.routeeContact'] span");
    private By numberValidationMessage = By.cssSelector("md-dialog [ng-show='ctrl.numberValidation'] span");
    private By defaultGroupDropdown = By.cssSelector(".radio-option-box select[ng-model='ctrl.defaultGroup']");
    private By defaultGroupDropdownOption = By.xpath("//*[@id='createForm-dialog']/md-content//md-radio-group//select/option");
    private By selectedDefaultGroupDropdown = By.cssSelector(".radio-option-box select.form-control [selected='selected']");
    private By addNewGroupButton = By.cssSelector("button[ng-click*='addNewGroupEnabled = true']");
    private By groupNameInput = By.cssSelector("input[name='groupName']");
    private By saveNewGroupButton = By.cssSelector("button[ng-click*='saveNewGroupForm(newGroup)']");
    private By cancelAddNewGroupButton = By.cssSelector(".form-group button.md-warn");
    private By routeeContactTooltip = By.cssSelector("[name='createForm'] a.tooltip-routee-contact-check");
    private By rightPopupNotification = By.cssSelector("md-toast div.md-toast-content");

    private By radioButtonByLabel(String label) {
        return By.cssSelector("md-dialog md-radio-button[aria-label='" + label + "']");
    }

    public String getCreateFormDialogTitleText() throws Exception {
        return ElementUtils.getTextByLocator( createFormDialogTitle, 0);
    }

    public void waitForCreateFormDialogIsDisplayed() {
        Waiters.waitForElementToBeDisplayed(createFormDialog);
    }

    public boolean isCreateFormDialogElementDisplayed() {
        return Action.isElementDisplayedByLocator(createFormDialog, 0);
    }

    public boolean isRadioButtonByLabelChecked(String radioButtonLabel) {
        By radioButton = By.cssSelector("md-dialog md-radio-button[aria-label='" + radioButtonLabel + "']");
        return Action.isElementCheckedByLocator(radioButton);
    }

    public void typeNameInFormNameInputField(String value) throws InterruptedException {
        Action.clearTextInLocatorAndTypeText(formNameInput, value);
    }

    public void typeDescriptionInFormDescriptionTextarea(String value) throws InterruptedException {
        Action.clearTextInLocatorAndTypeText(formDescription, value);
    }

    public void typeValueInGroupNameInputField(String value) throws InterruptedException {
        Action.clearTextInLocatorAndTypeText(groupNameInput, value);
    }

    public void clearFormNameInputField() {
        Action.clearTextInLocator(formNameInput, 0);
    }

    public void clickOnCreateFormButton() throws Exception {
        Action.clickByLocator( createFormButton, 0);
        Waiters.waitForElementToBeVisible(rightPopupNotification);
        Waiters.waitWithSleepTimeout(1000);
    }

    public WebElement isCreateFormButtonEnabled() throws Exception {
        return ElementUtils.getElementByLocator(createFormButton, 0);
    }

    public void clickOnAddNewGroupButton() throws Exception {
        Action.clickByLocator(addNewGroupButton, 0);
        Waiters.waitForElementToBeDisplayed(groupNameInput);
    }

    public void clickOnSaveNewGroupButton() throws Exception {
        Action.clickByLocator(saveNewGroupButton, 0);
        Waiters.waitWithSleepTimeout(1500);
    }

    public void clickOnCancelAddNewGroupButton() throws Exception {
        Action.clickByLocator(cancelAddNewGroupButton, 0);
        Waiters.waitForElementToBeInvisible(cancelAddNewGroupButton);
    }
    public void mouseMoveToRouteeContactTooltipIcon() throws Exception {
        Waiters.waitForElementToBeDisplayed(routeeContactTooltip);
        Action.moveMouseToElementByLocator(routeeContactTooltip, 0);
    }

    public String getRouteeContactsTooltipText() throws Exception {
        Waiters.waitForElementToBeDisplayed(routeeContactTooltip);
        return ElementUtils.getAttributeByLocator(routeeContactTooltip, AttributeEnum.Title.getValue(), 0);
    }

    public void clickOnCloseFormDialogButton() throws Exception {
        Action.clickByLocator(closeFormDialogButton, 0);
        Waiters.waitWithSleepTimeout(1000);
    }

    public WebElement getFormNameWarning() throws Exception {
        return ElementUtils.getElementWithWaitByLocator(formNameWarning, 0);
    }

    public WebElement getAddNewGroupButton() throws Exception {
        return ElementUtils.getElementWithWaitByLocator(addNewGroupButton, 0);
    }

    public String getFormNameWarningText() throws Exception {
        return ElementUtils.getTextByLocator(formNameWarning, 0);
    }

    public void clickOnAddFormCheckbox() throws Exception {
        Action.clickByLocator(addFormCheckbox, 0);
    }

    public WebElement getRouteeContactContainer() throws Exception {
        return ElementUtils.getElementWithWaitByLocator(routeeContactContainer, 0);
    }

    public String getRouteeContactMessageText() throws Exception {
        return ElementUtils.getTextByLocator(routeeContactMessage, 0);
    }

    public String getSelectedDefaultGroupDropdownText() throws Exception {
        Waiters.waitForElementToBeDisplayed(selectedDefaultGroupDropdown);
        return ElementUtils.getTextByLocator(selectedDefaultGroupDropdown, 0);
    }

    public void clickOnRadioButtonByLabel(String label) throws Exception {
        Action.clickByLocator(radioButtonByLabel(label), 0);
    }

    public String getNumberValidationMessageText() throws Exception {
        return ElementUtils.getTextByLocator(numberValidationMessage, 0);
    }

    public void selectOptionFromDropdownByNumber(int index) {
        Waiters.waitForElementToBeDisplayed(defaultGroupDropdown);
        Action.clickByLocator(defaultGroupDropdown, index);
        WebElement optionElement = ElementUtils.getElementByLocator(defaultGroupDropdownOption, index);
        // Assuming 'localStorage' is managed internally within your framework
        localStorage.setItem("defaultGroup", ElementUtils.getTextByLocator(defaultGroupDropdownOption, index));
        Action.clickByLocator(optionElement);
        Action.clickByLocator(defaultGroupDropdown, index);
    }


}
