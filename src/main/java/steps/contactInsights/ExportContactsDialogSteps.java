package steps.contactInsights;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import basePackage.BasePo;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.FileUtils;
import helpers.StringUtils;
import pages.contactInsights.ExportContactsDialogPo;

public class ExportContactsDialogSteps extends BasePo {

	private final ExportContactsDialogPo exportContactsDialogPo = new ExportContactsDialogPo(driver);

	public void whenTheUserSelectsExportFormatInExportContactsDialog(String option) throws Exception {
		exportContactsDialogPo.clickOnCheckboxByValue(option);
	}

	public void whenTheUserClicksOnExportButtonInExportContactsDialog() throws Exception {
		exportContactsDialogPo.clickOnExportButton();
	}

	public void whenTheUserClicksOnCancelButtonInExportContactsDialog() throws Exception {
		exportContactsDialogPo.clickOnCancelButton();
	}

	public void whenTheUserClicksOnCloseButtonInExportContactsDialog() throws Exception {
		exportContactsDialogPo.clickOnCloseButton();
	}

	public void thenTheExportContactsDialogIsDisplayed() throws Exception {
		Assertions.expectToBeTrue(exportContactsDialogPo.isExportContactsDialogElementDisplayed(),
				"The Export Contacts dialog is not displayed");
	}

	public void thenTheExportContactsDialogIsNotDisplayed() throws Exception {
		Assertions.expectToBeFalse(exportContactsDialogPo.isExportContactsDialogElementDisplayed(),
				"The Export Contacts dialog is displayed");
	}

	public void thenTheCsvFileWithContactsIsDownloaded(int fileIndex) {
		String fileName = DataProviders.getDownloadContactsTestData("fileName", fileIndex);
		String columnName = DataProviders.getDownloadContactsTestData("fileName", fileIndex);
		String contactData = DataProviders.getDownloadContactsTestData("fileName", fileIndex);
		String filePath = FileUtils.readFileContents("__dirname", DOWNLOAD_PATH, fileName);

		Assertions.expectToBeTrue(FileUtils.isFileExist(DOWNLOAD_PATH + "/" + fileName),
				"The '" + fileName + "' file isn't downloaded");
		Assertions.expectToInclude(filePath, columnName, "The column names in the uploaded file are incorrect");
		Assertions.expectToInclude(filePath, contactData, "The file content is incorrect");
	}
	@SuppressWarnings("unchecked")
	public void thenTheDownloadedXlsxFileContainsContact(int fileIndex, int contactIndex) {
		String fileName = DataProviders.getDownloadContactsTestData("fileName", fileIndex);
		String firstName = DataProviders.getContactTestData("firstName", contactIndex);
		String lastName = DataProviders.getContactTestData("lastName", contactIndex);
		String gender = DataProviders.getContactTestData("gender", contactIndex);
		String city = DataProviders.getContactTestData("city", contactIndex);
		String country = DataProviders.getContactTestData("country", contactIndex);
		String address = DataProviders.getContactTestData("address", contactIndex);
		String zip = DataProviders.getContactTestData("zip", contactIndex);
		String birthDate = DataProviders.getContactTestData("birthDate", contactIndex);
		String smsidentifier = DataProviders.getContactTestData("identifier", contactIndex, 1);
		String viberidentifier = DataProviders.getContactTestData("identifier", contactIndex, 5);
		String emailidentifier = DataProviders.getContactTestData("identifier", contactIndex, 7);

		List<List<String>> xlsxFileData = FileUtils.readXlsxFile(DOWNLOAD_PATH + "/" + fileName);
		
		Map<String, String> xlsxContactData = (Map<String, String>) xlsxFileData.get(xlsxFileData.size() - 1);

		Assertions.expectToBeTrue(FileUtils.isFileExist(DOWNLOAD_PATH + "/" + fileName),
				"The '" + fileName + "' file isn't downloaded");
		Assertions.expectToIncludeMembers(
				Arrays.asList(xlsxContactData.get("First Name"), xlsxContactData.get("Last Name"),
						xlsxContactData.get("Gender"), xlsxContactData.get("City"), xlsxContactData.get("Country"),
						xlsxContactData.get("Address"), xlsxContactData.get("ZIP"), xlsxContactData.get("Birth Date"),
						xlsxContactData.get("SMS"), xlsxContactData.get("Viber"), xlsxContactData.get("Email")),
				Arrays.asList(firstName, lastName, gender, city, country, address, String.valueOf(zip), birthDate,
						StringUtils.replaceAllStringForValue(smsidentifier, "+", ""),
						StringUtils.replaceAllStringForValue(viberidentifier, "+", ""), emailidentifier),
				"The file content is incorrect");
	}

	public void thenThePdfFileWithContactsIsDownloaded(int fileIndex) {
		String fileName = DataProviders.getDownloadContactsTestData("fileName", fileIndex);
		String columnName = DataProviders.getDownloadContactsTestData("fileName", fileIndex);
		String contactData = DataProviders.getDownloadContactsTestData("fileName", fileIndex);
		String textPdf = FileUtils.readPdfFile(DOWNLOAD_PATH + "/" + fileName);

		Assertions.expectToBeTrue(FileUtils.isFileExist(DOWNLOAD_PATH + "/" + fileName),
				"The '" + fileName + "' file isn't downloaded");
		Assertions.expectToInclude(textPdf, columnName, "The column names in the uploaded file are incorrect");
		Assertions.expectToInclude(textPdf, contactData, "The file content is incorrect");
	}
}
