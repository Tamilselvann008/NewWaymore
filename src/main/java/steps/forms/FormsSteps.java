package steps.forms;

import java.util.List;

import basePackage.BasePo;
import basePackage.CommonButtonsPo;
import enums.uienums.ActionEnum;
import enums.uienums.ActionEnum.ActionModeTypeEnum;
import enums.uienums.PopupsEnum.FormsPopupStatusEnum;
import helpers.Action;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.DateUtils;
import helpers.LocalStorage;
import helpers.StepUtils;
import helpers.StringUtils;
import helpers.Waiters;
import pages.forms.FormsPo;

public class FormsSteps extends BasePo {

    private static final String Disabled = "disabled";
	private static final String Enabled = "enabled";
	private FormsPo formsPo = new FormsPo(driver);
    private CommonButtonsPo commonButtonsPo = new CommonButtonsPo(driver);

    public void whenTheUserClicksOnTheAddNewItemIcon() throws Exception {
        formsPo.clickOnAddNewItemIcon();
    }

    public void whenTheUserClicksOnTheSearchIcon() throws Exception {
        formsPo.clickOnSearchIcon();
    }

    public void whenTheUserClicksOnTheClearIcon() throws Exception {
        formsPo.clickOnCancelSearchIcon();
    }

    public void whenTheUserClicksToTheLastPageWithForms() throws Exception {
        formsPo.clickOnLastPaginationLink();
    }

    public void whenTheUserNavigatesToTheFormPageTab() {
        Action.switchToHandleByTabNumber(1);
        Waiters.waitUntilURLContains(DataProviders.getUrlTestData("waymorePageUrl") + "forms");
    }

    public void whenTheUserClicksOnTheMenuDropdownOfTheFormNumber(int formIndex) throws Exception {
        String formName = DataProviders.getFormTestData("value", formIndex);
        StepUtils.addLog("The user clicks on the dropdown of the form by name '" + formName + "'");
        formsPo.clickOnFormMenuDropdownByFormName(formName);
    }

    public void whenTheUserSelectsTheDeleteEditCloneViewPublishUnpublishOptionFromTheDropdownOfTheFormNumber(String option, int formIndex) throws Exception {
        String formName = DataProviders.getFormTestData("value", formIndex);
        StepUtils.addLog("The user selects '" + option + "' option from the dropdown of the form name '" + formName + "'");
        formsPo.selectFormMenuOptionFromDropdownByOptionName(formName, StringUtils.getStringToLowerCase(option));
    }

    public void whenTheUserDeletesAllFormsFromTheLastPage() throws Exception {
        formsPo.deleteAllFormsFromPage();
    }

    public void whenTheUserEntersTheValueInTheSearchBox(String value) throws InterruptedException {
        formsPo.typeValueInSearchInputField(value);
    }

    public void whenTheUserStoresTheDataOfExistingForms() throws Exception {
        List<String> formNameList = formsPo.getFormItemNameTextList();
        LocalStorage.setItem("formNameListData", formNameList);
    }

    public void thenTheFormTopBarIsDisplayed() throws InterruptedException {
        Assertions.expectToBeTrue(formsPo.isFormTopBarElementDisplayed(), "The Form top bar is not displayed");
    }

    public void thenTheTabLinkIsDisplayed(String tab) throws Exception {
        Assertions.expectToEqual(formsPo.getFormTabLinkText(), tab, "The '" + tab + "' tab is not displayed");
    }

    public void thenTheUserIsRedirectedToTheFormPage() {
        String url = driver.getCurrentUrl();
        Assertions.expectToEqual(url, DataProviders.getUrlTestData("waymorePageUrl") + "forms", "The user is not on the Forms page");
    }

    // ... More methods ...

    public void thenTheCreatedFormNumberIsNotDisplayed(int formIndex) throws Exception {
        String formName = DataProviders.getFormTestData("value", formIndex);
        List<String> formList = formsPo.getFormItemNameTextList();
        if (formList != null) {
            Assertions.expectToNotInclude(formList, formName, "The created Form Item is displayed");
        } else {
            Assertions.expectToBeFalse(formsPo.isFormItemNameDisplayed(), "The created Form Item is displayed");
        }
    }

    public void thenTheCreatedFormNumberIsDeleted(int formIndex) throws Exception {
        String formName = DataProviders.getFormTestData("value", formIndex);
        List<String> formNameList = formsPo.getFormItemNameTextList();
        if (formNameList != null) {
            Assertions.expectToNotInclude(formNameList, formName, "The created Form is not deleted");
        }
    }
    
    public void thenTheUserCanSeeANotificationAboutTheCreatedForm() throws Exception {
        Assertions.expectToEqual(commonButtonsPo.getLeftPopupNotificationText(), FormsPopupStatusEnum.FormSaved, "The notification about the created form is incorrect");
    }

    public void thenTheUserCanSeeANotificationAboutNewGroupCreated(String newGroupName) throws Exception {
        Assertions.expectToInclude(formsPo.getRightPopupNotificationText(), "Your new group " + newGroupName + " has been created!",
            "The notification about the created new Group is incorrect");
        formsPo.clickOnCloseNotificationButton();
    }

    public void thenTheCreatedEditedClonedFormNumberIsDisplayed(String option, int formIndex) throws Exception {
        String formName = DataProviders.getFormTestData("value", formIndex);;
        Assertions.expectToInclude(formsPo.getFormItemNameTextList(), formName, "The '" + option + "' Form is not displayed");
    }

    public void thenTheCorrectDateOfTheCreatedFormNumberIsDisplayed(int formIndex) throws Exception {
        String formName = DataProviders.getFormTestData("value", formIndex);;
        String formDate = DateUtils.getCurrentDate("YYYY-MM-DD");
        Assertions.expectToInclude(formsPo.getFormCreatedDateByFormName(formName), "Last Update: " + formDate,
            "The date of created Form '" + formName + "' is incorrect");
    }

    // ... More methods ...

    public void thenThePublishedFormNumberIsDisplayedInANewBrowserTab(int formIndex) throws InterruptedException {
        String isPublishedFlag = LocalStorage.getItem("isPublishedFlag");
        String formName = DataProviders.getFormTestData("Value", formIndex);
        Waiters.waitForTabsCount();
        Action.switchToHandleByTabNumber(2);
        String title = driver.getTitle();
        Assertions.expectToEqual(title, formName, "The published Form title is incorrect");

        if ("true".equals(isPublishedFlag)) {
            String publishedFormLinkValue = LocalStorage.getItem("publishedFormLinkValue");
            String url = driver.getCurrentUrl();
            Assertions.expectToEqual(url, "http://" + publishedFormLinkValue, "The published Form link is incorrect");
        }
    }

    public void thenTheUserIsOnTheFormPage(String title) {
        String currentTitle = driver.getTitle();
        
        String currentUrl = driver.getCurrentUrl ();
        Assertions.expectToEqual(currentTitle, title, "The user is not on the '" + title + "' Form page");
        Assertions.expectToInclude(currentUrl, "dev-wayforms.int.amdtelecom.net/", "The URL of the '" + title + "' Form page is incorrect");
    }

    public void thenTheViewPublishOptionInTheFormMenuDropdownIsDisabledEnabled(String optionName, String mode) throws Exception {
        switch (mode) {
            case Disabled:
                Assertions.expectToBeDisabled(formsPo.getFromDropdownOptionByOptionName(optionName), "The '" + optionName + "' option is enabled");
                break;
            case Enabled:
                Assertions.expectToBeEnabled(formsPo.getFromDropdownOptionByOptionName(optionName), "The '" + optionName + "' option is disabled");
                break;
        }
    }
}

