package com.hari.dsal.strings.more;

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
	
	public static int solve(String s) {
        int max =0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                StringBuilder str = new StringBuilder(s.substring(i,j));
                String temp = new String(str);

                if(str.reverse().toString().equalsIgnoreCase(temp)) {
                	 max = Math.max(max,j-i);
                }
                   
            }
        }

    return max;
    }
	
	public static void main(String[] args) {
		System.out.println(solve("aaaaaa"));
	}
}
