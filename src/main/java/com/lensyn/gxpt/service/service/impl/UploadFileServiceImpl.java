package com.lensyn.gxpt.service.service.impl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lensyn.gxpt.service.entity.Comment;
import com.lensyn.gxpt.service.entity.UploadFile;
import com.lensyn.gxpt.service.mapper.UploadFileMapper;
import com.lensyn.gxpt.service.service.UploadFileService;

/**
 */
@Service("iuploadFileService")
@Transactional(rollbackFor = Exception.class)
public class UploadFileServiceImpl implements UploadFileService {
	
	@Autowired
    private UploadFileMapper uploadFileMapper;

	@Override
	public List<UploadFile> getFileList(int fid) {
		return uploadFileMapper.getFileList(fid);
	}

	@Override
	public int insertUploadFile(UploadFile file) {
		return uploadFileMapper.insertUploadFile(file);
	}

	@Override
	public int updateUploadFile(UploadFile file) {
		return uploadFileMapper.updateUploadFile(file);
	}

	@Override
	public List<UploadFile> getNotImageFileList(Map map) {
		return uploadFileMapper.getNotImageFileList(map);
	}

	@Override
	public int getFileCount(String type) {
		return uploadFileMapper.getFileCount(type);
	}

	@Override
	public int delFile(String id) {
		return uploadFileMapper.delFile(id);
	}

	@Override
	public List<Comment> getCommentList(Integer fileid) {
		return uploadFileMapper.getCommentList(fileid);
	}

	@Override
	public int insertComment(Comment comment) {
		return uploadFileMapper.insertComment(comment);
	}

	@Override
	public int delComment(String id) {
		return uploadFileMapper.delComment(id);
	}
}
