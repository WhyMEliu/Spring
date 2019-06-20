package com.peng.core;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @Authror LP
 * @Date 2019/6/19 15:44
 */
public class ClassScanner {
    public static List<Class<?>> scanClass(String packageName) throws IOException, ClassNotFoundException {
        List<Class<?>> classList = new ArrayList<>();
        //类路径，替换为文件路径
        String path = packageName.replace(".","/");
        //获取当前应用的类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //加载指定的数据
        Enumeration<URL> resoures = classLoader.getResources(path);
        while(resoures.hasMoreElements()){
            URL resource = resoures.nextElement();
            //只展示jar包加载
            if(resource.getProtocol().contains("jar")){
                //获取jar流链接
                JarURLConnection jarURLConnection = (JarURLConnection) resource.openConnection();
                //获取jar地址
                String jarFilePath = jarURLConnection.getJarFile().getName();
                //获取实例
                classList.addAll(getClassesFromJar(jarFilePath,path));
            }else{

            }
        }
        return classList;
    }

    private static List<Class<?>> getClassesFromJar(String jarFilePath, String path) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        //利用jar路径获取文件
        JarFile jarFile = new JarFile(jarFilePath);
        //遍历单个文件
        Enumeration<JarEntry> jarEntries = jarFile.entries();
        while(jarEntries.hasMoreElements()){
            JarEntry jarEntry =  jarEntries.nextElement();
            String entryName = jarEntry.getName();
            //利用名字区分是否是我们需要的字节码文件
            if(entryName.startsWith(path) && entryName.endsWith(".class")){
                String classFullName = entryName.replace("/" , ".")
                        .substring(0,entryName.length() - 6);
                //利用反射获取实例
                classes.add(Class.forName(classFullName));
            }
        }
        return classes;
    }

}
