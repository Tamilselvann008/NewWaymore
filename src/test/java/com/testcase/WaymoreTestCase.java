package com.testcase;

import org.testng.annotations.*;
import basePackage.BasePo;

public class WaymoreTestCase extends BasePo {

	@BeforeTest
	public void launchWebsite() {
		browserLaunch();

	}

	@AfterTest
	public void tearDown() {
		closeBrowser();
	}

//	
//	
//	@Test(priority = 2)
//	public void contactInsightTestCase() {
//		ContactInsightPage contacts = new ContactInsightPage(driver);
//		contacts.addNewContact();
//		contacts.searchContact();
//		
//	}

}
