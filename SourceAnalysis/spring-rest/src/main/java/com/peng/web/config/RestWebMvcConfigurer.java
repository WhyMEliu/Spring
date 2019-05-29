package com.peng.web.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.peng.web.method.support.PropertiesHandlerMethodArgumentResolver;
import com.peng.web.method.support.PropertiesHandlerMethodReturnValueHandler;

/**
 * @author Peng
 * @date:2019��5��20�� ����5:09:39  
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {
	
	@Autowired
	private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
	
	@PostConstruct
	public void init(){
		//��ȡ��ǰ RequestMappingHandlerAdapter ���е� Resolver����
		List<HandlerMethodArgumentResolver> resolver = requestMappingHandlerAdapter.getArgumentResolvers();
		List<HandlerMethodArgumentResolver> newResolvers = new ArrayList<>();
		//��� propertiesHandlerMethodArgumentResolver ��������λ
		newResolvers.add(new PropertiesHandlerMethodArgumentResolver());
		//����Ѿ�ע��Resolver ���󼯺�
		newResolvers.addAll(resolver);
		//��������Resolver���󼯺�
		requestMappingHandlerAdapter.setArgumentResolvers(newResolvers);
		
		//��ȡ��ǰ HandlerMethodReturnValueHandler ����Handler����
		List<HandlerMethodReturnValueHandler> handlers = requestMappingHandlerAdapter.getReturnValueHandlers();
		List<HandlerMethodReturnValueHandler> newHandlers = new ArrayList<>();
		//��� ProperthiesHandlerMethodReturnValueHandler ��������λ
		newHandlers.add(new PropertiesHandlerMethodReturnValueHandler());
		//����Ѿ�ע���Handler ���󼯺�
		newHandlers.addAll(handlers);
		//��������handler ���󼯺�
		requestMappingHandlerAdapter.setReturnValueHandlers(newHandlers);
	}
	
	public void addCorsMappings(CorsRegistry registry){
		registry.addMapping("/**").allowedOrigins("*");
	}
	
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        // ��� PropertiesHandlerMethodArgumentResolver ��������λ
        // ����Զ��� HandlerMethodArgumentResolver�����ȼ������ڽ� HandlerMethodArgumentResolver
//        if (resolvers.isEmpty()) {
//            resolvers.add(new PropertiesHandlerMethodArgumentResolver());
//        } else {
//            resolvers.set(0, new PropertiesHandlerMethodArgumentResolver());
//        }

    }

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // ��������ӵ� converters ��ĩβ
//        converters.add(new PropertiesHttpMessageConverter());
//        converters.set(0, new PropertiesHttpMessageConverter()); // ��ӵ�������λ
    }
	
}
