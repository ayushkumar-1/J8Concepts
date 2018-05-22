package com.concepts.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class StringReverse {
	
	public static void main(String[] args) {
		
		
				System.out.println("abc".substring(1));

			   
		        List<String> output = StringReverse.generatePermutations("xyz");
		        System.out.println("Result size: "+output.size());
		        output.stream().forEach(System.out::println);
		        System.out.println("------------------");
		 
		        output = StringReverse.generatePermutations("ABCD");
		        System.out.println("Result size: "+output.size());
		        output.stream().forEach(System.out::println);
		    
		 
		   
		
		
		/*
		String str = "This  is a string";
		reverseString(str);
		reverseString2(str);
		
		TreeMap<String, String> tm = new TreeMap<String, String>();*/
	}

	 public static List<String> generatePermutations(String input) {
		 
	        List<String> strList = new ArrayList<String>();
	        StringReverse.permutations("", input, strList);
	 
	        return strList;
	    }
	 
	    private static void permutations(String consChars, String input, List<String> opContainer) {
	 
	        if(input.isEmpty()) {
	            opContainer.add(consChars+input);
	            return;
	        }
	 
	        for(int i=0; i<input.length(); i++) {
	            permutations(consChars+input.charAt(i),
	                            input.substring(0, i)+input.substring(i+1),
	                            opContainer);
	            System.out.println(i);
	        }
	    }
	
	private static void reverseString2(String str) {
		String[] strArr = str.split(" ");
		
		System.out.println("str: "+strArr[1]);
		System.out.println(strArr.length);
		//String[] reversedArr = new String[strArr.length];
		int index = 0;
		StringBuilder strBuild = new StringBuilder();
		for(int i = strArr.length -1 ; i >= 0 ;i--) {	
			strBuild.append(strArr[i]);
		}
		System.out.println("reverse: "+strBuild);
		
		
	}

	private static void reverseString(String str) {
		StringBuilder strBuild = new StringBuilder(str);
		strBuild.reverse();
		System.out.println(strBuild);
		StringTokenizer stz = new StringTokenizer(strBuild.toString(), " ");
		StringBuilder reversedString = new StringBuilder();
		while(stz.hasMoreTokens()) {
			StringBuilder strTemp = new StringBuilder(stz.nextElement().toString());
			strTemp.reverse();

			reversedString.append(strTemp).append(" ");
			
		}
		
		System.out.println(reversedString.toString().trim());
		
	}

}
