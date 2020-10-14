package com.hari.dsal.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {

	public boolean wordPattern(String pattern, String s) {
		Map<Character, String> m1 = new HashMap<>();
		Map<String, Character> m2 = new HashMap<>();

		String[] word = s.split(" ");

		if (pattern.length() != word.length)
			return false;

		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);

			if (!m1.containsKey(ch))
				m1.put(ch, word[i]);
			if (!m2.containsKey(word[i]))
				m2.put(word[i], ch);

			if (!Objects.equals(ch, m2.get(word[i])) || !Objects.equals(word[i], m1.get(ch))) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
		System.out.println(wp.wordPattern("abba", "dog dog dog dog"));

	}

}
