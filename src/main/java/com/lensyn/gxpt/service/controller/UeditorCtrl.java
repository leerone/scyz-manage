package com.lensyn.gxpt.service.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lensyn.gxpt.service.common.ueditor.ActionEnter;


/**
 * 用于处理关于ueditor插件相关的请求
 * @author Guoqing
 * @date 2017-11-29
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/ueditor")
public class UeditorCtrl {

	@RequestMapping(value = "/exec")
	@ResponseBody
	public String exec(HttpServletRequest request) throws UnsupportedEncodingException, JSONException{ 
		request.setCharacterEncoding("utf-8");
		System.out.println("exec");
		String rootPath = request.getRealPath("/");
		return new ActionEnter( request, rootPath ).exec();
	}
	
}