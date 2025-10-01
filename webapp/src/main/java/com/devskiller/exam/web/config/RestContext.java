package com.devskiller.exam.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.devskiller.exam.web.rest")
@EnableWebMvc
public class RestContext {

}
