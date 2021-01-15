package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_L763 {
	 public List<Integer> partitionLabels(String S) {
	        int[] last = new int[26];
	        for (int i = 0; i < S.length(); ++i)
	            last[S.charAt(i) - 'a'] = i;
	        
	        int j = 0, anchor = 0;
	        List<Integer> ans = new ArrayList<>();
	        for (int i = 0; i < S.length(); ++i) {
	            j = Math.max(j, last[S.charAt(i) - 'a']);
	            if (i == j) {
	                ans.add(i - anchor + 1);
	                anchor = i + 1;
	            }
	        }
	        return ans;
	    }
	 
	 public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		
		PartitionLabels_L763 p = new PartitionLabels_L763();
		List<Integer> res = p.partitionLabels(s);
		res.forEach(val -> System.out.println(val));
	}
}
