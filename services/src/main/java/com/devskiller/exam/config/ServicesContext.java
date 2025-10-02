package com.devskiller.exam.config;

import com.devskiller.exam.service.PostService;
import com.devskiller.exam.service.PostServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:domain-applicationContext.xml")
@ComponentScan(basePackages = "com.devskiller.exam.service")
public class ServicesContext {

    @Bean
    public PostService postService() {
        return new PostServiceImpl();
    }
}
