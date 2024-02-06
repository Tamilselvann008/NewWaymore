package steps.contactInsights;

import java.nio.file.Path;
import java.nio.file.Paths;

import basePackage.BasePo;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.FileUtils;
import pages.contactInsights.CustomFieldsTabPo;

public class CustomFieldsTabSteps extends BasePo {

    private final CustomFieldsTabPo customFieldsTabPo = new CustomFieldsTabPo(driver);

    public void thenTheTabIsDisplayedInTheContactDetailsPage(String tabName) throws Exception {
        Assertions.expectToBeTrue(customFieldsTabPo.isTabByNameActive(tabName), "The '" + tabName + "' tab is not displayed");
    }

    public void thenTheNewCustomFieldIsDisplayedInCustomFieldsTab(int index) {
        String[] labelList = DataProviders.getContactLabelTestData("associatedValue",index);
        int labelIndex = 0; // Assuming labelIndex is 0, you may adjust this based on your logic
        String customField = customFieldsTabPo.getCustomFieldHeaderTextList().get(labelList[labelIndex]);
        Assertions.expectToIncludeMembers(customField, labelList[labelIndex],
                "The new custom field '" + labelList[labelIndex] + "' is not displayed in the Custom Fields tab");
    }

    public void thenTheValueOfTheCustomFieldThatWasUploadedFromFileIsCorrect(int index, String fileName) {
        String[] labelList = DataProviders.getContactLabelTestData(index).associatedValue;
        int labelIndex = 0; // Assuming labelIndex is 0, you may adjust this based on your logic
        String customFieldName = labelList[labelIndex];
        String customFieldText = customFieldsTabPo.getCustomFieldTextByCustomFieldName(customFieldName);

        // Assuming the file is a CSV file, adjust accordingly if it's a different type
        Path filePath = Paths.get(__dirname, uploadTestDataPath, fileName);
        String csvData = FileUtils.readCsvFile(filePath);

        Assertions.expectToInclude(csvData, customFieldText,
                "The value of the Custom Field '" + customFieldName + "' that was uploaded from the '" + fileName + "' file is not correct");
    }
}
