package step_definitions.LolRMI;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import modules.LolRMI.LolRMILoginActions;
import org.testng.Assert;
import step_definitions.BaseStepDefinitions;
import step_definitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;

import java.util.HashMap;

public class LolRMISteps {

    public static HashMap<String, String> dataMap;

    public LolRMISteps() {
        dataMap = BaseStepDefinitions.dataMap;
    }

    @And("Input Username and Password for LolRMI")
    public void inputUsernameAndPasswordForLolRMI() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                LolRMILoginActions.enterUsername(dataMap.get("Username"));
                LolRMILoginActions.enterPassword(dataMap.get("Password"));
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @And("Click LolRMI Login Button")
    public void clickLolRMILoginButton() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                LolRMILoginActions.clickLoginSubmitBtn();
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @And("Open Login page button")
    public void openLoginPageButton() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                LolRMILoginActions.clickOpenLoginPageBtn();
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @Then("Verify user is able to login to LolRMI successfully")
    public void verifyUserIsAbleToLoginToLolRMISuccessfully() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                Assert.assertEquals(LolRMILoginActions.getUsernameOnHomePageHeader(), "SDSmitha D", "Text Matching");
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @And("Search For Producers By {string}")
    public void searchForProducersBy(String text) {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                LolRMILoginActions.clickProducersSection();

                if (text.equalsIgnoreCase("Producer")) {
                    LolRMILoginActions.click_HomePage_Search_By_Producers();
                } else if (text.equalsIgnoreCase("Farm ID")) {
                    LolRMILoginActions.click_HomePage_Search_By_FarmID();
                } else if (text.equalsIgnoreCase("Milk Shed")) {
                    LolRMILoginActions.click_HomePage_Search_By_MilkShed();
                }

                LolRMILoginActions.enterProducersSearchCriteria(dataMap.get("Search"));
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @Then("Verify Result in The Tile List")
    public void verifyResultInTheTileList() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                Assert.assertEquals(LolRMILoginActions.getHomePage_First_Tile_Label(), "5 Star Dairy", "Text Matching");
                RunCukesTest.logger.log(LogStatus.INFO, HTMLReportUtil.infoStringGreyColor("Search is Successful"));
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @Then("Verify {string} login Of User to LolRMI")
    public void verifyLoginOfUserToLolRMI(String text) {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                if (text.equalsIgnoreCase("Valid")) {
                    Assert.assertEquals(LolRMILoginActions.getUsernameOnHomePageHeader(), dataMap.get("Messages"), "Valid Text Matching");
                    RunCukesTest.logger.log(LogStatus.INFO, HTMLReportUtil.infoStringGreyColor("Valid Login is successful"));
                } else if (text.equalsIgnoreCase("Invalid")) {
                    Assert.assertEquals(LolRMILoginActions.getInvalidLoginMessage(), dataMap.get("Messages"), "Invalid Text Matching");
                    RunCukesTest.logger.log(LogStatus.INFO, HTMLReportUtil.infoStringGreyColor("Invalid Login is unseccessful"));
                }
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @And("Click on Tile to Open Yearly Tiles List")
    public void clickOnTileToOpenYearlyTilesList() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                LolRMILoginActions.clickHomePage_First_Tile_Label();
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @And("Click on Edit COP in Yearly Tile")
    public void clickOnEditCOPInYearlyTile() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                LolRMILoginActions.click_EditCOP_ProducerTiles_2021();
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @And("Edit Field Details in COP")
    public void editFieldDetailsInCOP() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {

                LolRMILoginActions.enter_EditCOP_NumberOfReplacementsAvg_FinData_Form(dataMap.get("NumReplacements"));
                LolRMILoginActions.enter_EditCOP_MilkVolumeSold_FinData_Form(dataMap.get("MilkVolumeSold"));

                LolRMILoginActions.enter_EditCOP_CornForages_FinData_Form(dataMap.get("CornForages"));
                LolRMILoginActions.enter_EditCOP_CornGrain_FinData_Form(dataMap.get("CornGrain"));
                LolRMILoginActions.enter_EditCOP_Alfalfa_FinData_Form(dataMap.get("Alfalfa"));

                LolRMILoginActions.enter_EditCOP_OtherForage_FinData_Form(dataMap.get("OtherForage"));
                LolRMILoginActions.enter_EditCOP_OtherCashGrain_FinData_Form(dataMap.get("OtherCashGrain"));

                LolRMILoginActions.enter_EditCOP_NumberOfMatureCowsAvg_FinData_Form(dataMap.get("NumMatureCows"));
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @And("Click on Save Button to Save Details")
    public void clickOnSaveButtonToSaveDetails() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
//                LolRMILoginActions.click_EditCOP_SaveAndClose_Btn_FinData_Form();
                LolRMILoginActions.click_EditCOP_SaveAndClose_Btn_FinData_Form();
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @Then("Verify Details on Summary Report Tab")
    public void verifyDetailsOnSummaryReportTab() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {

//                Assert.assertEquals(LolRMILoginActions.getCOP_Year_SummaryReport_Tab(), dataMap.get("Year"), "Year Title on Summary page Matches");
//                                  LolRMILoginActions.getCOP_NumberOfMatureCowsAvg_SummaryReport_Tab(), dataMap.get("NumMatureCows"), "NumMatureCows on Summary page Matches");
                Assert.assertEquals(LolRMILoginActions.getCOP_NumberOfMatureCowsAvg_SummaryReport_Tab(), dataMap.get("NumMatureCows"), "NumMatureCows on Summary page Matches");
                Assert.assertEquals(LolRMILoginActions.getCOP_NumberOfReplacementsAvg_SummaryReport_Tab(), dataMap.get("NumReplacements"), "NumReplacements on Summary page Matches");
                Assert.assertEquals(LolRMILoginActions.get_COP_MilkVolumeSold_SummaryReport_Tab(), dataMap.get("MilkVolumeSold"), "MilkVolumeSold on Summary page Matches");

                Assert.assertEquals(LolRMILoginActions.getCOP_CornForages_SummaryReport_Tab(), dataMap.get("CornForages"), "CornForages on Summary page Matches");
                Assert.assertEquals(LolRMILoginActions.getCOP_CornGrain_SummaryReport_Tab(), dataMap.get("CornGrain"), "CornGrain on Summary page Matches");
                Assert.assertEquals(LolRMILoginActions.get_COP_Alfalfa_SummaryReport_Tab(), dataMap.get("Alfalfa"), "Alfalfa on Summary page Matches");
                Assert.assertEquals(LolRMILoginActions.getCOP_OtherForage_SummaryReport_Tab(), dataMap.get("OtherForage"), "OtherForage on Summary page Matches");
                Assert.assertEquals(LolRMILoginActions.get_COP_OtherCashGrain_SummaryReport_Tab(), dataMap.get("OtherCashGrain"), "OtherCashGrain on Summary page Matches");
                RunCukesTest.logger.log(LogStatus.INFO, HTMLReportUtil.infoStringGreyColor("All Data in Herd Information and Acreage Information is verified"));
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @Then("Verify Success Message on Saving Data")
    public void verifySuccessMessageOnSavingData() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                Assert.assertEquals(LolRMILoginActions.getSuccessMessageOnDataSaving(), dataMap.get("ValidationMessages"), "Success Message verification");
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @And("click on Summary Report to Check Saved Data")
    public void clickOnSummaryReportToCheckSavedData() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
//                Open Summary Report
                LolRMILoginActions.click_COP_SummaryReport_Tab();
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @And("Edit Total Income Fields Detail in COP")
    public void editTotalIncomeFieldsDetailInCOP() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
//                Update Total Income Fields
                LolRMILoginActions.enter_EditCOP_GrossPayrollMilkRevenue_FinData_Form(dataMap.get("GrossPayrollMilkRevenue"));
                LolRMILoginActions.enter_EditCOP_RiskMgmnt_FinData_Form(dataMap.get("RiskManagement"));

                LolRMILoginActions.enter_EditCOP_CullCows_FinData_Form(dataMap.get("CullCows"));
                LolRMILoginActions.enter_EditCOP_Calves_FinData_Form(dataMap.get("Calves"));
                LolRMILoginActions.enter_EditCOP_OtherLivestock_FinData_Form(dataMap.get("OtherLiveStock"));
                LolRMILoginActions.enter_EditCOP_CustomWork_FinData_Form(dataMap.get("CustomWork"));
                LolRMILoginActions.enter_EditCOP_GovPayments_FinData_Form(dataMap.get("GovPayments"));
                LolRMILoginActions.enter_EditCOP_Other_FinData_Form(dataMap.get("Other"));
            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @Then("Verify Total Milk And Income Details on Form")
    public void verifyTotalMilkAndIncomeDetailsonForm() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
//                Update Total Income Fields
                Assert.assertEquals(LolRMILoginActions.getTotalMilk_From_FinData_Form(), dataMap.get("TotalMilk"), "Total Milk Verifing");
                RunCukesTest.logger.log(LogStatus.INFO, HTMLReportUtil.infoStringGreyColor("Total Milk Verified on Form"));
                Assert.assertEquals(LolRMILoginActions.getTotalIncome_From_FinData_Form(), dataMap.get("TotalIncome"), "Total Income Verifing");
                RunCukesTest.logger.log(LogStatus.INFO, HTMLReportUtil.infoStringGreyColor("Total Income Verified on Form"));

            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @Then("Verify Total Income Details on Summary Report Tab")
    public void verifyTotalIncomeDetailsOnSummaryReportTab() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
//                Update Total Income Fields
                Assert.assertEquals(LolRMILoginActions.get_COP_TotalIncome_SummaryReport_Tab(), dataMap.get("TotalIncome"), "Total Milk Verifing");
                RunCukesTest.logger.log(LogStatus.INFO, HTMLReportUtil.infoStringGreyColor("Total Income Verified on Summary Report"));

            } catch (Throwable e) {
                GlobalUtil.e = e;
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }
}
