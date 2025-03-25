package com.roy;

import com.roy.oa.SalaryCalService;
import com.roy.oa.SalaryJARLoader;
import com.roy.oa.SalaryJARLoader6;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ServiceLoader;

public class SPITest {
    public static void main(String[] args) throws  Exception{
        URL jarPath = new URL("file:/Users/roykingw/DevCode/ClassLoadDemo/out/artifacts/SalaryCaler_jar/SalaryCaler.jar");
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {jarPath});
        //自己实现的这个类加载器，只能读取 OADemo 中的 SPI 配置文件，无法读取 Jar 包中的 SPI 配置文件
        SalaryJARLoader6 salaryJARLoader = new SalaryJARLoader6("/Users/roykingw/lib/SalaryCaler.jar");
//        ServiceLoader<SalaryCalService> services = ServiceLoader.load(SalaryCalService.class,salaryJARLoader);
        //换成 JDK 中的 URLClassLoader，就可以读取 Jar 包中的 SPI 配置文件。具体实现上还是有差距。
        ServiceLoader<SalaryCalService> services = ServiceLoader.load(SalaryCalService.class,urlClassLoader);
        for (SalaryCalService service : services) {
            System.out.println(service.cal(10000.00));
        }
        System.out.println("====================================");
        SalaryJARLoader loader = new SalaryJARLoader("/Users/roykingw/lib/SalaryCaler.jar");
        ServiceLoader<SalaryCalService> s = ServiceLoader.load(SalaryCalService.class,loader);
        for (SalaryCalService service : s) {
            System.out.println(service.cal(10000.00));
        }
        System.out.println("====================================");

        Class<?> aClass = salaryJARLoader.loadClass("com.roy.oa.SalaryCaler");
        Object o = aClass.newInstance();
        System.out.println(aClass.getMethod("cal", Double.class).invoke(o, 10000.00));

        System.out.println("====================================");
        Class<?> aClass1 = salaryJARLoader.loadClass("com.roy.oa.impl.SalaryCalServiceImpl");
        Object o1 = aClass1.newInstance();
        System.out.println(aClass1.getMethod("cal", Double.class).invoke(o1, 10000.00));
    }
}
