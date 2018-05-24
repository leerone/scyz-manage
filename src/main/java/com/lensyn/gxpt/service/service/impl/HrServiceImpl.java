package com.lensyn.gxpt.service.service.impl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lensyn.gxpt.service.entity.Hr;
import com.lensyn.gxpt.service.mapper.HrMapper;
import com.lensyn.gxpt.service.service.HrService;

/**
 */
@Service("hrService")
@Transactional(rollbackFor = Exception.class)
public class HrServiceImpl implements HrService {
	
	@Autowired
    private HrMapper hrMapper;

	@Override
	public List<Hr> getHrList(Map map) {
		return hrMapper.getHrList(map);
	}

	@Override
	public void insertHr(Hr hr) {
		hrMapper.insertHr(hr);
	}

	@Override
	public int delHr(String id) {
		return hrMapper.delHr(id);
	}

	@Override
	public int updateHr(Hr hr) {
		return hrMapper.updateHr(hr);
	}

	@Override
	public int getHrCount(String type) {
		return hrMapper.getHrCount(type);
	}

	@Override
	public List<Hr> getAll(Map map) {
		return hrMapper.getAll(map);
	}
}
