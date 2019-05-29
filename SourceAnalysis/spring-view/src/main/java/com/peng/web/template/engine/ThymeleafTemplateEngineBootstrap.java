package com.peng.web.template.engine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * Thymeleaf ģ������������
 * 
 * @author Peng
 * @date:2019��5��16�� ����8:56:42  
 */
public class ThymeleafTemplateEngineBootstrap {
	public static void main(String[] args) throws IOException {
		//��������
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		//������Ⱦ������
		Context context = new Context();
		context.setVariable("message", "Hello,World");
		//��ȡ���ݴ� classpath:/templates/thymeleaf/hello-world.html
		//ResourceLoader
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		//ͨ�� classpath:/templates/thymeleaf/hello-world.html Resource
		Resource resource = resourceLoader.getResource("classpath:/templates/thymeleaf/hello-world.html");
		File templateFile = resource.getFile();
		//�ļ���
		FileInputStream inputStream = new FileInputStream(templateFile);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		//Copy
		IOUtils.copy(inputStream, outputStream);

		inputStream.close();
		//ģ�������
		String content = outputStream.toString("UTF-8");
		//��Ⱦ���������
		String result = templateEngine.process(content, context);
		//�����Ⱦ���
		System.out.println(result);
	}
}
