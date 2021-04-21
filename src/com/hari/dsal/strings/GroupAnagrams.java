package com.hari.dsal.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs){ // Time : O(NlogN)
		if(strs == null || strs.length ==0)
			return null;
		Map<String, List<String>> map = new HashMap<>();
		
		for(String s: strs) {			
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			// Convert array to String
			String keystr = String.valueOf(ca);
			
			if(!map.containsKey(keystr))
				map.put(keystr, new ArrayList<String>());
			map.get(keystr).add(s);
		}
		return new ArrayList<List<String>>(map.values()); // Convert map values into List<List<String>>
	}
	
	public List<List<String>> groupAnagrams1(String[] strs) { // Time : O(N)
		
		if (strs.length == 0)
			return new ArrayList<>();
		
		Map<String, List<String>> ans = new HashMap<>();
		
		int[] count = new int[26];
		
		for (String s : strs) {
			Arrays.fill(count, 0);
		
			for (char c : s.toCharArray())
				count[c - 'a']++;

			StringBuilder sb = new StringBuilder("");
			
			for (int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			
			String key = sb.toString();
			
			if (!ans.containsKey(key))
				ans.put(key, new ArrayList<>());
			ans.get(key).add(s);
		}
		return new ArrayList<>(ans.values());
	}
	
	public static void main(String[] args) {
		String [] strs = {"ate","eat","tea","sub","bus"};
		
		GroupAnagrams ga = new GroupAnagrams();
		List<List<String>> results = ga.groupAnagrams(strs);
		List<List<String>> results1 = ga.groupAnagrams1(strs);
		
		for(List<String> res:results) {
			System.out.println("\n");
			res.forEach(val -> {
				System.out.print(val+ " ");
			});
		}
	}
}
