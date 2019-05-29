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
 * @date:2019年5月20日 下午4:29:07  
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
		//获取字符编码
		Charset charset = mediaType.getCharset();
		//当charset 不存在的时候，使用UTF-8
		charset = charset == null ? Charset.forName("UTF-8") : charset; 
		//字节输出流
		OutputStream outputStream = outputMessage.getBody();
		//字符输出流
		Writer writer = new OutputStreamWriter(outputStream,charset);
		//properties.写入到字符输出流
		t.store(writer, "0.0.");
	}

	@Override
	protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
        // 字符流 -> 字符编码
        // 从 请求头 Content-Type 解析编码
        HttpHeaders httpHeaders = inputMessage.getHeaders();
        MediaType mediaType = httpHeaders.getContentType();
        // 获取字符编码
        Charset charset = mediaType.getCharset();
        // 当 charset 不存在时，使用 UTF-8
        charset = charset == null ? Charset.forName("UTF-8") : charset;
        // 字节流
        InputStream inputStream = inputMessage.getBody();
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        Properties properties = new Properties();
        // 加载字符流成为 Properties 对象
        properties.load(reader);
        return properties;
	}
	
}
