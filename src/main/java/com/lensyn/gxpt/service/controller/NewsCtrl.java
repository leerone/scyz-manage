package com.lensyn.gxpt.service.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lensyn.gxpt.service.entity.News;
import com.lensyn.gxpt.service.service.NewsService;

@RestController
@RequestMapping(value = "/news")
public class NewsCtrl {
	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "/getNewsList")
	public List<News> getNewsList(String type, String page) {
		int newPage = (((Integer.valueOf(page) - 1) * 10));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("page", newPage);
		return newsService.getNewsList(map);
	}

	@RequestMapping(value = "/insertNews", method = RequestMethod.POST)
	public String insertNews(News news) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		news.setTime(df.format(new Date()));
		newsService.insertNews(news);
		Integer id = news.getId();
		if (id != null) {
			return "1";
		} else {
			return "0";
		}
	}
	
	@RequestMapping(value = "/updateNews", method = RequestMethod.POST)
	public String updateNews(News news) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		news.setTime(df.format(new Date()));
		Integer id = newsService.updateNews(news);
		if (id != null) {
			return "1";
		} else {
			return "0";
		}
	}

	@RequestMapping(value = "/delNews")
	public String delNews(String id) {
		int delNews = newsService.delNews(id);
		if (delNews > 0) {
			return "1";
		} else {
			return "0";
		}
	}

	@RequestMapping(value = "/getNewsCount")
	public int getNewsCount(String type) {
		int newsCount = newsService.getNewsCount(type);
		return newsCount;
	}
	
	@RequestMapping(value = "/getNewsById")
	public News getNewsById(int id) {
		News news = newsService.getNewsById(id);
		return news;
	}
}
