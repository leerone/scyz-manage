package com.lensyn.gxpt.service.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.lensyn.gxpt.service.entity.Comment;
import com.lensyn.gxpt.service.entity.UploadFile;
import com.lensyn.gxpt.service.service.UploadFileService;

/**
 */
@RestController
@RequestMapping(value = "/file")
public class UploadFileCtrl {

	@Autowired
	private UploadFileService uploadFileService;

	@RequestMapping(value = "/getFileCount")
	public int getCaseCount(String type) {
		type = "notimage";
		int count = uploadFileService.getFileCount(type);
		return count;
	}

	@RequestMapping(value = "/getNotImageFileList")
	public List<UploadFile> getNotImageFileList(String type, Integer page) {
		Map map = new HashMap();
		map.put("page", page - 1);
		map.put("type", "notimage");
		return uploadFileService.getNotImageFileList(map);
	}

	@RequestMapping(value = "/delFile")
	public int delFile(String id) {
		return uploadFileService.delFile(id);
	}

	/**
	 * 评论list
	 * 
	 * @param fileid
	 * @return
	 */
	@RequestMapping(value = "/getCommentList")
	public List<Comment> getCommentList(String fileid) {
		return uploadFileService.getCommentList(fileid);
	}

	/**
	 * 评论list
	 * 
	 * @param fileid
	 * @return
	 */
	@RequestMapping(value = "/insertComment")
	public String insertComment(Comment comment) {
		int commentid = uploadFileService.insertComment(comment);
		Integer id = comment.getId();
		if (id != null) {
			return "1";
		} else {
			return "0";
		}
	}

	/**
	 * 评论list
	 * 
	 * @param fileid
	 * @return
	 */
	@RequestMapping(value = "/delComment")
	public String delComment(String id) {
		int delComment = uploadFileService.delComment(id);
		if (delComment > 0) {
			return "1";
		} else {
			return "0";
		}
	}

	@RequestMapping("/uploadimage")
	public String postFile(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
		// String result = "error";
		// Map<String, Object> map = new HashMap<String, Object>();
		String result = "";
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
							File file = new File(url, tempname);
							try {
								multipartFile.transferTo(file);
								result = tempname;
								UploadFile uploadFile = new UploadFile();
								uploadFile.setName(tempname);
								uploadFile.setUrl(url + tempname);
								uploadFileService.insertUploadFile(uploadFile);
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
							// String url = "D://";
							String tempname = new Date().getTime() + "=" + fileName;

							File file = new File(url, tempname);
							try {
								multipartFile.transferTo(file);
								result = tempname;
								UploadFile uploadFile = new UploadFile();
								uploadFile.setName(tempname);
								uploadFile.setUrl(url + tempname);
								uploadFile.setType(fileName.split("\\.")[1]);
								uploadFileService.insertUploadFile(uploadFile);
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

	@RequestMapping("/tempimage")
	public String tempFile(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
		// String result = "error";
		// Map<String, Object> map = new HashMap<String, Object>();
		String result = "";
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
							String url = "/usr/local/src/tempimage/";
							String tempname = new Date().getTime() + "=" + fileName;
							File file = new File(url, tempname);
							try {
								multipartFile.transferTo(file);
								result = "http://47.106.177.128:16668/tempimage/" + tempname;
								UploadFile uploadFile = new UploadFile();
								uploadFile.setName(tempname);
								uploadFile.setUrl(url + tempname);
								uploadFileService.insertUploadFile(uploadFile);
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
