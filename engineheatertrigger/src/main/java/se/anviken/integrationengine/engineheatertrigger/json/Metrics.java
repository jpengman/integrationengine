
package se.anviken.integrationengine.engineheatertrigger.json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "icon",
    "title",
    "level",
    "modificationTime",
    "lastLevel",
    "isFailed"
})
public class Metrics {

    @JsonProperty("icon")
    private String icon;
    @JsonProperty("title")
    private String title;
    @JsonProperty("level")
    private String level;
    @JsonProperty("modificationTime")
    private Integer modificationTime;
    @JsonProperty("lastLevel")
    private String lastLevel;
    @JsonProperty("isFailed")
    private Boolean isFailed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    @JsonProperty("modificationTime")
    public Integer getModificationTime() {
        return modificationTime;
    }

    @JsonProperty("modificationTime")
    public void setModificationTime(Integer modificationTime) {
        this.modificationTime = modificationTime;
    }

    @JsonProperty("lastLevel")
    public String getLastLevel() {
        return lastLevel;
    }

    @JsonProperty("lastLevel")
    public void setLastLevel(String lastLevel) {
        this.lastLevel = lastLevel;
    }

    @JsonProperty("isFailed")
    public Boolean getIsFailed() {
        return isFailed;
    }

    @JsonProperty("isFailed")
    public void setIsFailed(Boolean isFailed) {
        this.isFailed = isFailed;
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
