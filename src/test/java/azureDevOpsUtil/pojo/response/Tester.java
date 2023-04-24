package azureDevOpsUtil.pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tester {

    private String displayName;
    private String url;

    @JsonProperty("_links")
    @SerializedName("_links")
    private Links links;
    private String id;
    private String uniqueName;
    private String imageUrl;
    private String descriptor;
}
