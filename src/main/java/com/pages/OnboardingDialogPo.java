package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePo;
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
}