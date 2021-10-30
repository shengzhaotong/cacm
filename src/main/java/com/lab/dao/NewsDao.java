package com.lab.dao;

import com.lab.pojo.News;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsDao {

    List<News> selectAllNews();
    int addNews(News news);
    List<String> searchTitle(String key);
    List<News> searchNews(String key);
    int deleteNews(News news);

}
