package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords_472 {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {

		List<String> result = new ArrayList<>();
		Set<String> preWords = new HashSet<>();

		Arrays.sort(words,(a,b)->a.length() - b.length());
		for (int i = 0; i < words.length; i++) {
			if (canForm(words[i], preWords)) {
				result.add(words[i]);
			}
			preWords.add(words[i]);
		}
		return result;
	}

	private boolean canForm(String word, Set<String> dict) {

		if (dict.isEmpty()) {
			return false;
		}

		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;

		for (int i = 1; i <= word.length(); i++) {
			for (int j = 0; j < i; j++) {

				if (!dp[j]) {
					continue;
				}

				if (dict.contains(word.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[word.length()];
	}

	// SOLUTION #2

	Set<String> set = new HashSet<>();

	public int solve(String[] words) {
		for (String word : words)
			set.add(word);
		int ans = 0;
		for (String word : words)
			ans += count(word, 0) ? 1 : 0;
		return ans;
	}

	public boolean count(String s, int dist) {
		int n = s.length();
		if (n == 0)
			if (dist == 1)
				return false;
			else
				return true;
		for (int i = 0; i <= n - 1; i++) {
			String prefix = s.substring(0, i + 1);
			if (set.contains(prefix))
				if (count(s.substring(i + 1), dist + 1))
					return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String[] words = { "news", "paper", "newspaper" };
		ConcatenatedWords_472 cw = new ConcatenatedWords_472();

		for (String str : cw.findAllConcatenatedWordsInADict(words)) {
			System.out.println(str + ",");
		}
	}
}
