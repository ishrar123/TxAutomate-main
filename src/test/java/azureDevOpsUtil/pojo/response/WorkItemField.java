package azureDevOpsUtil.pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkItemField {

    @JsonProperty("Microsoft.VSTS.Common.ActivatedBy")
    @SerializedName("Microsoft.VSTS.Common.ActivatedBy")
    private String microsoftVSTSCommonActivatedBy;

    @JsonProperty("Microsoft.VSTS.Common.ActivatedDate")
    @SerializedName("Microsoft.VSTS.Common.ActivatedDate")
    private String microsoftVSTSCommonActivatedDate;

    @JsonProperty("Microsoft.VSTS.TCM.AutomationStatus")
    @SerializedName("Microsoft.VSTS.TCM.AutomationStatus")
    private String microsoftVSTSTCMAutomationStatus;

    @JsonProperty("System.State")
    @SerializedName("System.State")
    private String systemState;

    @JsonProperty("System.AssignedTo")
    @SerializedName("System.AssignedTo")
    private String systemAssignedTo;

    @JsonProperty("Microsoft.VSTS.Common.Priority")
    @SerializedName("Microsoft.VSTS.Common.Priority")
    private Integer microsoftVSTSCommonPriority;

    @JsonProperty("Microsoft.VSTS.Common.StateChangeDate")
    @SerializedName("Microsoft.VSTS.Common.StateChangeDate")
    private String microsoftVSTSCommonStateChangeDate;

    @JsonProperty("System.WorkItemType")
    @SerializedName("System.WorkItemType")
    private String systemWorkItemType;

    @JsonProperty("System.Rev")
    @SerializedName("System.Rev")
    private Integer systemRev;
}
