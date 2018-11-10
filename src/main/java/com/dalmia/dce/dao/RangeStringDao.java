package com.dalmia.dce.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dalmia.dce.vo.SalesOrganizationVO;

@Repository
public class RangeStringDao {

	@Autowired
	DataSource dataSource;

public Map<String, String> getRange(String sch_key,String pfrom,String pto) throws SQLException {
		
		Connection jdbcConnection = dataSource.getConnection();
		Map<String,String> map = new HashMap<String,String>();
		String sql = "SELECT sch_key, table_name, field_name FROM string_keys where sch_key='"+sch_key+"'";
		System.out.println(sql);
		//connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		Statement statement1 = jdbcConnection.createStatement();
		
		
		if (resultSet.next()) {
			
			String table_name = resultSet.getString("table_name");
			String field_name =  resultSet.getString("field_name");
			String sql1="SELECT "+ field_name +" FROM  "+table_name+" WHERE  "+field_name+" BETWEEN '"+pfrom+"' AND  '"+pto+"'";
			System.out.println(sql1);
			ResultSet resultSet1 = statement.executeQuery(sql);
			while (resultSet1.next()) {
			map.put(resultSet1.getString(field_name), sch_key);	
			}
			
		}
		
		resultSet.close();
		statement.close();
		statement1.close();
		//disconnect();
		jdbcConnection.close();
		return map;
	}

	
}
