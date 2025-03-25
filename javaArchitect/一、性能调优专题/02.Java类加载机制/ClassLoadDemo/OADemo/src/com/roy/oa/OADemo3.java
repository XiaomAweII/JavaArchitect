package com.roy.oa;

public class OADemo3 {
    public static void main(String[] args) throws Exception {
        Double salary = 15000.00;
        Double money = 0.00;
        SalaryClassLoader salaryClassLoader = new SalaryClassLoader("/Users/roykingw/DevCode/ClassLoadDemo/out/production/SalaryCaler/");

        //模拟不停机状态
        while (true) {
            try {
                money = calSalary(salary,salaryClassLoader);
                System.out.println("实际到手Money:" + money);
            }catch(Exception e) {
                System.out.println("加载出现异常 ："+e.getMessage());
                System.exit(-1);
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
