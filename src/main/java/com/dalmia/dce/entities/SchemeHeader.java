package com.dalmia.dce.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sch_header")

public class SchemeHeader {
	@Id
	@Column(name = "Header_Id",length=11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schemeId;
	
	@Column(name = "Sales_Doc_Type",length=4)
	private String salesDocType;
	
	@Column(name = "Scheme_Category",length=30)
	private String schemCategory;
	
	@Column(name = "Scheme_Type",length=30)
	private String schemType;
	
	@Column(name = "Order_No",length=30)
	private String OrderNo;
	
	@Column(name = "Scheme_No",length=30)
	private String schemNumb;
	
	@Column(name = "Price_List",length=4)
	private String priceList;
	
	@Column(name = "Self_Or_Group",length=4)
	private String selfOrGroup;
	
	@Column(name = "Tax_COde",length=4)
	private String taxCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "From_Date")
	private Date fromDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "To_Date")
	private Date toDate;
	
	@Column(name = "GL_Account",length=10)
    private String glAccount;
	
	@Column(name = "Budget_Reference_No",length=12)
    private String budgetReferenceNo;
	
	
	@Column(name = "Business_Place",length=4)
	private String businessPlace;
	
	
	@Column(name = "Active",length=4)
	private String active;
	
	@Column(name = "Exclusive_CST_Sale",length=4)
	private String exclusiveCSTSale;
	
	@Column(name = "Single_Charecter_Ind",length=4)
	private String singleCharecterInd;
	
	
	@Column(name = "SAP_NonSAP_Date",length=4)
	private String sapNonSapDate;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Prev_From_Date")
	private Date prevfromDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Prev_To_Date")
	private Date prevToDate;
	
	@Column(name = "Cost_Center",length=10)
    private String costCenter;
	
	@Column(name = "Business_Area",length=4)
	private String buisnessArea;
	
	
	@Column(name = "Created_By",length=12)
	private String createdBy;
	
	@Column(name = "Created_On",length=15)
	private String createdOn;
	
	@Column(name = "Approve_Status",length=45)
	private String approveStatus;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Header_Id", referencedColumnName = "Header_Id")
    private List<SchemeHeaderDetail> schemeHeaderDetail;
	
	/*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Header_Id", referencedColumnName = "Header_Id")
    private List<SchemeHeaderCond> schemeHeaderCond;*/
	////////

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

	public List<SchemeHeaderDetail> getSchemeHeaderDetail() {
		return schemeHeaderDetail;
	}

	public void setSchemeHeaderDetail(List<SchemeHeaderDetail> schemeHeaderDetail) {
		this.schemeHeaderDetail = schemeHeaderDetail;
	}

	/*public List<SchemeHeaderCond> getSchemeHeaderCond() {
		return schemeHeaderCond;
	}

	public void setSchemeHeaderCond(List<SchemeHeaderCond> schemeHeaderCond) {
		this.schemeHeaderCond = schemeHeaderCond;
	}
	*/
	
	
	
}
