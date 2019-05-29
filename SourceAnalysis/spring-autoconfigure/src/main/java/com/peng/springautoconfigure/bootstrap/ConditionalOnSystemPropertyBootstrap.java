package com.peng.springautoconfigure.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.peng.springautoconfigure.condition.ConditionalOnSystemProperty;

/**
 * 系统属性引导类
 * 
 * @author Peng
 * @date:2019年5月10日 下午11:34:04  
 */
public class ConditionalOnSystemPropertyBootstrap {

	@Bean
	@ConditionalOnSystemProperty(name = "user.name", value = "Mercy")
	public String helloWorld(){
		return "Hello,World ~";
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
				.web(WebApplicationType.NONE)
				.run(args);
		// 通过名称和类型获取 helloWorld Bean
        String helloWorld = context.getBean("helloWorld", String.class);

        System.out.println("helloWorld Bean : " + helloWorld);

        // 关闭上下文
        context.close();
	}
}
