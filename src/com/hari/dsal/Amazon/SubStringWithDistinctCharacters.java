package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubStringWithDistinctCharacters {
	public static List<String> kSubstring(String s, int k) {
		Set<Character> window = new HashSet<>();
		Set<String> result = new HashSet<>();
		
		for (int start = 0, end = 0; end < s.length(); end++) {
			for (; window.contains(s.charAt(end)); start++) {
				window.remove(s.charAt(start));
			}

			window.add(s.charAt(end));

			if (window.size() == k) {
				result.add(s.substring(start, end + 1));
				window.remove(s.charAt(start++));
			}
		}
		return new ArrayList<>(result);
	}

	public static void main(String[] args) {
		System.out.println(kSubstring("awaglknagawunagwkwagl", 4));
	}
}
