package se.anviken.integrationengine.mowerdbservice.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ref_status_type database table.
 * 
 */
@Entity
@Table(name="ref_status_type")
@NamedQuery(name="RefStatusType.findAll", query="SELECT r FROM RefStatusType r")
public class RefStatusType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ref_status_type_id")
	private int refStatusTypeId;

	@Column(name="ref_status_type_cd")
	private String refStatusTypeCd;

	@Column(name="ref_status_type_desc")
	private String refStatusTypeDesc;

	public RefStatusType() {
	}

	public int getRefStatusTypeId() {
		return this.refStatusTypeId;
	}

	public void setRefStatusTypeId(int refStatusTypeId) {
		this.refStatusTypeId = refStatusTypeId;
	}

	public String getRefStatusTypeCd() {
		return this.refStatusTypeCd;
	}

	public void setRefStatusTypeCd(String refStatusTypeCd) {
		this.refStatusTypeCd = refStatusTypeCd;
	}

	public String getRefStatusTypeDesc() {
		return this.refStatusTypeDesc;
	}

	public void setRefStatusTypeDesc(String refStatusTypeDesc) {
		this.refStatusTypeDesc = refStatusTypeDesc;
	}

}