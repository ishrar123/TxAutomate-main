package modules.LolRMI;

import com.relevantcodes.extentreports.LogStatus;
import pageFactory.LolRMIPages.HomePageLolRmiPage;
import pageFactory.LolRMIPages.LolRMILoginPage;
//import pageFactory.OptimusPages.Account.OptimusAccountMainPage;
import step_definitions.RunCukesTest;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

public class LolRMILoginActions extends KeywordUtil {

    public static void clickOpenLoginPageBtn() {
        waitForVisible(LolRMILoginPage.openLoginPageBtn);
        click(LolRMILoginPage.openLoginPageBtn, "Clicking Open Login page btn");
        waitForVisible(LolRMILoginPage.loginPage_SubmitBtn);
    }

    public static void enterUsername(String username) throws InterruptedException {
        delay(5000);
        inputText(LolRMILoginPage.loginPage_UsernameBox, username,"Enter Username");
    }

    public static void enterPassword(String password) {
        inputText(LolRMILoginPage.loginPage_PasswordBox, password,"Enter Password");
    }

    public static void clickLoginSubmitBtn() {
        click(LolRMILoginPage.loginPage_SubmitBtn, "Clicking Open Login page btn");
        waitForVisible(HomePageLolRmiPage.homePage_Username);
    }

    public static String getUsernameOnHomePageHeader() {
        waitForVisible(HomePageLolRmiPage.homePage_Username);
        return getElementText(HomePageLolRmiPage.homePage_Username);
    }

    public static String getInvalidLoginMessage() {
        waitForVisible(LolRMILoginPage.loginPage_InvalidLogin_Msg);
        return getElementText(LolRMILoginPage.loginPage_InvalidLogin_Msg);
    }

    public static void clickProducersSection() {
        click(HomePageLolRmiPage.homePage_Producers_Sections, "Clicking Producers Section");
        waitForVisible(HomePageLolRmiPage.homePage_Search_Producers);
    }

    public static void click_HomePage_Search_By_Producers() throws InterruptedException {
        click(HomePageLolRmiPage.homePage_Search_Dropdown, "Clicking Producers Section Search Drop down");
        waitForVisible(HomePageLolRmiPage.homePage_Search_Dropdown_Select_Producers);
        click(HomePageLolRmiPage.homePage_Search_Dropdown_Select_Producers, "Select By Producers from Search Drop down");
        delay(2000);
    }

    public static void click_HomePage_Search_By_FarmID() throws InterruptedException {
        click(HomePageLolRmiPage.homePage_Search_Dropdown, "Clicking Producers Section Search Drop down");
        waitForVisible(HomePageLolRmiPage.homePage_Search_Dropdown_Select_FarmID);
        click(HomePageLolRmiPage.homePage_Search_Dropdown_Select_FarmID, "Select By Farm ID from Search Drop down");
        delay(2000);
    }

    public static void click_HomePage_Search_By_MilkShed() throws InterruptedException {
        click(HomePageLolRmiPage.homePage_Search_Dropdown, "Clicking Producers Section Search Drop down");
        waitForVisible(HomePageLolRmiPage.homePage_Search_Dropdown_Select_MilkShed);
        click(HomePageLolRmiPage.homePage_Search_Dropdown_Select_MilkShed, "Select By Milk Shed from Search Drop down");
        delay(2000);
    }

    public static void enterProducersSearchCriteria(String item) {
        inputText(HomePageLolRmiPage.homePage_Search_Producers, item,"Enter Search Criteria");
        pressEnter(HomePageLolRmiPage.homePage_Search_Producers);
        pressTabKey(HomePageLolRmiPage.homePage_Search_Producers);
    }

    public static String getHomePage_First_Tile_FarmID() {
        waitForVisible(HomePageLolRmiPage.homePage_First_Tile_FarmID);
        return getElementText(HomePageLolRmiPage.homePage_First_Tile_FarmID);
    }

    public static String getHomePage_First_Tile_Label() {
        return getElementText(HomePageLolRmiPage.homePage_First_Tile_Label);
    }

    public static void clickHomePage_First_Tile_Label() {
        click(HomePageLolRmiPage.homePage_First_Tile_Label, "Clicking homePage_First_Tile_Label Section");
        waitForVisible(HomePageLolRmiPage.editCOP_ProducerTiles_2021);
    }

    public static void clickHomePage_First_Tile_Menu() {
        click(HomePageLolRmiPage.homePage_First_Tile_Menu, "Clicking homePage_First_Tile_Menu Section");
        waitForVisible(HomePageLolRmiPage.homePage_First_Tile_TakeOffline);
    }

    public static void clickHomePage_First_Tile_TakeOffline() {
        click(HomePageLolRmiPage.homePage_First_Tile_TakeOffline, "Clicking homePage_First_Tile_TakeOffline Section");
        waitForVisible(HomePageLolRmiPage.homePage_First_Tile_TakeOffline_Modal);
    }

    public static void click_EditCOP_ProducerTiles_2021() {
        waitForVisible(HomePageLolRmiPage.editCOP_ProducerTiles_2021);
        click(HomePageLolRmiPage.editCOP_ProducerTiles_2021, "Clicking Yearly tile to open Section");
        waitForVisible(HomePageLolRmiPage.editCOP_NumberOfMatureCowsAvg_FinData_Form);
    }

    public static void enter_EditCOP_NumberOfMatureCowsAvg_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_NumberOfMatureCowsAvg_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_NumberOfMatureCowsAvg_FinData_Form, text, "Enter value in editCOP_NumberOfMatureCowsAvg_FinData_Form");
    }

    public static void enter_EditCOP_NumberOfReplacementsAvg_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_NumberOfReplacementsAvg_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_NumberOfReplacementsAvg_FinData_Form, text, "Enter value in editCOP_NumberOfReplacementsAvg_FinData_Form");
    }

    public static void enter_EditCOP_MilkVolumeSold_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_MilkVolumeSold_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_MilkVolumeSold_FinData_Form, text, "Enter value in editCOP_MilkVolumeSold_FinData_Form");
    }

    public static void enter_EditCOP_CornForages_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_CornForages_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_CornForages_FinData_Form, text, "Enter value in editCOP_CornForages_FinData_Form");
    }

    public static void enter_EditCOP_CornGrain_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_CornGrain_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_CornGrain_FinData_Form, text, "Enter value in editCOP_CornGrain_FinData_Form");
    }

    public static void enter_EditCOP_Alfalfa_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_Alfalfa_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_Alfalfa_FinData_Form, text, "Enter value in editCOP_Alfalfa_FinData_Form");
    }

    public static void enter_EditCOP_OtherForage_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_OtherForage_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_OtherForage_FinData_Form, text, "Enter value in editCOP_OtherForage_FinData_Form");
    }

    public static void enter_EditCOP_OtherCashGrain_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_OtherCashGrain_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_OtherCashGrain_FinData_Form, text, "Enter value in editCOP_OtherCashGrain_FinData_Form");
    }

//    General Assumptions
    public static void enter_EditCOP_GrossPayrollMilkRevenue_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_GrossPayrollMilkRevenue_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_GrossPayrollMilkRevenue_FinData_Form, text, "Enter value in editCOP_GrossPayrollMilkRevenue_FinData_Form");
        pressTabKey(HomePageLolRmiPage.editCOP_GrossPayrollMilkRevenue_FinData_Form);
    }

    public static void enter_EditCOP_RiskMgmnt_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_RiskMgmnt_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_RiskMgmnt_FinData_Form, text, "Enter value in editCOP_RiskMgmnt_FinData_Form");
        pressTabKey(HomePageLolRmiPage.editCOP_RiskMgmnt_FinData_Form);
    }

    public static String getTotalMilk_From_FinData_Form() throws InterruptedException {
        return getElementText(HomePageLolRmiPage.editCOP_TotalMilk_FinData_Form);
    }

    public static void enter_EditCOP_CullCows_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_CullCows_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_CullCows_FinData_Form, text, "Enter value in editCOP_CullCows_FinData_Form");
        pressTabKey(HomePageLolRmiPage.editCOP_CullCows_FinData_Form);
    }

    public static void enter_EditCOP_Calves_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_Calves_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_Calves_FinData_Form, text, "Enter value in editCOP_Calves_FinData_Form");
        pressTabKey(HomePageLolRmiPage.editCOP_Calves_FinData_Form);
    }

    public static void enter_EditCOP_OtherLivestock_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_OtherLivestock_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_OtherLivestock_FinData_Form, text, "Enter value in editCOP_OtherLivestock_FinData_Form");
        pressTabKey(HomePageLolRmiPage.editCOP_OtherLivestock_FinData_Form);
    }

    public static void enter_EditCOP_CustomWork_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_CustomWork_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_CustomWork_FinData_Form, text, "Enter value in editCOP_CustomWork_FinData_Form");
        pressTabKey(HomePageLolRmiPage.editCOP_CustomWork_FinData_Form);
    }

    public static void enter_EditCOP_GovPayments_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_GovPayments_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_GovPayments_FinData_Form, text, "Enter value in editCOP_GovPayments_FinData_Form");
        pressTabKey(HomePageLolRmiPage.editCOP_GovPayments_FinData_Form);
    }

    public static void enter_EditCOP_Other_FinData_Form(String text) throws InterruptedException {
        clearInputUsingKeys(HomePageLolRmiPage.editCOP_Other_FinData_Form);
        inputText(HomePageLolRmiPage.editCOP_Other_FinData_Form, text, "Enter value in editCOP_Other_FinData_Form");
        pressTabKey(HomePageLolRmiPage.editCOP_Other_FinData_Form);
    }

    public static String getTotalIncome_From_FinData_Form() throws InterruptedException {
        return getElementText(HomePageLolRmiPage.editCOP_TotalIncome_FinData_Form);
    }

    public static void click_EditCOP_SaveAndClose_Btn_FinData_Form() throws InterruptedException {
        scrollToTopOfAPage("Scroll to Page header");
        click(HomePageLolRmiPage.editCOP_SaveAndClose_Btn_FinData_Form, "Clicking editCOP_SaveAndClose_Btn_FinData_Form Section");
    }

    public static String getSuccessMessageOnDataSaving() throws InterruptedException {
        return getElementText(HomePageLolRmiPage.editCOP_SaveSuccessMessage_FinData_Form);
    }

    public static void click_COP_SummaryReport_Tab() {
        waitForPresent(HomePageLolRmiPage.editCOP_SummaryReport_Tab);
        click(HomePageLolRmiPage.editCOP_SummaryReport_Tab, "Clicking editCOP_SaveAndClose_Btn_FinData_Form Section");
        waitForVisible(HomePageLolRmiPage.cOP_Year_SummaryReport_Tab);
    }

    public static String getCOP_Year_SummaryReport_Tab() {
        return getElementText(HomePageLolRmiPage.cOP_Year_SummaryReport_Tab);
    }

    public static String getCOP_NumberOfMatureCowsAvg_SummaryReport_Tab() {
        return getElementText(HomePageLolRmiPage.cOP_NumberOfMatureCowsAvg_SummaryReport_Tab);
    }

    public static String getCOP_NumberOfReplacementsAvg_SummaryReport_Tab() {
        return getElementText(HomePageLolRmiPage.cOP_NumberOfReplacementsAvg_SummaryReport_Tab);
    }

    public static String get_COP_MilkVolumeSold_SummaryReport_Tab() {
        return getElementText(HomePageLolRmiPage.cOP_MilkVolumeSold_SummaryReport_Tab);
    }

    public static String getCOP_CornForages_SummaryReport_Tab() {
        return getElementText(HomePageLolRmiPage.cOP_CornForages_SummaryReport_Tab);
    }

    public static String getCOP_CornGrain_SummaryReport_Tab() {
        return getElementText(HomePageLolRmiPage.cOP_CornGrain_SummaryReport_Tab);
    }

    public static String get_COP_Alfalfa_SummaryReport_Tab() {
        return getElementText(HomePageLolRmiPage.cOP_Alfalfa_SummaryReport_Tab);
    }

    public static String getCOP_OtherForage_SummaryReport_Tab() {
        return getElementText(HomePageLolRmiPage.cOP_OtherForage_SummaryReport_Tab);
    }

    public static String get_COP_OtherCashGrain_SummaryReport_Tab() {
        return getElementText(HomePageLolRmiPage.cOP_OtherCashGrain_SummaryReport_Tab);
    }

    public static String get_COP_TotalIncome_SummaryReport_Tab() {
        return getElementText(HomePageLolRmiPage.cOP_TotalIncome_SummaryReport_Tab);
    }

}
