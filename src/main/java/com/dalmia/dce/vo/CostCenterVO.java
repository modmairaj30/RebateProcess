package com.dalmia.dce.vo;

import java.util.Date;

public class CostCenterVO {
	private String coar;
	private String costCtr;
	private Date toDate;
	private String name;
	private String coCd;
	
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
	
}
