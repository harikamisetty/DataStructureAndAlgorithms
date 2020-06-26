package com.hari.dsal.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoArrays {

	private static int[] merge(int a[], int b[]) {

		Arrays.sort(a);
		Arrays.sort(b);

		if (a.length == 0 && b.length == 0)
			throw null;

		if (a.length == 0)
			return b;
		if (b.length == 0)
			return a;

		int c[] = new int[a.length + b.length];
		int j = 0, i = 0, k = 0;

		while (i < a.length && j < b.length) {
			if (a[i] == 0) {
				i++;
				k++;
				System.out.println("Zero");
			} else {
				c[k] = a[i];
				i++;
				k++;
			}
			if (b[j] == 0) {
				j++;
				k++;
			} else {
				c[k] = b[j];
				j++;
				k++;
			}
		}
		while (i < a.length) {
			if (a[i] == 0) {
				System.out.println("Zero");i++;k++;
			} else {
				c[k] = a[i];
				i++;
				k++;
			}
		}

		while (j < b.length) {
			if (b[j] == 0) {
				j++;k++;
			} else {
				c[k] = b[j];
				j++;
				k++;
			}
		}
		
		for (int val : c) {
			System.out.print(val);
		}
		
		return c;
	}

	private static boolean merge_2(int a[], int b[]) {

		List temp = new ArrayList(Arrays.asList(a));
		return temp.addAll(temp);
		// Display the list

	}

	public static void main(String[] args) {
		int a[] = { 0, 0, 1, 1, 2, 4 };
		int b[] = { 2, 3, 6, 7, 8, 9 };

		int res[] = merge(a, b);
		Arrays.sort(res);

		for (int val : res) {
			System.out.print(val);
		}

	}
}
