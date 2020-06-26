package com.hari.dsal.number;

public class NimGame {
	
	public static void main(String[] args) {
		System.out.println(canWinNim(20));
	}
	public static boolean canWinNim(int n) {
	    return n%4>0;
	}

}
