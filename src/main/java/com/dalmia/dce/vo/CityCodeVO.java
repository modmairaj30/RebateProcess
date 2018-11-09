package com.dalmia.dce.vo;

import java.util.List;

public class CityCodeVO {
	private String city;
	private String description;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
