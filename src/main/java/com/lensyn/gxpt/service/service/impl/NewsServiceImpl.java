package com.lensyn.gxpt.service.service.impl;



import java.util.List;

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
	public List<News> getNewsList(String type) {
		return newsMapper.getNewsList(type);
	}

	@Override
	public void insertNews(News news) {
		newsMapper.insertNews(news);
	}

	@Override
	public void delNews(String id) {
		newsMapper.delNews(id);
	}

	@Override
	public void updateNews(News news) {
		newsMapper.updateNews(news);
	}
}
