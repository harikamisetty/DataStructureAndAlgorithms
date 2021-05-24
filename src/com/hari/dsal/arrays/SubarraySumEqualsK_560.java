package com.hari.dsal.arrays;

import java.util.HashMap;

public class SubarraySumEqualsK_560 {
	public int subarraySum(int[] nums, int k) {

		int len = nums.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			int windowsum = 0;
			for (int j = i; j < len; j++) {
				windowsum = windowsum + nums[j];
				if (windowsum == k)
					count++;
			}
		}
		return count;
	}

	public int subarraySum_2(int[] nums, int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		SubarraySumEqualsK_560 sas = new SubarraySumEqualsK_560();
		int[] nums = { 1, 2, 3 };
		int k = 3;
		System.out.println(sas.subarraySum(nums, k));
	}
}
