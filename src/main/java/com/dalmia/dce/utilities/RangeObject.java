package com.dalmia.dce.utilities;

import java.util.List;

public class RangeObject {
private String property;
private String type;
private List<String> range;
private List<String> values;
private List<String> excludeValues;
public String getProperty() {
	return property;
}
public void setProperty(String property) {
	this.property = property;
}
public List<String> getRange() {
	return range;
}
public void setRange(List<String> range) {
	this.range = range;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public List<String> getValues() {
	return values;
}
public void setValues(List<String> values) {
	this.values = values;
}
public List<String> getExcludeValues() {
	return excludeValues;
}
public void setExcludeValues(List<String> excludeValues) {
	this.excludeValues = excludeValues;
}

	
}
