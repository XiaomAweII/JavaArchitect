package com.roy.cl;

/**
 * @author xiaoweii
 * @create 2025-03-27 23:46
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl1 = Test.class.getClassLoader();
        cl1.loadClass("com.roy.cl.LoaderDemo");// 没有链接的过程（记得放开static静态代码块验证）
        System.out.println("------");
        Class.forName("com.roy.cl.LoaderDemo");
    }
}
