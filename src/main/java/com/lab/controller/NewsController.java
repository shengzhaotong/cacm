package com.lab.controller;

import com.lab.pojo.News;
import com.lab.service.NewsService;
import com.lab.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @Autowired
    NewsService newsService;

    @Autowired
    JsonUtil jsonUtil;

    @GetMapping("/get_news")
    public String getNews () {
        return jsonUtil.getJson(newsService.selectAllNews());
    }

    @GetMapping("/search_title")
    public String searchTitle (String key) {
        return jsonUtil.getJson(newsService.searchTitle(key));
    }

    @GetMapping("/search_news")
    public String searchNews (String key) {
        return jsonUtil.getJson(newsService.searchNews(key));
    }

    @PostMapping("/add_news")
    public int addNews (@RequestBody News news) {
        return newsService.addNews(news);
    }

    @PostMapping("/delete_news")
    public int deleteNews (@RequestBody News news) {
        return newsService.deleteNews(news);
    }

}
