package steps.common;

import basePackage.BasePo;
import basePackage.CommonButtonsPo;
import helpers.Assertions;

public class CommonButtonsSteps extends BasePo{

    private static final String NEXT_PAGE = "Next page";
    private static final String PREVIOUS_PAGE = "Previous page";
    private static final String DISABLED = "disabled";
    private static final String ENABLED = "enabled";

    private CommonButtonsPo commonButtonsPo = new CommonButtonsPo(driver);

    public void whenTheUserClicksOnTheNextButton() throws Exception {
        commonButtonsPo.clickOnNextButton();
    }

    public void whenTheUserClicksOnTheBackButton() throws Exception {
        commonButtonsPo.clickOnBackButton();
    }

    public void whenTheUserClicksPreviousOrNextPageButton(String buttonName) throws Exception {
        if (buttonName.equals(NEXT_PAGE)) {
            commonButtonsPo.clickOnPaginationNextLink();
            commonButtonsPo.waitForPaginationPreviousLinkToBeEnabled();
        } else if (buttonName.equals(PREVIOUS_PAGE)) {
            commonButtonsPo.clickOnPaginationPreviousLink();
            commonButtonsPo.waitForPaginationNextLinkToBeEnabled();
        }
    }

    public void whenTheUserHoversOverTheNextButton() throws Exception {
        commonButtonsPo.mouseMoveToNextButton();
    }

    public void thenThePreviousOrNextPageButtonIsActiveInactive(String buttonName, String option) throws Exception {
        String expectedResult = option.equals("active") ? null : "true";
        String buttonDisabled = commonButtonsPo.getDisableAttributeByButtonValue(buttonName);
        Assertions.expectToEqual(buttonDisabled, expectedResult, "The '" + buttonName + "' button is not '" + option + "'");
    }

    public void thenTheNextButtonIsDisabledEnabled(String mode) throws Exception {
        if (mode.equals(DISABLED)) {
            Assertions.expectToBeTrue(commonButtonsPo.isNextButtonDisabled(), "The Next button is enabled");
        } else if (mode.equals(ENABLED)) {
            Assertions.expectToBeFalse(commonButtonsPo.isNextButtonDisabled(), "The Next button is disabled");
        }
    }
}
