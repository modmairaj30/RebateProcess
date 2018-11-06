package com.dalmia.dce.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalmia.dce.dao.ShemCreationDetailDao;
import com.dalmia.dce.vo.CompanyCodesVO;
import com.dalmia.dce.vo.SalesDistrictVO;
import com.dalmia.dce.vo.SalesOrganizationVO;
import com.dalmia.dce.vo.SchemeUniverseVO;


@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class NewSchemeCreationController {
	@Autowired
	ShemCreationDetailDao schemcreationDetaiDao;
	@GetMapping(value = "/getSchemeMetadata")
    public Map<String, SalesOrganizationVO> getAllSchemes() {
        try {
			return  schemcreationDetaiDao.getSalesOrg();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getSalesDistrict")
    public Map<String, SalesDistrictVO> getSalesDistrict() {
        try {
			return  schemcreationDetaiDao.getSalesDistrict();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getComp")
    public Map<String, CompanyCodesVO> getComp() {
        try {
			return  schemcreationDetaiDao.getComp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	@GetMapping(value = "/getSchemUnverse")
    public Map<String, SchemeUniverseVO> getSchemUnverse() {
        try {
			return  schemcreationDetaiDao.getSchemUnverse();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
}
