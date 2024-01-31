package pages.contactInsights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePo;
import helpers.Waiters;
import helpers.Action;
import helpers.ElementUtils;

public class ChannelPreferencesDialogPo extends BasePo {
    private By channelPreferencesDialog = By.cssSelector("mat-dialog-container[role='dialog']");
    private By channelPreferencesDialogWarning = By.cssSelector("mat-dialog-container .wm-dialog__body div");
    private By channelPreferencesDialogWarningIcon = By.cssSelector("mat-dialog-container .wm-dialog-warning__icon");
    private By noExitButton = By.cssSelector("button.wm-dialog__btn.wm-dialog__btn--simple");
    private By yesContinueButton = By.cssSelector("mat-dialog-actions button:nth-child(2)");
    private By closeButton = By.cssSelector("button.wm-dialog__close");
    private By contactInfoGroup = By.cssSelector(".contact-info__groups + .ng-star-inserted");

    public ChannelPreferencesDialogPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

    public WebElement getChannelPreferenceDialog() throws Exception {
        return ElementUtils.getElementByLocator(channelPreferencesDialog, 0);
    }

    public boolean isYesContinueButtonDisabled() throws Exception {
        String isDisabled = ElementUtils.getAttributeByLocator(yesContinueButton, "disabled", 0);
        return "true".equals(isDisabled);
    }

    public boolean isChannelPreferencesDialogDisplayed() throws Exception {
        return Action.isElementDisplayedByLocator(channelPreferencesDialog, 0);
    }

    public boolean isChannelPreferencesDialogWarningIconDisplayed() throws Exception {
        return Action.isElementDisplayedByLocator(channelPreferencesDialogWarningIcon, 0);
    }

    public String getChannelPreferencesDialogWarningText() throws Exception {
        return ElementUtils.getTextByLocator(channelPreferencesDialogWarning, 0);
    }

    public void clickOnNoExitButton() throws Exception {
        Action.clickByLocator(noExitButton, 0);
    }

    public void clickOnCloseButton() throws Exception {
        Action.clickByLocator(closeButton, 0);
    }

    public String getContactInfoGroupText() throws Exception {
        Waiters.waitForElementToBeDisplayed(channelPreferencesDialogWarningIcon);
        return ElementUtils.getTextByLocator(contactInfoGroup, 0);
    }
}
