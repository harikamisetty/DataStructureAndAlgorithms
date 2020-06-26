package com.hari.dsal.arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 1, 2,2,3, 5 };
		
		for (int i = 0; i < a.length; i++) {
			if (i > 0 && a[i] == a[i - 1])
				continue;
			System.out.print(a[i]+ " ");
		}
	}
}
