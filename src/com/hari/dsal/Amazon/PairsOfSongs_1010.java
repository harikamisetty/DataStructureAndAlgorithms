package com.hari.dsal.Amazon;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongs_1010 {

	public int numPairsDivisibleBy60(int[] time) {

		int res = 0;
		// Step 1
		for (int i = 0; i < time.length; i++) {
			time[i] %= 60;
		}
		
		// Step 2
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < time.length; i++) {

			int t = time[i];
			if (map.containsKey((60 - t) % 60)) {
				//Step 3
				res += map.get((60 - t) % 60);
				map.put(t, map.getOrDefault(t, 0) + 1);
			} else {
				map.put(t, 1);
			}			
		}
		return res;
	}
	
	public static void main(String[] args) {
		int [] time = {30,20,150,100,40};
		PairsOfSongs_1010 ps = new PairsOfSongs_1010();
		System.out.println(ps.numPairsDivisibleBy60(time));
	}
}