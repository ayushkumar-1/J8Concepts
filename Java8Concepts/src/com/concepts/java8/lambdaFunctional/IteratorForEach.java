package com.concepts.java8.lambdaFunctional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class IteratorForEach {
	
	public static void main(String[] args) {
	
		//create a List
		List<Integer> myList = new ArrayList<Integer>();
		//adding data
		for(int i = 0; i < 10; i++) {
			myList.add(i);
		}
		
		//forEach
		//traversing through forEach method of Iterable with anonymous class
		
		Iterable itr;
		
		myList.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer i) {
				System.out.println("consumer impl val: "+i);
				
			}
		});
		
		MyConsumer myAction = new MyConsumer();
		myList.forEach(myAction);
			
	}
	

}

class MyConsumer implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.println("MyConsumer val: "+t);
		
	}
	
	
}
