package com.lensyn.gxpt.service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lensyn.gxpt.service.entity.Case;
import com.lensyn.gxpt.service.entity.Hr;
import com.lensyn.gxpt.service.service.CaseService;

@RestController
@RequestMapping(value = "/case")
public class CaseCtrl {
	@Autowired
	private CaseService caseService;
	
	@RequestMapping(value = "/getCaseList")
	public List<Case> getCasesList(String type,Integer page) {
		Map map = new HashMap();
		map.put("page", page-1);
		map.put("type", type);
		return caseService.getCaseList(map);
	}
	
	@RequestMapping(value = "/insertCase")
	public String insertCases(Case cases) {
		caseService.insertCase(cases);
		Integer id = cases.getId();
		if (id != null) {
			return "1";
		} else {
			return "0";
		}
	}
	
	@RequestMapping(value = "/delCase")
	public String delCases(String id) {
		int delCase = caseService.delCase(id);
		if (delCase > 0) {
			return "1";
		} else {
			return "0";
		}
	}
	
	@RequestMapping(value = "/updateCase", method = RequestMethod.POST)
	public String updateNews(Case cases) {
		Integer id = caseService.updateCase(cases);
		if (id != null) {
			return "1";
		} else {
			return "0";
		}
	}
	
	@RequestMapping(value = "/getCaseCount")
	public int getCaseCount(String type) {
		int count = caseService.getCaseCount(type);
		return count;
	}
}
