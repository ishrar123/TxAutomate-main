package azureDevOpsUtil.pojo.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestPlanList {

    private List<Value> value;
    private Integer count;
}
