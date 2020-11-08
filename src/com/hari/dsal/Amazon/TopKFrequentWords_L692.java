package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords_L692 {
	public List<String> topKFrequent(String[] words, int k) {
		List<String> res = new ArrayList<>();
		if (words == null || words.length == 0)
			return res;

		LinkedHashMap<String, Integer> tempMap = new LinkedHashMap<>();

		for (String s : words) {
			if (!tempMap.containsKey(s)) {
				tempMap.put(s, 1);
			} else {
				tempMap.put(s, tempMap.get(s) + 1);
			}
		}

		LinkedHashMap<String, Integer> lmap = new LinkedHashMap<>();

		tempMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> lmap.put(x.getKey(), x.getValue()));

		lmap.entrySet().stream().limit(k).forEachOrdered(x -> res.add(x.getKey()));
		return res;
	}

	public static void main(String[] args) {

		String str[] = { "i", "love", "leetcode", "i", "love", "coding" };
		TopKFrequentWords_L692 t = new TopKFrequentWords_L692();
		List<String> res=t.topKFrequent(str, 2);
		
		System.out.println(res);
	}
}
