package com.dalmia.dce.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalmia.dce.dao.ShemCreationDetailDao;
import com.dalmia.dce.vo.SalesOrganizationVO;


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
}
