package com.lensyn.gxpt.service.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lensyn.gxpt.service.entity.AboutUs;
import com.lensyn.gxpt.service.mapper.AboutUsMapper;
import com.lensyn.gxpt.service.service.AboutUsService;

@Service("absService")
@Transactional(rollbackFor = Exception.class)
public class AboutUsServiceImpl implements AboutUsService{
	@Autowired
	private AboutUsMapper aboutusMapper;
	
	@Override
	public List<AboutUs> getAboutUsList(Map map) {
		return aboutusMapper.getAboutUsList(map);
	}
	
	@Override
	public int insertAboutUs(AboutUs abs) {
		return aboutusMapper.insertAboutUs(abs);
	}
	
	@Override
	public int delAboutUs(String id) {
		return aboutusMapper.delAboutUs(id);
	}
	
	@Override
	public int updateAboutUs(AboutUs abs) {
		return aboutusMapper.updateAboutUs(abs);
	}
	
	@Override
	public int getAboutUsCount(String type) {
		return aboutusMapper.getAboutUsCount(type);
	}
	
	@Override
	public AboutUs getAboutUsById(int id) {
		return aboutusMapper.getAboutUsById(id);
	}
	
}
