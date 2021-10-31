package com.lab.config;

import com.lab.Interceptor.BucketInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    BucketInterceptor bucketInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 令牌桶拦截器 添加拦截器并选择拦截路径
        registry.addInterceptor(bucketInterceptor).addPathPatterns("/**");
    }

}
