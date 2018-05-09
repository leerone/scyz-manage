package com.lensyn.gxpt.service.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.lensyn.gxpt.service.entity.Cases;
import com.lensyn.gxpt.service.mapper.CasesMapper;
import com.lensyn.gxpt.service.service.CasesService;
import com.lensyn.gxpt.service.service.RedisService;
import com.lensyn.gxpt.service.utils.JsonUtil;

import java.util.*;
import java.util.concurrent.TimeUnit;

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
