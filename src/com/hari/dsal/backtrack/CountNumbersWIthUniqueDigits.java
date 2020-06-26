package com.hari.dsal.backtrack;

public class CountNumbersWIthUniqueDigits {
	/*
	 * f(1) = 10
	 * f(2) = 9*9 =81
	 * f(3) = f(2) *8
	 * f(4) = f(3) *7
	 */
	private int getUniqueDigitCount(int n) {
		if(n ==0)
			return 1;

		int res  =10;
		int uniqueDigits = 9;
		int availableNumber = 9;

		while (n-- > 1 && availableNumber > 0) {
			uniqueDigits = uniqueDigits * availableNumber;
			res += uniqueDigits;
			availableNumber--;
		}
		return res;
	}

	public static void main(String[] args) {
		int n =2; // Count number of unique numbers between 0<= n <= 10 power n.
		CountNumbersWIthUniqueDigits cnud = new CountNumbersWIthUniqueDigits();
		System.out.println(cnud.getUniqueDigitCount(n));
	}
}
