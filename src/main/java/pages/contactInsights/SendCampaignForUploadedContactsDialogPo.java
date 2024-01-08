package pages.contactInsights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.Waiters;

public class SendCampaignForUploadedContactsDialogPo extends BasePo {

	 public SendCampaignForUploadedContactsDialogPo(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	private By sendCampaignDialog = By.cssSelector("mat-dialog-container[role='dialog']");
    private By noButton = By.cssSelector("mat-dialog-actions [mat-dialog-close]");
    private By yesButton = By.cssSelector("mat-dialog-actions button[cdkfocusinitial]");

    public void getSendCampaignDialog() throws Exception {
        Waiters.waitForElementToBeDisplayed(sendCampaignDialog);
        ElementUtils.getElementWithWaitByLocator(sendCampaignDialog, 0);
    }

    public void clickOnNoButton() throws Exception {
        Waiters.waitForElementToBeDisplayed(noButton);
        Action.clickByLocator(noButton);
        Waiters.waitForElementToBeNotVisible(sendCampaignDialog);
    }

    public void clickOnYesButton() throws Exception {
        Waiters.waitForElementToBeDisplayed(yesButton);
        Action.clickByLocator(yesButton);
        Waiters.waitForElementToBeInvisible(yesButton);
    }
}
