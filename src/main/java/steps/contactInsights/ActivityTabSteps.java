package steps.contactInsights;

import helpers.Assertions;
import pages.contactInsights.ActivityTabPo;

public class ActivityTabSteps {

    private ActivityTabPo activityTabPo = new ActivityTabPo();

    public void thenTheActivityTabIsDisplayedInTheContactDetailsPage(String tabName) throws Exception {
        Assertions.expectToBeTrue(activityTabPo.isTabByNameActive(tabName), "The '" + tabName + "' tab is not displayed");
    }

    public void thenTheSessionsHeaderIsDisplayedInTheActivityTab(String header) throws Exception {
        Assertions.expectToEqual(activityTabPo.getActivityTableHeaderText(), header, "The '" + header + "' header is not displayed in the Activity tab");
    }

    public void thenTheSessionsChartBarIsDisplayedInTheActivityTab() throws Exception {
        Assertions.expectToBeTrue(activityTabPo.isSessionsChartBarDisplayed(), "The Sessions chart bar is not displayed in the Activity tab");
    }

    public void thenTheSessionsPageviewsClicksInfoBlockIsDisplayedInTheActivityTab(String infoBlock) throws Exception {
        Assertions.expectToBeTrue(activityTabPo.isInfoBlockContentByNameDisplayed(infoBlock), "The '" + infoBlock + "' info block is not displayed in the Activity tab");
    }

    // Other methods...
}
