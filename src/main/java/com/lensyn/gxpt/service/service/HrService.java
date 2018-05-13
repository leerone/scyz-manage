package com.lensyn.gxpt.service.service;


import java.util.List;
import java.util.Map;

import com.lensyn.gxpt.service.entity.Hr;

/**
 */

public interface HrService {
	List<Hr> getHrList(Map map);
	void insertHr(Hr hr);
	int delHr(String id);
	int updateHr(Hr hr);
	int getHrCount(String type);
}
