package com.concepts.overview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class Initiator {
	
	public static void main(String[] args) {
		
		ConceptsA a = new ConceptsB();
		a.test();
		
		/*Hashtable<Integer, Integer> ht = new Hashtable<>();
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		
		
		
		Map<Integer, Integer> hst = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer key1, Integer key2) {
				return -key1.compareTo(key2);
			}
		});*/
		
		/*String str = "dataD1'";
		System.out.println(str.toLowerCase());*/
		
		    
	}

}

class MyCompare implements Comparator<String>{

	      @Override
	      public int compare(String key1, String key2){
	        return -key1.compareTo(key2);
	      }
	  
}
