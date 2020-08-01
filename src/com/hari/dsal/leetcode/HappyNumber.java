package com.hari.dsal.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		HappyNumber hn = new HappyNumber();
		// System.out.println(hn.isHappyNumber(14));
		System.out.println(hn.isHappy(2));
	}

	private int getSum(int n) {
		int sum = 0;

		while (n > 0) {
			sum = sum + (n % 10) * (n % 10);
			n = n / 10;
		}
		return sum;
	}

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();

		while (!set.contains(n)) {
			set.add(n);
			n = getSum(n);

			if (n == 1)
				return true;
		}
		return false;
	}

	private boolean isHappyNumber(int num) {
		int result = 0;

		while (result != 1 && num != 0) {
			result += Math.pow(num % 10, 2);
			num = num / 10;
			if (num == 0) {
				if (result == 1)
					return true;
				num = result;
				result = 0;
			}

		}
		return false;
	}
}
