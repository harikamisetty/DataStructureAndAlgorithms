package com.hari.dsal.Google;

public class PlusOne_66 {
	public int[] plusOne(int[] digits) {
		if (null == digits)
			return digits;
		int n = digits.length;

		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int[] new_arr = new int[n + 1];
		new_arr[0] = 1;
		return new_arr;

	}
}
