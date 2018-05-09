package com.lensyn.gxpt.service.service;


import java.util.List;

import com.lensyn.gxpt.service.entity.Hr;

/**
 */

public interface HrService {
	List<Hr> getHrList();
	void insertHr(Hr hr);
	void delHr(String id);
	void updateHr(Hr hr);
}
