package com.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.ContactInsightsPo;
import com.pages.CreateContactDialogPo;
import com.pages.SideMenuPo;

import basePackage.BasePo;
import helpers.DataProviders;
import helpers.StepUtils;

public class CreateContact extends BasePo {
	private String contactInsights = "Contact  Insights";
	private String ContactTitle = "CONTACTS";
	private String createContactTitle = "Create contact";
	private String firstName = "First Name";
	private String lastName = "Last Name";
	private String email = "Email";
	private String sms = "SMS";

	@BeforeTest
	public void launchWebsite() {
		browserLaunch();
	}

	@Test
	public void createContact() {
		SideMenuPo sideMenuPo = new SideMenuPo(driver);
		WaymorePageLogin waymorePageLogin = new WaymorePageLogin();
		ContactInsightsPo contactInsightsPo = new ContactInsightsPo(driver);
		CreateContactDialogPo createContactDialogPo = new CreateContactDialogPo(driver);

		waymorePageLogin.Login();
		sideMenuPo.clickOnLinkFromSidebarMenuByName(contactInsights);
		StepUtils.addLog("The user clicks on " + contactInsights + " from the side menu items");

		sideMenuPo.clickOnSubmenuItemFromSideMenuByName(contactInsights, contactInsights);
		StepUtils.addLog(
				"The user clicks on " + contactInsights + " submenu from the " + contactInsights + " side menu items");

		Assert.assertEquals(contactInsightsPo.getContactsTitleText(), ContactTitle,
				"The '" + ContactTitle + "' title is not correct");
		StepUtils.addLog("The CONTACTS title is displayed");

		contactInsightsPo.clickOnAddNewButton();
		StepUtils.addLog("The user clicks on the Add New button on the Contact Insights page");

		Assert.assertTrue(createContactDialogPo.isCreateContactsDialogElementDisplayed(),
				"The Create Contact dialog is not displayed");
		StepUtils.addLog("The Create contact dialog is displayed");

		String createContactDialogTitleText = createContactDialogPo.getCreateContactDialogTitleText();
		Assert.assertEquals(createContactDialogTitleText, createContactTitle,
				"The '" + createContactTitle + "' title is not correct");
		StepUtils.addLog("The Create contact title is displayed");

		createContactDialogPo.typeContactDataByOptionName(firstName, DataProviders.getContactTestData("firstName"));
		StepUtils.addLog("The user enters firstName in the suitable input field in the Create Contact dialog");

		createContactDialogPo.typeContactDataByOptionName(lastName, DataProviders.getContactTestData("lastName"));
		StepUtils.addLog("The user enters lastName in the suitable input field in the Create Contact dialog");

		createContactDialogPo.typeContactDataByOptionName(email,
				DataProviders.getContactTestData("destination", "identifier"));
		StepUtils.addLog("The user enters email in the suitable input field in the Create Contact dialog");

		createContactDialogPo.typeMobileNumber(DataProviders.getphoneDetails("number"));
		StepUtils.addLog("The user enters mobile number with a code for country");

		createContactDialogPo.selectCheckboxByLocator(sms);
		StepUtils.addLog("The user checks" + sms + " checkbox");

		createContactDialogPo.clickOnSaveButton();
		StepUtils.addLog("The user clicks on the Save button");

	}

}
