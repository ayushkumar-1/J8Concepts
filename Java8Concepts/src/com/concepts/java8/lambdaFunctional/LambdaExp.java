package com.concepts.java8.lambdaFunctional;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;

public class LambdaExp {
	/**
	 * Syntax: (arguments) -> {body}
	 */
	public static void main(String[] args) {

		//new Thread(() -> System.out.println("test")).start();
		/*int i = 4;
		int j = 7;*/
		String str = "Hello";
        System.out.println(str.charAt(0));
        StringBuilder strBuild = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++) {
        	strBuild.append(str.charAt(i)).append(str.charAt(i));
        }
        
        System.out.println(strBuild.toString());
        
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(2);
        
        Iterator<Integer> iterator = list.iterator();
        
        while(iterator.hasNext()) {
        	System.out.println(iterator.next());;
        }
        
        Enumeration<Integer> enm = Collections.enumeration(list2);
        
        while(enm.hasMoreElements()) {
        	System.out.println("Data: "+enm.nextElement());
        }
        
        
        Spliterator<Integer> dataSplit = list.spliterator();
        
        dataSplit.forEachRemaining(System.out::println);
                               
		//int data = calculate(i,j, (i,j) -> return (i+j););
		
		
	}
	
	static int calculate(int i, int j, Test t) {
		return t.testFunctional(i, j);
	}
	
}

interface Test{
	 int testFunctional(int i, int j);
}

interface BinaryOperator<T> {
    T apply(T left, T right);
}

class LambdaExpressEx {
	 
    public static void main(String a[]){
         
        int i = 10;
        int j = 5;
         String str = "Hello";
         System.out.println(str.charAt(0));
       /* int sum = calculate(i, j, (i,j) -> {return (i+j);} );
        System.out.println("Sum:"+sum);
        int sub = calculate(i, j, (i,j) -> {return (i-j);} );
        System.out.println("Subtraction:"+sub);*/
    }
     
    public static int calculate(int i, int j, BinaryOperator<Integer> bo){
         
        return bo.apply(i, j);
    }
}