package se.anviken.integrationengine.mowerlogger.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the mowers database table.
 * 
 */
@Entity
@Table(name = "mowers")
@NamedQueries({ @NamedQuery(name = "Mower.findAll", query = "SELECT m FROM Mower m"),
		@NamedQuery(name = "Mower.findByRESTServiceId", query = "SELECT m FROM Mower m where  restServiceId = :RESTServiceId") })
public class Mower implements Serializable {
	@Override
	public String toString() {
		return "Mower [moverId=" + mowerId + ", model=" + model + ", moverName=" + mowerName + ", restServiceId="
				+ restServiceId + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "mower_id")
	private int mowerId;

	private String model;

	@Column(name = "mower_name")
	private String mowerName;

	@Column(name = "rest_service_id")
	private String restServiceId;

	public Mower() {
	}

	public int getMowerId() {
		return this.mowerId;
	}

	public void setMowerId(int moverId) {
		this.mowerId = moverId;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMowerName() {
		return this.mowerName;
	}

	public void setMowerName(String mowerName) {
		this.mowerName = mowerName;
	}

	public String getRestServiceId() {
		return this.restServiceId;
	}

	public void setRestServiceId(String restServiceId) {
		this.restServiceId = restServiceId;
	}
}