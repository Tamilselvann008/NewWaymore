package enums.uienums;

public class NotificationEnums {

	public enum CampaignChannelsMessageEnum {
	    ContactsSelected("Contacts have been selected"),
	    SetupContent("Setup your campaign content & your fallbacks"),
	    CampaignChannelWarning("Unfortunately, the selected audience cannot be contacted from any of the available channels. Click back to select another segment to execute a campaign.");

	    private final String value;

	    CampaignChannelsMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum CampaignManagerMessageEnum {
	    Successfully("SUCCESSFULLY!");

	    private final String value;

	    CampaignManagerMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ConfirmDialogMessageEnum {
	    DeleteCampaign("All data of this campaign will be forever lost and you will not be able to recover it."),
	    DeleteImplementation("All data of this contact, including information, campaign data, statistics, and activity will be forever lost, and you will not be able to recover them."),
	    DeleteContacts("If you continue, all information about selected contacts, including contact details, campaign data, statistics, and activity will be lost, and you will not be able to recover them."),
	    DeleteContact("If you continue, all information about the selected contact, including contact details, campaign data, statistics, and activity will be lost, and you will not be able to recover them."),
	    DeleteDomain("Are you sure you want to delete this domain? All your information and settings will be lost."),
	    EditData("Editing the selected campaign will set it as Draft up to the point you finish editing. Do you want to continue?"),
	    EnterDelete("Enter DELETE to confirm.");

	    private final String value;

	    ConfirmDialogMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum SetupDialogMessageEnum {
	    SenderIdWarning("Alphanumeric Sender IDs may be up to 11 characters. Special characters are not allowed. Numeric number may be up to 16 characters"),
	    FieldRequired("This field is required"),
	    AttachmentWarning("Attachments totals exceed the limits. Please try again."),
	    TotalFilesLimit("You have reached your total files limit"),
	    FileAlreadyUploaded("This file has been already uploaded"),
	    MinLength("Min length characters should be > 3 characters"),
	    MaxLength("Max length characters should be < 60 characters"),
	    InvalidURL("Invalid URL"),
	    MissingURL("Kindly provide a valid URL");

	    private final String value;

	    SetupDialogMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ScheduleDialogMessageEnum {
	    DatePassed("This date has passed. Please choose another"),
	    DateAfterEmailFallback("The selected date cannot be later than the fallback date of the emails.");

	    private final String value;

	    ScheduleDialogMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum PreviewDialogMessageEnum {
	    NotFinished("Set up is not finished!");

	    private final String value;

	    PreviewDialogMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum FormDialogMessageEnum {
	    FormNameRequired("Form name is required."),
	    PhoneFormElement("Please consider that Phone Form Element will be added to your form."),
	    EnablingNumberValidationService("By enabling Number Validation Service, your form submissions' contacts will be inserted into different groups by number Type. * Number Validation Service is charged by request"),
	    GroupExists("The same group already exists!");

	    private final String value;

	    FormDialogMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum SelectAudienceDialogMessageEnum {
	    SelectRecipients("Select recipients from the menu on the left"),
	    ItemAlreadyInList("This item is already in the list");

	    private final String value;

	    SelectAudienceDialogMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum FormBuilderPageMessageEnum {
	    RemovePhoneElement("Are you sure you want to remove the Phone Element?\nAdd form submissions as Routee contacts is enabled. By removing the phone element, your Routee Contact Settings will be disabled"),
	    SubmitFormMessageEnum("Thank You!\nYour submission has been received."),
	    UnverifiedAccount("Your account is not verified yet, please verify your account first in order to publish");

	    private final String value;

	    FormBuilderPageMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ContactInsightsMessageEnum {
	    AllResultsSelected("All results on this page are selected."),
	    NoResultsMatchSearch("No results match your search\nRefine your search and try again");

	    private final String value;

	    ContactInsightsMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum CreateContactMessageEnum {
	    AddValidPhoneNumber("Please add a valid phone number");

	    private final String value;

	    CreateContactMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum LoginPageMessageEnum {
	    FieldRequired("This field is required"),
	    InvalidPasswordLogin("Invalid Username or Password"),
	    InvalidPasswordAndValidEmail("Something went wrong. Please try again later"),
	    InvalidEmail("Please enter a valid email address"),
	    InvalidData("The given data was invalid"),
	    BadCredentials("Bad credentials");

	    private final String value;

	    LoginPageMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum RegistrationPageMessageEnum {
	    FieldRequired("This field is required"),
	    CheckBox("Please check the box in order to continue"),
	    Recaptcha("Please verify that you are not a robot"),
	    ValidEmail("Please enter a valid email address. Email must contain a single @ and a valid domain."),
	    ReviewYourPassword("Please review your password"),
	    PasswordsDontMatch("Passwords do not match");

	    private final String value;

	    RegistrationPageMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum RouteeMessageEnum {
	    ErrorMessage("×\nError\nWrong username or password. Please try again!");

	    private final String value;

	    RouteeMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum PrimaryChannelMessageEnum {
	    ViberOptIn("This message includes a Viber Opt-in option."),
	    OverviewViberOptIn("Message includes Viber Opt-In link");

	    private final String value;

	    PrimaryChannelMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ViberChannelSettingsMessageEnum {
	    ActivateBViberId("In order to use Viber Campaign Service you must first register a Sender ID. The process is very easy and you can find the form that you must fill pressing the button below");

	    private final String value;

	    ViberChannelSettingsMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum EmailTemplatesMessageEnum {
	    InputNameErrorMessage("255 characters max, cannot contain special chars(@!&^%) and should not be started and ended with spaces"),
	    AskingToEnterTheName("Please enter name"),
	    EmptyContent("Nothing to show. Click on the New Template Button. Select a ready-to-go template from the template library");

	    private final String value;

	    EmailTemplatesMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum SubscriptionMessageEnum {
	    InsufficientBalance("Subscription transition failed due to insufficient balance!");

	    private final String value;

	    SubscriptionMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ErrorDialogRequiredMessageEnum {
	    InquiryMissing("Inquiry is missing"),
	    FirstNameMissing("First Name is missing"),
	    LastNameMissing("Last Name is missing"),
	    EmailMissing("Email is missing"),
	    FallbackIsRequired("fallback is required."),
	    FileUpload("Type a Question[File Upload] is required"),
	    ShortTextOnlyNumbers("Short text must be only numbers"),
	    ShortTextOnlyLetters("Short text must be only letters"),
	    ShortTextOnlyNumbersAndLetters("Short text must be only numbers and letters"),
	    InvalidExtension("Below Files have invalid extension:");

	    private final String value;

	    ErrorDialogRequiredMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum SetUpTheAutomatedSmsMessageEnum {
	    SenderIdWarning("Alphanumeric Sender IDs may be up to 11 characters. Special characters are not allowed");

	    private final String value;

	    SetUpTheAutomatedSmsMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum DashboardMessageEnum {
	    AccountIsNotVerified("Your account has not been verified. Please talk to your account manager or proceed to mobile number verification after login in Routee platform (with the same credentials) here");

	    private final String value;

	    DashboardMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum SmsChannelSettingsEnum {
	    SenderIdErrorMessage("Please specify a non-empty SenderId");

	    private final String value;

	    SmsChannelSettingsEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ChannelPreferencesDialogMessageEnum {
	    GrayListMessage("You are about to graylist this contact. By that, status for all channels will turn to UNKNOWN. Do you want to continue?"),
	    BlackListMessage("You are about to blacklist this contact. By that, status for all channels will turn to OPT OUT. Do you want to continue?");

	    private final String value;

	    ChannelPreferencesDialogMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public enum ConfigureWebPushMessageEnum {
	    PersonalizedMessages("We will send you occasional personalized messages when we have something great to share!");

	    private final String value;

	    ConfigureWebPushMessageEnum(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	
}
