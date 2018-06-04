
package se.anviken.integrationengine.mowerlogger.json.getmowers;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "model", "valueFound", "status", "centralPoint" })
public class MowerJSON {

	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("model")
	private String model;
	@JsonProperty("valueFound")
	private Boolean valueFound;
	@JsonProperty("status")
	private Status status;
	@JsonProperty("centralPoint")
	private CentralPoint centralPoint;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Mower [id=" + id + ", name=" + name + ", model=" + model + ", valueFound=" + valueFound + ", status="
				+ status + ", centralPoint=" + centralPoint + ", additionalProperties=" + additionalProperties + "]";
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("model")
	public String getModel() {
		return model;
	}

	@JsonProperty("model")
	public void setModel(String model) {
		this.model = model;
	}

	@JsonProperty("valueFound")
	public Boolean getValueFound() {
		return valueFound;
	}

	@JsonProperty("valueFound")
	public void setValueFound(Boolean valueFound) {
		this.valueFound = valueFound;
	}

	@JsonProperty("status")
	public Status getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(Status status) {
		this.status = status;
	}

	@JsonProperty("centralPoint")
	public CentralPoint getCentralPoint() {
		return centralPoint;
	}

	@JsonProperty("centralPoint")
	public void setCentralPoint(CentralPoint centralPoint) {
		this.centralPoint = centralPoint;
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
