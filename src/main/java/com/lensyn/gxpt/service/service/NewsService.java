package com.lensyn.gxpt.service.service;


import java.util.List;
import java.util.Map;

import com.lensyn.gxpt.service.entity.News;

/**
 */

public interface NewsService {
	List<News> getNewsList(Map map);
	void insertNews(News news);
	int delNews(String id);
	int updateNews(News news);
	int getNewsCount(String type);
	News getNewsById(int id);
}
