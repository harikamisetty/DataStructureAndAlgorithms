package com.hari.dsal.number;

public class FibonacciNumber {

	public static void printFibonacciNumber(int n) {

		int a[] = new int[20];
		a[0] = 0;
		a[1] = 1;

		for (int i = 2; i < n; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}

		for (int l = 0; l < n; l++) {
			System.out.println(a[l]);
		}
	}

	public static int fibonacciNumber(int n, int[] a) {
		int res = 0;
		if (n >= 0) {

			res = fibonacciNumber(n - 1, a) + fibonacciNumber(n - 2, a);
		}
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		// printFibonacciNumber(10);
		fibonacciNumber(10, null);
	}

}
