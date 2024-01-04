package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import actions.Actions;
import basePackage.BasePo;

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
		driver.get(jsonValues("landingpage"));
	}

	public void typeValueInUserEmailInputField(String value) {
		Actions.enterText(userEmailInput, value);
	}

	public void typeValueInPasswordInputField(String value) {
		Actions.enterText(passwordInput, value);
	}

	public void clickOnLoginButton() {
		Actions.buttonClick(loginButton);
	}

}
