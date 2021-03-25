package com.hari.dsal.facebook;

/*
 * Input -> s = "tacocat"
 * Output -> 10
 * 
The palindromic substrings are:

"t"
"a"
"c"
"o"
"c"
"a"
"t"
"coc"
"acoca"

 * 
 */

public class NumberofPalindromicSubstrings_647 {
	public int countSubstrings(String s) {
		int ans = 0;

		for (int i = 0; i < s.length(); ++i) {
			ans += extendPalindromes(s, i, i);
			ans += extendPalindromes(s, i, i + 1);
		}

		return ans;
	}

	private int extendPalindromes(final String s, int l, int r) {
		int count = 0;

		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			++count;
			--l;
			++r;
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		NumberofPalindromicSubstrings_647 np = new NumberofPalindromicSubstrings_647();
		String s = "tacocat";
		System.out.println(np.countSubstrings(s));
	}
}
