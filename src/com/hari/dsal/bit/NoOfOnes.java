package com.hari.dsal.bit;

public class NoOfOnes {
	
	public static void main(String[] args) {
		
		System.out.println(noOfOnes(7));
		System.out.println(1<<0);
		System.out.println(1<<1);
		System.out.println(1<<2);
		System.out.println(1<<3);
		
		for(int k=0; k <= 7; k++) {
			System.out.print(noOfOnes(k)+ "--");
		}
		
		System.out.println(7&8-1);
	} 

	private static int noOfOnes(int i) {
		
		int count =0;
		for(int j = 0; j <= i; j++) {
			if((i & (1<<j)) !=0) { // Move Bit one after other and do the &.
				count++;
			}
		}
		return count;
	}
	
	/*
	 *  7 - 111  & 1<<001  
	 * 
	 * 
	 */
}
