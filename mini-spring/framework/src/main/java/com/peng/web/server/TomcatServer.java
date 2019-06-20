package com.peng.web.server;

import com.peng.web.servlet.DispatcherServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * @Authror LP
 * @Date 2019/6/18 17:42
 */
public class TomcatServer {

    private Tomcat tomcat;
    private String[] arg;

    public TomcatServer(String[] arg) {
        this.arg = arg;
    }

    public void startServer() throws LifecycleException {
        //创建tomcat
        tomcat = new Tomcat();
        tomcat.setPort(6699);
        tomcat.start();

        //创建context容器
        Context context = new StandardContext();
        context.setPath("");
        //使用默认的监听器
        context.addLifecycleListener(new Tomcat.FixContextListener());
        //将我们写的servlet放入容器内
        DispatcherServlet servlet = new DispatcherServlet();
        Tomcat.addServlet(context,"DispatcherServlet",servlet).setAsyncSupported(true);
        //进行映射（全部）
        context.addServletMappingDecoded("/","DispatcherServlet");
        //将容器放入host中
        tomcat.getHost().addChild(context);

        //将Tomcat挂起~
        Thread awaitThread = new Thread("tomcat_await_thread"){
            @Override
            public void run() {
                TomcatServer.this.tomcat.getServer().await();
            }
        };

        awaitThread.setDaemon(false);
        awaitThread.start();
    }
}
