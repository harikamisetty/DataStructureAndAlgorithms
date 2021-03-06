package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords_L692 {

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		List<String> ans = new ArrayList<String>();
		LinkedHashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(x->temp.put(x.getKey(), x.getValue()));
		temp.entrySet().stream().limit(k).forEach(x->ans.add(x.getKey()));
		
		/*PriorityQueue<PQ> pq = new PriorityQueue<PQ>(new Comparator<PQ>() {
			@Override
			public int compare(PQ a, PQ b) {
				if (a.cnt != b.cnt)
					return b.cnt - a.cnt;
				return a.word.compareTo(b.word);
			}
		});

		for (String word : map.keySet())
			pq.add(new PQ(word, map.get(word)));
		
		for (int i = 0; i < k; i++)
			ans.add(pq.poll().word);*/
		return ans;
	}

	public static void main(String[] args) {

		String str[] = { "i", "love", "leetcode", "i", "love", "coding" };
		TopKFrequentWords_L692 t = new TopKFrequentWords_L692();
		List<String> res = t.topKFrequent(str, 2);

		System.out.println(res);
	}
}

class PQ {
	String word;
	int cnt;

	PQ(String word, int cnt) {
		this.word = word;
		this.cnt = cnt;
	}
}
