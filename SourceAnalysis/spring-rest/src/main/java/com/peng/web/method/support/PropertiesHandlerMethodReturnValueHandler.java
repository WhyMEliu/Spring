package com.peng.web.method.support;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.peng.web.http.converter.properties.PropertiesHttpMessageConverter;

/**
 * {@link Properties} {@link HandlerMethodReturnValueHandler}
 * 
 * @author Peng
 * @date:2019��5��20�� ����5:01:33  
 */

public class PropertiesHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		//�жϷ����ķ������ͣ��Ƿ���Properties ����ƥ��
		return Properties.class.equals(returnType.getMethod().getReturnType());
	}

	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest) throws Exception {
		//ǿ��ת��
		Properties properties = (Properties) returnValue;
		//���� PropertiesHttpMessageConverter
		PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();
		
		ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
	    // Servlet Request API
        HttpServletRequest request = servletWebRequest.getRequest();
        String contentType = request.getHeader("Content-Type");
        // ��ȡ����ͷ Content-Type �е�ý������
        MediaType mediaType = MediaType.parseMediaType(contentType);

        // ��ȡ Servlet Response ����
        HttpServletResponse response = servletWebRequest.getResponse();
        HttpOutputMessage message = new ServletServerHttpResponse(response);
        // ͨ�� PropertiesHttpMessageConverter ���
        converter.write(properties, mediaType, message);
        // ��֪ Spring Web MVC ��ǰ�����Ѿ��������
        mavContainer.setRequestHandled(true);
	}
	
}
