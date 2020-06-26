package com.hari.dsal.mislanious;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Nordstrom {

	public static void main(String[] args) {
		int[] intArr = new int[] { 1, 2, 3, 3, 4, 4 };

		List<Map.Entry<Integer, Integer>> dupe = findMostCommon(intArr);
		dupe.forEach(e -> System.out.println(e.getKey()));
	}

	public static List<Map.Entry<Integer, Integer>> findMostCommon(int[] intArr) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < intArr.length; i++) {

			if (map.containsKey(intArr[i])) {
				map.put(intArr[i], map.get(intArr[i]) + 1);
			} else {
				map.put(intArr[i], 1);
			}
		}

		int maxcount = 0;
		final int dummy;

		List<Entry<Integer, Integer>> resultsList = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int count = entry.getValue();
			maxcount = Math.max(maxcount, count);
		}

		dummy = maxcount;
		resultsList = map.entrySet().stream().filter(k -> k.getValue() == dummy).collect(Collectors.toList());
		return resultsList;

	}
}