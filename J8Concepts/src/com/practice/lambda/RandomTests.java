package com.practice.lambda;

import java.util.Date;

public class RandomTests {

	static String msg = "Final Call";
	public static void main(String[] args) {
		TestingRandoms tr = () -> {return new Date();};
		
		tr.test();
		TestingRandoms.test2();
		
		System.out.println("Date: "+tr.todayDate());
		msg = "Hello ";
		MessageRead mr = (msg1) -> System.out.println(msg + msg1);
		mr.readMsg("Charlie");
	}
	
	
}

@FunctionalInterface
interface TestingRandoms {
	Date todayDate();
	
	default void test() {
		System.out.println("default method");
	}
	
	static void test2() {
		System.out.println("static method");
	}
}

interface MessageRead {
	void readMsg(String msg);
}
