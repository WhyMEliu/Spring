package com.peng.springautoconfigure.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.peng.springautoconfigure.service.CalculateService;

/**
 * profiles配置~ 
 * 
 * @author Peng
 * @date:2019年5月10日 下午11:12:25  
 */
@SpringBootApplication(scanBasePackages = "com.peng.springautoconfigure.service")
public class CalculateServiceBootstrap {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
				.web(WebApplicationType.NONE)
				.profiles("Java8")
				.run(args);
		
		CalculateService calculateService = context.getBean(CalculateService.class);
		System.out.println("calculateService :" + calculateService.sum(0));
		
		context.close();
	}
}
