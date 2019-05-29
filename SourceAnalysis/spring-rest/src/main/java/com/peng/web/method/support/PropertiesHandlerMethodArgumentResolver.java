package com.peng.web.method.support;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.peng.web.http.converter.properties.PropertiesHttpMessageConverter;

/**
 * {@link Properties 类型} {@link HandlerMethodArgumentResolver}
 * 
 * @author Peng
 * @date:2019年5月20日 下午4:44:54  
 */
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return Properties.class.equals(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		//复用 PropertiesHttpMessageConverter
		PropertiesHttpMessageConverter converter  = new PropertiesHttpMessageConverter();
		ServletWebRequest servletWebRequest = (ServletWebRequest)webRequest;
		//Servlet request API
		HttpServletRequest request = servletWebRequest.getRequest();
		
		HttpInputMessage httpInputMessage = new ServletServerHttpRequest(request);
		
		return converter.read(null, null, httpInputMessage);
	}
	
}
