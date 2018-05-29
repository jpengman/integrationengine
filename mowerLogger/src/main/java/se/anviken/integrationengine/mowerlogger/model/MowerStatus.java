package se.anviken.integrationengine.mowerlogger.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the mower_status database table.
 * 
 */
@Entity
@Table(name = "mower_status")
@NamedQueries({ @NamedQuery(name = "MowerStatus.findAll", query = "SELECT m FROM MowerStatus m"),
		@NamedQuery(name = "MowerStatus.findByRESTServiceId", query = "SELECT m FROM MowerStatus m where  m.mower.restServiceId = :RESTServiceId") })
public class MowerStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "mower_status_id")
	private int mowerStatusId;

	@Column(name = "battery_perrcent")
	private int batteryPerrcent;

	private String cached_Settings_UUID;

	private boolean connected;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "next_start_timestamp")
	private Date nextStartTimestamp;

	@Column(name = "operating_mode_id")
	private int operatingModeId;

	@Column(name = "show_as_disconnected")
	private boolean showAsDisconnected;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "stored_timestamp")
	private Date storedTimestamp;

	@Column(name = "value_found")
	private boolean valueFound;

	// bi-directional many-to-one association to Mower
	@ManyToOne
	@JoinColumn(name = "mower_id")
	private Mower mower;

	// uni-directional many-to-one association to RefStartSource
	@ManyToOne
	@JoinColumn(name = "next_start_source_id")
	private RefStartSource startSource;

	// uni-directional many-to-one association to RefStatus
	@ManyToOne
	@JoinColumn(name = "status_id")
	private RefStatus status;

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

	public boolean getConnected() {
		return this.connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
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

	public boolean getShowAsDisconnected() {
		return this.showAsDisconnected;
	}

	public void setShowAsDisconnected(boolean showAsDisconnected) {
		this.showAsDisconnected = showAsDisconnected;
	}

	public Date getStoredTimestamp() {
		return this.storedTimestamp;
	}

	public void setStoredTimestamp(Date storedTimestamp) {
		this.storedTimestamp = storedTimestamp;
	}

	public boolean getValueFound() {
		return this.valueFound;
	}

	public void setValueFound(boolean valueFound) {
		this.valueFound = valueFound;
	}

	public Mower getMower() {
		return this.mower;
	}

	public void setMower(Mower mower) {
		this.mower = mower;
	}

	public RefStartSource getRefStartSource() {
		return this.startSource;
	}

	public void setRefStartSource(RefStartSource refStartSource) {
		this.startSource = refStartSource;
	}

	public RefStatus getStatus() {
		return this.status;
	}

	public void setStatus(RefStatus status) {
		this.status = status;
	}

}