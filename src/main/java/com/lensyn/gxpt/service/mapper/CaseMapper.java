package com.lensyn.gxpt.service.mapper;

import java.util.List;
import java.util.Map;

import com.lensyn.gxpt.service.entity.Case;

public interface CaseMapper {

	List<Case> getCaseList(Map map);

	int insertCase(Case cases);

	int delCase(String id);

	int updateCase(Case cases);
	
	int getCaseCount(String type);

	Case getCaseById(int id);

}