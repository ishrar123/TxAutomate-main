package azureDevOpsUtil;

import azureDevOpsUtil.pojo.request.GetTestPointDetails;
import azureDevOpsUtil.pojo.request.PointsFilter;
import azureDevOpsUtil.pojo.request.Results;
import azureDevOpsUtil.pojo.request.UpdateTestStatusByTestPoint;
import azureDevOpsUtil.pojo.response.TestCaseListBySuiteId;
import azureDevOpsUtil.pojo.response.Value;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class PojoUtil {

    public static GetTestPointDetails getTestPointByTestCaseIdPayload(TestCaseListBySuiteId testCaseIds) {

        List<Integer> testPointsList = new ArrayList<>();
        for (Value valueIterator : testCaseIds.getValue())
            testPointsList.add(valueIterator.getWorkItem().getId());

        return GetTestPointDetails.builder()
                .pointsFilter(PointsFilter.builder()
                        .testcaseIds(testPointsList)
                        .build())
                .build();
    }

    public static GetTestPointDetails getTestPointByTestCaseIdPayload(String testCaseId) {

        List<Integer> testPointsList = new ArrayList<>();
        testPointsList.add(Integer.valueOf(testCaseId));

        return GetTestPointDetails.builder()
                .pointsFilter(PointsFilter.builder()
                        .testcaseIds(testPointsList)
                        .build())
                .build();
    }

    public static JSONArray updateTestStatusByTestPoint(Integer testPointDetailsByTestCaseId, String testStatus) {

        JSONArray arr = new JSONArray();


        arr.add(UpdateTestStatusByTestPoint.builder()
                .id(testPointDetailsByTestCaseId)
                .results(Results.builder().outcome(testStatus).build())
                .build());

        return arr;

    }

}
