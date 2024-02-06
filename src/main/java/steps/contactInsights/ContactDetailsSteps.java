package steps.contactInsights;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import basePackage.BasePo;
import enums.uienums.ActionEnum.ActionModeTypeEnum;
import enums.uienums.HtmlEnums.ColorFormatEnum;
import enums.uienums.OptionEnum.ChannelOptionEnum;
import enums.uienums.PopupsEnum.ContactDetailsTagsAddedPopupStatusEnum;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.StringUtils;
import helpers.Waiters;
import pages.contactInsights.ContactDetailsPo;
import pages.login.LoginPo;

public class ContactDetailsSteps extends BasePo{

    // Existing methods...
	LoginPo loginPo = new LoginPo(driver);
	ContactDetailsPo contactDetailsPo = new ContactDetailsPo(driver);
	
	public void whenTheUserClicksOnTheBackButtonOnTheContactDetailsPage() throws Exception {
        contactDetailsPo.clickOnBackButton();
    }

    public void whenTheUserTypesInTagsInputFieldAndPressEnter(String tagsValue) throws Exception {
        contactDetailsPo.enterTagValueAndPressEnter(tagsValue);
    }

    public void whenTheUserClicksOnTabInContactDetailsPage(String tabName) throws Exception {
        contactDetailsPo.clickOnTabByName(tabName);
    }

    public void whenTheUserClicksOnCancelIconInTagOnContactDetailsPage(String tagName) throws Exception {
        contactDetailsPo.clickOnCancelIconByTagName(tagName);
    }

    public void whenTheUserClicksOnPaginationButtonOnContactDetailsPage(String buttonType) throws Exception {
        contactDetailsPo.clickOnHeaderPaginationButtonByButtonType(StringUtils.getStringToLowerCase(buttonType));
    }

    public void whenTheUserClicksOnContactInfoButtonOnContactDetailsPage(String buttonType) throws Exception {
        contactDetailsPo.clickOnContactInfoButtonByName(buttonType);
    }
    public void thenTheUserIsRedirectedToTheContactDetailsPage() {
        Waiters.waitUntilURLContains("detail");
        String currentUrl = (String) loginPo.getCurrentUrl();
        Assertions.expectToInclude(currentUrl, "contact/detail", "The user is not taken to the Contact Details page");
    }

    public void thenTheContactsInfoPanelIsDisplayed() throws Exception {
        Assertions.expectToDisplay(contactDetailsPo.getContactInfo(), "The Contacts Info panel is not displayed");
    }

    public void thenTheDataOfTheContactIsCorrect(int contactIndex) throws Exception {
        List<String> contactInfoDataTextList = contactDetailsPo.getContactInfoDataTextList();
        
        // Additional processing or assertions based on your requirements

        Assertions.expectToEqual(contactDetailsPo.getContactInfoNameText(), DataProviders.getContactTestData("firstName" ,contactIndex) + " " + DataProviders.getContactTestData("lastName" ,contactIndex), "The contact name is incorrect");
        Assertions.expectToIncludeMembers(contactInfoDataTextList,Arrays.asList( "mail_outline" + DataProviders.getContactTestData("identifier", contactIndex, 7),
                                                                         		 "phone_outline" + StringUtils.getStringBySlice(DataProviders.getContactTestData("identifier", contactIndex, 1), 1, 1)) ,
                "The contact data is incorrect");
    }

    public void thenTheTagIsDisplayedOnTheContactDetailsPage(String tagValue) throws Exception {
        List<String> tagTextList = contactDetailsPo.getContactTagTextList();

        Assertions.expectToBeTrue(contactDetailsPo.isContactTagElementDisplayed(), "The tag is not displayed");
        Assertions.expectToIncludeMembers(tagTextList, Collections.singletonList(tagValue), "The '" + tagValue + "' tag has not been added");
    }

    public void thenTheGroupIsDisplayedOnTheContactDetailsPage(int groupIndex) throws Exception {
        String groupDataName = DataProviders.getGroupTestData("name", groupIndex);
        List<String> groupTextList = contactDetailsPo.getContactInfoGroupTextList();

        Assertions.expectToBeTrue(contactDetailsPo.isContactInfoGroupElementDisplayed(), "The group info is not displayed");
        Assertions.expectToIncludeMembers(groupTextList, Collections.singletonList(groupDataName),
                "The contact is not added to the '" + groupDataName + "' group");
    }

    public void thenTheTagIsNotDisplayedOnTheContactDetailsPage(String tagValue) throws Exception {
        List<String> tagTextList = contactDetailsPo.getContactTagTextList();

        Assertions.expectToNotIncludeMembers(tagTextList, Collections.singletonList(tagValue), "The '" + tagValue + "' tag has not been added");
    }

    public void thenTheTagsAreNotDisplayedOnTheContactDetailsPage() throws Exception {
        Assertions.expectToBeFalse(contactDetailsPo.isContactTagElementDisplayed(), "The tags are displayed");
    }

    public void thenTheUserCanSeePopupNotificationThatTheTagsHaveBeenAdded() throws Exception {
        Assertions.expectToInclude(contactDetailsPo.getRightPopupNotificationText(), ContactDetailsTagsAddedPopupStatusEnum.TagsAdded.getValue(),
                "The notification that the tags have been added is not correct");
    }

    public void thenTheUserCanSeePopupNotificationThatTheTagsHaveBeenDeleted() throws Exception {
        Assertions.expectToInclude(contactDetailsPo.getRightPopupNotificationText(), ContactDetailsTagsAddedPopupStatusEnum.TagsDeleted.getValue(),
                "The notification that the tags have been deleted is not correct");
    }

    public void thenTheAfterBeforePaginationButtonIsDisabledOnTheContactDetailsPage(String buttonType) throws Exception {
        Assertions.expectToBeTrue(contactDetailsPo.isHeaderPaginationButtonByButtonTypeDisabled(StringUtils.getStringToLowerCase(buttonType)),
                "The '" + buttonType + "' pagination button is enabled");
    }

    public void thenTheAfterBeforePaginationButtonIsEnabledOnTheContactDetailsPage(String buttonType) throws Exception {
        Assertions.expectToBeFalse(contactDetailsPo.isHeaderPaginationButtonByButtonTypeDisabled(StringUtils.getStringToLowerCase(buttonType)),
                "The '" + buttonType + "' pagination button is disabled");
    }

    public void thenTheEmailSMSViberChannelStatusIsDisplayedAsInactiveActive(ChannelOptionEnum channel, ActionModeTypeEnum actionMode) throws Exception {
        String channelValue;

        switch (channel) {
            case Email:
                channelValue = StringUtils.getStringBySlice(channel.getValue(), 0, 1);
                break;
            default:
                channelValue = StringUtils.getStringToLowerCase(channel.getValue());
                break;
        }

        switch (actionMode) {
            case Active:
                Assertions.expectToBeTrue(contactDetailsPo.isContactInfoChannelStatusByChannelValueActive(channelValue),
                        "The '" + channel + "' channel status is inactive");
                Assertions.expectToEqual(contactDetailsPo.getContactInfoChannelIconColorByChannelValue(channelValue), ColorFormatEnum.ActiveChannelHex,
                        "The '" + channel + "' channel status icon color is not green");
                break;
            case Inactive:
                Assertions.expectToBeFalse(contactDetailsPo.isContactInfoChannelStatusByChannelValueActive(channelValue),
                        "The '" + channel + "' channel status is active");
                Assertions.expectToEqual(contactDetailsPo.getContactInfoChannelIconColorByChannelValue(channelValue), ColorFormatEnum.InactiveChannelHex,
                        "The '" + channel + "' channel status icon color is not red");
                break;
		default:
			break;
        }
    }
}
