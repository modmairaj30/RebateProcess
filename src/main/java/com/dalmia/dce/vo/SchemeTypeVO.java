package com.dalmia.dce.vo;

import java.util.List;

public class SchemeTypeVO {
	private String schemeType;
	private String type;
	private String schemeName;
	private List range;
	private List values;
	private List excludeValues;
	private String schKeyName;
	public String getSchemeType() {
		return schemeType;
	}
	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
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
