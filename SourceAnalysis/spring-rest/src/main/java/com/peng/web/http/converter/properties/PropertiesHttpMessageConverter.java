package com.peng.web.http.converter.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;


/**
 * {@link Properties} {@link HttpMessageConverter}
 * 
 * @author Peng
 * @date:2019��5��20�� ����4:29:07  
 */
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {

	@Override
	public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		return readInternal(null,inputMessage);
	}

	@Override
	protected void writeInternal(Properties t, Type type, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		//Properties ->String
		//OutputStream -> Writer
		HttpHeaders httpHeaders = outputMessage.getHeaders();
		MediaType mediaType = httpHeaders.getContentType();
		//��ȡ�ַ�����
		Charset charset = mediaType.getCharset();
		//��charset �����ڵ�ʱ��ʹ��UTF-8
		charset = charset == null ? Charset.forName("UTF-8") : charset; 
		//�ֽ������
		OutputStream outputStream = outputMessage.getBody();
		//�ַ������
		Writer writer = new OutputStreamWriter(outputStream,charset);
		//properties.д�뵽�ַ������
		t.store(writer, "0.0.");
	}

	@Override
	protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
        // �ַ��� -> �ַ�����
        // �� ����ͷ Content-Type ��������
        HttpHeaders httpHeaders = inputMessage.getHeaders();
        MediaType mediaType = httpHeaders.getContentType();
        // ��ȡ�ַ�����
        Charset charset = mediaType.getCharset();
        // �� charset ������ʱ��ʹ�� UTF-8
        charset = charset == null ? Charset.forName("UTF-8") : charset;
        // �ֽ���
        InputStream inputStream = inputMessage.getBody();
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        Properties properties = new Properties();
        // �����ַ�����Ϊ Properties ����
        properties.load(reader);
        return properties;
	}
	
}
