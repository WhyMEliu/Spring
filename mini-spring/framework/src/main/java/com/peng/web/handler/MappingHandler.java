package com.peng.web.handler;

import com.peng.beans.Bean;
import com.peng.beans.BeanFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Authror LP
 * @Date 2019/6/19 17:06
 */
public class MappingHandler {
    private String uri;
    private Method method;
    private Class<?> controller;
    private String[] args;

    public boolean handle(ServletRequest req, ServletResponse res) throws IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        //获取请求的uri与当前MappingHandler 做对比~ 正确则继续进行
        String requestUri = ((HttpServletRequest)req).getRequestURI();
        if(!uri.equals(requestUri)){
            return false;
        }
        //将请求的数据字段数据放入
        Object[] parameters = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            parameters[i] = req.getParameter(args[i]);
        }

        //进类方法调用
        Object ctl = BeanFactory.getBean(controller);
        Object response = method.invoke(ctl,parameters);
        //返回
        res.getWriter().println(response.toString());
        return true;
    }

    MappingHandler(String uri, Method method, Class<?> controller, String[] args) {
        this.uri = uri;
        this.method = method;
        this.controller = controller;
        this.args = args;
    }

}
