package steps.contactInsights;

import basePackage.BasePo;
import helpers.Assertions;

public class SegmentsSteps extends BasePo{

	    public void thenTheUserIsOnTheSegmentsPage() {
	        String currentUrl = driver.getCurrentUrl();
	        Assertions.expectToInclude(currentUrl, "/campaigns-manager/segment-list", "The URL of the Segments page is incorrect");
	    }
	}
