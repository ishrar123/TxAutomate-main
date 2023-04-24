package azureDevOpsUtil.pojo.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Point {

    private Integer id;
    private String url;
    private AssignedTo assignedTo;
    private Boolean automated;
    private Configuration configuration;
    private LastTestRun lastTestRun;
    private LastResult lastResult;
    private String outcome;
    private String state;
    private String lastResultState;
    private Suite suite;
    private TestCase testCase;
    private TestPlan testPlan;
    private List<WorkItemProperty> workItemProperties;
}
