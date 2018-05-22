package com.ds.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InitiatorForTest {
	
	public static void main(String[] args) {
		
		String str1 = new String("Ayush");
		String str = "Ayush";
		System.out.println(str1.hashCode());
		System.out.println(str.hashCode());
		if(str1 == str) {
			System.out.println("true");
		}
		
		BasicLinkedList<String> list = new BasicLinkedList<>();
		//Add
		list.add("Hi");
		list.add("System");
		list.add("Data");
		System.out.println(list);
		
		//Remove
		list.remove();
		System.out.println(list);
		list.add("is");
		list.add("secured");
		System.out.println(list);
		
		//RemoveAt
		list.removeAt(3);
		System.out.println(list);
		
		//Insert
		list.insert("not", 3);
		System.out.println(list);
		
		//size
		System.out.println(list.size());
		
		//get
		System.out.println(list.get(0));
		
		//find
		System.out.println(list.find("System"));
		
		
		//For Performance Check
		int countOfData = 10;
		for(CountOfData count: CountOfData.values()) {
			checkPerformance(count.getValue());
		}
	}
	
	private static void checkPerformance(int count) {
		
		System.out.println("Number of Records: "+count);
		BasicLinkedList<Integer> customList = new BasicLinkedList<>();
		List<Integer> originalList = new LinkedList<>();
		originalList.add(1);
		System.out.println("Stream: "+originalList.stream());
		
		if (false) {
			// adding
			System.out.println("Adding data in custom List");
			long startTime = System.nanoTime();
			for (int i = 0; i < count; i++) {
				customList.add(i);
			}
			System.out.println(
					"Time taken to add " + count + " records in Custom List - " + (System.nanoTime() - startTime));

			System.out.println("Adding data in original List");
			startTime = System.nanoTime();
			for (int i = 0; i < count; i++) {
				originalList.add(i);
			}
			System.out.println(
					"Time taken to add " + count + " records  in Original List - " + (System.nanoTime() - startTime));

			// Get
			System.out.println("Find data in custom List");
			startTime = System.nanoTime();
			int position = count / 2;
			customList.get(position);
			System.out.println("Time taken to get " + position + "th record from Custom List - "
					+ (System.nanoTime() - startTime));

			System.out.println("Find data in original List");
			startTime = System.nanoTime();
			originalList.get(position);
			System.out.println("Time taken to get " + position + "th record from Original List - "
					+ (System.nanoTime() - startTime));

			// Remove
			System.out.println("Removing data in custom List");
			startTime = System.nanoTime();
			for (int i = 0; i < count; i++) {
				customList.remove();
			}
			System.out.println("Time taken to remove all records in Custom List with " + count + " records - "
					+ (System.nanoTime() - startTime));

			System.out.println("Removing data in original List");
			startTime = System.nanoTime();
			for (int i = 0; i < count; i++) {
				originalList.add(i);
			}
			System.out.println("Time taken to remove all records in Original List with " + count + " records - "
					+ (System.nanoTime() - startTime));
		}
		
	}

	enum TestCategory{
		LIST, STACK, QUEUE
	}
	
	enum CountOfData{
		TEN(10), HUNDRED(100), THOUSAND(1000), TEN_THOUSAND(10000), LAKH(100000), MILLION(1000000);
		
		private final int value;
		
		CountOfData(final int newValue){
			value = newValue;
		}
		
		public int getValue() {
			return value;
		}
	}

}
