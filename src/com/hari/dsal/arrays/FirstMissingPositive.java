package com.hari.dsal.arrays;

import java.util.Arrays;

public class FirstMissingPositive {

	public static void main(String[] args) {
		int[] A = { 3, 4, -1, 1 };
		FirstMissingPositive fmp = new FirstMissingPositive();

		System.out.println(fmp.firstMissingPositive(A));
		System.out.println(fmp.firstMissingPositive1(A));
	}

	public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}

		Arrays.sort(A);
		int result = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= 0) {
				continue;
			}

			if (A[i] - result > 1) {
				return result + 1;
			} else {
				result = A[i];
			}
		}
		return A[A.length - 1] + 1;
	}

	public int firstMissingPositive1(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}
		int n = A.length;
		int i = 0;
		while (i < n) {
			if (A[i] != i + 1 && A[i] >= 1 && A[i] <= n && A[i] != A[A[i] - 1]) {
				swap(A, i, A[i] - 1);
			} else {
				i++;
			}
		}

		for (i = 0; i < n; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}

		return A[n - 1] + 1;
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
