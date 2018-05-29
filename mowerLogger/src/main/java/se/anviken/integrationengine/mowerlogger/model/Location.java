package se.anviken.integrationengine.mowerlogger.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the locations database table.
 * 
 */
@Entity
@Table(name="locations")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="location_id")
	private int locationId;

	private BigDecimal latitude;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="location_timestamp")
	private Date locationTimestamp;

	private BigDecimal longitude;

	@Column(name="order_no")
	private int orderNo;

	//uni-directional many-to-one association to RefStatus
	@ManyToOne
	@JoinColumn(name="gps_status_id")
	private RefStatus refStatus;

	public Location() {
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public Date getLocationTimestamp() {
		return this.locationTimestamp;
	}

	public void setLocationTimestamp(Date locationTimestamp) {
		this.locationTimestamp = locationTimestamp;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public int getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public RefStatus getRefStatus() {
		return this.refStatus;
	}

	public void setRefStatus(RefStatus refStatus) {
		this.refStatus = refStatus;
	}

}