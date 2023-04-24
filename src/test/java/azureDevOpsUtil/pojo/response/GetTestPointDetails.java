package azureDevOpsUtil.pojo.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetTestPointDetails {

    private List<Point> points;
    private PointsFilter pointsFilter;
}
