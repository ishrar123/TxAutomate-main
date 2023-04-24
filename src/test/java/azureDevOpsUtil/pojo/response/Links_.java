package azureDevOpsUtil.pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Links_ {

    private TestPoints testPoints;
    private Configuration configuration;

    @JsonProperty("_self")
    @SerializedName("_self")
    private Self self;
    private SourcePlan sourcePlan;
    private SourceSuite sourceSuite;
    private SourceProject sourceProject;
}
