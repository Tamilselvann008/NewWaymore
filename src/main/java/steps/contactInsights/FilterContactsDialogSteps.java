package steps.contactInsights;

import basePackage.BasePo;
import helpers.Assertions;
import helpers.StepUtils;
import pages.contactInsights.FilterContactsDialogPo;

public class FilterContactsDialogSteps extends BasePo{

    private FilterContactsDialogPo filterContactsDialogPo = new FilterContactsDialogPo(driver);

    public void whenTheUserClicksOnABackgroundOutsideOfTheFilterDialog() throws Exception {
        filterContactsDialogPo.clickOnBackgroundOutsideDialog();
    }

    public void whenTheUserClicksOnTheCloseButtonInTheFilterDialog() throws Exception {
        filterContactsDialogPo.clickOnCloseButton();
        StepUtils.addLog(" the user clicks on the Close button in the Filter dialog");
    }
    
    public void whenTheUserClicksOnTheFirstNameLastNameEmailGroupCountryMobileChannelPreferencesSegmentDropdownInTheFilterDialog(String labelName) throws Exception {
        filterContactsDialogPo.clickOnFilterDropdownByName(labelName);
        StepUtils.addLog("the user clicks on the "+labelName+" dropdown in the Filter dialog");
    }
    public void whenTheUserChecksUnchecksTheCheckboxInTheOptionInTheExpandedDropdownInTheFilterDialog(String checkboxStatus, String option) throws Exception {
        StepUtils.addLog("the user "+checkboxStatus+" the checkbox in the "+option+" option in the expanded dropdown in the Filter dialog");
        filterContactsDialogPo.selectCheckboxByStatusAndOptionName(checkboxStatus, option);
    }
    
    public void whenTheUserClicksOnTheSearchButtonInTheFilterDialog() throws Exception {
        filterContactsDialogPo.clickOnSearchButton();
        StepUtils.addLog("the user clicks on the Search button in the Filter dialog");
    }
    // ... Other "When" methods ...
    public void thenTheFilterContactsDialogIsDisplayed() throws Exception {
        Assertions.expectToBeTrue(filterContactsDialogPo.isFilterContactsDialogDisplayed(), "The Filter Contacts dialog is not displayed");
        Assertions.expectToEqual(filterContactsDialogPo.getFilterContactsDialogTitleText(), "Filter Contacts", "The Filter Contacts dialog title is incorrect");
    }
    
    public void thenTheFilterContactsDialogIsNotDisplayed() throws Exception {
        Assertions.expectToBeFalse(filterContactsDialogPo.isFilterContactsDialogDisplayed(), "The Filter Contacts dialog is displayed");
    StepUtils.addLog("the Filter Contacts dialog is not displayed");
    }

    public void thenTheOptionIsSelectedInTheDropdownOptionsListInTheFilterDialog(String option) throws Exception {
        Assertions.expectToBeTrue(filterContactsDialogPo.isOptionByNameSelectedInDropdownOptionsList(option),
            "The '" + option + "' option is not selected in the dropdown options list in the Filter dialog");
        StepUtils.addLog("the "+option+" option is selected in the dropdown options list in the Filter dialog");
    }
    
    public void thenTheOptionAppearsSelectedInTheFirstNameLastNameEmailGroupCountryMobileSegmentChannelPreferencesFilterInTheFilterDialog(String option, String dropdownName) throws Exception {
        Assertions.expectToInclude(filterContactsDialogPo.getSelectedOptionByDropdownNameTextList(dropdownName), option,
            "The '" + option + "' option does not appear as selected in the '" + dropdownName + "' filter in the Filter dialog");
        StepUtils.addLog("the "+option+" option appears selected in the "+dropdownName+" filter in the Filter dialog");
    }

    public void thenTheOptionIsNotSelectedInTheDropdownOptionsListInTheFilterDialog(String option) throws Exception {
        Assertions.expectToBeFalse(filterContactsDialogPo.isOptionByNameSelectedInDropdownOptionsList(option),
            "The '" + option + "' option is selected in the dropdown options list in the Filter dialog");
        StepUtils.addLog("the "+option +" option is not selected in the dropdown options list in the Filter dialog");
    }
    public void thenTheOptionDoesNotAppearAsSelectedInTheFirstNameGroupFilterInTheFilterDialog(String option, String dropdownName) throws Exception {
        Assertions.expectToNotInclude(filterContactsDialogPo.getSelectedOptionByDropdownNameTextList(dropdownName), option,
            "The '" + option + "' option appears selected in the '" + dropdownName + "' filter in the Filter dialog");
        StepUtils.addLog("the "+option+" option does not appear as selected in the "+dropdownName+" filter in the Filter dialog");
    }
    // ... Other "Then" methods ...

    public void whenTheUserClicksOnTheCloseIconInTheSelectedOptionInTheFirstNameFilterInTheFilterDialog(String option, String dropdownName) throws Exception {
        filterContactsDialogPo.clickOnCloseIconInSelectedOptionByDropdownAndOptionName(dropdownName, option);
        StepUtils.addLog("the user clicks on the Close icon in the selected "+option+" option in the "+dropdownName+" filter in the Filter dialog");
    }

    public void whenTheUserCollapsesTheExpandedDropdownInTheFilterDialog() throws Exception {
        filterContactsDialogPo.clickOnFilterContactsDialog();
        StepUtils.addLog("the user collapses the expanded dropdown in the Filter dialog");
        
    }
    
    public void thenTheSearchButtonIsDisabledEnabledInTheFilterDialog(String mode) throws Exception {
        if (mode.equals("disabled")) {
            Assertions.expectToBeTrue(filterContactsDialogPo.isSubmitButtonDisabled(), "The Search button is enabled");
            StepUtils.addLog("the Search   button is enabled in the Filter dialog");
        } else if (mode.equals("enabled")) {
            Assertions.expectToBeFalse(filterContactsDialogPo.isSubmitButtonDisabled(), "The Search button is disabled");
            StepUtils.addLog("the Search   button is disabled in the Filter dialog");
        }
    }

    // ... Remaining methods ...

}
