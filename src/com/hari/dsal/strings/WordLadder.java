package com.hari.dsal.strings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || start.isEmpty() || end == null || end.isEmpty())
			return 0;

		int length = 1;
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);

		HashSet<String> visited = new HashSet<String>();

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String curr = queue.poll();
				for (int j = 0; j < curr.length(); j++) {
					char[] charCurr = curr.toCharArray();
					for (char c = 'a'; c < 'z'; c++) {
						charCurr[j] = c; // change one character at a time
						String strCurr = new String(charCurr);
						if (strCurr.equals(end)) {
							return length + 1;
						} else {
							if (dict.contains(strCurr) && !visited.contains(strCurr)) {
								queue.offer(strCurr);
								visited.add(strCurr);
							}
						}
					}
				}
			}
			length++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength(start, end, dict));
	}

}
