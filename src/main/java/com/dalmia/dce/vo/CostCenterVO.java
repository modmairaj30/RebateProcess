package com.dalmia.dce.vo;

import java.util.Date;
import java.util.List;

public class CostCenterVO {
	private String coar;
	private String costCtr;
	private Date toDate;
	private String name;
	private String coCd;

	private List range;
	private List values;
	private List excludeValues;
	private String schKeyName;

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCoCd() {
		return coCd;
	}

	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}

	public String getCoar() {
		return coar;
	}

	public void setCoar(String coar) {
		this.coar = coar;
	}

	public String getCostCtr() {
		return costCtr;
	}

	public void setCostCtr(String costCtr) {
		this.costCtr = costCtr;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getRange() {
		return range;
	}

	public void setRange(List range) {
		this.range = range;
	}

	public List getValues() {
		return values;
	}

	public void setValues(List values) {
		this.values = values;
	}

	public List getExcludeValues() {
		return excludeValues;
	}

	public void setExcludeValues(List excludeValues) {
		this.excludeValues = excludeValues;
	}

	public String getSchKeyName() {
		return schKeyName;
	}

	public void setSchKeyName(String schKeyName) {
		this.schKeyName = schKeyName;
	}

}
