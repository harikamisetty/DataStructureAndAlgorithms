package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak_II_140 {

	// Back Tracking

	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> result = new ArrayList<String>();

		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
			return result;
		}

		List<String> curr = new ArrayList<String>();
		wordBreakHelper(curr, result, s, dict, 0);

		return result;
	}

	private void wordBreakHelper(List<String> curr, List<String> result, String s, Set<String> dict, int start) {
		if (start >= s.length()) {
			String temp = String.join(" ",curr); 
			result.add(temp);
		}

		for (int i = start; i < s.length(); i++) {
			if (dict.contains(s.substring(start, i + 1))) {
				curr.add(s.substring(start, i + 1));
				wordBreakHelper(curr, result, s, dict, i + 1);
				curr.remove(curr.size() - 1);
			}
		}
	}

	
	// DFS
	public List<String> wordBreak_DFS(String s, List<String> wordDist) {
		return DFS(s, wordDist, new HashMap<String, LinkedList<String>>());
	}

	private List<String> DFS(String s, List<String> wordDist, HashMap<String, LinkedList<String>> map) {

		if (map.containsKey(s)) {
			return map.get(s);
		}
		LinkedList<String> res = new LinkedList<String>();

		if (s.length() == 0) {
			res.add("");
			return res;
		}

		for (String word : wordDist) {
			if (s.startsWith(word)) {
				List<String> sublist = DFS(s.substring(word.length()), wordDist, map);
				if (sublist != null) {
					for (String sub : sublist) {
						res.add(word + ((sub != null && sub.isEmpty()) ? "" : " ") + sub);
					}
				}
			}
		}

		map.put(s, res);
		return res;
	}

	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));

		WordBreak_II_140 w140 = new WordBreak_II_140();
		for (String val : w140.wordBreak(s, wordDict)) {
			System.out.println(val);
		}
		// Arrays.asList("catsanddog","cat", "cats", "and", "sand", "dog")
		for (String val : w140.wordBreak_DFS("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"))) {
			System.out.println(val);
		}
	}
}
