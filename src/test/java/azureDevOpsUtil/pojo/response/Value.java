package azureDevOpsUtil.pojo.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Value {

    private Integer id;
    private String name;
    private String url;
    private Project project;
    private String iteration;
    private Object owner;
    private Integer revision;
    private String state;
    private RootSuite rootSuite;
    private String clientUrl;
    private Area area;
    private TestPlan testPlan;
    private TestSuite testSuite;
    private WorkItem workItem;
    private List<PointAssignment> pointAssignments;
    private Links_ links;
    private Integer order;
}
