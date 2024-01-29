package com.testcase;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.contactInsights.ContactInsightsPo;
import pages.contactInsights.CreateContactDialogPo;
import pages.sidemenu.SideMenuPo;
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
	public void createContact() throws Exception {
		SideMenuPo sideMenuPo = new SideMenuPo(driver);
		WaymorePageLogin waymorePageLogin = new WaymorePageLogin();
		ContactInsightsPo contactInsightsPo = new ContactInsightsPo(driver);
		CreateContactDialogPo createContactDialogPo = new CreateContactDialogPo(driver);

		waymorePageLogin.theUserIsOnTheGettingStartedWithWayMorePage(1);
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

		createContactDialogPo.typeContactDataByOptionName(firstName, DataProviders.getContactTestData("firstName", 1));
		StepUtils.addLog("The user enters firstName in the suitable input field in the Create Contact dialog");

		createContactDialogPo.typeContactDataByOptionName(lastName, DataProviders.getContactTestData("lastName", 1));
		StepUtils.addLog("The user enters lastName in the suitable input field in the Create Contact dialog");

		createContactDialogPo.typeContactDataByOptionName(email,
		DataProviders.getContactTestData("destination", "identifier",1));
		StepUtils.addLog("The user enters email in the suitable input field in the Create Contact dialog");

		createContactDialogPo.typeMobileNumber(DataProviders.getphoneDetails("number", 1));
		StepUtils.addLog("The user enters mobile number with a code for country");

		createContactDialogPo.selectCheckboxByLocator(sms);
		StepUtils.addLog("The user checks" + sms + " checkbox"); 
 
		createContactDialogPo.clickOnSaveButton();
		StepUtils.addLog("The user clicks on the Save button");

//		String actualFirstName = contactInsightsPo.getContactsFirstNameTextList();
//		String firstNameErrorMessage = "The contact first name '" + DataProviders.getContactTestData("firstName") + "' is not displayed";
//		Assert.assertEquals(actualFirstName, DataProviders.getContactTestData("firstName"), firstNameErrorMessage);
//
//		String actualLastName = contactInsightsPo.getContactsLastNameTextList();
//		String lastNameErrorMessage = "The contact last name '" + DataProviders.getContactTestData("lastName") + "' is not displayed";
//		Assert.assertEquals(actualLastName, DataProviders.getContactTestData("lastName"), lastNameErrorMessage);
		
		String contactFirstName = DataProviders.getContactTestData("firstName", 1);
        String contactLastName = DataProviders.getContactTestData("lastName", 1);
		List<String> firstNameList = contactInsightsPo.getContactsFirstNameTextList();
        Assert.assertTrue(firstNameList.contains(contactFirstName),
            "The contact first name '" + contactFirstName + "' is not displayed");
        System.out.println("first name displayed");

        List<String> lastNameList = contactInsightsPo.getContactsLastNameTextList();
        Assert.assertTrue(lastNameList.contains(contactLastName),
            "The contact last name '" + contactLastName + "' is not displayed");
        System.out.println("last name displayed");
	}

}
