package com.lensyn.gxpt.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lensyn.gxpt.service.entity.News;
import com.lensyn.gxpt.service.service.NewsService;

@RestController
@RequestMapping(value = "/news")
public class NewsCtrl {
	@Autowired
	private NewsService newsService;
	
	@RequestMapping(value = "/getNewsList")
	public List<News> getNewsList() {
		System.out.println("请求到远程服务器!");
		return newsService.getNewsList();
	}
	
	@RequestMapping(value = "/insertNews")
	public String insertNews(News news) {
		newsService.insertNews(news);
		return "success!";
	}
	
	@RequestMapping(value = "/delNews")
	public String delNews(String id) {
		newsService.delNews(id);
		return "success!";
	}
}
