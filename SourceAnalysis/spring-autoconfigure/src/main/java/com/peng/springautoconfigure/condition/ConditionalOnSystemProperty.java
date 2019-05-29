package com.peng.springautoconfigure.condition;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

/**
 * Java 系统属性 条件判断
 * 
 * @author Peng
 * @date:2019年5月10日 下午11:22:06  
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
	/**
	 * java 系统属性名称
	 * @return
	 */
	String name();
	
	/**
	 * java 系统属性值
	 * @return
	 */
	String value();
	
}
