package step_definitions;

import io.cucumber.java.en.When;
//import pageFactory.NitroXPages.NitroXLoginPage;
import io.cucumber.java.en.Given;
import org.testng.Assert;
//import pageFactory.OptimusPages.OptimusLoginPage;
//import pageFactory.XAlphaPages.XAlphaLoginPage;
import utilities.*;

import java.util.HashMap;
import java.util.Objects;

public class BaseStepDefinitions extends KeywordUtil {

    public static HashMap<String, String> dataMap;

    static Class thisClass = BaseStepDefinitions.class;
    public static int counterVar = 1;


    @Given("Read test data {string} and {string} from Excel file")
    public void readTestDataAndFromExcelFile(String sheetName, String testCaseID) {
        //stop execution at a particular step based on SkipAtStepNum defined in excel sheet
        dataMap = new HashMap<String, String>();
        try {
            KeywordUtil.cucumberTagName = "Web";
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID(sheetName, testCaseID);
        } catch (Throwable e) {
            GlobalUtil.e = e;
            GlobalUtil.errorMsg = e.getMessage();
            Assert.fail(e.getMessage());
        }
    }

    @Given("Read {string} and {string} and {string} from test data")
    public void readAndAndFromTestData(String fileName, String sheetName, String testCaseID) {
        //stop execution at a particular step based on SkipAtStepNum defined in excel sheet
        dataMap = new HashMap<String, String>();
        try {
            KeywordUtil.cucumberTagName = "Web";
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID(fileName, sheetName, testCaseID);
        } catch (Throwable e) {
            GlobalUtil.e = e;
            GlobalUtil.errorMsg = e.getMessage();
            Assert.fail(e.getMessage());
        }
    }

    @When("^Navigate to the url$")
    public void navigateToTheUrl() {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                navigateToUrl(dataMap.get("URL"));
            } catch (Throwable e) {
                GlobalUtil.e = e;
                e.printStackTrace();
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    @When("Navigate to the {string} app url")
    public void navigateToTheAppURL(String appName) {
        //check if this step needs to be skipped
        if (BaseStepDefinitions.checkSkipExecutionFlags()) {
            BaseStepDefinitions.skipThisStep();
        } else {
            try {
                navigateToUrl(EnvironmentHelper.getURL(appName));
            } catch (Throwable e) {
                GlobalUtil.e = e;
                e.printStackTrace();
                GlobalUtil.errorMsg = e.getMessage();
                Assert.fail(e.getMessage());
            }
            //increase the step counter by 1
            if (BaseStepDefinitions.getSITflag()) {
                BaseStepDefinitions.increaseCounter();
            }
        }
    }

    //method to skip the execution at given step number in test data
    public static boolean checkSkipExecutionFlags() {
        boolean flag = false;
        LogUtil.infoLog(thisClass, "counterVar=" + counterVar);
        if ((Objects.equals(dataMap.get("SkipAtStepNum"), ""))) {
            LogUtil.infoLog(thisClass, "SkipAtStepNum=blank");
        } else {
            flag = counterVar >= Integer.parseInt(dataMap.get("SkipAtStepNum")) && Boolean.parseBoolean(dataMap.get("SIT"));
        }
        return flag;
    }

    //log execution is skipped
    public static void skipThisStep() {
        LogUtil.infoLog(thisClass, "Execution skipped at " + counterVar + " step definition");
    }

    //method to increase counter if SIT is true in test data
    public static boolean getSITflag() {
        return Boolean.parseBoolean(dataMap.get("SIT"));
    }

    //method to increase counter
    public static void increaseCounter() {
        counterVar += 1;
        LogUtil.infoLog(thisClass, "counterVar increased=" + counterVar);
    }

    //method to reset counter
    public static void resetCounter() {
        counterVar = 1;
        LogUtil.infoLog(thisClass, "counterVar reset to 1");
    }

//    @Given("Login to NitroX app with valid login credentials")
//    public void loginToNitroXAppWithValidLoginCredentials() {
//        try {
//            navigateToUrl(EnvironmentHelper.getURL("nitrox"));
//            inputText(NitroXLoginPage.username, ConfigReader.getValue("nitroxUsername"), "Enter the username");
//            inputText(NitroXLoginPage.password, ConfigReader.getValue("nitroxPassword"), "Enter the password");
//            click(NitroXLoginPage.loginbtn, "Click on Sign on Button");
//            waitForVisible(NitroXLoginPage.homepage);
//            Assert.assertEquals(KeywordUtil.getElementText(NitroXLoginPage.homepage), "Home");
//        } catch (Throwable e) {
//            GlobalUtil.e = e;
//            e.printStackTrace();
//            GlobalUtil.errorMsg = e.getMessage();
//            Assert.fail(e.getMessage());
//        }
//    }
//
//    @Given("Login to XAlpha with valid login credentials")
//    public void loginToXAlphaWithValidLoginCredentials() {
//        try {
//            navigateToUrl(EnvironmentHelper.getURL("xalpha"));
//            inputText(XAlphaLoginPage.username, ConfigReader.getValue("XAlphaUsername"), "Enter the username");
//            inputText(XAlphaLoginPage.password, ConfigReader.getValue("XAlphaPassword"), "Enter the password");
//            click(XAlphaLoginPage.loginBtn, "Click Login Button");
//            waitForVisible(XAlphaLoginPage.logoutbtn);
//            Assert.assertEquals(KeywordUtil.getElementText(XAlphaLoginPage.logoutbtn), "Logout");
//        } catch (Throwable e) {
//            GlobalUtil.e = e;
//            e.printStackTrace();
//            GlobalUtil.errorMsg = e.getMessage();
//            Assert.fail(e.getMessage());
//        }
//    }
//
//
//    @Given("Login to Optimus with Valid Credentials")
//    public void loginToOptimusWithValidCredentials()
//    {
//        try {
//            navigateToUrl(EnvironmentHelper.getURL("Optimus"));
//            inputText(XAlphaLoginPage.username, ConfigReader.getValue("OptimusUsername"), "Enter the username");
//            inputText(XAlphaLoginPage.password, ConfigReader.getValue("OptimusPassword"), "Enter the password");
//            click(OptimusLoginPage.loginBtn, "Click Login Button");
//            waitForVisible(OptimusLoginPage.logoutBtn);
//            Assert.assertEquals(KeywordUtil.getElementText(OptimusLoginPage.logoutBtn), "Logout");
//        } catch (Throwable e) {
//            GlobalUtil.e = e;
//            e.printStackTrace();
//            GlobalUtil.errorMsg = e.getMessage();
//            Assert.fail(e.getMessage());
//        }
//
//    }
}
