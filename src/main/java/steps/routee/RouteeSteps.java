package steps.routee;

import basePackage.BasePo;
import enums.uienums.NotificationEnums.RouteeMessageEnum;
import enums.uienums.OptionEnum.RouteePlaceholderOptionEnum;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.LocalStorage;
import helpers.StepUtils;
import helpers.StringUtils;
import pages.login.LoginPo;
import pages.routee.RouteePo;

public class RouteeSteps extends BasePo{

    private RouteePo routeePo= new RouteePo(driver);
    private LoginPo LoginPo = new LoginPo(driver);

    public void whenTheUserEntersAnEmailInTheEmailInputFieldOnTheRouteePage() throws InterruptedException {
        String email = StringUtils.getRandomString(10, "lower") + "@waymore.io";
        // Assuming LocalStorage class for managing local storage, similar to JavaScript's localStorage
        LocalStorage.setItem("routeeEmail", email);
        StepUtils.addLog("The user types the user email '" + email + "'");
        routeePo.typeValueInEmailInputFieldOnRouteePage(email);
    }

    public void whenTheUserSelectsLanguageOptionFromTheLanguageDropdownOnTheRouteePage(String languageOption) throws Exception {
        routeePo.selectOptionFromLanguageDropdown(languageOption);
    }

    public void whenTheUserClicksOnTheBackToLoginLinkOnTheRouteePage() throws Exception {
        routeePo.clickOnBackToLoginLink();
    }

    public void whenTheUserClicksOnTheSendButtonOnTheRouteePage() throws Exception {
        routeePo.clickOnSendButton();
    }

    public void whenTheUserChecksTheCaptchaOnTheRouteePage() throws Exception {
        routeePo.checkCaptcha();
    }

    public void thenTheUserIsRedirectedToTheRouteePage() {
        String expectedUrl = DataProviders.getUrlTestData("routeePageUrl");
        Assertions.expectToInclude(LoginPo.getCurrentUrl(), expectedUrl, "The user is not on the Routee page");
    }

    public void thenTheUserIsRedirectedToTheRouteeIntegrationsPage() {
        String expectedUrl = "/integrations/";
        Assertions.expectToInclude(LoginPo.getCurrentUrl(), expectedUrl, "The user is not on the Routee Integrations page");
    }

    public void thenTheUserIsRedirectedToTheBuildYourCustomPluginPage() {
        String expectedUrl = "/integrations/custom-software/";
        Assertions.expectToInclude(LoginPo.getCurrentUrl(), expectedUrl, "The user is not on the Build Your Custom Plugin page");
    }

    public void thenTheTitleIsDisplayedInTheLanguageOnTheRouteePage(String title, String language) throws Exception {
        String actualTitle = routeePo.getRouteeTitleText();
        Assertions.expectToEqual(actualTitle, title, "The '" + title + "' title is not displayed in '" + language + "'");
    }

    public void thenTheCaptchaIsDisplayedOnTheRouteePage() throws Exception {
        Assertions.expectToDisplay(routeePo.getCaptcha(), "The Captcha is not displayed");
    }

    public void thenTheEnteredEmailIsDisplayedInTheEmailInputFieldOnTheRouteePage() throws Exception {
        String routeeEmail = LocalStorage.getItem("routeeEmail");
        String actualEmail = routeePo.getEmailInputFieldValueOnLostYourPasswordPage();
        Assertions.expectToEqual(actualEmail, routeeEmail, "The entered Email is not displayed in the email input field on the Routee page");
    }

    public void thenTheUserCanSeeAPopupWarningThatTheUsernameOrPasswordIsIncorrectOnTheRouteePage() throws Exception {
        String actualPopupText = routeePo.getWarningPopupText();
        Assertions.expectToEqual(actualPopupText, RouteeMessageEnum.ErrorMessage,
                "The popup warning that the username or password is not displayed or incorrect");
    }

    public void thenTheLanguageOptionIsSelectedFromTheLanguageDropdownOnTheRouteePage(String languageOption) throws Exception {
        String actualLanguageOption = routeePo.getLanguageDropdownText();
        Assertions.expectToEqual(actualLanguageOption, languageOption, "The '" + languageOption + "' option is not selected from the language dropdown");
    }

    public void thenTheEmailPlaceholderIsDisplayedInTheLanguageOnTheRouteePage(String language) throws Exception {
        switch (language) {
            default:
                String actualPlaceholder = routeePo.getEmailInputOnRouteePagePlaceholderText();
                Assertions.expectToEqual(actualPlaceholder, RouteePlaceholderOptionEnum.EnglishPlaceholder,
                        "The email placeholder is not displayed in '" + language + "'");
                break;
        }
    }

    public void thenTheNameOfTheButtonIsDisplayedInTheLanguageOnTheRouteePage(String buttonName, String language) throws Exception {
        String actualButtonName = routeePo.getSendButtonText();
        Assertions.expectToEqual(actualButtonName, buttonName, "The button name '" + buttonName + "' is not displayed in '" + language + "'");
    }

    public void thenTheLinkNameIsDisplayedInTheLanguageOnTheRouteePage(String linkName, String language) throws Exception {
        String actualLinkName = routeePo.getBackToLoginLinkText();
        Assertions.expectToEqual(actualLinkName, linkName, "The link name '" + linkName + "' is not displayed in '" + language + "'");
    }

    public void thenTheUserIsRedirectedToTheRouteeLostYourPasswordPage() {
        String expectedUrl = DataProviders.getUrlTestData("forgotPasswordPageUrl");
        Assertions.expectToEqual(LoginPo.getCurrentUrl(), expectedUrl, "The user is not on Lost Your Password page of Routee");
    }

    // Include other "Then" methods here...

}

