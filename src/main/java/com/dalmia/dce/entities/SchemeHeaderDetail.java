/*package com.dalmia.dce.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@NamedQuery(name = "User.findByName", query = "SELECT u FROM sch_header_det u WHERE LOWER(u.userName) = LOWER(?1)")
@Table(name = "sch_header_det")
public class SchemeHeaderDetail implements Serializable {
	private static final long serialVersionUID = 4865903039190150223L;
	@Id
	@Column(name = "Header_ID")
	private String headerId;
	@Column(name = "Company_Code", length = 6)
	private String companyCode;

	@Column(name = "Sales_Org",length = 6)
	private String salesOrg;

	@Column(name = "Distribution_Channel", length = 6)
	private String distributionChannel;

	@Column(name = "Division", length = 6)
	private String division;

	@Column(name = "Salse_Office", length = 6)
	private String salseOffice;

	@Column(name = "Sales_Group")
	private String salesGroup;
	
	@Column(name = "Salse_District")
	private String salseDistrict;
	////
	@Column(name = "Region", length = 6)
	private String region;

	@Column(name = "Country_Code",length = 3)
	private String countryCode;

	@Column(name = "City_Code", length = 6)
	private String cityCode;

	@Column(name = "City", length = 25)
	private String city;

	@Column(name = "Customer", length = 10)
	private String customer;

	@Column(name = "Customer_Group",length = 10)
	private String customerGroup;
	
	@Column(name = "Serv_Agnt_Proc_Group",length = 4)
	private String servAgntProcGroup;
	
	//
	@Column(name = "Account_Group", length = 4)
	private String accountGroup;

	@Column(name = "Vendor",length = 10)
	private String vendor;

	@Column(name = "Material", length = 18)
	private String material;

	@Column(name = "Material_Group", length = 9)
	private String materialGroup;

	@Column(name = "Plant", length = 6)
	private String plant;

	@Column(name = "Shipping_Cond",length = 6)
	private String shippingCond;
	
	@Column(name = "Payment_Method",length = 20)
	private String paymentMethod;
	
	@Column(name = "Billing_Type", length = 6)
	private String billingType;

	@Column(name = "Profit_Center",length = 10)
	private String profitCenter;
	
	@Column(name = "Partner_Functn",length = 20)
	private String partnerFunctn;

	public String getHeaderId() {
		return headerId;
	}

	public void setHeaderId(String headerId) {
		this.headerId = headerId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getDistributionChannel() {
		return distributionChannel;
	}

	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getSalseOffice() {
		return salseOffice;
	}

	public void setSalseOffice(String salseOffice) {
		this.salseOffice = salseOffice;
	}

	public String getSalesGroup() {
		return salesGroup;
	}

	public void setSalesGroup(String salesGroup) {
		this.salesGroup = salesGroup;
	}

	public String getSalseDistrict() {
		return salseDistrict;
	}

	public void setSalseDistrict(String salseDistrict) {
		this.salseDistrict = salseDistrict;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCustomerGroup() {
		return customerGroup;
	}

	public void setCustomerGroup(String customerGroup) {
		this.customerGroup = customerGroup;
	}

	public String getServAgntProcGroup() {
		return servAgntProcGroup;
	}

	public void setServAgntProcGroup(String servAgntProcGroup) {
		this.servAgntProcGroup = servAgntProcGroup;
	}

	public String getAccountGroup() {
		return accountGroup;
	}

	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getMaterialGroup() {
		return materialGroup;
	}

	public void setMaterialGroup(String materialGroup) {
		this.materialGroup = materialGroup;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getShippingCond() {
		return shippingCond;
	}

	public void setShippingCond(String shippingCond) {
		this.shippingCond = shippingCond;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	public String getProfitCenter() {
		return profitCenter;
	}

	public void setProfitCenter(String profitCenter) {
		this.profitCenter = profitCenter;
	}

	public String getPartnerFunctn() {
		return partnerFunctn;
	}

	public void setPartnerFunctn(String partnerFunctn) {
		this.partnerFunctn = partnerFunctn;
	}
	
	

	}
*/