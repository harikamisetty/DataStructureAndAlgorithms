package com.hari.dsal.matrix;

import java.util.Arrays;
import java.util.TreeSet;

public class MaxSumofRectangleNoLargerThanK_363 {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int m = matrix.length;
		int n = matrix[0].length;

		int ans = Integer.MIN_VALUE;

		for (int col = 0; col < n; col++) {
			int sum[] = new int[m];

			for (int j = col; j < n; j++) {
				for (int i = 0; i < m; i++) {
					sum[i] = sum[i] + matrix[i][j];
				}

				TreeSet<Integer> accumulate = new TreeSet<>(Arrays.asList(0));

				int prefix = 0;

				for (int val : sum) {
					prefix = prefix + val;
					Integer lo = accumulate.ceiling(prefix - k);
					if (lo != null)
						ans = Math.max(ans, prefix - lo);
					accumulate.add(prefix);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		MaxSumofRectangleNoLargerThanK_363 mrl = new MaxSumofRectangleNoLargerThanK_363();
		int[][] matrix = { 
				{ 1, 0, 1 }, 
				{ 0, -2, 3 } 
				};
		int k = 2;

		System.out.println(mrl.maxSumSubmatrix(matrix, k));
	}
}
