
package se.anviken.integrationengine.mowerlogger.json.getmowers;

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
@JsonPropertyOrder({ "batteryPercent", "connected", "lastErrorCode", "lastErrorCodeTimestamp", "mowerStatus",
		"nextStartSource", "nextStartTimestamp", "operatingMode", "storedTimestamp", "showAsDisconnected", "valueFound",
		"cachedSettingsUUID", "lastLocations" })
public class Status {

	@JsonProperty("batteryPercent")
	private Integer batteryPercent;
	@JsonProperty("connected")
	private Boolean connected;
	@JsonProperty("lastErrorCode")
	private Integer lastErrorCode;
	@JsonProperty("lastErrorCodeTimestamp")
	private Integer lastErrorCodeTimestamp;
	@JsonProperty("mowerStatus")
	private String mowerStatus;
	@JsonProperty("nextStartSource")
	private String nextStartSource;
	@JsonProperty("nextStartTimestamp")
	private Integer nextStartTimestamp;
	@JsonProperty("operatingMode")
	private String operatingMode;
	@JsonProperty("storedTimestamp")
	private Double storedTimestamp;
	@JsonProperty("showAsDisconnected")
	private Boolean showAsDisconnected;
	@JsonProperty("valueFound")
	private Boolean valueFound;
	@JsonProperty("cachedSettingsUUID")
	private String cachedSettingsUUID;
	@JsonProperty("lastLocations")
	private List<LocationJSON> lastLocations = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("batteryPercent")
	public Integer getBatteryPercent() {
		return batteryPercent;
	}

	@JsonProperty("batteryPercent")
	public void setBatteryPercent(Integer batteryPercent) {
		this.batteryPercent = batteryPercent;
	}

	@JsonProperty("connected")
	public Boolean getConnected() {
		return connected;
	}

	@JsonProperty("connected")
	public void setConnected(Boolean connected) {
		this.connected = connected;
	}

	@JsonProperty("lastErrorCode")
	public Integer getLastErrorCode() {
		return lastErrorCode;
	}

	@JsonProperty("lastErrorCode")
	public void setLastErrorCode(Integer lastErrorCode) {
		this.lastErrorCode = lastErrorCode;
	}

	@JsonProperty("lastErrorCodeTimestamp")
	public Integer getLastErrorCodeTimestamp() {
		return lastErrorCodeTimestamp;
	}

	@JsonProperty("lastErrorCodeTimestamp")
	public void setLastErrorCodeTimestamp(Integer lastErrorCodeTimestamp) {
		this.lastErrorCodeTimestamp = lastErrorCodeTimestamp;
	}

	@JsonProperty("mowerStatus")
	public String getMowerStatus() {
		return mowerStatus;
	}

	@JsonProperty("mowerStatus")
	public void setMowerStatus(String mowerStatus) {
		this.mowerStatus = mowerStatus;
	}

	@JsonProperty("nextStartSource")
	public String getNextStartSource() {
		return nextStartSource;
	}

	@JsonProperty("nextStartSource")
	public void setNextStartSource(String nextStartSource) {
		this.nextStartSource = nextStartSource;
	}

	@JsonProperty("nextStartTimestamp")
	public Integer getNextStartTimestamp() {
		return nextStartTimestamp;
	}

	@JsonProperty("nextStartTimestamp")
	public void setNextStartTimestamp(Integer nextStartTimestamp) {
		this.nextStartTimestamp = nextStartTimestamp;
	}

	@JsonProperty("operatingMode")
	public String getOperatingMode() {
		return operatingMode;
	}

	@JsonProperty("operatingMode")
	public void setOperatingMode(String operatingMode) {
		this.operatingMode = operatingMode;
	}

	@JsonProperty("storedTimestamp")
	public Double getStoredTimestamp() {
		return storedTimestamp;
	}

	@JsonProperty("storedTimestamp")
	public void setStoredTimestamp(Double storedTimestamp) {
		this.storedTimestamp = storedTimestamp;
	}

	@JsonProperty("showAsDisconnected")
	public Boolean getShowAsDisconnected() {
		return showAsDisconnected;
	}

	@JsonProperty("showAsDisconnected")
	public void setShowAsDisconnected(Boolean showAsDisconnected) {
		this.showAsDisconnected = showAsDisconnected;
	}

	@JsonProperty("valueFound")
	public Boolean getValueFound() {
		return valueFound;
	}

	@JsonProperty("valueFound")
	public void setValueFound(Boolean valueFound) {
		this.valueFound = valueFound;
	}

	@JsonProperty("cachedSettingsUUID")
	public String getCachedSettingsUUID() {
		return cachedSettingsUUID;
	}

	@JsonProperty("cachedSettingsUUID")
	public void setCachedSettingsUUID(String cachedSettingsUUID) {
		this.cachedSettingsUUID = cachedSettingsUUID;
	}

	@JsonProperty("lastLocations")
	public List<LocationJSON> getLastLocations() {
		return lastLocations;
	}

	@JsonProperty("lastLocations")
	public void setLastLocations(List<LocationJSON> lastLocations) {
		this.lastLocations = lastLocations;
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
