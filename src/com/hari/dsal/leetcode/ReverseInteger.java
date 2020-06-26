package com.hari.dsal.leetcode;

public class ReverseInteger {
	
	public static void main(String[] args) {
		
		int a= 123;
		int res = 0;
		
		while(a != 0) {
			
			int num = a%10;
			a = a/10;
			// Formula
			res = res * 10 + num;
		}
		System.out.println(res);
	}
}
