package com.hari.dsal.arrays;

import java.util.Arrays;


/*You are given a list of integers nums where each integer occurs exactly three times 
except for one which occurs once. Return the lone integer. */

public class LoneNumber {

	private int getLoneNumber() {
		int a[] = { 2, 2, 2, 9, 9,9, 11, };

		Arrays.parallelSort(a);

		for (int i = 0; i < a.length - 3; i = i + 3) {
			if (a[i] != a[i + 2]) {
				return a[i];
			}
		}
		return a[a.length - 1];
	}

	public static void main(String[] args) {

		LoneNumber ln = new LoneNumber();
		System.out.println(ln.getLoneNumber());

	}
}
