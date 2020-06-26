package com.hari.dsal.strings;

public class IntegerToEnglishWords {

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}

		String[] group = { "", "Thousand ", "Million ", "Billion " };
		String[] dict1 = { "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
				"Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
				"Nineteen " };
		String[] dict2 = { "", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ",
				"Ninety " };

		StringBuffer sb = new StringBuffer();
		// Group Length is 4
		for (int i = 0; i < 4; i++) {
			int curr = num % 1000;
			if (curr > 0) {
				if (i > 0) {
					sb.insert(0, group[i]);
				}
				sb.insert(0, numToWordsHelper(curr, dict1, dict2));
			}
			num /= 1000;
		}

		String result = sb.toString();
		if (result.charAt(result.length() - 1) == ' ') {
			return result.substring(0, result.length() - 1);
		} else {
			return result;
		}
	}

	private String numToWordsHelper(int num, String[] dict1, String[] dict2) {
		StringBuffer result = new StringBuffer();

		int a = num / 100;
		int b = num % 100;
		int c = num % 10;

		if (a > 0) {
			result.append(dict1[a] + "Hundred ");
		}

		if (b > 0 && b < 20) {
			result.append(dict1[b]);
			c = 0;
		} else if (b >= 20) {
			b /= 10;
			result.append(dict2[b]);
		}

		if (c > 0) {
			result.append(dict1[c]);
		}

		return result.toString();
	}
	
	public static void main(String[] args) {
		IntegerToEnglishWords itoe = new IntegerToEnglishWords();
		System.out.println(itoe.numberToWords(12345));
		
	}
}