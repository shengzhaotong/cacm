package com.lab;

import com.lab.utils.BucketUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.lab.dao")
@EnableTransactionManagement
@EnableScheduling
@ServletComponentScan(basePackages="com.lab.Filter")
public class BackApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BackApplication.class, args);
        // 为了方便测试这里定义1容量  1增长速率
        BucketUtil bucketUtil = new BucketUtil(10,1);
        // 生成名为：bucket的令牌桶
        BucketUtil.buckets.put("bucket",bucketUtil);
    }

    @Scheduled(fixedRate = 1000)// 定时1s
    public void timer() {
        if (BucketUtil.buckets.containsKey("bucket")){
            //名为：bucket的令牌桶 开始不断生成令牌
            BucketUtil.buckets.get("bucket").incrTokens();
        }
    }
}

//@SpringBootApplication
//@MapperScan("com.lab.dao")
//@EnableTransactionManagement
//@EnableScheduling
//@ServletComponentScan(basePackages="com.lab.Filter")
//public class BackApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(BackApplication.class, args);
//        // 为了方便测试这里定义1容量  1增长速率
//        BucketUtil bucketUtil = new BucketUtil(10,1);
//        // 生成名为：bucket的令牌桶
//        BucketUtil.buckets.put("bucket",bucketUtil);
//    }
//
//    @Scheduled(fixedRate = 1000)// 定时1s
//    public void timer() {
//        if (BucketUtil.buckets.containsKey("bucket")){
//            //名为：bucket的令牌桶 开始不断生成令牌
//            BucketUtil.buckets.get("bucket").incrTokens();
//        }
//    }
//}
