package com.hari.dsal.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs){
		if(strs == null || strs.length ==0)
			return null;
		Map<String, List<String>> map = new HashMap<>();
		
		for(String s: strs) {			
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keystr = String.valueOf(ca);
			
			if(!map.containsKey(keystr))
				map.put(keystr, new ArrayList<String>());
			map.get(keystr).add(s);
		}
		return new ArrayList<List<String>>(map.values()); // Convert map values into List<List<String>>
	}
	
	public static void main(String[] args) {
		String [] strs = {"ate","eat","tea","sub","bus"};
		
		GroupAnagrams ga = new GroupAnagrams();
		List<List<String>> results = ga.groupAnagrams(strs);
		
		for(List<String> res:results) {
			System.out.println("\n");
			res.forEach(val -> {
				System.out.print(val+ " ");
			});
		}
	}
}
