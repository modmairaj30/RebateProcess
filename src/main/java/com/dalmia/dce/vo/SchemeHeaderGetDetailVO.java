package com.dalmia.dce.vo;

import java.io.Serializable;


public class SchemeHeaderGetDetailVO implements Serializable {
	private static final long serialVersionUID = 4865903039190150223L;
	
	
	private int schemeHdrDetId;
	
	
	private String headerId;
	private String schKey;
	

	private String schValue;
	

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
