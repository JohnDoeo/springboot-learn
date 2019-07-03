package com.johndoeo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}/*,scanBasePackages = "com.johndoeo.demo"*/)
public class SpringbootEsDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootEsDemoApplication.class, args);
    }
}
