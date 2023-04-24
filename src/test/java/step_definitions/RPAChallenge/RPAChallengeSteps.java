package step_definitions.RPAChallenge;


import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import modules.PRAChallenge.RPAChallengeActions;
import org.testng.Assert;
import step_definitions.BaseStepDefinitions;
import step_definitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;

import java.util.HashMap;

public class RPAChallengeSteps {

    public static HashMap<String, String> dataMap;

    public RPAChallengeSteps() {
        dataMap = BaseStepDefinitions.dataMap;
    }



    @And("Input Userdetails for RPAChallenge")
    public void inputUserdetailsForRPAChallenge() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                RPAChallengeActions.enterFirstNmae(dataMap.get("FirstName"));
                RPAChallengeActions.enterLastName(dataMap.get("LastName"));
                RPAChallengeActions.enterEmail(dataMap.get("Email"));
                RPAChallengeActions.enterCompanyName(dataMap.get("CompanyName"));
                RPAChallengeActions.enterAddress(dataMap.get("Address"));
                RPAChallengeActions.enterPhoneNumber(dataMap.get("PhoneNumber"));
                RPAChallengeActions.enterRoleinCompany(dataMap.get("RoleinCompany"));

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
    @And("Click On Submit Button")
    public void clickOnSubmitButton() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                RPAChallengeActions.clickSubmitBtn();
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
