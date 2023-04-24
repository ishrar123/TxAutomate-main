package azureDevOpsUtil.pojo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointAssignment {

    private Integer id;
    private String configurationName;
    private Tester tester;
    private Integer configurationId;
}
