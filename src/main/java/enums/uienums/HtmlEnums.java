package enums.uienums;

public class HtmlEnums {
	
	public enum AttributeEnum {
	    Href("href"),
	    NgSRC("ng-src"),
	    Class("class"),
	    AriaChecked("aria-checked"),
	    AriaSelected("aria-selected"),
	    MatRadioChecked("mat-radio-checked"),
	    Placeholder("placeholder"),
	    Disabled("disabled"),
	    AriaDisabled("aria-disabled"),
	    Draggable("draggable"),
	    AriaExpanded("aria-expanded"),
	    Readonly("readonly"),
	    Src("src"),
	    Tabindex("tabindex"),
	    Title("title"),
	    Content("content"),
	    Style("style"),
	    AriaControls("aria-controls"),
	    Value("value"),
	    AriaValueNow("aria-valuenow"),
	    MatTooltip("mattooltip");

	    private final String value;

	    AttributeEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ClassEnum {
	    IsActive("is-active"),
	    ActiveSettings("active-settings"),
	    MdChecked("md-checked"),
	    Active("active"),
	    MdActive("md-active"),
	    MatLabelActive("mat-tab-label-active"),
	    Danger("danger"),
	    UiDraggable("ui-draggable"),
	    ActiveColor("active-color");

	    private final String value;

	    ClassEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum CssValueEnum {
	    Width("width"),
	    BackgroundColor("background-color");

	    private final String value;

	    CssValueEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ColorFormatEnum {
	    InactiveChannelHex("#fb6868"),
	    ActiveChannelHex("#6cde9b");

	    private final String value;

	    ColorFormatEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum PseudoElementEnum {
	    Before("before"),
	    After("after");

	    private final String value;

	    PseudoElementEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum PropertyValueEnum {
	    Content("content");

	    private final String value;

	    PropertyValueEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}


}
