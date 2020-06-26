package com.hari.dsal.leetcode;

public class MonotonicArray {

	public static boolean isMonotonic(int[] A) {

		if (A.length <= 1)
			return true;

		boolean increase = false;
		boolean decrease = false;

		int k = 0;
		for (int j = 1; j < A.length; j++) {

			if (A[j] != A[j - 1]) {
				k = j;
				if (A[j] > A[j - 1])
					increase = true;
				if (A[j] < A[j - 1])
					decrease = true;
				break;
			}
		}

		for (int i = k + 1; i < A.length; i++) {

			if (increase && i < A.length && A[i - 1] > A[i]) {
				return false;
			}

			if (decrease && i < A.length && A[i - 1] < A[i]) {
				return false;
			}

		}

		return true;
	}

	public static void main(String[] args) {
		int A[] = { 6, 5, 4, 4 };
		System.out.println(isMonotonic(A));
	}

}
