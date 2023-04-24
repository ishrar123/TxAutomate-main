package azureDevOpsUtil.pojo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateTestStatusByTestPoint {

    private Integer id;
    private Results results;

}
