package pages.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.Waiters;

public class OnboardingDialogPo extends BasePo {

	public OnboardingDialogPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private By closeButton = By.cssSelector("wm-onboarding-iframe-dialog .close-btn");
	private By onboardingPopupIFrame = By.cssSelector("mat-dialog-container wm-onboarding-iframe-dialog");
	private By onboardingConfirmCloseDialog = By.cssSelector("wm-onboarding-iframe-close-dialog");
	private By onboardingConfirmCloseButton = By
			.cssSelector("wm-onboarding-iframe-close-dialog button.close-btn-primary");
	private By userName = By.cssSelector(".name");
	private By startedButton = By.cssSelector(".content-div button");
	private By onboardingPopupContentLoader = By.cssSelector(".MuiCircularProgress-svg");
	private By onboardingPopupContent = By.cssSelector(".page-container");
	private By onboardingLoaderImage = By.cssSelector("img.campaigns-loader__img");

	public void waitForOnboardingLoaderImageIsNotDisplayed() {
		Waiters.waitForElementToBeInvisible(onboardingLoaderImage);
	}
	
	public void clickOnCloseButton() throws Exception {
	    Waiters.waitForElementToBeDisplayed(onboardingPopupIFrame);
	    boolean isPopupDisplayed = isOnboardingPopupDisplayed();

	    if (isPopupDisplayed) {
	        Action.clickByLocator(closeButton, 0);
	        Waiters.waitForElementToBeInvisible(onboardingPopupIFrame);
	    }
	}

	public void clickOnYesButton() throws Exception {
	    boolean isPopupDisplayed = isConfirmCloseDialogDisplayed();

	    if (isPopupDisplayed) {
	        Action.clickByLocator(onboardingConfirmCloseButton, 0);
	        Waiters.waitForElementToBeInvisible(onboardingPopupIFrame);
	    }
	}

	public WebElement getOnboardingPopup() throws Exception {
	    Waiters.waitForElementToBeDisplayed(onboardingPopupIFrame);
	    return ElementUtils.getElementByLocator(onboardingPopupIFrame, 0);
	}

	public boolean isOnboardingPopupDisplayed() {
	    return Action.isElementDisplayedByLocator(onboardingPopupIFrame, 0);
	}

	public boolean isConfirmCloseDialogDisplayed() {
	    return Action.isElementDisplayedByLocator(onboardingConfirmCloseDialog, 0);
	}

	public boolean isOnboardingPopupContentDisplayed() throws Exception {
	    driver.switchTo().frame(ElementUtils.getElementByLocator(onboardingPopupIFrame, 0));
	    Waiters.waitForElementToBeNotVisible(onboardingPopupContentLoader);
	    Waiters.waitForElementToBeDisplayed(onboardingPopupContent);
	    return Action.isElementDisplayedByLocator(onboardingPopupContent, 0);
	}

	public String getUserNameText() throws Exception {
	    Waiters.waitForElementToBeDisplayed(userName);
	    return ElementUtils.getTextByLocator(userName, 0);
	}

	public WebElement getStartedButton() throws Exception {
	    return ElementUtils.getElementByLocator(startedButton, 0);
	}

}