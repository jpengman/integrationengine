package se.anviken.integrationengine.mowerlogger.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ref_start_source database table.
 * 
 */
@Entity
@Table(name="ref_start_source")
@NamedQuery(name="RefStartSource.findAll", query="SELECT r FROM RefStartSource r")
public class RefStartSource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ref_start_source_id")
	private int refStartSourceId;

	@Column(name="ref_start_source_cd")
	private String refStartSourceCd;

	@Column(name="ref_start_source_desc")
	private String refStartSourceDesc;

	public RefStartSource() {
	}

	public int getRefStartSourceId() {
		return this.refStartSourceId;
	}

	public void setRefStartSourceId(int refStartSourceId) {
		this.refStartSourceId = refStartSourceId;
	}

	public String getRefStartSourceCd() {
		return this.refStartSourceCd;
	}

	public void setRefStartSourceCd(String refStartSourceCd) {
		this.refStartSourceCd = refStartSourceCd;
	}

	public String getRefStartSourceDesc() {
		return this.refStartSourceDesc;
	}

	public void setRefStartSourceDesc(String refStartSourceDesc) {
		this.refStartSourceDesc = refStartSourceDesc;
	}

}