package com.peng.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot Rest 视图引导类
 * 
 * @author Peng
 * @date:2019年5月16日 下午8:51:05  
 */
@SpringBootApplication(scanBasePackages="com.peng")
public class SpringBootRestBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootstrap.class, args);
    }
}
