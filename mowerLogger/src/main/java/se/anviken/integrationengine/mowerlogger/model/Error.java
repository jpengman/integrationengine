package se.anviken.integrationengine.mowerlogger.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the errors database table.
 * 
 */
@Entity
@Table(name="errors")
@NamedQuery(name="Error.findAll", query="SELECT e FROM Error e")
public class Error implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="error_id")
	private int errorId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="error_timestamp")
	private Date errorTimestamp;

	//uni-directional many-to-one association to ErrorRef
	@ManyToOne
	@JoinColumn(name="error_ref_id")
	private ErrorRef errorRef;

	public Error() {
	}

	public int getErrorId() {
		return this.errorId;
	}

	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

	public Date getErrorTimestamp() {
		return this.errorTimestamp;
	}

	public void setErrorTimestamp(Date errorTimestamp) {
		this.errorTimestamp = errorTimestamp;
	}

	public ErrorRef getErrorRef() {
		return this.errorRef;
	}

	public void setErrorRef(ErrorRef errorRef) {
		this.errorRef = errorRef;
	}

}