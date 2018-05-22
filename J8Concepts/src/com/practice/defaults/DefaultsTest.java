package com.practice.defaults;

public class DefaultsTest implements Test1, Test2{

	public static void main(String[] args) {
		DefaultsTest dt = new DefaultsTest();
		dt.m1();
	}

/*	@Override
	public void m1() {
		// TODO Auto-generated method stub
		Test1.super.m1();
	}*/

	public void m1() {
		System.out.println("m1 in DefaultsTest");
		Test1.super.m1();
		Test2.super.m1();
	}
	
}

interface Test1{
	
	default void m1() {
		System.out.println("m1 in Test1");
	}
}

interface Test2{
	
	default void m1() {
		System.out.println("m1 in Test2");
	}
}
