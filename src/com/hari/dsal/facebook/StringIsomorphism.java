package com.hari.dsal.facebook;

import java.util.HashMap;
import java.util.Map;

public class StringIsomorphism {
	public boolean solve(String s, String t) {
		if (s == null || t == null)
			return false;
		if (s.equals(t))
			return true;
		if (s.length() != t.length())
			return false;

		Map<Character, Character> tmap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char d = t.charAt(i);
			
			if (tmap.containsKey(c)) {
				if(tmap.get(c)!=d)
					return false;

			} else {
				tmap.put(c,d);
			}
		}
		return true;
	}
	
	public boolean solve_1(String s, String t) {
		if (s == null || t == null)
			return false;
		if (s.equals(t))
			return true;
		if (s.length() != t.length())
			return false;

		Map<Character, Character> tmap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {

			if (tmap.containsKey(s.charAt(i))) {
				if(tmap.get(s.charAt(i))!=t.charAt(i))
					return false;

			} else {
				tmap.put(s.charAt(i),t.charAt(i));
			}
		}
		return true;
	}

	public static void main(String[] args) {
		StringIsomorphism si = new StringIsomorphism();
		String s ="coco", t= "lplp";
		System.out.println(si.solve_1(s, t));
	}
}
