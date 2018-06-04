package se.anviken.integrationengine.mowerlogger.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the locations database table.
 * 
 */
@Entity
@Table(name = "locations")
@NamedQueries({ @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
		@NamedQuery(name = "Location.findByMower", query = "SELECT l FROM Location l where mower.restServiceId = :RESTServiceId order by order_no desc") })
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "location_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locationId;

	private double latitude;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "location_timestamp")
	private Date locationTimestamp;

	private double longitude;

	@Column(name = "order_no")
	private int orderNo;

	// uni-directional many-to-one association to RefStatus
	@ManyToOne
	@JoinColumn(name = "gps_status_id")
	private RefStatus refStatus;

	// bi-directional many-to-one association to Mower
	@ManyToOne
	@JoinColumn(name = "mower_id")
	private Mower mower;

	public Mower getMower() {
		return mower;
	}

	public void setMower(Mower mower) {
		this.mower = mower;
	}

	public Location() {
	}

	public Location(Double latitude2, Double longitude2) {
		this.latitude = latitude2;
		this.longitude = longitude2;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", latitude=" + latitude + ", locationTimestamp="
				+ locationTimestamp + ", longitude=" + longitude + ", orderNo=" + orderNo + ", refStatus=" + refStatus
				+ ", mower=" + mower + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Date getLocationTimestamp() {
		return this.locationTimestamp;
	}

	public void setLocationTimestamp(Date locationTimestamp) {
		this.locationTimestamp = locationTimestamp;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
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