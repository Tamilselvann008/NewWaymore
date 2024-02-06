package steps.contactInsights;

import java.util.List;

import basePackage.BasePo;
import helpers.Assertions;
import pages.contactInsights.OverviewTabPo;

public class OverviewTabSteps extends BasePo {

    private final OverviewTabPo overviewTabPo = new OverviewTabPo(driver);

    public void thenTheUserCanSeeTheTotalValueForEachItemInOverviewTab(String value) {
        List<String> totalTextList = overviewTabPo.getOverviewPlaceholderTotalTextList();
        Assertions.expectToEveryStringEqualInArray(totalTextList, value,
                "The total value of '" + value + "' is not displayed correctly on the Overview Tab");
    }
}