package com.dalmia.dce.service;

import java.util.List;

import com.dalmia.dce.entities.SchemeHeader;
import com.dalmia.dce.vo.SchemeHeaderVO;

public interface SchemeHeaderService {
	List<SchemeHeader> getSchemeHeader(SchemeHeaderVO schemeHeaderVO);

}
