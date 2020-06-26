package com.hari.dsal.strings;

public class ReverseVowelsOfAString {
	
	private String reverseVowels(String s) {
		
		if(s == null || s.length() == 0)
			return null;
		
		String vowels = "aeiouAEIOU";
		char[] chars = s.toCharArray();
		int start =0, end =s.length() -1;
		
		while(start < end) {
			
			while(start < end && !vowels.contains(chars[start]+""))
				start++;
			while(start < end && !vowels.contains(chars[end]+""))
				end--;
			
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
		return new String(chars);		
	}
	
	public static void main(String[] args) {
		String str = "Iamasuperman";
		ReverseVowelsOfAString rsv = new ReverseVowelsOfAString();
		System.out.println(rsv.reverseVowels(str));
		System.out.println(str.contains('a'+"")); // Compare a character with in String
		System.out.println("Iam".contains(str));
	}
}
