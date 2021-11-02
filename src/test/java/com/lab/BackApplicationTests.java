package com.lab;

import com.lab.utils.Cache;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@SpringBootTest
class BackApplicationTests {


    @Autowired
    Cache cache;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() throws Exception{
        cache.set("key","123");
        System.out.println(cache.get("key"));
    }

    @GetMapping("/test")
    public String test (HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        System.out.println(header);
        return "test";
    }

}
