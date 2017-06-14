package se.anviken.integrationengine.mowerdbservice.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the error_ref database table.
 * 
 */
@Entity
@Table(name="error_ref")
@NamedQuery(name="ErrorRef.findAll", query="SELECT e FROM ErrorRef e")
public class ErrorRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="error_ref_id")
	private int errorRefId;

	@Column(name="error_ref_cd")
	private String errorRefCd;

	@Column(name="error_ref_desc")
	private String errorRefDesc;

	public ErrorRef() {
	}

	public int getErrorRefId() {
		return this.errorRefId;
	}

	public void setErrorRefId(int errorRefId) {
		this.errorRefId = errorRefId;
	}

	public String getErrorRefCd() {
		return this.errorRefCd;
	}

	public void setErrorRefCd(String errorRefCd) {
		this.errorRefCd = errorRefCd;
	}

	public String getErrorRefDesc() {
		return this.errorRefDesc;
	}

	public void setErrorRefDesc(String errorRefDesc) {
		this.errorRefDesc = errorRefDesc;
	}

}