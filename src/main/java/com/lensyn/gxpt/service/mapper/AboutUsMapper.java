package com.lensyn.gxpt.service.mapper;

import java.util.List;
import java.util.Map;

import com.lensyn.gxpt.service.entity.AboutUs;

public interface AboutUsMapper {
	List<AboutUs> getAboutUsList(Map map);
	
	int insertAboutUs(AboutUs abs);
	
	int delAboutUs(String id);
	
	int updateAboutUs(AboutUs abs);
	
	int getAboutUsCount(String type);
	
	AboutUs getAboutUsById(int id);
	
}
