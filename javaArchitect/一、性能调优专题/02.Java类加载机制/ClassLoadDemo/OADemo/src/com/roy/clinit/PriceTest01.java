package com.roy.clinit;


//Apple.apple访问了类的静态变量，会出发类的初始化，即加载-》连接-》初始化
//当执行构造函数时，price还没有初始化完成，处于连接阶段的准备阶段，其值为默认值 0，这时构造函数的 price 就是
class Apple{
    static Apple apple = new Apple(10);
    static double price = 20.00;
    double totalpay;

    public Apple (double discount) {
        System.out.println("===="+price);
        totalpay = price - discount;
    }
}
public class PriceTest01 {
    public static void main(String[] args) {
        System.out.println(Apple.apple.totalpay);
    }
}
