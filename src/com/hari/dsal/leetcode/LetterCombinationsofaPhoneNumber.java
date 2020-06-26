package com.hari.dsal.leetcode;

import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber {

	/*
	 * http://buttercola.blogspot.com/search?q=Letter+Combinations+of+a+Phone+Number
	 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
	 * "ce", "cf"].
	 */

	public static ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();

		if (digits == null)
			return result;

		String[] dict = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		StringBuilder sb = new StringBuilder();
		letterCombinationsHelper(digits, 0, sb, dict, result);

		return result;
	}

	private static void letterCombinationsHelper(String digits, int start, StringBuilder temp, String[] dict,
			ArrayList<String> result) {
		if (start >= digits.length()) {
			result.add(temp.toString());
			return;
		}

		// char to int
		int num = digits.charAt(start) - '0';
		for (int i = 0; i < dict[num].length(); i++) {
			temp.append(dict[num].charAt(i));
			letterCombinationsHelper(digits, start + 1, temp, dict, result);
			temp.deleteCharAt(temp.length() - 1);
		}
	}

	public static void main(String[] args) {
		
		ArrayList<String> results = letterCombinations("235");
		results.forEach(result -> {
			System.out.print(result+" ");
		});
	}

}
