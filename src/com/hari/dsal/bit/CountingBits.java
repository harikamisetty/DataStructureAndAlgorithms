package com.hari.dsal.bit;

public class CountingBits {

	public static int[] countBits(int num) {
		if (num < 0) {
			return new int[0];
		}

		int[] result = new int[num + 1];

		for (int i = 1; i <= num; i++) {
			if ((i & 1) == 0) {
				result[i] = result[i / 2];
			} else {
				result[i] = result[i - 1] + 1;
			}
		}

		return result;
	}

	public static int[] countBits1(int num) { // Too good
		
		int[] dp = new int[num + 1];

		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i & (i - 1)] + 1;
		}

		return dp;
	}
	
	public static void main(String[] args) {
		int [] results = new int[7];
		
		results = countBits(7);
		for (int i=1; i<= 7; i++) {
			System.out.println(results[i]);
		}
		
	}
}
