package enums.uienums;

public class InputEnum {
	
	public enum CreateNewTemplateInputEnum {
	    Name("Name"),
	    Tags("Tags"),
	    Description("Description");

	    private final String value;

	    CreateNewTemplateInputEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum SpaceLocationInInputEnum {
	    Start("start"),
	    End("end");

	    private final String value;

	    SpaceLocationInInputEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}


}
