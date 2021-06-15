package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortArraybyIncreasingFrequency_1636 {
	public int[] frequencySort(int[] nums) {
		Map<Integer, Integer> map = new TreeMap<>();

		for (int val : nums) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		LinkedHashMap<Integer, Integer> lmap = new LinkedHashMap<>();

		map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> lmap.put(x.getKey(), x.getValue()));
		int j = 0;
		for (Map.Entry<Integer, Integer> entry : lmap.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				nums[j] = entry.getKey();
				j++;
			}
		}
		return nums;
	}

	public int[] frequencySort_2(int[] nums) {

		HashMap<Integer, Integer> h = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (h.containsKey(nums[i]))
				h.put(nums[i], h.get(nums[i]) + 1);
			else
				h.put(nums[i], 1);
		}
		Set s = h.entrySet();
		Iterator i = s.iterator();
		ArrayList<Map.Entry<Integer, Integer>> l = new ArrayList<>();
		while (i.hasNext()) {
			Map.Entry<Integer, Integer> e = (Map.Entry<Integer, Integer>) i.next();
			l.add(e);
		}
		Comparator<Map.Entry<Integer, Integer>> c = (a, b) -> {
			if (a.getValue() == b.getValue())
				return -1 * (a.getKey()).compareTo(b.getKey());
			else
				return -1 * b.getValue().compareTo(a.getValue());
		};
		Collections.sort(l, c);
		int index = 0;
		for (int j = 0; j < l.size(); j++) {
			int k = l.get(j).getKey();
			int v = l.get(j).getValue();
			while (v-- > 0) {
				nums[index] = k;
				index++;
			}
		}

		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 2, 3 };
		SortArraybyIncreasingFrequency_1636 sai = new SortArraybyIncreasingFrequency_1636();
	}
}
