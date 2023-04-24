package azureDevOpsUtil;

import azureDevOpsUtil.pojo.request.GetTestPointDetails;
import azureDevOpsUtil.pojo.response.TestPlanList;
import azureDevOpsUtil.pojo.response.Value;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.sf.json.JSONArray;

public class AzureDevOpsUtil {

    public static String ADO_URI = null;

    public static String ADO_PAT = null;

    public static String ADO_PROJECT_NAME = null;

    public static String ADO_TEST_PLAN_NAME = null;

    public static String ADO_ORG_NAME = null;

    public static String SUITE_ID;

    private static String ADO_USERNAME = "";

    private static Integer ADO_TEST_PLAN_ID;

    public AzureDevOpsUtil() {
        ADO_TEST_PLAN_ID = getTestPlanIdBasedOnPlanName(ADO_TEST_PLAN_NAME);
    }

    //This method will fetch the Test Plan ID based on the Plan Name
    private static Integer getTestPlanIdBasedOnPlanName(String testPlanName) {

        RestAssured.baseURI = ADO_URI;

        TestPlanList testPlanList = RestAssured.given()
                .auth()
                .preemptive()
                .basic(ADO_USERNAME, ADO_PAT)
                .contentType(ContentType.JSON)
                .when()
                .get(String.format(AzureUtilConstants.getTestPlanListPath, ADO_ORG_NAME, ADO_PROJECT_NAME))
                .then()
                 // .assertThat().statusCode(200)
                .extract()
                .response()
                .as(TestPlanList.class);

        for (Value valueIterator : testPlanList.getValue()) {
            if (valueIterator.getName().equalsIgnoreCase(testPlanName))
                return valueIterator.getId();
        }
        return null;
    }

    //This method will help in fetching the Test Point ID to update in ADO
    private static Integer getTestPointDetailsByTestCaseId(String testCaseId) {

        RestAssured.baseURI = ADO_URI;

        GetTestPointDetails getTestPointDetailsPayload = PojoUtil.getTestPointByTestCaseIdPayload(testCaseId);

        return RestAssured.given()
                .auth()
                .preemptive()
                .basic(ADO_USERNAME, ADO_PAT)
                .contentType(ContentType.JSON)
                .body(getTestPointDetailsPayload, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(String.format(AzureUtilConstants.getTestPointsPath, ADO_ORG_NAME, ADO_PROJECT_NAME))
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .extract()
                .response()
                .as(azureDevOpsUtil.pojo.response.GetTestPointDetails.class)
                .getPoints().get(0).getId();
    }

    //This method will update the status of the test
    public void updateTestStatusByTestPoint(String testCaseId, String testStatus) {

        RestAssured.baseURI = ADO_URI;

        JSONArray arrTestStatusAndTestPoints = PojoUtil.updateTestStatusByTestPoint(getTestPointDetailsByTestCaseId(testCaseId), testStatus);

        RestAssured.given()
                .auth()
                .preemptive()
                .basic(ADO_USERNAME, ADO_PAT)
                .contentType(ContentType.JSON)
                .body(arrTestStatusAndTestPoints, ObjectMapperType.GSON)
                .log().all()
                .when()
                .patch(String.format(AzureUtilConstants.updateTestCaseStatusPath, ADO_ORG_NAME, ADO_PROJECT_NAME, ADO_TEST_PLAN_ID, SUITE_ID))
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .extract()
                .response();
    }
}
