package com.hari.dsal.strings;

public class CountBinarySubstrings_696 {
	public int countBinarySubstrings(String s) {
		int ans = 0, prev = 0, cur = 1;

		for (int i = 1; i < s.length(); i++) {

			if (s.charAt(i - 1) != s.charAt(i)) {

				ans += Math.min(prev, cur);
				prev = cur;
				cur = 1;
			} else {
				cur++;
			}
		}
		return ans + Math.min(prev, cur);
	}

	// SOLUTION #2
	public int countBinarySubstrings_2(String s) {
		int result = 0;
		int arr[] = new int[2];
		int digit = Character.getNumericValue(s.charAt(0));
		arr[digit]++;

		int primary = digit;
		int secondary = reverseDigit(digit);

		for (int i = 1; i < s.length(); i++) {
			int dig = Character.getNumericValue(s.charAt(i));
			arr[dig]++;

			if (primary != dig) {
				primary = dig;
				secondary = reverseDigit(dig);
				arr[primary] = 1;
			}

			if (primary == dig && arr[secondary] >= arr[primary]) {
				result++;
			}
		}
		return result;
	}

	public int reverseDigit(int n) {
		if (n == 0)
			return 1;
		else
			return 0;
	}

	public static void main(String[] args) {
		CountBinarySubstrings_696 cbs = new CountBinarySubstrings_696();
		System.out.println(cbs.countBinarySubstrings("00110011"));
	}
}
