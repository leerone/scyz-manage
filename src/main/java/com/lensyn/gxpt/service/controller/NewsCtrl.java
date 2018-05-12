package com.lensyn.gxpt.service.controller;

import java.util.Date;
import java.util.List;

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
	public List<News> getNewsList(String type) {
		System.out.println("请求到远程服务器!");
		return newsService.getNewsList(type);
	}
	
	@RequestMapping(value = "/insertNews", method=RequestMethod.POST)
	public String insertNews(News news) {
		news.setTime(new Date().toLocaleString());
		newsService.insertNews(news);
		Integer id = news.getId();
		System.out.println(id);
		if(id != null){
			return "1";
		}else {
			return "0";
		}
	}
	
	@RequestMapping(value = "/delNews")
	public String delNews(String id) {
		newsService.delNews(id);
		return "success!";
	}
}
