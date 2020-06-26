package com.hari.dsal.bit;

public class PowerOfTwo {

	public static void main(String[] args) {
		showPowerOfTwo(10);
		System.out.println(isPowerOfTwo(7));
	}

	private static void showPowerOfTwo(int num) {

		for (int i = 0; i < num; i++) {
			int a = 1<<i;
			System.out.println(a + " and binary is :" + Integer.toBinaryString(a));
		}
	}

	public static boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		while (n > 2) {
			System.out.println("n = "+ n);
			int t = n >> 1;
			System.out.println("t = "+ t);
			int c = t << 1;
			System.out.println("c = " + c);
			if (n - c != 0)
				return false;
			n = n >> 1;
		}
		return true;
	}

	public boolean isPowerOfTwo1(int n) {
		return n > 0 && (n & n - 1) == 0;
	}

	public boolean isPowerOfTwo2(int n) {
		return n > 0 && n == Math.pow(2, Math.round(Math.log(n) / Math.log(2)));
	}
}
