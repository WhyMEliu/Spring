package com.peng.web.handler;

import com.peng.web.mvc.Controller;
import com.peng.web.mvc.RequestMapping;
import com.peng.web.mvc.RequestParam;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Authror LP
 * @Date 2019/6/19 17:05
 */
public class HandlerManager {
    //mappingHandler容器
    public static List<MappingHandler> mappingHandlerList = new ArrayList<>();

    //在类加载的时候将符合要求的~requestMapping 放入 容器~
    public static void resolveMappingHandler(List<Class<?>> classList){
        for (Class<?> cls: classList) {
            if(cls.isAnnotationPresent(Controller.class)){
                parseHandlerFromController(cls);
            }
        }
    }

    private static void parseHandlerFromController(Class<?> cls){
        //获取类中的所有方法
        Method[] methods = cls.getDeclaredMethods();
        //判断注解RequestMapping
        for (Method method : methods) {
            if(!method.isAnnotationPresent(RequestMapping.class)){
                continue;
            }
            //获取注解RequestMapping值
            String uri = method.getDeclaredAnnotation(RequestMapping.class).value();
            //获取注解RequestParam值
            List<String> paramNameList = new ArrayList<>();
            for (Parameter parameter:method.getParameters()) {
                if(parameter.isAnnotationPresent(RequestParam.class)){
                    paramNameList.add(parameter.getDeclaredAnnotation(RequestParam.class).value());
                }
            }
            String[] params = paramNameList.toArray(new String[paramNameList.size()]);
            //产生新的MappingHandler
            MappingHandler mappingHandler = new MappingHandler(uri, method, cls, params);
            //放入管理器
            HandlerManager.mappingHandlerList.add(mappingHandler);
        }
    }
}
