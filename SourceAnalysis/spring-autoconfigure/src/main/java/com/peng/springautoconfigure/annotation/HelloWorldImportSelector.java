package com.peng.springautoconfigure.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.peng.springautoconfigure.configuration.HelloWorldConfiguration;

/**
 * 模块装配~中间加了一重选择~
 * 更加具有弹性
 * 
 * @author Peng
 * @date:2019年5月10日 下午10:54:38  
 */
public class HelloWorldImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		System.out.println("----------------666666------");
		return new String [] {HelloWorldConfiguration.class.getName()};
	}
	
}
