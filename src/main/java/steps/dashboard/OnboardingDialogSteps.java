package steps.dashboard;

import basePackage.BasePo;
import helpers.Assertions;
import helpers.DataProviders;
import pages.dashboard.OnboardingDialogPo;

public class OnboardingDialogSteps extends BasePo {

    private OnboardingDialogPo onboardingDialogPo = new OnboardingDialogPo(driver);

    public void whenTheUserClicksOnTheCloseButtonInTheOnboardingPopup() throws Throwable {
        onboardingDialogPo.clickOnCloseButton();
    }

    public void whenTheUserClicksOnTheYesButtonInTheConfirmDialogInTheOnboardingPopup() throws Exception {
        onboardingDialogPo.clickOnYesButton();
    }

    public void thenTheOnboardingPopupIsDisplayed() throws Exception {
        Assertions.expectToDisplay(onboardingDialogPo.getOnboardingPopup(), "The Onboarding Popup is not displayed");
    }

    public void thenTheOnboardingPopupContentIsDisplayed() throws Exception {
        Assertions.expectToBeTrue(onboardingDialogPo.isOnboardingPopupContentDisplayed(), "The Onboarding Popup Content is not displayed");
    }

    public void thenTheOnboardingPopupIsNotDisplayed() {
        Assertions.expectToBeFalse(onboardingDialogPo.isOnboardingPopupDisplayed(), "The Onboarding Popup is displayed");
    }

    public void thenTheUserDataOfTheUserNumberIsCorrectInTheOnboardingPopup(int index) throws Exception {
        String getFirstName = DataProviders.getUserTestData("firstName", index);
        String getLastName = DataProviders.getUserTestData("lastName", index);
        Assertions.expectToEqual(onboardingDialogPo.getUserNameText(), getFirstName + " " + getLastName, 
            "The user data is not correct in the Onboarding Popup");
    }

    public void thenTheGetStartedButtonIsEnabledInTheOnboardingPopup() throws Exception {
        Assertions.expectToBeEnabled(onboardingDialogPo.getStartedButton(), "The Get Started button is disabled in the Onboarding Popup");
    }

    // Other methods...
}

