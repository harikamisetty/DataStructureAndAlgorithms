package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastNumberofUniqueIntegersafterKRemovals_1481 {
	public int findLeastNumOfUniqueInts(int[] arr, int k) {

		int n = arr.length;
		Map<Integer, Integer> mp = new HashMap<>();

		for (int i = 0; i < n; i++) {
			mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(mp.entrySet());
		list.sort(Map.Entry.comparingByValue());

		for (Map.Entry<Integer, Integer> entry : list) {
			int val = entry.getValue();
			while (k > 0 && val > 0) {
				val--;
				k--;
			}

			if (val == 0) {
				mp.remove(entry.getKey());
			} else {
				mp.put(entry.getKey(), val);
			}

			if (k == 0) {
				break;
			}
		}

		return mp.size();

	}

	public static void main(String[] args) {
		LeastNumberofUniqueIntegersafterKRemovals_1481 ln = new LeastNumberofUniqueIntegersafterKRemovals_1481();
		int[] arr = { 4, 3, 1, 1, 3, 3, 2 };
		System.out.println(ln.findLeastNumOfUniqueInts(arr, 3));
	}

}
