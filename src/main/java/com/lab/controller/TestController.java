package com.lab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@RestController
public class TestController {

    BufferedReader reader;
    StringBuffer data = new StringBuffer();
    String line;

    @PostMapping("/post_test")
    public String postTest(HttpServletRequest request) {
        try {
            reader = request.getReader();
            while (null != (line = reader.readLine())) {
                data.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    @GetMapping("/get_test")
    public String getTest() {
        return "get_test2";
    }

}
