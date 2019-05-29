package com.peng.springapplication;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring 应用上下文引导
 * 
 * @author Peng
 * @date:2019年5月11日 下午11:24:43  
 */
@SpringBootApplication
public class SpringApplicationContextBootstrap {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
				//.web(WebApplicationType.NONE)
				.run(args);
		
		 System.out.println("ConfigurableApplicationContext 类型：" + context.getClass().getName());
	     System.out.println("Environment 类型：" + context.getEnvironment().getClass().getName());
	     
	     context.close();
	}
}
