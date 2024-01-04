package enums.uienums;

public class OptionEnums {
	public enum SelectAudienceOptionEnum {
		Groups, Segments
	}

	public enum ChannelOptionEnum {
		SMS, Viber, Email
	}

	public enum ChannelStatusOptionEnum {
		Blacklist, Whitelist, OptIn, OptOut
	}

	public enum SetupTabListOptionEnum {
		Link, Form, LandingPage
	}

	public enum EmojiOptionEnum {
		GrinningFace, WinkingFace
	}

	public enum FormDropdownOptionEnum {
		Delete, Edit, Clone, Publish, Unpublish, View
	}

	public enum FromElementOptionEnum {
		Submit, ShortText, FileUpload
	}

	public enum FeedbackFieldOptionEnum {
		Email, FirstName, LastName, Inquiry
	}

	public enum ErrorValidationTypeOptionEnum {
		Letters, Numbers, NumbersAndLetters
	}

	public enum SettingsFormBuilderOptionEnum {
		Configuration, Submit
	}

	public enum MenuItemOptionEnum {
		MyCampaigns, LeadGeneration, Analytics, Communication, Settings, Automations, UserPlugins, Events,
		MyIntegrations, PushNotification, PushForMobileDevices, Forms, Email, ContactInsights, Jobs, MyTemplates,
		ChatBot, UnifiedChatBoard, Dashboard
	}

	public enum DomainTableStatusOptionEnum {
		Pending, NA
	}

	public enum ImplementationTypeOptionEnum {
		New, Default
	}

	public enum EventOptionEnum {
		NewAccountIsRegistered, NewOrderIsPlaced, NewProductIsAdded, OutOfStockProducts, NewOrderConfirmation,
		SuccessRegistration, PaymentConfirmation, OrderStatusChanged
	}

	public enum InstallationInputFieldOptionEnum {
		SiteName, SiteURL
	}

	public enum DateInputFieldOptionEnum {
		Start, End
	}

	public enum WorkflowOptionEnum {
		NewOrderIsPlaced, NewAccountIsRegistered
	}

	public  enum ContactsOptionEnum {
		FirstName, LastName, Country, Email, Mobile, MobileNumber, Groups, SMS, Viber, ChannelUse
	}

	public enum SubscriptionPlanOptionEnum {
		Premium, Pro
	}

	public enum EmailEditorSettingsOptionEnum {
		AdvancedMode, SimpleMode
	}

	public enum CountryOptionEnum {
		Germany, Greece, Jordan
	}

	public enum CountryCodeOptionEnum {
		DEU, GRC, JOR
	}

	public enum UserMenuOptionEnum {
		CurrentPlan, AccountSettings, Feedback, Logout
	}

	public enum ServicesSetupOptionEnum {
		Integrate, Synchronize, Automate, PushNotification, SendCampaign
	}

	public enum RouteePlaceholderOptionEnum {
		EnglishPlaceholder
	}

	public enum PlatformOptionEnum {
		Waymore, Routee
	}

	public enum SortTypeConditionOptionEnum {
		Ascending, Descending
	}

	public enum GeneralSettingsOptionEnum {
		NormalizePhoneNumbers, RespectQuietHours, URLShortener
	}

	public enum SenderIdOptionEnum {
		UseNumberAsASenderId, CustomSenderId
	}

	public enum SetUpOptionEnum {
		ChannelSetup, ServicesSetup
	}

	public enum PushOverviewPopoverIconEnum {
		SubscribedUsers, MonthlyActiveUsers, CampaignsSent
	}

	public enum ValidationServicesOptionEnum {
		NumberValidation, NumberLookup, EmailValidation
	}

	public enum EventFiltersOptionEnum {
		Event, Installation
	}
}
