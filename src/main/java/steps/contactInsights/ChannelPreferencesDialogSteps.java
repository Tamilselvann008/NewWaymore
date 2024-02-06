package steps.contactInsights;

import basePackage.BasePo;
import enums.uienums.NotificationEnums.ChannelPreferencesDialogMessageEnum;
import helpers.Assertions;
import pages.contactInsights.ChannelPreferencesDialogPo;

public class ChannelPreferencesDialogSteps extends BasePo{

    private final ChannelPreferencesDialogPo channelPreferencesDialogPo = new ChannelPreferencesDialogPo(driver);

    public void whenTheUserClicksOnNoExitButtonInChannelPreferencesDialog() throws Exception {
        channelPreferencesDialogPo.clickOnNoExitButton();
    }

    public void whenTheUserClicksOnCloseButtonInChannelPreferencesDialog() throws Exception {
        channelPreferencesDialogPo.clickOnCloseButton();
    }

    public void thenTheContactChannelPreferencesDialogIsDisplayed() throws Exception {
        Assertions.expectToDisplay(channelPreferencesDialogPo.getChannelPreferenceDialog(), "The Contact Channel Preferences dialog is not displayed");
    }

    public void thenTheContactChannelPreferencesDialogIsNotDisplayed() throws Exception {
        Assertions.expectToBeFalse(channelPreferencesDialogPo.isChannelPreferencesDialogDisplayed(), "The Contact Channel Preferences dialog is displayed");
    }

    public void thenTheWarningAboutAddingAllContactChannelsToGraylistIsDisplayed() throws Exception {
        Assertions.expectToBeTrue(channelPreferencesDialogPo.isChannelPreferencesDialogWarningIconDisplayed(), "The warning icon is not displayed");
        Assertions.expectToEqual(channelPreferencesDialogPo.getChannelPreferencesDialogWarningText(),
                ChannelPreferencesDialogMessageEnum.GrayListMessage, "The warning about adding all contact channels to the graylist is incorrect");
    }

    public void thenTheWarningAboutAddingAllContactChannelsToBlacklistIsDisplayed() throws Exception {
        Assertions.expectToBeTrue(channelPreferencesDialogPo.isChannelPreferencesDialogWarningIconDisplayed(), "The warning icon is not displayed");
        Assertions.expectToEqual(channelPreferencesDialogPo.getChannelPreferencesDialogWarningText(),
                ChannelPreferencesDialogMessageEnum.BlackListMessage, "The warning about adding all contact channels to the blacklist is incorrect");
    }

    public void thenTheYesContinueButtonIsEnabledInChannelPreferencesDialog() throws Exception {
        Assertions.expectToBeFalse(channelPreferencesDialogPo.isYesContinueButtonDisabled(), "The Yes, Continue button is disabled");
    }

    public void thenTheMessageIndicatingThatUserDoesNotBelongToAnyOfGroupsIsDisplayed(String message) throws Exception {
        Assertions.expectToEqual(channelPreferencesDialogPo.getContactInfoGroupText(), message,
                "The message indicating that the '" + message + "' is incorrect");
    }
}
