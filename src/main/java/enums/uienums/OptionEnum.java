package enums.uienums;

public class OptionEnum {

	public enum SelectAudienceOptionEnum {
	    Groups("Groups"),
	    Segments("Segments");

	    private final String value;

	    SelectAudienceOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ChannelOptionEnum {
	    SMS("SMS"),
	    Viber("Viber"),
	    Email("Email");

	    private final String value;

	    ChannelOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ChannelStatusOptionEnum {
	    Blacklist("blacklist"),
	    Whitelist("whitelist"),
	    OptIn("opt in"),
	    OptOut("opt out");

	    private final String value;

	    ChannelStatusOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum SetupTabListOptionEnum {
	    Link("Link"),
	    Form("Form"),
	    LandingPage("Landing Page");

	    private final String value;

	    SetupTabListOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum EmojiOptionEnum {
	    GrinningFace("grinning squinting face"),
	    WinkingFace("winking face");

	    private final String value;

	    EmojiOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum FormDropdownOptionEnum {
	    Delete("delete"),
	    Edit("edit"),
	    Clone("clone"),
	    Publish("publish"),
	    Unpublish("unpublish"),
	    View("view");

	    private final String value;

	    FormDropdownOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum FromElementOptionEnum {
	    Submit("Submit"),
	    ShortText("Short text"),
	    FileUpload("File Upload");

	    private final String value;

	    FromElementOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum FeedbackFieldOptionEnum {
	    Email("email"),
	    FirstName("first name"),
	    LastName("last name"),
	    Inquiry("inquiry");

	    private final String value;

	    FeedbackFieldOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ErrorValidationTypeOptionEnum {
	    Letters("letters"),
	    Numbers("numbers"),
	    NumbersAndLetters("numbers and letters");

	    private final String value;

	    ErrorValidationTypeOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum SettingsFormBuilderOptionEnum {
	    Configuration("Configuration"),
	    Submit("Submit");

	    private final String value;

	    SettingsFormBuilderOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum MenuItemOptionEnum {
	    MyCampaigns("My Campaigns"),
	    LeadGeneration("Lead generation"),
	    Analytics("Analytics"),
	    Communication("Communication"),
	    Settings("Settings"),
	    Automations("Automations"),
	    UserPlugins("User Plugins"),
	    Events("Events"),
	    MyIntegrations("My Integrations"),
	    PushNotification("Push Notification"),
	    PushForMobileDevices("Push for Mobile Devices"),
	    Forms("Forms"),
	    Email("Email"),
	    ContactInsights("Contact Insights"),
	    Jobs("Jobs"),
	    MyTemplates("My Templates"),
	    ChatBot("ChatBot"),
	    UnifiedChatBoard("Unified Chat Board"),
	    Dashboard("Dashboard");

	    private final String value;

	    MenuItemOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum DomainTableStatusOptionEnum {
	    Pending("Pending"),
	    NA("N/A");

	    private final String value;

	    DomainTableStatusOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ImplementationTypeOptionEnum {
	    New("new"),
	    Default("default");

	    private final String value;

	    ImplementationTypeOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum EventOptionEnum {
	    NewAccountIsRegistered("New Account is Registered"),
	    NewOrderIsPlaced("New Order is Placed"),
	    NewProductIsAdded("New Product is Added"),
	    OutOfStockProducts("Out of Stock Products"),
	    NewOrderConfirmation("New Order Confirmation"),
	    SuccessRegistration("Success Registration"),
	    PaymentConfirmation("Payment Confirmation"),
	    OrderStatusChanged("Order Status Changed");

	    private final String value;

	    EventOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum InstallationInputFieldOptionEnum {
	    SiteName("Site Name"),
	    SiteURL("Site URL");

	    private final String value;

	    InstallationInputFieldOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum DateInputFieldOptionEnum {
	    Start("Start"),
	    End("End");

	    private final String value;

	    DateInputFieldOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum WorkflowOptionEnum {
	    NewOrderIsPlaced("New Order is Placed"),
	    NewAccountIsRegistered("New Account is Registered");

	    private final String value;

	    WorkflowOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ContactsOptionEnum {
	    FirstName("First Name"),
	    LastName("Last Name"),
	    Country("Country"),
	    Email("Email"),
	    Mobile("Mobile Phone"),
	    MobileNumber("Mobile Number"),
	    Groups("Groups"),
	    SMS("SMS"),
	    Viber("Viber"),
	    ChannelUse("Channel Use");

	    private final String value;

	    ContactsOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum SubscriptionPlanOptionEnum {
	    Premium("Premium"),
	    Pro("Pro");

	    private final String value;

	    SubscriptionPlanOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum EmailEditorSettingsOptionEnum {
	    AdvancedMode("Advanced Mode"),
	    SimpleMode("Simple Mode");

	    private final String value;

	    EmailEditorSettingsOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum CountryOptionEnum {
	    Germany("Germany"),
	    Greece("Greece"),
	    Jordan("Jordan");

	    private final String value;

	    CountryOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum CountryCodeOptionEnum {
	    DEU("DEU"),
	    GRC("GRC"),
	    JOR("JOR");

	    private final String value;

	    CountryCodeOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum UserMenuOptionEnum {
	    CurrentPlan("Current Plan"),
	    AccountSettings("Account settings"),
	    Feedback("Feedback"),
	    Logout("Logout");

	    private final String value;

	    UserMenuOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ServicesSetupOptionEnum {
	    Integrate("Integrate"),
	    Synchronize("Synchronize"),
	    Automate("Automate"),
	    PushNotification("Push Notification"),
	    SendCampaign("Send a campaign");

	    private final String value;

	    ServicesSetupOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum RouteePlaceholderOptionEnum {
	    EnglishPlaceholder("Please enter your email");

	    private final String value;

	    RouteePlaceholderOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum PlatformOptionEnum {
	    Waymore("Waymore"),
	    Routee("Routee");

	    private final String value;

	    PlatformOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum SortTypeConditionOptionEnum {
	    Ascending("Ascending"),
	    Descending("Descending");

	    private final String value;

	    SortTypeConditionOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum GeneralSettingsOptionEnum {
	    NormalizePhoneNumbers("Normalize Phone Numbers"),
	    RespectQuietHours("Respect the recipient's quiet hours"),
	    URLShortener("URL Shortener");

	    private final String value;

	    GeneralSettingsOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum SenderIdOptionEnum {
	    UseNumberAsASenderId("Use Number as a Sender Id"),
	    CustomSenderId("Custom Sender Id");

	    private final String value;

	    SenderIdOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum SetUpOptionEnum {
	    ChannelSetup("Channel Setup"),
	    ServicesSetup("Services Setup");

	    private final String value;

	    SetUpOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum PushOverviewPopoverIconEnum {
	    SubscribedUsers("Subscribed Users"),
	    MonthlyActiveUsers("Monthly Active Users"),
	    CampaignsSent("Campaigns Sent");

	    private final String value;

	    PushOverviewPopoverIconEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ValidationServicesOptionEnum {
	    NumberValidation("Number Validation"),
	    NumberLookup("Number Lookup"),
	    EmailValidation("Email Validation");

	    private final String value;

	    ValidationServicesOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum EventFiltersOptionEnum {
	    Event("Event"),
	    Installation("Installation");

	    private final String value;

	    EventFiltersOptionEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	
}
