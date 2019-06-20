package com.peng.beans;

import com.peng.web.mvc.Controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Authror LP
 * @Date 2019/6/20 18:04
 */
public class BeanFactory {
    private static Map<Class<?>,Object> classObjectMap = new ConcurrentHashMap<>();

    public static Object getBean(Class<?> cls){
        return classObjectMap.get(cls);
    }

    public static void initBean(List<Class<?>> classList) throws Exception {
        //初始化bean,放入容器~
        List<Class<?>> toCreate = new ArrayList<>(classList);
        while (toCreate.size() != 0){
            int remainSize = toCreate.size();
            for (int i = 0; i < toCreate.size(); i++) {
                if(finishCreate(toCreate.get(i))){
                    toCreate.remove(i);
                }
            }
            if(toCreate.size() == remainSize){
                throw new Exception("cycle dependency");
            }
        }
    }


    private static boolean finishCreate(Class<?> cls) throws IllegalAccessException, InstantiationException {
        if(!cls.isAnnotationPresent(Bean.class) && !cls.isAnnotationPresent(Controller.class)){
            return true;
        }
        //完成创建及类中的对象进行注入~
        Object bean = cls.newInstance();
        for (Field field : cls.getDeclaredFields()) {
            Class<?> fieldType = field.getType();
            Object reliantBean = BeanFactory.getBean(fieldType);
            if(reliantBean == null){
                return false;
            }
            field.setAccessible(true);
            field.set(bean,reliantBean);
        }
        classObjectMap.put(cls,bean);
        return true;
    }

}
