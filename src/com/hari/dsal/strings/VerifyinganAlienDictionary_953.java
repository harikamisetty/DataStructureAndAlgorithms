package com.hari.dsal.strings;

import java.util.Comparator;

public class VerifyinganAlienDictionary_953 {

	public boolean isAlienSorted(String[] words, String order) {
		char[] map = new char[26]; // order = "bca" -> map = ['c', 'a', 'b']

		for (int i = 0; i < 26; ++i)
			map[order.charAt(i) - 'a'] = (char) (i + 'a');

		for (int i = 0; i + 1 < words.length; ++i)
			if (bigger(words[i], words[i + 1], map))
				return false;

		return true;
	}

	private boolean bigger(final String s1, final String s2, final char[] map) {
		for (int i = 0; i < s1.length() && i < s2.length(); ++i)
			if (s1.charAt(i) != s2.charAt(i))
				return map[s1.charAt(i) - 'a'] > map[s2.charAt(i) - 'a'];
		return s1.length() > s2.length();
	}

	// SOLUTION #2
	public boolean isAlienSorted2(String[] words, String order) {
		Comparator<String> comparator = (o1, o2) -> {
			int l1 = o1.length();
			int l2 = o2.length();
			int i = 0;

			while (i < l1 && i < l2) {
				int index1 = order.indexOf(o1.charAt(i));
				int index2 = order.indexOf(o2.charAt(i));

				if (index1 < index2) {
					return -1;
				} else if (index1 > index2) {
					return 1;
				}

				i++;
			}

			return l1 == l2 ? 0 : (i == l1 ? -1 : 1);

		};

		for (int i = 0; i < words.length - 1; i++) {
			if (comparator.compare(words[i], words[i + 1]) > 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		VerifyinganAlienDictionary_953 va = new VerifyinganAlienDictionary_953();
		String[] words = { "hello", "leetcode" };
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(va.isAlienSorted(words, order));
	}
}
