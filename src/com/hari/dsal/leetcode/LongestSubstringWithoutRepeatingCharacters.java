package com.hari.dsal.leetcode;

/*
 * Explanation
We use two pointers technique to solve the problem. One slow pointer i, one fast pointer j.

We also add a HashSet to store the characters which have been visited by j pointer to help detect repeating characters.

We keep moving j pointer right further.

If current s.charAt(j) character is not in the HashSet, we add the character to the HashSet and keep moving j further.
If current s.charAt(j) character is in the HashSet, we remove the character i is visiting and move i forward. 
At this point, we found the maximum size of substrings without duplicate characters start with index i. We move i pointer one step further.

When j pointer iterates all the characters of the string, we get the max length of the longest substring without repeating characters.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	
	//SOlution #1 Eg: abcbcdef
	public static int lengthOfLongestSubstringSolution1(String s) {
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
	
	// Solution #2
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++)
				if (allUnique(s, i, j))
					ans = Math.max(ans, j - i);
		return ans;
	}

	public static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch))
				return false;
			set.add(ch);
		}
		return true;
	}

	public static void main(String[] args) {

		String s = "ababcd";
		System.out.println(lengthOfLongestSubstring(s));
		System.out.println(lengthOfLongestSubstringSolution1("abcbcdef"));
	}
}
