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



@RestController
@RequestMapping
public class SchemeHeaderController {
	@Autowired
	SchemeHeaderService schemeHeaderService;
	
	@GetMapping(value = "/getAllScheme")
    public List<Suggestions> getSuggstions() {
        return suggService.getSuggstions();
    }

    @GetMapping(value = "/getSuggestionsById")
    public List<Suggestions> getVoilationsById(SuggestionsVO sgVO) {
        return suggService.getSuggstionsById(sgVO);
    }
    
   
}
