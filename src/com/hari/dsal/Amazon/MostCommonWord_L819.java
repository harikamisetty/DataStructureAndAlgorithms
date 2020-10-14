package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWord_L819 {

	public String mostCommonWord(String paragraph, String[] banned) {
		Map<String, Integer> wordMap = new HashMap<>();
		String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
		String[] strs = normalizedStr.split("\\s+");

		List<String> arrayList = new ArrayList<>();
		for (String val : banned) {
			arrayList.add(val);
		}

		for (String str : strs) {
			if (!arrayList.contains(str)) {
				if (wordMap.containsKey(str)) {
					wordMap.put(str, wordMap.get(str) + 1);
				} else {
					wordMap.put(str, 1);
				}
			}
		}
		return Collections.max(wordMap.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
	
	public static void main(String[] args) {
		MostCommonWord_L819 mcw = new MostCommonWord_L819();
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String [] banned = {"hit"};
		mcw.mostCommonWord(paragraph, banned);
	}
}
