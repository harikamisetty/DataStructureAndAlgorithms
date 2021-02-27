package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {

	public List<List<String>> groupAnagrams(String[] strs) {
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
				ans.put(key, new ArrayList<String>());
			ans.get(key).add(s);
		}
		
		return new ArrayList<>(ans.values());
	}
	
	 public int solve(String[] words) {

	        int n = words.length;
	        Map<String,Integer> map = new HashMap<>();

	        for(int i=0;i<words.length;i++){
	        		String temp = getKey(words[i]);
	               if(map.containsKey(temp)){
	                    map.put(temp,map.get(temp)+1);
	               } else {
	                    map.put(temp,1);
	               }
	        } 
	        return map.entrySet().size();       
	    }

	    private String getKey(String str){
	        String res = new String();

	        int [] al = new int[27];

	        for(int i=0;i<str.length();i++){
	            al[str.charAt(i) - 'a']++;
	        }
	        for(int i=0;i<=26;i++){
	            res= res + al[i];
	        }
	        return res;
	    } 

	public static void main(String[] args) {

		String[] strs = { "abcdefg", "bedgafc" };

		GroupAnagrams_49 ga = new GroupAnagrams_49();
		List<List<String>> results = ga.groupAnagrams(strs);
		int res1= ga.solve(strs);
		System.out.println(res1);
		for (List<String> res : results) {
			System.out.println("\n");
			res.forEach(val -> {
				System.out.print(val + " ");
			});
		}

	}
}
