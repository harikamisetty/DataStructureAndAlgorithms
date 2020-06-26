package com.hari.dsal.strings;

public class LongestPalindrem {
	
	public static String longestPalindrome(String s) {        
        if (s == null || s.length() < 2) {
            return s;
        }
 
        int length = s.length();
        
        boolean[][] isPalindrome = new boolean[length][length];
        
        int left = 0;
        int right = 0;
        
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                boolean isInnerWordPalindrome = isPalindrome[j + 1][i - 1] || i - j <= 2;
                
                if (s.charAt(i) == s.charAt(j) && isInnerWordPalindrome) {
                    isPalindrome[j][i] = true;
                    
                    if (i - j > right - left) {
                        left = j;
                        right = i;
                    }
                }                
            }            
        }
        
        return s.substring(left, right + 1);
        
        // Time Complexity: O(n ^ 2)
        // Space Complexity: O(n ^ 2)
    }
	// BEST Solution
	public static String longestPalindromeString1(String string) { 

		String p = "";
		for (int i = 0; i < string.length(); i++) {
			String str = "";
			for (int j = i; j < string.length(); j++) {
				str += string.charAt(j);
				String revStr = new StringBuilder(str).reverse().toString();
				if (string.contains(revStr) && p.length() < revStr.length()) {
					p = revStr;
				}
				if (p.length() == string.length()) {
					break;
				}
			}
		}
		return p;
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("babadhellolleh"));
		System.out.println(longestPalindromeString1("babadhellolleh"));
	}
}
