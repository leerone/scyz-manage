package com.lensyn.gxpt.service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lensyn.gxpt.service.entity.Hr;
import com.lensyn.gxpt.service.service.HrService;

@RestController
@RequestMapping(value = "/hr")
public class HrCtrl {
	@Autowired
	private HrService hrService;
	
	@RequestMapping(value = "/getHrList")
	public List<Hr> gethrList(String type,Integer page) {
		Map map = new HashMap();
		map.put("page", page-1);
		map.put("type", type);
		return hrService.getHrList(map);
	}
	
	@RequestMapping(value = "/insertHr")
	public String insertHr(Hr hr) {
		hrService.insertHr(hr);
		Integer id = hr.getId();
		if (id != null) {
			return "1";
		} else {
			return "0";
		}
	}
	
	@RequestMapping(value = "/delHr")
	public String delHr(String id) {
		int delHr = hrService.delHr(id);
		if (delHr > 0) {
			return "1";
		} else {
			return "0";
		}
	}
	
	@RequestMapping(value = "/updateHr", method = RequestMethod.POST)
	public String updateNews(Hr hr) {
		Integer id = hrService.updateHr(hr);
		if (id != null) {
			return "1";
		} else {
			return "0";
		}
	}
	
	@RequestMapping(value = "/getHrCount")
	public int getHrCount(String type) {
		int hrCount = hrService.getHrCount(type);
		return hrCount;
	}
}
