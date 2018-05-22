package com.concepts.overview;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
	
	public static void main(String[] args) {
		
		String str = "ayu";
		System.out.println(str.substring(0,0));
		List<String> list = new ArrayList<>();
		//findAnagrams(str);
		//permutation(str);
	}

	private static void findAnagrams(String str) {
		
		List<String> list = new ArrayList<>();
		char[] array = str.toCharArray();
		String str1 = new String("aa");
		for(int i = 0; i < array.length;i++) {
			StringBuilder strBuild = new StringBuilder();
			strBuild.append(array[i]);
			for(int j = 0; j < array.length; j++) {
				if(j == array.length - 1 && !list.contains(strBuild.toString())) {
					list.add(strBuild.toString());
				}
				if(i!=j) {
					strBuild.append(array[j]);
				}
			}
		}
		
		System.out.println("List of Anagrams: "+list);
		
		
	}
	
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

}
