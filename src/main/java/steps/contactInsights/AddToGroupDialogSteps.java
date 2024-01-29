package steps.contactInsights;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import basePackage.BasePo;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.StepUtils;
import helpers.StringUtils;
import pages.contactInsights.AddToGroupDialogPo;

public class AddToGroupDialogSteps extends BasePo {
	
	
	AddToGroupDialogPo addToGroupDialogPo =new AddToGroupDialogPo(driver);
	
	 public void theUserSelectsOptionFromGroupsDropdownInAddToGroupDialog(int groupIndex) throws Exception {
	        String optionValue = DataProviders.getGroupTestData("name", groupIndex);

	        StepUtils.addLog("The user selects '" + optionValue + "' option from dropdown");
	        addToGroupDialogPo.selectOptionFromDropdownByOptionName(optionValue);
	    }
	 
	 public void theUserRemovesTheSelectedGroupInAddToGroupDialog(int groupIndex) throws Exception {
	        String optionValue = DataProviders.getGroupTestData("name", groupIndex);

	        StepUtils.addLog("The user removes group by name '" + optionValue + "'");
	        addToGroupDialogPo.removeGroupByName(optionValue);
	    }

//	    public void theUserClicksOnAddToGroupButtonInAddToGroupDialog() {
//	        List<String> groupOption = addToGroupDialogPo.getSelectedGroupChipOptionTextList();
//
//	        StepUtils.addLog("The user stores selected groups '" + groupOption + "'");
//	        addToGroupDialogPo.getLocalStorage().setItem("selectedGroups", groupOption);
//
//	        StepUtils.addLog("The user clicks on the Add to group button");
//	        addToGroupDialogPo.clickOnAddToGroupButton();
//	    }

	    public void theUserEntersTextValueInSearchCriteriaInAddToGroupDialog(String searchValue) throws Exception {
	        addToGroupDialogPo.typeSearchCriteriaInAddToGroupDropdown(searchValue);
	    }

	    public void theUserClicksOnCloseButtonInAddToGroupDialog() throws Exception {
	        addToGroupDialogPo.clickOnCloseButton();
	    }
	
	    public void theUserClicksOnCancelButtonInAddToGroupDialog() throws Exception {
	        addToGroupDialogPo.clickOnCancelButton();
	    }

	    public void allResultsShownContainValueSearchedInAddToGroupDialog(String searchValue) throws Exception {
	        List<String> searchValueList = addToGroupDialogPo.getAddToGroupDropdownOptionTextList();

	        Assertions.expectToEveryStringIncludeInArray(
	            searchValueList.stream().map(StringUtils::getStringToLowerCase).collect(Collectors.toList()),
	            searchValue,
	            "Not all results shown contain the '" + searchValue + "' value that was searched on");
	    }

	    public void addToGroupDialogIsDisplayed(String title) throws Exception {
	        Assertions.expectToDisplay(addToGroupDialogPo.getAddToGroupDialog(), "The '" + title + "' dialog is not displayed");
	        Assertions.expectToEqual(addToGroupDialogPo.getAddToGroupDialogHeaderText(), title, "The '" + title + "' title is incorrect");
	    }

	    public void addToGroupDialogIsNotDisplayed() {
	        Assertions.expectToBeFalse(addToGroupDialogPo.isAddToGroupDialogElementDisplayed(), "The Add to group dialog is displayed");
	    }

	    public void groupIsSelectedInAddToGroupDialog(int groupIndex) throws Exception {
	        String groupOption = DataProviders.getGroupTestData("name", groupIndex);
	        List<String> selectedGroupList = addToGroupDialogPo.getSelectedGroupChipOptionTextList();

	        Assertions.expectToIncludeMembers(selectedGroupList, Collections.singletonList(groupOption), "The group '" + groupOption + "' is not selected");
	    }

	    public void groupIsNotShownAsSelectedInAddToGroupDialog(int groupIndex) throws Exception {
	        String groupOption = DataProviders.getGroupTestData("name", groupIndex);
	        List<String> selectedGroupList = addToGroupDialogPo.getSelectedGroupChipOptionTextList();

	        Assertions.expectToNotIncludeMembers(selectedGroupList, Collections.singletonList(groupOption), "The group '" + groupOption + "' is selected");
	    }

}
