package com.hari.dsal.implementations;

public class UtoplanTreeGrow {
	public static void main(String[] args) {
		int t =3;
		int[] h = {0,1,4};
		
		for(int a =0; a<t; a++) {
			int n = h[a];
			int length =1;
			for(int i=1; i<=n;i++) {
				if(i % 2 ==0)
					length++;
				else
					length*=2;
			}
			System.out.println(length);
		}
	}
}
