package com.dalmia.dce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dalmia.dce.entities.SchemeHeader;
import com.dalmia.dce.repositories.SchemeHeaderRepository;
import com.dalmia.dce.vo.SchemeHeaderVO;

@Service	
public class SchemeHeaderServiceImpl implements SchemeHeaderService{

	SchemeHeaderRepository schemeHeaderRepository;
	@Override
	public List<SchemeHeader> getSchemeHeader(SchemeHeaderVO schemeHeaderVO) {
		return schemeHeaderRepository.findAll();
	}
	/*public List<SchemeHeader> getSchemeHeaderById(SchemeHeaderVO schemeHeaderVO) {
		return schemeHeaderRepository.findById();
	}*/
	
}
