package steps.sideMenu;

import java.util.List;

import basePackage.BasePo;
import helpers.Assertions;
import helpers.DataProviders;
import helpers.StepUtils;
import helpers.StringUtils;
import pages.dashboard.DashboardPo;
import pages.sidemenu.SideMenuPo;

public class SideMenuSteps extends BasePo{

    private static final String ContactInsights = "ContactInsights";
	private static final String UserPlugins = "User Plugins";
	private SideMenuPo sideMenuPo = new SideMenuPo(driver);
    private DashboardPo dashboardPo = new DashboardPo(driver);

    public void whenTheUserClicksOnMyCampaignsLeadGenerationSettingsCommunicationAutomationsUserPluginsEventsMyTemplatesContactInsightsChatBotValidationServicesAnalyticsSupportItem(String option) throws Exception {
        switch (option) {
            case UserPlugins:
                sideMenuPo.clickOnUserPluginsLink();
                break;
            case ContactInsights:
                boolean isExpanded = sideMenuPo.isSideMenuItemExpanded();
                if (!isExpanded) {
                    sideMenuPo.clickOnLinkFromSidebarMenuByName("Contact  Insights");
                    StepUtils.addLog("the user clicks on the" + ContactInsights +" item");
                }
                break;
            default:
                sideMenuPo.clickOnLinkFromSidebarMenuByName(option);
                break;
        }
        
    }

    public void whenTheUserClicksOnFormsPushNotificationMyIntegrationsEmailPushForMobileDevicesUnifiedChatBoardOptionInTheSidebarDropdownMenu(String option) throws Exception{
        sideMenuPo.selectOptionFromItemDropdownListByOptionName(option);
    }

    public void whenTheUserScrollsToEachMenuItemOnTheSideMenu() throws Exception{
        sideMenuPo.scrollToEachMenuItem();
    }

    public void whenTheUserClicksOnTheFormLinkFromTheWaymoreAppMenu() throws Exception{
        sideMenuPo.clickOnFormLink();
    }

    public void whenTheUserClicksOnTheQuickSearchInputInTheMainMenu() throws Exception {
        sideMenuPo.clickOnSideMenuQuickSearchInput();
    }

    public void whenTheUserClicksOnTheLandingPageLinkFromTheWaymoreAppMenu() throws Exception {
        sideMenuPo.clickOnLandingPageLink();
    }

    public void whenTheUserClicksOnTheLandingPageBuilderLinkInTheSidebarDropdownMenu(String option) throws Exception {
        sideMenuPo.clickOnLinkFromSidebarMenuByName(option);
    }

    public void whenTheUserHoverOverTheDashboardMyCampaignsSettingsEventsItemInTheMainMenu(String option) throws Exception {
        sideMenuPo.hoverOverOnMenuItem(option);
    }

    public void whenTheUserHoverOverTheMyTemplatesCommunicationAutomationsValidationServicesLeadGenerationAnalyticsChatBotSupportContactInsightsItemWithSubmenuInTheMainMenu(String option) {
        switch (option) {
            case ContactInsights:
                sideMenuPo.hoverOverOnMenuItemWithSubmenu(StringUtils.replaceAllStringForValue(MenuItemOptionEnum.ContactInsights, " ", "  "));
                break;
            default:
                sideMenuPo.hoverOverOnMenuItemWithSubmenu(option);
                break;
        }
    }

    public void whenTheUserClicksOnTheWaymoreLogoInTheMainMenu() throws Exception {
        sideMenuPo.clickOnWaymoreLogoLink();
    }

    public void whenTheUserClicksOnTheSmsEmailViberWhatsappVoiceSubmenuOptionInTheCommunicationSideMenuOption(String subSubmenuOption, String submenuOption) throws Exception {
        sideMenuPo.clickOnSubmenuItemFromSideMenuByName(subSubmenuOption, submenuOption);
    }

    public void whenTheUserClicksOnTheContactInsightsSegmentsSubmenuOptionInTheContactInsightsSideMenuOption(String subSubmenuOption, String submenuOption) throws Exception {
        String subSubmenu = StringUtils.replaceAllStringForValue(subSubmenuOption, " ", "  ");
        String submenu = StringUtils.replaceAllStringForValue(submenuOption, " ", "  ");
        sideMenuPo.clickOnSubmenuItemFromSideMenuByName(subSubmenu, submenu);
        StepUtils.addLog("the user clicks on the Contact Insights submenu option in the Contact Insights side menu option");
    }

    public void thenTheSideMenuIsDisplayed() throws Exception {
        Assertions.expectToDisplay(sideMenuPo.getSideMenu(), "The Side Menu is not displayed");
        Assertions.expectToDisplay(dashboardPo.getDashboardSideInfo(), "The Dashboard Side Info is not displayed");
        StepUtils.addLog("the Side Menu is displayed");
    }

    public void thenThePluginNumberIsDisplayedInTheSideMenuDomain(int pluginIndex) {
        String getDomain = DataProviders.getPluginTestData(pluginIndex);
        String getSource = DataProviders.getPluginTestData(pluginIndex);
        Assertions.expectToEqual(sideMenuPo.getSideMenuDomainOptionText(), getDomain, "The plugin domain '" + getDomain + "' is not displayed");
        Assertions.expectToEqual(sideMenuPo.getSideMenuPluginInfoText(),getSource, "The plugin info '" + getSource + "' is not displayed");
    }

    public void thenTheOrderOfTheSideMenuItemsIsCorrect() {
        List<String> sideMenuTextList = sideMenuPo.getSideMenuTextList();
        String sideMenuTestData = DataProviders.getSideMenuOptionsIndexData();
        Assertions.expectToHaveMembers(sideMenuTextList, sideMenuTestData, "The order of the side menu items is wrong");
            }

            public void thenTheDashboardMyCampaignsSettingsEventsTooltipIsDisplayed(String option) throws Exception {
                Assertions.expectToInclude(sideMenuPo.getSideMenuTooltipOnHoverText(), option, "The '" + option + "' tooltip is not displayed");
            }

            public void thenTheMyTemplatesCommunicationAutomationsValidationServicesLeadGenerationAnalyticsChatBotSupportTooltipWithSubmenuIsDisplayed(String option) throws Exception {
                Assertions.expectToInclude(sideMenuPo.getSideMenuTooltipWithSubmenuOnHoverText(), option, "The '" + option + "' tooltip with submenu is not displayed");
            }

            public void thenTheMyTemplatesCommunicationAutomationsValidationServicesLeadGenerationAnalyticsChatBotSupportContactInsightsSubmenuOptionsAreDisplayed(String option) throws Exception {
            	String submenuOption = option;
                Assertions.expectToHaveMembers(sideMenuPo.getSideMenuSubmenuOptionOnHoverTextList(), submenuOption, "The '" + option + "' submenu options are not displayed");
            }

            public void thenTheSubmenuOptionsOfTheExpandedCommunicationMyTemplatesAutomationsValidationServicesLeadGenerationAnalyticsChatBotSupportMenuItemAreDisplayed(String option) throws Exception {
                String submenuOption =option;
                Assertions.expectToHaveMembers(sideMenuPo.getSideMenuSubmenuOptionTextList(), submenuOption, "The '" + option + "' submenu options are not displayed");
            }

            public void thenTheSubmenuOptionsOfTheExpandedSmsEmailViberSubmenuItemOfTheActiveCommunicationMenuItemAreDisplayed(String subMenuItem, String menuItem) {
                String submenuOption = DataProviders.getSubmenuOptionsByName(subMenuItem).getData();
                Assertions.expectToHaveMembers(sideMenuPo.getSideMenuExpandedSubSubmenuOptionByMenuOptionsTextList(menuItem, subMenuItem), submenuOption,
                    "The '" + subMenuItem + "' submenu options of the active '" + menuItem + "' are not displayed");
            }

            public void thenTheSmsEmailViberWhatsappVoiceSubmenuOptionsAreDisplayed(String option) {
            	String submenuOption = DataProviders.getSubmenuOptionsByName(option).getData();
                Assertions.expectToHaveMembers(sideMenuPo.getSideMenuTooltipSubSubmenuOptionTextList(), submenuOption, "The '" + option + "' submenu options are not displayed");
            }

            public void thenTheEventsMenuItemIsDisplayed(String option) throws Exception {
                Assertions.expectToDisplay(sideMenuPo.getSideMenuItemByValue(option), "The '" + option + "' menu item is not displayed");
            }

            public void thenTheCommunicationMyTemplatesAutomationsValidationServicesLeadGenerationAnalyticsChatBotMenuItemIsCollapsed(String option) throws Exception {
                Assertions.expectToBeFalse(sideMenuPo.isSidebarMenuByNameActive(option), "The '" + option + "' menu is expanded");
            }

            // Other methods...
        }

