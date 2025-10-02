package com.devskiller.exam.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication()
@ComponentScan("com.devskiller.exam.service")
public class DevSkillerLauncher {

    public static void main(String[] args) {
        SpringApplication.run(DevSkillerLauncher.class, args);
    }
}
