package com.lensyn.gxpt.service.service.impl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lensyn.gxpt.service.entity.News;
import com.lensyn.gxpt.service.mapper.NewsMapper;
import com.lensyn.gxpt.service.service.NewsService;

/**
 */
@Service("newsService")
@Transactional(rollbackFor = Exception.class)
public class NewsServiceImpl implements NewsService {
	
	@Autowired
    private NewsMapper newsMapper;

	@Override
	public List<News> getNewsList(Map map) {
		return newsMapper.getNewsList(map);
	}

	@Override
	public void insertNews(News news) {
		newsMapper.insertNews(news);
	}

	@Override
	public int delNews(String id) {
		return newsMapper.delNews(id);
	}

	@Override
	public int updateNews(News news) {
		return newsMapper.updateNews(news);
	}

	@Override
	public int getNewsCount(String type) {
		return newsMapper.getNewsCount(type);
	}
}
