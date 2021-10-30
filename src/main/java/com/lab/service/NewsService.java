package com.lab.service;

import com.lab.dao.NewsDao;
import com.lab.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NewsService {

    @Autowired
    NewsDao newsDao;

    public List<News> selectAllNews () {
        return newsDao.selectAllNews();
    }

    public int addNews (News news) {
        return newsDao.addNews(news);
    }

    public List<String> searchTitle (String key) {
        return newsDao.searchTitle(key);
    }

    public List<News> searchNews (String key) {
        return newsDao.searchNews(key);
    }

    public int deleteNews (News news) {
        return newsDao.deleteNews(news);
    }

}
