package com.lab.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    /**
     * 获取所有实验室新闻
     * */
    @GetMapping("/get_news")
    public String getNews () throws JsonProcessingException {
        return jsonUtil.getJson(newsService.selectAllNews());
    }

    /**
     * 搜索新闻标题，前缀搜索
     * 返回以关键字为开头的所有字符串
     * */
    @GetMapping("/search_title")
    public String searchTitle (String key) throws JsonProcessingException {
        return jsonUtil.getJson(newsService.searchTitle(key));
    }

    /**
     * 搜索新闻，全文检索
     * 默认将接受到的关键字按2个一组进行分词
     * 返回标题或内容中含有关键字的所有新闻
     * 配置分词器办法：
     * 在MySQL的配置文件中增加 ： ngram_token_size=@{分词数量}
     * */
    @GetMapping("/search_news")
    public String searchNews (String key) throws JsonProcessingException {
        return jsonUtil.getJson(newsService.searchNews(key));
    }

    /**
     * 增加一条新闻
     * */
    @PostMapping("/add_news")
    public int addNews (@RequestBody News news) {
        return newsService.addNews(news);
    }

    /**
     * 删除一条新闻
     * */
    @PostMapping("/delete_news")
    public int deleteNews (@RequestBody News news) {
        return newsService.deleteNews(news);
    }

}
