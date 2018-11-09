package com.dalmia.dce.vo;

import java.util.Date;

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

	private String budgetReferenceNo;

	private String businessPlace;

	private String active;

	private String exclusiveCSTSale;

	private String singleCharecterInd;

	private String sapNonSapDate;

	private Date prevfromDate;

	private Date prevToDate;

	//private String costCenter;

	private String createdBy;

	private String createdOn;
	
	private CompanyCodesVO companyCode;
	
	private SalesOrganizationVO salesOrg; 
	private DistributionChannelVO distributionChannel;
	private DivisionVO division;
	private SalesOfficeVO salseOffice;
	private SalesGroupVO salesGroup;
	private SalesDistrictVO salseDistrict;
	private RegionVO region;
	private CountryCodeVO countryCode;
	private CityCodeVO cityCode;
	private CustomerVO customer;
	private CustomerGroupVO customerGroup;
	private MaterialVO material;
	private MaterialGroupVO materialGroup;
	private PlantVO plant;
	private ShippingConditionsVO shippingCond;
	private PaymentInsurenceTypeVO paymentMethod;
	private BillingTypeVO billingType;
	private ProfitCenterVO profitCenter;
	private CostCenterVO costCenter;
	private BusinessAreaVO buisnessArea;
	private GLAccountVO glAccount;
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
	public BusinessAreaVO getBuisnessArea() {
		return buisnessArea;
	}
	public void setBuisnessArea(BusinessAreaVO buisnessArea) {
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
	public CompanyCodesVO getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(CompanyCodesVO companyCode) {
		this.companyCode = companyCode;
	}
	public SalesOrganizationVO getSalesOrg() {
		return salesOrg;
	}
	public void setSalesOrg(SalesOrganizationVO salesOrg) {
		this.salesOrg = salesOrg;
	}
	public DistributionChannelVO getDistributionChannel() {
		return distributionChannel;
	}
	public void setDistributionChannel(DistributionChannelVO distributionChannel) {
		this.distributionChannel = distributionChannel;
	}
	public DivisionVO getDivision() {
		return division;
	}
	public void setDivision(DivisionVO division) {
		this.division = division;
	}
	public SalesOfficeVO getSalseOffice() {
		return salseOffice;
	}
	public void setSalseOffice(SalesOfficeVO salseOffice) {
		this.salseOffice = salseOffice;
	}
	public SalesGroupVO getSalesGroup() {
		return salesGroup;
	}
	public void setSalesGroup(SalesGroupVO salesGroup) {
		this.salesGroup = salesGroup;
	}
	public SalesDistrictVO getSalseDistrict() {
		return salseDistrict;
	}
	public void setSalseDistrict(SalesDistrictVO salseDistrict) {
		this.salseDistrict = salseDistrict;
	}
	public RegionVO getRegion() {
		return region;
	}
	public void setRegion(RegionVO region) {
		this.region = region;
	}
	public CountryCodeVO getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(CountryCodeVO countryCode) {
		this.countryCode = countryCode;
	}
	public CityCodeVO getCityCode() {
		return cityCode;
	}
	public void setCityCode(CityCodeVO cityCode) {
		this.cityCode = cityCode;
	}
	public CustomerVO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}
	public CustomerGroupVO getCustomerGroup() {
		return customerGroup;
	}
	public void setCustomerGroup(CustomerGroupVO customerGroup) {
		this.customerGroup = customerGroup;
	}
	public MaterialVO getMaterial() {
		return material;
	}
	public void setMaterial(MaterialVO material) {
		this.material = material;
	}
	public MaterialGroupVO getMaterialGroup() {
		return materialGroup;
	}
	public void setMaterialGroup(MaterialGroupVO materialGroup) {
		this.materialGroup = materialGroup;
	}
	public PlantVO getPlant() {
		return plant;
	}
	public void setPlant(PlantVO plant) {
		this.plant = plant;
	}
	public ShippingConditionsVO getShippingCond() {
		return shippingCond;
	}
	public void setShippingCond(ShippingConditionsVO shippingCond) {
		this.shippingCond = shippingCond;
	}
	public PaymentInsurenceTypeVO getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentInsurenceTypeVO paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public BillingTypeVO getBillingType() {
		return billingType;
	}
	public void setBillingType(BillingTypeVO billingType) {
		this.billingType = billingType;
	}
	public ProfitCenterVO getProfitCenter() {
		return profitCenter;
	}
	public void setProfitCenter(ProfitCenterVO profitCenter) {
		this.profitCenter = profitCenter;
	}
	public CostCenterVO getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(CostCenterVO costCenter) {
		this.costCenter = costCenter;
	}
	public GLAccountVO getGlAccount() {
		return glAccount;
	}
	public void setGlAccount(GLAccountVO glAccount) {
		this.glAccount = glAccount;
	}
	
	
}
