package com.dalmia.dce.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalmia.dce.dao.ShemCreationDetailDao;
import com.dalmia.dce.vo.BillingTypeVO;
import com.dalmia.dce.vo.BusinessAreaVO;
import com.dalmia.dce.vo.CityCodeVO;
import com.dalmia.dce.vo.CompanyCodesVO;
import com.dalmia.dce.vo.CostCenterVO;
import com.dalmia.dce.vo.CountryCodeVO;
import com.dalmia.dce.vo.CustomerGroupVO;
import com.dalmia.dce.vo.CustomerVO;
import com.dalmia.dce.vo.DistributionChannelVO;
import com.dalmia.dce.vo.DivisionVO;
import com.dalmia.dce.vo.GLAccountVO;
import com.dalmia.dce.vo.MaterialGroupVO;
import com.dalmia.dce.vo.MaterialVO;
import com.dalmia.dce.vo.PaymentInsurenceTypeVO;
import com.dalmia.dce.vo.PlantVO;
import com.dalmia.dce.vo.ProfitCenterVO;
import com.dalmia.dce.vo.RegionVO;
import com.dalmia.dce.vo.SalesDistrictVO;
import com.dalmia.dce.vo.SalesGroupVO;
import com.dalmia.dce.vo.SalesOfficeVO;
import com.dalmia.dce.vo.SalesOrganizationVO;
import com.dalmia.dce.vo.SchemeUniverseVO;
import com.dalmia.dce.vo.ShippingConditionsVO;
import com.dalmia.dce.vo.ViewSchemCreationVO;


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
	
	//------------------------------------
	@GetMapping(value = "/getDistbChanel")
    public Map<String, DistributionChannelVO> getDistbChanel() {
        try {
			return  schemcreationDetaiDao.getDistbChanel();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getDivision")
    public Map<String, DivisionVO> getDivision() {
        try {
			return  schemcreationDetaiDao.getDivision();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	
	@GetMapping(value = "/getBilling")
    public Map<String, BillingTypeVO> getBilling() {
        try {
			return  schemcreationDetaiDao.getBilling();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getSalesOffice")
    public Map<String, SalesOfficeVO> getSalesOffice() {
        try {
			return  schemcreationDetaiDao.getSalesOffice();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getSalesGroup")
    public Map<String, SalesGroupVO> getSalesGroup() {
        try {
			return  schemcreationDetaiDao.getSalesGroup();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getRegion")
    public Map<String, RegionVO> getRegion() {
        try {
			return  schemcreationDetaiDao.getRegion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getCity")
    public Map<String, CityCodeVO> getCity() {
        try {
			return  schemcreationDetaiDao.getCity();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	
	@GetMapping(value = "/getCustmGrp")
    public Map<String, CustomerGroupVO> getCustmGrp() {
        try {
			return  schemcreationDetaiDao.getCustmGrp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	
	
	
	
	@GetMapping(value = "/getCustomer")
    public Map<String, CustomerVO> getCustomer() {
        try {
			return  schemcreationDetaiDao.getCustomer();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getShippingCondition")
    public Map<String, ShippingConditionsVO> getShippingCondition() {
        try {
			return  schemcreationDetaiDao.getShippingCondition();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getMaterialGrp")
    public Map<String, MaterialGroupVO> getMaterialGrp() {
        try {
			return  schemcreationDetaiDao.getMaterialGrp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getMaterial")
    public Map<String, MaterialVO> getMaterial() {
        try {
			return  schemcreationDetaiDao.getMaterial();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	
	
	@GetMapping(value = "/getPlant")
    public Map<String, PlantVO> getPlant() {
        try {
			return  schemcreationDetaiDao.getPlant();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getProfitCenter")
    public Map<String, ProfitCenterVO> getProfitCenter() {
        try {
			return  schemcreationDetaiDao.getProfitCenter();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getBusinessArea")
    public Map<String, BusinessAreaVO> getBusinessArea() {
        try {
			return  schemcreationDetaiDao.getBusinessArea();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getPaymentInsType")
    public Map<String, PaymentInsurenceTypeVO> getPaymentInsType() {
        try {
			return  schemcreationDetaiDao.getPaymentInsType();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getGlAccount")
    public Map<String, GLAccountVO> getGlAccount() {
        try {
			return  schemcreationDetaiDao.getGlAccount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getCostCenter")
    public Map<String, CostCenterVO> getCostCenter() {
        try {
			return  schemcreationDetaiDao.getCostCenter();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@GetMapping(value = "/getCountryCode")
    public Map<String, CountryCodeVO> getCountryCode() {
        try {
			return  schemcreationDetaiDao.getCountryCode();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	
	@GetMapping(value = "/getViewSchemCreation")
    public ViewSchemCreationVO getViewSchemCreation() {
        try {
			return  schemcreationDetaiDao.getViewSchemCreation();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	
}
