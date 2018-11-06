package com.dalmia.dce.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalmia.dce.vo.CompanyCodesVO;
import com.dalmia.dce.vo.DistributionChannelVO;
import com.dalmia.dce.vo.SalesDistrictVO;
import com.dalmia.dce.vo.SalesOrganizationVO;
import com.dalmia.dce.vo.SchemeUniverseVO;

@Service
public class ShemCreationDetailDao {
	

	
	@Autowired
	DataSource dataSource;
	
	private Connection jdbcConnection=null;
	
	public Map<String, SalesOrganizationVO> getSalesOrg() throws SQLException {
		
		jdbcConnection = dataSource.getConnection();
		Map<String,SalesOrganizationVO> salesOrgMap = new LinkedHashMap<String,SalesOrganizationVO>();
		String sql = "select SOrg,Name from sdms.sales_organization";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		String idAndName = "";
		while (resultSet.next()) {
			
			String sorg = resultSet.getString("SOrg");
			String name =  resultSet.getString("Name");
			SalesOrganizationVO salesOrg = new SalesOrganizationVO();
			salesOrg.setSorg(sorg);
			salesOrg.setName(name);
			salesOrgMap.put(sorg, salesOrg);
			
		}
		
		resultSet.close();
		statement.close();
		//disconnect();
		return salesOrgMap;
	}
	
	public Map<String,SalesDistrictVO> getSalesDistrict() throws SQLException {
		jdbcConnection = dataSource.getConnection();
		Map<String,SalesDistrictVO> salesDistrictMap = new LinkedHashMap<String,SalesDistrictVO>();
		String sql = "select SDst,District_Name from sales_district";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		String idAndName = "";
		
		while (resultSet.next()) {
			
			SalesDistrictVO  sdv= new SalesDistrictVO();
			String sdst = resultSet.getString("SDst");
			sdv.setSdst(resultSet.getString("SDst"));
			sdv.setDistrictName(resultSet.getString("SDst"));
			salesDistrictMap.put(sdst, sdv);
			
		}
		
		resultSet.close();
		statement.close();
		//disconnect();
		return salesDistrictMap;
	}
	
	public Map<String,CompanyCodesVO> getComp() throws SQLException {
		jdbcConnection = dataSource.getConnection();
		Map<String,CompanyCodesVO> compMap = new LinkedHashMap<String,CompanyCodesVO>();
		String sql = "select CoCd,Company_Name from company_codes";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			CompanyCodesVO compCode = new CompanyCodesVO();
			String comCode = resultSet.getString("CoCd");
			 compCode.setComCode(resultSet.getString("CoCd"));
			compCode.setName(resultSet.getString("Company_Name"));
			
			compMap.put(comCode, compCode);
			
		}
		
		resultSet.close();
		statement.close();
		return compMap;
	}
	
	public Map<String,SchemeUniverseVO> getSchemUnverse() throws SQLException {
		jdbcConnection = dataSource.getConnection();
		Map<String, SchemeUniverseVO> schemUnivMap = new LinkedHashMap<String,SchemeUniverseVO>();
		String sql = "select Business_Name,Field_Type from scheme_universe order by Business_Name";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			
			String businessName = resultSet.getString("Business_Name");
			//String fieldType =  resultSet.getString("Field_Type"); 
			String value = businessName.replaceAll("\\s","");;
			SchemeUniverseVO schemeUnv = new SchemeUniverseVO();
			schemeUnv.setBusinessName(businessName);
			schemeUnv.setValue(value);
			schemUnivMap.put(businessName, schemeUnv);
			
		}
		
		resultSet.close();
		statement.close();
		return schemUnivMap;
	}

	//
	
	public Map<String,DistributionChannelVO> getDistbChanel() throws SQLException {
		jdbcConnection = dataSource.getConnection();
		Map<String,DistributionChannelVO> distChanelMap = new LinkedHashMap<String,DistributionChannelVO>();
		String sql = "select DChl,Name from distribution_channel";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		String idAndName ="";
		while (resultSet.next()) {
			
			String dch = resultSet.getString("DChl");
			String name =  resultSet.getString("Name");
			DistributionChannelVO distChannel = new DistributionChannelVO();
			distChannel.setDch(dch);
			distChannel.setName(name);
			distChanelMap.put(dch, distChannel);
			
		}
		resultSet.close();
		statement.close();
		return distChanelMap;
	}

	
	public Map<String,String> getDivision() throws SQLException {
		Map<String,String> divisionMap = new LinkedHashMap<String,String>();
		String sql = "select Dv,Name from division";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		String idNameMap = "";
		while (resultSet.next()) {
			
			String dv = resultSet.getString("Dv");
			String name =  resultSet.getString("Name"); 
			idNameMap = dv+"-"+name;
			divisionMap.put(dv, idNameMap);
			
		}
	
	resultSet.close();
	statement.close();
	return divisionMap;
}
//select BillT,Description from billing_type
	public Map<String,String> getBilling() throws SQLException {
		Map<String,String> billingMap = new LinkedHashMap<String,String>();
		String sql = "select BT_id,Description from billing_type";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		String idAndName = "";
		while (resultSet.next()) {
			
			String btId = resultSet.getString("BT_id");
			String description =  resultSet.getString("Description");
			idAndName = btId+"-"+description;
			billingMap.put(btId, idAndName);
			
		}
	
	resultSet.close();
	statement.close();
	return billingMap;
}
	
	//
	public Map<String,String> getSalesOffice() throws SQLException {
		Map<String,String> salesOfficeMap = new LinkedHashMap<String,String>();
		String sql = "select SOff,Description from sales_office";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		String idName = "";
		while (resultSet.next()) {
			
			String soff = resultSet.getString("SOff");
			String description =  resultSet.getString("Description"); 
			idName = soff +"-"+description;
			salesOfficeMap.put(soff, idName);
			
		}
	
	resultSet.close();
	statement.close();
	return salesOfficeMap;
}
//
	public Map<String,String> getSalesGroup() throws SQLException {
		Map<String,String> salesGroupMap = new LinkedHashMap<String,String>();
		String sql = "select SGrp,Description from sales_group";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			
			String sgrp = resultSet.getString("SGrp");
			String description =  resultSet.getString("Description"); 
			salesGroupMap.put(sgrp, sgrp+"-"+description);
			
		}
	
	resultSet.close();
	statement.close();
	return salesGroupMap;
}
	
	public Map<String,String> getRegion() throws SQLException {
		Map<String,String> regionMap = new LinkedHashMap<String,String>();
		String sql = "select Rg,Description from region";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			
			String rg = resultSet.getString("Rg");
			String description =  resultSet.getString("Description"); 
			regionMap.put(rg, rg+"-"+description);
			
		}
	
	resultSet.close();
	statement.close();
	return regionMap;
}
//
	public Map<String,String> getCity() throws SQLException {
		Map<String,String> cityMap = new LinkedHashMap<String,String>();
		String sql = "SELECT city_id,Description FROM city_code";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			
			String city = resultSet.getString("city_id");
			String description =  resultSet.getString("Description"); 
			cityMap.put(city, city+"-"+description);
			
		}
	
	resultSet.close();
	statement.close();
	return cityMap;
}
	//
	public Map<String,String> getCustmGrp() throws SQLException {
		Map<String,String> customerGrpMap = new LinkedHashMap<String,String>();
		String sql = "select CGrp,Name from customer_group";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			
			String cgrp = resultSet.getString("CGrp");
			String name =  resultSet.getString("Name"); 
			customerGrpMap.put(cgrp, cgrp+"-"+name);
			
		}
	
	resultSet.close();
	statement.close();
	return customerGrpMap;
}
//
	public Map<String,String> getCustomer() throws SQLException {
		Map<String,String> customerMap = new LinkedHashMap<String,String>();
		String sql = "SELECT Customer,Name1 FROM customer";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			
			String customer = resultSet.getString("Customer");
			String name =  resultSet.getString("Name1"); 
			customerMap.put(customer, customer+"-"+name);
			
		}
	
	resultSet.close();
	statement.close();
	return customerMap;
}
	//
	public Map<String,String> getShippingCondition() throws SQLException {
		Map<String,String> shippingConditionMap = new LinkedHashMap<String,String>();
		String sql = "select SC,Description from shipping_conditions";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			
			String sc = resultSet.getString("SC");
			String description =  resultSet.getString("Description"); 
			shippingConditionMap.put(sc, sc+"-"+description);
			
		}
	
	resultSet.close();
	statement.close();
	return shippingConditionMap;
}
	public Map<String,String> getMaterialGrp() throws SQLException {
		Map<String,String> materialGrpMap = new LinkedHashMap<String,String>();
		String sql = "select Matl_Group,Material_Group_Desc from material_group";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			
			String materialGrp = resultSet.getString("Matl_Group");
			String materialGrpDesc =  resultSet.getString("Material_Group_Desc"); 
			materialGrpMap.put(materialGrp, materialGrp+"-"+materialGrpDesc);
			
		}
	
	resultSet.close();
	statement.close();
	return materialGrpMap;
}
  //
	
	public Map<String,String> getMaterial() throws SQLException {
		Map<String,String> materialMap = new LinkedHashMap<String,String>();
		String sql = "select Material,Material_Description from material";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			
			String materialGrp = resultSet.getString("Material");
			String materialGrpDesc =  resultSet.getString("Material_Description"); 
			materialMap.put(materialGrp, materialGrp+"-"+materialGrpDesc);
			
		}
	
	resultSet.close();
	statement.close();
	return materialMap;
}
	
	public Map<String,String> getPlant() throws SQLException {
		Map<String,String> plantMap = new LinkedHashMap<String,String>();
		String sql = "SELECT plant_id,Name1 FROM plant";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			
			String plantId = resultSet.getString("plant_id");
			String name =  resultSet.getString("Name1"); 
			plantMap.put(plantId, plantId+"-"+name);
			
		}
	
	resultSet.close();
	statement.close();
	return plantMap;
}

	
	/*public ViewSchemCreation getViewSchemCreation() throws SQLException {
		ViewSchemCreation viewSchemCreation = new ViewSchemCreation();
		String sql = "select Company_Code,scheme_No,Scheme_Category,Scheme_Type,From_Date,To_Date,Active,Exclude_CST_Sale,Sales_Org,"
                +"Distrbution_Channel,Division,Billing_Type,Sales_Office,Sales_Group,Plant,Region,Sales_District,"
                +"Country_Code,City_Code,Customer_Group,Customer,Shipping_Cond,Material_Group,Material,Business_Area,"
                +"Payment_Method,Profit_Center,GL_Account,Cost_Center,Prev_From_Date,Prev_To_Date"
                +" from qd_definition_header order by QD_Definition_Header_ID desc limit 1 ";
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			
			   String companyCode = resultSet.getString("Company_Code");
			   String compName="";
			   if(companyCode !=null && !companyCode.equals(""))
			   {
				   String query2 = "select Company_Name from company_codes where CoCd = '"+companyCode+"' ";
				   Statement statement2 = jdbcConnection.createStatement();
				   ResultSet resultSetComp = statement2.executeQuery(query2);
					while (resultSetComp.next()) {
				     compName =resultSetComp.getString("Company_Name");
				    if(compName == null)
				    	compName="NA";
					}
					resultSetComp.close();
					statement2.close();
			   }
			   else
			   {
				   compName="NA";
			   }
			   viewSchemCreation.setCompName(compName);
			   String schemNumb = resultSet.getString("scheme_No");
			   if(schemNumb == null || schemNumb.equals(""))
			   {
				   schemNumb = "NA";
			   }
			   
			   viewSchemCreation.setSchemNumb(schemNumb);
			   String schemCategory =  resultSet.getString("Scheme_Category");
			   if(schemCategory == null || schemCategory.equals(""))
			       schemCategory = "NA";
			   viewSchemCreation.setSchemCategory(schemCategory);
			   String schemType = resultSet.getString("Scheme_Type");
			   if(schemType == null || schemType.equals(""))
				   schemType = "NA";
			   viewSchemCreation.setSchemType(schemType);
			   String fromDate = resultSet.getString("From_Date");
			   if(fromDate == null || fromDate.equals(""))
				   fromDate = "NA";
			   viewSchemCreation.setFromDate(fromDate);
			   String toDate = resultSet.getString("To_Date");
			   if(toDate == null || toDate.equals(""))
				   toDate = "NA";
			   viewSchemCreation.setToDate(toDate);
			   String active = resultSet.getString("Active");
			   if(active == null || active.equals(""))
				   active = "NA";
			   viewSchemCreation.setActive(active);
			   String excCstScale = resultSet.getString("Exclude_CST_Sale");
			   if(excCstScale ==null || excCstScale.equals(""))
				   excCstScale = "NA";
			   viewSchemCreation.setExcCstScale(excCstScale);
			   String billingType = resultSet.getString("Billing_Type");
			   if(billingType == null || billingType.equals(""))
				   billingType = "NA";
			   if(billingType != null && billingType.equals("Select"))
				   billingType = "All";
			   viewSchemCreation.setBillingType(billingType);
			   String salesOffice = resultSet.getString("Sales_Office");
			   if(salesOffice ==null || !salesOffice.equals(""))
				   salesOffice = "NA";
			   if(salesOffice != null && salesOffice.equals("Select"))
				   salesOffice = "All";
			   viewSchemCreation.setSalesOffice(salesOffice);
			   String salesGrp = resultSet.getString("Sales_Group");
			   if(salesGrp ==null || salesGrp.equals(""))
				   salesGrp = "NA";
			   if(salesGrp != null && salesGrp.equals("Select"))
				   salesGrp = "All";
			   viewSchemCreation.setSalesGrp(salesGrp);
			   String plant  = resultSet.getString("Plant");
			   if(plant ==null || !plant.equals(""))
				   plant = "NA";
			   if(plant!=null && plant.equals("Select"))
				   plant = "All";
			   viewSchemCreation.setPlant(plant);
			   String salesDistrict = resultSet.getString("Sales_District");
			   if(salesDistrict ==null || salesDistrict.equals(""))
				   salesDistrict = "NA";
			   if(salesDistrict!=null && salesDistrict.equals("Select"))
				   salesDistrict = "All";
			   viewSchemCreation.setSalesDistrict(salesDistrict);
			   String countryCode = resultSet.getString("Country_Code");
			   if(countryCode ==null || countryCode.equals(""))
				   countryCode = "NA";
			   if(countryCode.equals("Select"))
				   countryCode = "All";
			   viewSchemCreation.setCountryCode(countryCode);
			   String cityCode = resultSet.getString("City_Code");
			   if(cityCode == null || cityCode.equals(""))
				   cityCode = "NA";
			   if(cityCode != null && cityCode.equals("Select"))
				   cityCode = "All";
			   viewSchemCreation.setCityCode(cityCode); 
			   String customerGrp =  resultSet.getString("Customer_Group");
			   if(customerGrp == null || customerGrp.equals(""))
				   customerGrp = "NA";
			   if(customerGrp != null && customerGrp.equals("Select"))
				   customerGrp = "All";
			   viewSchemCreation.setCustomerGrp(customerGrp);
			   String customer  = resultSet.getString("Customer");
			   if(customer == null || customer.equals(""))
				   customer = "NA";
			   if(customer != null && customer.equals("Select"))
				   customer = "All";
			   viewSchemCreation.setCustomer(customer);
			   String shoppingCondition =  resultSet.getString("Shipping_Cond");
			   if(shoppingCondition == null || shoppingCondition.equals(""))
				   shoppingCondition = "NA";
			   if(shoppingCondition != null && shoppingCondition.equals("Select"))
				   shoppingCondition = "All";
			   viewSchemCreation.setShoppingCondition(shoppingCondition);
			   String materialGroup = resultSet.getString("Material_Group");
			   if(materialGroup == null || materialGroup.equals(""))
				   materialGroup = "NA";
			   if(materialGroup != null && materialGroup.equals("Select"))
				   materialGroup = "All";
			   viewSchemCreation.setMaterialGroup(materialGroup);
			   String material = resultSet.getString("Material");;
			   if(material == null || material.equals(""))
				   material = "NA";
			   if(material != null && material.equals("Select"))
				   material = "All";
			   viewSchemCreation.setMaterial(material);
			   
			   String buisnessArea = resultSet.getString("Business_Area");
			   if(buisnessArea == null || buisnessArea.equals(""))
				   buisnessArea = "NA";
			   if(buisnessArea != null && buisnessArea.equals("Select"))
				   buisnessArea = "All";
			   viewSchemCreation.setBuisnessArea(buisnessArea);
			   String paymentMethod = resultSet.getString("Payment_Method");
			   if(paymentMethod == null || paymentMethod.equals(""))
				   paymentMethod = "NA";
			   if(paymentMethod != null && paymentMethod.equals("Select"))
				   paymentMethod = "All";
			   viewSchemCreation.setPaymentMethod(paymentMethod);
			    String profitCenter = resultSet.getString("Profit_Center");
			   if(profitCenter == null || profitCenter.equals(""))
				   profitCenter = "NA";
			   if(profitCenter == null || profitCenter.equals("Select"))
				   profitCenter = "All";
			   viewSchemCreation.setProfitCenter(profitCenter);
			   String glAccount = resultSet.getString("GL_Account");
			   if(glAccount == null || glAccount.equals(""))
				   glAccount = "NA";
			   if(glAccount != null && glAccount.equals("Select"))
				   glAccount = "All";
			   viewSchemCreation.setGlAccount(glAccount);
			    String costCenter = resultSet.getString("Cost_Center");
			    if(costCenter ==null || costCenter.equals(""))
			    	costCenter = "NA";
				   if(costCenter != null && costCenter.equals("Select"))
					   costCenter = "All";
				   viewSchemCreation.setCostCenter(costCenter);
				   
				   String prevfromDate = resultSet.getString("Prev_From_Date");
				   if(prevfromDate == null || prevfromDate.equals(""))
					   prevfromDate = "NA";
				   viewSchemCreation.setPrevfromDate(prevfromDate);
				   String prevToDate = resultSet.getString("Prev_To_Date");
				   if(prevToDate == null || prevToDate.equals(""))
					   prevToDate = "NA";
				   viewSchemCreation.setPrevToDate(prevToDate);
			   String sorg = resultSet.getString("Sales_Org");
			   String soName="";
			   if(sorg !=null && !sorg.equals(""))
			   {
				   String query2 = "select Name from sales_organization where SOrg = '"+sorg+"'";
				   Statement statementSo = jdbcConnection.createStatement();
				   ResultSet resultSetSO = statementSo.executeQuery(query2);
					while (resultSetSO.next()) {
						soName =resultSetSO.getString("Name");
				    if(soName == null)
				    	soName="NA";
					}
					resultSetSO.close();
					statementSo.close();
			   }
			   viewSchemCreation.setSoName(soName);
			   String dchl  = resultSet.getString("Distrbution_Channel");
			   String dchlName = "";
			   if(dchl !=null && !dchl.equals(""))
			   {
				   String query2 = "select Name from distribution_channel where DChl = '"+dchl+"'";
				   Statement statementDchl = jdbcConnection.createStatement();
				   ResultSet resultSetDchl = statementDchl.executeQuery(query2);
					while (resultSetDchl.next()) {
						dchlName =resultSetDchl.getString("Name");
				    if(dchlName == null)
				    	dchlName="NA";
					}
					
					resultSetDchl.close();
					statementDchl.close();
			   }
			   viewSchemCreation.setDchlName(dchlName);
			   String div = resultSet.getString("Division");
			   String divName ="";
			   if(div !=null && !div.equals(""))
			   {
				   String query2 = "select Name from division where Dv = '"+div+"'";
				   Statement statementDiv = jdbcConnection.createStatement();
				   ResultSet resultSetDiv = statementDiv.executeQuery(query2);
					while (resultSetDiv.next()) {
						divName =resultSetDiv.getString("Name");
				    if(divName == null)
				    	divName="NA";
					}
					resultSetDiv.close();
					statementDiv.close();
			   }
			   viewSchemCreation.setDivName(divName);
			   String region = resultSet.getString("Region");;
			   String regionName = "";
			   if(region !=null && !region.equals(""))
			   {
				   String query2 = "select Description from region where Rg = '"+region+"'";
				   Statement statementRgn = jdbcConnection.createStatement();
				   ResultSet resultSetRgn = statementRgn.executeQuery(query2);
					while (resultSetRgn.next()) {
						regionName =resultSetRgn.getString("Description");
				    if(regionName == null)
				    	regionName="NA";
					}
					resultSetRgn.close();
					statementRgn.close();
			   }
			   viewSchemCreation.setRegionName(regionName);
			
			
		}
	
	resultSet.close();
	statement.close();
	return viewSchemCreation;
}
	
*/	

}
