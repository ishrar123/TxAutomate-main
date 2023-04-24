package azureDevOpsUtil;

public class AzureUtilConstants {

    public static final String getTestPlanListPath = "%s/%s/_apis/test/plans?api-version=5.0";
    public static final String getTestCaseIdsPath = "%s/%s/_apis/testplan/Plans/%s/suites/%s/TestCase?api-version=7.0";
    public static final String getTestPointsPath = "%s/%s/_apis/test/points?api-version=7.0";
    public static final String updateTestCaseStatusPath = "%s/%s/_apis/testplan/Plans/%s/Suites/%s/TestPoint?api-version=6.1-preview.2";
}
