package com.peng.springautoconfigure.condition;

import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 系统属性条件判断
 * 
 * @author Peng
 * @date:2019年5月10日 下午11:23:33  
 */
public class OnSystemPropertyCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
		
		String propertyName = String.valueOf(attributes.get("name"));
		
		String propertyValue = String.valueOf(attributes.get("value"));
		
		String javaPropertyValue = System.getProperty(propertyName);
		
		return propertyValue.equals(javaPropertyValue);
	}
	
}
