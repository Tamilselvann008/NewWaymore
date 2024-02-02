package steps.forms;

import basePackage.BasePo;
import enums.uienums.NotificationEnums.FormDialogMessageEnum;
import enums.uienums.ToolTipsEnum.FormsTooltipEnum;
import helpers.Assertions;
import helpers.DataProviders;
import pages.forms.CreateNewFormDialogPo;

public class CreateNewFormDialogSteps extends BasePo{

    private CreateNewFormDialogPo createNewFormDialogPo = new CreateNewFormDialogPo(driver);

    public void whenTheUserClicksOnTheCreateFormButton() throws Exception {
        createNewFormDialogPo.clickOnCreateFormButton();
    }

    public void whenTheUserClicksOnTheCloseFormDialogButton() throws Exception {
        createNewFormDialogPo.clickOnCloseFormDialogButton();
    }

    public void whenTheUserClicksOnTheCancelAddNewGroupButtonInTheCreateFormDialog() throws Exception {
        createNewFormDialogPo.clickOnCancelAddNewGroupButton();
    }

    public void whenTheUserClicksOnTheAddNewGroupButton() throws Exception {
        createNewFormDialogPo.clickOnAddNewGroupButton();
    }

    public void whenTheUserHoversOverTheRouteeContactTooltipIconInTheCreateFormDialog() throws Exception {
        createNewFormDialogPo.mouseMoveToRouteeContactTooltipIcon();
    }

    public void whenTheUserTypesANewGroupNameInTheGroupNameInputField(String groupName) throws InterruptedException {
        createNewFormDialogPo.typeValueInGroupNameInputField(groupName);
    }

    public void whenTheUserClicksOnTheSaveGroupNameButton() throws Exception {
        createNewFormDialogPo.clickOnSaveNewGroupButton();
    }

    public void whenTheUserTypesAFormNameInTheInputField(int index) throws InterruptedException {
        String formName = DataProviders.getFormTestData("value", index);
        createNewFormDialogPo.typeNameInFormNameInputField(formName);
    }

    public void whenTheUserClearsAFormNameInTheInputField() {
        createNewFormDialogPo.clearFormNameInputField();
    }

    public void whenTheUserTypesAFormDescriptionInTheTextarea(int index) throws InterruptedException {
        String formDescription = DataProviders.getFormTestData("description",index);
        createNewFormDialogPo.typeDescriptionInFormDescriptionTextarea(formDescription);
    }

    public void whenTheUserChecksTheCheckboxToAddSubmittedFormsAsRouteeContacts() throws Exception {
        createNewFormDialogPo.clickOnAddFormCheckbox();
    }

    public void whenTheUserSelectsEnableNumberValidationServiceRadioButtonInCreateNewFormDialog(String radioButton) throws Exception {
        createNewFormDialogPo.clickOnRadioButtonByLabel(radioButton);
    }

    public void whenTheUserSelectsOptionInDefaultGroupDropdownInCreateNewFormDialog(int indexValue) {
        createNewFormDialogPo.selectOptionFromDropdownByNumber(indexValue);
    }
 // Continuing from the previous methods...

    public void thenTheCreateNewFormDialogIsDisplayed() {
        Assertions.expectToBeTrue(createNewFormDialogPo.isCreateFormDialogElementDisplayed(),
            "The Create New Form dialog is not displayed");
    }

    public void thenTheWarningThatTheFormNameFieldIsRequiredIsDisplayedInTheDialog() throws Exception {
        Assertions.expectToDisplay(createNewFormDialogPo.getFormNameWarning(),
            "The Warning message is not displayed");
        Assertions.expectToEqual(createNewFormDialogPo.getFormNameWarningText(),
            FormDialogMessageEnum.FormNameRequired, "The Warning message is incorrect");
    }

    public void thenTheCreateNewFormDialogIsNotDisplayed() {
        Assertions.expectToBeFalse(createNewFormDialogPo.isCreateFormDialogElementDisplayed(),
            "The Create New Form dialog is displayed");
    }

    public void thenTheCreateNewFormDialogTitleIsCorrect(String title) throws Exception {
        Assertions.expectToInclude(createNewFormDialogPo.getCreateFormDialogTitleText(),
            title, "The '" + title + "' dialog title is incorrect");
    }

    public void thenTheFormGroupForTheRouteeContactsIsDisplayed() throws Exception {
        Assertions.expectToDisplay(createNewFormDialogPo.getRouteeContactContainer(),
            "The form group for the Routee contacts is not displayed");
    }

    public void thenTheFormGroupRadioButtonIsChecked(String radioButton) {
        Assertions.expectToBeTrue(createNewFormDialogPo.isRadioButtonByLabelChecked(radioButton),
            "The form group radio button is not checked");
    }

    public void thenTheUserCanSeeAMessageThatAPhoneFormElementWillBeAddedToTheForm() throws Exception {
        Assertions.expectToEqual(createNewFormDialogPo.getRouteeContactMessageText(),
            FormDialogMessageEnum.PhoneFormElement,
            "The message that a phone form element will be added to the form is not displayed");
    }

    public void thenTheUserCanSeeAWarningMessageAboutEnablingNumberValidationService() throws Exception {
        Assertions.expectToEqual(createNewFormDialogPo.getNumberValidationMessageText(),
            FormDialogMessageEnum.EnablingNumberValidationService,
            "The warning message about enabling number validation service is not displayed");
    }

    public void thenTheAddNewGroupButtonIsDisplayed() throws Exception {
        Assertions.expectToDisplay(createNewFormDialogPo.getAddNewGroupButton(),
            "The Add New Group button is not displayed");
    }

    public void thenTheDefaultGroupInTheCreateFormDialogIsNotSelected() throws Exception {
        String defaultGroup = createNewFormDialogPo.getSelectedDefaultGroupDropdownText();
        Assertions.expectToEqual(defaultGroup, "",
            "The Default Group is not empty");
    }

    public void thenTheCreatedGroupIsDisplayedAsSelectedInTheDefaultGroupDropdown(String groupName) throws Exception {
        String defaultGroup = createNewFormDialogPo.getSelectedDefaultGroupDropdownText();
        Assertions.expectToEqual(defaultGroup, groupName,
            "The Default Group is empty");
    }

    public void thenTheCreateFormButtonIsDisabled() throws Exception {
        Assertions.expectToBeDisabled(createNewFormDialogPo.isCreateFormButtonEnabled(),
            "The Create Form button is enabled");
    }

    public void thenTheUserCanSeeTheTooltipTextOfTheRouteeContactsInTheCreateNewFormDialog() throws Exception {
        String popOverContent = createNewFormDialogPo.getRouteeContactsTooltipText();
        Assertions.expectToEqual(popOverContent, FormsTooltipEnum.AllFormFields,
            "The tooltip text of the Routee Contacts in the Create New form dialog is incorrect");
    }

    // Other methods...
}

    
