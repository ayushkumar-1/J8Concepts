package com.practice.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsPractice {

	public static void main(String[] args) {
		
		List<Integer> ls = Arrays.asList(1,3,3,4,5,6,8,8,9,0);
		System.out.println("initial: "+ls);
		
		//stream filter based on a criteria
		List<Integer> list = ls.stream().filter(a -> a < 5).collect(Collectors.toList());
		System.out.println("post streams: "+list);
		
		//parallel stream
		List<Integer> listP = ls.parallelStream().filter(a -> a >= 5 && a < 10).sorted().limit(3).collect(Collectors.toList());
		System.out.println("post parallel stream: "+listP);
		
		//forEach
		listP.forEach(a -> System.out.println(a));
		
		//map --> get list of squares
		Set<Integer> sqNums = ls.stream().map(i -> i*i).collect(Collectors.toSet());
		System.out.println("Squares List: "+sqNums);
		
		
		List<String> stringsLs = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

		//get count of empty string
		long count = stringsLs.stream().filter(string -> !string.isEmpty()).count();
		System.out.println(count);
		
		//Stream Statistics
		List numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> (int)x).summaryStatistics();

		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
		
		
		
		
		
	}
	
}
