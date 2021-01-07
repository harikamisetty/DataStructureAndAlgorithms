package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0)
			return new ArrayList<>();
		
		Map<String, List<String>> ans = new HashMap<>();
		int[] count = new int[26];
		
		for (String s : strs) {
			Arrays.fill(count, 0);
			for (char c : s.toCharArray())
				count[c - 'a']++;

			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();
			if (!ans.containsKey(key))
				ans.put(key, new ArrayList<String>());
			ans.get(key).add(s);
		}
		
		return new ArrayList<>(ans.values());
	}

	public static void main(String[] args) {

		String[] strs = { "ate", "eat", "tea", "sub", "bus" };

		GroupAnagrams_49 ga = new GroupAnagrams_49();
		List<List<String>> results = ga.groupAnagrams(strs);

		for (List<String> res : results) {
			System.out.println("\n");
			res.forEach(val -> {
				System.out.print(val + " ");
			});
		}

	}
}