package com.lensyn.gxpt.service.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lensyn.gxpt.service.entity.AboutUs;
import com.lensyn.gxpt.service.service.AboutUsService;

@RestController
@RequestMapping(value = "/aboutus")
public class AboutUsCtrl {
	@Autowired
	private AboutUsService absService;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/getAboutUsList")
	public List<AboutUs> getAboutUsList(String type, Integer page) {
		Map map = new HashMap();
		map.put("type", type);
		map.put("page", page - 1);
		return absService.getAboutUsList(map);
	}
	
	@RequestMapping(value = "/inserAboutUs", method = RequestMethod.POST)
	public String insertAboutUs(AboutUs abs) {
		if (StringUtils.isEmpty(abs.getTime())) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			abs.setTime(df.format(new Date()));
		}
		absService.insertAboutUs(abs);
		Integer id = abs.getId();
		if (id != null) {
			return "1";
		} else {
			return "0";
		}
	}
	
	@RequestMapping(value = "/updateAboutUs", method = RequestMethod.POST)
	public String updateAboutUs(AboutUs abs) {
		Integer result = absService.updateAboutUs(abs);
		if (result > 0) {
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/delAboutUs")
	public String delAboutUs(String id) {
		int result = absService.delAboutUs(id);
		logger.info("删除 关于我们 的返回结果：");
		logger.info(result);
		if (result > 0) {
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/getAboutUsCount")
	public int getAboutUsCount(String type) {
		return absService.getAboutUsCount(type);
	}
	
	@RequestMapping(value = "/getAboutUsById")
	public AboutUs getAboutUsById(int id) {
		return absService.getAboutUsById(id);
	}
}
