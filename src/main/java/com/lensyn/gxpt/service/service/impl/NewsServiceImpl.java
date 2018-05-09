package com.lensyn.gxpt.service.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.lensyn.gxpt.service.entity.News;
import com.lensyn.gxpt.service.mapper.NewsMapper;
import com.lensyn.gxpt.service.service.NewsService;
import com.lensyn.gxpt.service.service.RedisService;
import com.lensyn.gxpt.service.utils.JsonUtil;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 */
@Service("newsService")
@Transactional(rollbackFor = Exception.class)
public class NewsServiceImpl implements NewsService {
	
	@Autowired
    private NewsMapper newsMapper;

	@Override
	public List<News> getNewsList() {
		return newsMapper.getNewsList();
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
