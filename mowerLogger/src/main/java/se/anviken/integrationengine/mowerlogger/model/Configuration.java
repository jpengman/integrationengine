package se.anviken.integrationengine.mowerlogger.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the configuration database table.
 * 
 */
@Entity
@Table(name = "configuration")
@NamedQueries({ @NamedQuery(name = "Configuration.findAll", query = "SELECT c FROM Configuration c"),
		@NamedQuery(name = "Configuration.findToken", query = "SELECT c FROM Configuration c where c.parameter = 'token'"),
		@NamedQuery(name = "Configuration.findTokenExpires", query = "SELECT c FROM Configuration c where c.parameter = 'token_expires'") })
public class Configuration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "configuration_id")
	private int configurationId;

	private String parameter;

	private String value;

	public Configuration() {
	}

	@Override
	public String toString() {
		return "Configuration [configurationId=" + configurationId + ", parameter=" + parameter + ", value=" + value
				+ "]";
	}

	public int getConfigurationId() {
		return this.configurationId;
	}

	public void setConfigurationId(int configurationId) {
		this.configurationId = configurationId;
	}

	public String getParameter() {
		return this.parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}