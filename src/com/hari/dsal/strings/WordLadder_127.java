package com.hari.dsal.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder_127 {

	public int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || start.isEmpty() || end == null || end.isEmpty() || dict.size()==0)
			return 0;
		if(!dict.contains(end)) {
			return 0;
		}
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
							if (dict.contains(strCurr) && !visited.contains(strCurr)) { // Main Condition
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
	
	
	// Best solution - Set & Queue
	public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
	    Set<String> set = new HashSet<>(wordList);
	    Queue<String> queue = new LinkedList<>();
	    queue.add(beginWord);
	    // COUNT NUMBER OF WORDS TRANSFORMED
	    int count = 1;
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        // FOR ALL WORDS THIS ROUND
	        for (int i = 0; i < size; i++) {
	            char[] current = queue.poll().toCharArray();
	            // TRAVERSE CURRENT WORD
	            for (int j = 0; j < current.length; j++) {
	                char tmp = current[j];
	                // CHANGE ONE LETTER AT A TIME 
	                for (char c = 'a'; c <= 'z'; c++) {
	                    current[j] = c;
	                    String next = new String(current);
	                    // WHEN NEXT WORD IS IN THE SET
	                    if (set.contains(next)) {
	                        
	                    	if (next.equals(endWord)) 
	                        	return count + 1;
	                        
	                        queue.add(next);
	                        set.remove(next);
	                    }
	                }
	                // HAVE TO UNDO FOR NEXT CHANGE OF LETTER
	                current[j] = tmp;
	            }
	        }
	        // THIS ROUND ENDS WITH ONE LETTER CHANGED
	        count++;
	    }
	    return 0;
	}
	
	public static void main(String[] args) {
		
		String start = "hit";
		String end = "cog";
		//Set<String> dict = new HashSet<String>();
		List<String> dict = new ArrayList<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("ait");
		dict.add("cog");
		
		WordLadder_127 wl = new WordLadder_127();
		System.out.println(wl.ladderLength1(start, end, dict));
	}

}
