package azureDevOpsUtil.pojo.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkItem {

    private Integer id;
    private String name;
    private List<WorkItemField> workItemFields;
    private String key;
    private String value;
}
