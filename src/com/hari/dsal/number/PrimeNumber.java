package com.hari.dsal.number;

public class PrimeNumber {

	static boolean isPrime(int n) {
		// Corner case
		if (n <= 1)
			return false;
		// Check from 2 to n-1
		for (int i = 2; i < n; i++) // Prime number means it will be divide by only with 1 and itself. 
			if (n % i == 0)
				return false;
		return true;
	}
	
	static void printPrimeNumbers(int m) {

		StringBuffer sb = new StringBuffer();

		for (int i = 2; i < m; i++) {
			int number = i, j = 2;
			boolean isPrime = true;
			while (j < i) {

				if (number % j == 0) {
					isPrime = false;
				}
				j++;
			}
			if (isPrime)
				sb.append(i + " ,");
		}
		System.out.println("Prime Numbers are ......" + sb.toString());
	}
	
	public static void main(String[] args) {
		System.out.println(isPrime(11));
		
		printPrimeNumbers(20);
	}
}
