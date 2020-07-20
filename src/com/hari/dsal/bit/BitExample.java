package com.hari.dsal.bit;

public class BitExample {
	
	public static void main(String[] args) {
		
		System.out.println(getLeftBit(16, 2));
		System.out.println(getLogicalLeftBit(16,2));
		System.out.println(getBit(16,2));
		System.out.println(12 & 20);
		System.out.println(12 & -20);
		System.out.println(-12 & -20);
		System.out.println(5<<1);
		System.out.println(5>>3);
		System.out.println(1<<3);
		System.out.println(2^3);
		System.out.println(1<<1);
		System.out.println(7&1);
		System.out.println(7&7);
		System.out.println(7|7);
		System.out.println(7^7);
		System.out.println(7>>>1);
		System.out.println(6&6-1);
		System.out.println(6&6|5);
	}
	
	public static int getLeftBit(int num, int count) {
		
		for(int i=0; i < count; i++) {
			
			System.out.println(num >> i);
		}
		return 0;
	}
	
	public static int getLogicalLeftBit(int num, int count) {
		
		for(int i=0; i < count; i++) {
			System.out.println(num >>> i);
		}
		return 0;
		
	}
	
	public static boolean getBit(int num, int i) {
		
		return ((num & (1 << i)) != 1);
	}
}
