package enums.uienums;

public class LabelsEnum {

	public enum FallbackLabelsEnum {
	    FirstName("FirstName"),
	    LastName("LastName"),
	    Email("Email"),
	    Country("Country"),
	    Zip("Zip"),
	    SelectLabel("Select Label");

	    private final String value;

	    FallbackLabelsEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ContactLabelsEnum {
	    CustomField("CustomField");

	    private final String value;

	    ContactLabelsEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum CheckboxLabelsEnum {
	    OptInLabel("Append to message a Viber opt-in link."),
	    AddDuplicate("Also add duplicate contacts to the group");

	    private final String value;

	    CheckboxLabelsEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

}
