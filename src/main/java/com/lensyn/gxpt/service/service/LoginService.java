package com.lensyn.gxpt.service.service;

import com.lensyn.gxpt.service.entity.User;

public interface LoginService {

	User login(User user);
	
	User getCurUser(String id);
}
