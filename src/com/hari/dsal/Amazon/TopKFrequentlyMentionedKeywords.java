package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TopKFrequentlyMentionedKeywords {

	public static void main(String[] args) {
		int k1 = 2;
		String[] keywords1 = { "anacell", "cetracular", "betacellular" };
		String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
				"Best services provided by anacell, everyone should use anacell", };
		int k2 = 2;
		String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
				"betacellular has great services", "deltacellular provides much better services than betacellular",
				"cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
		System.out.println(solve(k1, keywords1, reviews1));
		System.out.println(solve(k2, keywords2, reviews2));
	}

	private static List<String> solve(int k, String[] keywords, String[] reviews) {
		List<String> res = new ArrayList<>();
		Set<String> set = new HashSet<>(Arrays.asList(keywords));
		Map<String, Integer> map = new HashMap<>();
		for (String r : reviews) {
			String[] strs = r.split("\\W"); // Reviews
			Set<String> added = new HashSet<>();
			for (String s : strs) { // Reviews
				s = s.toLowerCase();
				if (set.contains(s) && !added.contains(s)) {
					map.put(s, map.getOrDefault(s, 0) + 1);
					added.add(s);
				}
			}
		}
		Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a,	b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
		maxHeap.addAll(map.entrySet());
		while (!maxHeap.isEmpty() && k-- > 0) {
			res.add(maxHeap.poll().getKey());
		}
		
		LinkedHashMap<String, Integer> resmap = new LinkedHashMap<>();
		map.entrySet().parallelStream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x->resmap.put(x.getKey(), x.getValue()));
		
		for(Map.Entry<String, Integer> val : map.entrySet()) {
			System.out.println(val.getKey());
			k--;
			if(k==0)
				break;
		}
		
			
		return res;
	}

	// Solution#2
	public static List<String> getFrequent(int k, String[] keywords, String[] words) {
		Map<String, Integer> count = new HashMap<>();
		List<String> keywordsList = Arrays.asList(keywords);
		for (String word : words) {
			for (String s : word.split("\\s+")) {
				if (keywordsList.contains(s)) {
					count.put(s, count.getOrDefault(s, 0) + 1);
				}
			}
		}

		List<String> ls = new ArrayList<>(count.keySet());
		Collections.sort(ls,
				(a, b) -> (count.get(a)).equals(count.get(b)) ? a.compareTo(b) : count.get(b) - count.get(a));

		return ls.subList(0, k);
	}

}
