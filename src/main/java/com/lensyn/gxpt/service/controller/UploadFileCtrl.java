package com.lensyn.gxpt.service.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.lensyn.gxpt.service.entity.UploadFile;
import com.lensyn.gxpt.service.service.UploadFileService;

/**
 */
@RestController
@RequestMapping(value = "/file")
public class UploadFileCtrl {
	
	@Autowired
	private UploadFileService uploadFileService;

	@RequestMapping("/uploadimage")
	public String postFile(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
		// String result = "error";
		// Map<String, Object> map = new HashMap<String, Object>();
		String result = "1";
		try {
			// 创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
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
						if (fileName.trim() != null && fileName.trim().length() > 0) {
							String url = "/usr/local/src/uploadimage/";
							String tempname = new Date().getTime() + "=" + fileName;
							File file = new File(url,tempname);
							try {
								multipartFile.transferTo(file);
								UploadFile uploadFile = new UploadFile();
								uploadFile.setName(fileName);
								uploadFile.setUrl(url+tempname);
								// 拿到文件，存储
								// result = "success";
							} catch (IllegalStateException | IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		} catch (Exception e) {
			result = "0";
			throw e;
		} finally {
			
		}
		return result;
	}
	
	@RequestMapping("/uploadfile")
	public String document(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
		// String result = "error";
		// Map<String, Object> map = new HashMap<String, Object>();
		String result = "1";
		try {
			// 创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
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
						if (fileName.trim() != null && fileName.trim().length() > 0) {
							String url = "/usr/local/src/uploadfile/";
							String tempname = new Date().getTime() + "=" + fileName;
							File file = new File(url,tempname);
							try {
								multipartFile.transferTo(file);
								UploadFile uploadFile = new UploadFile();
								uploadFile.setName(fileName);
								uploadFile.setUrl(url+tempname);
								// 拿到文件，存储
								// result = "success";
							} catch (IllegalStateException | IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		} catch (Exception e) {
			result = "0";
			throw e;
		} finally {
			
		}
		return result;
	}
}
