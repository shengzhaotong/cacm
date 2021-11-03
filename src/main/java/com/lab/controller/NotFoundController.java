package com.lab.controller;

import com.lab.utils.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class NotFoundController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    IPUtil ipUtil;

    @RequestMapping("/**")
    public String notFound (HttpServletRequest request) {
        String ip = ipUtil.getRemoteIpAddr(request);
        logger.error(ip+"访问了一个未知路径");
        return "404 NOT FOUND";
    }

}
