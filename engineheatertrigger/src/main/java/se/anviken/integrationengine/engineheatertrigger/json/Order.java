
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
    "rooms",
    "elements",
    "dashboard"
})
public class Order {

    @JsonProperty("rooms")
    private Integer rooms;
    @JsonProperty("elements")
    private Integer elements;
    @JsonProperty("dashboard")
    private Integer dashboard;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rooms")
    public Integer getRooms() {
        return rooms;
    }

    @JsonProperty("rooms")
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    @JsonProperty("elements")
    public Integer getElements() {
        return elements;
    }

    @JsonProperty("elements")
    public void setElements(Integer elements) {
        this.elements = elements;
    }

    @JsonProperty("dashboard")
    public Integer getDashboard() {
        return dashboard;
    }

    @JsonProperty("dashboard")
    public void setDashboard(Integer dashboard) {
        this.dashboard = dashboard;
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
