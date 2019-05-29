package com.peng.springapplication.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * 初始化order顺序
 * 
 * @author Peng
 * @date:2019年5月11日 下午11:10:46  
 */
public class AfterHelloWorldApplicationContextInitializer implements ApplicationContextInitializer,Ordered {

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("After application.id = " + applicationContext.getId());
	}
	
}
