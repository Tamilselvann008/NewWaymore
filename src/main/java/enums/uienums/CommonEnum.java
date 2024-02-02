package enums.uienums;

public class CommonEnum {
	
	public enum BrowsersEnum {
	    Chrome("chrome");

	    private final String value;

	    BrowsersEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ConsoleErrorEnum {
	    InternalServerError("Internal Server Error"),
	    BadGateway("Bad Gateway"),
	    ServiceTemporarilyUnavailable("Service Temporarily Unavailable"),
	    GatewayTimeout("Gateway Timeout"),
	    TypeError("TypeError");

	    private final String value;

	    ConsoleErrorEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum CucumberReportInfoPathEnum {
	    ChromePath(".tmp/reportInfoListChrome.json"),
	    TmpPath(".tmp");

	    private final String value;

	    CucumberReportInfoPathEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ScenarioResultStatusEnum {
	    UNKNOWN(0),
	    PASSED(1),
	    SKIPPED(2),
	    PENDING(3),
	    UNDEFINED(4),
	    AMBIGUOUS(5),
	    FAILED(6);

	    private final int value;

	    ScenarioResultStatusEnum(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	}

	public enum IssueLabelEnum {
	    Regression("Regression"),
	    BDDScenario("BDD_Scenario");

	    private final String value;

	    IssueLabelEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}


}
