package com.hari.dsal.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LettersToPhoneNumbers {

	public ArrayList<String> letterCombinations2(String digits) {
        ArrayList<String> result = new ArrayList<String>();

        if (digits == null) return result;

        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        StringBuilder sb = new StringBuilder();
        letterCombinationsHelper(result,sb,digits, 0, dict);

        return result;
    }

    private void letterCombinationsHelper(ArrayList<String> result,StringBuilder temp,String digits, int start, String[] dict) {
        if (start >= digits.length()) {
            result.add(temp.toString());
            return;
        }

        // char to int
        int num = digits.charAt(start) - '0';
        for (int i = 0; i < dict[num].length(); i++) {
            temp.append(dict[num].charAt(i));
            letterCombinationsHelper(result,temp,digits, start + 1, dict);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
	public static void main(String[] args) {
		LettersToPhoneNumbers lop = new LettersToPhoneNumbers();
		List<String> phnumber = lop.letterCombinations2("42");
		for(String number : phnumber) {
			System.out.print(number+" ");
		}
	}

}
