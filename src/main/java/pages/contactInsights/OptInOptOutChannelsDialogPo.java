package pages.contactInsights;

import basePackage.BasePo;
import helpers.Action;
import helpers.ElementUtils;

import helpers.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OptInOptOutChannelsDialogPo extends BasePo {
	 public OptInOptOutChannelsDialogPo(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		}
    private By optInOptOutChannelsDialog = By.cssSelector("wm-optin-optout-dialog .contacts-dialog__optin-optout");
    private By optInOptOutChannelsDialogHeader = By.cssSelector("wm-optin-optout-dialog .wm-dialog__header div");
    private By updateButton = By.cssSelector("wm-optin-optout-dialog button.progress-btn");
    private By progressButtonSpinner = By.cssSelector("wm-progress-button button mat-spinner");

    private By radioButtonByChannelNameAndButtonValue(String channel, String radioButton) {
        return By.cssSelector(String.format("wm-optin-optout-dialog input[name='%s-form'][value='%s']", channel, radioButton));
    }

    public WebElement getOptInOptOutChannelsDialog() throws Exception {
        return ElementUtils.getElementWithWaitByLocator(optInOptOutChannelsDialog, 0);
    }

    public boolean isOptInOptOutChannelsDialogDisplayed() throws Exception {
        return Action.isElementDisplayedByLocator(optInOptOutChannelsDialog, 0);
    }

    public String getOptInOptOutChannelsDialogHeaderText() throws Exception {
        return ElementUtils.getTextByLocator(optInOptOutChannelsDialogHeader, 0);
    }

    public boolean isRadioButtonByChannelAndButtonTypeChecked(String channel, String radioButton) throws Exception {
        String buttonAttribute = ElementUtils.getAttributeByLocator(radioButtonByChannelNameAndButtonValue(channel, radioButton), "tabindex", 0);
        return Integer.parseInt(buttonAttribute) == 0;
    }

    public void clickOnRadioButtonByChannelAndButtonType(String channel, String radioButton) throws Exception {
        Action.clickWithJSByLocator(radioButtonByChannelNameAndButtonValue(channel, radioButton), 0);
    }

    public void clickOnUpdateButton() throws Exception {
        Action.clickByLocator(updateButton, 0);
        Waiters.waitForElementToBeInvisible(progressButtonSpinner);
    }
}
