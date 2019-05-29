package com.peng.springautoconfigure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorld配置
 * 模块化装配
 * @author Peng
 * @date:2019年5月10日 下午10:47:07  
 */
public class HelloWorldConfiguration {
	
	@Bean
	public String helloWorld(){
		return "Hello,World 2018";
	}
}
