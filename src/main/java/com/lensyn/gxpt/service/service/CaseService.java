package com.lensyn.gxpt.service.service;


import java.util.List;
import java.util.Map;

import com.lensyn.gxpt.service.entity.Case;

/**
 */

public interface CaseService {
	List<Case> getCaseList(Map map);
	List<Case> getAll(Map map);
	int insertCase(Case cases);
	int delCase(String id);
	int updateCase(Case cases);
	int getCaseCount(String type);
	Case getCaseById(int id);
}
