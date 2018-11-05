package com.dalmia.dce.entities;

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
	

	}
