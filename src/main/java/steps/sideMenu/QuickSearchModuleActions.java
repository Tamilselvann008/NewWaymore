package steps.sideMenu;

import basePackage.BasePo;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.StringUtils;
import pages.sidemenu.QuickSearchModuleDialogPo;

public class QuickSearchModuleActions extends BasePo{

    private static final String NumberValidation = "Number Validation";
	private static final String EmailValidation = "Email Validation";
	private static final String NumberLookup = "Number Lookup";
	private QuickSearchModuleDialogPo quickSearchModuleDialogPo = new QuickSearchModuleDialogPo(driver);

    public void whenTheUserTypesTheSearchValueInSearchInputFieldInTheQuickSearchModuleDialog(String searchValue) throws InterruptedException {
        quickSearchModuleDialogPo.typeTextInSearchInput(searchValue);
    }

    public void whenTheUserClicksOnItemInTheQuickSearchModuleDialog(String searchValue) throws Exception {
        quickSearchModuleDialogPo.clickOnSearchItemLinkByName(StringUtils.getStringToUpperCase(searchValue));
    }

    public void whenTheUserClicksOnTheCloseButtonInTheQuickSearchModuleDialog() throws Exception {
        quickSearchModuleDialogPo.clickOnCloseButton();
    }

    public void thenTheQuickSearchModuleIsDisplayed() throws Exception {
        Assertions.expectToDisplay(quickSearchModuleDialogPo.getQuickSearchModule(), "The Quick Search Module is not displayed");
    }

    public void thenTheQuickSearchModuleIsNotDisplayed() throws InterruptedException {
        Assertions.expectToBeFalse(quickSearchModuleDialogPo.isQuickSearchModuleDisplayed(), "The Quick Search Module is displayed");
    }

    public void thenTheSearchResultsAreDisplayedInTheQuickSearchModuleDialog() throws InterruptedException {
        Assertions.expectToBeTrue(quickSearchModuleDialogPo.isSearchItemLinkDisplayed(), "The search results are not displayed in the Quick Search Module dialog");
    }

    public void thenTheSearchResultsAreNotDisplayedInTheQuickSearchModuleDialog() throws InterruptedException {
        Assertions.expectToBeFalse(quickSearchModuleDialogPo.isSearchItemLinkDisplayed(), "The search results are displayed in the Quick Search Module dialog");
    }

    public void thenTheMessageNoResultsIsDisplayedInTheQuickSearchModuleDialog(String message) throws Exception {
        String warningMessage = quickSearchModuleDialogPo.getNoResultsMessageText();
        Assertions.expectToEqual(StringUtils.getStringByTrim(warningMessage), StringUtils.getStringToUpperCase(message) + "...",
            "The message '" + message + "' is not displayed in the Quick Search Module dialog");
    }

    public void thenTheSearchResultContainsRedirectLinkToRouteeNumberValidationNumberLookupEmailValidationPage(String searchValue) throws InterruptedException {
        String searchResultLink;
        switch (searchValue) {
            case NumberValidation:
                searchResultLink = DataProviders.getUrlTestData("numberValidatorUrl");
                break;
            case NumberLookup:
                searchResultLink = DataProviders.getUrlTestData("numberLookupUrl");
                break;
            case EmailValidation:
                searchResultLink = DataProviders.getUrlTestData("emailValidatorUrl");
                break;
            default:
                throw new IllegalArgumentException("Invalid search value");
        }
        Assertions.expectToEqual(quickSearchModuleDialogPo.getSearchItemLinkPreviewTextByName(searchValue), searchResultLink,
            "The search result doesn't contain redirect link to Routee '" + searchValue + "' page");
    }
}
