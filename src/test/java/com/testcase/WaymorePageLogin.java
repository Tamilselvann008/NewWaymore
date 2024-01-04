package com.testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.LoginPo;
import com.pages.OnboardingDialogPo;

import basePackage.BasePo;

@Test(description = "Getting Started with Waymore Pages")
public class WaymorePageLogin extends BasePo {

	@BeforeTest
	public void launchWebsite() {
		browserLaunch();
	}

	public void Login() {

		LoginPo loginPo = new LoginPo(driver);
		OnboardingDialogPo onboardingDialogPo = new OnboardingDialogPo(driver);
		System.out.println("The user opens the Landing Page '" + jsonValues("landingpage") + "login'");
		loginPo.openLandingPage();

		System.out.println("The user types the user email '" + jsonValues("username") + "'");
		loginPo.typeValueInUserEmailInputField(jsonValues("username"));

		System.out.println("The user types the user password '" + jsonValues("password") + "'");
		loginPo.typeValueInPasswordInputField(jsonValues("password"));

		System.out.println("The user clicks on the Login button");
		loginPo.clickOnLoginButton();

		System.out.println("The user waits for Onboarding loader image is not displayed");
		onboardingDialogPo.waitForOnboardingLoaderImageIsNotDisplayed();

	}

}