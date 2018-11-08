package com.dalmia.dce.vo;

import java.util.Date;
import java.util.List;

import com.dalmia.dce.entities.SchemeHeaderCond;
import com.dalmia.dce.entities.SchemeHeaderDetail;

public class SchemeHeaderVO {

	private int schemeId;

	private String salesDocType;

	private String schemCategory;

	private String schemType;

	private String OrderNo;

	private String schemNumb;

	private String priceList;

	private String selfOrGroup;

	private String taxCode;

	private Date fromDate;

	private Date toDate;

	private String glAccount;

	private String budgetReferenceNo;

	private String businessPlace;

	private String active;

	private String exclusiveCSTSale;

	private String singleCharecterInd;

	private String sapNonSapDate;

	private Date prevfromDate;

	private Date prevToDate;

	private String costCenter;

	private String buisnessArea;

	private String createdBy;

	private String createdOn;

	private String approveStatus;
	private List<SchemeHeaderDetailVO> schemeHeaderDetail;
	private List<SchemeHeaderCondVO> schemeHeaderCond;

	////
	public int getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}

	public String getSalesDocType() {
		return salesDocType;
	}

	public void setSalesDocType(String salesDocType) {
		this.salesDocType = salesDocType;
	}

	public String getSchemCategory() {
		return schemCategory;
	}

	public void setSchemCategory(String schemCategory) {
		this.schemCategory = schemCategory;
	}

	public String getSchemType() {
		return schemType;
	}

	public void setSchemType(String schemType) {
		this.schemType = schemType;
	}

	public String getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}

	public String getSchemNumb() {
		return schemNumb;
	}

	public void setSchemNumb(String schemNumb) {
		this.schemNumb = schemNumb;
	}

	public String getPriceList() {
		return priceList;
	}

	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}

	public String getSelfOrGroup() {
		return selfOrGroup;
	}

	public void setSelfOrGroup(String selfOrGroup) {
		this.selfOrGroup = selfOrGroup;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getGlAccount() {
		return glAccount;
	}

	public void setGlAccount(String glAccount) {
		this.glAccount = glAccount;
	}

	public String getBudgetReferenceNo() {
		return budgetReferenceNo;
	}

	public void setBudgetReferenceNo(String budgetReferenceNo) {
		this.budgetReferenceNo = budgetReferenceNo;
	}

	public String getBusinessPlace() {
		return businessPlace;
	}

	public void setBusinessPlace(String businessPlace) {
		this.businessPlace = businessPlace;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getExclusiveCSTSale() {
		return exclusiveCSTSale;
	}

	public void setExclusiveCSTSale(String exclusiveCSTSale) {
		this.exclusiveCSTSale = exclusiveCSTSale;
	}

	public String getSingleCharecterInd() {
		return singleCharecterInd;
	}

	public void setSingleCharecterInd(String singleCharecterInd) {
		this.singleCharecterInd = singleCharecterInd;
	}

	public String getSapNonSapDate() {
		return sapNonSapDate;
	}

	public void setSapNonSapDate(String sapNonSapDate) {
		this.sapNonSapDate = sapNonSapDate;
	}

	public Date getPrevfromDate() {
		return prevfromDate;
	}

	public void setPrevfromDate(Date prevfromDate) {
		this.prevfromDate = prevfromDate;
	}

	public Date getPrevToDate() {
		return prevToDate;
	}

	public void setPrevToDate(Date prevToDate) {
		this.prevToDate = prevToDate;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getBuisnessArea() {
		return buisnessArea;
	}

	public void setBuisnessArea(String buisnessArea) {
		this.buisnessArea = buisnessArea;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public List<SchemeHeaderDetailVO> getSchemeHeaderDetail() {
		return schemeHeaderDetail;
	}

	public void setSchemeHeaderDetail(List<SchemeHeaderDetailVO> schemeHeaderDetail) {
		this.schemeHeaderDetail = schemeHeaderDetail;
	}

	public List<SchemeHeaderCondVO> getSchemeHeaderCond() {
		return schemeHeaderCond;
	}

	public void setSchemeHeaderCond(List<SchemeHeaderCondVO> schemeHeaderCond) {
		this.schemeHeaderCond = schemeHeaderCond;
	}

}
