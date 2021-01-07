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
		// When all 9's in an Array
		int[] new_arr = new int[n + 1];
		new_arr[0] = 1;
		return new_arr;

	}
	
	public static void main(String[] args) {
		PlusOne_66 po = new PlusOne_66();
		int[] a = {9,9,9,9};
		
		for(int val : po.plusOne(a)) {
			System.out.print(val+",");
		}
	}
}
