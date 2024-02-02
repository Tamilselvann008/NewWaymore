package enums.uienums;

public class ButtonEnum {
	
	public enum ButtonNameEnum {
	    OpenInNewTab("Open in new Tab"),
	    CopyLink("Copy Link"),
	    NextPage("Next page"),
	    PreviousPage("Previous page");

	    private final String value;

	    ButtonNameEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum EmailTemplateButtonNameEnum {
	    Close("Close"),
	    DontAskAgain("Don't ask again"),
	    Yes("Yes that'd be great"),
	    Continue("Continue"),
	    BrowseTemplates("Browse Templates"),
	    CreateNew("Create New"),
	    SaveAndContinue("Save and Continue"),
	    Save("Save");

	    private final String value;

	    EmailTemplateButtonNameEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }

       }
}
