package com.hari.dsal.number;

public class ReverseInteger {

	public static void main(String[] args) {

		int a= -123;
		int res = 0;

		while(a != 0) {

			int num = a%10;
			a = a/10;
			// Formula
			res = res * 10 + num;
		}
		System.out.println(res);

		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(1542659895));
	}

	 public int reverse(int x) {
		 if (x < 10 && x > -10) return x;
	        long result = 0;

	        while (x !=0) {
	            result = result * 10 + x % 10;
	            x = x / 10;
	        }

	        // handle the overflow issue
	        if (result > Integer.MAX_VALUE) return 0;
	        if (result < Integer.MIN_VALUE) return 0;

	        return (int) result;
	    }
}
