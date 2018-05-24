package com.lensyn.gxpt.service.mapper;

import java.util.List;
import java.util.Map;

import com.lensyn.gxpt.service.entity.Hr;

public interface HrMapper {

	List<Hr> getHrList(Map map);

	void insertHr(Hr hr);

	int delHr(String id);

	int updateHr(Hr hr);

	int getHrCount(String type);

	List<Hr> getAll(Map map);

}