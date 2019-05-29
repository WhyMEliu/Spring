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
 * @date:2019年5月20日 下午5:09:39  
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {
	
	@Autowired
	private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
	
	@PostConstruct
	public void init(){
		//获取当前 RequestMappingHandlerAdapter 所有的 Resolver对象
		List<HandlerMethodArgumentResolver> resolver = requestMappingHandlerAdapter.getArgumentResolvers();
		List<HandlerMethodArgumentResolver> newResolvers = new ArrayList<>();
		//添加 propertiesHandlerMethodArgumentResolver 到集合首位
		newResolvers.add(new PropertiesHandlerMethodArgumentResolver());
		//添加已经注册Resolver 对象集合
		newResolvers.addAll(resolver);
		//重新设置Resolver对象集合
		requestMappingHandlerAdapter.setArgumentResolvers(newResolvers);
		
		//获取当前 HandlerMethodReturnValueHandler 所有Handler对象
		List<HandlerMethodReturnValueHandler> handlers = requestMappingHandlerAdapter.getReturnValueHandlers();
		List<HandlerMethodReturnValueHandler> newHandlers = new ArrayList<>();
		//添加 ProperthiesHandlerMethodReturnValueHandler 到集合首位
		newHandlers.add(new PropertiesHandlerMethodReturnValueHandler());
		//添加已经注册的Handler 对象集合
		newHandlers.addAll(handlers);
		//重新设置handler 对象集合
		requestMappingHandlerAdapter.setReturnValueHandlers(newHandlers);
	}
	
	public void addCorsMappings(CorsRegistry registry){
		registry.addMapping("/**").allowedOrigins("*");
	}
	
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        // 添加 PropertiesHandlerMethodArgumentResolver 到集合首位
        // 添加自定义 HandlerMethodArgumentResolver，优先级低于内建 HandlerMethodArgumentResolver
//        if (resolvers.isEmpty()) {
//            resolvers.add(new PropertiesHandlerMethodArgumentResolver());
//        } else {
//            resolvers.set(0, new PropertiesHandlerMethodArgumentResolver());
//        }

    }

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 不建议添加到 converters 的末尾
//        converters.add(new PropertiesHttpMessageConverter());
//        converters.set(0, new PropertiesHttpMessageConverter()); // 添加到集合首位
    }
	
}
