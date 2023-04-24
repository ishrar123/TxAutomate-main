package step_definitions;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import mantisutil.MantisReport;
import org.apache.commons.compress.utils.IOUtils;
import org.openqa.selenium.JavascriptExecutor;
import testlink.api.java.client.TestLinkAPIResults;
import utilities.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

public class Hooks {

    private static final String BSTACK_PASSED = "passed";
    private static final String BSTACK_FAILED = "failed";
    private static final String ADO_TEST_STATUS_PASSED = "passed";
    private static final String ADO_TEST_STATUS_FAILED = "failed";
    public static String imagePath1;
    public static String concatt = ".";
    static String testCaseDescription;
    String imagePath;
    String pathForLogger;
    String screenshotFilePath;

    @Before("@tc11")
    public void beforeMethodAmazon(Scenario scenario) {

//        if (scenario.getName().contains("_"))
//            testCaseDescription = scenario.getName().split("_")[1].trim();
//        else
        testCaseDescription = scenario.getName();

        RunCukesTest.logger = RunCukesTest.extent.startTest(testCaseDescription);
        RunCukesTest.tagName = scenario.getSourceTagNames().toString().replace("[@", "").replace("]", "").trim();

        LogUtil.infoLog(getClass(),
                "\n+----------------------------------------------------------------------------------------------------------------------------+");
        LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());
        LogUtil.infoLog(Hooks.class,
                "Test is executed in Environment: " + GlobalUtil.getCommonSettings().getExecutionEnv());
        LogUtil.infoLog(Hooks.class, "Test is started with browser: " + GlobalUtil.getCommonSettings().getBrowser());

        GlobalUtil.setDriver(DriverUtil.getBrowser(GlobalUtil.getCommonSettings().getExecutionEnv(),
                GlobalUtil.getCommonSettings().getBrowser()));
    }

    //    @Before("")
    public void beforeAPIMethod(Scenario scenario) {

//        if (scenario.getName().contains("_"))
//            testCaseDescription = scenario.getName().split("_")[1];
//        else
        testCaseDescription = scenario.getName();

        RunCukesTest.logger = RunCukesTest.extent.startTest(testCaseDescription);
        RunCukesTest.tagName = scenario.getSourceTagNames().toString().replace("[@", "").replace("]", "").trim();
        LogUtil.infoLog(getClass(),
                "\n+----------------------------------------------------------------------------------------------------------------------------+");
        LogUtil.infoLog(getClass(), "API Test Started: " + scenario.getName());
        LogUtil.infoLog(Hooks.class, "Test is started using base URL: " + GlobalUtil.getCommonSettings().getRestURL());
    }

    //    @Before("")
    public void beforeMobileTestMethod(Scenario scenario) throws Exception {

//        if (scenario.getName().contains("_"))
//            testCaseDescription = scenario.getName().split("_")[1].trim();
//        else
        testCaseDescription = scenario.getName();

        RunCukesTest.logger = RunCukesTest.extent.startTest(testCaseDescription);
        RunCukesTest.tagName = scenario.getSourceTagNames().toString().replace("[@", "").replace("]", "").trim();

        LogUtil.infoLog(getClass(),
                "\n+----------------------------------------------------------------------------------------------------------------------------+");
        LogUtil.infoLog(getClass(), "Mobile Tests Started: " + scenario.getName());

        LogUtil.infoLog(Hooks.class,
                "Mobile Test is executed in OS: " + GlobalUtil.getCommonSettings().getAndroidName());
    }

    @AfterStep
    public void afterEachStep(Scenario scenario) {
        boolean flag = Boolean.parseBoolean(ConfigReader.getValue("ScreenshotFlag"));
        String testName = scenario.getName();//.split("_")[0].trim();
        JavascriptExecutor jse = (JavascriptExecutor) GlobalUtil.getDriver();

        try {
            if (GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")
                    && GlobalUtil.getCommonSettings().getCloudProvider().equalsIgnoreCase("Browserstack")) {
                jse.executeScript(
                        "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\"}}");
            }
            String scFileName = "ScreenShot_" + System.currentTimeMillis();

            if (scenario.isFailed()) {
                //screenshot path in case of failure
                screenshotFilePath = ConfigReader.getValue("screenshotPath") + File.separator + scFileName + ".png";
                imagePath = HTMLReportUtil.testFailTakeScreenshot(screenshotFilePath);
                InputStream is = new FileInputStream(imagePath);
                byte[] imageBytes = IOUtils.toByteArray(is);
                Thread.sleep(2000);
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                pathForLogger = RunCukesTest.logger.addBase64ScreenShot("data:image/png;base64," + base64);

                RunCukesTest.logger.log(LogStatus.FAIL,
                        HTMLReportUtil.failStringRedColor("Failed at point: " + "\n" + KeywordUtil.getCurrentUrl() + pathForLogger) + GlobalUtil.e);
                byte[] screenshot = KeywordUtil.takeScreenshot(imagePath);
                scenario.attach(screenshot, "image/png", "Screenshot");

            } else if (flag) {
                //screenshot path after each step definition on pass
                screenshotFilePath = ConfigReader.getValue("screenshotPathPass") + File.separator + scFileName + ".png";
                imagePath = HTMLReportUtil.testFailTakeScreenshot(screenshotFilePath);
                InputStream is = new FileInputStream(imagePath);
                byte[] imageBytes = IOUtils.toByteArray(is);
                Thread.sleep(2000);
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                pathForLogger = RunCukesTest.logger.addBase64ScreenShot("data:image/png;base64," + base64);
                RunCukesTest.logger.log(LogStatus.PASS,
                        HTMLReportUtil.passStringGreenColor("" + pathForLogger));

                byte[] screenshot = KeywordUtil.takeScreenshot(imagePath);
                scenario.attach(screenshot, "image/png", "Screenshot");

            } else {

//				RunCukesTest.logger.log(LogStatus.PASS,
//						HTMLReportUtil.passStringGreenColor(scenario.getName() ));

                LogUtil.infoLog(Hooks.class,
                        "Test has ended closing browser: " + GlobalUtil.getCommonSettings().getBrowser());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After("@tc11")
    public void afterMethodSmoke(Scenario scenario) {
        String testId;
        if (scenario.getName().contains("_"))
            testId = scenario.getName().split("_")[0].trim();
        else
            testId = scenario.getName();

        if (scenario.isFailed()) {
            try {
                //Taking Screenshot and putting into the report
             /*   String scFileName = "ScreenShot_" + System.currentTimeMillis();
                String screenshotFilePath = ConfigReader.getValue("screenshotPath") + "\\" + scFileName + ".png";
                imagePath = HTMLReportUtil.testFailTakeScreenshot(screenshotFilePath);

                InputStream is = new FileInputStream(imagePath);
                byte[] imageBytes = IOUtils.toByteArray(is);
                Thread.sleep(2000);
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                pathForLogger = RunCukesTest.logger.addBase64ScreenShot("data:image/png;base64," + base64);
                RunCukesTest.logger.log(LogStatus.FAIL,
                        HTMLReportUtil.failStringRedColor("Failed at point: " + pathForLogger) + GlobalUtil.e);

                byte[] screenshot = KeywordUtil.takeScreenshot(imagePath);
                scenario.attach(screenshot, "image/png", "Failed Screenshot");*/

                // report the bug
                String bugID = "Please check the Bug tool Configuration";
                if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")) {
                    bugID = MantisReport
                            .reportIssue(scenario.getName(), GlobalUtil.errorMsg, "General",
                                    "Automated on Browser: " + GlobalUtil.getCommonSettings().getBrowser()
                                            + " and Build Name: " + GlobalUtil.getCommonSettings().getBuildNumber(),
                                    imagePath);
                }

                if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")) {
                    // getting the os name to report the bug
                    String osName = System.getProperty("os.name");
                    if (GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")) {
                        osName = GlobalUtil.getCommonSettings().getRemoteOS();
                    }
                    bugID = GlobalUtil.jiraapi.reportIssue(scenario.getName(),
                            "Automated on OS: " + osName + ",\n Automated on Browser: "
                                    + GlobalUtil.getCommonSettings().getBrowser() + ",\n Build Name: "
                                    + GlobalUtil.getCommonSettings().getBuildNumber() + ". \n\n\n\n"
                                    + GlobalUtil.errorMsg,
                            imagePath);
                }

                // updating the results in Test Management tool
                if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
                    GlobalUtil.testlinkapi
                            .updateTestLinkResult(
                                    testId, "Please find the BUGID in "
                                            + GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID,
                                    TestLinkAPIResults.TEST_PASSED);
                }
                if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
                    GlobalUtil.jiraapi.updateJiraTestResults(testId, "Please find the BUGID in "
                            + GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID, "Fail");
                }

                if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Azure DevOps"))
                    GlobalUtil.azureDevOpsApi.updateTestStatusByTestPoint(testId, ADO_TEST_STATUS_FAILED);


                if (GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote"))
                    KeywordUtil.markTestAsPassedInBrowserStackWeb(BSTACK_FAILED);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            LogUtil.infoLog(Hooks.class,
                    "Test has ended closing browser: " + GlobalUtil.getCommonSettings().getBrowser());
            // updating the results in Test management tool
//            if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
//                GlobalUtil.testlinkapi.updateTestLinkResult(testId, "This test is passed",
//                        TestLinkAPIResults.TEST_PASSED);
//            }
//            if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
//                GlobalUtil.jiraapi.updateJiraTestResults(testId, "This test is passed", "Pass");
//            }
//
//            if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Azure DevOps"))
//                GlobalUtil.azureDevOpsApi.updateTestStatusByTestPoint(testId, ADO_TEST_STATUS_PASSED);
//
//            if (GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote"))
//                KeywordUtil.markTestAsPassedInBrowserStackWeb(BSTACK_PASSED);
        }

        // close the browsers
        if (Boolean.parseBoolean(ConfigReader.getValue("closeBrowserAfterScenario"))) {
            DriverUtil.closeAllDriver();
        }
        //method to reset counter for skip execution at a step definition
        BaseStepDefinitions.resetCounter();
        RunCukesTest.extent.endTest(RunCukesTest.logger);
        RunCukesTest.extent.flush();
    }

    //    @After("")
    public void afterAPIMethod(Scenario scenario) {
        String testName;

//        if (scenario.getName().contains("_"))
//            testName = scenario.getName().split("_")[0].trim();
//        else
        testName = scenario.getName();

        if (scenario.isFailed()) {
            try {

                // report the bug
                String bugID = "Please check the Bug tool Configuration";
                if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")) {
                    bugID = MantisReport.reportIssue(scenario.getName(), GlobalUtil.errorMsg, "General",
                            " Build Name: " + GlobalUtil.getCommonSettings().getBuildNumber(), "RestAPI");
                }

                if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")) {
                    // getting the os name to report the bug
                    String osName = System.getProperty("os.name");
                    if (GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")) {
                        osName = GlobalUtil.getCommonSettings().getRemoteOS();
                    }
                    bugID = GlobalUtil.jiraapi.reportIssue(scenario.getName(),
                            "Automated on OS: " + osName + "on Build Name: "
                                    + GlobalUtil.getCommonSettings().getBuildNumber() + ". \n\n\n\n"
                                    + GlobalUtil.errorMsg,
                            "RestAPI");
                }

                // updating the results in Test mangement tool
                if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
                    GlobalUtil.testlinkapi
                            .updateTestLinkResult(
                                    testName, "Please find the BUGID in "
                                            + GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID,
                                    TestLinkAPIResults.TEST_PASSED);
                }
                if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
                    GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "
                            + GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID, "Fail");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            LogUtil.infoLog(Hooks.class, "API Test has ended ");
            // updating the results in Testmangement tool
            if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
                GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed",
                        TestLinkAPIResults.TEST_PASSED);
            }
            if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
                GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
            }
        }

        // close the browsers
        RunCukesTest.extent.endTest(RunCukesTest.logger);
    }

    //    @After("")
    public void afterMobileTestMethod(Scenario scenario) {
        String testName;

//        if (scenario.getName().contains("_"))
//            testName = scenario.getName().split("_")[0].trim();
//        else
        testName = scenario.getName();

        if (scenario.isFailed()) {
            try {
                String scFileName = "ScreenShot_" + System.currentTimeMillis();
                String screenshotFilePath = ConfigReader.getValue("screenshotPath") + "\\" + scFileName + ".png";

                imagePath = HTMLReportUtil.testFailMobileTakeScreenshot(screenshotFilePath);

                InputStream is = new FileInputStream(imagePath);
                byte[] imageBytes = IOUtils.toByteArray(is);
                Thread.sleep(2000);
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                pathForLogger = RunCukesTest.logger.addBase64ScreenShot("data:image/png;base64," + base64);
                RunCukesTest.logger.log(LogStatus.FAIL,
                        HTMLReportUtil.failStringRedColor("Failed at point: " + KeywordUtil.getCurrentUrl() + pathForLogger) + GlobalUtil.e);

                byte[] screenshot = KeywordUtil.takeMobileScreenshot(imagePath);
                scenario.attach(screenshot, "image/png", "Failed Screenshot");


                // report the bug
                String bugID = "Please check the Bug tool Configuration";
                if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")) {
                    bugID = MantisReport.reportIssue(scenario.getName(), GlobalUtil.errorMsg, "General",
                            "Automated on Android Device Version: " + GlobalUtil.getCommonSettings().getAndroidVersion()
                                    + " and Build Name: " + GlobalUtil.getCommonSettings().getBuildNumber(),
                            screenshotFilePath);
                }

                if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")) {
                    bugID = GlobalUtil.jiraapi.reportIssue(scenario.getName(),
                            "Automated on Android Device Version: " + GlobalUtil.getCommonSettings().getAndroidVersion()
                                    + ",\n Build Name: " + GlobalUtil.getCommonSettings().getBuildNumber()
                                    + ". \n\n\n\n" + GlobalUtil.errorMsg,
                            screenshotFilePath);
                }

                // updating the results in Testmangement tool
                if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
                    GlobalUtil.testlinkapi
                            .updateTestLinkResult(
                                    testName, "Please find the BUGID in "
                                            + GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID,
                                    TestLinkAPIResults.TEST_PASSED);
                }
                if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
                    GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "
                            + GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID, "Fail");
                }

                if (GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote"))
                    KeywordUtil.markTestAsPassedInBrowserStackMobile(BSTACK_FAILED);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            LogUtil.infoLog(Hooks.class,
                    "Test has ended closing Application: " + GlobalUtil.getCommonSettings().getAndroidName());
            // updating the results in Testmangement tool
            if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
                GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed",
                        TestLinkAPIResults.TEST_PASSED);
            }
            if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
                GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
            }

            if (GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote"))
                KeywordUtil.markTestAsPassedInBrowserStackMobile(BSTACK_PASSED);
        }

        // close the browsers

        // We need to write the quit for local mobile device for time being we
        // commented
        // for browser stack
        GlobalUtil.getMDriver().quit();
        RunCukesTest.extent.endTest(RunCukesTest.logger);
    }

}