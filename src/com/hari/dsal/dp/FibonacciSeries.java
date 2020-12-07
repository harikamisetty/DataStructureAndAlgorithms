package com.hari.dsal.dp;

import java.util.HashMap;
import java.util.Map;

public class FibonacciSeries {
	Map<Integer, Integer> hm = new HashMap<>();

	// BOTTOM UP
	public int febSeries(int n) {
		hm.put(0, 0);
		hm.put(1, 1);

		for (int i = 2; i <= n; i++) {
			hm.put(i, hm.get(i - 1) + hm.get(i - 2));
		}

		return hm.get(n);
	}

	// TOP DOWN
	public int getFibonacciNumberTopDown(int n) {
		if (hm.containsKey(n))
			return hm.get(n);
		else {
			if (n == 0)
				return 0;
			if (n == 1)
				return 1;
			int nthValue = getFibonacciNumberTopDown(n - 1) + getFibonacciNumberTopDown(n - 2);
			hm.put(n, nthValue);
			return nthValue;
		}
	}

	public static void main(String[] args) {
		FibonacciSeries fb = new FibonacciSeries();
		System.out.println(fb.febSeries(8));
		System.out.println(fb.getFibonacciNumberTopDown(8));
	}
}
