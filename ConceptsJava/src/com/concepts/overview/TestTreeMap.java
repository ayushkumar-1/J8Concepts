package com.concepts.overview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {

	public static void main(String[] args) {
	
		Map<Bean, Integer> mp = new TreeMap<>(new TestComparator());
		Map<Bean,Integer> mp2 = new HashMap<>();
		
		
		Bean b1 = new Bean(1,"Hey");
		Bean b2 = new Bean(7, "Hello");
		Bean b3 = new Bean(5, "Ji");
		mp.put(b1, 11);
		mp.put(b2, 13);
		mp.put(b3, 12);
		
		mp2.put(b1, 12);
		mp2.put(b2, 13);
		mp2.put(b3, 14);
		
		System.out.println(mp);
		System.out.println("-------------------------------------------------");
		System.out.println(mp2);
		
		
	}
}

class TestComparator implements Comparator<Bean> {

	@Override
	public int compare(Bean b1, Bean b2) {
		if(b1.getIntData() > b2.getIntData()) {
			return 1;
		}
		return  -1;
	}
	
}

class Bean {
	
	private int intData;
	private String strData;
	
	Bean(int data1, String data2){
		this.intData = data1;
		this.strData = data2;
	}
	
	public int getIntData() {
		return intData;
	}
	public void setIntData(int intData) {
		this.intData = intData;
	}
	public String getStrData() {
		return strData;
	}
	public void setStrData(String strData) {
		this.strData = strData;
	}
	
	
	
}
