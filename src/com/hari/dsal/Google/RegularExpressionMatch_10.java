package com.hari.dsal.Google;

public class RegularExpressionMatch_10 {

	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		
		int i = 0, j = 0;
		while (i < s.length() && j < p.length()) {
			if ((s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '?')) {
				i++;
				j++;
			} else if (p.charAt(j) == '*') {
				i++;
			}
		}
		
		if (j == p.length() - 1)
			j++;

		if (i == s.length() - 1 && j == p.length() - 1)
			return true;
		
		return false;
	}
	
	 public boolean isMatch_dp(String s, String p) {
	       if (p == null || p.length() == 0) {
	            return s == null || s.length() == 0;
	        }
	        int rows = s.length();
	        int cols = p.length();
	         
	        boolean[][] dp = new boolean[rows + 1][cols + 1];
	        dp[0][0] = true;
	         
	        for (int j = 1; j <= cols; j++) {
	            if (p.charAt(j - 1) == '*') {
	                dp[0][j] = dp[0][j - 2];
	            }
	        }
	         
	        for (int i = 1; i <= rows; i++) {
	            for (int j = 1; j <= cols; j++) {
	                char sChar = s.charAt(i - 1);
	                char pChar = p.charAt(j - 1);
	                 
	                if (pChar != '*') {
	                    if (sChar == pChar || pChar == '.') {
	                        dp[i][j] = dp[i - 1][j - 1];
	                    }
	                } else {
	                    if (sChar != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
	                        dp[i][j] = dp[i][j - 2];
	                    } else {
	                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i][j - 1];
	                    }
	                }
	            }
	        }
	        return dp[rows][cols];       
	    }

	public static void main(String[] args) {
		RegularExpressionMatch_10 rem = new RegularExpressionMatch_10();
		String s = "aaa", p = "a*a";
		System.out.println(rem.isMatch_dp(s, p));
	}

}
