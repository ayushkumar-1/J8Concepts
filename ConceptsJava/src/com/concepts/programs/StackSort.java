package com.concepts.programs;

import java.util.Stack;

public class StackSort {
 
    public static Stack<Integer> sortStack(Stack<Integer> input){
         
        Stack<Integer> tmpStack = new Stack<Integer>();
        System.out.println("=============== debug logs ================");
        while(!input.isEmpty()) {
            int tmp = input.pop();
            System.out.println("Element taken out: "+tmp);
            while(!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                input.push(tmpStack.pop());
            }
            tmpStack.push(tmp);
            System.out.println("input: "+input);
            System.out.println("tmpStack: "+tmpStack);
        }
        System.out.println("=============== debug logs ended ================");
        return tmpStack;
    }
    
    
     
    public static void main(String a[]){
         
        Stack<Integer> input = new Stack<Integer>();
        input.add(2);
        input.add(4);
        input.add(-1);
        input.add(3);
        System.out.println("input: "+input);
        sortStack1(input);
    }
    
    
    private static void sortStack1(Stack<Integer> input){
    	Stack<Integer> stkTemp = new Stack<Integer>();
    	while(!input.isEmpty()) {
    		if(stkTemp.isEmpty() || stkTemp.peek() < input.peek()) {
    			stkTemp.push(input.pop());
    		}
    		else if(stkTemp.peek() > input.peek()) {
    			int temp = stkTemp.pop();
    			stkTemp.push(input.pop());
    			input.push(temp);
    			
    		}
    	}
    	
    	System.out.println(stkTemp);
    }
}
