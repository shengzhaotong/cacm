package com.lab.controller;

import com.lab.service.NewsService;
import com.lab.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
