package com.dalmia.dce.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalmia.dce.service.SchemeHeaderService;
import com.dalmia.dce.vo.SchemeHeaderVO;


@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class SchemeHeaderController {
	@Autowired
	SchemeHeaderService schemeHeaderService;
	
	@GetMapping(value = "/getAllScheme")
    public List<SchemeHeaderVO> getAllSchemes() {
        return schemeHeaderService.getSchemeHeader();
    }

   /* @GetMapping(value = "/getSchemeById")
    public List<SchemeHeaderVO> getVoilationsById(SchemeHeaderVO shVO) {
        return schemeHeaderService.getSuggstionsById(sVO);
    }*/
    
   
}
