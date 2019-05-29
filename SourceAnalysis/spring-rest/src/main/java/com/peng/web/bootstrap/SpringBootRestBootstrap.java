package com.peng.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot Rest ��ͼ������
 * 
 * @author Peng
 * @date:2019��5��16�� ����8:51:05  
 */
@SpringBootApplication(scanBasePackages="com.peng")
public class SpringBootRestBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootstrap.class, args);
    }
}
