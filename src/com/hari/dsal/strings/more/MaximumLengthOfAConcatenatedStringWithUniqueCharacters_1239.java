package com.hari.dsal.strings.more;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters_1239 {
	int max = 0;

	public int maxLength(List<String> arr) {
		dfs(0, arr, "");
		return max;
	}

	public void dfs(int start, List<String> arr, String str) {
		if (!isUnique(str)) {
			return;
		}
		max = Math.max(max, str.length());

		for (int i = start; i < arr.size(); i++) {
			String s = arr.get(i);
			dfs(i + 1, arr, str + s);
		}
	}

	public static boolean isUnique(String s) {
		Set<Character> set = new HashSet<Character>();

		for (char ch : s.toCharArray()) {
			if (set.contains(ch)) {
				return false;
			}
			set.add(ch);
		}
		return true;
	}

	public static void main(String[] args) {
		MaximumLengthOfAConcatenatedStringWithUniqueCharacters_1239 mla = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters_1239();
		String[] strs = { "cha", "r", "act", "ers" };
		System.out.println(mla.maxLength(Arrays.asList(strs)));
	}
}
