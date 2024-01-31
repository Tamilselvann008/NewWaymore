package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePo;
import helpers.Action;
import helpers.DataProviders;
import helpers.ElementUtils;
import helpers.Waiters;

public class LoginPo extends BasePo {
	public LoginPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private By userEmailInput = By.cssSelector("#email");
	private By passwordInput = By.cssSelector("#password");
	private By loginButton = By.cssSelector("button.login-form__btn");
	private By emailErrorMessage = By.cssSelector(".email-wrapper + div mat-error.mat-error.invalid-feedback");
	private By passwordErrorMessage = By.cssSelector("#password + div mat-error.mat-error.invalid-feedback");
	private By signUpButton = By.cssSelector(".login-form__header .login-signup");
	private By closeButton = By.cssSelector(".invalid-email-wrapper .mat-icon");
	private By forgotPasswordLink = By.cssSelector(".login-form__forgot-password a");
	private By rememberMeCheckbox = By.cssSelector(".login-form__actions mat-checkbox input[type=\"checkbox\"]");

	 public void openLandingPage() {
		 driver.get(DataProviders.getUrlTestData("waymorePageUrl"));
	    }
	

	 public void typeValueInUserEmailInputField(String value) throws InterruptedException {
	        Action.clearTextInLocatorAndTypeText(userEmailInput, value);
	    }

	 public void typeValueInPasswordInputField(String value) throws InterruptedException {
	        Action.clearTextInLocatorAndTypeText(passwordInput, value);
	    }

	    public void clickOnLoginButton() throws Exception {
	        Action.clickByLocator(loginButton, 0);
	        Waiters.waitForElementToBeInvisible(loginButton);
	        Waiters.waitUntilURLContains(DataProviders.getUrlTestData("waymorePageUrl"));
	    }

	    public void clickOnLoginButtonWithoutWait() throws Exception {
	        Action.clickByLocator(loginButton, 0);
	    }
	 
	    public void openNewWindowLandingPage() throws Exception {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.open('" + DataProviders.getUrlTestData("waymorePageUrl") + "login','_blank');");
	        Waiters.waitForTabsCount();
	        Action.switchToHandleByTabNumber(2);
	    }

	    public void refreshCurrentPage() {
	        driver.navigate().refresh();
	    }

	    public void selectRememberMeCheckboxByStatus(String checkboxStatus) throws Exception {
	        Action.selectCheckboxByLocatorAndStatus(rememberMeCheckbox, checkboxStatus);
	    }

	    public boolean isRememberMeCheckboxChecked() {
	        return Action.isElementCheckedByLocator(rememberMeCheckbox);
	    }
	 
	    public WebElement getEmailErrorMessage() throws Exception {
	        Waiters.waitForElementToBeDisplayed(emailErrorMessage);
	        return ElementUtils.getElementWithWaitByLocator(emailErrorMessage, 0);
	    }

	    public WebElement getPasswordErrorMessage() throws Exception {
	    	Waiters.waitForElementToBeDisplayed(passwordErrorMessage);
	        return ElementUtils.getElementWithWaitByLocator(passwordErrorMessage, 0);
	    }

	    public String getEmailErrorMessageText() throws Exception {
	    	Waiters.waitForElementToBeDisplayed(emailErrorMessage);
	        return ElementUtils.getTextByLocator(emailErrorMessage, 0);
	    }

	    public String getPasswordErrorMessageText() throws Exception {
	    	Waiters.waitForElementToBeDisplayed(passwordErrorMessage);
	        return ElementUtils.getTextByLocator(passwordErrorMessage, 0);
	    }

	    public void clickOnSignUpButton() throws Exception {
	        Waiters.waitForElementToBeDisplayed(signUpButton);
	        Action.clickByLocator(signUpButton, 0);
	    }

	    public void clickOnCloseButton() throws Exception {
	    	Waiters.waitForElementToBeDisplayed(closeButton);
	    	Action.clickByLocator(closeButton, 0);
	    }
	    
	    public String getEmailInputFieldValue() throws Exception {
	        return ElementUtils.getValueByLocator(userEmailInput, 0);
	    }

	    public String getPasswordInputFieldValue() throws Exception {
	        return ElementUtils.getValueByLocator(passwordInput, 0);
	    }

	    public void clickOnForgotPasswordLink() throws Exception {
	    	Waiters.waitForElementToBeDisplayed(forgotPasswordLink);
	    	Action.clickWithJSByLocator(forgotPasswordLink, 0);
	        Waiters.waitForElementToBeInvisible(forgotPasswordLink);
	    }


}
