package com.hari.dsal.math;

public class CountPrime {

	public int countPrimes(int n) {

		if (n <= 2)
			return 0;
		boolean[] isNotPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!isNotPrime[i]) {
				count++;
				for (int k = 2; k * i < n; k++) {
					isNotPrime[k * i] = true;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		CountPrime cp = new CountPrime();
		System.out.println(cp.countPrimes(10));
	}

}
