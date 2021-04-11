package com.hari.dsal.strings.more;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique_1647 {
	public int minDeletions(String s) {
		int count = 0;
		int[] letterCounts = new int[26];

		for (char c : s.toCharArray()) {
			letterCounts[c - 'a']++;
		}

		Set<Integer> set = new HashSet<Integer>();

		for (int c : letterCounts) {
			while (c != 0 && !set.add(c--)) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		MinimumDeletionstoMakeCharacterFrequenciesUnique_1647 md = new MinimumDeletionstoMakeCharacterFrequenciesUnique_1647();
		System.out.println(md.minDeletions("aaabbbcc"));
	}
}
