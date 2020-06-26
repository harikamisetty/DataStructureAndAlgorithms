package com.hari.dsal.backtrack;

import java.util.HashSet;
import java.util.Set;

public class WordLadder {

	private int ladderLength(String bword, String eword, Set<String> wordDist) {
		Set<String> reached = new HashSet<>();
		reached.add(bword);
		wordDist.add(eword);

		int distance = 1;

		while(!reached.contains(eword)) {
			Set<String> toAdd = new HashSet<>();

			for(String each : reached) {
				for(int i=0; i< each.length(); i++) {
					char[] chars = each.toCharArray();

					// Find the word from 'a' to 'z' by changing each character
					for(char ch ='a'; ch <='z';ch++) {
						chars[i] = ch;
						String word = new String(chars);

						if(wordDist.contains(word)) {
							toAdd.add(word);
							wordDist.remove(word);
						}
					}
				}
			}
			distance++;
			if(toAdd.size() ==0)
				return 0;
			reached = toAdd;
		}
		return distance;
	}
	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		Set<String> wordDist = new HashSet<>();
		wordDist.add("hot");
		wordDist.add("dot");
		wordDist.add("dog");
		wordDist.add("lot");
		wordDist.add("log");
		wordDist.add("cog");

		System.out.println(wl.ladderLength("hit", "cog", wordDist));

	}
}
