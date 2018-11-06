/*package com.dalmia.dce.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sch_header")

public class SchemeHeader {
	@Id
	@Column(name = "Header_ID",length=11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schemeId;
	
	@Column(name = "Scheme_No",length=30)
	private String schemNumb;
	
	@Column(name = "Scheme_Category",length=30)
	private String schemCategory;
	
	@Column(name = "Scheme_Type",length=30)
	private String schemType;
	
	@Column(name = "Business_Area",length=4)
	private String buisnessArea;
	
	@Column(name = "Scheme_Category",length=30)
    private String paymentMethod;

	@Column(name = "Scheme_Category",length=30)
    private String profitCenter;
		
	@Column(name = "GL_Account",length=10)
    private String glAccount;
	
	@Column(name = "Scheme_Category",length=30)
    private String costCenter;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "From_Date")
	private Date fromDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "To_Date")
	private Date toDate;
	
	@Column(name = "Active",length=4)
	private String active;
	
	@Column(name = "Exclude_CST_Sale",length=30)
	private String excCstScale;
	
	@Column(name = "Scheme_Category",length=30)
	private String billingType;
	
	@Column(name = "Scheme_Category",length=30)
	private String salesOffice;
	
	@Column(name = "Scheme_Category",length=30)
	private String salesGrp;
	
	@Column(name = "Scheme_Category",length=30)
	private String plant;
	@Column(name = "Scheme_Category",length=30)
	private String salesDistrict;
	
	@Column(name = "Scheme_Category",length=30)
	private String cityCode;
	@Column(name = "Scheme_Category",length=30)
	private String customerGrp;
	@Column(name = "Scheme_Category",length=30)
	private String customer;
	@Column(name = "Scheme_Category",length=30)
	private String shoppingCondition;
	
	@Column(name = "Scheme_Category",length=30)
	private String materialGroup;
	@Column(name = "Scheme_Category",length=30)
	private String material;
	
	@Column(name = "Scheme_Category",length=30)
	private String compName;
	
	@Column(name = "Scheme_Category",length=30)
	private String soName;
	@Column(name = "Scheme_Category",length=30)
	private String dchlName;
	@Column(name = "Scheme_Category",length=30)
	private String regionName;
	@Column(name = "Scheme_Category",length=30)
	private String divName;
	
	@Column(name = "Scheme_Category",length=30)
	private String countryCode;
	
	@Column(name = "Prev_From_Date",length=10)
	private String prevfromDate;
	
	@Column(name = "Prev_To_Date",length=10)
	private String prevToDate;
	
	@Column(name = "Scheme_Category",length=30)
	private String paymentInstrumentType;
	
	
	@Column(name = "Cost_Center",length=10)
	private String costCenter;
	
	@Column(name = "Sales_Doc_Type",length=4)
	private String salesDocType;
	
	@Column(name = "Order_No",length=12)
	private String orderNo;
	
	@Column(name = "Price_List",length=4)
	private String priceList;
	
	@Column(name = "Self_Or_Group",length=4)
	private String selfOrGroup;
	
	@Column(name = "Tax_COde",length=4)
	private String taxCode;
	
	@Column(name = "Budget_Refference_no",length=12)
	private String budgetReferenceNo;
	
	@Column(name = "Business_Place",length=4)
	private String businessPlace;
	
	@Column(name = "SingleCharacter_Ind",length=4)
	private String singleCharacterInd;
	
	@Column(name = "SAP_NonSAP_Data",length=4)
	private String sapNonSapData;
	
	@Column(name = "Created_By",length=12)
	private String createdBy;
	
	@Column(name = "Created_On",length=15)
	private String createdOn;
	
	@Column(name = "Approve_Status",length=45)
	private String approveStatus;

	public int getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}

	public String getSchemNumb() {
		return schemNumb;
	}

	public void setSchemNumb(String schemNumb) {
		this.schemNumb = schemNumb;
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

	public String getBuisnessArea() {
		return buisnessArea;
	}

	public void setBuisnessArea(String buisnessArea) {
		this.buisnessArea = buisnessArea;
	}

	public String getGlAccount() {
		return glAccount;
	}

	public void setGlAccount(String glAccount) {
		this.glAccount = glAccount;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getExcCstScale() {
		return excCstScale;
	}

	public void setExcCstScale(String excCstScale) {
		this.excCstScale = excCstScale;
	}

	public String getPrevfromDate() {
		return prevfromDate;
	}

	public void setPrevfromDate(String prevfromDate) {
		this.prevfromDate = prevfromDate;
	}

	public String getPrevToDate() {
		return prevToDate;
	}

	public void setPrevToDate(String prevToDate) {
		this.prevToDate = prevToDate;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getSalesDocType() {
		return salesDocType;
	}

	public void setSalesDocType(String salesDocType) {
		this.salesDocType = salesDocType;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public String getSingleCharacterInd() {
		return singleCharacterInd;
	}

	public void setSingleCharacterInd(String singleCharacterInd) {
		this.singleCharacterInd = singleCharacterInd;
	}

	public String getSapNonSapData() {
		return sapNonSapData;
	}

	public void setSapNonSapData(String sapNonSapData) {
		this.sapNonSapData = sapNonSapData;
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
	

	
}
*/