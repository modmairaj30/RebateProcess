package com.dalmia.dce.vo;

import java.util.List;

public class SchemeHeaderDetailVO {

	private String headerId;
	private String schKey;
	private String schValue;
	private String schemNumb;
	private List<Integer> range;
	private List<Integer> values;
	private List<Integer> excludeValues;
	
	
	
	
	public List<Integer> getRange() {
		return range;
	}
	public void setRange(List<Integer> range) {
		this.range = range;
	}
	public List<Integer> getValues() {
		return values;
	}
	public void setValues(List<Integer> values) {
		this.values = values;
	}
	public List<Integer> getExcludeValues() {
		return excludeValues;
	}
	public void setExcludeValues(List<Integer> excludeValues) {
		this.excludeValues = excludeValues;
	}
	public String getSchemNumb() {
		return schemNumb;
	}
	public void setSchemNumb(String schemNumb) {
		this.schemNumb = schemNumb;
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
	
	

}
