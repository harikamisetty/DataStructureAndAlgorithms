package com.hari.dsal.Amazon;

public class BreakaPalindrome_1328 {
	
	public String breakPalindrome(String palindrome) {
		int palLen = palindrome.length();
		if (palLen <= 1)
			return "";

		return getUnPalindrome(palindrome);
	}

	private String getUnPalindrome(String palindrome) {
		int palLen = palindrome.length();
		int left = 0;
		int right = palLen - 1;
		StringBuilder sb = new StringBuilder(palindrome);

		while (left < right) {
			if (sb.charAt(left) > 'a') {
				sb.setCharAt(left, 'a');
				return sb.toString();
			}
			++left;
			--right;
		}
		sb.setCharAt(palLen - 1, 'b');
		return sb.toString();
	}

	public static void main(String[] args) {
		BreakaPalindrome_1328 bp = new BreakaPalindrome_1328();
		System.out.println(bp.breakPalindrome("abccba"));
	}
}
