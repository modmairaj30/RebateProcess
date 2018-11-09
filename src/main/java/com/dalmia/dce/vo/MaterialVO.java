package com.dalmia.dce.vo;

import java.util.List;

public class MaterialVO {
	private String materialGrp;
	private String materialGrpDesc;
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

	public String getMaterialGrp() {
		return materialGrp;
	}

	public void setMaterialGrp(String materialGrp) {
		this.materialGrp = materialGrp;
	}

	public String getMaterialGrpDesc() {
		return materialGrpDesc;
	}

	public void setMaterialGrpDesc(String materialGrpDesc) {
		this.materialGrpDesc = materialGrpDesc;
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
