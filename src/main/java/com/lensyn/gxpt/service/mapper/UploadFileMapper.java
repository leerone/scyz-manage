package com.lensyn.gxpt.service.mapper;

import java.util.List;
import java.util.Map;

import com.lensyn.gxpt.service.entity.Comment;
import com.lensyn.gxpt.service.entity.UploadFile;

public interface UploadFileMapper {

	List<UploadFile> getFileList(int fid);

	int insertUploadFile(UploadFile file);
	
	int updateUploadFile(UploadFile file);

	List<UploadFile> getNotImageFileList(Map map);

	int getFileCount(String type);

	int delFile(String id);
	
	List<Comment> getCommentList(String fileid);
	int insertComment(Comment comment);
	int delComment(String id);
}