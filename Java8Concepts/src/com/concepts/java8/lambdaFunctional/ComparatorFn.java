package com.concepts.java8.lambdaFunctional;

import java.util.Comparator;
import java.util.function.Function;

@FunctionalInterface
public interface ComparatorFn<T> {

	public int compare(T t1, T t2);

	public default <U> ComparatorFn<T> thenComparing(ComparatorFn<T> cmp) {
		return (p1,p2) -> compare(p1,p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
	}
	
	
	public default ComparatorFn<T> thenComparing(Function<T, Comparable> f){
		ComparatorFn<T> cmp = comparing(f);
		return thenComparing(cmp);
	}

	/*
	 * public static ComparatorFn<Person> comparing(Function<Person, Integer> f){
	 * 
	 * return (p1,p2) -> f.apply(p1) - f.apply(p2); }
	 */

	public static <U> ComparatorFn<U> comparing(Function<U, Comparable> f) {
		return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
	}

}
