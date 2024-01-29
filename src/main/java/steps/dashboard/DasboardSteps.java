package steps.dashboard;

import java.util.List;

import basePackage.BasePo;
import enums.uienums.NotificationEnums.DashboardMessageEnum;
import helpers.Assertions;
import helpers.DataProviders;
import pages.dashboard.DashboardPo;

public class DasboardSteps extends BasePo {

	private static final Object AccountIsNotVerified = "Your account has not been verified. Please talk to your account manager or proceed to mobile number";
	private DashboardPo dashboardPo = new DashboardPo(driver);

	 public void whenTheUserClicksOnIntegrateSynchronizeAutomatePushNotificationSendACampaignLinkInTheQuickStartGuideOnTheDashboardPage(String option) throws Exception {
	        dashboardPo.clickOnServicesSetupOptionByName(option);
	    }

	    public void thenTheDashboardTitleIsCorrect(String title) throws Exception {
	        Assertions.expectToEqual(dashboardPo.getDashboardTitleText(), title, "The '" + title + "' title is incorrect");
	    }

	    public void thenTheQuickStartGuideTitleIsCorrect(String title) throws Exception {
	        Assertions.expectToEqual(dashboardPo.getQuickStartGuideTitleText(), title, "The '" + title + "' title is incorrect");
	    }

	    public void thenTheChannelSetupTitleIsCorrect(String title) throws Exception {
	        Assertions.expectToEqual(dashboardPo.getChannelSetupTitleText(), title, "The '" + title + "' title is incorrect");
	    }

	    public void thenTheChannelSetupTitleIsNotDisplayed() throws Exception {
	        Assertions.expectToBeFalse(dashboardPo.isChannelSetupTitleDisplayed(), "The Channel Setup title is displayed");
	    }

	    public void thenTheMessageThatTheAccountHasNotBeenVerifiedIsDisplayed() throws Exception {
	        Assertions.expectToEqual(dashboardPo.getUnverifiedUserMessageText(),  DashboardMessageEnum.AccountIsNotVerified,
	            "The message that the account has not been verified is not displayed");
	    }

	    public void thenTheQuickStartGuideChannelSetupServicesSetupItemsAreDisplayed(String option) {
	        List<String> quickStartGuideChannelSetupItemTextList = dashboardPo.getQuickStartGuideOptionTextListByOptionName(option);
	        Assertions.expectToEveryStringIncludeSomeValueFromArray(quickStartGuideChannelSetupItemTextList,
	           DataProviders.getQuickStartGuideOptionsTestDataByName(option), "The Quick Start guide '" + option + "' items are not displayed");
	    }

	    public void thenTheQuickStartGuideChannelSetupItemsAreNotDisplayed(String option) throws InterruptedException {
	        Assertions.expectToBeFalse(dashboardPo.isQuickStartGuideOptionByOptionNameDisplayed(option), "The Quick Start guide '" + option + "' items are displayed");
	    }

	    public void thenTheCountryStatsTabIsDisplayed(String tab) throws Exception {
	        List<String> headerTabTextList = dashboardPo.getDashboardHeaderTabTextList();
	        Assertions.expectToInclude(headerTabTextList, tab, "The '" + tab + "' tab is not displayed");
	    }

	    public void thenTheCountryViewIsDisplayedOnTheCountryStatsTab(String tab) throws Exception {
	        Assertions.expectToBeTrue(dashboardPo.isCountryViewDisplayed(tab), "The country view is not displayed on the '" + tab + "' tab");
	    }

	// Other methods...

}
