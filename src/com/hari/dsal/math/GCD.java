package com.hari.dsal.math;

public class GCD {
	public int gcd(int i, int j) {
		if (i == 0)
			return j;
		return gcd(j % i, i);
	}

	public static void main(String[] args) {
		GCD gcd = new GCD();
		System.out.println(gcd.gcd(15, 50));
	}
}
