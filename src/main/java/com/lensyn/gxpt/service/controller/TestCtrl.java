package com.lensyn.gxpt.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lensyn.gxpt.service.entity.UserInfo;
import com.lensyn.gxpt.service.mapper.UserInfoMapper;
import com.lensyn.gxpt.service.service.RedisService;

/**
 */
@RestController
@RequestMapping(value = "/test")
public class TestCtrl {

	@Autowired
	private RedisService redisService;

	@Autowired
	private UserInfoMapper userInfoMapper;

	@RequestMapping(value = "/index")
	public String index() {
		return "hello world";
	}

	/**
	 * 向redis存储值
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/set")
	public String set(String key, String value) throws Exception {

		redisService.set(key, value);
		return "success";
	}

	/**
	 * 获取redis中的值
	 * 
	 * @param key
	 * @return
	 */
	@RequestMapping("/get")
	public String get(String key) {
		try {
			return redisService.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取数据库中的用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/getUser/{id}")
	@ResponseBody
	public UserInfo get(@PathVariable("id") int id) {
		System.out.println(id);
		try {
			UserInfo user = userInfoMapper.selectByPrimaryKey(id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
