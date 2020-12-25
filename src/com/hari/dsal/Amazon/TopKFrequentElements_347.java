package com.hari.dsal.Amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TopKFrequentElements_347 {

	public int[] topKFrequent(int[] nums, int k) {
		int res[] = new int[k];
		if (nums.length == 0 || k == 0 || k > nums.length)
			return res;
		Map<Integer, Integer> map = new HashMap<>();

		for (int val : nums) {
			if(map.containsKey(val))				
				map.put(val, map.get(val)+1);
			else
				map.put(val, 1);
		}

		Map<Integer, Integer> lmap = new LinkedHashMap<>();

		map.entrySet().parallelStream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(val -> lmap.put(val.getKey(), val.getValue()));

		int i = 0;

		for (Map.Entry<Integer, Integer> entry : lmap.entrySet()) {
			res[i++] = entry.getKey();
			if (k == i)
				break;			
		}
		return res;
	}

	public static void main(String[] args) {
		TopKFrequentElements_347 tf = new TopKFrequentElements_347();
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		for(int val :tf.topKFrequent(nums, 2)) {
			System.out.print(val+ ",");
		}
	}

}
