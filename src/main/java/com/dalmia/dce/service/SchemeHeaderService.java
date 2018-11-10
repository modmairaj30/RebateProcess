package com.dalmia.dce.service;

import java.util.List;

import com.dalmia.dce.vo.SchemeHeaderGetVO;
import com.dalmia.dce.vo.SchemeHeaderVO;
import com.dalmia.dce.vo.StatusVO;

public interface SchemeHeaderService {
	List<SchemeHeaderGetVO> getSchemeHeader();
	public StatusVO saveSchemeHeader(SchemeHeaderVO shVO);

}
