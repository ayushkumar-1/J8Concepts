package com.practice.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
	
	public static void main(String[] args) {
		
	List<Integer> ls = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
	
	System.out.println("even");
	eval(ls, n -> n%2 == 0);
	
	System.out.println("odd");
	eval(ls, n -> n%2 != 0);
	
	System.out.println("number greater than 3");
	eval(ls, n -> n > 3);
	
	}
	
	private static void eval(List<Integer> ls, Predicate<Integer> pred) {
		
		
		for (Integer integer : ls) {
			if(pred.test(integer)) {
				System.out.println(integer + " ");
			}
		}
	}

}
