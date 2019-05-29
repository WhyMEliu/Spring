package com.peng.springapplication.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

/**
 * After HelloWorld {@link ApplicationListener} 
 * 监听 {@link ContextRefreshedEvent}
 * 
 * @author Peng
 * @date:2019年5月11日 下午11:14:45  
 */
public class AfterHelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent>,Ordered {

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		 System.out.println("AfterHelloWorld : " + event.getApplicationContext().getId()
	                + " , timestamp : " + event.getTimestamp());
	}
	
}
