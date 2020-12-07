package com.hari.dsal.Google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak_139 {
	
	// Recursive : Time : O(2^n)
	public boolean wordBreak(String s, Set<String> dict) {
        if (dict.contains(s)) return true;
         
        int len = s.length();
         
        for (int i = 1; i < len; i++) {
            String s1 = s.substring(0, i);
            if (dict.contains(s1)) {
                String s2 = s.substring(i, len);
                if (wordBreak(s2, dict) == true) return true;
            }
        }
        return false;
    }
	
	// DP Solution : Time : O(n^2)
	public boolean wordBreak_dp(String s, Set<String> dict) {
        if (s == null || s.isEmpty()) return true;
         
        // dp[i] means [0,i) is breakable
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
         
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
	
	public static void main(String[] args) {
		String s="leetcode";
		Set<String> set = new HashSet<>(Arrays.asList("leet","code"));
		WordBreak_139 w139 = new WordBreak_139();
		//System.out.println(w139.wordBreak(s, set));
		System.out.println(w139.wordBreak_dp(s, set));
	}

}
