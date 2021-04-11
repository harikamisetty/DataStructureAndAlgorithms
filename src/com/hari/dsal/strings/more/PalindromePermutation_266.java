package com.hari.dsal.strings.more;

import java.util.HashMap;

public class PalindromePermutation_266 {
	
	public boolean canPermutePalindrome(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		int count = 0;
		for (char key : map.keySet()) {
			count += map.get(key) % 2;
		}
		return count <= 1;
	}
	
	
	public static void main(String[] args) {
		PalindromePermutation_266 pp = new PalindromePermutation_266();
		System.out.println(pp.canPermutePalindrome("aab"));
	}
}
