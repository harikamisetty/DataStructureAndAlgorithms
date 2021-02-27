package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SubmajorityVote {
	public int[] solve(int[] nums) {

		Map<Integer, Integer> temp = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (temp.containsKey(nums[i])) {
				temp.put(nums[i], temp.get(nums[i]) + 1);
			} else {
				temp.put(nums[i], 1);
			}
		}
		LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
		List<Integer> result = new ArrayList<>();
		if (temp != null) {
			temp.entrySet().stream().sorted(Map.Entry.comparingByValue())
					.forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

			
		for (Map.Entry<Integer, Integer> entry : reverseSortedMap.entrySet()) {
				if (entry.getValue() > nums.length / 3) {
					result.add(entry.getKey());
				}
			}
			Collections.sort(result);
			 
		}

		return result.stream().mapToInt(Integer::intValue).toArray();

	}
	
	public static void main(String[] args) {
		int []nums = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
		SubmajorityVote s = new SubmajorityVote();
		for(int val : s.solve(nums)) {
			System.out.println(val);
		}
	}
}
