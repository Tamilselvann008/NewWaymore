package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePackage.BasePo;
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

	 public void openLandingPage(String url) {
		 driver.get(url);
	    }
	

	 public void typeValueInUserEmailInputField(String value) throws InterruptedException {
	        Action.clearTextInLocatorAndTypeText(userEmailInput, value);
	    }

	 public void typeValueInPasswordInputField(String value) throws InterruptedException {
	        Action.clearTextInLocatorAndTypeText(passwordInput, value);
	    }


	 public void clickOnLoginButton() throws Exception {
	        Action.clickByLocator(loginButton);
	        Waiters.waitForElementToBeInvisible(loginButton);
	        // Adjust URL waiting as per Java conventions
	    }
}
