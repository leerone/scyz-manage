package com.lensyn.gxpt.service.service;


import java.util.List;

import com.lensyn.gxpt.service.entity.News;

/**
 */

public interface NewsService {
	List<News> getNewsList();
	void insertNews(News news);
	void delNews(String id);
	void updateNews(News news);
}
