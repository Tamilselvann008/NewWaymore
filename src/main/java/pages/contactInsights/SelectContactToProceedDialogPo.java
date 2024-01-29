package pages.contactInsights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePackage.BasePo;
import helpers.Waiters;
import helpers.ElementUtils;

public class SelectContactToProceedDialogPo extends BasePo {
    private ContactInsightsPo contactInsightsPo = new ContactInsightsPo(driver);
    public SelectContactToProceedDialogPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

    private By dialogWarning = By.cssSelector(".wm-dialog__body div");
    private By okButton = By.cssSelector("mat-dialog-actions .wm-dialog__btn");

    public void clickOnOkButton() throws Exception {
        Waiters.waitForElementToBeClickable(okButton);
        Waiters.waitForElementToBeDisplayed(okButton);
        Action.clickByLocator(okButton, 0);
        contactInsightsPo.waitForTableLoaderIsNotDisplayed();
    }

    public String getDialogWarningText() throws Exception {
        Waiters.waitForElementToBeDisplayed(dialogWarning);
        return ElementUtils.getTextByLocator(dialogWarning, 0);
    }
}
