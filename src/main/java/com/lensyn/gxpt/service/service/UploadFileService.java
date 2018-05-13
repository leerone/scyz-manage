package com.lensyn.gxpt.service.service;


import java.util.List;

import com.lensyn.gxpt.service.entity.UploadFile;

/**
 */

public interface UploadFileService {
	List<UploadFile> getFileList(int fid);
	int insertUploadFile(UploadFile file);
	int updateUploadFile(UploadFile file);
}
