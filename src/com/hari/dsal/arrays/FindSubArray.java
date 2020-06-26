package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindSubArray {

	private static List<Integer> getSubArrayList(int[] A, int target) {
		int sum = 0;
		List<Integer> results = new ArrayList<Integer>();

		for (int i = 0; i < A.length; i++) {
			sum = A[i];
			if (sum == target) {
				results.add(sum);
				return results;
			}

			for (int j = i + 1; j < A.length; j++) {

				sum = sum + A[j];
				if (sum == target) {
					for (int k = i; k < j + 1; k++) {
						results.add(A[k]);
					}
					return results;
				}

				if (sum > target) {
					break;
				}
			}
		}
		return results;
	}
	
	public static void main(String[] args) {

		int A[] = { 1, 2, 3, 4, 5 };
		List<Integer> results = getSubArrayList(A, 9);

		for (int val : results)
			System.out.print(val + ", ");
	}	
}
