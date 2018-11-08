package com.dalmia.dce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalmia.dce.entities.SchemeHeader;
import com.dalmia.dce.entities.SchemeHeaderCond;
import com.dalmia.dce.entities.SchemeHeaderDetail;
import com.dalmia.dce.repositories.SchemeHeaderRepository;
import com.dalmia.dce.vo.SchemeHeaderCondVO;
import com.dalmia.dce.vo.SchemeHeaderDetailVO;
import com.dalmia.dce.vo.SchemeHeaderVO;
import com.dalmia.dce.vo.StatusVO;

@Service	
public class SchemeHeaderServiceImpl implements SchemeHeaderService{

	
	@Autowired
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
	@Override
	public StatusVO saveSchemeHeader(SchemeHeaderVO shVO) {
		SchemeHeader sh=new SchemeHeader();
		SchemeHeaderDetail shd=new SchemeHeaderDetail();
		SchemeHeaderCond shc=new SchemeHeaderCond();
		
		List <SchemeHeaderDetail> lshd=new ArrayList<SchemeHeaderDetail>();
		List <SchemeHeaderCond> lshc=new ArrayList<SchemeHeaderCond>();
		
		sh.setSalesDocType(shVO.getSalesDocType());
		
		sh.setActive(shVO.getActive());
		sh.setSchemNumb(shVO.getSchemNumb());
		sh.setFromDate(shVO.getFromDate());
		sh.setToDate(shVO.getToDate());
		sh.setApproveStatus(shVO.getApproveStatus());
		sh.setBudgetReferenceNo(shVO.getBudgetReferenceNo());
		sh.setBuisnessArea(shVO.getBuisnessArea());
		sh.setBusinessPlace(shVO.getBusinessPlace());
		sh.setCostCenter(shVO.getCostCenter());
		sh.setCreatedBy(shVO.getCreatedBy());
		sh.setCreatedOn(shVO.getCreatedOn());
		sh.setExclusiveCSTSale(shVO.getExclusiveCSTSale());
		//sh.setFromDate(shVO.getFromDate());
		sh.setGlAccount(shVO.getGlAccount());
		sh.setOrderNo(shVO.getOrderNo());
		sh.setPrevfromDate(shVO.getPrevfromDate());
		sh.setPrevToDate(shVO.getPrevToDate());
		sh.setPriceList(shVO.getPriceList());
						
		for (SchemeHeaderDetailVO obj_src : shVO.getSchemeHeaderDetail()) {
			SchemeHeaderDetail obj_tar = new SchemeHeaderDetail();
			BeanUtils.copyProperties(obj_src, obj_tar);
			lshd.add(obj_tar);
		}
		
		for (SchemeHeaderCondVO obj_src : shVO.getSchemeHeaderCond()) {
			SchemeHeaderCond obj_tar = new SchemeHeaderCond();
			BeanUtils.copyProperties(obj_src, obj_tar);
			lshc.add(obj_tar);
		}
		
		sh.setSchemeHeaderDetail(lshd);
		sh.setSchemeHeaderCond(lshc);

		schemeHeaderRepository.save(sh);
		 StatusVO status=new StatusVO();
		 status.setCode("200");
		 status.setMessage("Successfully");
		 status.setStatus("Success");
		return status;
	}
}
