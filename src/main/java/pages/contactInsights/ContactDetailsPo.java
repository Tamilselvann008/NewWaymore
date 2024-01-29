package pages.contactInsights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePo;
import helpers.ElementUtils;
import helpers.StringUtils;
import helpers.Waiters;
import actions.Action;

public class ContactDetailsPo extends BasePo {
	
	public ContactDetailsPo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	private static final String BackgroundColor = "background-color";
	private static final String Class = "class";
	String Disabled ="disabled";
	String IsActive = "is-active";
    private By contactInfo = By.cssSelector("div.contact-info__container");
    private By contactInfoName = By.cssSelector("#js-contact-info-column .contact-info__name");
    private By contactInfoData = By.cssSelector("#js-contact-info-column .contact-info .contact-info__row");
    private By backButton = By.cssSelector("wm-contact-detail button.wm-btn.wm-btn--back");
    private By tagsInput = By.cssSelector("[id*='mat-chip-list-input']");
    private By addedTag = By.cssSelector(".mat-chip-list-wrapper .mat-chip");
    private By contactInfoGroup = By.cssSelector(".contact-info .contact-info__group");
    private By contactTagCancelIcon = By.cssSelector(".mat-chip-list-wrapper .mat-chip mat-icon");
    private By rightPopupNotification = By.cssSelector("wm-toast-message.ng-star-inserted");
    private By tabLabel = By.cssSelector("[role=\"tablist\"] .mat-tab-label");

    private By contactInfoChannelStatusByChannelValue(String channel) {
        return By.cssSelector("mat-icon[data-mat-icon-name=\"" + channel + "\"] + span + div > span");
    }

    private By contactInfoButtonByName(String button) {
        return By.xpath("//button[text()='" + button + "']");
    }

    private By headerPaginationButton(String type) {
        return By.cssSelector("button.mat-tab-header-pagination-" + type);
    }

    public WebElement getContactInfo() throws Exception {
        Waiters.waitForElementToBeVisible(contactInfo);
        return ElementUtils.getElementByLocator(contactInfo, 0);
    }

    public void clickOnContactInfoButtonByName(String button) throws Exception {
        Waiters.waitForElementToBeClickable(contactInfoButtonByName(button));
        Action.clickByLocator(contactInfoButtonByName(button), 0);
    }

    public boolean isHeaderPaginationButtonByButtonTypeDisabled(String type) throws Exception {
        return ElementUtils.getAttributeByLocator(headerPaginationButton(type),Disabled, 0).equals("true");
    }

    public void clickOnHeaderPaginationButtonByButtonType(String type) throws Exception {
        Action.clickByLocator(headerPaginationButton(type), 0);
    }

    public String getContactInfoNameText() throws Exception {
        Waiters.waitForElementToBeVisible(contactInfoName);
        return ElementUtils.getTextByLocator(contactInfoName, 0);
    }

    public List<String> getContactInfoDataTextList() throws Exception {
        Waiters.waitForElementToBeVisible(contactInfoData);
        return ElementUtils.getTextListByLocator(contactInfoData);
    }

    public boolean isContactTagElementDisplayed() throws Exception {
        return Action.isElementDisplayedByLocator(addedTag, 0);
    }

    public boolean isContactInfoGroupElementDisplayed() throws Exception {
        return Action.isElementDisplayedByLocator(contactInfoGroup, 0);
    }

    public List<String> getContactTagTextList() throws Exception {
        WebElement tagInput = ElementUtils.getElementWithWaitByLocator(tagsInput, 0);
        Actions actions = new Actions(driver);
		actions.moveToElement(tagInput);

        boolean isTagDisplayed = Action.isElementDisplayedByLocator(addedTag, 0);
        List<String> tagList = new ArrayList<>();

        if (isTagDisplayed) {
            tagList = ElementUtils.getTextListByLocator(addedTag);
            tagList = tagList.stream()
                    .map(tag -> StringUtils.replaceAllStringForValue(tag, "\ncancel" , ""))
                    .collect(Collectors.toList());
        }

        return tagList;
    }

    public List<String> getContactInfoGroupTextList() throws Exception {
        WebElement contactInfoGroupElement = ElementUtils.getElementWithWaitByLocator(contactInfoGroup, 0);
        Actions actions = new Actions(driver);
		actions.moveToElement(contactInfoGroupElement);

        boolean isContactInfoGroupDisplayed = Action.isElementDisplayedByLocator(contactInfoGroup, 0);
        List<String> contactInfoGroupList = new ArrayList<>();

        if (isContactInfoGroupDisplayed) {
            contactInfoGroupList = ElementUtils.getTextListByLocator(contactInfoGroup);
        }

        return contactInfoGroupList;
    }
    public void clickOnBackButton() throws Exception {
        Waiters.waitForElementToBeVisible(backButton);
        Action.clickByLocator(backButton, 0);
        Waiters.waitForElementToBeNotVisible(backButton);
    }

    public void clickOnCancelIconByTagName(String tagName) throws Exception {
        List<String> tagList = getContactTagTextList();
        int index = tagList.indexOf(tagName);
        Action.clickByLocator(contactTagCancelIcon, index);
    }

    public void enterTagValueAndPressEnter(String tagsValue) throws Exception {
        Action.clearTextInLocatorAndTypeTextWithEnter(tagsInput, tagsValue);
    }

    public void clickOnTabByName(String tabName) throws Exception {
        List<String> tabList = ElementUtils.getTextListByLocator(tabLabel);
        int index = tabList.indexOf(tabName);
        Action.clickByLocator(tabLabel, index);
        Waiters.waitWithSleepTimeout(2500);
    }

    public String getRightPopupNotificationText() throws Exception {
        Waiters.waitForElementToBeVisible(rightPopupNotification);
        String popupText = ElementUtils.getTextByLocator(rightPopupNotification, 0);
        return StringUtils.getStringBySplit(popupText, "\n", 1);
    }

    public boolean isContactInfoChannelStatusByChannelValueActive(String channel) throws Exception {
        String isActive = ElementUtils.getAttributeByLocator(
            contactInfoChannelStatusByChannelValue(channel),Class, 0
        );
        return isActive.contains(IsActive);
    }

    public String getContactInfoChannelIconColorByChannelValue(String channel) throws Exception {
        String style = ElementUtils.getCssValueByElement(
            contactInfoChannelStatusByChannelValue(channel),BackgroundColor, 0
        );
        return style; // Conversion to color hex might be needed depending on implementation
    }
}
