/*package com.dalmia.dce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.dalmia.dce.entities.SchemeHeader;
import com.dalmia.dce.repositories.SchemeHeaderRepository;
import com.dalmia.dce.vo.SchemeHeaderVO;

@Service	
public class SchemeHeaderServiceImpl implements SchemeHeaderService{

	SchemeHeaderRepository schemeHeaderRepository;
	@Override
	public List<SchemeHeaderVO> getSchemeHeader() {
	List<SchemeHeader> lsh=	schemeHeaderRepository.findAll();
	List<SchemeHeaderVO> lshvo= new ArrayList<SchemeHeaderVO>();
	for (SchemeHeader objsrc : lsh) {
		SchemeHeaderVO objtar = new SchemeHeaderVO();
		BeanUtils.copyProperties(objsrc, objtar);
		lshvo.add(objtar);
	}
		return lshvo;
	}
	public List<SchemeHeader> getSchemeHeaderById(SchemeHeaderVO schemeHeaderVO) {
		return schemeHeaderRepository.findById();
	}
	
}
*/