package enums.uienums;

public class PopupEnum {
	
public enum CampaignAudiencePopupStatusEnum {
    GroupCreated("New group has been successfully created"),
    SegmentCreated("New segment has been successfully created!"),
    NameIsTaken("The name has already been taken."),
    FileSaved("The file has been successfully saved"),
    AllFields("Please, fill all fields"),
    RowsAreMissing("Rows are missing!");

    private final String value;

    CampaignAudiencePopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum SetupDialogPopupStatusEnum {
    EmailSuccessfullySent("Email has been successfully sent"),
    EmailSettingsSaved("Email settings have been successfully saved!"),
    SmsSettingsSaved("Sms settings have been successfully saved!"),
    ViberSettingsSaved("Viber settings have been successfully saved!"),
    SettingsSaved("Settings have been successfully saved!");

    private final String value;

    SetupDialogPopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum DomainPopupStatusEnum {
    DomainRemoved("The domain has been successfully removed"),
    FriendlyNameSaved("The friendly name has been successfully saved");

    private final String value;

    DomainPopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum FormsPopupStatusEnum {
    FormSaved("Your form has been saved!"),
    FormCreated("Your form has been created"),
    FormDeleted("Your form has been deleted!"),
    FormPublished("Your form has been published"),
    FormUnpublished("Your form has been unpublished");

    private final String value;

    FormsPopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum PushNotificationPopupStatusEnum {
    CodeCopied("Code Copied");

    private final String value;

    PushNotificationPopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum WorkflowPopupStatusEnum {
    WorkflowSaved("Your workflow has been saved!"),
    WorkflowDeactivated("Your workflow has been deactivated"),
    OrderStatusSaved("Order status(es) updated successfully");

    private final String value;

    WorkflowPopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum PushNotificationCampaignPopupStatusEnum {
    CampaignCreated("Campaign has been created"),
    CampaignUpdated("Campaign has been updated"),
    CampaignCanceled("Campaign has been canceled successfully"),
    CampaignRemoved("Campaign has been removed successfully");

    private final String value;

    PushNotificationCampaignPopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum PushNotificationImplementationPopupStatusEnum {
    ImplementationUpdated("Implementation has been updated"),
    InformationUpdated("The information has been updated successfully");

    private final String value;

    PushNotificationImplementationPopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum ContactsPopupStatusEnum {
    ContactsDeleted("Contact(s) successfully deleted"),
    ContactDeleted("Contact successfully deleted"),
    ContactsAddedToGroups("successfully added to"),
    GroupRemoved("successfully removed from"),
    ContactUpdated("contacts have been successfully updated!");

    private final String value;

    ContactsPopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum UploadFilePopupStatusEnum {
    FileUploaded("Your contacts file has been uploaded successfully."),
    HeadersAssociated("Your contacts headers have been associated"),
    AllFields("Please, fill all fields"),
    SomethingWentWrong("Something went wrong, please try again later");

    private final String value;

    UploadFilePopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum EmailEditorSettingsPopupStatusEnum {
    SettingsChanged("Your settings have been successfully changed");

    private final String value;

    EmailEditorSettingsPopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum ContactDetailsTagsAddedPopupStatusEnum {
    TagsAdded("Tags were successfully added"),
    TagsDeleted("Tags were successfully deleted");

    private final String value;

    ContactDetailsTagsAddedPopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum GeneralSettingsPopupStatusEnum {
    SettingsUpdated("Settings have been successfully updated!");

    private final String value;

    GeneralSettingsPopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum ViberSettingsPopupStatusEnum {
    ViberIdUpdated("The default Viber id has been successfully updated"),
    ViberInfoUpdated("Viber information has been successfully updated");

    private final String value;

    ViberSettingsPopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public enum EmailTemplatePopupStatusEnum {
    TemplateSaved("Template has been saved"),
    SettingsSaved("Template settings have been saved");

    private final String value;

    EmailTemplatePopupStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
}
