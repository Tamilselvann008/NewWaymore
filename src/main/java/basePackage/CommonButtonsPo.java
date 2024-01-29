package basePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import helpers.ElementUtils;
import helpers.StringUtils;
import helpers.Waiters;

public class CommonButtonsPo extends BasePo {
	
	public CommonButtonsPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    private static final Object NextPage = "Next page";
	private By nextButton = By.cssSelector("button.wm-btn--next");
    private By backButton = By.cssSelector("button.wm-btn--back");
    private By leftPopupNotification = By.cssSelector(".md-bottom.md-left.md-default-theme");
    private By rightPopupNotification = By.cssSelector("md-toast div.md-toast-content");
    private By popupNotificationCloseButton = By.cssSelector("md-toast button");
    private By uploadButton = By.cssSelector("#uploader");
    private By paginationNextLink = By.cssSelector("a[ng-disabled='noNext()||ngDisabled']");
    private By paginationPreviousLink = By.cssSelector("a[ng-disabled='noPrevious()||ngDisabled']");

    public WebElement getNextButton() throws Exception {
        return ElementUtils.getElementByLocator(nextButton, 0);
    }

    public boolean isNextButtonDisabled() throws Exception {
        String isDisabled = ElementUtils.getAttributeByLocator(nextButton, "disabled", 0);
        return isDisabled != null;
    }

    public void uploadFileByFileName(String fileName) {
        Action.uploadFileByFileName(uploadButton, fileName);
    }

    public void clickOnNextButton() throws Exception {
        Action.clickByLocator(nextButton, 0);
        Waiters.waitWithSleepTimeout(2000);
    }

    public void clickOnBackButton() throws Exception {
        Action.clickByLocator(backButton, 0);
        Waiters.waitWithSleepTimeout(1000);
    }

    public void waitForPaginationNextLinkToBeEnabled() {
        Waiters.waitForAttributeValueToBePresentInElement(paginationNextLink, "disabled", null, 0);
    }

    public void waitForPaginationPreviousLinkToBeEnabled() {
        Waiters.waitForAttributeValueToBePresentInElement(paginationPreviousLink, "disabled", null, 0);
    }

    public void waitForRightPopupNotificationToBeDisplayed() {
        Waiters.waitForElementToBeDisplayed(rightPopupNotification);
    }

    public boolean isRightPopupNotificationElementDisplayed() {
        return Action.isElementDisplayedByLocator(rightPopupNotification, 0);
    }

    public WebElement getRightPopupNotification() throws Exception {
        waitForRightPopupNotificationToBeDisplayed();
        return ElementUtils.getElementByLocator(rightPopupNotification, 0);
    }

    public String getLeftPopupNotificationText() throws Exception {
        Waiters.waitForElementToBeDisplayed(leftPopupNotification);
        return ElementUtils.getTextByLocator(leftPopupNotification, 0);
    }

    public String getRightPopupNotificationText() throws Exception {
        waitForRightPopupNotificationToBeDisplayed();
        String popupText = ElementUtils.getTextByLocator(rightPopupNotification, 0);
        return StringUtils.getStringBySplit(popupText, "'\n'", 1);
    }

    public void clickOnCloseNotificationButton() throws Exception {
        Action.clickWithJSByLocator(popupNotificationCloseButton, 0);
        Waiters.waitForElementToBeInvisible(rightPopupNotification);
        Waiters.waitWithSleepTimeout(0);
    }

    public String getDisableAttributeByButtonValue(String buttonName) throws Exception {
        By locator = buttonName.equals(NextPage) ? paginationNextLink : paginationPreviousLink;
        Waiters.waitForElementToBeDisplayed(locator);
        return ElementUtils.getAttributeByLocator(locator, "disabled", 0);
    }

    public void clickOnPaginationNextLink() throws Exception {
        String isDisabled = ElementUtils.getAttributeByLocator(paginationNextLink, "disabled", 0);
        if (isDisabled == null) {
            Action.clickByLocator(paginationNextLink, 0);
        }
    }

    public void clickOnPaginationPreviousLink() throws Exception {
        String isDisabled = ElementUtils.getAttributeByLocator(paginationPreviousLink, "disabled", 0);
        if (isDisabled == null) {
            Action.clickByLocator(paginationPreviousLink, 0);
        }
    }

    public void mouseMoveToNextButton() throws Exception {
        Waiters.waitForElementToBeDisplayed(nextButton);
        Action.moveMouseToElementByLocator(nextButton, 0);
    }
}
