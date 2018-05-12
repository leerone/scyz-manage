package com.lensyn.gxpt.service.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lensyn.gxpt.service.entity.Cases;
import com.lensyn.gxpt.service.mapper.CasesMapper;
import com.lensyn.gxpt.service.service.CasesService;

/**
 */
@Service("casesService")
@Transactional(rollbackFor = Exception.class)
public class CasesServiceImpl implements CasesService {
	
	@Autowired
    private CasesMapper casesMapper;

	@Override
	public List<Cases> getCasesList() {
		return casesMapper.getCasesList();
	}

	@Override
	public void insertCases(Cases cases) {
		casesMapper.insertCases(cases);
	}

	@Override
	public void delCases(String id) {
		casesMapper.delCases(id);
	}

	@Override
	public void updateCases(Cases cases) {
		casesMapper.updateCases(cases);
	}
}
