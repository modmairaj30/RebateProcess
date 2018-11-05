package com.dalmia.dce.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dalmia.app.JConnection;
import com.dalmia.app.JDBCConnection;
import com.dalmia.app.MyServlet;
import com.dalmia.app.model.Scheme;
import com.dalmia.app.model.Slab;
import com.dalmia.util.DateUtilsClass;
import com.dalmia.util.MysqlConnect;

public class SchemeDao {

	
	Logger logger = Logger.getLogger(SchemeDao.class.getName());
	private Connection jdbcConnection;
	
	JConnection jdbc = new JConnection();
	
	protected void connect() throws SQLException {
		jdbcConnection = MysqlConnect.getDbCon();
		
	}
	
	
		
	public List<Scheme> listAllScheme() throws SQLException {
		List<Scheme> listScheme = new ArrayList<>();
		String sql = "SELECT q.Region,q.QD_Definition_Header_ID,q.SCHEME_CATEGORY,SCHEME_TYPE,q.Scheme_No,q.Created_By,"+
        "q.Created_On,q.Prev_From_Date,q.Prev_To_Date,q.Approve_Status,r.Description FROM qd_definition_header q LEFT JOIN  region r ON  q.Region  = r.Rg";
		connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			int schemeId = resultSet.getInt("QD_Definition_Header_ID");
			String schemeCategory = resultSet.getString("SCHEME_CATEGORY");
			String schemeType =  resultSet.getString("SCHEME_TYPE"); 
			String schemeName = resultSet.getString("Scheme_No"); 
			String createdBy = resultSet.getString("Created_By"); 
			String createdOn = resultSet.getString("Created_On");
			String effectiveDateFrom = resultSet.getString("Prev_From_Date");
			String effectiveDateTo = resultSet.getString("Prev_To_Date"); 
			String status = resultSet.getString("Approve_Status");
			String region = resultSet.getString("Description");
			
			Scheme scheme = new Scheme(schemeId+"", schemeCategory, schemeType, schemeName, createdBy, createdOn, effectiveDateFrom, effectiveDateTo, status,region);
			listScheme.add(scheme);
		}
		
		resultSet.close();
		statement.close();
		//disconnect();
		return listScheme;
	}
	
	public boolean deleteScheme(int schemId) throws SQLException {
		String sql = "DELETE FROM qd_definition_header where QD_Definition_Header_ID = ?";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, schemId);
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowDeleted;		
	}
	
	public boolean updateScheme(Scheme scheme) throws SQLException {
		StringBuilder sql = new StringBuilder("UPDATE qd_definition_header SET SCHEME_CATEGORY = ?, SCHEME_TYPE = ?, Created_By = ?, Created_On = ?, Prev_From_Date = ?, Prev_To_Date = ?, Region=?");
		sql.append(" WHERE QD_Definition_Header_ID = ?") ;
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
		
 		
		statement.setString(1, scheme.getSchemeCategory());
		statement.setString(2, scheme.getSchemeType());
		statement.setString(3, scheme.getCreatedBy());
		statement.setString(4, scheme.getCreatedOn());
		statement.setString(5, scheme.getEffectiveDateFrom());
		statement.setString(6, scheme.getEffectiveDateTo());
		statement.setString(7, scheme.getRegion());
		statement.setInt(8, Integer.parseInt(scheme.getSchemeId()));
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		//disconnect();
		return rowUpdated;		
	}
	
	public Scheme getScheme(int id) throws SQLException {
		Scheme scheme = null;
		String sql = "SELECT * FROM qd_definition_header WHERE QD_Definition_Header_ID = ?";
		/*String sql = "SELECT q.QD_Definition_Header_ID,q.SCHEME_CATEGORY,SCHEME_TYPE,q.Scheme_No,q.Created_By,"+
                     "q.Created_On,q.Prev_From_Date,q.Prev_To_Date,q.Approve_Status ,q.Region FROM qd_definition_header q WHERE q.QD_Definition_Header_ID = ?";*/
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			int schemeId = resultSet.getInt("QD_Definition_Header_ID");
			String schemeCategory = resultSet.getString("SCHEME_CATEGORY");
			String schemeType =  resultSet.getString("SCHEME_TYPE"); 
			String schemeName = resultSet.getString("Scheme_No"); 
			String createdBy = resultSet.getString("Created_By"); 
			String createdOn = resultSet.getString("Created_On");
			String effectiveDateFrom = resultSet.getString("Prev_From_Date");
			String effectiveDateTo = resultSet.getString("Prev_To_Date"); 
			String status = resultSet.getString("Approve_Status");
			String companyCode = resultSet.getString("Company_Code");
			//String salesDocType = resultSet.getString("Sales_Doc_Type");
			String orderNo = resultSet.getString("Order_No");
			String salesOrg = resultSet.getString("Sales_Org");
			String distrbutionChannel = resultSet.getString("Distrbution_Channel");
			String division = resultSet.getString("Division");
			String salesOffice = resultSet.getString("Sales_Office");
			String salesDistrict = resultSet.getString("Sales_District");
			String cityCode = resultSet.getString("City_Code");
			String city = resultSet.getString("City");
			String customer = resultSet.getString("Customer");
			String fromDate = resultSet.getString("From_Date");
			String toDate = resultSet.getString("To_Date");
			String active = resultSet.getString("Active");
			String excludeCSTSale = resultSet.getString("Exclude_CST_Sale");
			String region = resultSet.getString("Region");
			String regionQ = "select Description from region WHERE Rg = ?";
	        PreparedStatement reginStmt = jdbcConnection.prepareStatement(regionQ);
	        reginStmt.setString(1, region);
	 		ResultSet regionResultSet = reginStmt.executeQuery();
	 		String regionName = "";
	 		while(regionResultSet.next())
	 		{
	 			regionName = regionResultSet.getString("Description");
	 		}
	 		
			scheme = new Scheme(schemeId+"", schemeCategory, schemeType, schemeName, createdBy, createdOn, effectiveDateFrom, effectiveDateTo, status,region);
			scheme.setRegionName(regionName);
			scheme.setCompanyCode(companyCode);
			scheme.setOrderNumber(orderNo);
			scheme.setSalesOrganization(salesOrg);
			scheme.setDistributionChannel(distrbutionChannel);
			scheme.setDivision(division);
			scheme.setSalesOffice(salesOffice);
			scheme.setSalesDistrict(salesDistrict);
			scheme.setCityCode(cityCode);
			//scheme.setCityCode(cityCode);
			scheme.setCustomer(customer);
			if(fromDate.equals("")){
			scheme.setFromDate(null);
			}
			else{
				scheme.setFromDate(fromDate);
			}
			scheme.setToDate(toDate);
			if(toDate.equals("")){
				scheme.setToDate(null);
				}
				else{
					scheme.setToDate(toDate);
				}
			scheme.setActive(active);
			//scheme.setActive(active);
			scheme.setExcludeCstSale(excludeCSTSale);
			
		}
		
		 String regionQuery = "select Rg,Description from region";
         PreparedStatement reginStatement = jdbcConnection.prepareStatement(regionQuery);
 		ResultSet regionResultSet = reginStatement.executeQuery();
 		Map<String,String> hmp = new HashedMap<String,String>();
 		while (regionResultSet.next()) {
			String rgId = regionResultSet.getString("Rg");
			String schemeCategory = regionResultSet.getString("Description");
			hmp.put(rgId, schemeCategory);
 		}	
 		scheme.setRegionMap(hmp);
 		resultSet.close();
		statement.close();
		return scheme;
	}
	
	public boolean saveScehem(Scheme scheme) throws SQLException
	{
		 
			//StringBuilder48 sql = new StringBuilder("UPDATE qd_definition_header SET SCHEME_CATEGORY = ?, SCHEME_TYPE = ?, Created_By = ?, Created_On = ?, Prev_From_Date = ?, Prev_To_Date = ?, Region=?");
		String  sql = "INSERT INTO qd_definition_header (Company_Code, Sales_Doc_Type, Scheme_Category, "
				+ "Scheme_Type,Order_No,Scheme_No,Sales_Org,"
				+ "Distrbution_Channel,Division,Sales_Office,"
				+ "Sales_Group,Sales_District,Price_List,Region,"
				+ "Country_Code,City,City_Code,Customer,"
				+ "Serv_Agnt_Proc_Group,Account_Group,Vendor,"
				+ "Customer_Group,Partner_Function,SelfOrGroup,"
				+ "Material,Material_Group,Plant,Profit_Center,Tax_Code,"
				+ "From_Date,To_Date,Shipping_Cond,GL_Account,"
				+ "Budget_Reference_No,Payment_Method,Business_Place,"
				+ "Active,Exclude_CST_Sale,Single_Character_Ind,"
				+ "Billing_Type,SAP_NonSAP_Data,Prev_From_Date,"
				+ "Prev_To_Date,Cost_Center,Business_Area,Created_By,"
				+ "Created_On,Approve_Status) "
				+ "VALUES (?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?)";
			//sql.append(" WHERE QD_Definition_Header_ID = ?") ;
			connect();
			PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
			statement.setString(2, scheme.getCompanyCode());
			statement.setString(3, scheme.getSalesDocType());
			statement.setString(4, scheme.getSchemeCategory());
			statement.setString(5, scheme.getSchemeType());
			statement.setString(6, scheme.getOrderNo());
			statement.setString(7, scheme.getSchemeNo());
			statement.setString(8, scheme.getSalesOrg());
			statement.setString(9, scheme.getDistributionChannel());
			statement.setString(10, scheme.getDivision());
			statement.setString(11, scheme.getSalesOffice());
			statement.setString(12, scheme.getSalesGroup());
			statement.setString(13, scheme.getSalesDistrict());
			statement.setString(14, scheme.getPriceList());
			statement.setString(15, scheme.getRegion());
			statement.setString(16, scheme.getCountryCode());
			statement.setString(17, scheme.getCityCode());
			statement.setString(18, scheme.getCity());
			statement.setString(19, scheme.getCustomer());
			statement.setString(20, scheme.getServAgntProcGroup());
			statement.setString(21, scheme.getAccountGroup());
			statement.setString(22, scheme.getVendor());
			statement.setString(23, scheme.getCustomerGroup());
			statement.setString(24, scheme.getPartnerFunction());
			statement.setString(25, scheme.getSalesGrp());
			statement.setString(26, scheme.getMaterial());
			statement.setString(27, scheme.getMaterialGroup());
			statement.setString(28, scheme.getPlant());
			statement.setString(29, scheme.getProfitCenter());
			statement.setString(30, scheme.getTaxCode());
			statement.setString(31, scheme.getFromDate());
			statement.setString(32, scheme.getToDate());
			statement.setString(33, scheme.getShippingCond());
			statement.setString(34, scheme.getGlAccount());
			statement.setString(35, scheme.getBudgetReferenceNo());
			statement.setString(36, scheme.getPaymentMethod());
			statement.setString(37, scheme.getBusinessPlace());
			statement.setString(38, scheme.getActive());
			statement.setString(39, scheme.getExcludeCstSale());
			statement.setString(40, scheme.getSingleCharacterInd());
			statement.setString(41, scheme.getBillingType());
			statement.setString(42, scheme.getSapNonSapData());
			statement.setString(43, scheme.getPrevFromDate());
			statement.setString(44, scheme.getPrevToDate());
			statement.setString(45, scheme.getCostCenter());
			statement.setString(46, scheme.getBusinessArea());
			statement.setString(47, scheme.getCreatedBy());
			statement.setString(48, scheme.getCreatedOn());
			statement.setString(49, scheme.getStatus());
			
			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			//disconnect();
			return rowInserted;
				
		}
	
	
	
	public Map<String, String> getCompanyCodeAndMap(String condition,String comCode) throws SQLException
	{
		
	Map<String, String> hmp = new LinkedHashMap<String, String>();
	//StringBuilder sql = new StringBuilder("SELECT CoCd,Company_Name FROM company_codes WHERE CoCd");
	String sql = "";
	if(condition.equalsIgnoreCase("singleValue"))
	sql = "SELECT CoCd,Company_Name FROM company_codes WHERE CoCd = "+comCode;	
	//sql.append(" = ? ") ;
	if(condition.equalsIgnoreCase("geOrEqualTo"))
		sql = "SELECT CoCd,Company_Name FROM company_codes WHERE CoCd >= "+comCode;	
		//sql.append(" >= ? ") ;
	if(condition.equalsIgnoreCase("leOrEqualTo"))
		sql = "SELECT CoCd,Company_Name FROM company_codes WHERE CoCd <= "+comCode;	
		//sql.append(" <= ? ") ;
	if(condition.equalsIgnoreCase("greaterThan"))
		sql = "SELECT CoCd,Company_Name FROM company_codes WHERE CoCd > "+comCode;
		//sql.append(" > ? ") ;
	if(condition.equalsIgnoreCase("lessThan"))
		sql = "SELECT CoCd,Company_Name FROM company_codes WHERE CoCd < "+comCode;
		//sql.append(" < ? ") ;
	if(condition.equalsIgnoreCase("notEqualTo"))
		sql = "SELECT CoCd,Company_Name FROM company_codes WHERE CoCd != "+comCode;
		//sql.append(" != ? ") ;
	connect();
	Statement statement = jdbcConnection.createStatement();
	//PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
	//statement.setString(1, comCode);
	ResultSet resultSet = statement.executeQuery(sql);
	String idCompName = "";
	while (resultSet.next()) {
		String coCd = resultSet.getString("CoCd");
		String compName = resultSet.getString("Company_Name");
		idCompName = coCd+"-"+compName;
		hmp.put(coCd, idCompName);
	}
	
	resultSet.close();
	statement.close();
	return hmp;
	}
	
	public Map<String, String> getSalesOrgCodeAndMap(String condition,String salesOrgId) throws SQLException
	{
		
	Map<String, String> hmp = new LinkedHashMap<String, String>();
	//StringBuilder sql = new StringBuilder("SELECT CoCd,Company_Name FROM company_codes WHERE CoCd");
	String sql = "";
	if(condition.equalsIgnoreCase("singleValue"))
	sql = "SELECT SOrg,Name FROM sales_organization WHERE SOrg = "+salesOrgId;	
	//sql.append(" = ? ") ;
	if(condition.equalsIgnoreCase("geOrEqualTo"))
		sql = "SELECT SOrg,Name FROM sales_organization WHERE SOrg >= "+salesOrgId;	
		//sql.append(" >= ? ") ;
	if(condition.equalsIgnoreCase("leOrEqualTo"))
		sql = "SELECT SOrg,Name FROM sales_organization WHERE SOrg <= "+salesOrgId;	
		//sql.append(" <= ? ") ;
	if(condition.equalsIgnoreCase("greaterThan"))
		sql = "SELECT SOrg,Name FROM sales_organization WHERE SOrg > "+salesOrgId;
		//sql.append(" > ? ") ;
	if(condition.equalsIgnoreCase("lessThan"))
		sql = "SELECT SOrg,Name FROM sales_organization WHERE SOrg < "+salesOrgId;
		//sql.append(" < ? ") ;
	if(condition.equalsIgnoreCase("notEqualTo"))
		sql = "SELECT SOrg,Name FROM sales_organization WHERE SOrg != "+salesOrgId;
		//sql.append(" != ? ") ;
	connect();
	Statement statement = jdbcConnection.createStatement();
	//PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
	//statement.setString(1, comCode);
	ResultSet resultSet = statement.executeQuery(sql);
	String idSorg = "";
	while (resultSet.next()) {
		String SOrg = resultSet.getString("SOrg");
		String Name = resultSet.getString("Name");
		idSorg = SOrg+"-"+Name;
		hmp.put(SOrg, idSorg);
	}
	
	resultSet.close();
	statement.close();
	return hmp;
	}
	
	
	
	
	
	
	public Map<String, String> getRgnNameAndCode(String condition,String rgnCode) throws SQLException
	{
		
	Map<String, String> hmp = new LinkedHashMap<String, String>();
	//StringBuilder sql = new StringBuilder("SELECT CoCd,Company_Name FROM company_codes WHERE CoCd");
	String sql = "";
	if(condition.equalsIgnoreCase("singleValue"))
	sql = "SELECT Rg,Description FROM region WHERE Rg = "+rgnCode;	
	//sql.append(" = ? ") ;
	if(condition.equalsIgnoreCase("geOrEqualTo"))
		sql = "SELECT Rg,Description FROM region WHERE Rg = "+rgnCode;	
		//sql.append(" >= ? ") ;
	if(condition.equalsIgnoreCase("leOrEqualTo"))
		sql = "SELECT Rg,Description FROM region WHERE Rg <= "+rgnCode;	
		//sql.append(" <= ? ") ;
	if(condition.equalsIgnoreCase("greaterThan"))
		sql = "SELECT Rg,Description FROM region WHERE Rg > "+rgnCode;
		//sql.append(" > ? ") ;
	if(condition.equalsIgnoreCase("lessThan"))
		sql = "SELECT Rg,Description FROM region WHERE Rg < "+rgnCode;
		//sql.append(" < ? ") ;
	if(condition.equalsIgnoreCase("notEqualTo"))
		sql = "SELECT Rg,Description FROM region WHERE Rg != "+rgnCode;
		//sql.append(" != ? ") ;
	connect();
	Statement statement = jdbcConnection.createStatement();
	//PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
	//statement.setString(1, comCode);
	ResultSet resultSet = statement.executeQuery(sql);
	String idRgnName = "";
	while (resultSet.next()) {
		String rg = resultSet.getString("Rg");
		String description = resultSet.getString("Description");
		idRgnName = rg+"-"+description;
		hmp.put(rg, idRgnName);
	}
	
	resultSet.close();
	statement.close();
	return hmp;
	}
	
	
	
	public Map<String, String> getDisbnChnlNameAndCode(String condition,String dchlCode) throws SQLException
	{
		
	Map<String, String> hmp = new LinkedHashMap<String, String>();
	//StringBuilder sql = new StringBuilder("SELECT CoCd,Company_Name FROM company_codes WHERE CoCd");
	String sql = "";
	if(condition.equalsIgnoreCase("singleValue"))
	sql = "SELECT DChl,Name FROM distribution_channel WHERE DChl = "+dchlCode;	
	//sql.append(" = ? ") ;
	if(condition.equalsIgnoreCase("geOrEqualTo"))
		sql = "SELECT DChl,Name FROM distribution_channel WHERE DChl >= "+dchlCode;	
		//sql.append(" >= ? ") ;
	if(condition.equalsIgnoreCase("leOrEqualTo"))
		sql = "SELECT DChl,Name FROM distribution_channel WHERE DChl <= "+dchlCode;	
		//sql.append(" <= ? ") ;
	if(condition.equalsIgnoreCase("greaterThan"))
		sql = "SELECT DChl,Name FROM distribution_channel WHERE DChl > "+dchlCode;
		//sql.append(" > ? ") ;
	if(condition.equalsIgnoreCase("lessThan"))
		sql = "SELECT DChl,Name FROM distribution_channel WHERE DChl < "+dchlCode;
		//sql.append(" < ? ") ;
	if(condition.equalsIgnoreCase("notEqualTo"))
		sql = "SELECT DChl,Name FROM distribution_channel WHERE DChl != "+dchlCode;
		//sql.append(" != ? ") ;
	connect();
	Statement statement = jdbcConnection.createStatement();
	//PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
	//statement.setString(1, comCode);
	ResultSet resultSet = statement.executeQuery(sql);
	String idDChlName = "";
	while (resultSet.next()) {
		String dchl = resultSet.getString("DChl");
		String name = resultSet.getString("Name");
		idDChlName = dchl+"-"+name;
		hmp.put(dchl, idDChlName);
	}
	
	resultSet.close();
	statement.close();
	return hmp;
	}
	
	
	
	
	public Map<String, String> getSalesDistNameAndCode(String condition,String ditrCode) throws SQLException
	{
		
	Map<String, String> hmp = new LinkedHashMap<String, String>();
	//StringBuilder sql = new StringBuilder("SELECT CoCd,Company_Name FROM company_codes WHERE CoCd");
	String sql = "";
	if(condition.equalsIgnoreCase("singleValue"))
	sql = "SELECT SDst_id,District_Name FROM sales_district WHERE SDst_id = "+ditrCode;	
	//sql.append(" = ? ") ;
	if(condition.equalsIgnoreCase("geOrEqualTo"))
		sql = "SELECT SDst_id,District_Name FROM sales_district WHERE SDst_id >= "+ditrCode;	
		//sql.append(" >= ? ") ;
	if(condition.equalsIgnoreCase("leOrEqualTo"))
		sql = "SELECT SDst_id,District_Name FROM sales_district WHERE SDst_id <= "+ditrCode;	
		//sql.append(" <= ? ") ;
	if(condition.equalsIgnoreCase("greaterThan"))
		sql = "SELECT SDst_id,District_Name FROM sales_district WHERE SDst_id > "+ditrCode;
		//sql.append(" > ? ") ;
	if(condition.equalsIgnoreCase("lessThan"))
		sql = "SELECT SDst_id,District_Name FROM sales_district WHERE SDst_id < "+ditrCode;
		//sql.append(" < ? ") ;
	if(condition.equalsIgnoreCase("notEqualTo"))
		sql = "SELECT SDst_id,District_Name FROM sales_district WHERE SDst_id != "+ditrCode;
		//sql.append(" != ? ") ;
	connect();
	Statement statement = jdbcConnection.createStatement();
	//PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
	//statement.setString(1, comCode);
	ResultSet resultSet = statement.executeQuery(sql);
	String idsDstIdName = "";
	while (resultSet.next()) {
		String sDstId = resultSet.getString("SDst_id");
		String districtName = resultSet.getString("District_Name");
		idsDstIdName = sDstId+"-"+districtName;
		hmp.put(sDstId, idsDstIdName);
	}
	
	resultSet.close();
	statement.close();
	return hmp;
	}
	
	public Map<String, String> getDivNameAndCode(String condition,String divCode) throws SQLException
	{
		
	Map<String, String> hmp = new LinkedHashMap<String, String>();
	//StringBuilder sql = new StringBuilder("SELECT CoCd,Company_Name FROM company_codes WHERE CoCd");
	String sql = "";
	if(condition.equalsIgnoreCase("singleValue"))
	sql = "SELECT Dv,Name FROM division WHERE Dv = "+divCode;	
	//sql.append(" = ? ") ;
	if(condition.equalsIgnoreCase("geOrEqualTo"))
		sql = "SELECT Dv,Name FROM division WHERE Dv >= "+divCode;	
		//sql.append(" >= ? ") ;
	if(condition.equalsIgnoreCase("leOrEqualTo"))
		sql = "SELECT Dv,Name FROM division WHERE Dv <= "+divCode;	
		//sql.append(" <= ? ") ;
	if(condition.equalsIgnoreCase("greaterThan"))
		sql = "SELECT Dv,Name FROM division WHERE Dv > "+divCode;
		//sql.append(" > ? ") ;
	if(condition.equalsIgnoreCase("lessThan"))
		sql = "SELECT Dv,Name FROM division WHERE Dv < "+divCode;
		//sql.append(" < ? ") ;
	if(condition.equalsIgnoreCase("notEqualTo"))
		sql = "SELECT Dv,Name FROM division WHERE Dv != "+divCode;
		//sql.append(" != ? ") ;
	connect();
	Statement statement = jdbcConnection.createStatement();
	//PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
	//statement.setString(1, comCode);
	ResultSet resultSet = statement.executeQuery(sql);
	String idsDvName = "";
	while (resultSet.next()) {
		String dv = resultSet.getString("Dv");
		String name = resultSet.getString("Name");
		idsDvName = dv+"-"+name;
		hmp.put(dv, idsDvName);
	}
	
	resultSet.close();
	statement.close();
	return hmp;
	}
	
	public Map<String, String> getCountryNameAndCode(String condition,String countryCode) throws SQLException
	{
		
	Map<String, String> hmp = new LinkedHashMap<String, String>();
	//StringBuilder sql = new StringBuilder("SELECT CoCd,Company_Name FROM company_codes WHERE CoCd");
	String sql = "";
	if(condition.equalsIgnoreCase("singleValue"))
	sql = "SELECT county_id,Description FROM county_code WHERE county_id = "+countryCode;	
	//sql.append(" = ? ") ;
	if(condition.equalsIgnoreCase("geOrEqualTo"))
		sql = "SELECT county_id,Description FROM county_code WHERE county_id >= "+countryCode;	
		//sql.append(" >= ? ") ;
	if(condition.equalsIgnoreCase("leOrEqualTo"))
		sql = "SELECT county_id,Description FROM county_code WHERE county_id <= "+countryCode;	
		//sql.append(" <= ? ") ;
	if(condition.equalsIgnoreCase("greaterThan"))
		sql = "SELECT county_id,Description FROM county_code WHERE county_id > "+countryCode;
		//sql.append(" > ? ") ;
	if(condition.equalsIgnoreCase("lessThan"))
		sql = "SELECT county_id,Description FROM county_code WHERE county_id < "+countryCode;
		//sql.append(" < ? ") ;
	if(condition.equalsIgnoreCase("notEqualTo"))
		sql = "SELECT county_id,Description FROM county_code WHERE county_id != "+countryCode;
		//sql.append(" != ? ") ;
	connect();
	Statement statement = jdbcConnection.createStatement();
	//PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
	//statement.setString(1, comCode);
	ResultSet resultSet = statement.executeQuery(sql);
	String idcountryName = "";
	while (resultSet.next()) {
		String countryId = resultSet.getString("county_id");
		String name = resultSet.getString("Description");
		idcountryName = countryId+"-"+name;
		hmp.put(countryId, idcountryName);
	}
	
	resultSet.close();
	statement.close();
	return hmp;
	}
	
	
	public Map<String, String> getBillingTypeNameAndCode(String condition,String billingtypCode) throws SQLException
	{
		
	Map<String, String> hmp = new LinkedHashMap<String, String>();
	//StringBuilder sql = new StringBuilder("SELECT CoCd,Company_Name FROM company_codes WHERE CoCd");
	String sql = "";
	if(condition.equalsIgnoreCase("singleValue"))
	sql = "SELECT BT_id,Description FROM billing_type WHERE BT_id = "+billingtypCode;	
	//sql.append(" = ? ") ;
	if(condition.equalsIgnoreCase("geOrEqualTo"))
		sql = "SELECT BT_id,Description FROM billing_type WHERE BT_id >= "+billingtypCode;	
		//sql.append(" >= ? ") ;
	if(condition.equalsIgnoreCase("leOrEqualTo"))
		sql = "SELECT BT_id,Description FROM billing_type WHERE BT_id <= "+billingtypCode;	
		//sql.append(" <= ? ") ;
	if(condition.equalsIgnoreCase("greaterThan"))
		sql = "SELECT BT_id,Description FROM billing_type WHERE BT_id > "+billingtypCode;
		//sql.append(" > ? ") ;
	if(condition.equalsIgnoreCase("lessThan"))
		sql = "SELECT BT_id,Description FROM billing_type WHERE BT_id < "+billingtypCode;
		//sql.append(" < ? ") ;
	if(condition.equalsIgnoreCase("notEqualTo"))
		sql = "SELECT BT_id,Description FROM billing_type WHERE BT_id != "+billingtypCode;
		//sql.append(" != ? ") ;
	connect();
	Statement statement = jdbcConnection.createStatement();
	//PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
	//statement.setString(1, comCode);
	ResultSet resultSet = statement.executeQuery(sql);
	String idBillTypName = "";
	while (resultSet.next()) {
		String btId = resultSet.getString("BT_id");
		String name = resultSet.getString("Description");
		idBillTypName = btId+"-"+name;
		hmp.put(btId, idBillTypName);
	}
	
	resultSet.close();
	statement.close();
	return hmp;
	}
	
	
	public Map<String, String> getcityNameAndCode(String condition,String cityCode) throws SQLException
	{
		
	Map<String, String> hmp = new LinkedHashMap<String, String>();
	//StringBuilder sql = new StringBuilder("SELECT CoCd,Company_Name FROM company_codes WHERE CoCd");
	String sql = "";
	if(condition.equalsIgnoreCase("singleValue"))
	sql = "SELECT city_id,Description FROM city_code WHERE city_id = "+cityCode;	
	//sql.append(" = ? ") ;
	if(condition.equalsIgnoreCase("geOrEqualTo"))
		sql = "SELECT city_id,Description FROM city_code WHERE city_id >= "+cityCode;	
		//sql.append(" >= ? ") ;
	if(condition.equalsIgnoreCase("leOrEqualTo"))
		sql = "SELECT city_id,Description FROM city_code WHERE city_id <= "+cityCode;	
		//sql.append(" <= ? ") ;
	if(condition.equalsIgnoreCase("greaterThan"))
		sql = "SELECT city_id,Description FROM city_code WHERE city_id > "+cityCode;
		//sql.append(" > ? ") ;
	if(condition.equalsIgnoreCase("lessThan"))
		sql = "SELECT city_id,Description FROM city_code WHERE city_id < "+cityCode;
		//sql.append(" < ? ") ;
	if(condition.equalsIgnoreCase("notEqualTo"))
		sql = "SELECT city_id,Description FROM city_code WHERE city_id != "+cityCode;
		//sql.append(" != ? ") ;
	connect();
	Statement statement = jdbcConnection.createStatement();
	//PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
	//statement.setString(1, comCode);
	ResultSet resultSet = statement.executeQuery(sql);
	String idCityNameCode = "";
	while (resultSet.next()) {
		String cityCod = resultSet.getString("city_id");
		String name = resultSet.getString("Description");
		idCityNameCode = cityCod+"-"+name;
		hmp.put(cityCod, idCityNameCode);
	}
	
	resultSet.close();
	statement.close();
	return hmp;
	}
	
	public Map<String, String> getCustomerGroupAndCode(String condition,String cgrpId) throws SQLException
	{
		
	Map<String, String> hmp = new LinkedHashMap<String, String>();
	//StringBuilder sql = new StringBuilder("SELECT CoCd,Company_Name FROM company_codes WHERE CoCd");
	String sql = "";
	if(condition.equalsIgnoreCase("singleValue"))
	sql = "SELECT Cgrp_id,Name FROM customer_group WHERE Cgrp_id = "+cgrpId;	
	//sql.append(" = ? ") ;
	if(condition.equalsIgnoreCase("geOrEqualTo"))
		sql = "SELECT Cgrp_id,Name FROM customer_group WHERE Cgrp_id >= "+cgrpId;	
		//sql.append(" >= ? ") ;
	if(condition.equalsIgnoreCase("leOrEqualTo"))
		sql = "SELECT Cgrp_id,Name FROM customer_group WHERE Cgrp_id <= "+cgrpId;	
		//sql.append(" <= ? ") ;
	if(condition.equalsIgnoreCase("greaterThan"))
		sql = "SELECT Cgrp_id,Name FROM customer_group WHERE Cgrp_id > "+cgrpId;
		//sql.append(" > ? ") ;
	if(condition.equalsIgnoreCase("lessThan"))
		sql = "SELECT Cgrp_id,Name FROM customer_group WHERE Cgrp_id < "+cgrpId;
		//sql.append(" < ? ") ;
	if(condition.equalsIgnoreCase("notEqualTo"))
		sql = "SELECT Cgrp_id,Name FROM customer_group WHERE Cgrp_id != "+cgrpId;
		//sql.append(" != ? ") ;
	connect();
	Statement statement = jdbcConnection.createStatement();
	//PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
	//statement.setString(1, comCode);
	ResultSet resultSet = statement.executeQuery(sql);
	String idGrpName = "";
	while (resultSet.next()) {
		String grpId = resultSet.getString("Cgrp_id");
		String name = resultSet.getString("Name");
		idGrpName = grpId+"-"+name;
		hmp.put(grpId, idGrpName);
	}
	
	resultSet.close();
	statement.close();
	return hmp;
	}
	
	public Map<String, String> getCustomerAndCode(String condition,String cstmId) throws SQLException
	{
		
	Map<String, String> hmp = new LinkedHashMap<String, String>();
	//StringBuilder sql = new StringBuilder("SELECT CoCd,Company_Name FROM company_codes WHERE CoCd");
	String sql = "";
	if(condition.equalsIgnoreCase("singleValue"))
	sql = "SELECT customer_id,Name1 FROM customer WHERE customer_id = "+cstmId;	
	//sql.append(" = ? ") ;
	if(condition.equalsIgnoreCase("geOrEqualTo"))
		sql = "SELECT customer_id,Name1 FROM customer WHERE customer_id >= "+cstmId;	
		//sql.append(" >= ? ") ;
	if(condition.equalsIgnoreCase("leOrEqualTo"))
		sql = "SELECT customer_id,Name1 FROM customer WHERE customer_id <= "+cstmId;	
		//sql.append(" <= ? ") ;
	if(condition.equalsIgnoreCase("greaterThan"))
		sql = "SELECT customer_id,Name1 FROM customer WHERE customer_id > "+cstmId;
		//sql.append(" > ? ") ;
	if(condition.equalsIgnoreCase("lessThan"))
		sql = "SELECT customer_id,Name1 FROM customer WHERE customer_id < "+cstmId;
		//sql.append(" < ? ") ;
	if(condition.equalsIgnoreCase("notEqualTo"))
		sql = "SELECT customer_id,Name1 FROM customer WHERE customer_id != "+cstmId;
		//sql.append(" != ? ") ;
	connect();
	Statement statement = jdbcConnection.createStatement();
	//PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
	//statement.setString(1, comCode);
	ResultSet resultSet = statement.executeQuery(sql);
	String idCstmName = "";
	while (resultSet.next()) {
		String customerId = resultSet.getString("customer_id");
		String name = resultSet.getString("Name1");
		idCstmName = customerId+"-"+name;
		hmp.put(customerId, idCstmName);
	}
	
	resultSet.close();
	statement.close();
	return hmp;
	}
	
	//plant
	public Map<String, String> getPlantAndCode(String condition,String plantId) throws SQLException
	{
		
	Map<String, String> hmp = new LinkedHashMap<String, String>();
	//StringBuilder sql = new StringBuilder("SELECT CoCd,Company_Name FROM company_codes WHERE CoCd");
	String sql = "";
	if(condition.equalsIgnoreCase("singleValue"))
	sql = "SELECT plant_id,Name1 FROM plant WHERE plant_id = "+plantId;	
	//sql.append(" = ? ") ;
	if(condition.equalsIgnoreCase("geOrEqualTo"))
		sql = "SELECT plant_id,Name1 FROM plant WHERE plant_id >= "+plantId;	
		//sql.append(" >= ? ") ;
	if(condition.equalsIgnoreCase("leOrEqualTo"))
		sql = "SELECT plant_id,Name1 FROM plant WHERE plant_id <= "+plantId;	
		//sql.append(" <= ? ") ;
	if(condition.equalsIgnoreCase("greaterThan"))
		sql = "SELECT plant_id,Name1 FROM plant WHERE plant_id > "+plantId;
		//sql.append(" > ? ") ;
	if(condition.equalsIgnoreCase("lessThan"))
		sql = "SELECT plant_id,Name1 FROM plant WHERE plant_id < "+plantId;
		//sql.append(" < ? ") ;
	if(condition.equalsIgnoreCase("notEqualTo"))
		sql = "SELECT plant_id,Name1 FROM plant WHERE plant_id != "+plantId;
		//sql.append(" != ? ") ;
	connect();
	Statement statement = jdbcConnection.createStatement();
	//PreparedStatement statement = jdbcConnection.prepareStatement(sql.toString());
	//statement.setString(1, comCode);
	ResultSet resultSet = statement.executeQuery(sql);
	String idCstmName = "";
	while (resultSet.next()) {
		String customerId = resultSet.getString("customer_id");
		String name = resultSet.getString("Name1");
		idCstmName = customerId+"-"+name;
		hmp.put(customerId, idCstmName);
	}
	
	resultSet.close();
	statement.close();
	return hmp;
	}
     /*schem saving*/
	//CEMSTTN1TRSSRBCD082018001	
	/*Division/Region/StateCode/Distributionchannel/SchemeCategory/SchemeType/Period/Year/RunningSlNo.*/			
	public void saveSchemes(Scheme schem) throws SQLException  {
		connect();
		String str="";
		String query1 = "select scheme_No from qd_definition_header order by QD_Definition_Header_ID desc limit 1";
        List<Object[]> list1 = jdbc.executeSelectQuery(query1);                
        Object[] obj1 = list1.get(0);
        //parametersMap.put("schemeNumber", obj1[0]);
        if(obj1[0]!=null)  
        str = obj1[0].toString();
        
        int value = 0;
        String orderNoQuery = "select distinct Order_No from qd_definition_header";
        List<Object[]> orderList = jdbc.executeSelectQuery(orderNoQuery);
        System.out.println("orderno ----"+schem.getOrderNo());
        System.out.println("size = "+orderList.size());
        outerloop:
        for (Object[] orderList1 : orderList) {
            for (Object orderList11 : orderList1) {
                if(orderList11.equals(schem.getOrderNo())){
                    System.out.println("At 116-----");
                    value = Integer.valueOf(str)+1;
                    break outerloop;
                } else {
                    System.out.println("At 119------");
                    value = 1;
                }
            }
        }       
        
        
        String query = "Insert into qd_definition_header (Company_Code,Scheme_Category,Scheme_Type,From_Date,To_Date,Order_No,Active,Exclude_CST_Sale,"
                + "Sales_Org,Distrbution_Channel,Division,Billing_Type,Sales_Office,Sales_Group,Plant,"
                + "Region,Sales_District,City_Code,Customer_Group,Customer,Shipping_Cond,"
                + "Material_Group,Material,Scheme_No,Approve_Status,Created_By,Created_On) values "
                + "('"+schem.getCompanyCode()+"','"+schem.getSchemeCategory()+"','"+schem.getSchemeType()+"','"
                + schem.getFromDate()+"','"+schem.getToDate()+"','"+schem.getOrderNo()+"','"
                + schem.getActive()+"','"+schem.getExcludeCstSale()+"','"+schem.getSalesOrg()+"','"
                + schem.getDistributionChannel()+"','"+schem.getDivision()+"','"+schem.getBillingType()+"','"
                + schem.getSalesOffice()+"','"+schem.getSalesGroup()+"','"+schem.getPlant()+"','"
                + schem.getCustomerRegion()+"','"+schem.getSalesDistrict()+"','"+schem.getCityCode()+"','"
                + schem.getCustomerGroup()+"','"+schem.getCustomer()+"','"+schem.getShippingCond()+"','"
                + schem.getMaterialGroup()+"','"+schem.getMaterial()+"','"                
                + "RBQDN-000"+value+"','Pending','"+"statehead"+"','"+DateUtilsClass.getCurrentDate()+"')";
        System.out.println("query = " + query);
        jdbc.executeUpdateQuery(query); 
        String qdHeaderID = "";
        JDBCConnection jdbc = new JDBCConnection();
        String query2 = "select QD_Definition_Header_ID,Scheme_No from qd_definition_header order by `QD_Definition_Header_ID` desc limit 1";
        List<Object[]> list = jdbc.executeSelectQuery(query2);                
        Object[] obj = list.get(0);
        if(obj[1]!=null)
        schem.setSchemeNo(obj[1].toString());
        if(obj[0]!=null)
        	qdHeaderID = obj[0].toString();
        //parametersMap.put("qdHeaderID", obj[0]);
        insertIntoDetailTable(schem,qdHeaderID);
        loaddataFromExcel(schem);
        
    }
	
	private void insertIntoDetailTable(Scheme schem,String qdHeaderID){
		try{
        String insertQuery = "insert into qd_definition_header_detail (Header_ID,Scheme_No,Company_Code,Sales_Org,Distribution_Channel,"
            + "Division,Sales_Office,Sales_Group,Sales_District,Region,City_Code,City,Customer,Customer_Group,"
            + "Material,Material_Group,Plant,Shipping_Cond,Billing_Type) "
            + "values ('"+qdHeaderID+"','"+schem.getSchemeNo()+"','"+schem.getCompanyCode()+"','"
            + schem.getSalesOrg()+"','"+ schem.getDistributionChannel()+"','"+schem.getDivision()+"','"
            + schem.getSalesOffice()+"','"+schem.getSalesGroup()+"','"+schem.getSalesDistrict()+"','"
            + schem.getCustomerRegion()+"','"+schem.getCityCode()+"','"+schem.getCity()+"','"
            + schem.getCustomer()+"','"+ schem.getCustomerGroup()+"','"+schem.getMaterial()+"','"
            + schem.getMaterialGroup()+"','"+schem.getPlant()+"','"+ schem.getShippingConditions()+"','"+ schem.getBillingType()+"')";
        
        System.out.println("insertQuery = " + insertQuery);
        jdbc.executeUpdateQuery(insertQuery);
		}
		catch(Exception e)
		{
			//logger.erro;
		}
		
}
	
	private void loaddataFromExcel(Scheme schem) {
		if(schem.isExlUplodedForSlab()){
        FileInputStream input = null;
    try {
        File file = new File("C:/Users/brajmohan.jha/Desktop/NOWDEMO/Rebate_Slab_Grid.xlsx");
        input = new FileInputStream("Rebate_Slab_Grid.xlsx");
        OPCPackage pkg = OPCPackage.open(file.getName());
        XSSFWorkbook wb = new XSSFWorkbook(pkg);
        XSSFSheet sheet = wb.getSheetAt(0);
        Row row;
        for(int i=1; i<=sheet.getLastRowNum(); i++){
            row = sheet.getRow(i);
            double sNo = row.getCell(0).getNumericCellValue();
            double from = row.getCell(1).getNumericCellValue();
            double to = row.getCell(2).getNumericCellValue();
            double rateFrom = row.getCell(3).getNumericCellValue();
            double keyCurr = row.getCell(4).getNumericCellValue();
            double baseFrom = row.getCell(5).getNumericCellValue();
            insertIntoDefItemTableFromFile(schem,sNo,from,to,rateFrom,keyCurr,baseFrom);
        }
    } catch(FileNotFoundException | InvalidFormatException ex){
        Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
    }catch (IOException | NumberFormatException ex ) {
        Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            input.close();
        } catch (IOException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
		}
		int i=1;
		for(Slab slab :schem.getSlabList()){
           // row = sheet.getRow(i);
            double sNo = i;
            double from = slab.getSlbFromValue();
            double to = slab.getSlbToValue();
            double rateFrom = slab.getSlabRate();
            double keyCurr = slab.getKeyCurr();
            double baseFrom = slab.getBaseFrom();
            insertIntoDefItemTableFromFile(schem,sNo,from,to,rateFrom,keyCurr,baseFrom);
        }
}
	
	
	private void insertIntoDefItemTableFromFile(Scheme schem,Double sNo, Double from, Double to, Double rateFrom, Double keyCurr, double baseFrom){
		try {
        String insertQuery = "insert into qd_definition_item (Scheme_Type,Order_Number,Scheme_No,Region,Sales_District,Customer_Number,"
                + "SNo,From_Value,To_Value,Rate_From,Key1_Curr,Base1_From)"
            + " values ('"+schem.getSchemeType()+"','"+schem.getOrderNo()+"','"+schem.getSchemeNo()+"','"
            + schem.getCustomerRegion()+"','"+ schem.getSalesDistrict()+"','"+schem.getCustomer()+"',"+sNo+","+from+","+to+","+rateFrom+","+keyCurr+","+baseFrom+")";
        
        System.out.println("insertQuery =136 " + insertQuery);
    
		jdbc.executeUpdateQuery(insertQuery);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
}    
/*end scheme save*/
    
	
}
	
	
