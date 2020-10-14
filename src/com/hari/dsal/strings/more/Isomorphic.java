package com.hari.dsal.strings.more;

import java.util.HashMap;
import java.util.HashSet;

public class Isomorphic {

	public static void main(String[] args) {
		String string1 = "egg";
		String string2 = "apg";
		System.out.println(isIsomorphic(string1, string2));
	}

	private static boolean isIsomorphic(String string1, String string2) {

		int[] m = new int[512];

		for (int i = 0; i < string1.length(); i++) {
			if (m[string1.charAt(i)] != m[string2.charAt(i) + 256]) {
				return false;
			}
			m[string1.charAt(i)] = m[string2.charAt(i) + 256] = i + 1;
		}
		return true;
	}

	public boolean isIsomorphic1(String s, String t) {
	    if (s.length() != t.length()) {
	        return false;
	    }

	    HashMap<Character, Character> map = new HashMap<>();
	    for (int i = 0; i < s.length(); i++) {
	        char c1 = s.charAt(i);
	        char c2 = t.charAt(i);

	        if (map.containsKey(c1)) {
	            if (map.get(c1) != c2) {
	                return false;
	            }
	        } else {
	            map.put(c1, c2);
	        }
	    }

	    HashSet<Character> set = new HashSet<>(map.values());
	    if (set.size() == map.values().size()) {
	        return true;
	    }

	    return false;
	}
}
