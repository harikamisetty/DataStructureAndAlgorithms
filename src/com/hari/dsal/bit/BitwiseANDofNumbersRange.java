package com.hari.dsal.bit;

public class BitwiseANDofNumbersRange {

	public static void main(String[] args) {
		BitwiseANDofNumbersRange ba = new BitwiseANDofNumbersRange();
		System.out.println(ba.getNumberRange(5, 7));
	}

	private int getNumberRange(int m, int n) {

		while (n > m) {
			n = n & n - 1;
			System.out.println(n);
		}
		return m & n;
	}
}
