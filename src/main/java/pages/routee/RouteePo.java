package pages.routee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePo;
import helpers.Action;
import helpers.ElementUtils;
import helpers.Waiters;

import java.util.List;
import java.util.stream.Collectors;

public class RouteePo extends BasePo {
    private By routeeTitle = By.cssSelector("h1.ng-binding");
    private By emailInputOnRouteePage = By.cssSelector("#EmailInput");
    private By captcha = By.cssSelector("iframe[title='reCAPTCHA']");
    private By captchaCheckbox = By.cssSelector(".recaptcha-checkbox");
    private By captchaCheckboxCheckmark = By.cssSelector(".recaptcha-checkbox-checkmark");
    private By sendButton = By.cssSelector(".pull-right button[type='button']");
    private By backToLoginLink = By.cssSelector("a[ng-click='lostPasswordController.goBackToLogin()']");
    private By warningPopup = By.cssSelector("div[ng-repeat='toaster in toasters']");
    private By languageDropdown = By.cssSelector("a[data-template='language-items.tpl.html']");
    private By languageDropdownOption = By.cssSelector(".languages-menu li a");

    public RouteePo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    public String getRouteeTitleText() throws Exception {
        return ElementUtils.getTextByLocator(routeeTitle, 0);
    }

    public WebElement getCaptcha() throws Exception {
        Waiters.waitForElementToBeDisplayed(captcha);
        return ElementUtils.getElementByLocator(captcha, 0);
    }

    public String getEmailInputFieldValueOnLostYourPasswordPage() throws Exception {
        return ElementUtils.getValueByLocator(emailInputOnRouteePage, 0);
    }

    public void typeValueInEmailInputFieldOnRouteePage(String value) throws InterruptedException {
        Action.clearTextInLocatorAndTypeText(emailInputOnRouteePage, value);
    }

    public String getEmailInputOnRouteePagePlaceholderText() throws Exception {
        return ElementUtils.getAttributeByLocator(emailInputOnRouteePage, "placeholder", 0);
    }

    public String getBackToLoginLinkText() throws Exception {
        return ElementUtils.getTextByLocator(backToLoginLink, 0);
    }

    public String getSendButtonText() throws Exception {
        return ElementUtils.getTextByLocator(sendButton, 0);
    }

    public void clickOnSendButton() throws Exception {
        Waiters.waitForElementToBeClickable(sendButton);
        Action.clickWithJSByLocator(sendButton, 0);
    }

    public void clickOnBackToLoginLink() throws Exception {
        Waiters.waitForElementToBeClickable(backToLoginLink);
        Action.clickWithJSByLocator(backToLoginLink, 0);
        Waiters.waitForElementToBeInvisible(backToLoginLink);
    }

    public void selectOptionFromLanguageDropdown(String optionName) throws Exception {
        Waiters.waitForElementToBeDisplayed(languageDropdown);
        Action.clickWithJSByLocator(languageDropdown, 0);
        Waiters.waitForElementToBeDisplayed(languageDropdownOption);
        
        List<String> optionsTexts = ElementUtils.getTextListByLocator(languageDropdownOption).stream()
                .map(text -> text.replaceAll("\\s+", " ").trim())
                .collect(Collectors.toList());

        int optionIndex = optionsTexts.indexOf(optionName);
        if (optionIndex != -1) {
        	Action.clickByLocator(languageDropdownOption, optionIndex); // Assuming clickByIndex is an adapted method
            Waiters.waitForElementToBeInvisible(languageDropdownOption);
            Waiters.waitWithSleepTimeout(1000); // Assuming this method internally handles the sleep
        }
    }
    public String getLanguageDropdownText() throws Exception {
        Waiters.waitForElementToBeDisplayed(languageDropdown);
        return ElementUtils.getTextByLocator(languageDropdown, 0).replaceAll("\\s+", " ").trim();
    }
    
    public void checkCaptcha() throws Exception {
        // Switch to the CAPTCHA iframe
        WebElement captchaFrame = ElementUtils.getElementWithWaitByLocator(captcha, 0);
        driver.switchTo().frame(captchaFrame);
        // Click the CAPTCHA checkbox
        Action.clickByLocator(captchaCheckbox, 0);
        // Wait for the CAPTCHA checkbox checkmark to be displayed
        Waiters.waitForElementToBeDisplayed(captchaCheckboxCheckmark);
        // Switch back to the main window/frame
        driver.switchTo().defaultContent();
        Waiters.waitWithSleepTimeout(2000);
    }

    public String getWarningPopupText() throws Exception {
        Waiters.waitForElementToBeDisplayed(warningPopup);
        return ElementUtils.getTextByLocator(warningPopup, 0);
    }

}
