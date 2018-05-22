package com.concepts.overview;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapComparator {
	 
	
	//Method for sorting the TreeMap based on values
	  public <K, V extends Comparable<V>> Map<K, V> 
	    sortByValues(final Map<K, V> map) {
	    Comparator<K> valueComparator = 
	             new Comparator<K>() {
	      public int compare(K k1, K k2) {
	        int compare = 
	              map.get(k1).compareTo(map.get(k2));
	        if (compare == 0) 
	          return 1;
	        else 
	          return compare;
	      }
	    };
	 
	    Map<K, V> sortedByValues = 
	      new TreeMap<K, V>(valueComparator);
	    sortedByValues.putAll(map);
	    return sortedByValues;
	  }
	
	    public static void main(String a[]){
	        //the treemap sorts by key
	        TreeMap<String, String> hm = new TreeMap<String, String>();//(new MyCopr());
	        //add key-value pair to TreeMap
	        hm.put("java", "language");
	        hm.put("computer", "machine");
	        hm.put("india","country");
	        hm.put("mango","fruit");
	        hm.put("game","cricket");
	        System.out.println("TreeMap Entries:");
	        System.out.println(hm);
	        
	        TreeMapComparator tr = new TreeMapComparator();
	        // Calling the method sortByvalues
	        Map sortedMap = tr.sortByValues(hm);
	        System.out.println(sortedMap);
	        
	        /*Map<String, String> rm = hm.descendingMap();
	        System.out.println("Reverse Map Content: ");
	        System.out.println(rm);*/
	    }
	}
	 
	class MyCopr implements Comparator<String>{
	 
	    @Override
	    public int compare(String str1, String str2) {
	        return -str1.compareTo(str2);
	    }
	     
	}

