package com.teczuka.devp.appLibrary.model.administrative;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.teczuka.devp.appLibrary.configuration.CustomDateSerializer;

@Entity
@Table(name = "LIBRARY_COUNTRY")
public class LibraryCountry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COUNTRY_ID")
	private int countryId;

	@Column(name = "COUNTRY_DESCRIPTION")
	private String countryDescription;

	@Column(name = "COUNTRY_STATE")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean countryState;

	@Column(name = "COUNTRY_DATEREGISTRY")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date countryDateRegistry;

	@Column(name = "COUNTRY_DATEUPDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date countryDateUpdate;

	@Column(name = "COUNTRY_USERREGISTRY")
	private String countryUserRegistry;

	@Column(name = "COUNTRY_USERUPDATE")
	private String countryUserUpdate;

	public LibraryCountry() {

	}

	public LibraryCountry(int countryId, String countryDescription, boolean countryState, Date countryDateRegistry,
			Date countryDateUpdate, String countryUserRegistry, String countryUserUpdate) {
		super();
		this.countryId = countryId;
		this.countryDescription = countryDescription;
		this.countryState = countryState;
		this.countryDateRegistry = countryDateRegistry;
		this.countryDateUpdate = countryDateUpdate;
		this.countryUserRegistry = countryUserRegistry;
		this.countryUserUpdate = countryUserUpdate;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryDescription() {
		return countryDescription;
	}

	public void setCountryDescription(String countryDescription) {
		this.countryDescription = countryDescription;
	}

	public boolean isCountryState() {
		return countryState;
	}

	public void setCountryState(boolean countryState) {
		this.countryState = countryState;
	}

	public Date getCountryDateRegistry() {
		return countryDateRegistry;
	}

	public void setCountryDateRegistry(Date countryDateRegistry) {
		this.countryDateRegistry = countryDateRegistry;
	}

	public Date getCountryDateUpdate() {
		return countryDateUpdate;
	}

	public void setCountryDateUpdate(Date countryDateUpdate) {
		this.countryDateUpdate = countryDateUpdate;
	}

	public String getCountryUserRegistry() {
		return countryUserRegistry;
	}

	public void setCountryUserRegistry(String countryUserRegistry) {
		this.countryUserRegistry = countryUserRegistry;
	}

	public String getCountryUserUpdate() {
		return countryUserUpdate;
	}

	public void setCountryUserUpdate(String countryUserUpdate) {
		this.countryUserUpdate = countryUserUpdate;
	}

	@Override
	public String toString() {
		return "LibraryCountry [countryId=" + countryId + ", countryDescription=" + countryDescription
				+ ", countryState=" + countryState + ", countryDateRegistry=" + countryDateRegistry
				+ ", countryDateUpdate=" + countryDateUpdate + ", countryUserRegistry=" + countryUserRegistry
				+ ", countryUserUpdate=" + countryUserUpdate + "]";
	}

}
