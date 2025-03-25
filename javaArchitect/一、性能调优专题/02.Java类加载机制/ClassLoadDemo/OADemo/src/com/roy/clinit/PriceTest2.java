package com.roy.clinit;

//把 price 提前
// 当执行构造函数时，price 已经完成了初始化。
class Apple2{
	static double price = 20.00;
	static Apple2 apple = new Apple2(10);
	double totalpay;
	
	public Apple2 (double discount) {
		System.out.println("===="+price);
		totalpay = price - discount;
	}
}

public class PriceTest2 {

	public static void main(String[] args) {
		System.out.println(Apple2.apple.totalpay);
	}

}
