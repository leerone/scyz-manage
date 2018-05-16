package com.lensyn.gxpt.service.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lensyn.gxpt.service.entity.Case;
import com.lensyn.gxpt.service.mapper.CaseMapper;
import com.lensyn.gxpt.service.service.CaseService;

/**
 */
@Service("casesService")
@Transactional(rollbackFor = Exception.class)
public class CaseServiceImpl implements CaseService {

	@Autowired
	private CaseMapper caseMapper;

	@Override
	public List<Case> getCaseList(Map map) {
		return caseMapper.getCaseList(map);
	}

	@Override
	public int insertCase(Case cases) {
		return caseMapper.insertCase(cases);
	}

	@Override
	public int delCase(String id) {
		return caseMapper.delCase(id);
	}

	@Override
	public int updateCase(Case cases) {
		return caseMapper.updateCase(cases);
	}

	@Override
	public int getCaseCount(String type) {
		return caseMapper.getCaseCount(type);
	}

	@Override
	public Case getCaseById(int id) {
		// TODO Auto-generated method stub
		return caseMapper.getCaseById(id);
	}
}
