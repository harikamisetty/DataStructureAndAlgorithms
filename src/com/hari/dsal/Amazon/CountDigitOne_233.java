package com.hari.dsal.Amazon;

public class CountDigitOne_233 {
	public int countDigitOne(int n) {
		if (n == 0)
			return 0;

		long base = 1;
		int sum = 0;

		while (base <= n) {
			int cur = (int) (n / base % 10);
			int left = (int) (n / base / 10);
			int right = (int) (n % base);

			if (cur > 1) {
				sum += (left + 1) * base;
			} else if (cur == 1) {
				sum += (left) * base;
				sum += (right + 1);
			} else {
				sum += left * base;
			}

			base *= 10;
		}

		return sum;
	}
	
	public static void main(String[] args) {
		CountDigitOne_233 cdo = new CountDigitOne_233();
		System.out.println(cdo.countDigitOne(20));
	}
}
