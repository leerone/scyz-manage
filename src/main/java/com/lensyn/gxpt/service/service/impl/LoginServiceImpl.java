package com.lensyn.gxpt.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lensyn.gxpt.service.entity.User;
import com.lensyn.gxpt.service.mapper.LoginMapper;
import com.lensyn.gxpt.service.service.LoginService;

/**
 */
@Service("loginService")
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Override
	public User login(User user) {
		return loginMapper.login(user);
	}
}
