package com.hari.dsal.arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray_697 {
	public int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			if (left.get(x) == null)
				left.put(x, i);
			right.put(x, i);
			count.put(x, count.getOrDefault(x, 0) + 1);
		}

		int ans = nums.length;
		int degree = Collections.max(count.values());
		for (int x : count.keySet()) {
			if (count.get(x) == degree) {
				ans = Math.min(ans, right.get(x) - left.get(x) + 1);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		DegreeOfArray_697 doa = new DegreeOfArray_697();
		int[] nums = { 1, 2, 2, 3, 1, 4, 2 };
		System.out.println(doa.findShortestSubArray(nums));
	}
}
