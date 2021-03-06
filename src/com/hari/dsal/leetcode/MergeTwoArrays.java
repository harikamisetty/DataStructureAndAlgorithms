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
				System.out.println("Zero");
				i++;
				k++;
			} else {
				c[k] = a[i];
				i++;
				k++;
			}
		}

		while (j < b.length) {
			if (b[j] == 0) {
				j++;
				k++;
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

	public static int[] solve1(int[] a, int[] b) {
		int m = 0;
		int n = 0, i = 0;
		int[] res = new int[a.length + b.length];

		while (m < a.length && n < b.length) {
			if (a[m] < b[n]) {
				res[i++] = a[m++];
			} else if (b[n] < a[m]) {
				res[i++] = b[n++];
			} else {
				res[i++] = a[m++];
				res[i++] = b[n++];
			}
		}

		if (m < a.length) {
			while (m < a.length)
				res[i++] = a[m++];
		}

		if (n < b.length) {
			while (n < b.length)
				res[i++] = b[n++];
		}

		return res;
	}

	// BEST SOLUTION
	public int[] solve(int[] lst0, int[] lst1) {
		int i = 0;
		int j = 0;
		int[] retArr = new int[lst0.length + lst1.length];
		
		while (i < lst0.length || j < lst1.length) {
			
			if (i == lst0.length) {
				retArr[i + j] = lst1[j++];
			} else if (j == lst1.length) {
				retArr[i + j] = lst0[i++];
			} else if (lst0[i] > lst1[j]) {
				retArr[i + j] = lst1[j++];
			} else {
				retArr[i + j] = lst0[i++];
			}			
		}
		
		return retArr;
	}

	public static void main(String[] args) {
		int a[] = { 0 };
		int b[] = { 1, 1 };

		int res[] = solve1(a, b);
		Arrays.sort(res);

		for (int val : res) {
			System.out.print(val);
		}

	}
}
