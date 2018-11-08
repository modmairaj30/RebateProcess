package com.dalmia.dce.service;

import java.util.List;

import com.dalmia.dce.vo.SchemeHeaderVO;
import com.dalmia.dce.vo.StatusVO;

public interface SchemeHeaderService {
	List<SchemeHeaderVO> getSchemeHeader();
	public StatusVO saveSchemeHeader(SchemeHeaderVO shVO);

}
