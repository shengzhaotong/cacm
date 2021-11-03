package com.lab.controller;

import com.lab.utils.IPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @Autowired
    IPUtil ipUtil;

    @GetMapping("/test")
    public String test (HttpServletRequest request) {
        String remoteIpAddr = ipUtil.getRemoteIpAddr(request);
        System.out.println(remoteIpAddr);
        System.out.println(request.getHeader("referer"));
        return remoteIpAddr;
    }

}
