package com.hari.dsal.number;

public class PowerOfThree {

	public static boolean isPowerOfThree(int n) {
		if (n == 1)
			return true;
		boolean result = false;
		while (n > 0) {
			int m = n % 3;
			if (m == 0) {
				n = n / 3;
				if (n == 1)
					return true;
			} else {
				return false;
			}
		}
		return result;
	}

	public static boolean isPowerOfThree1(int n) {
		if (n == 0)
			return false;
		if (n == 1)
			return true;
		if (n > 1)
			return n % 3 == 0 && isPowerOfThree(n / 3);
		else
			return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(15));
		System.out.println(1%3);
	}
}
