package com.roy.cl;

public class LoaderDemo {
    public static String a = "aaa";

    /*static {
        System.out.println("Hello World");
    }*/

    public static void main(String[] args) throws ClassNotFoundException {
        // 父子关系 AppClassLoader <- ExtClassLoader <- BootStrap Classloader
        ClassLoader cl1 = LoaderDemo.class.getClassLoader();
        System.out.println("cl1 > " + cl1);

        System.out.println();

        System.out.println("parent of cl1 > " + cl1.getParent());

        System.out.println();

        // BootStrap Classloader由C++开发，是JVM虚拟机的一部分，本身不是JAVA类。
        System.out.println("grant parent of cl1 > " + cl1.getParent().getParent());

        System.out.println();

        // String,Int等基础类由BootStrap Classloader加载。
        ClassLoader cl2 = String.class.getClassLoader();
        System.out.println("cl2 > " + cl2);
        System.out.println(cl1.loadClass("java.util.List").getClass().getClassLoader());

        System.out.println();

        // java指令可以通过增加-verbose:class -verbose:gc 参数在启动时打印出类加载情况
        // BootStrap Classloader，加载java基础类。这个属性不能在java指令中指定，推断不是由java语言处理。。
        System.out.println("BootStrap ClassLoader加载目录：" + System.getProperty("sun.boot.class.path"));

        System.out.println();

        // Extention Classloader 加载JAVA_HOME/ext下的jar包。 可通过-D java.ext.dirs另行指定目录
        System.out.println("Extention ClassLoader加载目录：" + System.getProperty("java.ext.dirs"));

        System.out.println();

        // 项目的一些代码
        // AppClassLoader 加载CLASSPATH，应用下的Jar包。可通过-D java.class.path另行指定目录
        System.out.println("AppClassLoader加载目录：" + System.getProperty("java.class.path"));
    }
}
