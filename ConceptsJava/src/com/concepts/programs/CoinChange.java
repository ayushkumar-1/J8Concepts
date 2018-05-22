package com.concepts.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CoinChange {

	public static void main(String[] args) throws InterruptedException {
		
		String str = "hereisdata";
		StringBuilder strBuild = new StringBuilder(str);
		char[] ch = str.toCharArray();
		TreeMap<String, String> tree = new TreeMap<>();
		
		for(int i =0; i < ch.length; i++) {
			System.out.println(ch[i]);
			String string = String.valueOf(i);
			tree.put(string, String.valueOf(ch));
		}
		StringBuilder strBuild2 = new StringBuilder();
		for(Map.Entry<String, String> entry : tree.entrySet()) {
			
			//System.out.println(entry.getValue());
			strBuild2.append(entry.getValue());
		}
		System.out.println(strBuild2.toString());
		
		
		/*int[] coins = {25,10,5,1};
		int money = 27;
		long ways = 0;
		Map<String, Long> map = new HashMap<>();
		ways = makeChange(coins, money, 0, map);
		System.out.println(ways);*/
	}

	private static long makeChange(int[] coins, int money, int i, Map<String, Long> map) throws InterruptedException {
		//Base cases
		if(money == 0) {
			return 1;
		}
		
		if(i >= coins.length) {
			return 0;
		}
		String key = money + "=" + i;
		
		if(map.containsKey(key)) {
			return map.get(key);
		}
		
		
		int amountWithCoin = 0;
		long ways = 0;
		while(amountWithCoin <= money) {
			
			int remaining = money - amountWithCoin;
			
			ways += makeChange(coins, remaining, i+1, map);
			//System.out.println(ways);			
			//Thread.sleep(2000);
			amountWithCoin += coins[i];
		}	
		map.put(key, ways);
		return ways;
	}
}
