package com.hari.dsal.bit;

public class SingleNumber {
	
	public static int singleNumber(int[] A) {
		int x = 0;
		for (int a : A) {
		x = x ^ a;
		}
		return x;
		}
	
	public static void main(String[] args) {
		int a[] = {1,2,3,4,2};
		System.out.println(singleNumber(a));
	}

}
