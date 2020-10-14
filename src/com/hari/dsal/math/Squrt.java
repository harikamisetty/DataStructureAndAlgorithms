package com.hari.dsal.math;

public class Squrt {

	public int mySqrt(int x) {
		if (x == 0 || x == 1)
			return x;
		int l = 0, r = x;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (x / mid == mid)
				return mid;
			else if (x / mid < mid) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return r;
	}

	public static void main(String[] args) {
		Squrt s = new Squrt();
		System.out.println(s.mySqrt(9));
	}

}
