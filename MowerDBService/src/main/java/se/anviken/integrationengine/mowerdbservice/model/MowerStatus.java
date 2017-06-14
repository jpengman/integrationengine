package se.anviken.integrationengine.mowerdbservice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mower_status database table.
 * 
 */
@Entity
@Table(name="mower_status")
@NamedQuery(name="MowerStatus.findAll", query="SELECT m FROM MowerStatus m")
public class MowerStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mower_status_id")
	private int mowerStatusId;

	@Column(name="battery_perrcent")
	private int batteryPerrcent;

	private String cached_Settings_UUID;

	private Object connected;

	@Column(name="mower_id")
	private int mowerId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="next_start_timestamp")
	private Date nextStartTimestamp;

	@Column(name="operating_mode_id")
	private int operatingModeId;

	@Column(name="show_as_disconnected")
	private Object showAsDisconnected;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="stored_timestamp")
	private Date storedTimestamp;

	@Column(name="value_found")
	private Object valueFound;

	//uni-directional many-to-one association to RefStartSource
	@ManyToOne
	@JoinColumn(name="next_start_source_id")
	private RefStartSource refStartSource;

	//uni-directional many-to-one association to RefStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private RefStatus refStatus;

	public MowerStatus() {
	}

	public int getMowerStatusId() {
		return this.mowerStatusId;
	}

	public void setMowerStatusId(int mowerStatusId) {
		this.mowerStatusId = mowerStatusId;
	}

	public int getBatteryPerrcent() {
		return this.batteryPerrcent;
	}

	public void setBatteryPerrcent(int batteryPerrcent) {
		this.batteryPerrcent = batteryPerrcent;
	}

	public String getCached_Settings_UUID() {
		return this.cached_Settings_UUID;
	}

	public void setCached_Settings_UUID(String cached_Settings_UUID) {
		this.cached_Settings_UUID = cached_Settings_UUID;
	}

	public Object getConnected() {
		return this.connected;
	}

	public void setConnected(Object connected) {
		this.connected = connected;
	}

	public int getMowerId() {
		return this.mowerId;
	}

	public void setMowerId(int mowerId) {
		this.mowerId = mowerId;
	}

	public Date getNextStartTimestamp() {
		return this.nextStartTimestamp;
	}

	public void setNextStartTimestamp(Date nextStartTimestamp) {
		this.nextStartTimestamp = nextStartTimestamp;
	}

	public int getOperatingModeId() {
		return this.operatingModeId;
	}

	public void setOperatingModeId(int operatingModeId) {
		this.operatingModeId = operatingModeId;
	}

	public Object getShowAsDisconnected() {
		return this.showAsDisconnected;
	}

	public void setShowAsDisconnected(Object showAsDisconnected) {
		this.showAsDisconnected = showAsDisconnected;
	}

	public Date getStoredTimestamp() {
		return this.storedTimestamp;
	}

	public void setStoredTimestamp(Date storedTimestamp) {
		this.storedTimestamp = storedTimestamp;
	}

	public Object getValueFound() {
		return this.valueFound;
	}

	public void setValueFound(Object valueFound) {
		this.valueFound = valueFound;
	}

	public RefStartSource getRefStartSource() {
		return this.refStartSource;
	}

	public void setRefStartSource(RefStartSource refStartSource) {
		this.refStartSource = refStartSource;
	}

	public RefStatus getRefStatus() {
		return this.refStatus;
	}

	public void setRefStatus(RefStatus refStatus) {
		this.refStatus = refStatus;
	}

}