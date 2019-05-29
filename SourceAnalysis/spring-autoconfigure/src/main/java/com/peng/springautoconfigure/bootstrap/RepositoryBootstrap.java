package com.peng.springautoconfigure.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.peng.springautoconfigure.repository.MyFirstLevelRepository;

/**
 * 仓储的引导类
 * 
 * @author Peng
 * @date:2019年5月10日 下午10:32:49  
 */
@ComponentScan(basePackages = "com.peng.springautoconfigure.repository")
public class RepositoryBootstrap {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
		.web(WebApplicationType.NONE)
		.run(args);
		
		//检查 myFirstLevelRepository 是否存在
		MyFirstLevelRepository myFirstLevelRepository =
				context.getBean("myFirstLevelRepository" , MyFirstLevelRepository.class);
		System.out.println("myFirstLevelRepository Bean:" + myFirstLevelRepository);
		
		context.close();
	}
}	
