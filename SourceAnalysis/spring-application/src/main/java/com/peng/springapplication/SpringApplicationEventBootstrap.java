package com.peng.springapplication;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring 应用事件引导类
 * 
 * @author Peng
 * @date:2019年5月11日 下午11:32:13  
 */
public class SpringApplicationEventBootstrap {
	
	public static void main(String[] args) {
		//创建上下文
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		//注册应用事件监听器
		context.addApplicationListener(event ->{
			System.out.println("监听到事件：" + event);
		});
		
		//启动上下文
		context.refresh();
		//发送事件
		context.publishEvent("HelloWorld");
		context.publishEvent("2180");
		context.publishEvent(new ApplicationEvent("小马哥") {
			
		});
		
		//关闭上下文
		context.close();
	}
}
