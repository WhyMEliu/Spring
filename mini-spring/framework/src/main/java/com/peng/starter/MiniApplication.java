package com.peng.starter;

import com.peng.beans.BeanFactory;
import com.peng.core.ClassScanner;
import com.peng.web.handler.HandlerManager;
import com.peng.web.server.TomcatServer;

import java.util.List;

/**
 * @Authror LP
 * @Date 2019/6/18 17:23
 */
public class MiniApplication {

    public static void run(Class<?> cls, String[] args){
        System.out.println("Hello mini-spring~");
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            tomcatServer.startServer();
            List<Class<?>> classList = ClassScanner.scanClass(cls.getPackage().getName());
            BeanFactory.initBean(classList);
            HandlerManager.resolveMappingHandler(classList);
            classList.forEach(a->{
                System.out.println(a.getName());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
