package com.lensyn.gxpt.service.mapper;

import java.util.List;

import com.lensyn.gxpt.service.entity.UploadFile;

public interface UploadFileMapper {

	List<UploadFile> getFileList(int fid);

	int insertUploadFile(UploadFile file);
	
	int updateUploadFile(UploadFile file);
}