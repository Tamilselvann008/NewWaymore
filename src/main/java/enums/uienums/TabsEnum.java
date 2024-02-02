package enums.uienums;

public class TabsEnum {
	public enum HeaderTabNameEnum {
	    DownloadTemplateFile("DOWNLOAD TEMPLATE FILE");

	    private final String value;

	    HeaderTabNameEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum PushHeaderMenuTabNameEnum {
	    Campaigns("Campaigns"),
	    Overview("Overview"),
	    Configuration("Configuration"),
	    PushNotifications("Push Notifications");

	    private final String value;

	    PushHeaderMenuTabNameEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum EmailTemplatesTabNameEnum {
	    Published("Published"),
	    Draft("Draft"),
	    Deleted("Deleted"),
	    Events("Events");

	    private final String value;

	    EmailTemplatesTabNameEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum UploadContactsStepTabNameEnum {
	    Upload("Upload"),
	    Match("Match"),
	    Inspect("Inspect"),
	    Assign("Assign");

	    private final String value;

	    UploadContactsStepTabNameEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}


}
