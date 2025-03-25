package com.roy.oa;

import java.net.URL;
import java.net.URLClassLoader;

public class OADemo2 {
    public static void main(String[] args) throws Exception {
        Double salary = 15000.00;
        Double money = 0.00;

        URL jarPath = new URL("file:/Users/roykingw/DevCode/ClassLoadDemo/out/artifacts/SalaryCaler_jar/SalaryCaler.jar");
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {jarPath});

        //模拟不停机状态
        while (true) {
            try {
                money = calSalary(salary,urlClassLoader);
                System.out.println("实际到手Money:" + money);
            }catch(Exception e) {
                e.printStackTrace();
                System.out.println("加载出现异常 ："+e.getMessage());
            }
            Thread.sleep(5000);
        }
    }

    private static Double calSalary(Double salary,ClassLoader classloader) throws Exception {
        Class<?> clazz = classloader.loadClass("com.roy.oa.SalaryCaler");
        if(null != clazz) {
            Object object = clazz.newInstance();
            return (Double)clazz.getMethod("cal", Double.class).invoke(object, salary);
        }
        return -1.00;
    }
}
