package pages.contactInsights;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import actions.Action;
import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.StringUtils;
import helpers.Waiters;

public class UploadFileWithContactsPo extends BasePo {
	private static final Object CustomField = "CustomField";
	private static final String Width = "width";
	private static final String Placeholder = "placeholder";
	private static final String Disabled = "disabled";
	private By uploadFileTitle = By.cssSelector(".contacts-upload__container h2");
	private By uploadedFileInfo = By.cssSelector("wm-file-uploader div div .ng-star-inserted");
	private By progressBarStatus = By
			.cssSelector("wm-contacts-uploading-progress-bar .contacts-uploading-progress-bar span");
	private By progressBarCloseButton = By
			.cssSelector("wm-contacts-uploading-progress-bar .contacts-uploading-progress-bar__close");
	private By continueButton = By.cssSelector("wm-progress-button button");
	private By continueButtonLoading = By.cssSelector("button.loading");
	private By validSummaryItemInfo = By
			.cssSelector(".wm-upload-contacts__uploader .wm-upload-contacts__summary-item.is-valid");
	private By invalidSummaryItemInfo = By
			.cssSelector(".wm-upload-contacts__summary .wm-upload-contacts__summary-item.is-invalid");
	private By duplicateSummaryItemInfo = By
			.cssSelector(".wm-upload-contacts__uploader .wm-upload-contacts__summary-item.is-duplicated");
	private By addNewGroupNameInput = By.cssSelector("#name");
	private By finishButton = By.cssSelector("wm-progress-button .wm-dialog__btn");
	private By existingGroupDropdown = By.cssSelector("div .autocomplete-wrapper");
	private By existingGroupDropdownOption = By.cssSelector("[role=\"listbox\"] mat-option");
	private By existingGroupOptionsContent = By.cssSelector("[role=\"listbox\"]");
	private By downloadTemplateLink = By.cssSelector(".wm-upload-contacts__tab-info .wm-link");
	private By downloadBar = By.cssSelector("div.download-bar");
	private By downloadBarTitle = By.cssSelector(".download-bar .wm-dialog__body-title");
	private By downloadButton = By.cssSelector(".wm-dialog__download-template-action a");
	private By downloadBarCloseButton = By.cssSelector(".download-bar .wm-dialog__close");
	private By skipAllRemainingFieldsButton = By
			.cssSelector(".wm-upload-contacts__matches-controls-actions button:last-child");
	private By clearButton = By.cssSelector("button.form__control-uploader-clear");
	private By resetAllButton = By.cssSelector(".wm-upload-contacts__matches-controls-actions button:first-child");
	private By startOverLink = By.cssSelector("div .wm-link");
	private By dropdownChannelOption = By.cssSelector(".mat-select-panel-wrap mat-option");
	private By dropdownChannelOptionCheckboxLabel = By.cssSelector("mat-option mat-checkbox label");
	private By backdrop = By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing");
	private By localPhoneSwitch = By.cssSelector("mat-slide-toggle .mat-slide-toggle-bar input");
	private By columnName = By.cssSelector(".wm-upload-contacts__matches-item .wm-upload-contacts__matches-col-name");
	private By inputNewLabelField = By.cssSelector(".cdk-overlay-container input[name=\"name\"]");
	private By addNewLabelButton = By.cssSelector(".cdk-overlay-container button.add-icon mat-icon");
	private By uploadErrorMessage = By.cssSelector("div.form__control-uploader-info span");
	private By normalizeCountryDropdown = By.cssSelector(".wm-upload-contacts__matches-controls [role=\"combobox\"]");
	private By normalizeCountryDropdownOption = By.cssSelector("[role=\"listbox\"] mat-option:not(.hide-option)");
	private By normalizeCountryDropdownWidth = By.cssSelector("div.mat-select-panel");
	private By normalizeCountryDropdownOptionWidth = By.cssSelector("mat-option.mat-option.mat-active");
	private By normalizeCountryDropdownSearchInput = By.cssSelector("input[name=\"countrySearch\"]");
	private By selectedCountryCode = By
			.cssSelector(".wm-upload-contacts__matches-controls-normalize .mat-select-value-text");
	private By addDuplicatesCheckbox = By.cssSelector("mat-checkbox.mat-checkbox.wm-checkbox label input");
	private By addDuplicatesCheckboxLabel = By.cssSelector("mat-checkbox label .mat-checkbox-label");
	private By labelsLoader = By.cssSelector("div.progress-spinner");
	private By groupLoader = By.cssSelector("md-content md-progress-circular[ng-if=\"vm.isLoadMore\"]");
	private By rightPopupNotification = By.cssSelector("wm-toast-message span");

	private By downloadFileButtonByName(String button) {
        return By.xpath("//span[contains(text(), \"" + button + "\")]");
    }

    private By campaignAudienceLabelDropdownByValue(String label) {
        return By.xpath("//div[text()=\"" + label + "\"]/following-sibling::div[1]//div[contains(@class,'mat-select-arrow-wrapper')]");
    }

    private By campaignAudienceLabelDropdownOption() {
        return By.cssSelector("mat-optgroup mat-option .mat-option-text");
    }

    private By radioButtonByValue(String value) {
        return By.cssSelector("mat-radio-button:has(input[value=\"" + value + "\"])");
    }

    private By selectLabelDropdownOption() {
        return By.cssSelector(".wm-upload-contacts__matches-col .mat-select");
    }

    private By campaignAudienceUseForDropdown() {
        return By.cssSelector(".wm-upload-contacts__matches-col mat-select.mat-select-multiple");
    }

    private By skipMatchesColumnByValue(String option) {
        return By.xpath("//div[text()=\"" + option + "\"]/following-sibling::div[contains(text(), 'Skipped')]");
    }

    private By campaignAudienceLabelDropdownSkipOption() {
        return By.cssSelector(".mat-select-panel mat-option[value='skip'] span");
    }

    private By selectNewLabelTypeDropdown(String label) {
        return By.xpath("//div[text()=\"" + label + "\"]/following-sibling::div[2]//div[contains(@class, 'mat-select-trigger')]");
    }

    private By selectNewLabelTypeDropdownOption() {
        return By.cssSelector(".mat-select-panel-wrap mat-option span");
    }

    private By tabByStepName(String stepName) {
        return By.xpath("//md-tab-item[contains(.,'" + stepName + "')]");
    }
	
	
	public UploadFileWithContactsPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ...continuing from the previous class definition

	public boolean isDownloadBarElementDisplayed() throws InterruptedException {
		return Action.isElementDisplayedByLocator(downloadBar, 0);
	}

	public boolean isRadioButtonByNameChecked(String buttonName) throws InterruptedException {
		return Action.isElementCheckedByLocator(radioButtonByValue(buttonName));
	}

	public void typeTextInAddNewGroupNameInputField(String value) throws InterruptedException {
		Action.clearTextInLocatorAndTypeText(addNewGroupNameInput, value);
	}

	public String getUploadFileTitleText() throws Exception {
		Waiters.waitForElementToBeDisplayed(uploadFileTitle);
		return ElementUtils.getTextByLocator(uploadFileTitle, 0);
	}

	public String getUploadFileText() throws Exception {
		Waiters.waitForElementToBeDisplayed(uploadFileTitle);
		Waiters.waitWithSleepTimeout(2500);
		return ElementUtils.getTextByLocator(uploadedFileInfo, 0);
	}

	public String getProgressBarStatusText() throws Exception {
		Waiters.waitForElementToBeNotVisible(continueButtonLoading);
		Waiters.waitForElementToBeDisplayed(progressBarStatus);
		return ElementUtils.getTextByLocator(progressBarStatus, 0);
	}

	public void clickOnClosePopupButton() throws Exception {
		Action.clickWithJSByLocator(progressBarCloseButton, 0);
		Waiters.waitForElementToBeInvisible(progressBarStatus);
		Waiters.waitWithSleepTimeout(2500);
	}

	public WebElement getContinueButtonElement() throws Exception {
		Waiters.waitForElementToBeDisplayed(continueButton);
		return ElementUtils.getElementByLocator(continueButton, 0);
	}

	public void clickOnContinueButton() throws Exception {
		Waiters.waitForElementToBeEnabled(continueButton);
		Action.clickWithJSByLocator(continueButton, 0);
		Waiters.waitForElementToBeNotVisible(continueButtonLoading);
		Waiters.waitWithSleepTimeout(2500);
	}

	public void clickOnClearButton() throws Exception {
		Action.clickWithJSByLocator(clearButton, 0);
	}

	public void clickOnResetAllButton() throws Exception {
		Action.clickByLocator(resetAllButton, 0);
	}

	public void clickOnStartOverLink() throws Exception {
		Action.clickByLocator(startOverLink, 0);
	}

	public void clickOnDownloadTemplateLink() throws Exception {
		Action.clickByLocator(downloadTemplateLink, 0);
	}

	public String getDownloadBarTitleText() throws Exception {
		return ElementUtils.getTextByLocator(downloadBarTitle, 0);
	}

	public void clickOnDownloadFileButtonByName(String button) throws Exception {
		Action.clickByLocator(downloadFileButtonByName(button), 0);
	}

	public void clickOnDownloadButton() throws Exception {
		Action.clickWithJSByLocator(downloadButton, 0);
		Waiters.waitWithSleepTimeout(1000);
	}

	public void clickOnDownloadBarCloseButton() throws Exception {
		Action.clickByLocator(downloadBarCloseButton, 0);
	}

	public void clickOnSkipAllRemainingFieldsButton() throws Exception {
		Action.clickByLocator(skipAllRemainingFieldsButton, 0);
	}

	public List<String> getSkippedFieldList() throws InterruptedException {
		List<String> skippedFieldList = new ArrayList<>();
		List<String> columnNameList = ElementUtils.getTextListWithJSByLocator(columnName);

		for (int i = 0; i < columnNameList.size(); i++) {
			boolean isSkipped = Action.isElementDisplayedByLocator(skipMatchesColumnByValue(columnNameList.get(i)), i);
			if (isSkipped) {
				skippedFieldList.add(columnNameList.get(i));
			}
		}

		return skippedFieldList;
	}

	public void selectAssociatedValueFromDropdownByOptionName(String label, String optionName, int index, int maxRetryAttempts) throws Exception {
	    int retryCount = 1;
	    List<String> optionList = new ArrayList<>();
	    int optionIndex = 0;

	    this.clickOnLabelDropdownByLabelName(label, index);

	    while (retryCount <= maxRetryAttempts) {
	        optionList = this.getLabelDropdownOptionList();
	        optionList = optionList.stream().map(StringUtils::getStringByTrim).collect(Collectors.toList());
	        optionIndex = optionList.indexOf(optionName);

	        if (optionIndex >= 0) {
	            break;
	        }
	        Action.scrollToElementWithJsByLocator(campaignAudienceLabelDropdownOption(), optionList.size() - 2);
	        Waiters.waitForElementToBeInvisible(labelsLoader);

	        if (retryCount >= maxRetryAttempts) {
	            throw new Exception("The option '" + optionName + "' isn't exist in dropdown");
	        }
	        retryCount++;
	    }

	    Action.clickWithJSByLocator(campaignAudienceLabelDropdownOption(), optionIndex);
	    Waiters.waitWithSleepTimeout(2500);
	}


	public void selectOrSkipFieldFromDropdownByOptionName(String label, String optionName, String skipField, int index) throws Exception {
	    this.clickOnLabelDropdownByLabelName(label, index);
	    Waiters.waitWithSleepTimeout(2000);
	    List<String> optionList = this.getLabelDropdownOptionList();

	    for (String option : optionList) {
	        if (option.equals(optionName)) {
	            if (option.equals(skipField)) {
	                WebElement skipElement = ElementUtils.getElementByLocator(campaignAudienceLabelDropdownSkipOption(), index);
	                Action.clickWithJSByElement(skipElement, index);
	                return;
	            }
	            Action.clickWithJSByLocator(campaignAudienceLabelDropdownOption(), optionList.indexOf(option));
	            return;
	        }
	        Waiters.waitWithSleepTimeout(2500);
	    }
	}

	 

	public void clickOnFinishButton() throws Exception {
	    Waiters.waitForElementToBeEnabled(finishButton);
	    Action.clickWithJSByLocator(finishButton, 0);
	    Waiters.waitWithSleepTimeout(3000);
	}

	public void clickOnLabelDropdownByLabelName(String label, int index) throws Exception {
	    Waiters.waitForElementToBeDisplayed(campaignAudienceLabelDropdownByValue(label));
	    Action.clickWithJSByLocator(campaignAudienceLabelDropdownByValue(label), index);
	}

	public List<String> getLabelDropdownOptionList() throws InterruptedException {
	    List<String> optionList = ElementUtils.getTextListWithJSByLocator(campaignAudienceLabelDropdownOption());
	    return optionList.stream().map(StringUtils::getStringByTrim).collect(Collectors.toList());
	}

	// ...continuing from the previous class definition

	public void selectOrAddCustomFieldFromDropdownByOptionName(String label, String optionName, String customField, int index) throws Exception {
	    this.clickOnLabelDropdownByLabelName(label, index);
	    List<String> optionList = this.getLabelDropdownOptionList();

	    if (label.equals(CustomField)) {
	        Action.clickWithJSByLocator(inputNewLabelField, index);
	        Action.clearTextInLocatorAndTypeText(inputNewLabelField, customField);
	        Action.clickWithJSByLocator(addNewLabelButton, index);
	        Waiters.waitForElementToBeDisplayed(selectNewLabelTypeDropdown(label));
	        Action.clickWithJSByLocator(selectNewLabelTypeDropdown(label), index);
	        List<String> typeList = ElementUtils.getTextListWithJSByLocator(selectNewLabelTypeDropdownOption());

	        if (typeList.contains(customField)) {
	            Action.clickWithJSByLocator(selectNewLabelTypeDropdownOption(), typeList.indexOf(customField));
	        }
	        return;
	    }

	    if (optionList.contains(optionName)) {
	        Action.clickWithJSByLocator(campaignAudienceLabelDropdownOption(), optionList.indexOf(optionName));
	        Waiters.waitWithSleepTimeout(1000);
	    }
	}



	public void selectSpecificChannelFromDropdownByChannelName(String channel) throws Exception {
	    Waiters.waitWithSleepTimeout(1000);
	    Waiters.waitForElementToBeDisplayed(campaignAudienceUseForDropdown());
	    Action.clickByLocator(campaignAudienceUseForDropdown(), 0);
	    List<String> channelList = ElementUtils.getTextListWithJSByLocator(dropdownChannelOption);
	    channelList = channelList.stream().map(StringUtils::getStringByTrim).collect(Collectors.toList());

	    for (int i = 0; i < channelList.size(); i++) {
	        if (channelList.get(i).equals(channel)) {
	            boolean isChecked = Action.isElementSelectedByLocator(dropdownChannelOptionCheckboxLabel);
	            if (!isChecked) {
	                Action.clickWithJSByLocator(dropdownChannelOptionCheckboxLabel, i);
	            }
	        } else {
	            Action.clickWithJSByLocator(dropdownChannelOptionCheckboxLabel, i);
	        }
	    }
	    Action.clickWithJSByLocator(backdrop, 0);
	    Waiters.waitWithSleepTimeout(2500);
	}

	// ...continuing from the previous class definition

	public void uncheckLocalPhoneSwitch() throws Exception {
	    boolean isChecked = Action.isElementCheckedByLocator(localPhoneSwitch);

	    if (isChecked) {
	        Action.clickWithJSByLocator(localPhoneSwitch, 0);
	    }
	}

	public String getValidSummaryItemInfoText() throws Exception {
	    Waiters.waitWithSleepTimeout(1000);
	    Waiters.waitForElementToBeDisplayed(validSummaryItemInfo);
	    return ElementUtils.getTextByLocator(validSummaryItemInfo, 0);
	}

	public String getInvalidSummaryItemInfoText() throws Exception {
	    Waiters.waitWithSleepTimeout(1000);
	    Waiters.waitForElementToBeDisplayed(invalidSummaryItemInfo);
	    return ElementUtils.getTextByLocator(invalidSummaryItemInfo, 0);
	}

	public String getDuplicateSummaryItemInfoText() throws Exception {
	    Waiters.waitWithSleepTimeout(1000);
	    Waiters.waitForElementToBeDisplayed(duplicateSummaryItemInfo);
	    return ElementUtils.getTextByLocator(duplicateSummaryItemInfo, 0);
	}

	public boolean isAddDuplicateCheckboxElementDisplayed() throws InterruptedException {
	    return Action.isElementDisplayedByLocator(addDuplicatesCheckbox, 0);
	}

	public boolean isAddDuplicateCheckboxChecked() throws InterruptedException {
	    return Action.isElementCheckedByLocator(addDuplicatesCheckbox);
	}

	public String getAddDuplicatesCheckboxLabelText() throws Exception {
	    return ElementUtils.getTextByLocator(addDuplicatesCheckboxLabel, 0);
	}

	public void selectAddDuplicateContactsCheckboxByStatus(String checkboxStatus) throws Exception {
	    Action.selectCheckboxByLocatorAndStatus(addDuplicatesCheckbox, checkboxStatus);
	}

	public void clickOnRadioButtonByValue(String value) throws Exception {
	    Action.clickByLocator(radioButtonByValue(value), 0);
	}

	public void clickOnExistingGroupDropdown() throws Exception {
	    Waiters.waitForElementToBeDisplayed(existingGroupDropdown);
	    Action.clickWithJSByLocator(existingGroupDropdown, 0);
	    Waiters.waitForElementToBeDisplayed(existingGroupDropdownOption);
	}

	public int getExistingGroupDropdownWidth() throws Exception {
	    Waiters.waitForElementToBeDisplayed(existingGroupDropdown);
	    String width = ElementUtils.getCssValueByElement(existingGroupDropdown, Width, 0);

	    return StringUtils.getRoundedNumber(Integer.parseInt(width) - 2); // 2 -> it's a border 2px;
	}

	public int getExistingGroupDropdownOptionsWidth() throws Exception {
	    Waiters.waitForElementToBeDisplayed(existingGroupDropdownOption);
	    String width = ElementUtils.getCssValueByElement(existingGroupOptionsContent, Width, 0);

	    return StringUtils.getRoundedNumber(Integer.parseInt(width));
	}

	public void selectGroupOptionFromDropdownByName(String optionName, int index) throws Exception {
	    Waiters.waitForElementToBeDisplayed(existingGroupDropdown);
	    Action.clickByLocator(existingGroupDropdown, index);
	    Waiters.waitForElementToBeVisible(existingGroupOptionsContent);
	    Waiters.waitForElementToBeNotVisible(groupLoader);
	    List<String> optionList = ElementUtils.getTextListWithJSByLocator(existingGroupDropdownOption);
	    optionList = optionList.stream().map(StringUtils::getStringByTrim).collect(Collectors.toList());

	    int optionIndex = optionList.indexOf(optionName);
	    Action.clickByLocator(existingGroupDropdownOption, optionIndex);
	    Waiters.waitWithSleepTimeout(2500);
	}

	// ...continuing from the previous class definition

	public List<String> getSelectLabelDropdownOptionAttributeList() throws Exception {
	    List<String> attributeList = new ArrayList<>();
	    List<WebElement> labelList = ElementUtils.getElementListWithWaitByLocator(selectLabelDropdownOption());

	    for (int i = 0; i < labelList.size(); i++) {
	        String attribute = ElementUtils.getAttributeByLocator(selectLabelDropdownOption(), Placeholder, i);
	        attributeList.add(attribute);
	    }

	    return attributeList;
	}

	public boolean isNewLabelTypeDropdownDisplayed(String label) throws InterruptedException {
	    return Action.isElementDisplayedByLocator(selectNewLabelTypeDropdown(label), 0);
	}

	public String getUploadErrorMessageText() throws Exception {
	    return ElementUtils.getTextByLocator(uploadErrorMessage, 0);
	}

	public void selectCountryFromDropdownByCountryValue(String countryOption) throws Exception {
	    clickOnNormalizeCountryDropdown();
	    List<String> countryResultList = ElementUtils.getTextListWithJSByLocator(normalizeCountryDropdownOption);
	    countryResultList = countryResultList.stream()
	                                         .map(country -> StringUtils.getStringBySplit(country, " ",0))
	                                         .collect(Collectors.toList());
	    int countryIndex = countryResultList.indexOf(countryOption);
	    Action.clickWithJSByLocator(normalizeCountryDropdownOption, countryIndex);
	    Waiters.waitForElementToBeInvisible(normalizeCountryDropdownOption);
	}

	public String getSelectedCountryName() throws Exception {
	    return ElementUtils.getTextWithJSByLocator(selectedCountryCode, 0);
	}

	public boolean isNormalizePhoneNumbersCheckboxChecked() throws InterruptedException {
	    return Action.isElementCheckedByLocator(localPhoneSwitch);
	}

	public boolean isNormalizePhoneNumbersCheckboxDisplayed() throws InterruptedException {
	    return Action.isElementDisplayedByLocator(localPhoneSwitch, 0);
	}

	public void checkLocalPhoneSwitch() throws Exception {
	    boolean isChecked = Action.isElementCheckedByLocator(localPhoneSwitch);

	    if (!isChecked) {
	        Action.clickWithJSByLocator(localPhoneSwitch, 0);
	    }
	}

	public void clickOnNormalizeCountryDropdown() throws Exception {
	    Action.clickByLocator(normalizeCountryDropdown, 0);
	    Waiters.waitForElementToBeDisplayed(normalizeCountryDropdownOption);
	}

	public int getNormalizePhoneNumbersDropdownWidth() throws Exception {
	    Waiters.waitForElementToBeDisplayed(normalizeCountryDropdownWidth);
	    WebElement element = ElementUtils.getElementByLocator(normalizeCountryDropdownWidth, 0);
	    String widthValue = element.getCssValue("width");
	    int parsedWidth = Integer.parseInt(widthValue.replace("px", ""));

	    // Check the OS type and adjust the width value accordingly
	    String osType = System.getProperty("os.name").toLowerCase();
	    if (osType.contains("win")) {
	        return StringUtils.getRoundedNumber(parsedWidth - 21);
	    } else {
	        return StringUtils.getRoundedNumber(parsedWidth - 15);
	    }
	}


	public int getNormalizePhoneNumbersDropdownOptionsWidth() throws Exception {
	    Waiters.waitForElementToBeDisplayed(normalizeCountryDropdownOptionWidth);
	    WebElement element = ElementUtils.getElementByLocator(normalizeCountryDropdownOptionWidth, 0);
	    String widthValue = element.getCssValue("width");

	    // Assuming StringUtils.getRoundedNumber() rounds a double to the nearest integer
	    return StringUtils.getRoundedNumber(Double.parseDouble(widthValue.replace("px", "")));
	}



	public String getDataFromTxtFile(String filePath) throws InterruptedException {
	    String fileData = StringUtils.replaceAllStringForValue(filePath, "\\s+", " ");

	    return StringUtils.getStringBySlice(fileData, StringUtils.getMatchStringIndexByRegExp(fileData, "AQA"), 0);
	}

	public String getDataFromCsvFile(String filePath) throws InterruptedException {
	    String fileData = StringUtils.replaceAllStringForValue(filePath, "\\r\\n", " ");
	    fileData = StringUtils.replaceAllStringForValue(fileData, ",", " ");

	    return StringUtils.getStringBySlice(fileData, StringUtils.getMatchStringIndexByRegExp(fileData, "AQA"), 0);
	}

	@SuppressWarnings("resource")
	public String getDataFromXlsxFile(String[] filePaths) throws IOException {
        StringBuilder xlsxData = new StringBuilder();
        for (String filePath : filePaths) {
            FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    xlsxData.append(cell.toString()).append(" ");
                }
            }
            fis.close();
        }
        return xlsxData.toString().replace(",", " ");
    }

	public WebElement getTabByStepName(String stepName) throws Exception {
	    return ElementUtils.getElementByLocator(tabByStepName(stepName), 0);
	}

	public boolean isStepByNameDisabled(String stepName) throws Exception {
	    String isDisabled = ElementUtils.getAttributeByLocator(tabByStepName(stepName), Disabled, 0);

	    return isDisabled != null && !isDisabled.isEmpty();
	}

	public void typeTextInNormalizeLocalPhoneSearchInput(String searchValue) throws InterruptedException {
	    Action.clearTextInLocatorAndTypeText(normalizeCountryDropdownSearchInput, searchValue);
	}

	public List<String> getNormalizePhoneNumbersDropdownOptionTextList() throws Exception {
	    return ElementUtils.getTextListByLocator(normalizeCountryDropdownOption);
	}

	public boolean isProgressBarStatusDisplayed() throws InterruptedException {
	    return Action.isElementDisplayedByLocator(progressBarStatus, 0);
	}

	public String getRightPopupNotificationText() throws Exception {
	    Waiters.waitForElementToBeDisplayed(rightPopupNotification);
	    return ElementUtils.getTextByLocator(rightPopupNotification, 0);
	}

	public void waitForRightPopupNotificationToBeDisplayed() throws InterruptedException {
	    Waiters.waitForElementToBeDisplayed(rightPopupNotification);
	}

	// ...additional methods will follow




}
