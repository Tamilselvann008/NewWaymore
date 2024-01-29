package com.testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BasePo;
import helpers.DataProviders;
import helpers.StepUtils;
import pages.dashboard.OnboardingDialogPo;
import pages.login.LoginPo;


public class WaymorePageLogin extends BasePo {

	@BeforeTest
	public void launchWebsite() {
		browserLaunch();
	}
	@Test()
	public void theUserIsOnTheGettingStartedWithWayMorePage(int index) throws Exception {
		LoginPo loginPo = new LoginPo(driver);
		OnboardingDialogPo onboardingDialogPo = new OnboardingDialogPo(driver);
		loginPo.openLandingPage();
		StepUtils.addLog("The user opens the Landing Page...");

		loginPo.typeValueInUserEmailInputField(DataProviders.getUserTestData("username", index));
		
		loginPo.typeValueInUserEmailInputField(DataProviders.getUserTestData("username", index));
		StepUtils.addLog("The user types the user email...");

		loginPo.typeValueInPasswordInputField(DataProviders.getUserTestData("password", index));
		StepUtils.addLog("The user types the user password...");

		loginPo.clickOnLoginButton();
		StepUtils.addLog("The user clicks on the Login button");

		onboardingDialogPo.waitForOnboardingLoaderImageIsNotDisplayed();
		StepUtils.addLog("The user waits for Onboarding loader image is not displayed");
	}

}
