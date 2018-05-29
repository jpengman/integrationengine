package se.anviken.integrationengine.mowerlogger.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ref_status database table.
 * 
 */
@Entity
@Table(name="ref_status")
@NamedQuery(name="RefStatus.findAll", query="SELECT r FROM RefStatus r")
public class RefStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ref_status_id")
	private int refStatusId;

	@Column(name="ref_status_cd")
	private String refStatusCd;

	@Column(name="ref_statusc_desc")
	private String refStatuscDesc;

	//uni-directional many-to-one association to RefStatusType
	@ManyToOne
	@JoinColumn(name="ref_status_type_id")
	private RefStatusType refStatusType;

	public RefStatus() {
	}

	public int getRefStatusId() {
		return this.refStatusId;
	}

	public void setRefStatusId(int refStatusId) {
		this.refStatusId = refStatusId;
	}

	public String getRefStatusCd() {
		return this.refStatusCd;
	}

	public void setRefStatusCd(String refStatusCd) {
		this.refStatusCd = refStatusCd;
	}

	public String getRefStatuscDesc() {
		return this.refStatuscDesc;
	}

	public void setRefStatuscDesc(String refStatuscDesc) {
		this.refStatuscDesc = refStatuscDesc;
	}

	public RefStatusType getRefStatusType() {
		return this.refStatusType;
	}

	public void setRefStatusType(RefStatusType refStatusType) {
		this.refStatusType = refStatusType;
	}

}