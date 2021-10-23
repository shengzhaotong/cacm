package com.lab;

import com.lab.dao.NewsDao;
import com.lab.pojo.News;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BackApplicationTests {

    @Autowired
    NewsDao newsDao;

    @Test
    void contextLoads() {

    }
}
