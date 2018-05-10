package com.lensyn.gxpt.service.service.impl;



import java.util.List;

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
	public List<Hr> getHrList() {
		return hrMapper.getHrList();
	}

	@Override
	public void insertHr(Hr hr) {
		hrMapper.insertHr(hr);
	}

	@Override
	public void delHr(String id) {
		hrMapper.delHr(id);
	}

	@Override
	public void updateHr(Hr hr) {
		hrMapper.updateHr(hr);
	}
}
