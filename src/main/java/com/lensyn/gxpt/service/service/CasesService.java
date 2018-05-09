package com.lensyn.gxpt.service.service;


import java.util.List;

import com.lensyn.gxpt.service.entity.Cases;

/**
 */

public interface CasesService {
	List<Cases> getCasesList();
	void insertCases(Cases cases);
	void delCases(String id);
	void updateCases(Cases cases);
}
