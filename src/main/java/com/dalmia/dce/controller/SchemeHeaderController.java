package com.dalmia.dce.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalmia.dce.service.SchemeHeaderService;
import com.dalmia.dce.vo.SchemeHeaderVO;



@RestController
@RequestMapping
public class SchemeHeaderController {
	@Autowired
	SchemeHeaderService schemeHeaderService;
	
	@GetMapping(value = "/getAllScheme")
    public List<SchemeHeaderVO> getSuggstions() {
        return schemeHeaderService.getSchemeHeader();
    }

   /* @GetMapping(value = "/getSchemeById")
    public List<SchemeHeaderVO> getVoilationsById(SchemeHeaderVO shVO) {
        return schemeHeaderService.getSuggstionsById(sVO);
    }*/
    
   
}
