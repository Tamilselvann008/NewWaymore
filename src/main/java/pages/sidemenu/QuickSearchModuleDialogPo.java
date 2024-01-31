package pages.sidemenu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePo;
import helpers.Action;
import helpers.ElementUtils;
import helpers.StringUtils;
import helpers.Waiters;

public class QuickSearchModuleDialogPo extends BasePo {
	public QuickSearchModuleDialogPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    private By quickSearchModule = By.id("morphsearch");
    private By searchInput = By.cssSelector("#morphsearch #morphsearch-input");
    private By searchItemLink = By.cssSelector("#morphsearch .dummy-column__item a");
    private By noResultsMessage = By.cssSelector("#morphsearch .dummy-column h3");
    private By closeButton = By.cssSelector("#morphsearch .morphsearch-close");

    public WebElement getQuickSearchModule() throws Exception {
        Waiters.waitForElementToBeDisplayed(quickSearchModule);
        return ElementUtils.getElementWithWaitByLocator(quickSearchModule, 0);
    }

    public String getSearchItemLinkPreviewTextByName(String value) throws InterruptedException {
        List<WebElement> itemLinkTextList = ElementUtils.getElementListWithWaitByLocator(searchItemLink);
        for (int index = 0; index < itemLinkTextList.size(); index++) {
            String linkText = itemLinkTextList.get(index).getText().replaceAll("\\s\\s+", " ");
            if (StringUtils.getStringToUpperCase(linkText).equals(value)) {
                return itemLinkTextList.get(index).getAttribute("href");
            }
        }
        return null;
    }

    public boolean isQuickSearchModuleDisplayed() throws InterruptedException {
        return Action.isElementDisplayedByLocator(quickSearchModule, 0);
    }

    public void typeTextInSearchInput(String value) throws InterruptedException {
        Action.clearTextInLocatorAndTypeText(searchInput, value);
    }

    public boolean isSearchItemLinkDisplayed() throws InterruptedException {
        return Action.isElementDisplayedByLocator(searchItemLink, 0);
    }

    public void clickOnSearchItemLinkByName(String value) throws Exception {
        List<WebElement> itemLinkTextList = ElementUtils.getElementListWithWaitByLocator(searchItemLink);
        for (int index = 0; index < itemLinkTextList.size(); index++) {
            String linkText = itemLinkTextList.get(index).getText().replaceAll("\\s\\s+", " ");
            if (linkText.equals(value)) {
                Action.clickByLocator(searchItemLink, index);
                Waiters.waitForElementToBeInvisible(searchItemLink);
                break;
            }
        }
    }

    public void clickOnCloseButton() throws Exception {
        Action.clickByLocator(closeButton, 0);
        Waiters.waitForElementToBeInvisible(quickSearchModule);
    }

    public String getNoResultsMessageText() throws Exception {
        return ElementUtils.getTextByLocator(noResultsMessage, 0);
    }
}
