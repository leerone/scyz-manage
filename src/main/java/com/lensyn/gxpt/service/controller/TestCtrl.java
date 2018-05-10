package com.lensyn.gxpt.service.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

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
	
	@RequestMapping("/postFile")
    public void postFile(HttpServletRequest request, HttpServletResponse response) {
//        String result = "error";
//        Map<String, Object> map = new HashMap<String, Object>();
        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
                .getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 取得上传文件
                MultipartFile multipartFile = multiRequest.getFile(iter.next());
                if (multipartFile != null) {
                    // 取得当前上传文件的文件名称
                    String fileName = multipartFile.getOriginalFilename();
                    System.err.println(fileName);
                    if (fileName.trim() != null && fileName.trim().length() > 0) {
                    	File file = new File("D://"+fileName);
                    	try {
							multipartFile.transferTo(file);
							System.err.println(file.getName());
	                        // 拿到文件，存储
//	                        result = "success";
						} catch (IllegalStateException | IOException e) {
							e.printStackTrace();
						}
                    }
                }
            }
        }
    }
}
