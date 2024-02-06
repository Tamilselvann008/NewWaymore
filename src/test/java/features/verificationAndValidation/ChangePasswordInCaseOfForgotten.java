package features.verificationAndValidation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BasePo;
import steps.login.LoginSteps;

//@ChangePasswordInCaseOfForgotten @PRD-145
//Feature: Change Password In Case Of Forgotten
//
//  USER STORY - As a waymore user, i should be able to change my password in case of forgotten/misplaced
//  GIVEN user is on Waymore Login Page
//  WHEN the user will click on 'Forgot your Password?' link
//  THEN user will be redirected to the Forgot password screen
//  WHEN the user enters a valid email in the email input field
//  AND the user clicks on Forgot Your Password link
//  THEN the user is redirected to the Routee page
//  AND the Captcha is displayed
//  WHEN the user enters an email in the email input field
//  THEN the entered email is displayed in the email input field
public class ChangePasswordInCaseOfForgotten extends BasePo {
	private LoginSteps loginSteps = new LoginSteps();
	@BeforeTest
	public void launchWebsite() {
		browserLaunch();
	}

	@AfterTest
	public void tearDown() {
		closeBrowser();
	}

	
	@Test(description = " @WQ-522 @TR-522 @Regression\r\n"
			+ "	  Scenario: The user will be redirected to the routee page if he forgot his password")
	public void theUserWillBeRedirectedToTheRouteePageIfHeForgotHisPassword() throws Exception {
	 
//	    Given the user is on the Waymore login page
		loginSteps.givenTheUserIsOnTheWaymoreLoginPage();
//	    When the user № 1 enters a valid email in the email input field
		loginSteps.whenTheUserEntersAValidEmailInTheEmailInputField(1);
//	    And the user clicks on Forgot Your Password link
		loginSteps.whenTheUserClicksOnForgotYourPasswordLink();
//	    Then the user is redirected to the Routee Lost Your Password page
		loginSteps.thenTheUserIsRedirectedToTheWaymoreLoginPage();
//	    And the Captcha is displayed on the Routee page
		
//	    When the user enters an email in the email input field on the Routee page
//	    Then the entered email is displayed in the email input field on the Routee page
	}
//	  @ALW-10233 @TR-10233 @Regression
//	  Scenario: The user can return to the login page from the Routee page if he forgot his password and decided to go back
//	    Given the user is on the Waymore login page
//	    When the user clicks on Forgot Your Password link
//	    Then the user is redirected to the Routee Lost Your Password page
//	    When the user clicks on the Back To Login link on the Routee page
//	    Then the user is redirected to the Waymore login page
//
//	  @ALW-10234 @TR-10234 @Regression
//	  Scenario: The user can change language on the Routee page
//	    Given the user is on the Waymore login page
//	    When the user clicks on Forgot Your Password link
//	    Then the user is redirected to the Routee Lost Your Password page
//	    When the user selects English option from the language dropdown on the Routee page
//	    Then the English option is selected from the language dropdown on the Routee page
//	    And the Lost your password? title is displayed in English on the Routee page
//	    And the email placeholder is displayed in English on the Routee page
//	    And the name of the Send button is displayed in English on the Routee page
//	    And the link name Back to login is displayed in English on the Routee page
//
//	  @ALW-10235 @TR-10235 @DoNotRunDueToRecaptcha
//	  Scenario: The user can see an error popup when entering a non-existent email on the Routee page
//	    Given the user is on the Waymore login page
//	    When the user clicks on Forgot Your Password link
//	    Then the user is redirected to the Routee Lost Your Password page
//	    When the user selects English option from the language dropdown on the Routee page
//	    And the user enters an email in the email input field on the Routee page
//	    And the user checks the captcha on the Routee page
//	    And the user clicks on the Send Button on the Routee page
//	    Then the user can see a popup warning that the username or password is incorrect on the Routee page

	

}
