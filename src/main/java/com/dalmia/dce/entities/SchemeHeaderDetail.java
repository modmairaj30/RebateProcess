package com.dalmia.dce.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@NamedQuery(name = "User.findByName", query = "SELECT u FROM sch_header_det u WHERE LOWER(u.userName) = LOWER(?1)")
@Table(name = "sch_header_det")
public class SchemeHeaderDetail implements Serializable {
	private static final long serialVersionUID = 4865903039190150223L;
	
	@Id
	@Column(name = "sch_hdr_det_id",length=11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schemeHdrDetId;
	
	@Column(name = "Header_Id")
	private String headerId;
	
	@Column(name="Sch_Key")
	private String schKey;
	
	@Column(name="Sch_Value")
	private String schValue;
	
	@Column(name = "Scheme_No",length=30)
	private String schemNumb;

	public String getSchemNumb() {
		return schemNumb;
	}

	public void setSchemNumb(String schemNumb) {
		this.schemNumb = schemNumb;
	}

	public int getSchemeHdrDetId() {
		return schemeHdrDetId;
	}

	public void setSchemeHdrDetId(int schemeHdrDetId) {
		this.schemeHdrDetId = schemeHdrDetId;
	}

	public String getHeaderId() {
		return headerId;
	}

	public void setHeaderId(String headerId) {
		this.headerId = headerId;
	}

	public String getSchKey() {
		return schKey;
	}

	public void setSchKey(String schKey) {
		this.schKey = schKey;
	}

	public String getSchValue() {
		return schValue;
	}

	public void setSchValue(String schValue) {
		this.schValue = schValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
