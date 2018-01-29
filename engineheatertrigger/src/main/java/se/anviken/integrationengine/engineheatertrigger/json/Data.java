
package se.anviken.integrationengine.engineheatertrigger.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "creationTime",
    "creatorId",
    "customIcons",
    "deviceType",
    "h",
    "hasHistory",
    "id",
    "location",
    "metrics",
    "order",
    "permanently_hidden",
    "probeType",
    "tags",
    "visibility",
    "updateTime"
})
public class Data {

    @JsonProperty("creationTime")
    private Integer creationTime;
    @JsonProperty("creatorId")
    private Integer creatorId;
    @JsonProperty("customIcons")
    private CustomIcons customIcons;
    @JsonProperty("deviceType")
    private String deviceType;
    @JsonProperty("h")
    private Integer h;
    @JsonProperty("hasHistory")
    private Boolean hasHistory;
    @JsonProperty("id")
    private String id;
    @JsonProperty("location")
    private Integer location;
    @JsonProperty("metrics")
    private Metrics metrics;
    @JsonProperty("order")
    private Order order;
    @JsonProperty("permanently_hidden")
    private Boolean permanentlyHidden;
    @JsonProperty("probeType")
    private String probeType;
    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonProperty("visibility")
    private Boolean visibility;
    @JsonProperty("updateTime")
    private Integer updateTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("creationTime")
    public Integer getCreationTime() {
        return creationTime;
    }

    @JsonProperty("creationTime")
    public void setCreationTime(Integer creationTime) {
        this.creationTime = creationTime;
    }

    @JsonProperty("creatorId")
    public Integer getCreatorId() {
        return creatorId;
    }

    @JsonProperty("creatorId")
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @JsonProperty("customIcons")
    public CustomIcons getCustomIcons() {
        return customIcons;
    }

    @JsonProperty("customIcons")
    public void setCustomIcons(CustomIcons customIcons) {
        this.customIcons = customIcons;
    }

    @JsonProperty("deviceType")
    public String getDeviceType() {
        return deviceType;
    }

    @JsonProperty("deviceType")
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @JsonProperty("h")
    public Integer getH() {
        return h;
    }

    @JsonProperty("h")
    public void setH(Integer h) {
        this.h = h;
    }

    @JsonProperty("hasHistory")
    public Boolean getHasHistory() {
        return hasHistory;
    }

    @JsonProperty("hasHistory")
    public void setHasHistory(Boolean hasHistory) {
        this.hasHistory = hasHistory;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("location")
    public Integer getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Integer location) {
        this.location = location;
    }

    @JsonProperty("metrics")
    public Metrics getMetrics() {
        return metrics;
    }

    @JsonProperty("metrics")
    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }

    @JsonProperty("order")
    public Order getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(Order order) {
        this.order = order;
    }

    @JsonProperty("permanently_hidden")
    public Boolean getPermanentlyHidden() {
        return permanentlyHidden;
    }

    @JsonProperty("permanently_hidden")
    public void setPermanentlyHidden(Boolean permanentlyHidden) {
        this.permanentlyHidden = permanentlyHidden;
    }

    @JsonProperty("probeType")
    public String getProbeType() {
        return probeType;
    }

    @JsonProperty("probeType")
    public void setProbeType(String probeType) {
        this.probeType = probeType;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("visibility")
    public Boolean getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("updateTime")
    public Integer getUpdateTime() {
        return updateTime;
    }

    @JsonProperty("updateTime")
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
