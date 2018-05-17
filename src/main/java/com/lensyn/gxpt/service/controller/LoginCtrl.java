package com.lensyn.gxpt.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lensyn.gxpt.service.entity.User;
import com.lensyn.gxpt.service.service.LoginService;

@RestController
//@RequestMapping(value = "/login")
public class LoginCtrl {
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value = "/login")
	public User login(User user) {
		return loginService.login(user);
	}
}
