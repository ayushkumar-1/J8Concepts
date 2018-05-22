package com.ds.stack;

public class InitiatorStackTest {
	
	public static void main(String[] args) {
		
		BasicStack<Integer> stack = new BasicStack<>();
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack);
		System.out.println(stack.size());
		System.out.println(stack.pop());
/*		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());*/

		System.out.println(stack);
		System.out.println(stack.size());
		
		System.out.println(stack.contains(2));
		System.out.println(stack.contains(4));
		
	}

}
