package com.hari.dsal.strings;

public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		if (p == null || p.length() == 0) {
			return s == null || s.length() == 0;
		}

		int rows = s.length();
		int cols = p.length();

		boolean[][] dp = new boolean[rows + 1][cols + 1];

		dp[0][0] = true;
		for (int j = 1; j <= cols; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 1];
			}
		}

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (p.charAt(j - 1) != '*') {
					if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
						dp[i][j] = dp[i - 1][j - 1];
					}
				} else {
					dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
				}
			}
		}

		return dp[s.length()][p.length()];
	}

}
