package com.lensyn.gxpt.service.mapper;

import java.util.List;

import com.lensyn.gxpt.service.entity.News;

public interface NewsMapper {

	List<News> getNewsList();

	void insertNews(News news);

	void delNews(String id);

	void updateNews(News news);

}