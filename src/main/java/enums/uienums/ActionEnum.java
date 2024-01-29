package enums.uienums;

public class ActionEnum {
	public enum ActionModeTypeEnum {
	    Disabled("disabled"),
	    Enabled("enabled"),
	    Created("created"),
	    Updated("updated"),
	    Canceled("canceled"),
	    Deleted("deleted"),
	    Active("active"),
	    Inactive("inactive");

	    private final String value;

	    ActionModeTypeEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	    @Override
	    public String toString() {
	        return value;
	    }
	}

	public enum SwitchTypeEnum {
	    Checked("checked"),
	    Unchecked("unchecked");

	    private final String value;

	    SwitchTypeEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum CheckboxActionTypeEnum {
	    Checks("checks"),
	    Unchecks("unchecks");

	    private final String value;

	    CheckboxActionTypeEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}


}
