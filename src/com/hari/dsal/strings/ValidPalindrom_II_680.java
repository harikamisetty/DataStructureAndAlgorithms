package com.hari.dsal.strings;

public class ValidPalindrom_II_680 {
	
	public boolean validPalindromeUtil(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!= s.charAt(end)){
                return false;
            }
            start++; end--;
        }
        return true;
    }
        
    public boolean validPalindrome(String s) {
        int len = s.length();
        int start =0; int end = len-1;
        while(start<=end){
            if(s.charAt(start)!= s.charAt(end)){
                return validPalindromeUtil(s,start,end-1) || validPalindromeUtil(s,start+1,end);
            }
            start++; end--;
        }
        return true;
    }
    
    public static void main(String[] args) {
    	ValidPalindrom_II_680 vp = new ValidPalindrom_II_680();
    	System.out.println(vp.validPalindrome("abcb"));
	}

}
