package com.peng.springautoconfigure.configuration;

import org.springframework.context.annotation.Configuration;

import com.peng.springautoconfigure.annotation.EnableHelloWorld;
import com.peng.springautoconfigure.condition.ConditionalOnSystemProperty;

/**
 * spring boot 自动装配~
 * 其实就是结合模式注解装配，模块装配，条件装配
 * 
 * @author Peng
 * @date:2019年5月10日 下午11:49:07  
 */
@Configuration // Spring 模式注解装配
@EnableHelloWorld // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "peng") // 条件装配
public class HelloWorldAutoConfiguration {
	
}
