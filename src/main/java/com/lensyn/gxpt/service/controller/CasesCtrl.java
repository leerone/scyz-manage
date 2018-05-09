package com.lensyn.gxpt.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lensyn.gxpt.service.entity.Cases;
import com.lensyn.gxpt.service.service.CasesService;

@RestController
@RequestMapping(value = "/cases")
public class CasesCtrl {
	@Autowired
	private CasesService casesService;
	
	@RequestMapping(value = "/getNewsList")
	public List<Cases> getCasesList() {
		return casesService.getCasesList();
	}
	
	@RequestMapping(value = "/insertNews")
	public String insertCases(Cases cases) {
		casesService.insertCases(cases);
		return "success!";
	}
	
	@RequestMapping(value = "/delNews")
	public String delCases(String id) {
		casesService.delCases(id);
		return "success!";
	}
}
