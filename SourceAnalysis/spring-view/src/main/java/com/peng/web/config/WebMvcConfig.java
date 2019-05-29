package com.peng.web.config;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Spring Web MVC 配置类
 * @author Peng
 * @date:2019年5月16日 下午9:21:28  
 */
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Bean
	public ViewResolver myViewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		//ThymeleafViewResolver Ordered.LOWEST_PRECEDENCE - 5
		viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
		//优先级高于 ThyemleafViewResolver
		//配置ViewResolver的Content-Type
		viewResolver.setContentType("text/xml;charset=UTF-8");
		return viewResolver;
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(true)
				.favorPathExtension(true);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("拦截中...");
                return true;
            }
        });
	}
	
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer(){
		return (factory)->{
			factory.addContextCustomizers((context)->{
				String relativePath = "spring-view/src/main/webapp";
				//相对于user.dir = "D:\workspace\dive-in-spring-boot"
				File docBaseFile = new File(relativePath);
                if(docBaseFile.exists()) { // 路径是否存在
                    // 解决 Maven 多模块 JSP 无法读取的问题
                    context.setDocBase(docBaseFile.getAbsolutePath());
                }
			});
		};
	}
	
	
}
