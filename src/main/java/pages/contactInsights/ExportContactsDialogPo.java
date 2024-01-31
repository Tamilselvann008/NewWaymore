package pages.contactInsights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePo;
import helpers.Action;
import helpers.Waiters;

public class ExportContactsDialogPo extends BasePo {

    public ExportContactsDialogPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    private By exportContactsDialog = By.cssSelector(".cdk-overlay-pane .mat-dialog-container");
    private By exportButton = By.cssSelector(".wm-dialog progress-button[pb-click='ctrl.export()']");
    private By exportButtonLoading = By.cssSelector(".wm-dialog progress-button .wm-btn--loading");
    private By cancelButton = By.cssSelector(".wm-btn.wm-btn--simple.wm-btn--small");
    private By closeButton = By.cssSelector("wm-export-contacts-dialog .wm-dialog-close");

    private By exportFormatCheckbox(String option) {
        return By.cssSelector(".wm-dialog md-checkbox[aria-label='" + option + "']");
    }

    public boolean isExportContactsDialogElementDisplayed() throws Exception {
        return Action.isElementDisplayedByLocator(exportContactsDialog, 0);
    }

    public void clickOnCheckboxByValue(String option) throws Exception {
        Action.clickByLocator(exportFormatCheckbox(option), 0);
    }

    public void clickOnExportButton() throws Exception {
        Action.clickByLocator(exportButton, 0);
        Waiters.waitForElementToBeInvisible(exportButtonLoading);
        Waiters.waitWithSleepTimeout(2000);
    }

    public void clickOnCancelButton() throws Exception {
        Action.clickByLocator(cancelButton, 0);
        Waiters.waitForElementToBeInvisible(exportContactsDialog);
    }

    public void clickOnCloseButton() throws Exception {
        Action.clickByLocator(closeButton, 0);
        Waiters.waitForElementToBeInvisible(exportContactsDialog);
    }

    // Other methods as needed
}

