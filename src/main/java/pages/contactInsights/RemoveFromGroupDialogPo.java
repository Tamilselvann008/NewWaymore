package pages.contactInsights;

import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.StringUtils;
import helpers.Waiters;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import actions.Action;

public class RemoveFromGroupDialogPo extends BasePo {
	 public RemoveFromGroupDialogPo(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
    private By removeFromGroupDialog = By.cssSelector("mat-dialog-container [role='dialog']");
    private By removeFromGroupDialogHeader = By.cssSelector("mat-dialog-container [role='dialog'] .wm-dialog__header div");
    private By removeFromGroupButton = By.cssSelector(".wm-dialog__actions wm-progress-button button");
    private By removeFromGroupButtonLoading = By.cssSelector("mat-progress-bar[role='progressbar']");
    private By selectedGroupChipOption = By.cssSelector(".wm-dialog__body mat-chip-list[aria-disabled='false'] mat-chip");
    private By removeFromGroupDropdown = By.cssSelector("mat-form-field mat-chip-list input");
    private By removeFromGroupDropdownOption = By.cssSelector(".mat-autocomplete-visible mat-option");
    private By closeButton = By.cssSelector(".contacts-dialog__add-to-group .wm-dialog-close");
    private By cancelButton = By.cssSelector(".wm-dialog__actions .wm-btn.wm-btn--simple.wm-btn--small");

    public WebElement getRemoveFromGroupDialog() throws Exception {
        return ElementUtils.getElementWithWaitByLocator(removeFromGroupDialog, 0);
    }

    public boolean isRemoveFromGroupDialogElementDisplayed() throws Exception {
        return Action.isElementExistingByLocator(removeFromGroupDialog);
    }

    public String getRemoveFromGroupHeaderText() throws Exception {
        Waiters.waitForElementToBeDisplayed(removeFromGroupDialogHeader);
        return ElementUtils.getTextByLocator(removeFromGroupDialogHeader, 0);
    }

    public void clickOnRemoveFromGroupButton() throws Exception {
        Waiters.waitForElementToBeClickable(removeFromGroupButton);
        Action.clickByLocator(removeFromGroupButton, 0);
        Waiters.waitForElementToBeNotVisible(removeFromGroupButtonLoading);
    }

    public List<String> getSelectedGroupChipOptionTextList() throws Exception {
        Waiters.waitForElementToBeDisplayed(selectedGroupChipOption);
        List<WebElement> elements = driver.findElements(selectedGroupChipOption);
        return elements.stream()
                       .map(WebElement::getText)
                       .map(text -> StringUtils.replaceAllStringForValue(text, "\ncancel", ""))
                       .collect(Collectors.toList());
    }

    public void selectOptionFromDropdownByOptionName(String optionName) throws Exception {
        Waiters.waitForElementToBeDisplayed(removeFromGroupDropdown);
        Action.clickByLocator(removeFromGroupDropdown, 0);
        Waiters.waitWithSleepTimeout(1000);// This is generally discouraged; use explicit waits instead.
        Waiters.waitForElementToBeClickable(removeFromGroupDropdownOption);
        List<WebElement> options = driver.findElements(removeFromGroupDropdownOption);
        
        for (WebElement option : options) {
            if (StringUtils.getStringByTrim(option.getText()).equals(optionName)) {
                option.click();
                break;
            }
        }
        Thread.sleep(1500); // Again, better to use explicit waits.
        Waiters.waitForElementToBeDisplayed(selectedGroupChipOption);
    }
    public void clickOnCloseButton() throws Exception {
        Waiters.waitForElementToBeDisplayed(closeButton);
        Action.clickByLocator(closeButton, 0);
        Waiters.waitForElementToBeNotVisible(closeButton);
    }

    public void clickOnCancelButton() throws Exception {
        Waiters.waitForElementToBeDisplayed(cancelButton);
        Action.clickByLocator(cancelButton, 0);
    }
}
