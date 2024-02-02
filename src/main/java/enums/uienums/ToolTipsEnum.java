package enums.uienums;

public class ToolTipsEnum {

	public enum OptInTooltipEnum {
	    OptInTooltip("Switching on/off will delete the current message body");

	    private final String value;

	    OptInTooltipEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum DomainSettingsTooltipEnum {
	    AddAndVerifyDomain("Add and verify one or more domains to use as a 'form' address when you send emails." +
	            " For each domain add a sender profile to appear as 'sender' of your emails.");

	    private final String value;

	    DomainSettingsTooltipEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum RegistrationTooltipEnum {
	    EightCharacters("At least 8 characters"),
	    CapitalLetter("A capital letter"),
	    LowercaseLetter("A lowercase letter"),
	    SpecialCharacter("A special character"),
	    Number("A number");

	    private final String value;

	    RegistrationTooltipEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum PushOverviewTooltipEnum {
	    SubscribedUsers("This number is a count of devices who have opted-in and can receive your messages."),
	    MonthlyActiveUsers("An estimate of the number of users who have used your app in the last 30 days."),
	    CampaignsSent("The number of Campaigns that have been run for the selected implementation.");

	    private final String value;

	    PushOverviewTooltipEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum WebsiteSetupTooltipEnum {
	    SiteName("HTTPS Web Push. Site name is used as an identifier for this implementation"),
	    SiteUrl("On the URL enter the full URL of your Website. Push notification works only for HTTPS(SSL secured websites)");

	    private final String value;

	    WebsiteSetupTooltipEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}
	public enum FormsTooltipEnum {
	    AllFormFields("All fields of the form will be sent to Routee to be created as a contact.");

	    private final String value;

	    FormsTooltipEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

}
