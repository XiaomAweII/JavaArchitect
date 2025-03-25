package com.roy.clinit;

// 给price添加final关键字，price的初始化过程会提前到编译阶段之前。
class Apple3{
	static Apple3 apple = new Apple3(10);
	final static double price = 20.00;
	double totalpay;
	
	public Apple3 (double discount) {
		System.out.println("===="+price);
		totalpay = price - discount;
	}
}

public class PriceTest3 {

	public static void main(String[] args) {
		System.out.println(Apple3.apple.totalpay);
	}

}
