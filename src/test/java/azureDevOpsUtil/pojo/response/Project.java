package azureDevOpsUtil.pojo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project {

    private String id;
    private String name;
    private String url;
    private String state;
    private String visibility;
    private String lastUpdateTime;
}
