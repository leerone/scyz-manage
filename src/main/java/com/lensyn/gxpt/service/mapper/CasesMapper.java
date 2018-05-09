package com.lensyn.gxpt.service.mapper;

import java.util.List;

import com.lensyn.gxpt.service.entity.Cases;

public interface CasesMapper {

	List<Cases> getCasesList();

	void insertCases(Cases cases);

	void delCases(String id);

	void updateCases(Cases cases);

}