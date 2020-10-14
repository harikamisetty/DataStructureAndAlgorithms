package com.hari.dsal.strings;

public class FirstUniqueCharacterInaString {

	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}

		int[] counts = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			counts[c - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (counts[c - 'a'] == 1) {
				return i;
			}
		}

		return -1;
	}
	
	public static void main(String[] args) {
		FirstUniqueCharacterInaString fucs = new FirstUniqueCharacterInaString();
		System.out.println(fucs.firstUniqChar("bd"));
	}

}
