package com.lab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //http://localhost:8888/doc.html?plus=1

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lab.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("ShengZhaoTong","","1454579997@qq.com");
        return new ApiInfo(
                "Dr. Lu's Laboratory",
                "",
                "v1.0",
                "",
                contact,
                "",
                "",
                new ArrayList<>()
        );
    }


}
