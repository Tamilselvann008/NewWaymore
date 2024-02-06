package steps.login;

import basePackage.BasePo;
import basePackage.CommonButtonsPo;
import enums.uienums.NotificationEnums.LoginPageMessageEnum;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.StepUtils;
import helpers.StringUtils;
import helpers.Waiters;
import pages.dashboard.OnboardingDialogPo;
import pages.login.LoginPo;

public class LoginSteps extends BasePo {
	LoginPo loginPo = new LoginPo(driver);
	OnboardingDialogPo onboardingDialogPo = new OnboardingDialogPo(driver);
	CommonButtonsPo commonButtonsPo = new CommonButtonsPo(driver);

	public void theUserIsOnTheGettingStartedWithWayMorePage(int index) throws Exception {

		loginPo.openLandingPage();
		StepUtils.addLog("The user opens the Landing Page...");

		loginPo.typeValueInUserEmailInputField(DataProviders.getUserTestData("username", index));
		StepUtils.addLog("The user types the user email...");

		loginPo.typeValueInPasswordInputField(DataProviders.getUserTestData("password", index));
		StepUtils.addLog("The user types the user password...");

		loginPo.clickOnLoginButton();
		StepUtils.addLog("The user clicks on the Login button");

		onboardingDialogPo.waitForOnboardingLoaderImageIsNotDisplayed();
		StepUtils.addLog("The user waits for Onboarding loader image is not displayed");
	}

	public void givenTheUserLoginsToTheWayMoreApp(int index) throws Exception {
		// Assuming getUserTestData returns an instance of a user data class with
		// username and password fields
		String userName = DataProviders.getUserTestData("username", index);
		loginPo.typeValueInUserEmailInputField(userName);
		StepUtils.addLog("The user types the user email '" + userName + "'");

		String password = DataProviders.getUserTestData("username", index);
		loginPo.typeValueInPasswordInputField(password);
		StepUtils.addLog("The user types the user password '" + password + "'");

		loginPo.clickOnLoginButton();
		StepUtils.addLog("The user clicks on the Login button");
	}

	public void givenTheUserWithOnboardingImplementationLogsIntoTheWayMoreApp(int index) throws Exception {
		String waymorePageUrl = DataProviders.getUrlTestData("waymorePageUrl");
		StepUtils.addLog("The user opens the Landing Page '" + waymorePageUrl + "login'");
		loginPo.openLandingPage();

		String userName = DataProviders.getUserTestData("username", index);
		loginPo.typeValueInUserEmailInputField(userName);
		StepUtils.addLog("The user types the user email '" + userName + "'");

		String password = DataProviders.getUserTestData("password", index);
		loginPo.typeValueInPasswordInputField(password);
		StepUtils.addLog("The user types the user password '" + password + "'");

		loginPo.clickOnLoginButton();
		StepUtils.addLog("The user clicks on the Login button");

		onboardingDialogPo.clickOnCloseButton();
		StepUtils.addLog("The user clicks on the Close button in the Onboarding Dialog");

		// Uncomment the following lines if the "Yes" button click is required in the
		// onboarding dialog
		// StepUtils.addLog("The user clicks on the Yes button in the Confirm dialog in
		// the Onboarding Popup");
		// onboardingDialogPo.clickOnYesButton();
	}

	public void givenTheUserIsOnTheWaymoreLoginPage() {
		loginPo.openLandingPage();
		StepUtils.addLog(
				"The user opens the Landing Page '" + DataProviders.getUrlTestData("waymorePageUrl") + "login'");
	}

	public void whenTheUserClicksOnTheLoginButton() throws Exception {
		loginPo.clickOnLoginButtonWithoutWait();
	}

	public void whenTheUserClicksOnTheLoginButtonToGoToTheDashboardPage() throws Exception {
		loginPo.clickOnLoginButton();
	}

	public void thenTheWarningThatInvalidUsernameOrPasswordIsDisplayedOnTheLoginPage() throws Exception {
		Assertions.expectToDisplay(loginPo.getPasswordErrorMessage(), "The Warning message is not displayed");
		Assertions.expectToInclude(loginPo.getPasswordErrorMessageText(),
				LoginPageMessageEnum.InvalidPasswordLogin.getValue(), "The Warning message is incorrect");
	}

	public void whenTheUserEntersAValidEmailInTheEmailInputField(int index) throws InterruptedException {
		String userEmail = DataProviders.getUserTestData("username", index); // Fetches the user's email
		loginPo.typeValueInUserEmailInputField(userEmail); // Types the fetched email into the email input field
		StepUtils.addLog("The user types the user email '" + userEmail + "'");
	}

	public void whenTheUserEntersAValidPasswordInThePasswordInputField(int index) throws InterruptedException {
		String userPassword = DataProviders.getUserTestData("password", index); // Fetches the user's password
		loginPo.typeValueInPasswordInputField(userPassword); // Types the fetched password into the password input field
		StepUtils.addLog("The user types the user password '" + userPassword + "'");
	}

	public void whenTheUserEntersAnInvalidPasswordInThePasswordInputField() throws InterruptedException {
		String invalidPassword = StringUtils.getRandomString(12, "scoped:%$@!&^");
		StepUtils.addLog("The user types the user password '" + invalidPassword + "'");
		loginPo.typeValueInPasswordInputField(invalidPassword);
	}

	public void whenTheUserEntersAnInvalidCharacterEmailInTheEmailInputField(int characterNumber)
			throws InterruptedException {
		String invalidEmail = StringUtils.getRandomString(characterNumber, "lower") + "@waymore.com";
		StepUtils.addLog("The user types the user email '" + invalidEmail + "'");
		loginPo.typeValueInUserEmailInputField(invalidEmail);
	}

	public void whenTheUserClicksOnSignUpButton() throws Exception {
		StepUtils.addLog("The user clicks on Sign Up button");
		loginPo.clickOnSignUpButton();
	}

	public void whenTheUserClicksOnXButtonInTheEmailField() throws Exception {
		StepUtils.addLog("The user clicks on X button in the email field");
		loginPo.clickOnCloseButton();
	}

	public void whenTheUserClicksOnForgotYourPasswordLink() throws Exception {
		loginPo.clickOnForgotPasswordLink();
		StepUtils.addLog("The user clicks on Forgot Your Password link");
	}

	public void thenTheWarningAboutBadCredentialsIsDisplayedOnTheLoginPage() throws Exception {
		Assertions.expectToInclude(loginPo.getPasswordErrorMessageText(),
				LoginPageMessageEnum.BadCredentials.getValue(),
				"The Warning message about bad credentials is incorrect");
	}

	public void thenTheUserCanSeeNotificationThatSomethingWentWrongOnTheLoginPage() throws Exception {
		Assertions.expectToDisplay(commonButtonsPo.getRightPopupNotification(),
				"Invalid password Notification is not displayed");
		Assertions.expectToInclude(commonButtonsPo.getRightPopupNotificationText(),
				LoginPageMessageEnum.InvalidPasswordAndValidEmail.getValue(),
				"Toast error message is not same as expected");
	}

	public void thenTheWarningThatTheEmailFieldIsRequiredIsDisplayedOnTheLoginPage() throws Exception {
		Assertions.expectToDisplay(loginPo.getEmailErrorMessage(),
				"The required Email field error message is not displayed");
		Assertions.expectToEqual(loginPo.getEmailErrorMessageText(), LoginPageMessageEnum.FieldRequired,
				"The Warning message is incorrect");
	}

	public void thenTheWarningThatThePasswordFieldIsRequiredIsDisplayedOnTheLoginPage() throws Exception {
		Assertions.expectToDisplay(loginPo.getPasswordErrorMessage(),
				"The required Password field error message is not displayed");
		Assertions.expectToEqual(loginPo.getPasswordErrorMessageText(), LoginPageMessageEnum.FieldRequired,
				"The Warning message is incorrect");
	}

	public void thenTheUserCanSeeAWarningThatAValidEmailAddressMustBeEnteredOnTheLoginPage() throws Exception {
		Assertions.expectToDisplay(loginPo.getEmailErrorMessage(),
				"The warning that user must enter a valid email address is not displayed");
		Assertions.expectToEqual(loginPo.getEmailErrorMessageText(), LoginPageMessageEnum.InvalidEmail,
				"The warning that user must enter a valid email address is incorrect");
	}

	public void thenTheDataIsResetInTheEmailInputField() throws Exception {
		Assertions.expectToEqual(loginPo.getEmailInputFieldValue(), "",
				"The data in the Email input field is not cleared");
	}

	public void thenTheInputFieldsDisplayTheCompletedDataOfTheUser(int index) throws Exception {
		String expectedEmail = DataProviders.getUserTestData("username", index);
		Assertions.expectToEqual(loginPo.getEmailInputFieldValue(), expectedEmail,
				"The data in the Email input field is not filled in");

		String expectedPassword = DataProviders.getUserTestData("password", index);
		Assertions.expectToEqual(loginPo.getPasswordInputFieldValue(), expectedPassword,
				"The data in the Password input field is not filled in");
	}

	public void thenTheInputFieldsDoNotDisplayAnyUserData() throws Exception {
		Assertions.expectToEqual(loginPo.getEmailInputFieldValue(), "", "The Email input field is not empty");
		Assertions.expectToEqual(loginPo.getPasswordInputFieldValue(), "", "The Password input field is not empty");
	}

	public void thenTheRememberMeCheckboxIsCheckedOnTheLoginPage() {
		Assertions.expectToBeTrue(loginPo.isRememberMeCheckboxChecked(), "The Remember me checkbox is not checked");
	}

	public void thenTheRememberMeCheckboxIsUncheckedOnTheLoginPage() {
		Assertions.expectToBeFalse(loginPo.isRememberMeCheckboxChecked(), "The Remember me checkbox is checked");
	}

	public void thenTheUserIsRedirectedToTheWaymoreLoginPage() {
		String expectedUrl = DataProviders.getUrlTestData("waymorePageUrl") + "login";
		Waiters.waitUntilURLContains("login");
		Assertions.expectToEqual(loginPo.getCurrentUrl(), expectedUrl,
				"The user is not redirected to the Waymore login page");
	}
}
