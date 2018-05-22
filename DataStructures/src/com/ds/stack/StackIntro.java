package com.ds.stack;

import java.util.HashMap;
import java.util.Stack;

public class StackIntro {

	
	public static void main(String[] args) {
		System.out.println("Hello");
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());

		
		System.out.println(stk.peek());
		System.out.println(stk.search(5));
		System.out.println(test().toString());
		
		HashMap<String, String> hm = new HashMap<>();
	}
	
	public static <E> E test() {
		StackIntro st = new StackIntro();
		return (E) st ;
	}
}
