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
		return "Mower [moverId=" + moverId + ", model=" + model + ", moverName=" + moverName + ", restServiceId="
				+ restServiceId + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "mover_id")
	private int moverId;

	private String model;

	@Column(name = "mover_name")
	private String moverName;

	@Column(name = "rest_service_id")
	private String restServiceId;

	public Mower() {
	}

	public int getMoverId() {
		return this.moverId;
	}

	public void setMoverId(int moverId) {
		this.moverId = moverId;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMoverName() {
		return this.moverName;
	}

	public void setMoverName(String moverName) {
		this.moverName = moverName;
	}

	public String getRestServiceId() {
		return this.restServiceId;
	}

	public void setRestServiceId(String restServiceId) {
		this.restServiceId = restServiceId;
	}
}