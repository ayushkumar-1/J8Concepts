package com.practice.methodref;

import java.util.ArrayList;
import java.util.List;

public class MethodRefPractice {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("Hey");
		list.add("Jude");
		list.add(",");
		list.add("Kahan");
		list.add("ho?");
		
		list.forEach(System.out::println);
	}

	

}
