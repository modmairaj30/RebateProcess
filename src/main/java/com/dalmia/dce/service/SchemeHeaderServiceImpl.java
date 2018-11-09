package com.dalmia.dce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalmia.dce.entities.SchemeHeader;
import com.dalmia.dce.entities.SchemeHeaderCond;
import com.dalmia.dce.entities.SchemeHeaderDetail;
import com.dalmia.dce.repositories.SchemeHeaderRepository;
import com.dalmia.dce.utilities.RangeCalculationUtil;
import com.dalmia.dce.utilities.RangeObject;
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
		sh.setApproveStatus(shVO.getActive());
		sh.setBudgetReferenceNo(shVO.getBudgetReferenceNo());
		sh.setBusinessPlace(shVO.getBusinessPlace());
		sh.setCreatedBy(shVO.getCreatedBy());
		sh.setCreatedOn(shVO.getCreatedOn());
		sh.setExclusiveCSTSale(shVO.getExclusiveCSTSale());
		//sh.setFromDate(shVO.getFromDate());
		sh.setOrderNo(shVO.getOrderNo());
		sh.setPrevfromDate(shVO.getPrevfromDate());
		sh.setPrevToDate(shVO.getPrevToDate());
		sh.setPriceList(shVO.getPriceList());
								
			RangeObject rangeObj= new RangeObject();
			
			if(shVO.getCompanyCode()!=null) {
			rangeObj.setProperty(shVO.getCompanyCode().getSchKeyName());
			rangeObj.setType(shVO.getCompanyCode().getType());
			rangeObj.setRange(shVO.getCompanyCode().getRange());
			rangeObj.setValues(shVO.getCompanyCode().getValues());
			rangeObj.setExcludeValues(shVO.getCompanyCode().getExcludeValues());
			Map<String,String> compCodeMap = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : compCodeMap.keySet()) 
			{ 				 
				String sch_key = compCodeMap.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			} 
			}
			if(shVO.getSalesOrg()!=null) {
			rangeObj.setProperty(shVO.getSalesOrg().getSchKeyName());
			rangeObj.setType(shVO.getSalesOrg().getType());
			rangeObj.setRange(shVO.getSalesOrg().getRange());
			rangeObj.setValues(shVO.getSalesOrg().getValues());
			rangeObj.setExcludeValues(shVO.getSalesOrg().getExcludeValues());
			Map<String,String> salesOrgMap = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : salesOrgMap.keySet()) 
			{ 				 
				String sch_key = salesOrgMap.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			} 
			}
			
			if(shVO.getDistributionChannel()!=null) {
			rangeObj.setProperty(shVO.getDistributionChannel().getSchKeyName());
			rangeObj.setType(shVO.getDistributionChannel().getType());
			rangeObj.setType(shVO.getDistributionChannel().getType());
			rangeObj.setRange(shVO.getDistributionChannel().getRange());
			rangeObj.setValues(shVO.getDistributionChannel().getValues());
			rangeObj.setExcludeValues(shVO.getDistributionChannel().getExcludeValues());
			Map<String,String> dbChMap = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : dbChMap.keySet()) 
			{ 				 
				String sch_key = dbChMap.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			} 
			}
			if(shVO.getDivision()!=null) {
			rangeObj.setProperty(shVO.getDivision().getSchKeyName());
			rangeObj.setType(shVO.getDivision().getType());
			rangeObj.setRange(shVO.getDivision().getRange());
			rangeObj.setValues(shVO.getDivision().getValues());
			rangeObj.setExcludeValues(shVO.getDivision().getExcludeValues());
			Map<String,String> getDivisionMap = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getDivisionMap.keySet()) 
			{ 				 
				String sch_key = getDivisionMap.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			} 
			}
			if(shVO.getSalseOffice()!=null) {
			rangeObj.setProperty(shVO.getSalseOffice().getSchKeyName());
			rangeObj.setType(shVO.getSalseOffice().getType());
			rangeObj.setRange(shVO.getSalseOffice().getRange());
			rangeObj.setValues(shVO.getSalseOffice().getValues());
			rangeObj.setExcludeValues(shVO.getSalseOffice().getExcludeValues());
			Map<String,String> getSalseOfficeMap = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getSalseOfficeMap.keySet()) 
			{ 				 
				String sch_key = getSalseOfficeMap.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			} 
			}
			if(shVO.getSalesGroup()!=null) {
			rangeObj.setProperty(shVO.getSalesGroup().getSchKeyName());
			rangeObj.setType(shVO.getSalesGroup().getType());
			rangeObj.setRange(shVO.getSalesGroup().getRange());
			rangeObj.setValues(shVO.getSalesGroup().getValues());
			rangeObj.setExcludeValues(shVO.getSalesGroup().getExcludeValues());
			Map<String,String> getSalesGroupMap = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getSalesGroupMap.keySet()) 
			{ 				 
				String sch_key = getSalesGroupMap.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			} 
			}
			if(shVO.getSalseDistrict()!=null) {
			rangeObj.setProperty(shVO.getSalseDistrict().getSchKeyName());
			rangeObj.setType(shVO.getSalseDistrict().getType());
			rangeObj.setRange(shVO.getSalseDistrict().getRange());
			rangeObj.setValues(shVO.getSalseDistrict().getValues());
			rangeObj.setExcludeValues(shVO.getSalseDistrict().getExcludeValues());
			Map<String,String> getSalseDistrict = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getSalseDistrict.keySet()) 
			{ 				 
				String sch_key = getSalseDistrict.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			} 
			}
			if(shVO.getRegion()!=null) {
			rangeObj.setProperty(shVO.getRegion().getSchKeyName());
			rangeObj.setType(shVO.getRegion().getType());
			rangeObj.setRange(shVO.getRegion().getRange());
			rangeObj.setValues(shVO.getRegion().getValues());
			rangeObj.setExcludeValues(shVO.getRegion().getExcludeValues());
			Map<String,String> getRegion = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getRegion.keySet()) 
			{ 				 
				String sch_key = getRegion.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			} 
			}
			if(shVO.getCountryCode()!=null) {
			rangeObj.setProperty(shVO.getCountryCode().getSchKeyName());
			rangeObj.setType(shVO.getCountryCode().getType());
			rangeObj.setRange(shVO.getCountryCode().getRange());
			rangeObj.setValues(shVO.getCountryCode().getValues());
			rangeObj.setExcludeValues(shVO.getCountryCode().getExcludeValues());
			Map<String,String> getCountryCode = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getCountryCode.keySet()) 
			{ 				 
				String sch_key = getCountryCode.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			} 
			}
			if(shVO.getCityCode()!=null) {
			rangeObj.setProperty(shVO.getCityCode().getSchKeyName());
			rangeObj.setType(shVO.getCityCode().getType());
			rangeObj.setRange(shVO.getCityCode().getRange());
			rangeObj.setValues(shVO.getCityCode().getValues());
			rangeObj.setExcludeValues(shVO.getCityCode().getExcludeValues());
			Map<String,String> getCityCode = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getCityCode.keySet()) 
			{ 				 
				String sch_key = getCityCode.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			} 
			}
			if(shVO.getCustomer()!=null) {
			rangeObj.setProperty(shVO.getCustomer().getSchKeyName());
			rangeObj.setType(shVO.getCustomer().getType());
			rangeObj.setRange(shVO.getCustomer().getRange());
			rangeObj.setValues(shVO.getCustomer().getValues());
			rangeObj.setExcludeValues(shVO.getCustomer().getExcludeValues());
			Map<String,String> getCustomer = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getCustomer.keySet()) 
			{ 				 
				String sch_key = getCustomer.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			}
			}
			if(shVO.getCustomerGroup()!=null) {
			rangeObj.setProperty(shVO.getCustomerGroup().getSchKeyName());
			rangeObj.setType(shVO.getCustomerGroup().getType());
			rangeObj.setRange(shVO.getCustomerGroup().getRange());
			rangeObj.setValues(shVO.getCustomerGroup().getValues());
			rangeObj.setExcludeValues(shVO.getCustomerGroup().getExcludeValues());
			Map<String,String> getCustomerGroup = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getCustomerGroup.keySet()) 
			{ 				 
				String sch_key = getCustomerGroup.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			}
			}
			if(shVO.getMaterial()!=null) {	
			rangeObj.setProperty(shVO.getMaterial().getSchKeyName());
			rangeObj.setType(shVO.getMaterial().getType());
			rangeObj.setRange(shVO.getMaterial().getRange());
			rangeObj.setValues(shVO.getMaterial().getValues());
			rangeObj.setExcludeValues(shVO.getMaterial().getExcludeValues());
			Map<String,String> getMaterial = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getMaterial.keySet()) 
			{ 				 
				String sch_key = getMaterial.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			}
			}
			if(shVO.getMaterialGroup()!=null) {
			rangeObj.setProperty(shVO.getMaterialGroup().getSchKeyName());
			rangeObj.setType(shVO.getMaterialGroup().getType());
			rangeObj.setRange(shVO.getMaterialGroup().getRange());
			rangeObj.setValues(shVO.getMaterialGroup().getValues());
			rangeObj.setExcludeValues(shVO.getMaterialGroup().getExcludeValues());
			Map<String,String> getMaterialGroup = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getMaterialGroup.keySet()) 
			{ 				 
				String sch_key = getMaterialGroup.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			}
			}
			if(shVO.getPlant()!=null) {
			rangeObj.setProperty(shVO.getPlant().getSchKeyName());
			rangeObj.setType(shVO.getPlant().getType());
			rangeObj.setRange(shVO.getPlant().getRange());
			rangeObj.setValues(shVO.getPlant().getValues());
			rangeObj.setExcludeValues(shVO.getPlant().getExcludeValues());
			Map<String,String> getPlant = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getPlant.keySet()) 
			{ 				 
				String sch_key = getPlant.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			}
			}
			if(shVO.getPaymentMethod()!=null) {
			rangeObj.setProperty(shVO.getPaymentMethod().getSchKeyName());
			rangeObj.setType(shVO.getPaymentMethod().getType());
			rangeObj.setRange(shVO.getShippingCond().getRange());
			rangeObj.setValues(shVO.getShippingCond().getValues());
			rangeObj.setExcludeValues(shVO.getShippingCond().getExcludeValues());
			Map<String,String> getShippingCond = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getShippingCond.keySet()) 
			{ 				 
				String sch_key = getShippingCond.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			}
			}
			if(shVO.getPaymentMethod()!=null) {
			rangeObj.setProperty(shVO.getPaymentMethod().getSchKeyName());
			rangeObj.setType(shVO.getPaymentMethod().getType());
			rangeObj.setRange(shVO.getPaymentMethod().getRange());
			rangeObj.setValues(shVO.getPaymentMethod().getValues());
			rangeObj.setExcludeValues(shVO.getPaymentMethod().getExcludeValues());
			Map<String,String> getPaymentMethod = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getPaymentMethod.keySet()) 
			{ 				 
				String sch_key = getPaymentMethod.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			}
			}
			if(shVO.getBillingType()!=null) {
			rangeObj.setProperty(shVO.getBillingType().getSchKeyName());
			rangeObj.setType(shVO.getBillingType().getType());
			rangeObj.setRange(shVO.getBillingType().getRange());
			rangeObj.setValues(shVO.getBillingType().getValues());
			rangeObj.setExcludeValues(shVO.getBillingType().getExcludeValues());
			Map<String,String> getBillingType = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getBillingType.keySet()) 
			{ 				 
				String sch_key = getBillingType.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			}
			}
			if(shVO.getProfitCenter()!=null) {
			rangeObj.setProperty(shVO.getProfitCenter().getSchKeyName());
			rangeObj.setType(shVO.getProfitCenter().getType());
			rangeObj.setRange(shVO.getProfitCenter().getRange());
			rangeObj.setValues(shVO.getProfitCenter().getValues());
			rangeObj.setExcludeValues(shVO.getProfitCenter().getExcludeValues());
			Map<String,String> getProfitCenter = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getProfitCenter.keySet()) 
			{ 				 
				String sch_key = getProfitCenter.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			}
			}
			if(shVO.getCostCenter()!=null) {
			rangeObj.setProperty(shVO.getCostCenter().getSchKeyName());
			rangeObj.setType(shVO.getCostCenter().getType());
			rangeObj.setRange(shVO.getCostCenter().getRange());
			rangeObj.setValues(shVO.getCostCenter().getValues());
			rangeObj.setExcludeValues(shVO.getCostCenter().getExcludeValues());
			Map<String,String> getCostCenter = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getCostCenter.keySet()) 
			{ 				 
				String sch_key = getCostCenter.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			}
			}
			if(shVO.getBuisnessArea()!=null) {
			rangeObj.setProperty(shVO.getBuisnessArea().getSchKeyName());
			rangeObj.setType(shVO.getBuisnessArea().getType());
			rangeObj.setRange(shVO.getBuisnessArea().getRange());
			rangeObj.setValues(shVO.getBuisnessArea().getValues());
			rangeObj.setExcludeValues(shVO.getBuisnessArea().getExcludeValues());
			Map<String,String> getBuisnessArea = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (String sch_values : getBuisnessArea.keySet()) 
			{ 				 
				String sch_key = getBuisnessArea.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			}
			}
			
			
			/*rangeObj.setProperty(shVO.getGlAccount().getSchKeyName());
			rangeObj.setRange(shVO.getGlAccount().getRange());
			rangeObj.setValues(shVO.getGlAccount().getValues());
			rangeObj.setExcludeValues(shVO.getGlAccount().getExcludeValues());
			Map<Integer,String> getGlAccount = RangeCalculationUtil.rangeCalculation(rangeObj);
						
			for (Integer sch_values : getGlAccount.keySet()) 
			{ 				 
				String sch_key = getGlAccount.get(sch_values); 
				SchemeHeaderDetail obj_detail = new SchemeHeaderDetail();
				obj_detail.setSchKey(sch_key);
				obj_detail.setSchemNumb(shVO.getSchemNumb());
				obj_detail.setSchValue(sch_values+"");
				lshd.add(obj_detail);
				 
			}*/
				
		
		/*for (SchemeHeaderCondVO obj_src : shVO.getSchemeHeaderCond()) {
			SchemeHeaderCond obj_tar = new SchemeHeaderCond();
			BeanUtils.copyProperties(obj_src, obj_tar);
			lshc.add(obj_tar);
		}*/
		
		sh.setSchemeHeaderDetail(lshd);
		//sh.setSchemeHeaderCond(lshc);

		schemeHeaderRepository.save(sh);
		 StatusVO status=new StatusVO();
		 status.setCode("200");
		 status.setMessage("Successfully");
		 status.setStatus("Success");
		return status;
	}
}
