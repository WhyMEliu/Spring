package com.peng.springapplication;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@link SpringApplication} 引导类
 * @author Peng
 * @date:2019年5月11日 下午10:55:35  
 */

public class SpringApplicationBootstrap {
	
	public static void main(String[] args) {
		//SpringApplication.run(SpringApplicationBootstrap.class, args);
	
		Set<String> sources = new HashSet();
		//配置Class 名称
		sources.add(ApplicationConfiguration.class.getName());
		SpringApplication springApplication = new SpringApplication();
		springApplication.setSources(sources);
		springApplication.run(args);
	}
	
	@SpringBootApplication
	public static class ApplicationConfiguration {
		
	}
}
