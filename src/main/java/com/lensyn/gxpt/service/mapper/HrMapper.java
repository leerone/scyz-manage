package com.lensyn.gxpt.service.mapper;

import java.util.List;

import com.lensyn.gxpt.service.entity.Hr;

public interface HrMapper {

	List<Hr> getHrList();

	void insertHr(Hr hr);

	void delHr(String id);

	void updateHr(Hr hr);

}