package com.lensyn.gxpt.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lensyn.gxpt.service.entity.Hr;
import com.lensyn.gxpt.service.service.HrService;

@RestController
@RequestMapping(value = "/hr")
public class HrCtrl {
	@Autowired
	private HrService hrService;
	
	@RequestMapping(value = "/getHrList")
	public List<Hr> gethrList() {
		return hrService.getHrList();
	}
	
	@RequestMapping(value = "/insertHr")
	public String insertHr(Hr hr) {
		hrService.insertHr(hr);
		return "success!";
	}
	
	@RequestMapping(value = "/delHr")
	public String delHr(String id) {
		hrService.delHr(id);
		return "success!";
	}
}
